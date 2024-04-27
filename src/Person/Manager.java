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
    public Manager(int ID, String name, boolean gender, String phone, boolean status, int unitTask, double salary, String job){
        super(ID, name, gender, phone, status, unitTask, salary, job);
    }
    public void addEmployee(Hotel hotel) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID");
        int ID = scanner.nextInt();
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter gender");
        boolean gender = scanner.nextBoolean();
        System.out.println("Enter phone");
        String phone = scanner.next();
        System.out.println("Enter status");
        boolean status = scanner.nextBoolean();
        System.out.println("Enter unitTask");
        int unitTask = scanner.nextInt();
        System.out.println("Enter salary");
        double salary = scanner.nextDouble();
        System.out.println("Enter job");
        String job = scanner.next();
        Employee newemployee = new Employee(ID, name, gender, phone, status, unitTask, salary, job);
        List<Employee> e = hotel.getEmployees();
        e.add(newemployee);
        ConnectDatabase connector = new ConnectDatabase();
        Connection connection = connector.ConnectDatabase();
        String sql = "INSERT INTO employees (employee_id, Name, Gender, Phone, Status, Unit_Task, Salary, Job)" +
        "VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement state = connection.prepareStatement(sql);
        state.setInt(1,ID);
        state.setString(2, name);
        state.setBoolean(3, gender);
        state.setString(4, phone);
        state.setBoolean(5, status);
        state.setInt(6, unitTask);
        state.setDouble(7, salary);
        state.setString(8, job);
        state.executeUpdate();
        System.out.println("Employee added successfully!");
    }

    public void removeEmployee(Hotel hotel) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID");
        int ID = scanner.nextInt();
        List<Employee> e = hotel.getEmployees();
        if(e.isEmpty()) {
            System.out.println("Employee list is empty");
            return;
        }
        for(Employee employee : e) {
            if(employee.getID() == ID) {
                e.remove(ID);

                Connection connection = null;
                PreparedStatement statement = null;
                try {
                    ConnectDatabase connector = new ConnectDatabase();
                    connection = connector.ConnectDatabase();
                    statement = connection.prepareStatement("DELETE FROM employee_information WHERE ID = ?");
                    statement.setInt(1, ID);
                    statement.executeUpdate();
                    System.out.println("Employee removed successfully!");
                } finally {
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                }
            }
            else {
                System.out.println("Employee not found");
            }
        }

    }

    public void addService(Hotel hotel) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID Service");
        int ID = scanner.nextInt();
        System.out.println("Enter Name Service");
        String name = scanner.next();
        Service s = new Service();
        s.setName(name);
        s.setId(ID);
        List<Service> e = hotel.getServices();
        e.add(s);
        ConnectDatabase db = new ConnectDatabase();
        Connection connection = db.ConnectDatabase();
        String sql = "INSERT INTO service (id, name) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,ID);
        statement.setString(2, name);
        statement.executeUpdate();
        System.out.println("Service added successfully!");
    }

    public void removeService(Hotel hotel) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID Service");
        int ID = scanner.nextInt();
        List<Service> e = hotel.getServices();
        for(Service s : e) {
            if(s.getId() == ID) {
                System.out.println("Service removed successfully!");
                e.remove(ID);
                ConnectDatabase db = new ConnectDatabase();
                Connection connection = db.ConnectDatabase();
                String sql = "DELETE FROM service WHERE ID = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1,ID);
                statement.executeUpdate();
                System.out.println("Service removed successfully!");
            }
            else {
                System.out.println("Service not found!");
                return;
            }
        }
    }
}
