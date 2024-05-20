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
import Person.*;

public class SignUpPage extends JFrame{
    private JPanel mainPanel;
    private JPanel signupPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signup;
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
        signupPanel.setBounds(230,80,365,400);

        Color colorWord = new Color(69, 60, 103);
        Font fontWord = new Font("Serif", Font.PLAIN, 15);
        JLabel signupLabel = new JLabel("SIGN UP");
        signupLabel.setForeground(new Color(69, 60, 103));
        signupLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        signupLabel.setBounds(125,20,250,50);

        


        

        //SET TEXT FIELD NAME
        JTextField nameField = new JTextField("Name");
        nameField.setForeground(new Color(69, 60, 103));
        nameField.setFont(new Font("Serif", Font.PLAIN, 20));
        nameField.setBounds(30,110,150,30);
        nameField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if(nameField.getText().equals("Name")){
                    nameField.setText("");
                    nameField.setForeground(new Color(69, 60, 103));
                }
            }

            public void focusLost(FocusEvent e) {
                if(nameField.getText().equals("")){
                    nameField.setText("Name");
                    nameField.setForeground(new Color(69, 60, 103));
                }
            }
        });

        //SET GENDER WORD
       

        //Set gender button
        JRadioButton male = new JRadioButton("Male");
        male.setForeground(colorWord);
        male.setBackground(new Color(154, 200, 205));
        male.setFont(fontWord);
        male.setBounds(90,235,100,40);

        JRadioButton female = new JRadioButton("Female");
        female.setForeground(colorWord);
        female.setBackground(new Color(154, 200, 205));
        female.setFont(fontWord);
        female.setBounds(200,235,100,40);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        //SET PHONE WORD
        
        

        //SET TEXT FIELD PHONE
        JTextField phoneField = new JTextField("Phone");
        phoneField.setForeground(new Color(69, 60, 103));
        phoneField.setFont(new Font("Serif", Font.PLAIN, 20));
        phoneField.setBounds(190,110,150,30);
        phoneField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if(phoneField.getText().equals("Phone")){
                    phoneField.setText("");
                    phoneField.setForeground(new Color(69, 60, 103));
                }
            }

            public void focusLost(FocusEvent e) {
                if(phoneField.getText().equals("")){
                    phoneField.setText("Phone");
                    phoneField.setForeground(new Color(69, 60, 103));
                }
            }
        });

        

        //SET TEXT FIELD USERNAME
        usernameField = new JTextField("User name");
        usernameField.setForeground(new Color(69, 60, 103));
        usernameField.setFont(new Font("Serif", Font.PLAIN, 20));
        usernameField.setBounds(30,155,310,30);
        usernameField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if(usernameField.getText().equals("User name")){
                    usernameField.setText("");
                    usernameField.setForeground(new Color(69, 60, 103));
                }
            }

            public void focusLost(FocusEvent e) {
                if(usernameField.getText().equals("")){
                    usernameField.setText("User name");
                    usernameField.setForeground(new Color(69, 60, 103));
                }
            }
        });

        

        //SET TEXT FIED PASSWORD
        passwordField = new JPasswordField("password");
        passwordField.setForeground(new Color(69, 60, 103));
        passwordField.setFont(new Font("Serif", Font.PLAIN, 20));
        passwordField.setBounds(30,200,310,30);
        passwordField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if(passwordField.getPassword().equals("password")){
                    passwordField.setText("");
                    passwordField.setForeground(new Color(69, 60, 103));
                }
            }

            public void focusLost(FocusEvent e) {
                if(passwordField.getPassword().equals("")){
                    passwordField.setText("password");
                    passwordField.setForeground(new Color(69, 60, 103));
                }
            }
        });


        //SET ENTER BUTTON
        signup = new RoundedButton("SIGN UP");
        signup.setForeground(new Color(69, 60, 103));
        signup.setBackground(new Color(248, 246, 227));
        signup.setBounds(105,300,150,30);
        signup.setFont(new Font("Serif", Font.PLAIN, 20));
        signup.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                signup.setBackground(new Color(69, 60, 103));
                signup.setForeground(new Color(248, 246, 227));
                signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                signup.setBackground(new Color(248, 246, 227));
                signup.setForeground(new Color(69, 60, 103));
            }
        });


        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connector connector = new Connector();
                QueryAll query = new QueryAll(connector);
                String newCusName = nameField.getText();
                Boolean newgenderCus = true;
                Boolean is_active = false;
                if(female.isSelected()){
                    newgenderCus = false;
                }
                System.out.println(newCusName);
                System.out.println(newgenderCus);

                String newusername = usernameField.getText();
                String phone = phoneField.getText();
                String newpassword = new String(passwordField.getPassword());
                Boolean flag1 = query.queryCustomer.checkCustomerAccountExist(newusername);
                Boolean flag2 = query.queryEmployee.checkEmployeeAccountExist(newusername);
                
                System.out.println(phone);
                System.out.println(newusername);
                System.out.println(newpassword);
                
                
                if(flag1 || flag2){
                    JOptionPane.showMessageDialog(null, "Username already exists");
                    return;
                }
                query.queryCustomer.insertCustomerAccount(newusername, newpassword, newCusName, newgenderCus, phone) ;


                Login login = new Login();
                dispose();
            }
        });

        signupPanel.add(signupLabel);
        signupPanel.add(nameField);
        
        signupPanel.add(male);
        signupPanel.add(female);
        
        signupPanel.add(phoneField);
        
        signupPanel.add(usernameField);
        
        signupPanel.add(passwordField);
        signupPanel.add(signup);
        
        mainPanel.add(signupPanel);
    }

    public static void main(String[] args) {
        new SignUpPage();
    }
}
