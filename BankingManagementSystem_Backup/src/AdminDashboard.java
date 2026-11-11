import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame implements ActionListener {

    JButton addCustomer;
    JButton viewCustomer;
    JButton updateCustomer;
    JButton deleteCustomer;
    JButton searchCustomer;
    JButton viewTransactions;
    JButton profile;
    JButton changePassword;
    JButton logout;

    JLabel customerCount;
    JLabel accountCount;
    JLabel depositAmount;
    JLabel withdrawAmount;

    public AdminDashboard() {

        setTitle("Banking Management System - Admin Dashboard");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1100, 750);

        setLocationRelativeTo(null);

        setResizable(false);

        getContentPane().setBackground(
                new Color(235, 243, 252)
        );

        setLayout(null);


        // =========================================
        // HEADER
        // =========================================

        JPanel header = new JPanel();
        header.setBounds(0, 0, 1100, 95);
        header.setBackground(Color.WHITE);
        header.setLayout(null);
        add(header);


        JLabel title = new JLabel(
                "BANKING MANAGEMENT SYSTEM"
        );

        title.setBounds(250, 15, 600, 40);

        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        title.setForeground(
                new Color(0, 82, 170)
        );

        header.add(title);


        JLabel welcome = new JLabel(
                "ADMIN DASHBOARD"
        );

        welcome.setBounds(350, 55, 400, 25);

        welcome.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        welcome.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        17
                )
        );

        welcome.setForeground(
                new Color(70, 70, 70)
        );

        header.add(welcome);


        // =========================================
        // STATISTICS TITLE
        // =========================================

        JLabel statisticsTitle =
                new JLabel("DASHBOARD OVERVIEW");

        statisticsTitle.setBounds(
                50, 115, 400, 30
        );

        statisticsTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        21
                )
        );

        statisticsTitle.setForeground(
                new Color(0, 70, 160)
        );

        add(statisticsTitle);

        // Customers
        JPanel customerCard =
                createCard(
                        50,
                        155,
                        220,
                        100,
                        "TOTAL CUSTOMERS",
                        "125",
                        new Color(0, 102, 204)
                );

        add(customerCard);


        // Accounts
        JPanel accountCard =
                createCard(
                        295,
                        155,
                        220,
                        100,
                        "TOTAL ACCOUNTS",
                        "150",
                        new Color(0, 153, 76)
                );

        add(accountCard);


        // Deposits
        JPanel depositCard =
                createCard(
                        540,
                        155,
                        220,
                        100,
                        "TOTAL DEPOSITS",
                        "₹ 5,20,000",
                        new Color(255, 153, 0)
                );

        add(depositCard);


        // Withdrawals
        JPanel withdrawCard =
                createCard(
                        785,
                        155,
                        220,
                        100,
                        "WITHDRAWALS",
                        "₹ 2,10,000",
                        new Color(220, 50, 50)
                );

        add(withdrawCard);


        // =========================================
        // CUSTOMER MANAGEMENT
        // =========================================

        JLabel customerTitle =
                new JLabel("CUSTOMER MANAGEMENT");

        customerTitle.setBounds(
                50, 285, 400, 30
        );

        customerTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        21
                )
        );

        customerTitle.setForeground(
                new Color(0, 70, 160)
        );

        add(customerTitle);


        // Customer Panel
        JPanel customerPanel =
                new JPanel();

        customerPanel.setBounds(
                50, 325, 955, 130
        );

        customerPanel.setBackground(
                Color.WHITE
        );

        customerPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(200, 210, 220),
                        1
                )
        );

        customerPanel.setLayout(null);

        add(customerPanel);


        // Add Customer
        addCustomer =
                createButton(
                        "Add Customer",
                        30,
                        25,
                        new Color(0, 153, 76)
                );

        customerPanel.add(addCustomer);


        // View Customers
        viewCustomer =
                createButton(
                        "View Customers",
                        260,
                        25,
                        new Color(0, 102, 204)
                );

        customerPanel.add(viewCustomer);


        // Update Customer
        updateCustomer =
                createButton(
                        "Update Customer",
                        490,
                        25,
                        new Color(255, 153, 0)
                );

        customerPanel.add(updateCustomer);


        // Delete Customer
        deleteCustomer =
                createButton(
                        "Delete Customer",
                        720,
                        25,
                        new Color(220, 50, 50)
                );

        customerPanel.add(deleteCustomer);


        // Search Customer
        searchCustomer =
                createButton(
                        "Search Customer",
                        375,
                        80,
                        new Color(80, 90, 100)
                );

        customerPanel.add(searchCustomer);


        // =========================================
        // RECENT TRANSACTIONS
        // =========================================

        JLabel transactionTitle =
                new JLabel("RECENT TRANSACTIONS");

        transactionTitle.setBounds(
                50, 480, 400, 30
        );

        transactionTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        21
                )
        );

        transactionTitle.setForeground(
                new Color(0, 70, 160)
        );

        add(transactionTitle);


        viewTransactions =
                createButton(
                        "View Transactions",
                        750,
                        475,
                        new Color(80, 90, 100)
                );

        add(viewTransactions);


        // =========================================
        // TRANSACTION TABLE
        // =========================================

        String[] columns = {
                "Account No.",
                "Customer",
                "Type",
                "Amount",
                "Date"
        };


        Object[][] data = {

                {"10001", "Rahul Sharma",
                        "Deposit", "₹ 5,000", "03/09/2026"},

                {"10002", "Priya Singh",
                        "Withdraw", "₹ 2,000", "03/09/2026"},

                {"10003", "Aman Verma",
                        "Deposit", "₹ 8,000", "02/09/2026"}

        };


        JTable table =
                new JTable(data, columns);

        table.setRowHeight(28);

        table.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );


        table.getTableHeader()
                .setFont(
                        new Font(
                                "Arial",
                                Font.BOLD,
                                14
                        )
                );


        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setBounds(
                50, 515, 955, 100
        );

        add(scrollPane);


        // =========================================
        // BOTTOM BUTTONS
        // =========================================

        profile =
                createButton(
                        "My Profile",
                        50,
                        635,
                        new Color(0, 102, 204)
                );

        add(profile);


        changePassword =
                createButton(
                        "Change Password",
                        220,
                        635,
                        new Color(100, 70, 160)
                );

        add(changePassword);


        logout =
                createButton(
                        "Logout",
                        830,
                        635,
                        new Color(200, 0, 0)
                );

        add(logout);


        // =========================================
        // FOOTER
        // =========================================

        JLabel footer =
                new JLabel(
                        "Developed By : Kavya Mittal | PIET | © 2026",
                        SwingConstants.CENTER
                );

        footer.setBounds(
                350, 680, 400, 25
        );

        footer.setFont(
                new Font(
                        "Arial",
                        Font.ITALIC,
                        14
                )
        );

        footer.setForeground(
                new Color(90, 90, 90)
        );

        add(footer);


        // =========================================
        // ACTION LISTENERS
        // =========================================

        addCustomer.addActionListener(this);
        viewCustomer.addActionListener(this);
        updateCustomer.addActionListener(this);
        deleteCustomer.addActionListener(this);
        searchCustomer.addActionListener(this);
        viewTransactions.addActionListener(this);
        profile.addActionListener(this);
        changePassword.addActionListener(this);
        logout.addActionListener(this);


        setVisible(true);
    }


    // =============================================
    // CREATE STATISTICS CARD
    // =============================================

    private JPanel createCard(
            int x,
            int y,
            int width,
            int height,
            String heading,
            String value,
            Color color
    ) {

        JPanel card = new JPanel();

        card.setBounds(
                x,
                y,
                width,
                height
        );

        card.setBackground(Color.WHITE);

        card.setBorder(
                BorderFactory.createLineBorder(
                        color,
                        2
                )
        );

        card.setLayout(null);


        JLabel headingLabel =
                new JLabel(heading);

        headingLabel.setBounds(
                10, 10, width - 20, 25
        );

        headingLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        headingLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        headingLabel.setForeground(color);

        card.add(headingLabel);


        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setBounds(
                10, 40, width - 20, 40
        );

        valueLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        valueLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        23
                )
        );

        valueLabel.setForeground(
                new Color(50, 50, 50)
        );

        card.add(valueLabel);


        return card;
    }


    // =============================================
    // CREATE BUTTON
    // =============================================

    private JButton createButton(
            String text,
            int x,
            int y,
            Color color
    ) {

        JButton button =
                new JButton(text);

        button.setBounds(
                x,
                y,
                205,
                42
        );

        button.setBackground(color);

        button.setForeground(Color.WHITE);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }


    // =============================================
    // ACTIONS
    // =============================================

    @Override
    public void actionPerformed(
            ActionEvent e
    ) {

        // ADD CUSTOMER
        if (e.getSource() == addCustomer) {
            dispose();
            new AddCustomer();
        }

        // VIEW CUSTOMER
        else if (e.getSource() == viewCustomer) {

            dispose();
            new ViewCustomers();
        }


        // UPDATE CUSTOMER
        else if (e.getSource() == updateCustomer) {

            dispose();
            new UpdateCustomer();
        }


        // DELETE CUSTOMER
        else if (e.getSource() == deleteCustomer) {

            dispose();
            new DeleteCustomer();
        }


        // SEARCH CUSTOMER
        else if (e.getSource() == searchCustomer) {

            String account =
                    JOptionPane.showInputDialog(
                            this,
                            "Enter Account Number:",
                            "Search Customer",
                            JOptionPane.QUESTION_MESSAGE
                    );

            if (account != null && !account.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Searching Account: " + account
                );
            }
        }


        // TRANSACTIONS
        else if (e.getSource() == viewTransactions) {

            dispose();
            new TransactionHistory();
        }


        // PROFILE
        else if (e.getSource() == profile) {

            JOptionPane.showMessageDialog(
                    this,
                    "Admin Profile\n\n" +
                            "Name: Kavya Mittal\n" +
                            "Role: Administrator\n" +
                            "Institute: PIET",
                    "My Profile",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }


        // CHANGE PASSWORD
        else if (e.getSource() == changePassword) {

            JOptionPane.showMessageDialog(
                    this,
                    "Change Password Module"
            );
        }


        // LOGOUT
        else if (e.getSource() == logout) {

            int choice =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Do you want to logout?",
                            "Logout",
                            JOptionPane.YES_NO_OPTION
                    );


            if (
                    choice ==
                            JOptionPane.YES_OPTION
            ) {

                dispose();

                new AdminPanel();
            }
        }
    }


    // =============================================
    // MAIN
    // =============================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new AdminDashboard()
        );
    }
}