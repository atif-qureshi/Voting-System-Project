import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Detail {
    public Login_Detail(Person person) {
        //Login_Detail Frame:
        JFrame login_detail = new JFrame("Voter Detail");
        //Login_Detail Icone:
        ImageIcon icon = new ImageIcon("D:\\Java\\Voting System Remaking\\Images/detail_login.png  ");
        Image image_icon = icon.getImage();
        login_detail.setIconImage(image_icon);
        //Background:
        ImageIcon image = new ImageIcon("D:\\Java\\Voting System Remaking\\Images/form.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setSize(635, 415);
        login_detail.add(imageLabel);
        //Heading:
        JLabel heading = new JLabel("Voter Detail's");
        heading.setBounds(190, 15, 300, 75);
        heading.setFont(new Font("Imprint MT Shadow", Font.BOLD, 45));
        heading.setForeground(new Color(34, 39, 115));
        //Detail TextArea:
        JTextArea detail_area = new JTextArea();
        detail_area.setBounds(140, 100, 350, 220);
        detail_area.setForeground(Color.BLACK);
        detail_area.setBackground(Color.cyan);
        detail_area.setEditable(false);
        Font largerFont_5 = new Font(detail_area.getFont().getName(), Font.BOLD, 22);
        detail_area.setFont(largerFont_5);
        detail_area.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        detail_area.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
        //Detail Printing:
        String details = String.format(
                " ID: %d\n Name: %s\n CNIC: %s\n City: %s\n Area: %s\n Place: %s\n Constitution: %s",
                person.id, person.name, person.cnic, person.city, person.area, person.place, person.constitution
        );
        detail_area.setText(details);
        detail_area.setCaretPosition(0);
        JScrollPane scrollPane = new JScrollPane(detail_area);
        scrollPane.setBounds(140, 100, 350, 220);
        //Next Button:
        JButton next_button = new JButton("Next");
        next_button.setBounds(265, 350, 100, 35);
        next_button.setForeground(new Color(2, 3, 18));
        next_button.setBackground(new Color(84, 94, 97, 255));
        next_button.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 20));
        //Button Action Listner:
        next_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Candidate(person);
                login_detail.dispose();
            }
        });
        //Image Label:
        imageLabel.add(heading);
        imageLabel.add(detail_area);
        imageLabel.add(next_button);
        //Frame properties:
        login_detail.setSize(650, 450);
        login_detail.setLayout(null);
        login_detail.setVisible(true);
        login_detail.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login_detail.setLocationRelativeTo(null);
        login_detail.setResizable(false);
    }
}
