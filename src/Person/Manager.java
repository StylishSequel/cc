package Person;


import Service.Service;
import ConnectDatabase.ConnectDatabase;
import ConnectDatabase.Connector;
import ConnectDatabase.QueryAll;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;
import Hotel.*;

public class Manager extends Employee {
    public Manager() {
        super();
    }
    public Manager(int ID, String name, boolean gender, String phone, boolean is_active, double salary,
            String job) {
        super(ID, name, gender, phone, is_active, salary, job);
    }

    public void addEmployee(String name,boolean gender, String phone,boolean is_active,double salary, String job) throws SQLException {
        Connector connector = new Connector();
        QueryAll connectToDb = new QueryAll(connector);
        Employee newEmployee = new Employee(name, gender, phone, is_active, salary, job)
        connectToDb.queryEmployee.insert(newEmployee);
    }

    public void removeEmployee(Hotel hotel) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ID");
        int ID = scanner.nextInt();
        Employee employee  = hotel.getEmployees().stream().filter(e -> e.getID() == ID).findFirst().orElse(null);
        if (employee != null) {
            hotel.getEmployees().remove(employee);
        } else {
            System.out.println("Employee not found");

        }
        scanner.close();
        // List<Employee> listE = hotel.getEmployees();
        // if (listE.isEmpty()) {
        // System.out.println("Employee list is empty");
        // return;
        // }

        // for (Employee employee : listE) {
        // if (employee.getID() == ID) {
        // // remove Employee có id = ID chứ không phải remove vị trí ID
        // // listE.remove(ID);
        // listE.remove(employee);
        // } else {
        // System.out.println("Employee not found");
        // }
        // }
        ConnectDatabase connector = new ConnectDatabase();
        connector.removeEmployee(ID);
        System.out.println("Employee removed successfully!");
        scanner.close();

    }

    public void addService(Hotel hotel) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name Service");
        String name = scanner.next();
        System.out.println("Enter Price Service");
        double price = scanner.nextDouble();

        ConnectDatabase db = new ConnectDatabase();
        Service s = db.insertService(name, price);

        List<Service> e = hotel.getServices();
        e.add(s);
        System.out.println("Service added successfully!");
        scanner.close();
    }

    public void removeService(Hotel hotel) throws SQLException {
        Connector connector = new Connector();
        QueryAll connectToDb = new QueryAll(connector);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID Service");
        int ID = scanner.nextInt();
        List<Service> e = hotel.getServices();
        Service s = e.stream().filter(service -> service.getId() == ID).findFirst().orElse(null);
        if (s != null) {
            e.remove(s);
            connectToDb.queryService.delete(s);
            System.out.println("Service removed successfully!");
        } else {
            System.out.println("Service not found!");
        }
        scanner.close();
//        for (Service s : e) {
//            if (s.getId() == ID) {
//
//
//                e.remove(s);
//                System.out.println("Service removed successfully!");
//                ConnectDatabase db = new ConnectDatabase();
//                db.removeService(ID);
//            }
//            // đặt ở đây nó in ra liên tục
//             else {
//             System.out.println("Service not found!");
//             scanner.close();
             return;
    }

}
