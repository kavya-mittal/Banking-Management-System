import javax.swing.*;
import java.awt.*;

public class DeleteCustomer extends JFrame {

    JTextField searchField;

    DeleteCustomer() {

        setTitle("Banking Management System - Delete Customer");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(235, 242, 250));

        JLabel title = new JLabel("DELETE CUSTOMER");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBounds(180, 40, 300, 40);
        panel.add(title);

        JLabel label = new JLabel("Customer ID / Account No.:");
        label.setBounds(80, 130, 200, 30);
        panel.add(label);

        searchField = new JTextField();
        searchField.setBounds(280, 130, 220, 30);
        panel.add(searchField);

        JButton delete = new JButton("Delete");
        delete.setBounds(180, 210, 110, 35);
        panel.add(delete);

        JButton back = new JButton("Back");
        back.setBounds(310, 210, 100, 35);
        panel.add(back);

        delete.addActionListener(e -> deleteCustomer());

        back.addActionListener(e -> {
            dispose();
            new AdminDashboard();
        });

        add(panel);
        setVisible(true);
    }

    void deleteCustomer() {

        String id = searchField.getText().trim();

        Customer customer = CustomerData.findCustomer(id);

        if (customer == null) {

            JOptionPane.showMessageDialog(this,
                    "Customer not found!");

            return;
        }

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Delete customer " + customer.name + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {

            CustomerData.customers.remove(customer);

            JOptionPane.showMessageDialog(this,
                    "Customer Deleted Successfully!");

            searchField.setText("");
        }
    }

    public static void main(String[] args) {
        new DeleteCustomer();
    }
}