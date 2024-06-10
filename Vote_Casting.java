import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Vote_Casting {
    public Vote_Casting(Person person, Candidate_Data candidate_data) {
        //Vote Casting Frame:
        JFrame vote_frame = new JFrame("Vote Casting");
        //Frame Icon:
        ImageIcon icon = new ImageIcon("D:\\Java\\Voting System Remaking\\Images/vote_cast.png  ");
        Image image_icon = icon.getImage();
        vote_frame.setIconImage(image_icon);
        //Background Image:
        ImageIcon image = new ImageIcon("D:\\Java\\Voting System Remaking\\Images/form.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setSize(635, 415);
        vote_frame.add(imageLabel);
        // Heading:
        JLabel heading = new JLabel("Vote Casting");
        heading.setBounds(185, 18, 300, 75);
        heading.setFont(new Font("Imprint MT Shadow", Font.BOLD, 45));
        heading.setForeground(new Color(34, 39, 115));
        // PTI Label:
        JLabel pti_label = new JLabel("PTI");
        pti_label.setBounds(105, 130, 50, 30);
        pti_label.setFont(new Font("Imprint MT Shadow", Font.BOLD, 20));
        //PTI TextFiled:
        JTextArea pti_filed = new JTextArea();
        pti_filed.setBounds(185, 130, 200, 30);
        pti_filed.setEditable(false);
        pti_filed.setText(candidate_data.pti);
        Font pti_name = new Font(pti_filed.getFont().getName(), Font.BOLD, 18);
        pti_filed.setFont(pti_name);
        //Vote Cast Button for PTI:
        JButton pti_vote = new JButton("VOTE");
        pti_vote.setBounds(405, 130, 100, 30);
        pti_vote.setForeground(new Color(2, 3, 18));
        pti_vote.setBackground(new Color(120, 137, 143, 255));
        pti_vote.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 20));
        //PTI Actton Listmer:
        pti_vote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (var connection = DB.connect()) {
                    System.out.println("Connection Established Successfully...!!");

                    // Fetch data from Data table
                    String query = "UPDATE \"Data\" set vote_casted = true where cnic = '" + person.cnic + "'";
                    try (Statement stmt = connection.createStatement()) {
                        int rowsAffected = stmt.executeUpdate(query);
                    }
                    query = "Insert into \"Vote Casting\" (name, cnic, party, constitution, member) VALUES ('" + person.name + "', '" + person.cnic + "', 'pti', '" + person.constitution + "', '" + candidate_data.pti + "')";
                    try (Statement stmt = connection.createStatement()) {
                        int rowsAffected = stmt.executeUpdate(query);
                    }
                    JOptionPane.showMessageDialog(vote_frame, "Vote Casted successfully.");
                    System.out.println("Connection Closed Successfully....!!");
                    new Casting_Detail(person.name, person.cnic, "pti", candidate_data.pti, person.constitution);
                    vote_frame.dispose();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        //PMLN Label:
        JLabel pmln_label = new JLabel("Pmln");
        pmln_label.setBounds(105, 200, 90, 30);
        pmln_label.setFont(new Font("Imprint MT Shadow", Font.BOLD, 20));
        //PMLN TextFiled:
        JTextArea pmln_filed = new JTextArea();
        pmln_filed.setBounds(185, 200, 200, 30);
        Font largerFont_3 = new Font(pmln_filed.getFont().getName(), Font.BOLD, 24);
        pmln_filed.setFont(largerFont_3);
        pmln_filed.setText(candidate_data.pmln);
        Font pmln_name = new Font(pmln_filed.getFont().getName(), Font.BOLD, 17);
        pmln_filed.setFont(pmln_name);
        pmln_filed.setEditable(false);
        //PMLN Vote Cast Button:
        JButton pmln_vote = new JButton("VOTE");
        pmln_vote.setBounds(405, 200, 100, 30);
        pmln_vote.setForeground(new Color(2, 3, 18));
        pmln_vote.setBackground(new Color(120, 137, 143, 255));
        pmln_vote.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 20));
        //PMLN Action Listner:
        pmln_vote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (var connection = DB.connect()) {
                    System.out.println("Connection Established Successfully...!!");

                    // Fetch data from Data table
                    String query = "UPDATE \"Data\" set vote_casted = true where cnic = '" + person.cnic + "'";
                    try (Statement stmt = connection.createStatement()) {
                        int rowsAffected = stmt.executeUpdate(query);
                    }

                    query = "Insert into \"Vote Casting\" (name, cnic, party, constitution, member) VALUES ('" + person.name + "', '" + person.cnic + "', 'pmln', '" + person.constitution + "', '" + candidate_data.pmln + "')";
                    try (Statement stmt = connection.createStatement()) {
                        int rowsAffected = stmt.executeUpdate(query);
                    }
                    JOptionPane.showMessageDialog(vote_frame, "Vote Casted successfully.");
                    System.out.println("Connection Closed Successfully....!!");
                    new Casting_Detail(person.name, person.cnic, "pmln", candidate_data.pmln, person.constitution);
                    vote_frame.dispose();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        //PPP Label:
        JLabel ppp_label = new JLabel("PPP");
        ppp_label.setBounds(105, 270, 60, 30);
        ppp_label.setFont(new Font("Imprint MT Shadow", Font.BOLD, 20));
        //PPP TextFiled:
        JTextArea ppp_field = new JTextArea();
        ppp_field.setBounds(185, 270, 200, 30);
        ppp_field.setText(candidate_data.ppp);
        ppp_field.setEditable(false);
        Font ppp_name = new Font(ppp_field.getFont().getName(), Font.BOLD, 17);
        ppp_field.setFont(ppp_name);
        //PPP Vote Cast Button:
        JButton ppp_vote = new JButton("VOTE");
        ppp_vote.setBounds(405, 270, 100, 30);
        ppp_vote.setForeground(new Color(2, 3, 18));
        ppp_vote.setBackground(new Color(120, 137, 143, 255));
        ppp_vote.setFont(new Font("Imprint MT Shadow", Font.CENTER_BASELINE, 20));
        //PPP Action Listner:
        ppp_vote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (var connection = DB.connect()) {
                    System.out.println("Connection Established Successfully...!!");

                    // Fetch data from Data table
                    String query = "UPDATE \"Data\" set vote_casted = true where cnic = '" + person.cnic + "'";
                    try (Statement stmt = connection.createStatement()) {
                        int rowsAffected = stmt.executeUpdate(query);
                    }
                    query = "Insert into \"Vote Casting\" (name, cnic, party, constitution, member) VALUES ('" + person.name + "', '" + person.cnic + "', 'ppp', '" + person.constitution + "', '" + candidate_data.ppp + "')";
                    try (Statement stmt = connection.createStatement()) {
                        int rowsAffected = stmt.executeUpdate(query);
                    }
                    JOptionPane.showMessageDialog(vote_frame, "Vote Casted successfully.");
                    System.out.println("Connection Closed Successfully....!!");
                    new Casting_Detail(person.name, person.cnic, "ppp", candidate_data.ppp, person.constitution);
                    vote_frame.dispose();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        //Images Labels:
        imageLabel.add(heading);
        imageLabel.add(pti_label);
        imageLabel.add(pti_filed);
        imageLabel.add(pti_vote);
        imageLabel.add(pmln_label);
        imageLabel.add(pmln_filed);
        imageLabel.add(pmln_vote);
        imageLabel.add(ppp_label);
        imageLabel.add(ppp_field);
        imageLabel.add(ppp_vote);
        //Frame Properties:
        vote_frame.setSize(650, 450);
        vote_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vote_frame.setLayout(null);
        vote_frame.setLocationRelativeTo(null);
        vote_frame.setVisible(true);
    }
}
