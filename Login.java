import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login {
    public Login() {
        //Frame:
        JFrame login_frame = new JFrame("Login");
        //Login_Icon::
        ImageIcon login_icon = new ImageIcon("D:\\Java\\Voting System Remaking\\Images/login_icon.png  ");
        Image image_icon = login_icon.getImage();
        login_frame.setIconImage(image_icon);
        //Background Image:
        ImageIcon login_image = new ImageIcon("D:\\Java\\Voting System Remaking\\Images/form.png");
        JLabel imageLabel = new JLabel(login_image);
        imageLabel.setSize(700, 500);
        login_frame.add(imageLabel);
        //Logim Heading:
        JLabel login_title = new JLabel("Login");
        login_title.setBounds(260, 30, 180, 75);
        login_title.setForeground(new Color(34, 39, 115));
        login_title.setFont(new Font("Imprint MT Shadow", Font.BOLD, 50));
        //Name Label:
        JLabel name = new JLabel("Name");
        name.setBounds(170, 135, 90, 30);
        name.setForeground(new Color(34, 39, 115));
        // Create a custom font with larger size
        name.setFont(new Font("Imprint MT Shadow", Font.BOLD, 25));
        //Name TextField:
        JTextField name_field = new JTextField();
        name_field.setBounds(265, 140, 180, 28);
        name_field.setFont(new Font("San sarif", Font.BOLD, 18));
        //Cnic Label:
        JLabel cnic = new JLabel("CNIC");
        cnic.setBounds(170, 188, 90, 30);
        cnic.setForeground(new Color(34, 39, 115));
        cnic.setFont(new Font("Imprint MT Shadow", Font.BOLD, 25));
        //Cnic TextField:
        JTextField cnic_field = new JTextField();
        cnic_field.setBounds(265, 190, 180, 28);
        Font largerFont_5 = new Font(cnic_field.getFont().getName(), Font.BOLD, 18);
        cnic_field.setFont(largerFont_5);
        //Login Button:
        JButton login_button = new JButton("Login");
        login_button.setBounds(185, 268, 100, 32);
        login_button.setForeground(new Color(2, 3, 18));
        login_button.setBackground(new Color(120, 137, 143, 255));
        login_button.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 20));
        //Login_Button ActionListner:
        login_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name_field.getText();
                String cnic = cnic_field.getText();

                try (var connection = DB.connect()) {
                    var person = DB.login(connection, name, cnic);
                    if (person == null) {
                        JOptionPane.showMessageDialog(login_frame, "Invalid Login credentials.");
                    } else {
                        JOptionPane.showMessageDialog(login_frame, "Login Successful.");
                        new Login_Detail(person);
                        login_frame.setVisible(false);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        //CLear_Button:
        JButton clear_button = new JButton("Clear");
        clear_button.setBounds(340, 268, 110, 32);
        clear_button.setForeground(new Color(2, 3, 18));
        clear_button.setBackground(new Color(120, 137, 143, 255));
        clear_button.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 20));
        //Clear_Button Action Listner:
        clear_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name_field.setText("");
                cnic_field.setText("");
                JOptionPane.showMessageDialog(login_frame, "Data is cleared");
            }

        });
        //Image Label:
        imageLabel.add(login_title);
        imageLabel.add(name);
        imageLabel.add(name_field);
        imageLabel.add(cnic);
        imageLabel.add(cnic_field);
        imageLabel.add(login_button);
        imageLabel.add(clear_button);
        //Frame properties
        login_frame.setLayout(null);
        login_frame.setSize(642, 420);
        login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login_frame.setLocationRelativeTo(null);
        login_frame.setResizable(false);
        login_frame.setVisible(true);
    }
}
