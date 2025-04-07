package service.serviceImpl;
import models.Management;
import models.User;
import service.ManagementService;
import java.util.Scanner;

public class ManagementServiceImpl implements ManagementService {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String register(Management management) {
        User user = new User();
        try {
            System.out.println("Write name:");
            user.setName(scanner.nextLine());
            System.out.println("Write password:");
            user.setPassword(scanner.nextLine());
            System.out.println("Write address:");
            user.setAddress(scanner.nextLine());
            String userPhoneNumber;
            while (true) {
                System.out.println("Write phone number:");
                userPhoneNumber = scanner.nextLine();
                if (userPhoneNumber.matches("\\+996\\d{9}")) {
                    break;
                } else {
                    System.out.println("Incorrect phone number format, try again!");
                }
            }
            user.setPhoneNumber(userPhoneNumber);

        } catch (Exception e) {
            throw new RuntimeException("error ",e);
        }
        management.addUser(user);
        return "Success!";
    }

    @Override
    public String login(Management management) {
        boolean isUserWasInDataBase = false;
        while (true) {
            System.out.println("Write name:");
            String userName = scanner.nextLine();
            System.out.println("Write password:");
            String userPassword = (scanner.nextLine());

            for (User user : management.getUsers()) {
                if (user != null) {
                    if (userName.equals(user.getName()) && userPassword.equals(user.getPassword())) {
                        return "Welcome";
                    } else {
                        System.out.println("Incorrect name or password, try again!");
                        break;
                    }
                } else {
                    isUserWasInDataBase = true;
                    break;
                }
            }
            if (isUserWasInDataBase) {
                System.out.println("Do 'Sign up' please!");
                break;
            }
        }
        return "";
    }
}
