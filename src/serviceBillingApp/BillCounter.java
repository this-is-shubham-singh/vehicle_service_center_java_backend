package serviceBillingApp;

import java.util.Scanner;

public class BillCounter {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("welcome to garage services");
        GarageSystem garageObject = new GarageSystem();

        while (true) {
            System.out.println("1" + " to add customer");
            System.out.println("2" + " to select services");

            int enteredInput = sc.nextInt();

            switch (enteredInput) {
                case 1: {

                    System.out.println("enter customer name ");
                    String name = sc.next();

                    System.out.println("enter customer phone number ");
                    String phone = sc.next();

                    System.out.println("enter car model ");
                    String carModel = sc.next();

                    garageObject.addCustomer(carModel, name, phone);

                    break;
                }
                case 2: {

                    System.out.println("enter car model");
                    String carModel = sc.next();
                    garageObject.selectServices(carModel);
                    break;
                }
                default:
                    System.out.println("invalid response, try again");
                    break;
            }
        }

    }

}
