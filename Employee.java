import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Employee extends Person {
    private boolean status;
    private List<Integer> taskid;
    private int unitTask;
    private double salary;
    private String job;
    public Employee(int ID, String name, boolean gender, String phone, boolean status, int unitTask, double salary, String job) {
        super(ID, name, gender, phone);
        this.status = status;
        this.unitTask = unitTask;
        this.salary = salary;
        this.job = job;
        this.taskid = new ArrayList<>();
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getUnitTask() {
        return unitTask;
    }
    public void setUnitTask(int unitTask) {
        this.unitTask = unitTask;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    public void chooseTask(int id) {
        Boolean flag = true;
        while (flag) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter ID: ");
            id = input.nextInt();
            ConnectDatabase db = new ConnectDatabase();
            Connection connection = db.ConnectToDatabase();
            String sql = "SELECT id FROM services";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    this.taskid = new ArrayList<>();
                    while (rs.next()) {
                        id = rs.getInt("id");
                        this.taskid.add(id);
                    }
                    System.out.println("Do you want continue: ");
                    flag = input.nextBoolean();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
            @Override
    public String toString() {
        return "Employee{" +
                super.toString()+
                "status=" + status +
                ", unitTask=" + unitTask +
                ", salary=" + salary +
                ", taskid=" + taskid +
                ", job='" + job + '\'' +
                '}';
    }
}
