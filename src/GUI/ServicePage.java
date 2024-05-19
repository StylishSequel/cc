package GUI;

import ConnectDatabase.*;
import GUI.DatePickerExample.DateLabelFormatter;
import Person.*;
import Room.*;
import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

public class ServicePage extends BaseForm {
    private List<Room> rooms;
    private int room_id;
    private JPanel contentPanel;
    private JPanel cleaningPanel;
    private JPanel fruitPanel;
    private JPanel breakfastPanel;
    private JPanel laundryPanel;
    private Person person;
    private JRadioButton cleanButton, fruitButton, breakfastButton, laundryButton;
    private String check_in_date;
    private JTextField roomIdField;
    private JTextField checkInDateField;

    public ServicePage(Person person, int room_id, String check_in_date) {
        super(person);
        this.room_id = room_id;
        this.person = person;
        this.check_in_date = check_in_date;
        setCleaningPanel();
        setFruitPanel();
        setBreakfastPanel();
        setLaundryPanel();
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
        contentPanel.setBounds(40, 20, 700, 450);

        // WORD CHECK OUT
        JLabel roomlabel = new JLabel("SERVICES");
        roomlabel.setForeground(new Color(69, 60, 103));
        roomlabel.setFont(new Font("Serif", Font.PLAIN, 20));
        roomlabel.setBounds(310, 5, 200, 50);

        // SET ENTER BUTTOM
        JButton enterButton = new JButton("Enter");
        enterButton.setLayout(null);
        enterButton.setBackground(new Color(248, 246, 227));
        enterButton.setForeground(new Color(69, 60, 103));
        enterButton.setFont(new Font("Serif", Font.PLAIN, 20));
        enterButton.setBounds(310, 340, 100, 30);

        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Boolean cleaningInput = cleanButton.isSelected();
                Boolean fruitInput = fruitButton.isSelected();
                Boolean breakfastInput = breakfastButton.isSelected();
                Boolean laundryInput = laundryButton.isSelected();

                Connector connector = new Connector();
                QueryRoomService queryRoomService = new QueryRoomService(connector);
                QueryAll queryAll = new QueryAll(connector);

                if (person instanceof Customer) {

                    room_id = Integer.parseInt(roomIdField.getText());
                    check_in_date = checkInDateField.getText();
                    System.out.println(person.getID());

                    rooms = ((Customer) person).getBookedRoom(room_id);
                } else {

                    rooms = queryAll.queryCustomer.select(room_id)
                            .getBookedRoom(Integer.parseInt(roomIdField.getText()));
                    room_id = Integer.parseInt(roomIdField.getText());
                    check_in_date = checkInDateField.getText();
                    System.out.println(room_id);
                }

                if (rooms.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Room ID is not valid");
                    return;
                }

                Room room = rooms.get(0);
                LocalDate bookedDate = LocalDate.parse(check_in_date);
                LocalDate eCheckOutDate = LocalDate.parse(room.getECheckOutDate());
                LocalDate checkInDate = LocalDate.parse(room.getCheck_in_date());
                if (bookedDate.isAfter(eCheckOutDate) || bookedDate.isBefore(checkInDate)) {
                    JOptionPane.showMessageDialog(null,
                            "Cannot book service after expected check out date and bofore check in date");
                    return;
                }

                if (cleaningInput) {
                    room.bookService(1, check_in_date);
                }
                if (fruitInput) {
                    room.bookService(2, check_in_date);
                }
                if (breakfastInput) {
                    room.bookService(3, check_in_date);
                }
                if (laundryInput) {
                    room.bookService(4, check_in_date);
                }
                HomePage homePage = new HomePage(person);
                dispose();
            }
        });

        // SET BUTTON BACK
        JButton back = new JButton("Back");
        back.setLayout(null);
        back.setBackground(new Color(248, 246, 227));
        back.setForeground(new Color(69, 60, 103));
        back.setFont(new Font("Serif", Font.PLAIN, 20));
        back.setBounds(310, 390, 100, 30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookingPage bookingPage = new BookingPage(person);
                dispose();
            }
        });

        JLabel roomIdLabel = new JLabel("Room ID:");
        roomIdLabel.setBounds(300, 290, 90, 30);
        roomIdLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        roomIdField = new JTextField(String.valueOf(room_id));
        roomIdField.setBounds(380, 290, 50, 30);

        JLabel checkInLabel = new JLabel("Date:");
        checkInLabel.setBounds(300, 240, 90, 30);
        checkInLabel.setFont(new Font("Serif", Font.PLAIN, 18));
        checkInDateField = new JTextField(String.valueOf(check_in_date));
        checkInDateField.setBounds(350, 240, 80, 30);

        contentPanel.add(enterButton);
        contentPanel.add(back);
        contentPanel.add(roomlabel);
        contentPanel.add(roomIdLabel);
        contentPanel.add(roomIdField);
        contentPanel.add(checkInLabel);
        contentPanel.add(checkInDateField);
        MainPanel.add(contentPanel);
    }

    public void setCleaningPanel() {
        cleaningPanel = new JPanel();
        cleaningPanel.setLayout(null);
        cleaningPanel.setBounds(100, 90, 200, 180);
        cleaningPanel.setBackground(new Color(154, 200, 205));

        // SET IMAGE
        ImageIcon img = new ImageIcon("cc/src/GUI/Images/Cleaning.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        // SET CLEANING WORDS
        JLabel cleaningLabel = new JLabel("Cleaning");
        cleaningLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        cleaningLabel.setBounds(25, 140, 150, 20);
        cleaningLabel.setForeground(Color.BLACK);

        // SET SELECT CLEANING
        cleanButton = new JRadioButton();
        cleanButton.setBackground(new Color(154, 200, 205));
        cleanButton.setForeground(Color.BLACK);
        cleanButton.setBounds(150, 140, 150, 20);

        cleaningPanel.add(cleanButton);
        cleaningPanel.add(imgLabel);
        cleaningPanel.add(cleaningLabel);
        MainPanel.add(cleaningPanel);
    }

    public void setFruitPanel() {
        fruitPanel = new JPanel();
        fruitPanel.setLayout(null);
        fruitPanel.setBounds(500, 90, 200, 180);
        fruitPanel.setBackground(new Color(154, 200, 205));

        // SET IMAGE
        ImageIcon img = new ImageIcon("cc/src/GUI/Images/fruit.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        // SET CLEANING WORDS
        JLabel cleaningLabel = new JLabel("Fruit Daily");
        cleaningLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        cleaningLabel.setBounds(25, 140, 150, 20);
        cleaningLabel.setForeground(Color.BLACK);

        // SET SELECT CLEANING
        fruitButton = new JRadioButton();
        fruitButton.setBackground(new Color(154, 200, 205));
        fruitButton.setForeground(Color.BLACK);
        fruitButton.setBounds(150, 140, 150, 20);

        fruitPanel.add(fruitButton);
        fruitPanel.add(imgLabel);
        fruitPanel.add(cleaningLabel);
        MainPanel.add(fruitPanel);
    }

    public void setLaundryPanel() {
        laundryPanel = new JPanel();
        laundryPanel.setLayout(null);
        laundryPanel.setBounds(100, 290, 200, 180);
        laundryPanel.setBackground(new Color(154, 200, 205));

        // SET IMAGE
        ImageIcon img = new ImageIcon("cc/src/GUI/Images/laundry.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        // SET LAUNDRY WORDS
        JLabel cleaningLabel = new JLabel("Laundry");
        cleaningLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        cleaningLabel.setBounds(25, 140, 150, 20);
        cleaningLabel.setForeground(Color.BLACK);

        // SET SELECT LAUNDRY
        laundryButton = new JRadioButton();
        laundryButton.setBackground(new Color(154, 200, 205));
        laundryButton.setForeground(Color.BLACK);
        laundryButton.setBounds(150, 140, 150, 20);

        laundryPanel.add(laundryButton);
        laundryPanel.add(imgLabel);
        laundryPanel.add(cleaningLabel);
        MainPanel.add(laundryPanel);
    }

    public void setBreakfastPanel() {
        breakfastPanel = new JPanel();
        breakfastPanel.setLayout(null);
        breakfastPanel.setBounds(500, 290, 200, 180);
        breakfastPanel.setBackground(new Color(154, 200, 205));

        // SET IMAGE
        ImageIcon img = new ImageIcon("cc/src/GUI/Images/breakfast.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        // SET BREAKFAST WORDS
        JLabel cleaningLabel = new JLabel("Breakfast");
        cleaningLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        cleaningLabel.setBounds(25, 140, 150, 20);
        cleaningLabel.setForeground(Color.BLACK);

        // SET SELECT BREAKFAST
        breakfastButton = new JRadioButton();
        breakfastButton.setBackground(new Color(154, 200, 205));
        breakfastButton.setForeground(Color.BLACK);
        breakfastButton.setBounds(150, 140, 150, 20);

        breakfastPanel.add(breakfastButton);
        breakfastPanel.add(imgLabel);
        breakfastPanel.add(cleaningLabel);
        MainPanel.add(breakfastPanel);
    }

    public static void main(String[] args) {
        Customer person1 = new Customer();
        person1.setID(6);
        new ServicePage(person1, 100, "2024-06-03");
    }
}
