import javax.swing.*;
import java.awt.*;

public class SearchCustomer extends JFrame {

    JTextField searchField;
    JTextArea resultArea;

    SearchCustomer() {

        setTitle("Banking Management System - Search Customer");
        setSize(650, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(235, 242, 250));

        JLabel title = new JLabel("SEARCH CUSTOMER");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBounds(190, 30, 300, 40);
        panel.add(title);

        JLabel label = new JLabel("Enter Name / ID / Account:");
        label.setBounds(60, 100, 200, 30);
        panel.add(label);

        searchField = new JTextField();
        searchField.setBounds(260, 100, 230, 30);
        panel.add(searchField);

        JButton search = new JButton("Search");
        search.setBounds(500, 100, 90, 30);
        panel.add(search);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 15));

        JScrollPane scroll = new JScrollPane(resultArea);
        scroll.setBounds(60, 160, 530, 220);
        panel.add(scroll);

        JButton back = new JButton("Back");
        back.setBounds(270, 400, 100, 35);
        panel.add(back);

        search.addActionListener(e -> searchCustomer());

        back.addActionListener(e -> {
            dispose();
            new AdminDashboard();
        });

        add(panel);
        setVisible(true);
    }

    void searchCustomer() {

        String text = searchField.getText().trim().toLowerCase();

        resultArea.setText("");

        for (Customer c : CustomerData.customers) {

            if (c.customerId.toLowerCase().contains(text)
                    || c.accountNumber.contains(text)
                    || c.name.toLowerCase().contains(text)) {

                resultArea.append(
                        "Customer ID : " + c.customerId + "\n" +
                                "Account No. : " + c.accountNumber + "\n" +
                                "Name        : " + c.name + "\n" +
                                "Father Name : " + c.fatherName + "\n" +
                                "Mobile      : " + c.mobile + "\n" +
                                "Email       : " + c.email + "\n" +
                                "Account Type: " + c.accountType + "\n" +
                                "Balance     : ₹ " + c.balance + "\n" +
                                "Address     : " + c.address + "\n" +
                                "-----------------------------\n"
                );
            }
        }

        if (resultArea.getText().isEmpty()) {
            resultArea.setText("No customer found.");
        }
    }

    public static void main(String[] args) {
        new SearchCustomer();
    }
}