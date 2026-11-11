import java.util.ArrayList;

public class CustomerData {

    public static ArrayList<Customer> customers =
            new ArrayList<>();

    public static Customer findCustomer(String id) {

        for (Customer c : customers) {

            if (c.customerId.equalsIgnoreCase(id)
                    || c.accountNumber.equals(id)) {

                return c;
            }
        }

        return null;
    }
}