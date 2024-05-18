package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import Room.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        // Tạo dữ liệu mẫu
        rooms.add(new Room("Room A", 10, "Conference"));
        rooms.add(new Room("Room B", 20, "Meeting"));
        rooms.add(new Room("Room C", 30, "Classroom"));

        // Tạo JFrame
        JFrame frame = new JFrame("Room List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout());

        String[] roomTypes = {"All", "Conference", "Meeting", "Classroom"};
        JComboBox<String> comboBox = new JComboBox<>(roomTypes);
        comboBox.setSelectedIndex(0);

        JTextField capacityField = new JTextField(10);
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Type:"));
        topPanel.add(comboBox);
        topPanel.add(new JLabel("Capacity:"));
        topPanel.add(capacityField);

        // Tạo bảng với DefaultTableModel
        String[] columnNames = {"Room Name", "Capacity", "Type"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (Room room : rooms) {
            Object[] rowData = {room.getName(), room.getCapacity()};
            tableModel.addRow(rowData);
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Thêm bảng vào JFrame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(topPanel, BorderLayout.NORTH);

        JButton searchButton = new JButton("Search");
        frame.add(searchButton, BorderLayout.SOUTH);
        searchButton.addActionListener(comboBoxSearchEvent -> {
            String selectedType = (String) comboBox.getSelectedItem();
            String capacityText = capacityField.getText();
            List<Room> filteredRooms = filterRoomsByType(selectedType, capacityText);
            updateTable(tableModel, filteredRooms);
        });

        updateTable(tableModel, rooms);

        // Hiển thị JFrame
        frame.setVisible(true);
    }

    private static List<Room> filterRoomsByType(String type, String capacityText) {
        if ("All".equals(type)) {
            return rooms;
        }
        return rooms.stream()
                .filter(room -> room.getType().equalsIgnoreCase(type)
                        && room.getCapacity() == Integer.parseInt(capacityText))
                .collect(Collectors.toList());
    }

    private static void updateTable(DefaultTableModel tableModel, List<Room> rooms) {
        tableModel.setRowCount(0); // Xóa tất cả các hàng
        for (Room room : rooms) {
            Object[] rowData = {room.getName(), room.getCapacity(), room.getType()};
            tableModel.addRow(rowData);
        }
    }
}