package Person;
import ConnectDatabase.ConnectDatabase;
import Service.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Hotel.*;

public class Manager extends Employee {
    public Manager(int ID, String name, boolean gender, String phone, boolean is_active, int unitTask, double salary, String job){
        super(ID, name, gender, phone, is_active, salary, job);
    }
    public void addEmployee(Hotel hotel) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter gender");
        boolean gender = scanner.nextBoolean();
        System.out.println("Enter phone");
        String phone = scanner.next();
        System.out.println("Enter status");
        boolean is_active = scanner.nextBoolean();
        System.out.println("Enter salary");
        double salary = scanner.nextDouble();
        System.out.println("Enter job");
        String job = scanner.next();

        ConnectDatabase connector = new ConnectDatabase();
        Employee e = connector.insertEmployee(name,gender,phone,is_active,salary,job);
        hotel.getEmployees().add(e);
        System.out.println("Employee added successfully!");
    }

    public void removeEmployee(Hotel hotel) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter ID");
        int ID = scanner.nextInt();

        List<Employee> listE = hotel.getEmployees();
        if(e.isEmpty()) {
            System.out.println("Employee list is empty");
            return;
        }

        for(Employee employee : listE) {
            if(employee.getID() == ID) {
                // remove Employee có id = ID chứ không phải remove vị trí ID
                // listE.remove(ID);
                listE.remove(employee);
                ConnectDatabase connector = new ConnectDatabase();
                connector.removeEmployee(ID);
            }
            else {
                System.out.println("Employee not found");
            }
        }

    }

    public void addService(Hotel hotel) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name Service");
        String name = scanner.next();
        System.out.println("Enter Price Service");
        double price = scanner.nextDouble();

        ConnectDatabase db = new ConnectDatabase();
        Service s = db.insertService(name,price);
        List<Service> e = hotel.getServices();
        e.add(s);
        System.out.println("Service added successfully!");
    }

    public void removeService(Hotel hotel) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID Service");
        int ID = scanner.nextInt();
        List<Service> e = hotel.getServices();
        for(Service s : e) {
            if(s.getId() == ID) {
                e.remove(ID);
                System.out.println("Service removed successfully!");
                ConnectDatabase db = new ConnectDatabase();
                db.removeService(ID);
            }
            // đặt ở đây nó in ra liên tục
            // else {
            //     System.out.println("Service not found!");
            //     return;
            // }
        }
        System.out.println("Service not found!");
    }
}
