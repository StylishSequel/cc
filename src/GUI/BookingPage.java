package GUI;

import ConnectDatabase.ConnectDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingPage extends BaseForm{
    private JPanel DeluxePanel;
    private JPanel StandardPanel;
    private JPanel SuitePanel;
    private JPanel BookingPanel;


    public BookingPage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
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
    public Integer setDeluxePanel() {
        DeluxePanel = new JPanel();
        DeluxePanel.setLayout(null);
        DeluxePanel.setBounds(50, 20, 200, 350);
        DeluxePanel.setBackground(new Color(154, 200, 205));

        //SET IMAGE
        ImageIcon img = new ImageIcon("src\\GUI\\Images\\Deluxeroom1.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        //SET DELUXE ROOM WORDS
        JLabel deluxe = new JLabel("Deluxe room");
        deluxe.setFont(new Font("Serif", Font.PLAIN, 20));
        deluxe.setBounds(30,320,150,20);
        deluxe.setForeground(Color.BLACK);

        //SET NUMBER OF ROOM
        JTextField deluxeField = new JTextField("00");
        deluxeField.setBounds(150,323,30,20);
        deluxeField.setBackground(Color.WHITE);

        //Return value
        String numDeluRoom = deluxeField.getText();
        Integer num = Integer.parseInt(numDeluRoom);


        DeluxePanel.add(deluxeField);
        DeluxePanel.add(imgLabel);
        DeluxePanel.add(deluxe);
        MainPanel.add(DeluxePanel);

        return num;
    }

    //STANDARD
    public Integer setStandardPanel() {
        StandardPanel= new JPanel();
        StandardPanel.setLayout(null);
        StandardPanel.setBounds(300, 20, 200, 350);
        StandardPanel.setBackground(new Color(154, 200, 205));

        //SET IMAGE
        ImageIcon img = new ImageIcon("src/GUI/Images/Standardroom1.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        JLabel standard = new JLabel("Standard room");

        //SET STANDARD ROOM WORD
        standard.setFont(new Font("Serif", Font.PLAIN, 20));
        standard.setForeground(Color.BLACK);
        standard.setBounds(30,320,150,20);

        //SET NUMBER OF ROOM
        JTextField standardField = new JTextField("00");
        standardField.setBounds(160,323,30,20);
        standardField.setBackground(Color.WHITE);

        //Return value
        String numStandRoom = standardField.getText();
        Integer num = Integer.parseInt(numStandRoom);


        StandardPanel.add(standardField);
        StandardPanel.add(standard);
        StandardPanel.add(imgLabel);
        MainPanel.add(StandardPanel);

        return num;
    }

    //SUITE
    public Integer setSuitePanel() {
        SuitePanel = new JPanel();
        SuitePanel.setLayout(null);
        SuitePanel.setBounds(550, 20, 200, 350);
        SuitePanel.setBackground(new Color(154, 200, 205));

        //SET IMAGE
        ImageIcon img = new ImageIcon("src/GUI/Images/Suiteroom1.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        //SET SUITE ROOM WORD
        JLabel suite = new JLabel("Suite room");
        suite.setFont(new Font("Serif", Font.PLAIN, 20));
        suite.setForeground(Color.BLACK);
        suite.setBounds(50,320,150,20);

        //SET NUMBER OF ROOM
        JTextField suiteField = new JTextField("00");
        suiteField.setBounds(150,323,30,20);
        suiteField.setBackground(Color.WHITE);

        //Return value
        String numSuiteRoom = suiteField.getText();
        Integer num = Integer.parseInt(numSuiteRoom);

        SuitePanel.add(suiteField);
        SuitePanel.add(suite);
        SuitePanel.add(imgLabel);
        MainPanel.add(SuitePanel);

        return num;
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
        checkIn.setBounds(100,5,150,50);

        //TEXT FIELD CHECK IN
        JTextArea inText = new JTextArea("00/00/0000");
        inText.setBounds(100,50,100,20);

        //WORD CHECK OUT
        JLabel checkOut = new JLabel("Check Out Date:");
        checkOut.setFont(f);
        checkOut.setForeground(Color.BLACK);
        checkOut.setBounds(300,5,150,50);

        //TEXT FIELD CHECK OUT
        JTextArea outText = new JTextArea("00/00/0000");
        outText.setBounds(300,50,100,20);


        //BUTTON BOOKING
        JButton book = new JButton("Booking");
        book.setLayout(null);
        book.setBackground(new Color(225, 247, 245));
        book.setForeground(new Color(14, 70, 163));
        book.setFont(new Font("Serif", Font.PLAIN, 15));
        book.setBounds(500,40,100,30);


        //ADD
        BookingPanel.add(book);
        BookingPanel.add(outText);
        BookingPanel.add(inText);
        BookingPanel.add(checkOut);
        BookingPanel.add(checkIn);
        MainPanel.add(BookingPanel);
    }


    public static void main(String[] args) {
        new BookingPage();
    }
}
