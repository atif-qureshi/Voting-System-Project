import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Candidate_Detail {
    public Candidate_Detail(Person person, Candidate_Data candidate_data) {
        //Candidate Detail Frame:
        JFrame candidate_detail = new JFrame("Detail");
        //Frame Icone:
        ImageIcon icon = new ImageIcon("D:\\Java\\Voting System Remaking\\Images/candidate.png  ");
        Image image_icon = icon.getImage();
        candidate_detail.setIconImage(image_icon);
        //Background Image:
        ImageIcon image = new ImageIcon("D:\\Java\\Voting System Remaking\\Images/form.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setSize(635, 415);
        candidate_detail.add(imageLabel);
        //Heading:
        JLabel heading = new JLabel("Candidate Detail's");
        heading.setBounds(140, 18, 400, 75);
        heading.setFont(new Font("Imprint MT Shadow", Font.BOLD, 45));
        heading.setForeground(new Color(34, 39, 115));
        //Details Holder TextArea:
        JTextArea detail_area = new JTextArea();
        detail_area.setBounds(140, 100, 350, 220);
        detail_area.setForeground(Color.BLACK);
        detail_area.setBackground(Color.cyan);
        detail_area.setEditable(false);
        Font largerFont_5 = new Font(detail_area.getFont().getName(), Font.BOLD, 20);
        detail_area.setFont(largerFont_5);
        detail_area.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        detail_area.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
        //Detail Printing:
        String details = String.format(
                " Constitution: %s\n PTI: %s\n Symbol: %s\n PMLN: %s\n Symbol: %s\n PPP: %s\n Symbol: %s",
                candidate_data.constitution, candidate_data.pti, candidate_data.ptisymbol, candidate_data.pmln, candidate_data.pmlnsymbol, candidate_data.ppp, candidate_data.pppsymbol
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
        //Next Button Action Listner:
        next_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Vote_Casting(person, candidate_data);
                candidate_detail.dispose();
            }
        });
        //Image labels:
        imageLabel.add(heading);
        imageLabel.add(detail_area);
        imageLabel.add(next_button);
        //Frame properties:
        candidate_detail.setSize(650, 450);
        candidate_detail.setLayout(null);
        candidate_detail.setVisible(true);
        candidate_detail.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        candidate_detail.setLocationRelativeTo(null);
        candidate_detail.setResizable(false);
    }
}
