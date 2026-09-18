package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JLabel personalDetails, rel, cat, inc, edu, qual, occup, pan, nid, citz, pin;
    JTextField panTextField, nidTextField;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, qualification, occupation;
    JButton next;
    ButtonGroup group1, group2;
    String formno;

    SignupTwo(String formno) {
        setLayout(null);
        this.formno = formno;
        
        personalDetails = new JLabel("Page 2 : Additional Details");
        personalDetails.setFont(new Font("osward", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        rel = new JLabel("Religion:");
        rel.setFont(new Font("Osward", Font.BOLD, 20));
        rel.setBounds(100, 140, 200, 30);
        add(rel);

        String religionArray[] = {"Muslim", "Hindu", "Christian", "Other"};
        religion = new JComboBox(religionArray);
        religion.setFont(new Font("Raleway", Font.BOLD, 14));
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        cat = new JLabel("Category:");
        cat.setFont(new Font("Osward", Font.BOLD, 20));
        cat.setBounds(100, 190, 200, 30);
        add(cat);

        String catArray[] = {"General", "Special", "VIP", "others"};
        category = new JComboBox(catArray);
        category.setFont(new Font("Raleway", Font.BOLD, 14));
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        inc = new JLabel("Income:");
        inc.setFont(new Font("Osward", Font.BOLD, 20));
        inc.setBounds(100, 240, 200, 30);
        add(inc);

        String incomeArray[] = {"0", "0 to 50000", "50000 to 100000", "upto 1000000"};
        income = new JComboBox(incomeArray);
        income.setFont(new Font("Raleway", Font.BOLD, 14));
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        edu = new JLabel("Educational");
        edu.setFont(new Font("Osward", Font.BOLD, 20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);

        qual = new JLabel("Qualifiaction:");
        qual.setFont(new Font("Osward", Font.BOLD, 20));
        qual.setBounds(100, 340, 200, 30);
        add(qual);

        String educationArray[] = {"Non-Graduation", "Graduation", "Post Graduation", "PHD", "Others"};
        qualification = new JComboBox(educationArray);
        qualification.setFont(new Font("Raleway", Font.BOLD, 14));
        qualification.setBounds(300, 340, 400, 30);
        qualification.setBackground(Color.WHITE);
        add(qualification);

        occup = new JLabel("Occupation:");
        occup.setFont(new Font("Osward", Font.BOLD, 20));
        occup.setBounds(100, 390, 200, 30);
        add(occup);

        String occupationArray[] = {"Student", "Teacher", "Banker", "Doctor", "Others"};
        occupation = new JComboBox(occupationArray);
        occupation.setFont(new Font("Raleway", Font.BOLD, 14));
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        pan = new JLabel("Phone Number:");
        pan.setFont(new Font("Osward", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        nid = new JLabel("NID Number:");
        nid.setFont(new Font("Osward", Font.BOLD, 20));
        nid.setBounds(100, 490, 200, 30);
        add(nid);

        nidTextField = new JTextField();
        nidTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nidTextField.setBounds(300, 490, 400, 30);
        add(nidTextField);

        citz = new JLabel("Bangladeshi Citizen:");
        citz.setFont(new Font("Osward", Font.BOLD, 20));
        citz.setBounds(100, 540, 200, 30);
        add(citz);

        syes = new JRadioButton("Yes");
        syes.setBackground(Color.WHITE);
        syes.setBounds(350, 540, 100, 30);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBackground(Color.WHITE);
        sno.setBounds(500, 540, 100, 30);
        add(sno);

        group1 = new ButtonGroup();
        group1.add(syes);
        group1.add(sno);

        pin = new JLabel("Existing Account:");
        pin.setFont(new Font("Osward", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);

        eyes = new JRadioButton("Yes");
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(350, 590, 100, 30);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBackground(Color.WHITE);
        eno.setBounds(500, 590, 100, 30);
        add(eno);

        group2 = new ButtonGroup();
        group2.add(eyes);
        group2.add(eno);

        next = new JButton("NEXT");
        next.setBounds(620, 660, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String squalification = (String) qualification.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }
        String span = panTextField.getText();
        String snid = nidTextField.getText();
        try {
            if (span.equals("")) {
                JOptionPane.showMessageDialog(null, "Phone Number is required");
            } else if (snid.equals("")) {
                JOptionPane.showMessageDialog(null, "NID   is required");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + squalification + "','" + soccupation + "','" + span + "','" + snid + "','" + seniorcitizen + "','" + existingaccount + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
