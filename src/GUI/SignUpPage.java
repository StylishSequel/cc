package GUI;

import ConnectDatabase.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUpPage extends JFrame{
    private JPanel mainPanel;
    private JPanel signupPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton login;
    public SignUpPage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setVisible(true);
    }

    public void setBackground(){
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 800, 600);
        mainPanel.setBackground(Color.white);
        setSignupPanel();
        add(mainPanel);
    }

    public void setSignupPanel() {
        signupPanel = new JPanel();
        signupPanel.setLayout(null);
        signupPanel.setBackground(new Color(154, 200, 205));
        signupPanel.setBounds(230,80,300,400);

        Color colorWord = new Color(69, 60, 103);
        Font fontWord = new Font("Serif", Font.PLAIN, 15);

        JLabel Label = new JLabel("SIGN UP");
        Label.setForeground(colorWord);
        Label.setFont(new Font("Serif", Font.PLAIN, 25));
        Label.setBounds(100,20,250,50);


        //SET NAME WORD
        JLabel name = new JLabel("NAME:");
        name.setForeground(colorWord);
        name.setFont(fontWord);
        name.setBounds(20,80,250,50);

        //SET TEXT FIELD NAME
        JTextField nameField = new JTextField();
        nameField.setForeground(new Color(69, 60, 103));
        nameField.setFont(new Font("Serif", Font.PLAIN, 20));
        nameField.setBounds(120,90,150,30);

        //SET GENDER WORD
        JLabel gender = new JLabel("GENDER:");
        gender.setForeground(colorWord);
        gender.setFont(fontWord);
        gender.setBounds(20,120,250,50);

        //Set gender button
        JRadioButton male = new JRadioButton("Male");
        male.setForeground(colorWord);
        male.setBackground(new Color(154, 200, 205));
        male.setFont(fontWord);
        male.setBounds(120,130,90,40);

        JRadioButton female = new JRadioButton("Female");
        female.setForeground(colorWord);
        female.setBackground(new Color(154, 200, 205));
        female.setFont(fontWord);
        female.setBounds(210,130,100,40);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        //SET PHONE WORD
        JLabel phone = new JLabel("PHONE");
        phone.setForeground(new Color(69, 60, 103));
        phone.setFont(new Font("Serif", Font.PLAIN, 15));
        phone.setBounds(20,160,250,50);

        //SET TEXT FIELD PHONE
        JTextField phoneField = new JTextField();
        phoneField.setForeground(new Color(69, 60, 103));
        phoneField.setFont(new Font("Serif", Font.PLAIN, 20));
        phoneField.setBounds(120,170,150,30);

        //SET USERNAME WORD
        JLabel username = new JLabel("USERNAME:");
        username.setForeground(colorWord);
        username.setFont(fontWord);
        username.setBounds(20,200,250,50);

        //SET TEXT FIELD USERNAME
        usernameField = new JTextField();
        usernameField.setForeground(new Color(69, 60, 103));
        usernameField.setFont(new Font("Serif", Font.PLAIN, 20));
        usernameField.setBounds(120,210,150,30);

        //SET PASSWORD WORD
        JLabel password = new JLabel("PASSWORD:");
        password.setForeground(colorWord);
        password.setFont(fontWord);
        password.setBounds(20,240,250,50);

        //SET TEXT FIED PASSWORD
        passwordField = new JPasswordField();
        passwordField.setForeground(new Color(69, 60, 103));
        passwordField.setFont(new Font("Serif", Font.PLAIN, 20));
        passwordField.setBounds(120,250,150,30);


        //SET ENTER BUTTON
        login = new JButton("SIGN UP");
        login.setForeground(new Color(69, 60, 103));
        login.setBackground(new Color(248, 246, 227));
        login.setBounds(80,300,150,30);
        login.setFont(new Font("Serif", Font.PLAIN, 20));


        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newCusName = nameField.getText();
                Boolean newgenderCus = true;
                Boolean is_active = false;
                if(female.isSelected()){
                    newgenderCus = false;
                }
                System.out.println(newCusName);
                System.out.println(newgenderCus);
                String newusername = usernameField.getText();
                String newpassword = passwordField.getText();
                System.out.println(newusername);
                System.out.println(newpassword);
                Login login = new Login();
                dispose();
            }
        });

        signupPanel.add(name);
        signupPanel.add(nameField);
        signupPanel.add(gender);
        signupPanel.add(male);
        signupPanel.add(female);
        signupPanel.add(phone);
        signupPanel.add(phoneField);
        signupPanel.add(username);
        signupPanel.add(usernameField);
        signupPanel.add(password);
        signupPanel.add(passwordField);
        signupPanel.add(login);
        signupPanel.add(Label);
        mainPanel.add(signupPanel);
    }

    public static void main(String[] args) {
        new SignUpPage();
    }
}
