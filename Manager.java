import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager extends Employee{
    public Manager(int ID, String name, boolean gender, String phone,boolean status, int unitTask, double salary, String job){
        super(ID, name, gender, phone, status, unitTask, salary, job);
    }
    public void addEmployeeIntoDatabase(Hotel hotel) throws SQLException {
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
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(newemployee);
        hotel.setEmployees(employees);
        Statement statement = null;
        ConnectDatabase connector = new ConnectDatabase();
        Connection connection = connector.ConnectToDatabase();
        String sql = "INSERT INTO employee_information (ID, Name, Gender, Phone, Status, Unit_Task, Salary, Job)" +
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

//        List<Employee> e = hotel.getEmployees();
//        if(e.isEmpty()) {
//            System.out.println("Employee list is empty");
//            return;
//        }
//
//        for (Employee employee : e) {
//            if (employee.getID() == ID) {
//                e.remove(this);
//            }
//        }
//        hotel.setEmployees(e);
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            ConnectDatabase connector = new ConnectDatabase();
            connection = connector.ConnectToDatabase();
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

}
