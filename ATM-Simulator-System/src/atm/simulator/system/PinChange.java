package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JLabel text, pintext, repintext;
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 280, 500, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);

        pintext = new JLabel("NEW PIN:");
        pintext.setBounds(165, 320, 180, 25);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 14));
        pin.setBounds(325, 320, 180, 25);
        image.add(pin);

        repintext = new JLabel("Re Enter - New PIN:");
        repintext.setBounds(165, 360, 180, 25);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setForeground(Color.WHITE);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 14));
        repin.setBounds(325, 360, 180, 25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(400, 450, 100, 30);

        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(400, 500, 100, 30);

        back.addActionListener(this);
        image.add(back);

       setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }
                if(npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter new pin");
                }
                 if(rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please reneter new pin");
                }
                 Conn c1 = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                String q3 = "update signupThree set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);
                JOptionPane.showMessageDialog(null, "Pin Changed successfully ");
                setVisible(false);
            new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
