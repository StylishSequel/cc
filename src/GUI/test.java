//package GUI;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//
//import ConnectDatabase.Connector;
//import ConnectDatabase.QueryAll;
//
//import java.awt.*;
//import Room.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class test {
//    public static List<Room> rooms = new ArrayList<>();
//
//    public static Connector connector = new Connector();
//    public static QueryAll connectToDb = new QueryAll(connector);
//
//    public static void main(String[] args) {
//        // Tạo dữ liệu mẫu
//
//        // Tạo JFrame
//        JFrame frame = new JFrame("Room List");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 400);
//        frame.setLayout(new BorderLayout());
//
//        String[] roomTypes = { "All", "Standard Room", "Deluxe Room", "Suite Room" };
//        JComboBox<String> comboBox = new JComboBox<>(roomTypes);
//        comboBox.setSelectedIndex(0);
//
//        JTextField capacityField = new JTextField("0", 10);
//        JPanel topPanel = new JPanel();
//        topPanel.add(new JLabel("Type:"));
//        topPanel.add(comboBox);
//        topPanel.add(new JLabel("Capacity:"));
//        topPanel.add(capacityField);
//
//        // Tạo bảng với DefaultTableModel
//        String[] columnNames = { "Room ID", "Price", "Type", "Number of beds", "Having shower", "Furniture",
//                "Electric device" };
//        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
//
//        for (Room room : rooms) {
//            if (room instanceof StandardRoom) {
//                Object[] rowData = { room.getId(), room.getPrice(), room.getType(), room.getNumOfBed(),
//                        ((StandardRoom) room).isHavingShower() ? "Yes" : "No", "No", "No" };
//                tableModel.addRow(rowData);
//            } else if (room instanceof DeluxeRoom) {
//                Object[] rowData = { room.getId(), room.getPrice(), room.getType(), room.getNumOfBed(), "Yes",
//                        ((DeluxeRoom) room).getFurniture(), "No" };
//                tableModel.addRow(rowData);
//            } else {
//                Object[] rowData = { room.getId(), room.getPrice(), room.getType(), room.getNumOfBed(), "Yes", "No",
//                        ((SuiteRoom) room).getElectricDevices() };
//                tableModel.addRow(rowData);
//            }
//        }
//
//        JTable table = new JTable(tableModel);
//        JScrollPane scrollPane = new JScrollPane(table);
//
//        // Thêm bảng vào JFrame
//        frame.add(scrollPane, BorderLayout.CENTER);
//        frame.add(topPanel, BorderLayout.NORTH);
//
//        JButton searchButton = new JButton("Search");
//        frame.add(searchButton, BorderLayout.SOUTH);
//        searchButton.addActionListener(comboBoxSearchEvent -> {
//            String selectedType = (String) comboBox.getSelectedItem();
//            String capacityText = capacityField.getText() == null ? "0" : capacityField.getText();
//            int capacity = Integer.parseInt(capacityText); // Parse the capacityText string to an integer
//            List<Room> filteredRooms = filterRoomsByType(selectedType, capacity);
//            updateTable(tableModel, filteredRooms);
//        });
//
//        updateTable(tableModel, rooms);
//
//        // Hiển thị JFrame
//        frame.setVisible(true);
//    }
//
//    private static List<Room> filterRoomsByType(String type, int num_of_beds) {
//        rooms = connectToDb.queryRoom.selectAll();
//        rooms.forEach(System.out::println);
//        if (type.equals("All") && num_of_beds == 0) {
//            return new ArrayList<>(rooms);
//        }
//        if (type.equals("Standard Room")) {
//            return connectToDb.queryRoom.selectStandardRoomsRS(num_of_beds);
//        }
//        if (type.equals("Deluxe Room")) {
//            return connectToDb.queryRoom.selectDeluxeRoomsRS(num_of_beds);
//        }
//        if (type.equals("Suite Room")) {
//            return connectToDb.queryRoom.selectSuiteRoomsRS(num_of_beds);
//        }
//        return null;
//    }
//
//    private static void updateTable(DefaultTableModel tableModel, List<Room> rooms) {
//        tableModel.setRowCount(0); // Xóa tất cả các hàng
//        for (Room room : rooms) {
//            if (room instanceof StandardRoom) {
//                Object[] rowData = { room.getId(), room.getPrice(), room.getType(), room.getNumOfBed(),
//                        ((StandardRoom) room).isHavingShower() ? "Yes" : "No", "No", "No" };
//                tableModel.addRow(rowData);
//            } else if (room instanceof DeluxeRoom) {
//                Object[] rowData = { room.getId(), room.getPrice(), room.getType(), room.getNumOfBed(), "Yes",
//                        ((DeluxeRoom) room).getFurniture(), "No" };
//                tableModel.addRow(rowData);
//            } else {
//                Object[] rowData = { room.getId(), room.getPrice(), room.getType(), room.getNumOfBed(), "Yes", "No",
//                        ((SuiteRoom) room).getElectricDevices() };
//                tableModel.addRow(rowData);
//            }
//        }
//    }
//}
