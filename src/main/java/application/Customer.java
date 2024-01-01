package application;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private  String carNum;
    private  String model;

    private String Carname;
    private String number;
    private  String carModel;
    private boolean available;

    public Customer(String customerId, String name, String email, String carNum, String model) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.carNum = carNum;
        this.model = model;
    }

    public Customer(String carname, String number, String carModel, boolean available) {
        Carname = carname;
        this.number = number;
        this.carModel = carModel;
        this.available = available;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarname() {
        return Carname;
    }

    public void setCarname(String carname) {
        Carname = carname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}


