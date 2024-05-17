package GUI;

import ConnectDatabase.Connector;

import javax.swing.*;
import java.awt.*;

public class BookingPage extends BaseForm{
    private JPanel DeluxePanel;
    private JPanel StandardPanel;
    private JPanel SuitePanel;
    private JPanel BookingPanel;
    private JPanel inforPanel;
    private JButton enterButton;
    private JPanel bookingPanel;
    private JTable table;



    public BookingPage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setVisible(true);
    }

    public void setBackground() {
        super.setBackground();
        setbookingPanel();
        setInforPanel();
//        setDeluxePanel();
//        setStandardPanel();
//        setSuitePanel();
//        setBookingPanel();
    }

    public void setbookingPanel() {
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(null);
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setBounds(570, 20, 200, 470);

        //Set image
        ImageIcon img = new ImageIcon("src/GUI/Images/Deluxeroom1.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());


        imagePanel.add(imgLabel);
        MainPanel.add(imagePanel);
    }


    public void setInforPanel() {
        inforPanel = new JPanel();
        inforPanel.setLayout(null);
        inforPanel.setBackground(new Color(154, 200, 205));
        inforPanel.setBounds(10, 20, 540, 470);

        Font f = new Font("Serif", Font.PLAIN, 15);


        //WORD CHECK IN
        JLabel checkIn = new JLabel("Check In Date:");
        checkIn.setFont(f);
        checkIn.setForeground(Color.BLACK);
        checkIn.setBounds(5,5,150,50);

        //TEXT FIELD CHECK IN
        JTextArea inText = new JTextArea("00/00/0000");
        inText.setBounds(5,50,100,20);

        //WORD CHECK OUT
        JLabel checkOut = new JLabel("Check Out Date:");
        checkOut.setFont(f);
        checkOut.setForeground(Color.BLACK);
        checkOut.setBounds(130,5,150,50);

        //TEXT FIELD CHECK OUT
        JTextArea outText = new JTextArea("00/00/0000");
        outText.setBounds(130,50,100,20);

        //WORD NUM OF BED
        JLabel numofbed = new JLabel("Number of Bed:");
        numofbed.setFont(f);
        numofbed.setForeground(Color.BLACK);
        numofbed.setBounds(250,5,150,50);

//        //TEXT FIELD NUM OF BED
//        JTextArea numfield = new JTextArea("00");
//        outText.setBounds(200,50,50,20);

        String str[] = {"Single bed","Double bed"};
        JComboBox cbbed = new JComboBox(str);
        cbbed.setFont(f);
        cbbed.setForeground(Color.BLACK);
        cbbed.setBounds(250,50,100,20);

        //WORD TYPE OF ROOM
        JLabel typeroom = new JLabel("Room Type:");
        typeroom.setFont(f);
        typeroom.setForeground(Color.BLACK);
        typeroom.setBounds(400,5,150,50);

        String room[] = {"Standard room","Suite room","Deluxeroom"};
        JComboBox cbroom = new JComboBox(room);
        cbroom.setFont(f);
        cbroom.setForeground(Color.BLACK);
        cbroom.setBounds(400,50,130,20);

        cbbed.setFont(f);
        cbbed.setForeground(Color.BLACK);
        cbbed.setBounds(250,50,100,20);

        table = new JTable();
        table.setBounds(5,100,530,360);

        try {
            Connector conn = new Connector();
        } catch (Exception e) {
            e.printStackTrace();
        }

        inforPanel.add(table);
        inforPanel.add(cbroom);
        inforPanel.add(cbbed);
        inforPanel.add(numofbed);
        inforPanel.add(typeroom);
        inforPanel.add(inText);
        inforPanel.add(checkOut);
        inforPanel.add(outText);
        inforPanel.add(checkIn);
        inforPanel.add(typeroom);
        MainPanel.add(inforPanel);
    }
    //DELUXE
    public Integer setDeluxePanel() {
        DeluxePanel = new JPanel();
        DeluxePanel.setLayout(null);
        DeluxePanel.setBounds(50, 20, 200, 350);
        DeluxePanel.setBackground(new Color(154, 200, 205));

        //SET IMAGE
        ImageIcon img = new ImageIcon("src/GUI/Images/Deluxeroom1.jpg");
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
//    public void setBookingPanel() {
//        BookingPanel = new JPanel();
//        BookingPanel.setLayout(null);
//        BookingPanel.setBounds(50,380,700,100);
//        BookingPanel.setBackground(new Color(154, 200, 205));
//
//        //WORD CHECK IN
//        JLabel checkIn = new JLabel("Check In Date:");
//        checkIn.setFont(f);
//        checkIn.setForeground(Color.BLACK);
//        checkIn.setBounds(100,5,150,50);
//
//        //TEXT FIELD CHECK IN
//        JTextArea inText = new JTextArea("00/00/0000");
//        inText.setBounds(100,50,100,20);
//
//        //WORD CHECK OUT
//        JLabel checkOut = new JLabel("Check Out Date:");
//        checkOut.setFont(f);
//        checkOut.setForeground(Color.BLACK);
//        checkOut.setBounds(300,5,150,50);
//
//        //TEXT FIELD CHECK OUT
//        JTextArea outText = new JTextArea("00/00/0000");
//        outText.setBounds(300,50,100,20);
//
//
//        //BUTTON BOOKING
//        JButton book = new JButton("Booking");
//        book.setLayout(null);
//        book.setBackground(new Color(225, 247, 245));
//        book.setForeground(new Color(14, 70, 163));
//        book.setFont(new Font("Serif", Font.PLAIN, 15));
//        book.setBounds(500,40,100,30);
//
//
//        //ADD
//        BookingPanel.add(book);
//        BookingPanel.add(outText);
//        BookingPanel.add(inText);
//        BookingPanel.add(checkOut);
//        BookingPanel.add(checkIn);
//        MainPanel.add(BookingPanel);
//    }


    public static void main(String[] args) {
        new BookingPage();
    }
}
