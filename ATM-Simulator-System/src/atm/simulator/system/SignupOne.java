package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {

    long random;
    JLabel formno, personalDetails, name, fname, dob, gender, email, marital, address, city, district, pin;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, stateTextField, cityTextField, pinTextField;
    JRadioButton male, female, other, married, unmarried;
    JButton next;
    ButtonGroup maritalGroup, genderGroup;
    JDateChooser dateChooser;

    SignupOne() {
        setLayout(null);
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L + 1000L);

        formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("osward", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("osward", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        name = new JLabel("Name : ");
        name.setFont(new Font("osward", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        fname = new JLabel("Father's Name :");
        fname.setFont(new Font("osward", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("osward", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        gender = new JLabel("Gender :");
        gender.setFont(new Font("osward", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("male");
        male.setBackground(Color.WHITE);
        male.setBounds(300, 290, 60, 30);
        add(male);

        female = new JRadioButton("female");
        female.setBackground(Color.WHITE);
        female.setBounds(450, 290, 120, 30);
        add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        email = new JLabel("Email Address :");
        email.setFont(new Font("osward", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("osward", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("married");
        married.setBackground(Color.WHITE);
        married.setBounds(300, 390, 100, 30);
        add(married);

        unmarried = new JRadioButton("unmarried");
        unmarried.setBackground(Color.WHITE);
        unmarried.setBounds(450, 390, 100, 30);
        add(unmarried);

        other = new JRadioButton("others");
        other.setBackground(Color.WHITE);
        other.setBounds(630, 390, 80, 30);
        add(other);

        maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        address = new JLabel("Address :");
        address.setFont(new Font("osward", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        city = new JLabel("District :");
        city.setFont(new Font("osward", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        district = new JLabel("Division :");
        district.setFont(new Font("osward", Font.BOLD, 20));
        district.setBounds(100, 540, 200, 30);
        add(district);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        pin = new JLabel("Pin Code :");
        pin.setFont(new Font("osward", Font.BOLD, 20));
        pin.setBounds(100, 590, 200, 30);
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);

        next = new JButton("NEXT");
        next.setBounds(620, 660, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father name is required");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email is required");
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is required");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "District is required");
            } else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "Division is required");
            } else if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Pin is required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignupOne();
    }
}
