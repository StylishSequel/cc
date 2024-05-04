package Person;

import ConnectDatabase.ConnectDatabase;
import Service.Service;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;
import Hotel.*;

public class Manager extends Employee {
    public Manager(int ID, String name, boolean gender, String phone, boolean is_active, int unitTask, double salary,
            String job) {
        super(ID, name, gender, phone, is_active, salary, job);
    }

    public void addEmployee(Hotel hotel) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter gender");
        boolean gender = scanner.nextBoolean();
        System.out.println("Enter phone");
        String phone = scanner.next();
        System.out.println("Enter status");
        boolean is_active = scanner.nextBoolean();
        System.out.println("Enter salary");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter job");
        String job = scanner.nextLine();

        ConnectDatabase connector = new ConnectDatabase();
        Employee e = connector.insertEmployee(name, gender, phone, is_active, salary, job);

        hotel.getEmployees().add(e);
        System.out.println("Employee added successfully!");
        scanner.close();
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID Service");
        int ID = scanner.nextInt();
        List<Service> e = hotel.getServices();
        Service s = e.stream().filter(service -> service.getId() == ID).findFirst().orElse(null);
        if (s != null) {
            e.remove(s);
            ConnectDatabase db = new ConnectDatabase();
            db.removeService(ID);
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
