package application;

import java.util.Scanner;

public class MainApp {
    private static Scanner sc= new Scanner(System.in);
    private static Service ser= new ServiceImp();
    public static void main(String[] args) {
        System.out.println("select option");
        System.out.println("1 rent a vechel");
        System.out.println("2 subbit vechel");
        System.out.println("3 exit");
        int ch= sc.nextInt();
        switch (ch){
            case 1:
                rentCar();
                break;
            case 2:
                submitCar();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("invalid input");

        }
        main(args);
    }
    public static void rentCar(){
        for(Vechal ve:ser.showAvalV()){
            System.out.println(ve.getName()+" "+ve.getNumber()+" "+ve.isAvailable());
        }
        System.out.println("enter car number");
        String number= sc.next();
        System.out.println("enter your name ");
        String name = sc.next();
        System.out.println("entert email");
        String email = sc.next();
        System.out.println("enetrr id poof ");
        String idProf = sc.next();
        int n = ser.rentCar(number,name,email,idProf);
        System.out.println(n+" row updated ");
    }

    public static  void submitCar(){
        System.out.println("enter your name ");
        String name = sc.next();
        System.out.println("enter car number ");
        String carNumber= sc.next();
        int n = ser.submitCar(name,carNumber);
        System.out.println(n+" row updted");
        double cost = ser.getTimeSto(name ,carNumber);
        System.out.println("total cost is "+cost);

    }
}
