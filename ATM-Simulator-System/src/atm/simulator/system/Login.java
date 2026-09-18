package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel text, cardNo, pin;
    JButton login, signup, clear;
    JTextField cardText;
    JPasswordField pinText;

    Login() {
        setTitle("ATUMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        text = new JLabel("Welcome to  ATM");
        text.setFont(new Font("osward", Font.BOLD, 38));
        text.setBounds(200, 40, 450, 40);
        add(text);

        cardNo = new JLabel("Card No : ");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setBounds(125, 150, 375, 30);
        add(cardNo);

        cardText = new JTextField();
        cardText.setBounds(300, 150, 230, 30);
        cardText.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardText);

        pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(125, 220, 230, 30);
        add(pin);

        pinText = new JPasswordField();
        pinText.setBounds(300, 220, 230, 30);
        pinText.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinText);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 480);
        setLocation(350, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardText.setText("");
            pinText.setText("");
        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardText.getText();
            String pinnumber = pinText.getText();
            String query = "select * from login where cardnumber = '" + cardnumber + "' and pin = '" + pinnumber + "'";

            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card number or pin!!");

                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
