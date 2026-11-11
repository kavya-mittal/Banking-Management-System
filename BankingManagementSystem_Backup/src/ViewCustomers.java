import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewCustomers extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewCustomers() {

        setTitle("Banking Management System - View Customers");
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel header = new JPanel();
        header.setBackground(new Color(30, 60, 100));

        JLabel title = new JLabel("CUSTOMER LIST");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 28));

        header.add(title);
        add(header, BorderLayout.NORTH);

        String[] columns = {
                "Customer ID", "Account No.", "Name",
                "Father Name", "Mobile", "Email",
                "Account Type", "Balance"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.PLAIN, 14));

        loadCustomers();

        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 15));

        back.addActionListener(e -> {
            dispose();
            new AdminDashboard();
        });

        JPanel bottom = new JPanel();
        bottom.add(back);

        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    void loadCustomers() {

        model.setRowCount(0);

        for (Customer c : CustomerData.customers) {

            model.addRow(new Object[]{
                    c.customerId,
                    c.accountNumber,
                    c.name,
                    c.fatherName,
                    c.mobile,
                    c.email,
                    c.accountType,
                    "₹ " + c.balance
            });
        }
    }

    public static void main(String[] args) {
        new ViewCustomers();
    }
}