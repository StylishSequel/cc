package ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Person.Employee;

import javax.swing.*;

public class QueryEmployee implements IQuery<Employee> {
    private Connector connector;

    public QueryEmployee(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void insert(Employee employee) {
        String query = "INSERT INTO employees(name, gender, phone, is_active, salary, job)" +
                "VALUES(?, ?, ?, ?, ?, ?) RETURNING employee_id";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, employee.getName());
            pstmt.setBoolean(2, employee.isGender());
            pstmt.setString(3, employee.getPhone());
            pstmt.setBoolean(4, employee.is_active());
            pstmt.setDouble(5, employee.getSalary());
            pstmt.setString(6, employee.getJob());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            employee.setID(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Employee employee) {
        String query = "UPDATE employees SET name = ?, gender = ?, phone = ?, is_active = ?, salary = ?, job = ? WHERE employee_id = ?";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, employee.getName());
            pstmt.setBoolean(2, employee.isGender());
            pstmt.setString(3, employee.getPhone());
            pstmt.setBoolean(4, employee.is_active());
            pstmt.setDouble(5, employee.getSalary());
            pstmt.setString(6, employee.getJob());
            pstmt.setInt(7, employee.getID());
            pstmt.executeUpdate();
            System.out.println("Updated successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Employee t) {
        String query = "DELETE FROM employees WHERE employee_id = ?";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, t.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee select(int id) {
        String query = "SELECT * FROM employees WHERE employee_id = ?";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("employee_id"), rs.getString("name"), rs.getBoolean("gender"),
                        rs.getString("phone"), rs.getBoolean("is_active"), rs.getDouble("salary"), rs.getString("job"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Employee> selectAll() {
        String query = "SELECT * FROM employees";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("employee_id"), rs.getString("name"), rs.getBoolean("gender"),
                        rs.getString("phone"), rs.getBoolean("is_active"), rs.getDouble("salary"),
                        rs.getString("job")));
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
