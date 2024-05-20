package GUI;

import ConnectDatabase.*;
import GUI.DatePickerExample.DateLabelFormatter;
import Person.*;
import Room.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import org.jdatepicker.impl.*;
import java.util.Properties;

public class BookingPage extends BaseForm {
    public static List<Room> rooms = new ArrayList<>();
    private JPanel DeluxePanel;
    private JPanel StandardPanel;
    private JPanel SuitePanel;
    private JPanel BookingPanel;
    private JPanel inforPanel;
    private JButton enterButton;
    private JTable table;
    private Person person;

    public BookingPage(Person person) {
        super(person);
        this.person = person;

        setInforPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 100, 800, 600);
        setBackground();
        setResizable(false);
        setVisible(true);
    }

    public void setInforPanel() {
        inforPanel = new JPanel();
        inforPanel.setLayout(null);
        inforPanel.setBackground(new Color(154, 200, 205));
        inforPanel.setBounds(20, 20, 750, 470);

        Font f = new Font("Serif", Font.PLAIN, 15);

        // WORD CHECK IN
        JLabel checkIn = new JLabel("Check In Date:");
        checkIn.setFont(f);
        checkIn.setForeground(Color.BLACK);
        checkIn.setBounds(5, 5, 150, 50);

        //
        UtilDateModel model1 = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model1, p);
        JDatePickerImpl inText = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        // Đặt vị trí và kích thước cho JDatePicker
        inText.setBounds(5, 50, 110, 20);
        inforPanel.add(inText);

        // WORD NUMBER OF DAY
        JLabel numDay = new JLabel("Number Of Day:");
        numDay.setFont(f);
        numDay.setForeground(Color.BLACK);
        numDay.setBounds(140, 5, 150, 50);

        // TEXT FIELD NUMBER OF DAY
        JTextArea numDayField = new JTextArea("00");
        numDayField.setBounds(140, 50, 110, 20);
        numDayField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (numDayField.getText().equals("00")) {
                    numDayField.setText("");
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (numDayField.getText().equals("")) {
                    numDayField.setText("00");
                }

            }
        });

        // WORD NUM OF BED
        JLabel numofbed = new JLabel("Number of Bed:");
        numofbed.setFont(f);
        numofbed.setForeground(Color.BLACK);
        numofbed.setBounds(290, 5, 150, 50);

        JTextField cbbed = new JTextField("00");
        cbbed.setFont(f);
        cbbed.setForeground(Color.BLACK);
        cbbed.setBounds(250, 50, 100, 20);
        cbbed.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (cbbed.getText().equals("00")) {
                    cbbed.setText("");
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (cbbed.getText().equals("")) {
                    cbbed.setText("00");
                }

            }
        });

        // WORD TYPE OF ROOM
        JLabel typeroom = new JLabel("Room Type:");
        typeroom.setFont(f);
        typeroom.setForeground(Color.BLACK);
        typeroom.setBounds(430, 5, 150, 50);

        String room[] = { "All", "Standard Room", "Suite Room", "Deluxe Room" };
        JComboBox cbroom = new JComboBox(room);
        cbroom.setFont(f);
        cbroom.setForeground(Color.BLACK);
        cbroom.setBounds(430, 50, 130, 20);

        cbbed.setFont(f);
        cbbed.setForeground(Color.BLACK);
        cbbed.setBounds(290, 50, 100, 20);

        // SET BUTTON SEARCH
        JButton search = new JButton("Search");
        search.setLayout(null);
        search.setBackground(new Color(248, 246, 227));
        search.setForeground(new Color(69, 60, 103));
        search.setFont(new Font("Serif", Font.PLAIN, 15));
        search.setBounds(5, 80, 100, 30);

        String[] columnNames = { "Room ID", "Price", "Type", "Number of beds", "Having shower", "Furniture",
                "Electric device" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Room Room : rooms) {
            if (Room instanceof StandardRoom) {
                Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(),
                        ((StandardRoom) Room).isHavingShower() ? "Yes" : "No", "No", "No" };
                model.addRow(rowData);
            } else if (Room instanceof DeluxeRoom) {
                Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(), "Yes",
                        ((DeluxeRoom) Room).getFurniture(), "No" };
                model.addRow(rowData);
            } else {
                Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(), "Yes", "No",
                        ((SuiteRoom) Room).getElectricDevices() };
                model.addRow(rowData);
            }
        }
        table = new JTable(model);
        table.setBounds(0, 140, 750, 340);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 130, 750, 340);

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String roomType = cbroom.getSelectedItem().toString();
                String bedText = cbbed.getText() == null ? "0" : cbbed.getText();
                int bedNum = Integer.parseInt(bedText);
                List<Room> filteredRooms = filterRoomsByType(roomType, bedNum);
                updateTable(model, filteredRooms);
            }
        });

        updateTable(model, rooms);

        // WORD ENTER ID ROOM
        JLabel enterid = new JLabel("Enter Id Room:");
        enterid.setFont(f);
        enterid.setForeground(Color.BLACK);
        enterid.setBounds(140, 70, 150, 50);

        // TEXT FIELD ENTER ID
        JTextArea enterRoomIdField = new JTextArea("00");
        enterRoomIdField.setBounds(290, 85, 100, 20);
        enterRoomIdField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (enterRoomIdField.getText().equals("00")) {
                    enterRoomIdField.setText("");
                }

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (enterRoomIdField.getText().equals("")) {
                    enterRoomIdField.setText("00");
                }
            }
        });
        // SET BUTTON BOOKING
        JButton book = new JButton("Booking");
        book.setLayout(null);
        book.setBackground(new Color(248, 246, 227));
        book.setForeground(new Color(69, 60, 103));
        book.setFont(new Font("Serif", Font.PLAIN, 15));
        book.setBounds(430, 80, 100, 30);
        book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String checkInInput = inText.getJFormattedTextField().getText();
                int numDayInput = Integer.parseInt(numDayField.getText());
                int roomIdInput = Integer.parseInt(enterRoomIdField.getText());
                
                if(checkInInput.equals("") || numDayInput == 0 || roomIdInput == 0) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                    return;
                }

                QueryAll queryAll = new QueryAll(new Connector());
                Room room = queryAll.queryRoom.select(roomIdInput);
                if (room == null) {
                    JOptionPane.showMessageDialog(null, "Room not found");
                    return;
                }

                if (person instanceof Customer) {
                    ((Customer) person).bookRoom(roomIdInput, numDayInput, checkInInput);
                }
                ServicePage sp = new ServicePage(person, roomIdInput, checkInInput);
                dispose();

            }
        });

        // SET BUTTON BACK
        JButton back = new JButton("Back");
        back.setLayout(null);
        back.setBackground(new Color(248, 246, 227));
        back.setForeground(new Color(69, 60, 103));
        back.setFont(new Font("Serif", Font.PLAIN, 15));
        back.setBounds(600, 80, 100, 30);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage hp = new HomePage(person);
                dispose();
            }
        });

        inforPanel.add(enterid);
        inforPanel.add(enterRoomIdField);
        inforPanel.add(back);
        inforPanel.add(book);
        inforPanel.add(scrollPane);
        inforPanel.add(search);
        inforPanel.add(cbroom);
        inforPanel.add(cbbed);
        inforPanel.add(numofbed);
        inforPanel.add(typeroom);
        inforPanel.add(checkIn);
        inforPanel.add(numDay);
        inforPanel.add(numDayField);
        inforPanel.add(typeroom);
        MainPanel.add(inforPanel);
    }

    private static List<Room> filterRoomsByType(String type, int num_of_beds) {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        Connector connector = new Connector();
        QueryAll connectToDb = new QueryAll(connector);
        rooms = connectToDb.queryRoom.selectAll();
        rooms.forEach(System.out::println);
        if (type.equals("All")) {
            return new ArrayList<>(rooms);
        }
        if (type.equals("Standard Room")) {
            return connectToDb.queryRoom.selectStandardRoomsRS(num_of_beds);
        }
        if (type.equals("Deluxe Room")) {
            return connectToDb.queryRoom.selectDeluxeRoomsRS(num_of_beds);
        }
        if (type.equals("Suite Room")) {
            return connectToDb.queryRoom.selectSuiteRoomsRS(num_of_beds);
        }
        return null;
    }

    private static void updateTable(DefaultTableModel tableModel, List<Room> rooms) {
        tableModel.setRowCount(0);
        for (Room room : rooms) {
            if (room instanceof StandardRoom) {
                Object[] rowData = { room.getId(), room.getPrice(), room.getType(), room.getNumOfBed(),
                        ((StandardRoom) room).isHavingShower() ? "Yes" : "No", "No", "No" };
                tableModel.addRow(rowData);
            } else if (room instanceof DeluxeRoom) {
                Object[] rowData = { room.getId(), room.getPrice(), room.getType(), room.getNumOfBed(), "Yes",
                        ((DeluxeRoom) room).getFurniture(), "No" };
                tableModel.addRow(rowData);
            } else {
                Object[] rowData = { room.getId(), room.getPrice(), room.getType(), room.getNumOfBed(), "Yes", "No",
                        ((SuiteRoom) room).getElectricDevices() };
                tableModel.addRow(rowData);
            }
        }
    }

    public static void main(String[] args) {
        Customer person = new Customer();
        person.setID(6);
        new BookingPage(person);
    }
}
