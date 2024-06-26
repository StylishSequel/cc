package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

import ConnectDatabase.*;
import Person.*;
public class DeleteEmployeePage extends BaseForm{
    private JPanel contentPanel;
    private Person person;
    public DeleteEmployeePage(Person person){
        super(person);
        this.person = person;
        setContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setResizable(false);
        setVisible(true);
    }

    public void setContentPane() {
        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(new Color(154, 200, 205));
        contentPanel.setBounds(280, 100, 200, 200);

        //WORD DELETE EMPLOYEE
        JLabel checkout = new JLabel("DELETE EMPLOYEE");
        checkout.setForeground(new Color(69, 60, 103));
        checkout.setFont(new Font("Serif", Font.PLAIN, 20));
        checkout.setBounds(10,10,200,50);

        //SET TEXT FIELD
        JTextArea idText = new JTextArea("Enter Employee Id");
        idText.setFont(new Font("Serif", Font.PLAIN, 17));
        idText.setBounds(35,75,130,30);

        // Focus Listener
        idText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (idText.getText().equals("Enter Employee Id")) {
                    idText.setText("");
                    idText.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (idText.getText().isEmpty()) {
                    idText.setText("Enter Employee Id");
                    idText.setForeground(Color.BLACK);
                }
            }
        });

        //SET ENTER BUTTOM
        JButton enterButton = new JButton("Enter");
        enterButton.setLayout(null);
        enterButton.setBackground(new Color(248, 246, 227));
        enterButton.setForeground(new Color(69, 60, 103));
        enterButton.setFont(new Font("Serif", Font.PLAIN, 20));
        enterButton.setBounds(50,120,100,30);

        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer idInput = Integer.parseInt(idText.getText());
                Manager m = new Manager();
                try {
                    ConnectDatabase connectDatabase = new ConnectDatabase();
                    Connector connector = new Connector();
                    QueryAll queryAll = new QueryAll(connector);
                    Employee employee = queryAll.queryEmployee.select(idInput);

                    if(employee != null) {
                        m.removeEmployee(idInput);

                        JOptionPane.showMessageDialog(null, "Delete employee successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        Login login = new Login();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, " Id not found: " , "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //SET BUTTON BACK
        JButton back = new JButton("Back");
        back.setLayout(null);
        back.setBackground(new Color(248, 246, 227));
        back.setForeground(new Color(69, 60, 103));
        back.setFont(new Font("Serif", Font.PLAIN, 20));
        back.setBounds(50,160,100,30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerPage managerPage = new ManagerPage(person);
                dispose();
            }
        });

        contentPanel.add(back);
        contentPanel.add(enterButton);
        contentPanel.add(idText);
        contentPanel.add(checkout);
        MainPanel.add(contentPanel);
    }
}
