package application;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServiceImp implements Service {
    static Connection conn;
    static {
        String url="jdbc:mysql://localhost:3306/carrented";
        String uname="root";
        String pass= "tiger";
        try {
            conn= DriverManager.getConnection(url,uname,pass);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    @Override
    public List<Vechal> showAvalV() {
        List<Vechal> ve= new ArrayList<>();
        String q= "select * from available_cars";
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()){
                Vechal v= new Vechal(rs.getString(1),rs.getString(2),rs.getString(3));
                ve.add(v);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return  ve;
    }

    @Override
    public int rentCar(String number , String name , String email,String prof) {
        int n=0;
        String deletc= "select * from available_cars where car_num=?";
        String notavl="UPDATE available_cars SET available = false WHERE car_num = ?";
        String insertc= "INSERT INTO rented_cars (car_num, model, rented_by_name, rented_by_email, rented_by_id_proof, rental_date) " +
                "VALUES (?, ?, ?, ?, ?, now())";
        PreparedStatement pstm1= null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3= null;
        try {
            pstmt3=conn.prepareStatement(notavl);
            pstmt3.setString(1,number);
            pstmt3.executeUpdate();
            pstm1 = conn.prepareStatement(deletc);
            pstm1.setString(1,number);
            ResultSet rs=pstm1.executeQuery();
            while (rs.next()){
                String carName = rs.getString(1);
                String cModel = rs.getString(2);
                pstmt2=conn.prepareStatement(insertc);
                pstmt2.setString(1,carName);
                pstmt2.setString(2,cModel);
                pstmt2.setString(3,name);
                pstmt2.setString(4,email);
                pstmt2.setString(5,prof);
//                pstmt2.setDate(6,Date.valueOf(LocalDate.now()));
               n= pstmt2.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    return  n;
    }

    @Override
    public int submitCar(String name, String carNumber) {
        int c=0;
        String cavl= "UPDATE available_cars SET available = true WHERE car_num = ?";
        String carT= "update rented_cars set return_date= now() where car_num=? and rented_by_name = ?";
        try {
            PreparedStatement pstmt1=conn.prepareStatement(cavl);
            PreparedStatement pstmt2=conn.prepareStatement(carT);
            pstmt1.setString(1,carNumber);
            pstmt2.setString(1,carNumber);
            pstmt2.setString(2,name);
            int n= pstmt1.executeUpdate();
           int e=  pstmt2.executeUpdate();
            c=e+n;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return c;
    }

    @Override
    public double priceCal(Timestamp rentalTimestamp, Timestamp returnTimestamp, double costPerMinute) {

            LocalDateTime rentalDateTime = rentalTimestamp.toLocalDateTime();
            LocalDateTime returnDateTime = returnTimestamp.toLocalDateTime();

            // Calculate the time difference in minutes
            long minutesDifference = Duration.between(rentalDateTime, returnDateTime).toMinutes();

            // Calculate the total price
            return minutesDifference * costPerMinute;

    }



    @Override
    public double getTimeSto(String name, String carNumber) {
        String q= "select rental_date,return_date from rented_cars where rented_by_name=? and car_num=?";
        String cost = "update rented_cars set cost_total=? where rented_by_name=? and car_num=?";
        try {
            PreparedStatement pstmt= conn.prepareStatement(q);
            pstmt.setString(1,name);
            pstmt.setString(2,carNumber);
            ResultSet rs= pstmt.executeQuery();
            while (rs.next()){
                Timestamp rantaldate = rs.getTimestamp(1);
                Timestamp returndate= rs.getTimestamp(2);
                double costff= priceCal(rantaldate,returndate,10);
                PreparedStatement pstmtC= conn.prepareStatement(cost);
                pstmtC.setDouble(1,costff);
                pstmtC.setString(2,name);
                pstmtC.setString(3,carNumber);
                pstmtC.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return 0;
    }

}
