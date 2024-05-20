package Person;

import Service.Service;
import ConnectDatabase.ConnectDatabase;
import ConnectDatabase.Connector;
import ConnectDatabase.QueryAll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;
import Hotel.*;
import Room.Room;
import Room.StandardRoom;

public class Manager extends Employee {
    private QueryAll queryAll = new QueryAll(new Connector());
    public Manager() {
        super();
    }

    public Manager(int ID, String name, boolean gender, String phone, boolean is_active, double salary,
            String job) {
        super(ID, name, gender, phone, is_active, salary, job);
    }

    public void addEmployee(String name, boolean gender, String phone, boolean is_active, double salary, String job)
            throws SQLException {
        Connector connector = new Connector();
        QueryAll connectToDb = new QueryAll(connector);
        Employee newEmployee = new Employee(name, gender, phone, is_active, salary, job);
        connectToDb.queryEmployee.insert(newEmployee);
    }

    public void addRoom(Room room) {
        queryAll.queryRoom.insert(room);
    }

    public void removeEmployee(int ID) throws SQLException {
        ConnectDatabase connector = new ConnectDatabase();
        connector.removeEmployee(ID);
        System.out.println("Employee removed successfully!");
    }
}
