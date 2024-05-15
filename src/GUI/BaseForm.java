package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseForm extends JFrame {
    protected JPanel MenuPanel;
    protected JPanel ContactPanel;
    protected JPanel MainPanel;
    protected JPanel BasePanel;
    private JButton setButton;
    private JButton BookingButton;
    private JButton ServiceButton;
    private JButton LoginButton;
    private JButton HomeButton;


    public BaseForm() {
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

        setMainPanel();
        setMenuPanel();
        setcontactPanel();
        createButton();
        add(BasePanel);
  }
    public void setMainPanel() {
        MainPanel = new JPanel();
        MainPanel.setLayout(null);
        MainPanel.setBackground(new Color(248, 246, 227));
        MainPanel.setBounds(0,30,800,500);
        BasePanel.add(MainPanel);

    }

    public void setMenuPanel() {
        MenuPanel = new JPanel();
        MenuPanel.setLayout(null);
        MenuPanel.setBackground(new Color(106, 212, 221));
        MenuPanel.setBounds(0,0,800,30);
        BasePanel.add(MenuPanel);
        JLabel nameHotel = new JLabel("SHERATION HOTEL");
        nameHotel.setFont(new Font("Serif", Font.PLAIN, 20));
        nameHotel.setBounds(20, -10, 200, 50);
        nameHotel.setForeground(new Color(14, 70, 163));
        MenuPanel.add(nameHotel);

    }

    public void setcontactPanel() {
        ContactPanel = new JPanel(); // Tạo một JPanel mới là ContactPanel
        ContactPanel.setLayout(null);
        ContactPanel.setBackground(new Color(151, 231, 225));
        ContactPanel.setBounds(0, 520, 800, 50);

        JLabel phone = new JLabel("Phone number: 0946025947");
        phone.setFont(new Font("Serif", Font.BOLD, 12));
        phone.setForeground(new Color(14, 70, 163));
        phone.setBounds(10, 10, 200, 25);
        JLabel email = new JLabel("Email: hotel@gmail.com ");
        email.setFont(new Font("Serif", Font.BOLD, 12));
        email.setForeground(new Color(14, 70, 163));
        email.setBounds(650, 10, 200, 25);
        ContactPanel.add(phone);
        ContactPanel.add(email);
        BasePanel.add(ContactPanel);
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
        HomeButton =setButton("Home");
        HomeButton.setBounds(340,5,100,20);
        HomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                dispose();
            }
        });
        BookingButton = setButton("Booking");
        BookingButton.setBounds(460,5,100,20);
        BookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookingPage bookingPage = new BookingPage();
                dispose();
            }
        });
        MenuPanel.add(BookingButton);
        ServiceButton = setButton("Staff");
        ServiceButton.setBounds(580, 5, 100, 20);
        ServiceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
            }
        });
        MenuPanel.add(ServiceButton);
        LoginButton = setButton("Login");
        LoginButton.setBounds(700, 5, 80, 20);
        LoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                dispose();
            }
        });
        MenuPanel.add(LoginButton);
    }

    public static void main(String[] args) {
        BaseForm frame = new BaseForm();
    }
}
