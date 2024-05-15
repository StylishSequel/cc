package GUI;
import javax.swing.*;
import java.awt.*;

public class BaseForm extends JFrame {
    protected JPanel MenuPanel;
    protected JPanel ContactPanel;
    protected JPanel MainPanel;
    protected JPanel BasePanel;
    protected JLabel Logo;


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

        add(BasePanel);
  }
    public void setMainPanel() {
        MainPanel = new JPanel();
        MainPanel.setLayout(null);
        MainPanel.setBackground(new Color(248, 246, 227));
        MainPanel.setBounds(200,0,600,530);
        BasePanel.add(MainPanel);

    }

    public void setMenuPanel() {
        MenuPanel = new JPanel();
        MenuPanel.setLayout(null);
        MenuPanel.setBackground(new Color(106, 212, 221));
        MenuPanel.setBounds(0,0,200,600);
        BasePanel.add(MenuPanel);

    }

    public void setcontactPanel() {
        ContactPanel = new JPanel(); // Tạo một JPanel mới là ContactPanel
        ContactPanel.setLayout(null);
        ContactPanel.setBackground(new Color(151, 231, 225));
        ContactPanel.setBounds(200, 520, 600, 50);

        JLabel phone = new JLabel("Phone number: 0946025947");
        phone.setFont(new Font("Serif", Font.BOLD, 12));
        phone.setForeground(new Color(14, 70, 163));
        phone.setBounds(10, 10, 200, 25);
        JLabel email = new JLabel("Email: hotel@gmail.com ");
        email.setFont(new Font("Serif", Font.BOLD, 12));
        email.setForeground(new Color(14, 70, 163));
        email.setBounds(450, 10, 200, 25);
        ContactPanel.add(phone);
        ContactPanel.add(email);

        BasePanel.add(ContactPanel);
    }
}
