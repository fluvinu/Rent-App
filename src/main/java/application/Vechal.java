package application;

public class Vechal {
    private String name;
    private String number;
    private  String carModel;
    private boolean available;

    public Vechal(String name, String number,String carModel) {
        this.name = name;
        this.number = number;
        this.available = available;
        this.carModel= carModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
