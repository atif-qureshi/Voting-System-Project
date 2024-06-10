import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Candidate {
    public Candidate(Person person) {
        //Constitution Frame:
        JFrame constitution_frame = new JFrame("Constitution Holder");
        //Frame Icone:
        ImageIcon icon = new ImageIcon("D:\\Java\\Voting System Remaking\\Images/constitution.png  ");
        Image image_icon = icon.getImage();
        constitution_frame.setIconImage(image_icon);
        //Background Image:
        ImageIcon image = new ImageIcon("D:\\Java\\Voting System Remaking\\Images/form.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setSize(image.getIconWidth(), image.getIconHeight());
        constitution_frame.setContentPane(imageLabel);
        // Heading Label
        JLabel heading = new JLabel("Constitution");
        heading.setBounds(185, 25, 300, 75);
        heading.setFont(new Font("Imprint MT Shadow", Font.BOLD, 45));
        heading.setForeground(new Color(34, 39, 115));
        // Constitution Field
        JTextField constitutionField = new JTextField();
        constitutionField.setBounds(255, 170, 140, 35);
        constitutionField.setText(person.constitution);
        constitutionField.setHorizontalAlignment(JTextField.CENTER);
        constitutionField.setFont(new Font("Imprint MT Shadow", Font.BOLD, 22));
        constitutionField.setEditable(false);
        //Next Button:
        JButton centerButton = new JButton("Next");
        centerButton.setBounds(265, 300, 120, 39);
        centerButton.setForeground(new Color(2, 3, 18));
        centerButton.setBackground(new Color(84, 94, 97, 255));
        centerButton.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 24));
        //Next Button Action Listner:
        centerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String constitution = constitutionField.getText();

                try (var connection = DB.connect()) {
                    var candidate_data = DB.Candidate(connection, constitution);
                    if (candidate_data == null) {
                        JOptionPane.showMessageDialog(constitution_frame, "No data Found");
                    } else {
                        new Candidate_Detail(person, candidate_data);
                        constitution_frame.dispose();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        //Image Labels:
        imageLabel.add(heading);
        imageLabel.add(constitutionField);
        imageLabel.add(centerButton);

        //Frame properties:
        constitution_frame.setVisible(true);
        constitution_frame.setLayout(null);
        constitution_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        constitution_frame.setSize(650, 450);
        constitution_frame.setLocationRelativeTo(null);
    }
}