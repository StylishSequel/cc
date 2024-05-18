package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Person.*;

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
    private Person person;

    public ManagerPage(Person person) {
        super(person);
        this.person = person;
        setChooseFunction();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setVisible(true);
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
                AddEmployeePage addEmployeePage = new AddEmployeePage(person);
                dispose();
            }
        });

        //SET REMOVE EMPLOYEE BUTTON
        JButton removeEm = setButton("REMOVE EMPLOYEE");
        removeEm.setFont(new Font("Serif", Font.PLAIN, 15));
        removeEm.setBounds(200,100,180,50);
        removeEm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteEmployeePage deleteEmployeePage = new DeleteEmployeePage(person);
                dispose();
            }
        });

        //SET ADD ROOM BUTTON
        JButton addroom = setButton("ADD ROOM");
        addroom.setFont(new Font("Serif", Font.PLAIN, 15));
        addroom.setBounds(110,170,150,50);
        addroom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddRoomPage addRoomPage = new AddRoomPage(person);
                dispose();
            }
        });
        chooseFunction.add(addroom);

        //SET BUTTON BACK
        JButton back = new JButton("Back");
        back.setLayout(null);
        back.setBackground(new Color(248, 246, 227));
        back.setForeground(new Color(69, 60, 103));
        back.setFont(new Font("Serif", Font.PLAIN, 15));
        back.setBounds(140,230,100,30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage hp = new HomePage(person);
                dispose();
            }
        });

        chooseFunction.add(back);
        chooseFunction.add(removeEm);
        chooseFunction.add(addEm);
        chooseFunction.add(managerRole);
        MainPanel.add(chooseFunction);
    }

//    public static void main(String[] args) {
//        new ManagerPage(per);
//    }

}
