package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JLabel accountDetails, type, card, carddetails, number, pin, pindetails, pnumber, services;
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    ButtonGroup groupaccount;
    String formno;

    SignupThree(String formno) {
        setLayout(null);
        this.formno = formno;
        accountDetails = new JLabel("Page 3 : Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accountDetails.setBounds(280, 40, 400, 40);
        add(accountDetails);

        type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 150, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        carddetails = new JLabel("Your 16 digit card number");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetails.setBounds(100, 330, 300, 20);
        add(carddetails);

        number = new JLabel("XXXX-XXXX-XXXX-1234");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        pindetails = new JLabel("Your 4 digit password");
        pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetails.setBounds(100, 400, 300, 20);
        add(pindetails);

        pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);

        services = new JLabel("Services:");
        services.setFont(new Font("Arial", Font.BOLD, 22));
        services.setBounds(100, 450, 300, 30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 22));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 22));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350, 500, 300, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 22));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 22));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350, 550, 300, 30);
        add(c4);

        c5 = new JCheckBox("Check Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 22));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 22));
        c6.setBackground(Color.WHITE);
        c6.setBounds(350, 600, 300, 30);
        add(c6);

        c7 = new JCheckBox("The above entered details are correct ");
        c7.setFont(new Font("Raleway", Font.BOLD, 22));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100, 650, 600, 50);
        add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 22));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(200, 720, 125, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 22));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(450, 720, 125, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 820);
        setLocation(350, 0);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accounType = null;
            if (r1.isSelected()) {
                accounType = "Saving Account";
            } else if (r2.isSelected()) {
                accounType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accounType = "Current Account";
            } else if (r4.isSelected()) {
                accounType = "Recurring Deposit Account";
            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";
            if (c1.isSelected()) {
                facility = facility + "ATM CARD";
            } else if (c2.isSelected()) {
                facility = facility + "Internet Banking";
            } else if (c3.isSelected()) {
                facility = facility + "Mobile Banking";
            } else if (c4.isSelected()) {
                facility = facility + "Email & SMS Alerts";
            } else if (c5.isSelected()) {
                facility = facility + "Check Book";
            } else if (c6.isSelected()) {
                facility = facility + "E-Statement";
            }
            try {
                if (accounType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account type is required");
                } else {
                    Conn c1 = new Conn();
                    String q1 = "insert into signupThree values('" + formno + "','" + accounType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                    String q2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin:" + pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new SignupThree("");
    }
}
