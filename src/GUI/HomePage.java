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
        setImage();
    }


    public JButton setButton(String text) {
        setButton = new JButton(text);
        setButton.setLayout(null);
        setButton.setBackground(new Color(225, 247, 245));
        setButton.setForeground(new Color(14, 70, 163));
        setButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        MenuPanel.add(setButton);
        return setButton;
    }

    public void createButton() {
        BookingButton = setButton("Booking");
        BookingButton.setBounds(50,200,100,30);
        BookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        MenuPanel.add(BookingButton);
        ServiceButton = setButton("Service");
        ServiceButton.setBounds(50, 250, 100, 30);
        ServiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        MenuPanel.add(ServiceButton);
        LoginButton = setButton("Login");
        LoginButton.setBounds(50, 300, 100, 30);
        LoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {}
        });
        MenuPanel.add(LoginButton);
    }

    public void setImage() {
        ImageIcon image = new ImageIcon("src/GUI/Images/hotel.jpg");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(200, 0, image.getIconWidth(), image.getIconHeight());
        MainPanel.add(imageLabel);
    }


    public static void main(String[] args) {
        new HomePage();
    }
}


