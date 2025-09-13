package serviceBillingApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GarageSystem {
    // these are the customer list of garage
    private Map<String, Customer> customerList;

    // these are the services which the garage provide
    private List<Service> listOfServices;

    Scanner sc = new Scanner(System.in);
    private Invoice newInvoice;

    GarageSystem() {
        customerList = new HashMap<>();
        listOfServices = new ArrayList<>();
        addServices();
    }

    void addServices() {
        listOfServices.add(new Service("car wash", 500));
        listOfServices.add(new Service("punture", 200));
        listOfServices.add(new Service("regular service", 1000));
        listOfServices.add(new Service("painting", 1500));
        listOfServices.add(new Service("headlight repair", 400));
    }

    void addCustomer(String carModel, String name, String phone) {
        Car carOfCustomer = new Car(carModel);
        Customer newCustomer = new Customer(name, phone, carOfCustomer);
        newInvoice = new Invoice(newCustomer);

        customerList.put(carModel, newCustomer);
    }

    boolean flag = false;

    void selectServices(String carModel) {

        if (!customerList.containsKey(carModel)) {
            System.out.println("Invalid Customer");
            System.out.println("Register the Customer first");
            System.out.println(" ");
            return;
        }

        while (true) {

            System.out.println("------------- select services ------------");

            for (int i = 0; i < listOfServices.size(); i++) {
                System.out.println(i + 1 + ". " + listOfServices.get(i).getServiceName() + " - "
                        + listOfServices.get(i).getPrice());
            }

            System.out.println("press 0 to exit");
            System.out.println("enter service number to take service");

            int enteredInput = sc.nextInt();

            if (enteredInput == 0) {
                break;
            } else if (enteredInput < 1 || enteredInput > listOfServices.size()) {
                System.out.println("invalid input");
                continue;
            } else {
                flag = true;
                newInvoice.addService(listOfServices.get(enteredInput - 1));
            }

        }

        if (flag) {
            newInvoice.printInvoice();
        }

    }
}
