package GUI;
import javax.imageio.ImageIO;
import java.io.*;
// import javax.swing.border.Border;
import javax.swing.*;
// import javax.swing.border.EmptyBorder;
// import javax.swing.event.DocumentEvent;
// import javax.swing.event.DocumentListener;
import java.net.URL;
import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Map;
import java.awt.font.TextAttribute;

//ConnectDatabase libary 
import ConnectDatabase.*;
import Room.*;
public class BaseForm extends JFrame {
    
    protected JPanel MenuPanel;
    protected JPanel ContentPanel;
    protected JPanel MainPanel;
    protected JPanel BasePanel;

    protected JLabel Logo;
    



    public BaseForm() {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 600);
        
        setBackground();
        setResizable(false);
        setVisible(true);
    }
    public void setBackground() {
        BasePanel = new JPanel();
        BasePanel.setLayout(null);
        
        BasePanel.setBounds(0, 0, 800, 600);
    
        
    
        add(BasePanel);
        setMenuPanel();
        setContentPanel();
        setMainPanel();
        setLogo();
        
    }
    public void setMenuPanel() {
        MenuPanel = new JPanel();
        MenuPanel.setLayout(null);
        MenuPanel.setBackground(new Color(93, 123, 111));
        MenuPanel.setBounds(0,0,200,600);
        BasePanel.add(MenuPanel);
        
        
        
    }
    public void setContentPanel() {
        ContentPanel = new JPanel();
        ContentPanel.setLayout(null);
        ContentPanel.setBackground(new Color(234,231, 214,144));
        ContentPanel.setBounds(200,0,600,100);
        BasePanel.add(ContentPanel);
        
    }
    public void setLogo(){
        try {
            Logo = new JLabel();
            Logo.setBounds(-25, 0, 180, 180);
            ImageIcon originalIcon = new ImageIcon("src\\GUI\\Icons\\jwrffo0t.png");
            Image originalImage = originalIcon.getImage();
            int newWidth = originalIcon.getIconWidth() / 2;
            int newHeight = originalIcon.getIconHeight() / 2;
            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            Logo.setIcon(scaledIcon);
            MenuPanel.add(Logo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setMainPanel() {
        MainPanel = new JPanel();
        MainPanel.setLayout(null);
        MainPanel.setBackground(new Color(34,231, 214,144));
        MainPanel.setBounds(200,100,600,500);
        
        BasePanel.add(MainPanel);
        
        
    }
    public static void main(String[] args) {
        new BaseForm();
    }
}
