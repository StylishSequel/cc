package GUI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class HomePage extends JFrame {
    private JPanel contactPanel;
    private JPanel inforPanel;
    private JPanel picturePanel;
    public HomePage() {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setContactPanel();
        setVisible(true);
    }
    public void setContactPanel() {
        contactPanel = new JPanel();
        contactPanel.setLayout(null);
        contactPanel.setBackground(new Color(120, 193, 243));
        contactPanel.setBounds(0,0,600,300);
        add(contactPanel);
    }
    public void setInforPanel() {}


}
