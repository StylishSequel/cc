package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeePage extends BaseForm {

    private JPanel addEmployeePanel;
    private JTextField nameField,phoneField,salaryField,jobField;
    private JRadioButton maleRadio,femaleRadio,activeRadio;
    private JButton enterButton;

    public AddEmployeePage(){
        setAddEmployeePanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setVisible(true);
    }

    public void setBackground() {
        super.setBackground();
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
        addEmLabel.setBounds(80,20,250,50);

        //Set word name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(bgColor);
        nameLabel.setFont(font);
        nameLabel.setBounds(50,95,100,40);

        //Set text field name
        nameField = new JTextField();
        nameField.setBounds(140,100,150,30);
        nameField.setForeground(new Color(69, 60, 103));


        //Set word gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setForeground(bgColor);
        genderLabel.setFont(font);
        genderLabel.setBounds(50,145,100,40);

        //Set gender button
        maleRadio = new JRadioButton("Male");
        maleRadio.setForeground(bgColor);
        maleRadio.setBackground(new Color(154, 200, 205));
        maleRadio.setFont(font);
        maleRadio.setBounds(140,145,100,40);

        femaleRadio = new JRadioButton("Female");
        femaleRadio.setForeground(bgColor);
        femaleRadio.setBackground(new Color(154, 200, 205));
        femaleRadio.setFont(font);
        femaleRadio.setBounds(250,145,100,40);

        ButtonGroup group = new ButtonGroup();
        group.add(maleRadio);
        group.add(femaleRadio);

        //Set word phone
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(bgColor);
        phoneLabel.setFont(font);
        phoneLabel.setBounds(50,195,100,40);

        //Set phone textfield
        phoneField = new JTextField();
        phoneField.setBounds(140,200,150,30);

        //Set active word
        JLabel activeLabel = new JLabel("Active:");
        activeLabel.setForeground(bgColor);
        activeLabel.setFont(font);
        activeLabel.setBounds(50,245,100,40);

        //Set active button
        activeRadio = new JRadioButton();
        activeRadio.setForeground(bgColor);
        activeRadio.setBackground(new Color(154, 200, 205));
        activeRadio.setFont(font);
        activeRadio.setBounds(140,245,100,40);


        //Set salary word
        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setForeground(bgColor);
        salaryLabel.setFont(font);
        salaryLabel.setBounds(50,295,100,40);

        //Set salary textfield
        salaryField = new JTextField();
        salaryField.setBounds(140,300,150,30);

        //Set job word
        JLabel jobLabel = new JLabel("Job:");
        jobLabel.setForeground(bgColor);
        jobLabel.setFont(font);
        jobLabel.setBounds(50,345,100,40);

        //Set job text field
        jobField = new JTextField();
        jobField.setBounds(140,350,150,30);



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

                System.out.println(nameInput);
                System.out.println(phoneInput);
                System.out.println(salaryInput);
                System.out.println(jobInput);
            }
        });

        addEmployeePanel.add(jobLabel);
        addEmployeePanel.add(jobField);
        addEmployeePanel.add(salaryLabel);
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

    public static void main(String[] args) {
        new AddEmployeePage();
    }
}
