package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        setChooseFunction();

//        setRemoveEm();
//        setAddServices();
//        setRemoveServices();
    }

    public void setChooseFunction() {
        chooseFunction = new JPanel();
        chooseFunction.setLayout(null);
        chooseFunction.setBackground(new Color(154, 200, 205));
        chooseFunction.setBounds(200,100,400,300);

        //WORD MANAGER ROLE
        JLabel managerRole = new JLabel("MANAGER ROLE");
        managerRole.setForeground(new Color(69, 60, 103));
        managerRole.setFont(new Font("Serif", Font.PLAIN, 20));
        managerRole.setBounds(120,40,200,50);

        //SET ADD EMPLOYEE BUTTON
        JButton addEm = setButton("ADD EMPLOYEE");
        addEm.setFont(new Font("Serif", Font.PLAIN, 15));
        addEm.setBounds(20,100,150,50);
        addEm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddEmployeePage addEmployeePage = new AddEmployeePage();
            }
        });

        //SET REMOVE EMPLOYEE BUTTON
        JButton removeEm = setButton("REMOVE EMPLOYEE");
        removeEm.setFont(new Font("Serif", Font.PLAIN, 15));
        removeEm.setBounds(200,100,180,50);
        removeEm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        //SET ADD SERVICE BUTTON
        JButton addServices = setButton("ADD SERVICES");
        addServices.setBounds(20,200,150,50);
        addServices.setFont(new Font("Serif", Font.PLAIN, 15));
        addServices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        //SET REMOVE SERVICE BUTTON
        JButton removeServices = setButton("REMOVE SERVICES");
        removeServices.setBounds(200,200,180,50);
        removeServices.setFont(new Font("Serif", Font.PLAIN, 15));
        removeServices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        chooseFunction.add(removeEm);
        chooseFunction.add(addServices);
        chooseFunction.add(removeServices);
        chooseFunction.add(addEm);
        chooseFunction.add(managerRole);
        MainPanel.add(chooseFunction);
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
