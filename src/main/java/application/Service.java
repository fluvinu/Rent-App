package application;

import java.sql.Timestamp;
import java.util.List;

public interface Service {

    List<Vechal> showAvalV();

    int rentCar(String number ,String name , String emal,String prof);

    int submitCar(String name, String carNumber);

    double priceCal(Timestamp rentalTimestamp, Timestamp returnTimestamp, double costPerMinute);



    double getTimeSto(String name, String carNumber);
}
