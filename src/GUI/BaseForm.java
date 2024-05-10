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
import java.util.Map;
import java.awt.font.TextAttribute;

//ConnectDatabase libary 
import ConnectDatabase.*;
import Room.*;
public class BaseForm extends JFrame {
    
    private JPanel MenuPanel;
    private JPanel ContentPanel;
    private JPanel MainPanel;

    private JButton RoomButton;
    private JButton ServiceButton;



    public BaseForm() {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        
        setBackground();
        setVisible(true);
    }
    public void setBackground() {
        MainPanel = new JPanel();
        MainPanel.setLayout(null);
        MainPanel.setBackground(new Color(176  , 211, 136));
        MainPanel.setBounds(0,0,800,600);
        add(MainPanel);
        setMenuPanel();
        setContentPanel();
        
    }
    public void setMenuPanel() {
        MenuPanel = new JPanel();
        MenuPanel.setLayout(null);
        MenuPanel.setBackground(new Color(93, 123, 111));
        MenuPanel.setBounds(0,0,200,600);
        MainPanel.add(MenuPanel);
        setButtonOfMenu();
    }
    public void setContentPanel() {
        ContentPanel = new JPanel();
        ContentPanel.setLayout(null);
        ContentPanel.setBackground(new Color(234, 231, 214));
        ContentPanel.setBounds(200,0,600,100);
        MainPanel.add(ContentPanel);
    }

    // Set Button
    public void setButtonOfMenu() {
        
        RoomButton = new JButton("Room");
        RoomButton.setBounds(0, 200, 200, 50);
        RoomButton.setBackground(new Color(93, 123, 111));
        RoomButton.setForeground(Color.WHITE);
        RoomButton.setFont(new Font("Arial", Font.BOLD, 20));
        RoomButton.setBorder(BorderFactory.createEmptyBorder());
        RoomButton.setFocusPainted(false);
        RoomButton.setIcon(new ImageIcon("src\\GUI\\Icons\\Github-Octicons-Plus-16.48.png"));
        RoomButton.setIconTextGap(20); // Set the gap to 10 pixels
        RoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContentPanel.removeAll();
                ContentPanel.revalidate();
                ContentPanel.repaint();
                // Room roomForm = new Room();
                // ContentPanel.add(roomForm);
            }
        });
        RoomButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                RoomButton.setBackground(new Color(255, 255, 255));
                RoomButton.setForeground(new Color(93, 123, 111));
            }
            public void mouseExited(MouseEvent e) {
                RoomButton.setBackground(new Color(93, 123, 111));
                RoomButton.setForeground(Color.WHITE);
            }
        });
        MenuPanel.add(RoomButton);

        ServiceButton = new JButton("Service");
        ServiceButton.setBounds(0, 250, 200, 50);
        ServiceButton.setBackground(new Color(93, 123, 111));
        ServiceButton.setForeground(Color.WHITE);
        ServiceButton.setFont(new Font("Arial", Font.BOLD, 20));
        ServiceButton.setBorder(BorderFactory.createEmptyBorder());
        ServiceButton.setFocusPainted(false);
        ServiceButton.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\CS3360\\Hotel_management\\src\\GUI\\Icons\\Aniket-Suvarna-Box-Regular-Bx-calendar-check.48.png"));
        ServiceButton.setIconTextGap(10); // Set the gap to 10 pixels
        ServiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContentPanel.removeAll();
                ContentPanel.revalidate();
                ContentPanel.repaint();
                // ServiceForm serviceForm = new ServiceForm();
                // ContentPanel.add(serviceForm);
            }
        });
        ServiceButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                ServiceButton.setBackground(new Color(255, 255, 255));
                ServiceButton.setForeground(new Color(93, 123, 111));
            }
            public void mouseExited(MouseEvent e) {
                ServiceButton.setBackground(new Color(93, 123, 111));
                ServiceButton.setForeground(Color.WHITE);
            }
        });
        MenuPanel.add(ServiceButton);
    }
    public static void main(String[] args) {
        new BaseForm();
    }
}
