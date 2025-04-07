package models;

public class Car {
    int id;
    private String name;
    private int year;
    private String type;
    private int priceOfDay;
    private String color;

    public Car() {
    }

    public Car(int id,String name, int year, String type, int priceOfDay, String color) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.type = type;
        this.priceOfDay = priceOfDay;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPriceOfDay() {
        return priceOfDay;
    }

    public void setPriceOfDay(int priceOfDay) {
        this.priceOfDay = priceOfDay;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", type='" + type + '\'' +
                ", priceOfDay=" + priceOfDay +
                ", color='" + color + '\'' +
                '}';
    }
}
