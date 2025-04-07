package models;
import java.util.Arrays;

public class Management {
    private User[] users = new User[3];
    private Car[] cars = new Car[9];
    private Driver[] drivers;

    public Management() {
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public Driver[] getDrivers() {
        return drivers;
    }

    public void setDrivers(Driver[] drivers) {
        this.drivers = drivers;
    }

    int userCount = 0;
    public void addUser(User user){
        if (userCount < users.length){
            users[userCount++] = user;
        } else {
            System.out.println("Not space for new users!");
        }
    }



}
