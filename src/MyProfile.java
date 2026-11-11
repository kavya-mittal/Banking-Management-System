import javax.swing.*;
import java.awt.*;

public class MyProfile extends JFrame {

    MyProfile() {

        setTitle("Banking Management System - My Profile");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(235, 242, 250));

        JLabel title = new JLabel("MY PROFILE");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setBounds(220, 35, 250, 40);
        panel.add(title);

        JLabel admin = new JLabel("Admin Name:");
        admin.setFont(new Font("Arial", Font.BOLD, 16));
        admin.setBounds(100, 120, 150, 30);
        panel.add(admin);

        JLabel adminValue = new JLabel("Administrator");
        adminValue.setBounds(270, 120, 200, 30);
        panel.add(adminValue);

        JLabel username = new JLabel("Username:");
        username.setFont(new Font("Arial", Font.BOLD, 16));
        username.setBounds(100, 170, 150, 30);
        panel.add(username);

        JLabel usernameValue = new JLabel("admin");
        usernameValue.setBounds(270, 170, 200, 30);
        panel.add(usernameValue);

        JLabel role = new JLabel("Role:");
        role.setFont(new Font("Arial", Font.BOLD, 16));
        role.setBounds(100, 220, 150, 30);
        panel.add(role);

        JLabel roleValue = new JLabel("Bank Administrator");
        roleValue.setBounds(270, 220, 200, 30);
        panel.add(roleValue);

        JLabel bank = new JLabel("Bank System:");
        bank.setFont(new Font("Arial", Font.BOLD, 16));
        bank.setBounds(100, 270, 150, 30);
        panel.add(bank);

        JLabel bankValue = new JLabel("Banking Management System");
        bankValue.setBounds(270, 270, 250, 30);
        panel.add(bankValue);

        JButton back = new JButton("Back");
        back.setBounds(240, 350, 100, 35);
        panel.add(back);

        back.addActionListener(e -> {
            dispose();
            new AdminDashboard();
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyProfile();
    }
}