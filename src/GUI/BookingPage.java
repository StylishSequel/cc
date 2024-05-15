package GUI;

import javax.swing.*;
import java.awt.*;

public class BookingPage extends BaseForm{
    private JPanel DeluxePanel;
    private JPanel StandardPanel;
    private JPanel SuitePanel;
    private JPanel BookingPanel;


    public BookingPage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setVisible(true);
    }
    public void setBackground() {
        super.setBackground();
        setDeluxePanel();
        setStandardPanel();
        setSuitePanel();
        setBookingPanel();


    }

    //DELUXE
    public void setDeluxePanel() {
        DeluxePanel = new JPanel();
        DeluxePanel.setLayout(null);
        DeluxePanel.setBounds(50, 20, 200, 350);
        DeluxePanel.setBackground(Color.WHITE);
        ImageIcon img = new ImageIcon("src/GUI/Images/Deluxeroom1.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        JLabel deluxe = new JLabel("Deluxe room");
        deluxe.setFont(new Font("Serif", Font.PLAIN, 20));
        deluxe.setBounds(50,320,150,20);
        deluxe.setForeground(new Color(14, 70, 163));

        JTextField deluxeField = new JTextField("00");
        deluxeField.setBounds(200,320,150,20);


        DeluxePanel.add(imgLabel);
        DeluxePanel.add(deluxe);
        MainPanel.add(DeluxePanel);
    }

    //STANDARD
    public void setStandardPanel() {
        StandardPanel= new JPanel();
        StandardPanel.setLayout(null);
        StandardPanel.setBounds(300, 20, 200, 350);
        StandardPanel.setBackground(Color.WHITE);
        ImageIcon img = new ImageIcon("src/GUI/Images/Standardroom1.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        JLabel standard = new JLabel("Standard room");
        standard.setFont(new Font("Serif", Font.PLAIN, 20));
        standard.setForeground(new Color(14, 70, 163));
        standard.setBounds(50,320,150,20);
        StandardPanel.add(standard);
        StandardPanel.add(imgLabel);
        MainPanel.add(StandardPanel);
    }

    //SUITE
    public void setSuitePanel() {
        SuitePanel = new JPanel();
        SuitePanel.setLayout(null);
        SuitePanel.setBounds(550, 20, 200, 350);
        SuitePanel.setBackground(Color.WHITE);
        ImageIcon img = new ImageIcon("src/GUI/Images/Suiteroom1.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        JLabel suite = new JLabel("Suite room");
        suite.setFont(new Font("Serif", Font.PLAIN, 20));
        suite.setForeground(new Color(14, 70, 163));
        suite.setBounds(50,320,150,20);
        SuitePanel.add(suite);
        SuitePanel.add(imgLabel);
        MainPanel.add(SuitePanel);
    }


    //BOOKING
    public void setBookingPanel() {
        Font f = new Font("Serif", Font.PLAIN, 15);
        BookingPanel = new JPanel();
        BookingPanel.setLayout(null);
        BookingPanel.setBounds(50,380,700,100);
        BookingPanel.setBackground(new Color(154, 200, 205));

        //WORD CHECK IN
        JLabel checkIn = new JLabel("Check In Date:");
        checkIn.setFont(f);
        checkIn.setForeground(Color.BLACK);
        checkIn.setBounds(20,5,150,50);

        //TEXT FIELD CHECK IN
        JTextArea inText = new JTextArea("00/00/0000");
        inText.setBounds(20,50,100,20);

        //WORD CHECK OUT
        JLabel checkOut = new JLabel("Check Out Date:");
        checkOut.setFont(f);
        checkOut.setForeground(Color.BLACK);
        checkOut.setBounds(140,5,150,50);

        //TEXT FIELD CHECK OUT
        JTextArea outText = new JTextArea("00/00/0000");
        outText.setBounds(140,50,100,20);

        //WORD ROOM
        JLabel room = new JLabel("Room:");
        room.setFont(f);
        room.setBounds(280,5,150,50);
        room.setForeground(Color.BLACK);

        //TEXT FIELD ROOM
        JTextArea roomText = new JTextArea("00");
        roomText.setBounds(280,50,50,20);

        //WORD ADULT
        JLabel adults = new JLabel("Adult:");
        adults.setFont(f);
        adults.setBounds(380,5,150,50);
        adults.setForeground(Color.BLACK);

        //TEXT FIELD ADULT
        JTextArea adultText = new JTextArea("00");
        adultText.setBounds(380,50,50,20);

        //WORD CHILDREN
        JLabel children = new JLabel("Children:");
        children.setFont(f);
        children.setBounds(480,10,150,50);
        children.setForeground(Color.BLACK);

        //TEXT FIELD CHILDREN
        JTextArea childText = new JTextArea("00");
        childText.setBounds(480,50,50,20);

        //BUTTON BOOKING
        JButton book = new JButton("Booking");
        book.setLayout(null);
        book.setBackground(new Color(225, 247, 245));
        book.setForeground(new Color(14, 70, 163));
        book.setFont(new Font("Serif", Font.PLAIN, 15));
        book.setBounds(580,40,100,30);

        //ADD
        BookingPanel.add(book);
        BookingPanel.add(outText);
        BookingPanel.add(adultText);
        BookingPanel.add(childText);
        BookingPanel.add(roomText);
        BookingPanel.add(inText);
        BookingPanel.add(children);
        BookingPanel.add(room);
        BookingPanel.add(adults);
        BookingPanel.add(checkOut);
        BookingPanel.add(checkIn);
        MainPanel.add(BookingPanel);
    }


    public static void main(String[] args) {
        new BookingPage();
    }
}
