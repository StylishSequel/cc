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

    protected JButton BookingButton;
    protected JButton DiscountButton;
    protected JButton HomeButton;
    protected JButton AboutUsButton;

    protected JLabel Logo;



    public BaseForm() {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 600);
        
        setBackground();
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
        // Load the image from file path
        try {
            File imageFile = new File("cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Images\\du-lich-phu-quoc-mua-nao-dep-1.jpg"); // Thay "path_to_your_image.jpg" bằng đường dẫn đến tệp hình ảnh của bạn
            Image backgroundImage = ImageIO.read(imageFile);
            ImageIcon imageIcon = new ImageIcon(backgroundImage);
            JLabel backgroundLabel = new JLabel(imageIcon);
            backgroundLabel.setBounds(0, 0, 800, 600);
            BasePanel.add(backgroundLabel);
        } catch (IOException e) {
            e.printStackTrace();
            // Xử lý trường hợp khi không thể đọc hình ảnh
        }
    }
    public void setMenuPanel() {
        MenuPanel = new JPanel();
        MenuPanel.setLayout(null);
        MenuPanel.setBackground(new Color(93, 123, 111));
        MenuPanel.setBounds(0,0,200,600);
        BasePanel.add(MenuPanel);
        setButtonOfMenu();
        ImageIcon imageIcon = new ImageIcon("cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\Github-Octicons-Plus-16.48.png");
        JLabel label = new JLabel();
        label.setIcon(imageIcon);
        label.setBounds(20, 50, 200, 50);
        BasePanel.add(label);
    }
    public void setContentPanel() {
        ContentPanel = new JPanel();
        ContentPanel.setLayout(null);
        ContentPanel.setBackground(new Color(255,255, 255, 135));
        ContentPanel.setBounds(200,0,600,160);
        BasePanel.add(ContentPanel);
    }
    
    // Set Button
    public void setButtonOfMenu() {
        HomeButton = new JButton("Home");
        HomeButton.setHorizontalAlignment(SwingConstants.LEFT);
        HomeButton.setBounds(0, 150, 200, 50);
        HomeButton.setBackground(new Color(93, 123, 111));
        HomeButton.setForeground(Color.WHITE);
        HomeButton.setFont(new Font("Arial", Font.BOLD, 20));
        
        HomeButton.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
        HomeButton.setFocusPainted(false);
        // HomeButton.setIcon(new ImageIcon("C:\\Users\\x\\Desktop\\CS3360\\cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\Github-Octicons-Plus-16.48.png"));
        HomeButton.setIconTextGap(20); // Set the gap to 10 pixels
        
        HomeButton.setRolloverIcon(new ImageIcon("cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\Aniket-Suvarna-Box-Regular-Bx-calendar-check.48.png"));
        HomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContentPanel.removeAll();
                ContentPanel.revalidate();
                ContentPanel.repaint();
                // Room roomForm = new Room();
                // ContentPanel.add(roomForm);
            }
        });
        HomeButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                HomeButton.setBackground(new Color(255, 255, 255));
                HomeButton.setForeground(new Color(93, 123, 111));
                HomeButton.setFont(new Font("Arial", Font.BOLD, 25));
                // HomeButton.setIcon(new ImageIcon("C:\\Users\\x\\Desktop\\CS3360\\cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\Github-Octicons-Plus-16.48.png"));
                
            }
            public void mouseExited(MouseEvent e) {
                HomeButton.setBackground(new Color(93, 123, 111));
                HomeButton.setForeground(Color.WHITE);
                HomeButton.setFont(new Font("Arial", Font.BOLD, 20));
                HomeButton.setIcon(null);
            }
        });
        MenuPanel.add(HomeButton);
        
        BookingButton = new JButton("Booking");
        BookingButton.setHorizontalAlignment(SwingConstants.LEFT);
        BookingButton.setBounds(0, 200, 200, 50);
        BookingButton.setBackground(new Color(93, 123, 111));
        BookingButton.setForeground(Color.WHITE);
        BookingButton.setFont(new Font("Arial", Font.BOLD, 20));
        
        BookingButton.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
        BookingButton.setFocusPainted(false);
        // BookingButton.setIcon(new ImageIcon("C:\\Users\\x\\Desktop\\CS3360\\cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\Github-Octicons-Plus-16.48.png"));
        BookingButton.setIconTextGap(20); // Set the gap to 10 pixels
        
        // BookingButton.setRolloverIcon(new ImageIcon("cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\Aniket-Suvarna-Box-Regular-Bx-calendar-check.48.png"));
        BookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContentPanel.removeAll();
                ContentPanel.revalidate();
                ContentPanel.repaint();
                // Room roomForm = new Room();
                // ContentPanel.add(roomForm);
            }
        });
        BookingButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                BookingButton.setBackground(new Color(255, 255, 255));
                BookingButton.setForeground(new Color(93, 123, 111));
                BookingButton.setFont(new Font("Arial", Font.BOLD, 25));
                // BookingButton.setIcon(new ImageIcon("C:\\Users\\x\\Desktop\\CS3360\\cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\Github-Octicons-Plus-16.48.png"));
                
            }
            public void mouseExited(MouseEvent e) {
                BookingButton.setBackground(new Color(93, 123, 111));
                BookingButton.setForeground(Color.WHITE);
                BookingButton.setFont(new Font("Arial", Font.BOLD, 20));
                BookingButton.setIcon(null);
            }
        });
        MenuPanel.add(BookingButton);

        DiscountButton = new JButton("Discount");
        DiscountButton.setHorizontalAlignment(SwingConstants.LEFT);
        DiscountButton.setBounds(0, 250, 200, 50);
        DiscountButton.setBackground(new Color(93, 123, 111));
        DiscountButton.setForeground(Color.WHITE);
        DiscountButton.setFont(new Font("Arial", Font.BOLD, 20));
        // DiscountButton.setIcon(new ImageIcon("cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\Aniket-Suvarna-Box-Regular-Bx-calendar-check.48.png"));
        DiscountButton.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
        DiscountButton.setFocusPainted(false);
        
        DiscountButton.setIconTextGap(20); // Set the gap to 10 pixels
        DiscountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContentPanel.removeAll();
                ContentPanel.revalidate();
                ContentPanel.repaint();
                // ServiceForm serviceForm = new ServiceForm();
                // ContentPanel.add(serviceForm);
            }
        });
        DiscountButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                DiscountButton.setBackground(new Color(255, 255, 255));
                DiscountButton.setForeground(new Color(93, 123, 111));
                DiscountButton.setFont(new Font("Arial", Font.BOLD, 25));
                
            }
            public void mouseExited(MouseEvent e) {
                DiscountButton.setBackground(new Color(93, 123, 111));
                DiscountButton.setForeground(Color.WHITE);
                DiscountButton.setIcon(null);
                DiscountButton.setFont(new Font("Arial", Font.BOLD, 20));
            }
        });
        MenuPanel.add(DiscountButton);


        AboutUsButton = new JButton("About us");
        AboutUsButton.setHorizontalAlignment(SwingConstants.LEFT);
        AboutUsButton.setBounds(0, 300, 200, 50);
        AboutUsButton.setBackground(new Color(93, 123, 111));
        AboutUsButton.setForeground(Color.WHITE);
        AboutUsButton.setFont(new Font("Arial", Font.BOLD, 20));
        
        AboutUsButton.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
        AboutUsButton.setFocusPainted(false);
        // AboutUsButton.setIcon(new ImageIcon("C:\\Users\\x\\Desktop\\CS3360\\cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\Github-Octicons-Plus-16.48.png"));
        AboutUsButton.setIconTextGap(20); // Set the gap to 10 pixels
        
        AboutUsButton.setRolloverIcon(new ImageIcon("cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\Aniket-Suvarna-Box-Regular-Bx-calendar-check.48.png"));
        AboutUsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContentPanel.removeAll();
                ContentPanel.revalidate();
                ContentPanel.repaint();
                // Room roomForm = new Room();
                // ContentPanel.add(roomForm);
            }
        });
        AboutUsButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                AboutUsButton.setBackground(new Color(255, 255, 255));
                AboutUsButton.setForeground(new Color(93, 123, 111));
                AboutUsButton.setFont(new Font("Arial", Font.BOLD, 25));
                // AboutUsButton.setIcon(new ImageIcon("C:\\Users\\x\\Desktop\\CS3360\\cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\Github-Octicons-Plus-16.48.png"));
                
            }
            public void mouseExited(MouseEvent e) {
                AboutUsButton.setBackground(new Color(93, 123, 111));
                AboutUsButton.setForeground(Color.WHITE);
                AboutUsButton.setFont(new Font("Arial", Font.BOLD, 20));
                AboutUsButton.setIcon(null);
            }
        });
        MenuPanel.add(AboutUsButton);
    }
    public void setMainPanel() {
        MainPanel = new JPanel();
        MainPanel.setLayout(null);
        MainPanel.setBackground(new Color(0,0, 0, 195));
        MainPanel.setBounds(200,160,600,440);
        BasePanel.add(MainPanel);
    }
    public static void main(String[] args) {
        new BaseForm();
    }
}
