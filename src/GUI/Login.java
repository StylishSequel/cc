package GUI;
// import javax.swing.border.Border;
import javax.swing.*;
// import javax.swing.border.EmptyBorder;
// import javax.swing.event.DocumentEvent;
// import javax.swing.event.DocumentListener;

import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.awt.event.*;

//ConnectDatabase libary 
import ConnectDatabase.*;

//CREATE LOGIN PAGE

public class Login extends JFrame {
    // private JPanel panel;
     private JLabel label;
     private JLabel labelUsername;
     private JLabel labelPassword;
     private JTextField textFieldUsername;
     private JPasswordField textFieldPassword;
     private JButton buttonLogin;
     private JButton buttonSignUp;
     private JButton forgetPassword;

    public Login() {
        this.setSize(800, 600);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Hotel Application");
        this.setLabel();
        this.setTextField();
        this.setButton();
        this.setBackground();
        this.setVisible(true);
    }

    //SET BACKGROUND
    public void setBackground() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(217, 237, 191));
        panel.setBounds(0, 0, 800, 600);
        add(panel);
    }
    //SET USERNAME,PASSWORD LABEL
    public void setLabel() {
        Container pane = this.getContentPane();

        this.label = new JLabel("SHERATON HANOI HOTEL");
        this.label.setBounds(300,50,200,200);
        this.label.setFont(new Font("Calibri",Font.HANGING_BASELINE,20));
        this.label.setForeground(new Color(255, 152, 0));
        this.labelUsername = new JLabel("USERNAME:");
        this.labelUsername.setFont(new Font("Calibri",Font.HANGING_BASELINE,20));
        this.labelUsername.setForeground(new Color(255, 152, 0));
        this.labelPassword = new JLabel("PASSWORD:");
        this.labelPassword.setFont(new Font("Calibri",Font.HANGING_BASELINE,20));
        this.labelPassword.setForeground(new Color(255, 152, 0));
        this.labelUsername.setBounds(300,100,200,200);
        this.labelPassword.setBounds(300,150,200,200);
        pane.add(this.labelUsername);
        pane.add(this.labelPassword);
        pane.add(this.label);
    }

    //SET USERNAME,PASSWORD TEXTFIELD
    // public void setTextField() {
    //     Container pane = this.getContentPane();
    //     this.textFieldUsername = new JTextField();
    //     this.textFieldPassword = new JPasswordField();
    //     this.textFieldUsername.setBounds(430,185,150,30);
    //     this.textFieldPassword.setBounds(430,230,150,30);
    //     pane.add(this.textFieldUsername);
    //     pane.add(this.textFieldPassword);
    // }

    
    public void setTextField() {
        Container pane = this.getContentPane();
        this.textFieldUsername = new JTextField("user_name");
        this.textFieldPassword = new JPasswordField("password");

        // Add FocusListener to the username text field
        textFieldUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textFieldUsername.getText().equals("user_name")) {
                    textFieldUsername.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldUsername.getText().isEmpty()) {
                    textFieldUsername.setText("user_name");
                }
            }
        });

        // Add FocusListener to the password field
        textFieldPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // When the field gains focus, clear the text if it's the default value
                String passText = new String(textFieldPassword.getPassword());
                if (passText.equals("password")) {
                    textFieldPassword.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // When the field loses focus, if it's empty, set the default value
                String passText = new String(textFieldPassword.getPassword());
                if (passText.isEmpty()) {
                    textFieldPassword.setText("password");
                }
            }
        });

        this.textFieldUsername.setBounds(430, 185, 150, 30);
        this.textFieldPassword.setBounds(430, 230, 150, 30);
        pane.add(this.textFieldUsername);
        pane.add(this.textFieldPassword);
    }

   

    //SET LOGIN,SIGNUP BUTTON
    public void setButton() {
        
        Container pane = this.getContentPane();
        this.buttonLogin = new JButton("LOGIN");
        this.buttonSignUp = new JButton("SIGN UP");
        this.forgetPassword = new JButton("FORGOT PASS");
        //Login button
        this.buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = String.valueOf(textFieldPassword.getPassword());
                ConnectDatabase db = new ConnectDatabase();
                Boolean flag = db.checkLogin(username, password);
                if(flag){
                    System.out.println("Login successfully");
                }else{  
                    System.out.println("Login failed");
                }
                
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);

            }
        });
        //Sign up button
        this.buttonSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = String.valueOf(textFieldPassword.getPassword());
                System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            }
        });
        this.forgetPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = String.valueOf(textFieldUsername.getText());
                System.out.println("Username: " + username);
            }
        });
        this.buttonSignUp.setBounds(280,300,150,30);
        pane.add(this.buttonSignUp);
        this.buttonLogin.setBounds(430,300,150,30);
        pane.add(this.buttonLogin);
        this.forgetPassword.setBounds(430,260,150,30);
        pane.add(this.forgetPassword);

        
    }
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
}


