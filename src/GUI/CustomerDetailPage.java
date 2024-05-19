package GUI;

import ConnectDatabase.Connector;
import ConnectDatabase.QueryAll;
import Person.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CustomerDetailPage extends BaseForm{
    private JPanel contentPane;
    private Person person;
    private JTable roomTable;

    public CustomerDetailPage(Person person){
        super(person);
        createRoomTable();
        this.person = person;

    }

    private void createRoomTable() {
        QueryAll queryAll = new QueryAll(new Connector());
        String[] columnNames = { "Customer ID", "Name", "Gender", "Phone" };
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        List<Customer> customers = queryAll.queryCustomer.selectAll();
        for (Customer customer : customers) {
            Object[] rowData = { customer.getID(), customer.getName(), customer.isGender() ? "Male" : "Female",
                    customer.getPhone() };
            tableModel.addRow(rowData);
        }

        roomTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(roomTable);
        scrollPane.setBounds(40, 50, 700, 300);
        MainPanel.add(scrollPane);
    }

    public static void main(String[] args) {
        Manager manager  = new Manager();
        CustomerDetailPage newcus = new CustomerDetailPage(manager);
    }

}
