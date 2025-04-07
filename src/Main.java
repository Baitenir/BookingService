import enums.Enum;
import models.Car;
import models.Management;
import models.User;
import service.ManagementService;
import service.UserService;
import service.serviceImpl.ManagementServiceImpl;
import service.serviceImpl.UserServiceImpl;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Management management = new Management();
        ManagementService managementService = new ManagementServiceImpl();
        User user = new User();
        UserService userService = new UserServiceImpl();
        Car car1 = new Car(1, "Toyota camry 70", 2017, "Sedan", 5000, "White");
        Car car2 = new Car(2, "KiA K5", 2001, "Sedan", 3000, "Black");
        Car car3 = new Car(3, "Subaru impreza", 2007, "Sedan", 3000, "Green");
        Car car4 = new Car(4, "Subaru Impreza", 2007, "Sedan", 3000, "Green");
        Car car5 = new Car(5, "Subaru Impreza", 2007, "Sedan", 3000, "Green");
        Car car6 = new Car(6, "Subaru Impreza", 2007, "Sedan", 3000, "Green");
        Car car7 = new Car(7, "Subaru Impreza", 2007, "Sedan", 10000, "Green");
        Car car8 = new Car(8, "Subaru Impreza", 2007, "Sedan", 3000, "Green");
        Car car9 = new Car(9, "Subaru Impreza", 2007, "Sedan", 3000, "Green");
        Car car10 = new Car(9, "Subaru Impreza", 2007, "Sedan", 3000, "Green");

        Car[] carsDB = new Car[]{car1,car2,car3,car4,car5,car6,car7,car8,car9,car10};
        management.setCars(carsDB);


//        System.out.println(Arrays.toString(management.getUsers()));
    String res;
    boolean isTrue = true;
        System.out.println("Welcome to booking service!");
        while (isTrue) {
            System.out.println("""
                    Select action:
                    1. Sign up
                    2. Sign in
                    """);
            int userChoice = -1;
            try {
                userChoice = scanner.nextInt();
            } catch (RuntimeException e) {
                System.out.println("Select (1 or 2) please!");
            }
            switch (userChoice) {
                case 1:
                    managementService.register(management);
                    break;
                case 2:
                    res = managementService.login(management);
                    if (res.equals("Welcome")){
                        System.out.println("Welcome!"+"\nYour balance: "+user.getBalance()+"\nYou can select next cars:");
                        isTrue = false;
                    }
                    break;
                default:
                    System.out.println("Incorrect value!");
            }
        }

        int count = 1;
        for (Car car : management.getCars()) {
            System.out.println(count++ +". "+car);
        }
        String nextPanel;
        String nextPanel2;

        while (true) {
            nextPanel = userService.pay(scanner.nextInt(), management, user);
            if (nextPanel.equals("deposit")) {
                nextPanel2 = userService.deposit(user,management);
                if (nextPanel2.equals("nullBro")){
                    System.out.println("Wrong name or password, try again!");
                }
            } else {
                return;
            }
        }
    }
}