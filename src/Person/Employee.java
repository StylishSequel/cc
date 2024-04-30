package Person;
// import ConnectDatabase.ConnectDatabase;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;


public class Employee extends Person {
    private boolean is_active;
    private double salary;
    private String job;
    public Employee(int ID, String name, boolean gender, String phone, boolean is_active, double salary, String job) {
        super(ID, name, gender, phone);
        this.is_active = is_active;
        this.salary = salary;
        this.job = job;
    }
    public boolean is_active() {
        return is_active;
    }
    public void setIs_active(boolean status) {
        this.is_active = status;
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


            @Override
    public String toString() {
        return "Employee{" +
                super.toString()+
                "is_active=" + is_active +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                '}';
    }
}
