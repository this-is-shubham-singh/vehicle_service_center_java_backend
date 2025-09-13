package serviceBillingApp;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private Customer customer;
    private List<Service> services;
    private double totalAmount;

    Invoice(Customer customer) {
        this.customer = customer;
        services = new ArrayList<>();
        totalAmount = 0;
    }

    public void addService(Service service) {
        services.add(service);
        totalAmount += service.getPrice();
    }

    public void addCustomer (Customer customer) {
        this.customer = customer;
    }

    public void printInvoice() {

        if(services.size() == 0) {
            System.out.println("add services first");
            return;
        }

        System.out.println("--------------- this is invoice ---------------");
        System.out.println("customer name" + customer.getName());
        System.out.println("car Model" + customer.getCar().getCarModel());

        for (int i = 0; i < services.size(); i++) {
            System.out.println(i + 1 + ". " + services.get(i).getServiceName() + " - " + services.get(i).getPrice());
        }

        System.out.println("total amount " + totalAmount);

    }
}
