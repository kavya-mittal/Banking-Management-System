import javax.swing.*;
import java.awt.*;

public class AddCustomer extends JFrame {

    JTextField nameField;
    JTextField fatherField;
    JTextField mobileField;
    JTextField emailField;
    JTextField balanceField;

    JTextArea addressArea;

    JComboBox<String> accountType;

    JLabel customerIdLabel;
    JLabel accountNumberLabel;

    JButton saveButton;
    JButton resetButton;
    JButton backButton;

    static int customerCounter = 1001;
    static int accountCounter = 10000001;

    AddCustomer() {

        setTitle("Banking Management System - Add Customer");

        setSize(900, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        // ================= HEADER =================

        JPanel header = new JPanel();

        header.setBackground(new Color(30, 60, 100));

        header.setBounds(0, 0, 900, 100);

        header.setLayout(null);

        JLabel title =
                new JLabel("BANKING MANAGEMENT SYSTEM");

        title.setForeground(Color.WHITE);

        title.setFont(
                new Font("Arial", Font.BOLD, 28)
        );

        title.setBounds(230, 20, 500, 35);

        header.add(title);

        JLabel subTitle =
                new JLabel("ADD CUSTOMER");

        subTitle.setForeground(Color.WHITE);

        subTitle.setFont(
                new Font("Arial", Font.PLAIN, 18)
        );

        subTitle.setBounds(370, 60, 200, 25);

        header.add(subTitle);

        add(header);

        // ================= CARD =================

        JPanel card = new JPanel();

        card.setBackground(Color.WHITE);

        card.setBounds(150, 125, 600, 450);

        card.setLayout(null);

        JLabel heading =
                new JLabel("Customer Information");

        heading.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        heading.setBounds(190, 15, 250, 35);

        card.add(heading);

        // Customer ID

        JLabel customerId =
                new JLabel("Customer ID:");

        customerId.setBounds(40, 70, 150, 30);

        card.add(customerId);

        customerIdLabel =
                new JLabel("CUST" + customerCounter);

        customerIdLabel.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        customerIdLabel.setBounds(
                200, 70, 250, 30
        );

        card.add(customerIdLabel);

        // Account Number

        JLabel account =
                new JLabel("Account Number:");

        account.setBounds(
                40, 110, 150, 30
        );

        card.add(account);

        accountNumberLabel =
                new JLabel(
                        String.valueOf(accountCounter)
                );

        accountNumberLabel.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        accountNumberLabel.setBounds(
                200, 110, 250, 30
        );

        card.add(accountNumberLabel);

        // Name

        JLabel name =
                new JLabel("Full Name:");

        name.setBounds(
                40, 150, 150, 30
        );

        card.add(name);

        nameField = new JTextField();

        nameField.setBounds(
                200, 150, 330, 30
        );

        card.add(nameField);

        // Father Name

        JLabel father =
                new JLabel("Father Name:");

        father.setBounds(
                40, 190, 150, 30
        );

        card.add(father);

        fatherField = new JTextField();

        fatherField.setBounds(
                200, 190, 330, 30
        );

        card.add(fatherField);

        // Mobile

        JLabel mobile =
                new JLabel("Mobile Number:");

        mobile.setBounds(
                40, 230, 150, 30
        );

        card.add(mobile);

        mobileField = new JTextField();

        mobileField.setBounds(
                200, 230, 330, 30
        );

        card.add(mobileField);

        // Email

        JLabel email =
                new JLabel("Email:");

        email.setBounds(
                40, 270, 150, 30
        );

        card.add(email);

        emailField = new JTextField();

        emailField.setBounds(
                200, 270, 330, 30
        );

        card.add(emailField);

        // Account Type

        JLabel type =
                new JLabel("Account Type:");

        type.setBounds(
                40, 310, 150, 30
        );

        card.add(type);

        accountType =
                new JComboBox<>(
                        new String[]{
                                "Saving",
                                "Current"
                        }
                );

        accountType.setBounds(
                200, 310, 330, 30
        );

        card.add(accountType);

        // Balance

        JLabel balance =
                new JLabel("Initial Balance:");

        balance.setBounds(
                40, 350, 150, 30
        );

        card.add(balance);

        balanceField = new JTextField();

        balanceField.setBounds(
                200, 350, 330, 30
        );

        card.add(balanceField);

        // Address

        JLabel address =
                new JLabel("Address:");

        address.setBounds(
                40, 390, 150, 30
        );

        card.add(address);

        addressArea = new JTextArea();

        addressArea.setLineWrap(true);

        addressArea.setWrapStyleWord(true);

        JScrollPane addressScroll =
                new JScrollPane(addressArea);

        addressScroll.setBounds(
                200, 390, 330, 55
        );

        card.add(addressScroll);

        add(card);

        // ================= BUTTONS =================

        saveButton =
                new JButton("Save Customer");

        saveButton.setBounds(
                230, 590, 150, 35
        );

        saveButton.setBackground(
                new Color(40, 140, 80)
        );

        saveButton.setForeground(Color.WHITE);

        saveButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        add(saveButton);

        resetButton =
                new JButton("Reset");

        resetButton.setBounds(
                395, 590, 100, 35
        );

        add(resetButton);

        backButton =
                new JButton("Back");

        backButton.setBounds(
                510, 590, 100, 35
        );

        add(backButton);

        // ================= ACTION LISTENERS =================

        saveButton.addActionListener(
                e -> saveCustomer()
        );

        resetButton.addActionListener(
                e -> resetFields()
        );

        backButton.addActionListener(e -> {

            dispose();

            new AdminDashboard();
        });

        setVisible(true);
    }

    // ================= SAVE =================

    void saveCustomer() {

        String name =
                nameField.getText().trim();

        String father =
                fatherField.getText().trim();

        String mobile =
                mobileField.getText().trim();

        String email =
                emailField.getText().trim();

        String balanceText =
                balanceField.getText().trim();

        String address =
                addressArea.getText().trim();

        // Empty check

        if (name.isEmpty()
                || father.isEmpty()
                || mobile.isEmpty()
                || email.isEmpty()
                || balanceText.isEmpty()
                || address.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields!"
            );

            return;
        }

        // Mobile check

        if (!mobile.matches("\\d{10}")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Mobile number must contain 10 digits!"
            );

            return;
        }

