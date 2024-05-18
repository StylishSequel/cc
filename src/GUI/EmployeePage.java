package GUI;
import ConnectDatabase.Connector;
import ConnectDatabase.QueryAll;
import ConnectDatabase.QueryRoom;
import Person.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import Room.*;
public class EmployeePage  extends BaseForm{
    private JPanel contentPanel;
    private Person person;


    public EmployeePage(Person person){
        super(person);
        this.person = person;
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
        contentPanel.setBounds(280, 100, 200, 250);

        //WORD CHECK OUT
        JLabel checkout = new JLabel("CHECK OUT");
        checkout.setForeground(new Color(69, 60, 103));
        checkout.setFont(new Font("Serif", Font.PLAIN, 20));
        checkout.setBounds(40,10,200,50);

        //SET TEXT FIELD
        JTextArea idText = new JTextArea("Enter Customer id");
        idText.setFont(new Font("Serif", Font.PLAIN, 17));
        idText.setBounds(35,75,130,30);


        //SET TEXT FIELD
        JTextArea roomidText = new JTextArea("Enter Room id");
        roomidText.setFont(new Font("Serif", Font.PLAIN, 17));
        roomidText.setBounds(35,120,130,30);
        contentPanel.add(roomidText);

        roomidText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (roomidText.getText().equals("Enter Customer id")) {
                    roomidText.setText("");
                    roomidText.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (roomidText.getText().isEmpty()) {
                    roomidText.setText("Enter Customer id");
                    roomidText.setForeground(Color.BLACK);
                }
            }
        });

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

        //Set Total Bill word
        JLabel billLabel = new JLabel("Total Bill:");
        billLabel.setForeground(new Color(69, 60, 103));
        billLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        billLabel.setBounds(35,150,100,40);
        contentPanel.add(billLabel);


        //SET ENTER BUTTOM
        JButton enterButton = new JButton("Enter");
        enterButton.setLayout(null);
        enterButton.setBackground(new Color(248, 246, 227));
        enterButton.setForeground(new Color(69, 60, 103));
        enterButton.setFont(new Font("Serif", Font.PLAIN, 15));
        enterButton.setBounds(50,200,100,30);

        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idText.getText());
                int roomid = Integer.parseInt(roomidText.getText());
                Connector connector = new Connector();
                QueryAll queryAll = new QueryAll(connector);

                //Set price
                QueryRoom queryRoom = new QueryRoom(connector);
                Customer customer = queryAll.queryCustomer.select(id);
                double price = customer.checkOut(roomid);
                String roomPrice = String.valueOf(price);
                JLabel bill = new JLabel(roomPrice);
                bill.setForeground(new Color(69, 60, 103));
                bill.setFont(new Font("Serif", Font.PLAIN, 15));
                bill.setBounds(100,150,100,40);
                contentPanel.add(bill);

                HomePage homePage = new HomePage(person);
                dispose();
            }
        });

        contentPanel.add(enterButton);
        contentPanel.add(idText);
        contentPanel.add(checkout);
        MainPanel.add(contentPanel);
    }

//    public static void main(String[] args) {
//        new EmployeePage();
//    }
}
