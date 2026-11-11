public class Customer {

    String customerId;
    String accountNumber;
    String name;
    String fatherName;
    String mobile;
    String email;
    String accountType;
    double balance;
    String address;

    public Customer(String customerId, String accountNumber,
                    String name, String fatherName,
                    String mobile, String email,
                    String accountType, double balance,
                    String address) {

        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.name = name;
        this.fatherName = fatherName;
        this.mobile = mobile;
        this.email = email;
        this.accountType = accountType;
        this.balance = balance;
        this.address = address;
    }
}