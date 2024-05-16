package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import Person.Manager;
import Person.Manager.*;


public class ManagerPage extends BaseForm {
    private JPanel chooseFunction;
    private JPanel addEm;
    private JPanel newPanel;
    private JPanel removeEm;
    private JPanel addServices;
    private JPanel removeServices;
    private JTextField nameField,phoneField,salaryField,jobField;
    private JRadioButton maleRadio,femaleRadio,activeRadio;
    private JButton enterButton;
    public ManagerPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setVisible(true);
    }

    public void setBackground() {
        super.setBackground();
//        setChooseFunction();
        setAddEm();
//        setRemoveEm();
//        setAddServices();
//        setRemoveServices();
    }

//    public void setChooseFunction() {
//        chooseFunction = new JPanel();
//        chooseFunction.setLayout(null);
//        chooseFunction.setBackground(new Color(154, 200, 205));
//        chooseFunction.setBounds(200,100,400,300);
//
//        //WORD MANAGER ROLE
//        JLabel managerRole = new JLabel("MANAGER ROLE");
//        managerRole.setForeground(new Color(69, 60, 103));
//        managerRole.setFont(new Font("Serif", Font.PLAIN, 20));
//        managerRole.setBounds(120,40,200,50);
//
//        //SET ADD EMPLOYEE BUTTON
//        JButton addEm = setButton("ADD EMPLOYEE");
//        addEm.setFont(new Font("Serif", Font.PLAIN, 15));
//        addEm.setBounds(20,100,150,50);
//        addEm.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                MainPanel.removeAll();
//                setAddEm();
//                MainPanel.revalidate();
//                MainPanel.repaint();
//            }
//        });
//
//        //SET REMOVE EMPLOYEE BUTTON
//        JButton removeEm = setButton("REMOVE EMPLOYEE");
//        removeEm.setFont(new Font("Serif", Font.PLAIN, 15));
//        removeEm.setBounds(200,100,180,50);
//        removeEm.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        //SET ADD SERVICE BUTTON
//        JButton addServices = setButton("ADD SERVICES");
//        addServices.setBounds(20,200,150,50);
//        addServices.setFont(new Font("Serif", Font.PLAIN, 15));
//        addServices.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        //SET REMOVE SERVICE BUTTON
//        JButton removeServices = setButton("REMOVE SERVICES");
//        removeServices.setBounds(200,200,180,50);
//        removeServices.setFont(new Font("Serif", Font.PLAIN, 15));
//        removeServices.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//
//        chooseFunction.add(removeEm);
//        chooseFunction.add(addServices);
//        chooseFunction.add(removeServices);
//        chooseFunction.add(addEm);
//        chooseFunction.add(managerRole);
//        MainPanel.add(chooseFunction);
//    }

    public void setAddEm() {
        addEm = new JPanel();
        addEm.setLayout(null);
        addEm.setBackground(new Color(154, 200, 205));
        addEm.setBounds(200,50,400,430);

        Font font = new Font("Serif", Font.PLAIN, 20);
        Color bgColor = new Color(69, 60, 103);
        JLabel addEmLabel = new JLabel("ADD EMPLOYEE");
        addEmLabel.setForeground(new Color(69, 60, 103));
        addEmLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        addEmLabel.setBounds(80,20,250,50);

        //Set word name
        JLabel name = new JLabel("Name:");
        name.setForeground(bgColor);
        name.setFont(font);
        name.setBounds(50,95,100,40);

        //Set text field name
        nameField = new JTextField();
        nameField.setBounds(140,100,150,30);

        //Set word gender
        JLabel gender = new JLabel("Gender:");
        gender.setForeground(bgColor);
        gender.setFont(font);
        gender.setBounds(50,145,100,40);

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
        JLabel phone = new JLabel("Phone:");
        phone.setForeground(bgColor);
        phone.setFont(font);
        phone.setBounds(50,195,100,40);

        //Set phone textfield
        phoneField = new JTextField();
        phoneField.setBounds(140,200,150,30);

        //Set active word
        JLabel active = new JLabel("Active:");
        active.setForeground(bgColor);
        active.setFont(font);
        active.setBounds(50,245,100,40);

        //Set active button
        activeRadio = new JRadioButton();
        activeRadio.setForeground(bgColor);
        activeRadio.setBackground(new Color(154, 200, 205));
        activeRadio.setFont(font);
        activeRadio.setBounds(140,245,100,40);


        //Set salary word
        JLabel salary = new JLabel("Salary:");
        salary.setForeground(bgColor);
        salary.setFont(font);
        salary.setBounds(50,295,100,40);

        //Set salary textfield
        salaryField = new JTextField();
        salaryField.setBounds(140,300,150,30);

        //Set job word
        JLabel job = new JLabel("Job:");
        job.setForeground(bgColor);
        job.setFont(font);
        job.setBounds(50,345,100,40);

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
                String name = nameField.getText();
                String phone = phoneField.getText();
                String salaryText = salaryField.getText();
                String job = jobField.getText();


                Double salary = Double.parseDouble(salaryText);
                Boolean gender = false, active = activeRadio.isSelected();

                if (maleRadio.isSelected()) {
                    gender = true;
                }

                Manager manager = new Manager();
                try {
                    manager.addEmployee(name, gender, phone, active, salary, job);
                    setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        addEm.add(enterButton);
        addEm.add(job);
        addEm.add(jobField);
        addEm.add(salary);
        addEm.add(salaryField);
        addEm.add(active);
        addEm.add(activeRadio);
        addEm.add(phone);
        addEm.add(phoneField);
        addEm.add(maleRadio);
        addEm.add(femaleRadio);
        addEm.add(gender);
        addEm.add(nameField);
        addEm.add(name);
        addEm.add(addEmLabel);
        MainPanel.add(addEm);
    }


//    public JPanel createPanel(String title, String enterText ) {
//        newPanel = new JPanel();
//        newPanel.setLayout(null);
//        newPanel.setBackground(new Color(154, 200, 205));
//        newPanel.setBounds(250,100,300,300);
//
//        JLabel Label = new JLabel(title);
//        Label.setForeground(new Color(69, 60, 103));
//        Label.setFont(new Font("Serif", Font.PLAIN, 20));
//        Label.setBounds(50,20,250,50);
//
//        JLabel newLabel = new JLabel(enterText);
//        newLabel.setForeground(new Color(69, 60, 103));
//        newLabel.setFont(new Font("Serif", Font.PLAIN, 20));
//        newLabel.setBounds(130,70,250,50);
//
//        JTextField idField = new JTextField();
//        idField.setForeground(new Color(69, 60, 103));
//        idField.setFont(new Font("Serif", Font.PLAIN, 20));
//        idField.setBounds(50,120,200,30);
//
////        Set enter buttom
//        JButton enter = new JButton("Enter");
//        enter.setForeground(new Color(69, 60, 103));
//        enter.setBackground(new Color(248, 246, 227));
//        enter.setBounds(100,200,100,30);
//        enter.setFont(new Font("Serif", Font.PLAIN, 20));
//
//        newPanel.add(enter);
//        newPanel.add(idField);
//        newPanel.add(newLabel);
//        newPanel.add(Label);
//
//        return newPanel;
//    }
//
//    public void setRemoveEm() {
//        removeEm = createPanel("REMOVE EMPLOYEE","ID");
//        MainPanel.add(removeEm);
//    }
//
//    public void setAddServices() {
//        addServices = createPanel("ADD SERVICES","NAME");
//
//        MainPanel.add(addServices);
//    }
//
//    public void setRemoveServices() {
//        removeServices = createPanel("REMOVE SERVICES","ID");
//        MainPanel.add(removeServices);
//    }


    public static void main(String[] args) {
        new ManagerPage();
    }

}
