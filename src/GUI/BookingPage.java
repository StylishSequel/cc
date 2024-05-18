package GUI;

import ConnectDatabase.*;
import Person.*;
import Room.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class BookingPage extends BaseForm{
    public static List<Room> rooms = new ArrayList<>();
    private JPanel DeluxePanel;
    private JPanel StandardPanel;
    private JPanel SuitePanel;
    private JPanel BookingPanel;
    private JPanel inforPanel;
    private JButton enterButton;
    private JTable table;
    private Person person;



    public BookingPage(Person person){
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


        //WORD CHECK IN
        JLabel checkIn = new JLabel("Check In Date:");
        checkIn.setFont(f);
        checkIn.setForeground(Color.BLACK);
        checkIn.setBounds(5,5,150,50);

        //TEXT FIELD CHECK IN
        JTextArea inText = new JTextArea("0000-00-00");
        inText.setBounds(5,50,100,20);

        //WORD NUMBER OF DAY
        JLabel numDay = new JLabel("Number Of Day:");
        numDay.setFont(f);
        numDay.setForeground(Color.BLACK);
        numDay.setBounds(130,5,150,50);

        //TEXT FIELD NUMBER OF DAY
        JTextArea numDayField = new JTextArea("00");
        numDayField.setBounds(130,50,100,20);

        //WORD NUM OF BED
        JLabel numofbed = new JLabel("Number of Bed:");
        numofbed.setFont(f);
        numofbed.setForeground(Color.BLACK);
        numofbed.setBounds(250,5,150,50);

//        //TEXT FIELD NUM OF BED
//        JTextArea numfield = new JTextArea("00");
//        outText.setBounds(200,50,50,20);


        JTextField cbbed = new JTextField("1 or 2");
        cbbed.setFont(f);
        cbbed.setForeground(Color.BLACK);
        cbbed.setBounds(250,50,100,20);

        //WORD TYPE OF ROOM
        JLabel typeroom = new JLabel("Room Type:");
        typeroom.setFont(f);
        typeroom.setForeground(Color.BLACK);
        typeroom.setBounds(400,5,150,50);

        String room[] = {"All", "Standard Room","Suite Room","Deluxe Room"};
        JComboBox cbroom = new JComboBox(room);
        cbroom.setFont(f);
        cbroom.setForeground(Color.BLACK);
        cbroom.setBounds(400,50,130,20);

        cbbed.setFont(f);
        cbbed.setForeground(Color.BLACK);
        cbbed.setBounds(250,50,100,20);

        //SET BUTTON SEARCH
        JButton search = new JButton("Search");
        search.setLayout(null);
        search.setBackground(new Color(248, 246, 227));
        search.setForeground(new Color(69, 60, 103));
        search.setFont(new Font("Serif", Font.PLAIN, 15));
        search.setBounds(5,80,100,30);

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
        table.setBounds(5,130,700,330);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 130, 700, 330);

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

        //WORD ENTER ID ROOM
        JLabel enterid = new JLabel("Enter Id Room:");
        enterid.setFont(f);
        enterid.setForeground(Color.BLACK);
        enterid.setBounds(130,70,150,50);

        //TEXT FIELD ENTER ID
        JTextArea enterRoomIdField = new JTextArea("00");
        enterRoomIdField.setBounds(250,85,100,20);

        //SET BUTTON BOOKING
        JButton book = new JButton("Booking");
        book.setLayout(null);
        book.setBackground(new Color(248, 246, 227));
        book.setForeground(new Color(69, 60, 103));
        book.setFont(new Font("Serif", Font.PLAIN, 15));
        book.setBounds(400,80,100,30);
        book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String checkInInput = inText.getText();
                int numDayInput = Integer.parseInt(numDayField.getText());
                int roomIdInput = Integer.parseInt(enterRoomIdField.getText());

                if (person instanceof Customer) {
                    ((Customer) person).bookRoom(roomIdInput, numDayInput, checkInInput);
                }
                    ServicePage sp = new ServicePage(person, roomIdInput);
                    dispose();

            }
        });

        //SET BUTTON BACK
        JButton back = new JButton("Back");
        back.setLayout(null);
        back.setBackground(new Color(248, 246, 227));
        back.setForeground(new Color(69, 60, 103));
        back.setFont(new Font("Serif", Font.PLAIN, 15));
        back.setBounds(600,80,100,30);
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
        inforPanel.add(inText);
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

//    public static void main(String[] args) {
//        new BookingPage(person);
//    }
}
