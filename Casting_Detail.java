import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Casting_Detail {
    public Casting_Detail(String name, String cnic, String party, String member, String constitution) {
        JFrame frame = new JFrame("Candidate detail");
        //Icone:
        ImageIcon icon = new ImageIcon("D:\\Java\\Voting System Remaking\\Images/candidate.png  ");
        Image image_icon = icon.getImage();
        frame.setIconImage(image_icon);
        //================================
        //Image:
        ImageIcon image = new ImageIcon("D:\\Java\\Voting System\\Images/form.png");
        //Image Label:
        JLabel imageLabel = new JLabel(image);
        imageLabel.setSize(635, 415);
        frame.add(imageLabel);
        // Heading Label
        JLabel heading = new JLabel("Casting Detail's");
        heading.setBounds(148, 18, 400, 75);
        heading.setFont(new Font("Imprint MT Shadow", Font.BOLD, 45));
        heading.setForeground(new Color(34, 39, 115));

        // Detail Label and TextField
        JTextArea detail_area = new JTextArea();
        detail_area.setBounds(140, 120, 350, 170);
        detail_area.setForeground(Color.BLACK);
        detail_area.setBackground(Color.WHITE);
        detail_area.setEditable(false);
        Font largerFont_5 = new Font(detail_area.getFont().getName(), Font.BOLD, 20);
        detail_area.setFont(largerFont_5);
        detail_area.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        detail_area.setAlignmentY(JTextArea.CENTER_ALIGNMENT);

        String details = String.format(
                " Name: %s\n CNIC: %s\n Party: %s\n Member: %s\n Constitution: %s",
                name, cnic, party, member, constitution
        );
        detail_area.setText(details);
        detail_area.setCaretPosition(0);
        JScrollPane scrollPane = new JScrollPane(detail_area);
        scrollPane.setBounds(140, 100, 350, 220);

        // Logout Button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(265, 340, 100, 35);
        logoutButton.setForeground(new Color(2, 3, 18));
        logoutButton.setBackground(new Color(84, 94, 97, 255));
        logoutButton.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 20));

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();
                frame.dispose();
            }
        });

        // Adding components to the frame
        imageLabel.add(heading);
        imageLabel.add(detail_area);
        imageLabel.add(logoutButton);

        // Setting frame properties
        frame.setLayout(null);
        frame.setSize(650, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
