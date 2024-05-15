package GUI;
// import javax.swing.border.Border;
import javax.swing.*;
// import javax.swing.border.EmptyBorder;
// import javax.swing.event.DocumentEvent;
// import javax.swing.event.DocumentListener;
import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.awt.event.*;

//ConnectDatabase libary

public class HomePage extends BaseForm {
    private JButton setButton;
    private JButton BookingButton;
    private JButton ServiceButton;
    private JButton LoginButton;


    public HomePage() {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setBackground();
        setVisible(true);
    }
    public void setBackground() {
        super.setBackground();
        createButton();
        setword();
        setImage();
    }

    public void setImage() {
        ImageIcon image = new ImageIcon("src/GUI/Images/marina-bay-vung-tau-resort-spa-24.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        MainPanel.add(imageLabel);
    }

    public void setword() {
        JLabel welcomeWord = new JLabel("WELCOME TO OUR HOTEL");
        welcomeWord.setFont(new Font("Serif", Font.PLAIN, 40));
        welcomeWord.setBounds(150, 0, 600, 200);
        welcomeWord.setForeground(new Color(14, 70, 163));
        MainPanel.add(welcomeWord);

    }



    public static void main(String[] args) {
        new HomePage();
    }
}


