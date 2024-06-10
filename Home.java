import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    public Home() {
        JFrame home = new JFrame();
        //Frame_Background:
        ImageIcon image = new ImageIcon("D:\\Java\\Voting System\\Images/1716893811296.jpeg");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setSize(627, 415);
        home.add(imageLabel);
        //Title:
        JLabel heading = new JLabel("Electronic Voting System");
        heading.setBounds(45, 10, 800, 70);
        heading.setForeground(new Color(215, 216, 239));
        Font largerFont_0 = new Font(heading.getFont().getName(), Font.CENTER_BASELINE, 45);
        heading.setFont(largerFont_0);
        //Name_1:
        JLabel mahnoor = new JLabel("Mahnoor Islam");
        mahnoor.setBounds(380, 280, 280, 90);
        mahnoor.setForeground(new Color(163, 206, 230));
        Font largerFont_2 = new Font(mahnoor.getFont().getName(), Font.CENTER_BASELINE, 28);
        mahnoor.setFont(largerFont_2);
        //Name_2:
        JLabel atif = new JLabel("Atif Qureshi");
        atif.setBounds(380, 330, 190, 90);
        atif.setForeground(new Color(163, 206, 230));
        Font largerFont_6 = new Font(atif.getFont().getName(), Font.CENTER_BASELINE, 28);
        atif.setFont(largerFont_6);
        //Next:
        JButton next = new JButton("Next");
        next.setBounds(265, 280, 90, 35);
        Font largerFont_3 = new Font(next.getFont().getName(), Font.BOLD, 22);
        next.setFont(largerFont_3);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                home.dispose();

            }
        });
        //Labels:
        imageLabel.add(heading);
        imageLabel.add(next);
        imageLabel.add(mahnoor);
        imageLabel.add(atif);
        //Frame:
        home.setLayout(null);
        home.setSize(642, 450);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setLocationRelativeTo(null);
        home.setResizable(false);
        home.setVisible(true);

    }
}
