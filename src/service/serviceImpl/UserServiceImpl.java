package service.serviceImpl;
import models.Car;
import models.Management;
import models.User;
import service.UserService;

import java.util.Scanner;

public class UserServiceImpl implements UserService {


    @Override
    public String pay(int id,Management management, User user) {
        Scanner scanner = new Scanner(System.in);
        int index = -1;
        for (int i = 0; i < management.getCars().length; i++) {
            if (management.getCars()[i].getId() == id){
                index = i;
            }
        }

        if (index == -1){
            System.out.println("Car is not founded");
            return "";
        }
        if (user.getBalance() >= management.getCars()[index].getPriceOfDay()) {
            user.setBalance(user.getBalance() - management.getCars()[index].getPriceOfDay());
            System.out.println("You successfully pay! \nYour balance- "+user.getBalance());
            System.out.println("You successfully booking the car!");
            return "success";
        } else {
            System.out.println("Error! You need else- '"+ (management.getCars()[index].getPriceOfDay()- user.getBalance()) + "' som");
            System.out.println("""
                    Select the next action: 
                    1. Deposit
                    2. Exit
                    """);
            int userChoice;
            try {
                userChoice = scanner.nextInt();
            } catch (RuntimeException e) {
                throw new RuntimeException("Incorrect choice bro, "+e);
            }
            if (userChoice == 1) {
                return "deposit";
            } else if (userChoice == 2) {
                return "exit";
            }
        }
        return "";
    }

    @Override
    public String deposit(User user, Management management) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write name: ");
        String userName = scanner.nextLine();
        System.out.println("Write password:");
        String userPassword = (scanner.nextLine());
        if (management.getUsers() != null) {
            for (User managementUser : management.getUsers()) {
                if (managementUser.getName() != null && managementUser.getPassword() != null) {
                    if (managementUser.getName().equals(userName) && managementUser.getPassword().equals(userPassword)) {
                        System.out.println("Write how much money you want to get?");
                        user.addBalance(scanner.nextInt());
                        System.out.println("Successful operation!");
                        return "success";
                    }
                }
            }
        }
        return "nullBro";
    }
}
