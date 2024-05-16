package GUI;

import javax.swing.*;
import java.awt.*;

public class ServicePage extends BaseForm {
    private JPanel cleaningPanel;
    private JPanel laundryPanel;
    private JPanel breakfastPanel;
    private JPanel fruitPanel;
    public ServicePage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setVisible(true);
    }

    public void setBackground() {
        super.setBackground();
        setCleaningPanel();

    }

    public void setCleaningPanel() {
        cleaningPanel = new JPanel();
        cleaningPanel.setLayout(null);
        cleaningPanel.setBounds(50, 20, 200, 350);
        cleaningPanel.setBackground(new Color(154, 200, 205));

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


        cleaningPanel.add(deluxeField);
        cleaningPanel.add(imgLabel);
        cleaningPanel.add(deluxe);
        MainPanel.add(cleaningPanel);
    }



    public static void main(String[] args) {
        new ServicePage();
    }
}
