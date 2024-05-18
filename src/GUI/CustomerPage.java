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
import java.util.List;


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
        customerPanel.setBounds(15, 20, 760, 470);

        Font fontWord = new Font("Serif", Font.PLAIN, 15);

        if(person instanceof Customer) {
            //SET BOOKING SERVICES BUTTON
            JButton bookingButton = new JButton("Booking Service");
            bookingButton.setLayout(null);
            bookingButton.setBackground(new Color(248, 246, 227));
            bookingButton.setForeground(new Color(69, 60, 103));
            bookingButton.setFont(fontWord);
            bookingButton.setBounds(300,15,200,30);
            bookingButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(person instanceof Employee) {
                        ServicePage servicePage = new ServicePage(person,person.getID());
                        dispose();
                    } else {
                        ServicePage servicePage = new ServicePage(person,person.getID());
                        dispose();
                    }
                }
            });
            customerPanel.add(bookingButton);
            //SET SHOWN INFOR BUTTON
            JButton showninforButton = new JButton("Show Information");
            showninforButton.setLayout(null);
            showninforButton.setBackground(new Color(248, 246, 227));
            showninforButton.setForeground(new Color(69, 60, 103));
            showninforButton.setFont(fontWord);
            showninforButton.setBounds(25,15,150,30);
            customerPanel.add(showninforButton);
            showninforButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //CREATE TABLE ROOM
                    String[] columnNames = { "Room ID", "Price", "Type", "Number of beds", "Having shower", "Furniture",
                            "Electric device","Check In Date", "Num of Day", "Expected Check Out Date"};
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                    Connector connector = new Connector();
                    QueryCustomerRoom queryCustomerRoom = new QueryCustomerRoom(connector);
                    List<Room> roomList = queryCustomerRoom.selectCustomerRooms(person.getID());
                    for (Room Room : roomList) {
                        if (Room instanceof StandardRoom) {
                            Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(),
                                    ((StandardRoom) Room).isHavingShower() ? "Yes" : "No", "No", "No", Room.getCheck_in_date(), Room.getNumOfDay(), Room.getECheckOutDate()};
                            model.addRow(rowData);
                        } else if (Room instanceof DeluxeRoom) {
                            Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(), "Yes",
                                    ((DeluxeRoom) Room).getFurniture(), "No", Room.getCheck_in_date(), Room.getNumOfDay(), Room.getECheckOutDate() };
                            model.addRow(rowData);
                        } else {
                            Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(), "Yes", "No",
                                    ((SuiteRoom) Room).getElectricDevices(),Room.getCheck_in_date(), Room.getNumOfDay(), Room.getECheckOutDate() };
                            model.addRow(rowData);
                        }
                    }

                    //SET TABLE ROOM
                    JTable tableRoom = new JTable(model);
//                tableRoom.setBounds(10,100,700,300);
                    customerPanel.add(tableRoom);

                    //SET SCROLL PANE ROOM
                    JScrollPane scrollPaneRoom = new JScrollPane(tableRoom);
                    scrollPaneRoom.setBounds(10, 50, 720, 300);
                    customerPanel.add(scrollPaneRoom);


                    String[] columnServices = { "Room ID", "Name","Price","Date"};
                    QueryRoomService queryRoomService = new QueryRoomService(connector);
                    List<Service> services = queryRoomService.selectCurRoomService(person.getID());
                    DefaultTableModel modelService = new DefaultTableModel(columnServices, 0);

                    for(Service service : services) {
                        Object[] rowService = {service.getId(), service.getName(), service.getPrice(),service.getDate()};
                        modelService.addRow(rowService);
                    }
                    //SET TABLE SERVICES
                    JTable tableService = new JTable(modelService);
