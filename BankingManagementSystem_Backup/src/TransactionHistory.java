import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TransactionHistory extends JFrame {

    TransactionHistory() {

        setTitle("Banking Management System - Transaction History");
        setSize(900, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel header = new JPanel();
        header.setBackground(new Color(30, 60, 100));

        JLabel title = new JLabel("TRANSACTION HISTORY");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 26));

        header.add(title);
        add(header, BorderLayout.NORTH);

        String[] columns = {
                "Transaction ID",
                "Account No.",
                "Type",
                "Amount",
                "Date"
        };

        DefaultTableModel model =
                new DefaultTableModel(columns, 0);

        model.addRow(new Object[]{
                "TXN001", "10000001",
                "Deposit", "₹ 10,000", "03-09-2026"
        });

        model.addRow(new Object[]{
                "TXN002", "10000002",
                "Withdrawal", "₹ 5,000", "03-09-2026"
        });

        model.addRow(new Object[]{
                "TXN003", "10000003",
                "Deposit", "₹ 15,000", "02-09-2026"
        });

        JTable table = new JTable(model);
        table.setRowHeight(30);

        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton back = new JButton("Back");

        back.addActionListener(e -> {
            dispose();
            new AdminDashboard();
        });

        JPanel bottom = new JPanel();
        bottom.add(back);

        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TransactionHistory();
    }
}