        // Email check

        if (!email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter a valid email address!"
            );

            return;
        }

        // Balance

        double amount;

        try {

            amount =
                    Double.parseDouble(balanceText);

            if (amount < 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Balance cannot be negative!"
                );

                return;
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter a valid balance!"
            );

            return;
        }

        // ================= CREATE CUSTOMER =================

        String customerId =
                "CUST" + customerCounter;

        String accountNumber =
                String.valueOf(accountCounter);

        Customer newCustomer =
                new Customer(
                        customerId,
                        accountNumber,
                        name,
                        father,
                        mobile,
                        email,
                        accountType
                                .getSelectedItem()
                                .toString(),
                        amount,
                        address
                );


        CustomerData.customers.add(newCustomer);

        // Increase counters

        customerCounter++;

        accountCounter++;

        // Success message

        JOptionPane.showMessageDialog(
                this,
                "Customer Added Successfully!\n\n"
                        + "Customer ID: "
                        + customerId
                        + "\nAccount Number: "
                        + accountNumber
        );

        // Update next ID

        customerIdLabel.setText(
                "CUST" + customerCounter
        );

        accountNumberLabel.setText(
                String.valueOf(accountCounter)
        );

        resetFields();
    }

    // ================= RESET =================

    void resetFields() {

        nameField.setText("");

        fatherField.setText("");

        mobileField.setText("");

        emailField.setText("");

        balanceField.setText("");

        addressArea.setText("");

        accountType.setSelectedIndex(0);
    }

    public static void main(String[] args) {

        new AddCustomer();
    }
}