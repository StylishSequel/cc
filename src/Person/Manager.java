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

    //ADD EMPLOYEE TO HOTEL AND DATABASE
    public void addEmployee(Hotel hotel) throws SQLException {

        //TYPING EMPLOYEE INFORMATION
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

        //ADD TO DATABASE
        ConnectDatabase connector = new ConnectDatabase();
        int idNewEmployee = connector.insertEmployee(name,gender,phone,is_active,salary,job);

        //ADD TO HOTEL LIST
        Employee newemployee = new Employee(idNewEmployee, name, gender, phone, is_active, salary, job);
        List<Employee> e = hotel.getEmployees();
        e.add(newemployee);
        System.out.println("Employee added successfully!");
    }

    //REMOVE EMPLOYEE IN HOTEL AND DATABASE BY ID
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
                    connection = connector.connect();
                    statement = connection.prepareStatement("DELETE FROM employees WHERE ID = ?");
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

    //ADD SERVICE INTO HOTEL AND DATABASE
    public void addService(Hotel hotel) throws SQLException {

        //TYPING SERVICE INFOR
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name Service");
        String name = scanner.next();
        System.out.println("Enter Price Service");
        double price = scanner.nextDouble();

        //ADD INTO DATABSE
        ConnectDatabase db = new ConnectDatabase();
        int idNewService = db.insertService(name,price);

        //ADD INTO HOTEL LIST
        Service s = new Service(idNewService,name,price);
        List<Service> e = hotel.getServices();
        e.add(s);
        System.out.println("Service added successfully!");
    }

    //REMOVE SERVICE IN HOTEL AND DATABASE
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
                Connection connection = db.connect();
                String sql = "DELETE FROM services WHERE ID = ?";
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
