import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class AdminPanel extends JFrame implements ActionListener {


    JTextField userField;
    JPasswordField passField;

    JButton loginBtn;
    JButton resetBtn;
    JButton exitBtn;

    public AdminPanel() {


        setTitle("Banking Management System - Admin Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Full Screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(235, 243, 252)
        );


        JPanel headerPanel =
                new JPanel(new BorderLayout());

        headerPanel.setBackground(Color.WHITE);

        headerPanel.setPreferredSize(
                new Dimension(0, 200)
        );


        // PIET LOGO
        ImageIcon originalIcon =
                new ImageIcon("src/poornima.png");

        JLabel logoLabel =
                new JLabel();

        logoLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        logoLabel.setVerticalAlignment(
                SwingConstants.CENTER
        );


        Image originalImage =
                originalIcon.getImage();

        int originalWidth =
                originalIcon.getIconWidth();

        int originalHeight =
                originalIcon.getIconHeight();


        if (originalWidth > 0 && originalHeight > 0) {

            int screenWidth =
                    Toolkit.getDefaultToolkit()
                            .getScreenSize().width;

            int maxWidth =
                    screenWidth - 40;

            int maxHeight = 190;


            double widthRatio =
                    (double) maxWidth / originalWidth;

            double heightRatio =
                    (double) maxHeight / originalHeight;

            double ratio =
                    Math.min(
                            widthRatio,
                            heightRatio
                    );


            int newWidth =
                    (int) (originalWidth * ratio);

            int newHeight =
                    (int) (originalHeight * ratio);


            Image resizedImage =
                    originalImage.getScaledInstance(
                            newWidth,
                            newHeight,
                            Image.SCALE_SMOOTH
                    );


            logoLabel.setIcon(
                    new ImageIcon(resizedImage)
            );
        }


        headerPanel.add(
                logoLabel,
                BorderLayout.CENTER
        );

        add(
                headerPanel,
                BorderLayout.NORTH
        );


        JPanel centerPanel =
                new JPanel(new GridBagLayout());

        centerPanel.setBackground(
                new Color(235, 243, 252)
        );


        JPanel loginCard =
                new JPanel(new GridBagLayout());

        loginCard.setBackground(Color.WHITE);

        loginCard.setPreferredSize(
                new Dimension(600, 400)
        );

        loginCard.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                new Color(200, 210, 220),
                                1
                        ),

                        BorderFactory.createEmptyBorder(
                                30,
                                50,
                                30,
                                50
                        )
                )
        );


        GridBagConstraints gbc =
                new GridBagConstraints();


        JLabel adminTitle =
                new JLabel("ADMIN LOGIN");

        adminTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        adminTitle.setForeground(
                new Color(0, 82, 170)
        );

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.gridwidth = 2;

        gbc.anchor =
                GridBagConstraints.CENTER;

        gbc.insets =
                new Insets(
                        10,
                        10,
                        35,
                        10
                );

        loginCard.add(
                adminTitle,
                gbc
        );



        JLabel userLabel =
                new JLabel("Username");

        userLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.gridwidth = 1;

        gbc.anchor =
                GridBagConstraints.LINE_END;

        gbc.insets =
                new Insets(
                        10,
                        10,
                        15,
                        20
                );

        loginCard.add(
                userLabel,
                gbc
        );


        userField =
                new JTextField();

        userField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        17
                )
        );

        userField.setPreferredSize(
                new Dimension(300, 42)
        );

        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.weightx = 1.0;

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.anchor =
                GridBagConstraints.CENTER;

        loginCard.add(
                userField,
                gbc
        );


        JLabel passLabel =
                new JLabel("Password");

        passLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0;

        gbc.fill =
                GridBagConstraints.NONE;

        gbc.anchor =
                GridBagConstraints.LINE_END;

        loginCard.add(
                passLabel,
                gbc
        );


        passField =
                new JPasswordField();

        passField.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        17
                )
        );

        passField.setPreferredSize(
                new Dimension(300, 42)
        );

        gbc.gridx = 1;
        gbc.gridy = 2;

        gbc.weightx = 1.0;

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.anchor =
                GridBagConstraints.CENTER;

        loginCard.add(
                passField,
                gbc
        );


        // =========================================
        // BUTTON PANEL
        // =========================================

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                20,
                                10
                        )
                );

        buttonPanel.setBackground(Color.WHITE);


        loginBtn =
                new JButton("Login");

        resetBtn =
                new JButton("Reset");

        exitBtn =
                new JButton("Exit");


        styleButton(
                loginBtn,
                new Color(0, 153, 76)
        );

        styleButton(
                resetBtn,
                new Color(255, 153, 0)
        );

        styleButton(
                exitBtn,
                new Color(220, 40, 40)
        );


        buttonPanel.add(loginBtn);
        buttonPanel.add(resetBtn);
        buttonPanel.add(exitBtn);


        gbc.gridx = 0;
        gbc.gridy = 3;

        gbc.gridwidth = 2;

        gbc.weightx = 0;

        gbc.fill =
                GridBagConstraints.NONE;

        gbc.anchor =
                GridBagConstraints.CENTER;

        gbc.insets =
                new Insets(
                        35,
                        10,
                        10,
                        10
                );

        loginCard.add(
                buttonPanel,
                gbc
        );


        centerPanel.add(loginCard);

        add(
                centerPanel,
                BorderLayout.CENTER
        );


        JPanel footerPanel =
                new JPanel(new BorderLayout());

        footerPanel.setBackground(
                new Color(235, 243, 252)
        );

        footerPanel.setPreferredSize(
                new Dimension(0, 60)
        );


        JLabel footer =
                new JLabel(
                        "Developed By : Kavya Mittal | © 2026 Banking Management System | PIET",
                        SwingConstants.CENTER
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


        footerPanel.add(
                footer,
                BorderLayout.CENTER
        );


        add(
                footerPanel,
                BorderLayout.SOUTH
        );

        loginBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        exitBtn.addActionListener(this);


        setVisible(true);
    }

    private void styleButton(
            JButton button,
            Color color
    ) {

        button.setPreferredSize(
                new Dimension(125, 45)
        );

        button.setBackground(color);

        button.setForeground(Color.WHITE);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );
    }

    @Override
    public void actionPerformed(
            ActionEvent e
    ) {

        // LOGIN
        if (e.getSource() == loginBtn) {

            String username =
                    userField.getText();

            String password =
                    String.valueOf(
                            passField.getPassword()
                    );


            if (
                    username.equals("admin")
                            &&
                            password.equals("1234")
            ) {

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!\nWelcome Admin.",
                        "Login Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

                dispose();

                new AdminDashboard();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Username or Password!",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }


        // RESET
        if (e.getSource() == resetBtn) {

            userField.setText("");

            passField.setText("");

            userField.requestFocus();
        }


        // EXIT
        if (e.getSource() == exitBtn) {

            int choice =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Do you really want to exit?",
                            "Exit",
                            JOptionPane.YES_NO_OPTION
                    );


            if (
                    choice ==
                            JOptionPane.YES_OPTION
            ) {

                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3307/src";
        String username = "root";
        String password = "Kavya@1435";
        try

        {
            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );
        }
        catch(SQLException e)
        {
            System.out.println();
        }
        String sql="insert into student(name,password)values(?,?)";




        SwingUtilities.invokeLater(
                () -> new AdminPanel()
        );
    }
}