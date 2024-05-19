package GUI;

import ConnectDatabase.Connector;
import ConnectDatabase.QueryCustomerRoom;
import ConnectDatabase.QueryRoomService;
import Person.*;
import Room.*;
import Service.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomerPage extends BaseForm {
    private JPanel customerPanel;
    private Person person;

    public CustomerPage(Person person) {
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
        customerPanel.setBounds(15, 20, 760, 470);

        Font fontWord = new Font("Serif", Font.PLAIN, 15);

        // SET ENTER ID LABEL
        JLabel idLabel = new JLabel("Enter ID:");
        idLabel.setFont(fontWord);
        idLabel.setForeground(Color.BLACK);
        idLabel.setBounds(25, 15, 150, 30);


        // SET ID TEXT FIELD
        JTextField idText = new JTextField();
        idText.setFont(fontWord);
        idText.setForeground(Color.BLACK);
        idText.setBounds(100, 15, 50, 30);


        // SET BOOKING SERVICES BUTTON
        JButton bookingButton = new JButton("Booking Service");
        bookingButton.setLayout(null);
        bookingButton.setBackground(new Color(248, 246, 227));
        bookingButton.setForeground(new Color(69, 60, 103));
        bookingButton.setFont(fontWord);
        bookingButton.setBounds(300, 15, 200, 30);
        bookingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                System.out.println(currentDate);
                int idInput = Integer.parseInt(idText.getText());
                if(person instanceof Manager || person instanceof Employee) {

                    ServicePage servicePage = new ServicePage(person, idInput, currentDate);
                } else {
                    ServicePage servicePage = new ServicePage(person, person.getID(), currentDate);
                }


            }
        });
        customerPanel.add(bookingButton);

        if (person instanceof Customer) {
            //SET SHOWN INFOR BUTTON
            JButton showninforButton = new JButton("Show Information");
            showninforButton.setLayout(null);
            showninforButton.setBackground(new Color(248, 246, 227));
            showninforButton.setForeground(new Color(69, 60, 103));
            showninforButton.setFont(fontWord);
            showninforButton.setBounds(25, 15, 150, 30);
            customerPanel.add(showninforButton);
            showninforButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // CREATE TABLE ROOM
                    String[] columnNames = { "Room ID", "Price", "Type", "Number of beds", "Having shower", "Furniture",
                            "Electric device", "Check In Date", "Num of Day", "Expected Check Out Date" };
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                    Connector connector = new Connector();
                    QueryCustomerRoom queryCustomerRoom = new QueryCustomerRoom(connector);
                    List<Room> roomList = queryCustomerRoom.selectCustomerRooms(person.getID());
                    for (Room Room : roomList) {
                        if (Room instanceof StandardRoom) {
                            Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(),
                                    ((StandardRoom) Room).isHavingShower() ? "Yes" : "No", "No", "No",
                                    Room.getCheck_in_date(), Room.getNumOfDay(), Room.getECheckOutDate() };
                            model.addRow(rowData);
                        } else if (Room instanceof DeluxeRoom) {
                            Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(),
                                    "Yes",
                                    ((DeluxeRoom) Room).getFurniture(), "No", Room.getCheck_in_date(),
                                    Room.getNumOfDay(), Room.getECheckOutDate() };
                            model.addRow(rowData);
                        } else {
                            Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(),
                                    "Yes", "No",
                                    ((SuiteRoom) Room).getElectricDevices(), Room.getCheck_in_date(),
                                    Room.getNumOfDay(), Room.getECheckOutDate() };
                            model.addRow(rowData);
                        }
                    }

                    // SET TABLE ROOM
                    JTable tableRoom = new JTable(model);
                    customerPanel.add(tableRoom);

                    // SET SCROLL PANE ROOM
                    JScrollPane scrollPaneRoom = new JScrollPane(tableRoom);
                    scrollPaneRoom.setBounds(10, 50, 720, 300);
                    customerPanel.add(scrollPaneRoom);

                    String[] columnServices = { "Room ID", "Service ID", "Name", "Price", "Date" };
                    QueryRoomService queryRoomService = new QueryRoomService(connector);
                    DefaultTableModel modelService = new DefaultTableModel(columnServices, 0);

                    for (Room room : roomList) {
                        List<Service> services = queryRoomService.selectCurRoomService(room.getId());

                        for (Service service : services) {
                            Object[] rowService = { room.getId(), service.getId(), service.getName(),
                                    service.getPrice(), service.getDate() };
                            modelService.addRow(rowService);
                            System.out.println("ok");
                        }
                    }

                    // SET TABLE SERVICES
                    JTable tableService = new JTable(modelService);
                    // tableService.setBounds(10,600,100,200);
                    customerPanel.add(tableService);

                    // SET SCROLL PANE SERVICES
                    JScrollPane scrollPaneServices = new JScrollPane(tableService);
                    scrollPaneServices.setBounds(10, 380, 720, 80);
                    customerPanel.add(scrollPaneServices);
                }
            });

        }

        else if (person instanceof Employee) {
            customerPanel.add(idLabel);
            customerPanel.add(idText);

            // SET ENTER BUTTON
            JButton enterButton = new JButton("Enter");
            enterButton.setLayout(null);
            enterButton.setBackground(new Color(248, 246, 227));
            enterButton.setForeground(new Color(69, 60, 103));
            enterButton.setFont(fontWord);
            enterButton.setBounds(180, 15, 100, 30);
            customerPanel.add(enterButton);
            enterButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int enterid = Integer.parseInt(idText.getText());
                    // CREATE TABLE ROOM
                    String[] columnNames = { "Room ID", "Price", "Type", "Bed", "Shower", "Furniture",
                            "Electric", "Date In", "Days", "Expected Date Out" };
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                    Connector connector = new Connector();
                    QueryCustomerRoom queryCustomerRoom = new QueryCustomerRoom(connector);
                    List<Room> roomList = queryCustomerRoom.selectCustomerRooms(enterid);
                    for (Room Room : roomList) {
                        if (Room instanceof StandardRoom) {
                            Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(),
                                    ((StandardRoom) Room).isHavingShower() ? "Yes" : "No", "No", "No",
                                    Room.getCheck_in_date(), Room.getNumOfDay(), Room.getECheckOutDate() };
                            model.addRow(rowData);
                        } else if (Room instanceof DeluxeRoom) {
                            Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(),
                                    "Yes",
                                    ((DeluxeRoom) Room).getFurniture(), "No", Room.getCheck_in_date(),
                                    Room.getNumOfDay(), Room.getECheckOutDate() };
                            model.addRow(rowData);
                        } else {
                            Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(),
                                    "Yes", "No",
                                    ((SuiteRoom) Room).getElectricDevices(), Room.getCheck_in_date(),
                                    Room.getNumOfDay(), Room.getECheckOutDate() };
                            model.addRow(rowData);
                        }
                    }

                    // SET TABLE ROOM
                    JTable tableRoom = new JTable(model);
                    // tableRoom.setBounds(10,100,700,300);
                    customerPanel.add(tableRoom);

                    // SET SCROLL PANE ROOM
                    JScrollPane scrollPaneRoom = new JScrollPane(tableRoom);
                    scrollPaneRoom.setBounds(10, 50, 720, 300);
                    customerPanel.add(scrollPaneRoom);

                    String[] columnServices = { "Room ID", "Service ID", "Name", "Price", "Date" };
                    DefaultTableModel modelService = new DefaultTableModel(columnServices, 0);
                    QueryRoomService queryRoomService = new QueryRoomService(connector);

                    for (Room room : roomList) {
                        List<Service> servicesT = queryRoomService.selectCurRoomService(room.getId());
                        for (Service service : servicesT) {
                            Object[] rowService = { room.getId(), service.getId(), service.getName(),
                                    service.getPrice(),
                                    service.getDate() };
                            modelService.addRow(rowService);
                        }

                    }

                    // SET TABLE SERVICES
                    JTable tableService = new JTable(modelService);
                    // tableService.setBounds(10,600,100,200);
                    customerPanel.add(tableService);

                    // SET SCROLL PANE SERVICES
                    JScrollPane scrollPaneServices = new JScrollPane(tableService);
                    scrollPaneServices.setBounds(10, 380, 720, 80);
                    customerPanel.add(scrollPaneServices);
                }
            });
        }

        MainPanel.add(customerPanel);
    }

    public static void main(String[] args) {
        new CustomerPage(new Customer());
    }
}
