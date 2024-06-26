package GUI;
import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import Person.*;


public class BaseForm extends JFrame  {
    protected JPanel MenuPanel;
    protected JPanel ContactPanel;
    protected JPanel MainPanel;
    protected JPanel BasePanel;
    protected JButton setButton;
    private JButton bookingButton;
    private JButton managerButton;
    private JButton homeButton;
    private JButton customerButton;
    private JButton employeeButton;
    private Person person;


    public BaseForm(Person person) {
        this.person = person;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setResizable(false);
        setVisible(true);
    }

    public void setBackground() {
        BasePanel = new JPanel();
        BasePanel.setLayout(null);
        BasePanel.setBounds(0, 0, 800, 600);
        setMenuPanel();
        setMainPanel();
        setcontactPanel();
        createButton();
        add(BasePanel);
  }


    public void setMainPanel() {
        MainPanel = new JPanel();
        MainPanel.setLayout(null);
        MainPanel.setBackground(new Color(248, 246, 227));
        MainPanel.setBounds(0,30,800,500);
        BasePanel.add(MainPanel);
    }


    public void setMenuPanel() {
        MenuPanel = new JPanel();
        MenuPanel.setLayout(null);
        MenuPanel.setBackground(new Color(154, 200, 205));
        MenuPanel.setBounds(0,0,800,40);
        BasePanel.add(MenuPanel);
        JLabel nameHotel = new JLabel("SHERATION HOTEL");
    
        nameHotel.setFont(new Font("Serif", Font.PLAIN, 20));
        nameHotel.setBounds(20, -5, 200, 50);
        nameHotel.setForeground(new Color(69, 60, 103));
        nameHotel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                HomePage homePage = new HomePage(person);
                dispose();
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                nameHotel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
    
        MenuPanel.add(nameHotel);
    }
    public void setcontactPanel() {
        ContactPanel = new JPanel(); // Tạo một JPanel mới là ContactPanel
        ContactPanel.setLayout(null);
        ContactPanel.setBackground(new Color(154, 200, 205));
        ContactPanel.setBounds(0, 520, 800, 50);

        JLabel phone = new JLabel("Phone number: 0946025947");
        phone.setFont(new Font("Serif", Font.BOLD, 12));
        phone.setForeground(new Color(69, 60, 103));
        phone.setBounds(10, 10, 200, 25);
        JLabel email = new JLabel("Email: hotel@gmail.com ");
        email.setFont(new Font("Serif", Font.BOLD, 12));
        email.setForeground(new Color(69, 60, 103));
        email.setBounds(650, 10, 200, 25);
        ContactPanel.add(phone);
        ContactPanel.add(email);
        BasePanel.add(ContactPanel);
    }

    //SET BUTTON CHARACTERISTICS
    public JButton setButton(String text) {
        setButton = new JButton(text);
        setButton.setLayout(null);
        setButton.setBackground(new Color(154, 200, 205));
        setButton.setForeground(new Color(69, 60, 103));
        setButton.setFont(new Font("Serif", Font.PLAIN, 18));
        setButton.setBorder(null);
        
        return setButton;
    }

    //CREATE BUTTONS
    public void createButton() {
        //HOME BUTTON
        homeButton =setButton("Home");
        homeButton.setBounds(230,0,110,40);
        homeButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                HomePage homePage = new HomePage(person);
                dispose();
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                homeButton.setBackground(new Color( 248, 246, 227));
                homeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                homeButton.setBackground(new Color(154,200,205));
            }
        });
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage(person);
                dispose();
            }
        });

        //BOOKING BUTTON
        bookingButton = setButton("Booking");
        bookingButton.setBounds(340,0,110,40);
        bookingButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                BookingPage bookingPage = new BookingPage(person);
                dispose();
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                bookingButton.setBackground(new Color( 248, 246, 227));
                bookingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                bookingButton.setBackground(new Color(154,200,205));
            }
        });
        bookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookingPage bookingPage = new BookingPage(person);
                dispose();
            }
        });

        //CUSTOMER BUTTON
        customerButton = setButton("Customer");
        customerButton.setBounds(450, 0, 110, 40);
        customerButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                CustomerPage customerPage = new CustomerPage(person);
                dispose();
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                customerButton.setBackground(new Color( 248, 246, 227));
                customerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                customerButton.setBackground(new Color(154,200,205));
            }
        });
        customerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        //EMPLOYEE BUTTON
        employeeButton = setButton("Employee");
        employeeButton.setBounds(560,0,110,40);
        employeeButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                EmployeePage em = new EmployeePage(person);
                dispose();
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                employeeButton.setBackground(new Color( 248, 246, 227));
                employeeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                employeeButton.setBackground(new Color(154,200,205));
            }
        });
        employeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Customer customer = new Customer("John Doe",true,"123456789",true);
                EmployeePage em = new EmployeePage(person);
                dispose();
            }
        });

        //MANAGER BUTTON
        managerButton = setButton("Manager");
        managerButton.setBounds(670, 0, 110, 40);
        managerButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                ManagerPage managerPage = new ManagerPage(person);
                dispose();
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                managerButton.setBackground(new Color( 248, 246, 227));
                managerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                managerButton.setBackground(new Color(154,200,205));
            }
        });
        managerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerPage managerPage = new ManagerPage(person);
                dispose();
            }
        });

        if(person instanceof Customer) {
            MenuPanel.add(customerButton);
            MenuPanel.add(bookingButton);
        } else if(person instanceof Employee) {
            MenuPanel.add(customerButton);
            if(person instanceof Manager) {
                MenuPanel.add(managerButton);
            }
            MenuPanel.add(employeeButton);
        }
        MenuPanel.add(homeButton);
    }

    public static void main(String[] args) {
        Manager manager  = new Manager();
        BaseForm frame = new BaseForm(manager);
    }
}
