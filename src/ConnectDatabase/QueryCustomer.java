package ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Person.Customer;

public class QueryCustomer implements IQuery<Customer> {
    private Connector connector;

    public QueryCustomer(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void insert(Customer customer) {
        String query = "INSERT INTO customers(name, gender, phone, is_active)" + "VALUES(? ,?, ?, ?) RETURNING id";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, customer.getName());
            pstmt.setBoolean(2, customer.isGender());
            pstmt.setString(3, customer.getPhone());
            pstmt.setBoolean(4, true);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            System.out.println("Customer inserted successfully!");
            customer.setID(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Customer customer) {
        String query = "UPDATE customers SET name = ?, gender = ?, phone = ?, is_active = ? WHERE id = ?";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, customer.getName());
            pstmt.setBoolean(2, customer.isGender());
            pstmt.setString(3, customer.getPhone());
            pstmt.setBoolean(4, customer.isActive());
            pstmt.setInt(5, customer.getID());
            pstmt.executeUpdate();
            System.out.println("Customer updated successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Customer customer) {
        String query = "DELETE FROM customers WHERE id = ?";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, customer.getID());
            pstmt.executeUpdate();
            System.out.println("Customer deleted successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer select(int id) {
        String query = "SELECT * FROM customers WHERE id = ?";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt("id"), rs.getString("name"), rs.getBoolean("gender"),
                        rs.getString("phone"), rs.getBoolean("is_active"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Customer> selectAll() {
        String query = "SELECT * FROM customers WHERE is_active = true";
        List<Customer> customers = new ArrayList<>();
        try (Connection con = connector.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("id"), rs.getString("name"), rs.getBoolean("gender"),
                        rs.getString("phone"), rs.getBoolean("is_active")));
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   public void updateActiveCustomer(int id, boolean isActive) {
       String query = "UPDATE customers SET is_active = ? WHERE id = ?";
       try (Connection con = connector.connect();
               PreparedStatement pstmt = con.prepareStatement(query)) {
           pstmt.setBoolean(1, isActive);
           pstmt.setInt(2, id);
           pstmt.executeUpdate();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }

    public boolean checkCustomerAccountExist(String user_name) {
        String query = "SELECT * FROM customer_account WHERE user_name = ? ";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, user_name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public Customer insertCustomer(String name, boolean gender, String phone, boolean is_active) {
        String query = "INSERT INTO customers(name, gender, phone, is_active)" + "VALUES(? ,?, ?, ?) RETURNING id";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setBoolean(2, gender);
            pstmt.setString(3, phone);
            pstmt.setBoolean(4, is_active);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            System.out.println("Customer inserted successfully!");
            return new Customer(rs.getInt("id"), name, gender, phone, is_active);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertCustomerAccount(String username, String password, String name, Boolean gender, String phone) {
        int id = insertCustomer(name, gender, phone, true).getID();
        
        String query = "INSERT INTO customer_account(customer_account_id,user_name, pass_word ) VALUES(?, ?, ?)";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
