package GUI;

import Person.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPage extends BaseForm{
    private JPanel customerPanel;
    private Person person;
    public CustomerPage(Person person){
        super(person);
        this.person = person;
        setCustomerPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setVisible(true);
    }

    public void setCustomerPanel() {
        customerPanel = new JPanel();
        customerPanel.setLayout(null);
        customerPanel.setBackground(new Color(154, 200, 205));
        customerPanel.setBounds(15, 20, 770, 470);

        Font fontWord = new Font("Serif", Font.PLAIN, 15);

        //SET ENTER ID
        JLabel idLabel = new JLabel("Enter ID:");
        idLabel.setFont(fontWord);
        idLabel.setForeground(Color.BLACK);
        idLabel.setBounds(25,15,150,30);

        JTextField idText = new JTextField();
        idText.setFont(fontWord);
        idText.setForeground(Color.BLACK);
        idText.setBounds(100,15,50,30);

        //SET ENTER BUTTON
        JButton enterButton = new JButton("Enter");
        enterButton.setLayout(null);
        enterButton.setBackground(new Color(248, 246, 227));
        enterButton.setForeground(new Color(69, 60, 103));
        enterButton.setFont(fontWord);
        enterButton.setBounds(180,15,100,30);

        //SET BOOKING SERVICES BUTTON
        JButton bookingButton = new JButton("Booking Service");
        bookingButton.setLayout(null);
        bookingButton.setBackground(new Color(248, 246, 227));
        bookingButton.setForeground(new Color(69, 60, 103));
        bookingButton.setFont(fontWord);
        bookingButton.setBounds(300,15,200,30);
        bookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ServicePage servicePage = new ServicePage(person);
                dispose();
            }
        });

        //WORD CHECK IN
        JLabel checkIn = new JLabel("Check In Date:");
        checkIn.setFont(fontWord);
        checkIn.setForeground(Color.BLACK);
        checkIn.setBounds(25,50,150,50);

        //WORD CHECK OUT
        JLabel checkOut = new JLabel("Check Out Date:");
        checkOut.setFont(fontWord);
        checkOut.setForeground(Color.BLACK);
        checkOut.setBounds(150,50,150,50);

        JTable tableRoom = new JTable();
        tableRoom.setBounds(25,130,530,330);

        JTable tableService = new JTable();
        tableService.setBounds(580,130,140,200);

        customerPanel.add(tableService);
        customerPanel.add(bookingButton);
        customerPanel.add(enterButton);
        customerPanel.add(tableRoom);
        customerPanel.add(checkIn);
        customerPanel.add(checkOut);
        customerPanel.add(bookingButton);
        customerPanel.add(idText);
        customerPanel.add(idLabel);
        MainPanel.add(customerPanel);
    }

//    public static void main(String[] args) {
//        new CustomerPage();
//    }
}