//                tableService.setBounds(10,600,100,200);
                    customerPanel.add(tableService);

                    //SET SCROLL PANE SERVICES
                    JScrollPane scrollPaneServices = new JScrollPane(tableService);
                    scrollPaneServices.setBounds(10, 380, 720, 80);
                    customerPanel.add(scrollPaneServices);
                }
            });

        }

        else if(person instanceof Employee) {
            //SET ENTER ID LABEL
            JLabel idLabel = new JLabel("Enter ID:");
            idLabel.setFont(fontWord);
            idLabel.setForeground(Color.BLACK);
            idLabel.setBounds(25,15,150,30);
            customerPanel.add(idLabel);

            //SET ID TEXT FIELD
            JTextField idText = new JTextField();
            idText.setFont(fontWord);
            idText.setForeground(Color.BLACK);
            idText.setBounds(100,15,50,30);
            customerPanel.add(idText);

            //SET ENTER BUTTON
            JButton enterButton = new JButton("Enter");
            enterButton.setLayout(null);
            enterButton.setBackground(new Color(248, 246, 227));
            enterButton.setForeground(new Color(69, 60, 103));
            enterButton.setFont(fontWord);
            enterButton.setBounds(180,15,100,30);
            customerPanel.add(enterButton);
            enterButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int enterid = Integer.parseInt(idText.getText());
                    //CREATE TABLE ROOM
                    String[] columnNames = { "Room ID", "Price", "Type", "Number of beds", "Having shower", "Furniture",
                            "Electric device","Check In Date", "Num of Day", "Expected Check Out Date"};
                    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                    Connector connector = new Connector();
                    QueryCustomerRoom queryCustomerRoom = new QueryCustomerRoom(connector);
                    List<Room> roomList = queryCustomerRoom.selectCustomerRooms(enterid);
                    for (Room Room : roomList) {
                        if (Room instanceof StandardRoom) {
                            Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(),
                                    ((StandardRoom) Room).isHavingShower() ? "Yes" : "No", "No", "No", Room.getCheck_in_date(), Room.getNumOfDay(), Room.getECheckOutDate()};
                            model.addRow(rowData);
                        } else if (Room instanceof DeluxeRoom) {
                            Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(), "Yes",
                                    ((DeluxeRoom) Room).getFurniture(), "No", Room.getCheck_in_date(), Room.getNumOfDay(), Room.getECheckOutDate() };
                            model.addRow(rowData);
                        } else {
                            Object[] rowData = { Room.getId(), Room.getPrice(), Room.getType(), Room.getNumOfBed(), "Yes", "No",
                                    ((SuiteRoom) Room).getElectricDevices(),Room.getCheck_in_date(), Room.getNumOfDay(), Room.getECheckOutDate() };
                            model.addRow(rowData);
                        }
                    }

                    //SET TABLE ROOM
                    JTable tableRoom = new JTable(model);
//                tableRoom.setBounds(10,100,700,300);
                    customerPanel.add(tableRoom);

                    //SET SCROLL PANE ROOM
                    JScrollPane scrollPaneRoom = new JScrollPane(tableRoom);
                    scrollPaneRoom.setBounds(10, 50, 720, 300);
                    customerPanel.add(scrollPaneRoom);


                    String[] columnServices = { "Room ID", "Name","Price","Date"};
                    QueryRoomService queryRoomService = new QueryRoomService(connector);
                    List<Service> services = queryRoomService.selectCurRoomService(enterid);
                    DefaultTableModel modelService = new DefaultTableModel(columnServices, 0);

                    for(Service service : services) {
                        Object[] rowService = {service.getId(), service.getName(), service.getPrice(),service.getDate()};
                        modelService.addRow(rowService);
                    }
                    //SET TABLE SERVICES
                    JTable tableService = new JTable(modelService);
//                tableService.setBounds(10,600,100,200);
                    customerPanel.add(tableService);

                    //SET SCROLL PANE SERVICES
                    JScrollPane scrollPaneServices = new JScrollPane(tableService);
                    scrollPaneServices.setBounds(10, 380, 720, 80);
                    customerPanel.add(scrollPaneServices);


                    //SET BOOKING SERVICES BUTTON
                    JButton bookingButton = new JButton("Booking Service");
                    bookingButton.setLayout(null);
                    bookingButton.setBackground(new Color(248, 246, 227));
                    bookingButton.setForeground(new Color(69, 60, 103));
                    bookingButton.setFont(fontWord);
                    bookingButton.setBounds(300,15,200,30);
                    bookingButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if(person instanceof Employee) {
                                int enterid = Integer.parseInt(idText.getText());
                                ServicePage servicePage = new ServicePage(person,enterid);
                                dispose();
                            } else {
                                ServicePage servicePage = new ServicePage(person,person.getID());
                                dispose();
                            }
                        }
                    });
                    customerPanel.add(bookingButton);
                }
            });
        }



        MainPanel.add(customerPanel);
    }

//    public static void main(String[] args) {
//        new CustomerPage();
//    }
}
