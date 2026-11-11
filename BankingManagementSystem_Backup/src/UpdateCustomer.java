import javax.swing.*;
import java.awt.*;

public class UpdateCustomer extends JFrame {

    JTextField searchField, nameField, fatherField,
            mobileField, emailField, balanceField;

    JTextArea addressArea;

    JComboBox<String> accountType;

    Customer customer;

    UpdateCustomer() {

        setTitle("Banking Management System - Update Customer");
        setSize(700, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(null);
        main.setBackground(new Color(235, 242, 250));

        JLabel title = new JLabel("UPDATE CUSTOMER");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setBounds(220, 20, 300, 40);
        main.add(title);

        JLabel searchLabel = new JLabel("Customer ID / Account No.:");
        searchLabel.setBounds(50, 80, 180, 30);
        main.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(230, 80, 220, 30);
        main.add(searchField);

        JButton findButton = new JButton("Find");
        findButton.setBounds(470, 80, 80, 30);
        main.add(findButton);

        JLabel name = new JLabel("Full Name:");
        name.setBounds(50, 140, 150, 30);
        main.add(name);

        nameField = new JTextField();
        nameField.setBounds(220, 140, 330, 30);
        main.add(nameField);

        JLabel father = new JLabel("Father Name:");
        father.setBounds(50, 185, 150, 30);
        main.add(father);

        fatherField = new JTextField();
        fatherField.setBounds(220, 185, 330, 30);
        main.add(fatherField);

        JLabel mobile = new JLabel("Mobile:");
        mobile.setBounds(50, 230, 150, 30);
        main.add(mobile);

        mobileField = new JTextField();
        mobileField.setBounds(220, 230, 330, 30);
        main.add(mobileField);

        JLabel email = new JLabel("Email:");
        email.setBounds(50, 275, 150, 30);
        main.add(email);

        emailField = new JTextField();
        emailField.setBounds(220, 275, 330, 30);
        main.add(emailField);

        JLabel type = new JLabel("Account Type:");
        type.setBounds(50, 320, 150, 30);
        main.add(type);

        accountType = new JComboBox<>(new String[]{"Saving", "Current"});
        accountType.setBounds(220, 320, 330, 30);
        main.add(accountType);

        JLabel balance = new JLabel("Balance:");
        balance.setBounds(50, 365, 150, 30);
        main.add(balance);

        balanceField = new JTextField();
        balanceField.setBounds(220, 365, 330, 30);
        main.add(balanceField);

        JLabel address = new JLabel("Address:");
        address.setBounds(50, 410, 150, 30);
        main.add(address);

        addressArea = new JTextArea();
        addressArea.setBounds(220, 410, 330, 60);
        main.add(addressArea);

        JButton update = new JButton("Update");
        update.setBounds(220, 500, 120, 35);
        main.add(update);

        JButton back = new JButton("Back");
        back.setBounds(360, 500, 100, 35);
        main.add(back);

        findButton.addActionListener(e -> findCustomer());

        update.addActionListener(e -> updateCustomer());

        back.addActionListener(e -> {
            dispose();
            new AdminDashboard();
        });

        add(main);
        setVisible(true);
    }

    void findCustomer() {

        String id = searchField.getText().trim();

        customer = CustomerData.findCustomer(id);

        if (customer == null) {
            JOptionPane.showMessageDialog(this,
                    "Customer not found!");
            return;
        }

        nameField.setText(customer.name);
        fatherField.setText(customer.fatherName);
        mobileField.setText(customer.mobile);
        emailField.setText(customer.email);
        accountType.setSelectedItem(customer.accountType);
        balanceField.setText(String.valueOf(customer.balance));
        addressArea.setText(customer.address);
    }

    void updateCustomer() {

        if (customer == null) {
            JOptionPane.showMessageDialog(this,
                    "First find a customer!");
            return;
        }

        try {

            customer.name = nameField.getText();
            customer.fatherName = fatherField.getText();
            customer.mobile = mobileField.getText();
            customer.email = emailField.getText();
            customer.accountType =
                    accountType.getSelectedItem().toString();
            customer.balance =
                    Double.parseDouble(balanceField.getText());
            customer.address = addressArea.getText();

            JOptionPane.showMessageDialog(this,
                    "Customer Updated Successfully!");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this,
                    "Invalid balance!");
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer();
    }
}