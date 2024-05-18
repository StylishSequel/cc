package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServicePage extends BaseForm {
    private JPanel contentPanel;
    private JPanel cleaningPanel;
    private JPanel fruitPanel;
    private JPanel breakfastPanel;
    private JPanel laundryPanel;
    public ServicePage(){
        super();
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

        //WORD CHECK OUT
        JLabel roomlabel = new JLabel("ROOM");
        roomlabel.setForeground(new Color(69, 60, 103));
        roomlabel.setFont(new Font("Serif", Font.PLAIN, 20));
        roomlabel.setBounds(250,5,200,50);

        String roomlist[] = {"room 1", "room 2", "room 3", "room 4"};
        JComboBox roomcb = new JComboBox(roomlist);
        roomcb.setFont(new Font("Serif", Font.PLAIN, 15));
        roomcb.setForeground(Color.BLACK);
        roomcb.setBounds(330,20,100,20);

        //SET ENTER BUTTOM
        JButton enterButton = new JButton("Enter");
        enterButton.setLayout(null);
        enterButton.setBackground(new Color(248, 246, 227));
        enterButton.setForeground(new Color(69, 60, 103));
        enterButton.setFont(new Font("Serif", Font.PLAIN, 20));
        enterButton.setBounds(310,340,100,30);

        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                dispose();
            }
        });

        //SET BUTTON BACK
        JButton back = new JButton("Back");
        back.setLayout(null);
        back.setBackground(new Color(248, 246, 227));
        back.setForeground(new Color(69, 60, 103));
        back.setFont(new Font("Serif", Font.PLAIN, 20));
        back.setBounds(310,390,100,30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookingPage bookingPage = new BookingPage();
                dispose();
            }
        });

        contentPanel.add(enterButton);
        contentPanel.add(back);
        contentPanel.add(roomlabel);
        contentPanel.add(roomcb);
        MainPanel.add(contentPanel);
    }
    public void setCleaningPanel() {
        cleaningPanel = new JPanel();
        cleaningPanel.setLayout(null);
        cleaningPanel.setBounds(100, 90, 200, 180);
        cleaningPanel.setBackground(new Color(154, 200, 205));

        //SET IMAGE
        ImageIcon img = new ImageIcon("src/GUI/Images/Cleaning.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        //SET CLEANING WORDS
        JLabel cleaningLabel = new JLabel("Cleaning");
        cleaningLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        cleaningLabel.setBounds(25,140,150,20);
        cleaningLabel.setForeground(Color.BLACK);

        //SET SELECT CLEANING
        JRadioButton cleaningButton = new JRadioButton();
        cleaningButton.setBackground(new Color(154, 200, 205));
        cleaningButton.setForeground(Color.BLACK);
        cleaningButton.setBounds(150, 140, 150, 20);

        cleaningPanel.add(cleaningButton);
        cleaningPanel.add(imgLabel);
        cleaningPanel.add(cleaningLabel);
        MainPanel.add(cleaningPanel);
    }

    public void setFruitPanel() {
        fruitPanel = new JPanel();
        fruitPanel.setLayout(null);
        fruitPanel.setBounds(500, 90, 200, 180);
        fruitPanel.setBackground(new Color(154, 200, 205));

        //SET IMAGE
        ImageIcon img = new ImageIcon("src/GUI/Images/fruit.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        //SET CLEANING WORDS
        JLabel cleaningLabel = new JLabel("Fruit Daily");
        cleaningLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        cleaningLabel.setBounds(25,140,150,20);
        cleaningLabel.setForeground(Color.BLACK);

        //SET SELECT CLEANING
        JRadioButton cleaningButton = new JRadioButton();
        cleaningButton.setBackground(new Color(154, 200, 205));
        cleaningButton.setForeground(Color.BLACK);
        cleaningButton.setBounds(150, 140, 150, 20);

        fruitPanel.add(cleaningButton);
        fruitPanel.add(imgLabel);
        fruitPanel.add(cleaningLabel);
        MainPanel.add(fruitPanel);
    }

    public void setLaundryPanel (){
        laundryPanel = new JPanel();
        laundryPanel.setLayout(null);
        laundryPanel.setBounds(100, 290, 200, 180);
        laundryPanel.setBackground(new Color(154, 200, 205));

        //SET IMAGE
        ImageIcon img = new ImageIcon("src/GUI/Images/laundry.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        //SET LAUNDRY WORDS
        JLabel cleaningLabel = new JLabel("Laundry");
        cleaningLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        cleaningLabel.setBounds(25,140,150,20);
        cleaningLabel.setForeground(Color.BLACK);

        //SET SELECT LAUNDRY
        JRadioButton cleaningButton = new JRadioButton();
        cleaningButton.setBackground(new Color(154, 200, 205));
        cleaningButton.setForeground(Color.BLACK);
        cleaningButton.setBounds(150, 140, 150, 20);

        laundryPanel.add(cleaningButton);
        laundryPanel.add(imgLabel);
        laundryPanel.add(cleaningLabel);
        MainPanel.add(laundryPanel);
    }

    public void setBreakfastPanel() {
        breakfastPanel = new JPanel();
        breakfastPanel.setLayout(null);
        breakfastPanel.setBounds(500, 290, 200, 180);
        breakfastPanel.setBackground(new Color(154, 200, 205));

        //SET IMAGE
        ImageIcon img = new ImageIcon("src/GUI/Images/breakfast.jpg");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

        //SET BREAKFAST WORDS
        JLabel cleaningLabel = new JLabel("Breakfast");
        cleaningLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        cleaningLabel.setBounds(25,140,150,20);
        cleaningLabel.setForeground(Color.BLACK);

        //SET SELECT CLEANING
        JRadioButton cleaningButton = new JRadioButton();
        cleaningButton.setBackground(new Color(154, 200, 205));
        cleaningButton.setForeground(Color.BLACK);
        cleaningButton.setBounds(150, 140, 150, 20);

        breakfastPanel.add(cleaningButton);
        breakfastPanel.add(imgLabel);
        breakfastPanel.add(cleaningLabel);
        MainPanel.add(breakfastPanel);
    }


    public static void main(String[] args) {
        new ServicePage();
    }
}
