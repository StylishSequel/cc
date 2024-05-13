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
import java.util.Map;
import java.awt.font.TextAttribute;

//ConnectDatabase libary 
import ConnectDatabase.*;

//CREATE LOGIN PAGE

public class Login extends JFrame {
    // private JPanel panel;

    private JPanel panel;

     private JLabel label;
     private JLabel labelUsername;
     private JLabel labelPassword;
     private JLabel forgotPasswordLabel;
     private JLabel or;

     private JTextField textFieldUsername;

     private JPasswordField textFieldPassword;

     private RoundedButton buttonLogin;
     private RoundedButton buttonSignUp;
    //  private JButton forgetPassword;

    public Login() {
        this.setSize(800, 600);
        
        this.setLocation(100,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Hotel Application");
        
        this.setLabel();
        this.setTextField();
        this.setButton();
        this.setPanel();

        this.setBackground();
        this.setVisible(true);
    }

    //SET BACKGROUND
    public void setBackground() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0, 0, 20));
        panel.setBounds(0, 0, 800, 600);
        add(panel);
    }
    //SET USERNAME,PASSWORD LABEL
    public void setLabel() {
        Container pane = this.getContentPane();

        this.label = new JLabel("LOGIN");
        this.label.setBounds(400,30,200,200);
        this.label.setFont(new Font("Calibri",Font.BOLD,20));
        this.label.setForeground(new Color(255, 152, 0));
        
        this.labelUsername = new JLabel("USERNAME:");
        this.labelUsername.setFont(new Font("Calibri",Font.BOLD,15));
        this.labelUsername.setForeground(new Color(255, 152, 0));
        this.labelUsername.setBounds(300,70,200,200);

        this.labelPassword = new JLabel("PASSWORD:");
        this.labelPassword.setFont(new Font("Calibri",Font.BOLD,15));
        this.labelPassword.setForeground(new Color(255, 152, 0));
        this.labelPassword.setBounds(300,140,200,200);
        
        this.or = new JLabel("OR");
        this.or.setFont(new Font("Calibri",Font.BOLD,13));
        this.or.setForeground(new Color(255, 152, 0));
        this.or.setBounds(430,290,200,200);

        this.forgotPasswordLabel = new JLabel("Forgot Password?");
        this.forgotPasswordLabel.setForeground(Color.BLUE.darker());
        this.forgotPasswordLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        forgotPasswordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle click event here
                System.out.println("Forgot Password link clicked");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change color to red and underline text when mouse enters
                forgotPasswordLabel.setForeground(Color.RED);
                Font font = forgotPasswordLabel.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                forgotPasswordLabel.setFont(font.deriveFont(attributes));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color back to darker blue and remove underline when mouse exits
                forgotPasswordLabel.setForeground(Color.BLUE.darker());
                Font font = forgotPasswordLabel.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, -1);
                forgotPasswordLabel.setFont(font.deriveFont(attributes));
            }
        });

        forgotPasswordLabel.setBounds(465,295,150,30);

        pane.add(this.labelUsername);
        pane.add(this.labelPassword);
        pane.add(this.label);
        pane.add(forgotPasswordLabel);
        pane.add(or);
    }
    public void setPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(250, 95, 365, 400);
        add(panel);
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
        this.textFieldUsername = new JTextField("Email or Phone");
        this.textFieldPassword = new JPasswordField("password");

        // Add FocusListener to the username text field
        textFieldUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textFieldUsername.getText().equals("Email or Phone")) {
                    textFieldUsername.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldUsername.getText().isEmpty()) {
                    textFieldUsername.setText("Email or Phone");
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

        this.textFieldUsername.setBounds(300, 185, 270, 40);
        this.textFieldPassword.setBounds(300, 255, 270, 40);
        pane.add(this.textFieldUsername);
        pane.add(this.textFieldPassword);
    }

   

    //SET LOGIN,SIGNUP BUTTON
    public void setButton() {
        
        Container pane = this.getContentPane();
        this.buttonLogin = new RoundedButton("LOGIN");
        buttonLogin.setBackground(new Color(255, 152, 0));
        this.buttonSignUp = new RoundedButton("SIGN UP");
        buttonSignUp.setBackground(new Color(255, 152, 0));
        // this.forgetPassword = new JButton("FORGOT PASS");
        //Login button
        this.buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = String.valueOf(textFieldPassword.getPassword());
                ConnectDatabase db = new ConnectDatabase();
                Boolean flag = db.checkLoginCustomer(username, password);
                // Boolean flag2 = db.checkLoginEmployee(username, password);
                if(flag == true){
                    System.out.println("Login successfully");
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                    BaseForm baseForm = new BaseForm();
                    //Close login page
                    dispose();
                }else{  
                    JOptionPane.showMessageDialog(pane, "Invalid username or password", "Message Title", JOptionPane.INFORMATION_MESSAGE);

                }
                
                
                

            }
        });
        this.buttonLogin.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                buttonLogin.setBackground(Color.GREEN); // Change color when mouse entered
            }
        
            public void mouseExited(MouseEvent evt) {
                buttonLogin.setBackground(new Color(255, 152, 0)); // Change color back when mouse exited
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
        this.buttonSignUp.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                buttonSignUp.setBackground(Color.GREEN); // Change color when mouse entered
            }
        
            public void mouseExited(MouseEvent evt) {
                buttonSignUp.setBackground(new Color(255, 152, 0)); // Change color back when mouse exited
            }
        });
        // this.forgetPassword.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         String username = String.valueOf(textFieldUsername.getText());
        //         System.out.println("Username: " + username);
        //     }
        // });
        this.buttonSignUp.setBounds(300,410,270,30);
        pane.add(this.buttonSignUp);
        this.buttonLogin.setBounds(300,340,270,30);
        pane.add(this.buttonLogin);
        // this.forgetPassword.setBounds(430,360,150,30);
        // pane.add(this.forgetPassword);

        
    }
    public static void main(String[] args) {
        new Login();
    }
}


