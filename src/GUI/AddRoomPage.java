package GUI;

import ConnectDatabase.*;
import Person.Customer;
import Person.Manager;
import Person.Person;
import Room.DeluxeRoom;
import Room.StandardRoom;
import Room.SuiteRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddRoomPage extends BaseForm {
    private JTextField nameField, priceField, bedField, furnitureField, electricField;
    private JRadioButton showerRadio, activeRadio;
    private JPanel contentPanel;
    private Person person;

    public AddRoomPage(Person person) {
        super(person);
        setContentPane();
        this.person = person;
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
        contentPanel.setBounds(200, 50, 400, 430);

        Font font = new Font("Serif", Font.PLAIN, 20);
        Color bgColor = new Color(69, 60, 103);

        // SET ADD ROOM
        JLabel addRoomLabel = new JLabel("ADD ROOM");
        addRoomLabel.setForeground(new Color(69, 60, 103));
        addRoomLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        addRoomLabel.setBounds(100, 10, 250, 50);
        contentPanel.add(addRoomLabel);

        // Set word name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(bgColor);
        nameLabel.setFont(font);
        nameLabel.setBounds(50, 70, 100, 40);
        contentPanel.add(nameLabel);

        // Set text field name
        nameField = new JTextField();
        nameField.setBounds(140, 75, 150, 30);
        nameField.setForeground(new Color(69, 60, 103));
        contentPanel.add(nameField);

        // Set word PRICE
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setForeground(bgColor);
        priceLabel.setFont(font);
        priceLabel.setBounds(50, 130, 100, 40);
        contentPanel.add(priceLabel);

        // Set price textfield
        priceField = new JTextField();
        priceField.setBounds(140, 135, 150, 30);
        contentPanel.add(priceField);

        // Set active word
        JLabel activeLabel = new JLabel("Active:");
        activeLabel.setForeground(bgColor);
        activeLabel.setFont(font);
        activeLabel.setBounds(50, 180, 100, 40);
        contentPanel.add(activeLabel);

        // Set active button
        activeRadio = new JRadioButton();
        activeRadio.setForeground(bgColor);
        activeRadio.setBackground(new Color(154, 200, 205));
        activeRadio.setFont(font);
        activeRadio.setBounds(140, 185, 100, 40);
        contentPanel.add(activeRadio);

        // Set Bed word
        JLabel bedLabel = new JLabel("Bed:");
        bedLabel.setForeground(bgColor);
        bedLabel.setFont(font);
        bedLabel.setBounds(50, 230, 100, 40);
        contentPanel.add(bedLabel);

        // Set BED textfield
        bedField = new JTextField();
        bedField.setBounds(140, 235, 150, 30);
        contentPanel.add(bedField);

        // Set word furniture
        JLabel furnitureLabel = new JLabel("Furniture:");
        furnitureLabel.setForeground(bgColor);
        furnitureLabel.setFont(font);
        furnitureLabel.setBounds(50, 280, 100, 40);
        contentPanel.add(furnitureLabel);

        // Set furniture textfield
        furnitureField = new JTextField();
        furnitureField.setBounds(140, 285, 150, 30);
        contentPanel.add(furnitureField);

        // Set word electric
        JLabel electricLabel = new JLabel("Electric:");
        electricLabel.setForeground(bgColor);
        electricLabel.setFont(font);
        electricLabel.setBounds(50, 330, 100, 40);
        contentPanel.add(electricLabel);

        // Set electric textfield
        electricField = new JTextField();
        electricField.setBounds(140, 335, 150, 30);
        contentPanel.add(electricField);

        // Set shower word
        JLabel showerLabel = new JLabel("Shower:");
        showerLabel.setForeground(bgColor);
        showerLabel.setFont(font);
        showerLabel.setBounds(50, 380, 100, 40);
        contentPanel.add(showerLabel);

        // Set shower button
        showerRadio = new JRadioButton();
        showerRadio.setForeground(bgColor);
        showerRadio.setBackground(new Color(154, 200, 205));
        showerRadio.setFont(font);
        showerRadio.setBounds(140, 385, 20, 40);
        contentPanel.add(showerRadio);

        JButton enterButton = new JButton("Enter");
        enterButton.setForeground(bgColor);
        enterButton.setBackground(new Color(248, 246, 227));
        enterButton.setBounds(170, 390, 100, 30);
        enterButton.setFont(font);
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nameInput = nameField.getText();
                Double priceInput = Double.parseDouble(priceField.getText());
                Boolean activeInput = activeRadio.isSelected();
                int bedInput = Integer.parseInt(bedField.getText());

                Connector connector = new Connector();
                QueryRoom queryRoom = new QueryRoom(connector);

                Manager manager = new Manager();
                if (person instanceof Manager) {
                    manager = (Manager) person;
                }

                if (nameInput.equals("Standard")) {
                    Boolean showerInput = showerRadio.isSelected();
                    StandardRoom standardRoom = new StandardRoom(priceInput, bedInput, activeInput, nameInput,
                            showerInput);
                    // queryRoom.insert(standardRoom);

                    manager.addRoom(standardRoom);
                } else if (nameInput.equals("Suite")) {
                    String electricInput = electricField.getText();
                    SuiteRoom suiteRoom = new SuiteRoom(priceInput, bedInput, activeInput, nameInput, electricInput);
                    // queryRoom.insert(suiteRoom);

                    manager.addRoom(suiteRoom);
                } else if (nameInput.equals("Deluxe")) {
                    String furnitureInput = furnitureField.getText();
                    DeluxeRoom deluxeRoom = new DeluxeRoom(priceInput, bedInput, activeInput, nameInput,
                            furnitureInput);
                    // queryRoom.insert(deluxeRoom);

                    manager.addRoom(deluxeRoom);
                }
                HomePage homePage = new HomePage(person);
                dispose();
            }
        });
        contentPanel.add(enterButton);

        // SET BUTTON BACK
        JButton back = new JButton("Back");
        back.setLayout(null);
        back.setBackground(new Color(248, 246, 227));
        back.setForeground(new Color(69, 60, 103));
        back.setFont(font);
        back.setBounds(280, 390, 100, 30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerPage managerPage = new ManagerPage(person);
                dispose();
            }
        });

        contentPanel.add(back);

        MainPanel.add(contentPanel);
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        AddRoomPage addRoomPage = new AddRoomPage(manager);
    }
}
