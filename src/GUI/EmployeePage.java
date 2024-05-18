package GUI;
import Person.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EmployeePage  extends BaseForm{
    private JPanel contentPanel;
    public EmployeePage(Person person){
        super(person);
        setContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setResizable(false);
        setVisible(true);
    }

    public void setContentPane() {
        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(new Color(154, 200, 205));
        contentPanel.setBounds(280, 100, 200, 200);

        //WORD CHECK OUT
        JLabel checkout = new JLabel("CHECK OUT");
        checkout.setForeground(new Color(69, 60, 103));
        checkout.setFont(new Font("Serif", Font.PLAIN, 20));
        checkout.setBounds(40,10,200,50);

        //SET TEXT FIELD
        JTextArea idText = new JTextArea("Enter Customer id");
        idText.setFont(new Font("Serif", Font.PLAIN, 17));
        idText.setBounds(35,75,130,30);

        // Focus Listener
        idText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (idText.getText().equals("Enter Customer id")) {
                    idText.setText("");
                    idText.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (idText.getText().isEmpty()) {
                    idText.setText("Enter Customer id");
                    idText.setForeground(Color.BLACK);
                }
            }
        });

        //SET ENTER BUTTOM
        JButton enterButton = new JButton("Enter");
        enterButton.setLayout(null);
        enterButton.setBackground(new Color(248, 246, 227));
        enterButton.setForeground(new Color(69, 60, 103));
        enterButton.setFont(new Font("Serif", Font.PLAIN, 15));
        enterButton.setBounds(50,120,100,30);

        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                dispose();
            }
        });

        contentPanel.add(enterButton);
        contentPanel.add(idText);
        contentPanel.add(checkout);
        MainPanel.add(contentPanel);
    }

    public static void main(String[] args) {
        new EmployeePage();
    }
}
