package GUI;

// import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ConnectDatabase.Connector;
import ConnectDatabase.QueryAll;

// import javax.swing.border.EmptyBorder;
// import javax.swing.event.DocumentEvent;
// import javax.swing.event.DocumentListener;
import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import Person.*;
//ConnectDatabase libary
import Room.DeluxeRoom;
import Room.Room;
import Room.StandardRoom;
import Room.SuiteRoom;

public class HomePage extends BaseForm {
    private JButton setButton;
    private JButton BookingButton;
    private JButton ServiceButton;
    private JButton LoginButton;
    private Person person;
    private JTable roomTable;

    public HomePage(Person person) {
        super(person);
        this.person = person;
        setTitle("Home Page");
        createButton();
        setword();
        setImage();
        createRoomTable();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setVisible(true);
    }

    public void setImage() {
        ImageIcon image = new ImageIcon("GUI\\Images\\marina-bay-vung-tau-resort-spa-24.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

        // SET BUTTON LOG OUT
        JButton logout = new JButton("LOG OUT");
        logout.setLayout(null);
        logout.setBackground(new Color(248, 246, 227));
        logout.setForeground(new Color(69, 60, 103));
        logout.setFont(new Font("Serif", Font.PLAIN, 20));
        logout.setBounds(620, 460, 150, 30);
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (person instanceof Customer) {
                    if (((Customer) person).getBookedRoom().size() == 0) {
                        ((Customer) person).updateStatus(false);
                    }
                    ;
                }
                Login login = new Login();
                dispose();
            }
        });

        MainPanel.add(logout);
        MainPanel.add(imageLabel);

    }

    public void setword() {
        JLabel welcomeWord = new JLabel("WELCOME TO OUR HOTEL");
        welcomeWord.setFont(new Font("Serif", Font.PLAIN, 40));
        welcomeWord.setBounds(150, 0, 600, 200);
        welcomeWord.setForeground(new Color(14, 70, 163));
        MainPanel.add(welcomeWord);
    }

    private void createRoomTable() {
        QueryAll queryAll = new QueryAll(new Connector());
        String[] columnNames = { "Customer ID", "Name", "Gender", "Phone" };
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        List<Customer> customers = queryAll.queryCustomer.selectAll();
        for (Customer customer : customers) {
            Object[] rowData = { customer.getID(), customer.getName(), customer.isGender() ? "Male" : "Female",
                    customer.getPhone() };
            tableModel.addRow(rowData);
        }

        roomTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(roomTable);
        scrollPane.setBounds(50, 150, 700, 300);
        MainPanel.add(scrollPane);
    }

    public static void main(String[] args) {
        new HomePage(new Manager());
    }
}
