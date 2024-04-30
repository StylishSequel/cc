package GUI;
import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//CREATE LOGIN PAGE

public class Login extends JFrame {
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

        this.label = new JLabel("SHERATON HA NOI HOTEL");
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
    public void setTextField() {
        Container pane = this.getContentPane();
        this.textFieldUsername = new JTextField();
        this.textFieldPassword = new JPasswordField();
        this.textFieldUsername.setBounds(430,185,150,30);
        this.textFieldPassword.setBounds(430,230,150,30);
        pane.add(this.textFieldUsername);
        pane.add(this.textFieldPassword);
    }

    //SET LOGIN,SIGNUP BUTTON
    public void setButton() {
        Container pane = this.getContentPane();
        this.buttonLogin = new JButton("LOGIN");
        this.buttonSignUp = new JButton("SIGN UP");
        this.forgetPassword = new JButton("FORGOT PASS");
        this.buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = String.valueOf(textFieldPassword.getPassword());
            }
        });
        this.buttonSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = String.valueOf(textFieldPassword.getPassword());
            }
        });
        this.forgetPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(textFieldPassword.getPassword());
            }
        });
        this.buttonSignUp.setBounds(250,300,150,30);
        pane.add(this.buttonSignUp);
        this.buttonLogin.setBounds(450,300,150,30);
        pane.add(this.buttonLogin);
        this.forgetPassword.setBounds(430,260,150,30);
        pane.add(this.forgetPassword);
    }

}


