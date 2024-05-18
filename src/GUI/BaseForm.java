package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Person.*;
public class BaseForm extends JFrame  {
    protected JPanel MenuPanel;
    protected JPanel ContactPanel;
    protected JPanel MainPanel;
    protected JPanel BasePanel;
    protected JButton setButton;
    private JButton bookingButton;
    private JButton staffButton;
    private JButton homeButton;


    public BaseForm() {
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
        nameHotel.setBounds(20, -10, 200, 50);
        nameHotel.setForeground(new Color(69, 60, 103));
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
        setButton.setBackground(new Color(248, 246, 227));
        setButton.setForeground(new Color(69, 60, 103));
        setButton.setFont(new Font("Serif", Font.PLAIN, 20));
        MenuPanel.add(setButton);
        return setButton;
    }

    //CREATE BUTTONS
    public void createButton() {

        //HOME BUTTON
        homeButton =setButton("Home");
        homeButton.setBounds(310,5,100,30);
        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                dispose();
            }
        });
        MenuPanel.add(homeButton);

        //BOOKING BUTTON
        bookingButton = setButton("Booking");
        bookingButton.setBounds(420,5,120,30);
        bookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookingPage bookingPage = new BookingPage();
                dispose();
            }
        });
        MenuPanel.add(bookingButton);

        //STAFF BUTTON
        staffButton = setButton("Staff");
        staffButton.setBounds(550, 5, 100, 30);
        staffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerPage managerPage = new ManagerPage();
                dispose();
            }
        });
        MenuPanel.add(staffButton);

        //CUSTOMER BUTTON
        staffButton = setButton("Customer");
        staffButton.setBounds(660, 5, 120, 30);
        staffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerPage customerPage = new CustomerPage();
                dispose();
            }
        });
        MenuPanel.add(staffButton);
    }

    public static void main(String[] args) {
        BaseForm frame = new BaseForm();
    }
}
