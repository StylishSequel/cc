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
import Person.*;
//ConnectDatabase libary

public class HomePage extends BaseForm {
    private JButton setButton;
    private JButton BookingButton;
    private JButton ServiceButton;
    private JButton LoginButton;
    private Person person;

    public HomePage(Person person) {
        super(person);
        this.person = person;
        setTitle("Home Page");
        createButton();
        setword();
        setImage();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setVisible(true);
    }


    public void setImage() {
        ImageIcon image = new ImageIcon("src/GUI/Images/marina-bay-vung-tau-resort-spa-24.png");
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

        //SET BUTTON LOG OUT
        JButton logout = new JButton("LOG OUT");
        logout.setLayout(null);
        logout.setBackground(new Color(248, 246, 227));
        logout.setForeground(new Color(69, 60, 103));
        logout.setFont(new Font("Serif", Font.PLAIN, 20));
        logout.setBounds(620,460,150,30);
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                dispose();
            }
        });

        MainPanel.add(logout);
        MainPanel.add(imageLabel);
    }

    public void setword() {
        JLabel welcomeWord = new JLabel("WELCOME TO OUR HOTEL");
        welcomeWord.setFont(new Font("Serif", Font.PLAIN, 40));
        welcomeWord.setBounds(150, 0, 600, 200);
        welcomeWord.setForeground(new Color(14, 70, 163));
        MainPanel.add(welcomeWord);

    }



    // public static void main(String[] args) {
    //     new HomePage();
    // }
}


