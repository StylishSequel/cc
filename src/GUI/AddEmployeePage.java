package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import ConnectDatabase.*;
import Person.*;
public class AddEmployeePage extends BaseForm {
    private Person person;
    private JPanel addEmployeePanel;
    private JTextField nameField,phoneField,salaryField,jobField, usernameField, passwordField;
    private JRadioButton maleRadio,femaleRadio,activeRadio;
    private JButton enterButton;

    public AddEmployeePage(Person person){
        super(person);
        this.person = person;
        setAddEmployeePanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setVisible(true);
    }

    public void setAddEmployeePanel() {
        addEmployeePanel = new JPanel();
        addEmployeePanel.setLayout(null);
        addEmployeePanel.setBackground(new Color(154, 200, 205));
        addEmployeePanel.setBounds(200,50,400,430);

        Font font = new Font("Serif", Font.PLAIN, 20);
        Color bgColor = new Color(69, 60, 103);

        JLabel addEmLabel = new JLabel("ADD EMPLOYEE");
        addEmLabel.setForeground(new Color(69, 60, 103));
        addEmLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        addEmLabel.setBounds(80,10,250,50);

        //Set word name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(bgColor);
        nameLabel.setFont(font);
        nameLabel.setBounds(50,65,100,40);

        //Set text field name
        nameField = new JTextField();
        nameField.setBounds(140,70,150,30);
        nameField.setForeground(new Color(69, 60, 103));


        //Set word gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(bgColor);
        genderLabel.setFont(font);
        genderLabel.setBounds(50,105,100,40);

        //Set gender button
        maleRadio = new JRadioButton("Male");
        maleRadio.setForeground(bgColor);
        maleRadio.setBackground(new Color(154, 200, 205));
        maleRadio.setFont(font);
        maleRadio.setBounds(140,110,100,40);

        femaleRadio = new JRadioButton("Female");
        femaleRadio.setForeground(bgColor);
        femaleRadio.setBackground(new Color(154, 200, 205));
        femaleRadio.setFont(font);
        femaleRadio.setBounds(250,110,100,40);

        ButtonGroup group = new ButtonGroup();
        group.add(maleRadio);
        group.add(femaleRadio);

        //Set word phone
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(bgColor);
        phoneLabel.setFont(font);
        phoneLabel.setBounds(50,145,100,40);

        //Set phone textfield
        phoneField = new JTextField();
        phoneField.setBounds(140,150,150,30);

        //Set active word
        JLabel activeLabel = new JLabel("Active:");
        activeLabel.setForeground(bgColor);
        activeLabel.setFont(font);
        activeLabel.setBounds(50,185,100,40);

        //Set active button
        activeRadio = new JRadioButton();
        activeRadio.setForeground(bgColor);
        activeRadio.setBackground(new Color(154, 200, 205));
        activeRadio.setFont(font);
        activeRadio.setBounds(140,190,100,40);


        //Set salary word
        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setForeground(bgColor);
        salaryLabel.setFont(font);
        salaryLabel.setBounds(50,225,100,40);

        //Set salary textfield
        salaryField = new JTextField();
        salaryField.setBounds(140,230,150,30);

        //Set job word
        JLabel jobLabel = new JLabel("Job:");
        jobLabel.setForeground(bgColor);
        jobLabel.setFont(font);
        jobLabel.setBounds(50,265,100,40);

        //Set job text field
        jobField = new JTextField();
        jobField.setBounds(140,270,150,30);


        //Set username word
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(bgColor);
        usernameLabel.setFont(font);
        usernameLabel.setBounds(50,305,100,40);

        //Set username textfield
        usernameField = new JTextField();
        usernameField.setBounds(140,310,150,30);

        //Set password word
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(bgColor);
        passwordLabel.setFont(font);
        passwordLabel.setBounds(50,345,100,40);

        //Set password text field
        passwordField = new JTextField();
        passwordField.setBounds(140,350,150,30);


        //Set enter button
        enterButton = new JButton("Enter");
        enterButton.setForeground(bgColor);
        enterButton.setBackground(new Color(248, 246, 227));
        enterButton.setBounds(150,390,100,30);
        enterButton.setFont(font);
        enterButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String nameInput = nameField.getText();
                String phoneInput = phoneField.getText();
                String salaryInput = salaryField.getText();
                String jobInput = jobField.getText();
                String usernameInput = usernameField.getText();
                String passwordInput = passwordField.getText();
                Boolean genderInput = true;
                Boolean active = activeRadio.isSelected();
                Double salaryDouble = Double.parseDouble(salaryInput);
                if(femaleRadio.isSelected()){
                    genderInput = false;
                }

                Manager m = new Manager();
                try {
                    m.addEmployee(nameInput,genderInput,phoneInput,active,salaryDouble,jobInput);
                    JOptionPane.showMessageDialog(null, "Add employee successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    ManagerPage managerPage = new ManagerPage(person);
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error adding employee: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException(ex);
                }

            }
        });

        //SET BUTTON BACK
        JButton back = new JButton("Back");
        back.setLayout(null);
        back.setBackground(new Color(248, 246, 227));
        back.setForeground(new Color(69, 60, 103));
        back.setFont(font);
        back.setBounds(280,390,100,30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerPage managerPage = new ManagerPage(person);
                dispose();
            }
        });


        addEmployeePanel.add(back);
        addEmployeePanel.add(passwordLabel);
        addEmployeePanel.add(passwordField);
        addEmployeePanel.add(jobLabel);
        addEmployeePanel.add(jobField);
        addEmployeePanel.add(salaryLabel);
        addEmployeePanel.add(salaryField);
        addEmployeePanel.add(usernameLabel);
        addEmployeePanel.add(usernameField);
        addEmployeePanel.add(salaryField);
        addEmployeePanel.add(activeLabel);
        addEmployeePanel.add(activeRadio);
        addEmployeePanel.add(phoneLabel);
        addEmployeePanel.add(phoneField);
        addEmployeePanel.add(maleRadio);
        addEmployeePanel.add(femaleRadio);
        addEmployeePanel.add(genderLabel);
        addEmployeePanel.add(nameField);
        addEmployeePanel.add(nameLabel);
        addEmployeePanel.add(addEmLabel);
        addEmployeePanel.add(enterButton);
        MainPanel.add(addEmployeePanel);
    }

//    public static void main(String[] args) {
//        Manager manager = new Manager();
//        new AddEmployeePage(manager);
//    }
}
