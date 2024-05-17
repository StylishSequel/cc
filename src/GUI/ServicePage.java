package GUI;

import javax.swing.*;
import java.awt.*;

public class ServicePage extends BaseForm {
    private JPanel mainPanel;
    public ServicePage() {
        setMainPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setVisible(true);
    }

    public void setBackground() {
        super.setBackground();
    }

    public void setMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(50, 50, 600, 400);
        mainPanel.setBackground(new Color(154, 200, 205));


        MainPanel.add(mainPanel);
    }
//    public void setCleaningPanel() {
//        cleaningPanel = new JPanel();
//        cleaningPanel.setLayout(null);
//        cleaningPanel.setBounds(50, 100, 200, 180);
//        cleaningPanel.setBackground(new Color(154, 200, 205));
//
//        //SET IMAGE
//        ImageIcon img = new ImageIcon("src/GUI/Images/Cleaning.jpg");
//        JLabel imgLabel = new JLabel(img);
//        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
//
//        //SET CLEANING WORDS
//        JLabel cleaningLabel = new JLabel("Cleaning");
//        cleaningLabel.setFont(new Font("Serif", Font.PLAIN, 20));
//        cleaningLabel.setBounds(25,140,150,20);
//        cleaningLabel.setForeground(Color.BLACK);
//
//        //SET SELECT CLEANING
//        JRadioButton cleaningButton = new JRadioButton();
//        cleaningButton.setBackground(new Color(154, 200, 205));
//        cleaningButton.setForeground(Color.BLACK);
//        cleaningButton.setBounds(150, 140, 150, 20);
//
//        cleaningPanel.add(cleaningButton);
//        cleaningPanel.add(imgLabel);
//        cleaningPanel.add(cleaningLabel);
//        MainPanel.add(cleaningPanel);
//    }
//
//    public void setFruitPanel() {
//        fruitPanel = new JPanel();
//        fruitPanel.setLayout(null);
//        fruitPanel.setBounds(400, 100, 200, 180);
//        fruitPanel.setBackground(new Color(154, 200, 205));
//
//        //SET IMAGE
//        ImageIcon img = new ImageIcon("src/GUI/Images/fruit.jpg");
//        JLabel imgLabel = new JLabel(img);
//        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
//
//        //SET CLEANING WORDS
//        JLabel cleaningLabel = new JLabel("Fruit Daily");
//        cleaningLabel.setFont(new Font("Serif", Font.PLAIN, 20));
//        cleaningLabel.setBounds(25,140,150,20);
//        cleaningLabel.setForeground(Color.BLACK);
//
//        //SET SELECT CLEANING
//        JRadioButton cleaningButton = new JRadioButton();
//        cleaningButton.setBackground(new Color(154, 200, 205));
//        cleaningButton.setForeground(Color.BLACK);
//        cleaningButton.setBounds(150, 140, 150, 20);
//
//        fruitPanel.add(cleaningButton);
//        fruitPanel.add(imgLabel);
//        fruitPanel.add(cleaningLabel);
//        MainPanel.add(fruitPanel);
//    }
//
//    public void setLaundryPanel (){
//        laundryPanel = new JPanel();
//        laundryPanel.setLayout(null);
//        laundryPanel.setBounds(50, 300, 200, 180);
//        laundryPanel.setBackground(new Color(154, 200, 205));
//
//        //SET IMAGE
//        ImageIcon img = new ImageIcon("src/GUI/Images/laundry.jpg");
//        JLabel imgLabel = new JLabel(img);
//        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
//
//        //SET LAUNDRY WORDS
//        JLabel cleaningLabel = new JLabel("Laundry");
//        cleaningLabel.setFont(new Font("Serif", Font.PLAIN, 20));
//        cleaningLabel.setBounds(25,140,150,20);
//        cleaningLabel.setForeground(Color.BLACK);
//
//        //SET SELECT LAUNDRY
//        JRadioButton cleaningButton = new JRadioButton();
//        cleaningButton.setBackground(new Color(154, 200, 205));
//        cleaningButton.setForeground(Color.BLACK);
//        cleaningButton.setBounds(150, 140, 150, 20);
//
//        laundryPanel.add(cleaningButton);
//        laundryPanel.add(imgLabel);
//        laundryPanel.add(cleaningLabel);
//        MainPanel.add(laundryPanel);
//    }
//
//    public void setBreakfastPanel() {
//        breakfastPanel = new JPanel();
//        breakfastPanel.setLayout(null);
//        breakfastPanel.setBounds(400, 300, 200, 180);
//        breakfastPanel.setBackground(new Color(154, 200, 205));
//
//        //SET IMAGE
//        ImageIcon img = new ImageIcon("src/GUI/Images/breakfast.jpg");
//        JLabel imgLabel = new JLabel(img);
//        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
//
//        //SET BREAKFAST WORDS
//        JLabel cleaningLabel = new JLabel("Breakfast");
//        cleaningLabel.setFont(new Font("Serif", Font.PLAIN, 20));
//        cleaningLabel.setBounds(25,140,150,20);
//        cleaningLabel.setForeground(Color.BLACK);
//
//        //SET SELECT CLEANING
//        JRadioButton cleaningButton = new JRadioButton();
//        cleaningButton.setBackground(new Color(154, 200, 205));
//        cleaningButton.setForeground(Color.BLACK);
//        cleaningButton.setBounds(150, 140, 150, 20);
//
//        breakfastPanel.add(cleaningButton);
//        breakfastPanel.add(imgLabel);
//        breakfastPanel.add(cleaningLabel);
//        MainPanel.add(breakfastPanel);
//    }


    public static void main(String[] args) {
        new ServicePage();
    }
}
