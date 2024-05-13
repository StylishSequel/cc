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
public class HomePage extends BaseForm {
    protected JButton BookingButton;
    protected JButton DiscountButton;
    protected JButton HomeButton;
    protected JButton AboutUsButton;
    protected JLabel Heading;
    protected JLabel SubHeading;

    public HomePage() {
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setBackground();
        setVisible(true);
    }
    @Override 
    public void setMenuPanel() {
        super.setMenuPanel();
        setButtonOfMenu();
    }
    // Set Button
    public void setButtonOfMenu() {
        HomeButton = new JButton("Home");
        HomeButton.setHorizontalAlignment(SwingConstants.LEFT);
        HomeButton.setBounds(0, 200, 200, 50);
        HomeButton.setBackground(new Color(93, 123, 111));
        HomeButton.setForeground(Color.WHITE);
        HomeButton.setFont(new Font("Roboto Th", Font.PLAIN, 20));
        
        HomeButton.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
        HomeButton.setIcon(new ImageIcon("cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\home_icon.png"));
        HomeButton.setFocusPainted(false);
        HomeButton.setIconTextGap(20); // Set the gap to 10 pixels
        
        
        HomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContentPanel.removeAll();
                ContentPanel.revalidate();
                
                ContentPanel.repaint();
                
            }
        });
        HomeButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                HomeButton.setBackground(new Color(255, 255, 255));
                HomeButton.setForeground(new Color(93, 123, 111));
                HomeButton.setFont(new Font("Roboto Th", Font.PLAIN, 22));
                
            }
            public void mouseExited(MouseEvent e) {
                HomeButton.setBackground(new Color(93, 123, 111));
                HomeButton.setForeground(Color.WHITE);
                HomeButton.setFont(new Font("Roboto Th", Font.PLAIN, 20));
                
            }
        });
        MenuPanel.add(HomeButton);
        
        BookingButton = new JButton("Booking");
        BookingButton.setHorizontalAlignment(SwingConstants.LEFT);
        BookingButton.setBounds(0, 250, 200, 50);
        BookingButton.setBackground(new Color(93, 123, 111));
        BookingButton.setForeground(Color.WHITE);
        BookingButton.setFont(new Font("Roboto Th", Font.PLAIN, 20));
        
        BookingButton.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
        BookingButton.setIcon(new ImageIcon("cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\Booking.png"));
        BookingButton.setFocusPainted(false);
        BookingButton.setIconTextGap(20); // Set the gap to 10 pixels
        
        BookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContentPanel.removeAll();
                ContentPanel.revalidate();
                ContentPanel.repaint();
             
            }
        });
        BookingButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                BookingButton.setBackground(new Color(255, 255, 255));
                BookingButton.setForeground(new Color(93, 123, 111));
                BookingButton.setFont(new Font("Roboto Th", Font.PLAIN, 22));
                
            }
            public void mouseExited(MouseEvent e) {
                BookingButton.setBackground(new Color(93, 123, 111));
                BookingButton.setForeground(Color.WHITE);
                BookingButton.setFont(new Font("Roboto Th", Font.PLAIN, 20));
                
            }
        });
        MenuPanel.add(BookingButton);

        DiscountButton = new JButton("Discount");
        DiscountButton.setHorizontalAlignment(SwingConstants.LEFT);
        DiscountButton.setBounds(0, 300, 200, 50);
        DiscountButton.setBackground(new Color(93, 123, 111));
        DiscountButton.setForeground(Color.WHITE);
        DiscountButton.setFont(new Font("Roboto Th", Font.PLAIN, 20));
        DiscountButton.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
        DiscountButton.setFocusPainted(false);
        DiscountButton.setIcon(new ImageIcon("cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\percent_icon.png"));
        DiscountButton.setIconTextGap(20); 
        DiscountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContentPanel.removeAll();
                ContentPanel.revalidate();
                ContentPanel.repaint();
                
            }
        });
        DiscountButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                DiscountButton.setBackground(new Color(255, 255, 255));
                DiscountButton.setForeground(new Color(93, 123, 111));
                DiscountButton.setFont(new Font("Roboto Th", Font.PLAIN, 22));
                
                
            }
            public void mouseExited(MouseEvent e) {
                DiscountButton.setBackground(new Color(93, 123, 111));
                DiscountButton.setForeground(Color.WHITE);
                
                DiscountButton.setFont(new Font("Roboto Th", Font.PLAIN, 20));
            }
        });
        MenuPanel.add(DiscountButton);


        AboutUsButton = new JButton("About Us");
        AboutUsButton.setHorizontalAlignment(SwingConstants.LEFT);
        AboutUsButton.setBounds(0, 350, 200, 50); // Adjust the position as needed
        AboutUsButton.setBackground(new Color(93, 123, 111));
        AboutUsButton.setForeground(Color.WHITE);
        AboutUsButton.setFont(new Font("Roboto Th", Font.PLAIN, 20));
        AboutUsButton.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
        AboutUsButton.setFocusPainted(false);
        AboutUsButton
                .setIcon(new ImageIcon("cc\\Hotel_management cs3360\\src\\cc\\src\\GUI\\Icons\\about_us_icon.png")); 
                                                                                                                 
        AboutUsButton.setIconTextGap(20);
        AboutUsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContentPanel.removeAll();
                ContentPanel.revalidate();
                ContentPanel.repaint();

                // Add your specific action for AboutUsButton here
            }
        });
        AboutUsButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                AboutUsButton.setBackground(new Color(255, 255, 255));
                AboutUsButton.setForeground(new Color(93, 123, 111));
                AboutUsButton.setFont(new Font("Roboto Th", Font.PLAIN, 22));
                

            }

            public void mouseExited(MouseEvent e) {
                AboutUsButton.setBackground(new Color(93, 123, 111));
                AboutUsButton.setForeground(Color.WHITE);

                AboutUsButton.setFont(new Font("Roboto Th", Font.PLAIN, 20));
            }
        });
        MenuPanel.add(AboutUsButton);
    }

    public void setContentPanel(){
        super.setContentPanel();
        Heading = new JLabel("Welcome");
        Heading.setFont(new Font("Roboto Th", Font.PLAIN, 40));
        Heading.setBounds(50, 30, 300, 30);
        Heading.setForeground(new Color(93, 123, 111));
        ContentPanel.add(Heading);

        SubHeading = new JLabel("The Knight Hotel");
        SubHeading.setFont(new Font("Roboto Th", Font.PLAIN, 15));
        SubHeading.setBounds(50, 70, 300, 30);
        SubHeading.setForeground(new Color(93, 123, 111));
        ContentPanel.add(SubHeading);

    }
    public static void main(String[] args) {
        new HomePage();
    }

}
