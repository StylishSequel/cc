package ConnectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Room.DeluxeRoom;
import Room.Room;
import Room.StandardRoom;
import Room.SuiteRoom;
import Service.Service;
import Person.Customer;
import Person.Employee;

public class ConnectDatabase {
    private String hostName = "localhost:5432";
    private String databaseName = "postgres";
    private String username = "duc";
    private String password = "noname";

    private String connectionURL = "jdbc:postgresql://" + hostName + "/" + databaseName;

    public Connection connect() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Đã đóng kết nối đến cơ sở dữ liệu.");
            } catch (SQLException e) {
                System.out.println("Đóng kết nối đến cơ sở dữ liệu thất bại.");
                e.printStackTrace();
            }
        }
    }

    public List<StandardRoom> queryStandardRooms() {
        String query = "SELECT r.room_id, r.price, r.num_of_beds, r.room_type, s.having_shower " +
                "FROM rooms r " +
                "JOIN standard_rooms s ON s.room_id = r.room_id " +
                "WHERE r.is_available = true";
        List<StandardRoom> standardRooms = new ArrayList<>();
        try (Connection con = connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                standardRooms.add(new StandardRoom(rs.getInt("room_id"), rs.getDouble("price"),
                        rs.getInt("num_of_beds"), rs.getBoolean("having_shower")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return standardRooms;
    }

    public List<DeluxeRoom> queryDeluxeRooms() {
        String query = "SELECT r.room_id, r.price, r.num_of_beds, r.room_type, s.furniture " +
                "FROM rooms r " +
                "JOIN standard_rooms s ON s.room_id = r.room_id " +
                "WHERE r.is_available = true";
        List<DeluxeRoom> deluxeRooms = new ArrayList<>();
        try (Connection con = connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                deluxeRooms.add(new DeluxeRoom(rs.getInt("room_id"), rs.getDouble("price"),
                        rs.getInt("num_of_beds"), rs.getString("furniture")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deluxeRooms;
    }

    public List<SuiteRoom> querySuiteRooms() {
        String query = "SELECT r.room_id, r.price, r.num_of_beds, r.room_type, s.furniture " +
                "FROM rooms r " +
                "JOIN standard_rooms s ON s.room_id = r.room_id " +
                "WHERE r.is_available = true";
        List<SuiteRoom> suiteRooms = new ArrayList<>();
        try (Connection con = connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                suiteRooms.add(new SuiteRoom(rs.getInt("room_id"), rs.getDouble("price"),
                        rs.getInt("num_of_beds"), rs.getString("furniture")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return suiteRooms;
    }

    public List<Room> queryRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.addAll(queryStandardRooms());
        rooms.addAll(queryDeluxeRooms());
        rooms.addAll(querySuiteRooms());
        return rooms;
    }

    public List<Employee> queryEmployees() {
        String query = "SELECT * FROM employees";
        List<Employee> employees = new ArrayList<>();
        try (Connection con = connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                employees.add(new Employee(rs.getInt("employee_id"), rs.getString("name"), rs.getBoolean("gender"),
                        rs.getString("phone"), rs.getBoolean("status"), rs.getDouble("salary"),
                        rs.getString("job")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public List<Service> queryAllServices() {
        String query = "SELECT * FROM services";
        List<Service> services = new ArrayList<>();
        try (Connection con = connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                services.add(new Service(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return services;
    }

    // Trả về dịch vụ có id = id
    public Service queryService(int id) {
        String query = "SELECT * FROM services WHERE id = ?";
        try (Connection con = connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return new Service(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> queryCustomers() {
        String query = "SELECT * FROM customers WHERE is_active = true";
        List<Customer> customers = new ArrayList<>();
        try (Connection con = connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("customer_id"), rs.getString("name"), rs.getBoolean("gender"),
                        rs.getString("phone")));
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertCustomer(String name, boolean gender, String phone) {
        String query = "INSERT INTO customers(name, gender, phone)" + "VALUES(? ,?, ?) RETURNING customer_id";
        try (Connection con = connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setBoolean(2, gender);
            pstmt.setString(3, phone);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt("customer_id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertEmployee(String name, boolean gender, String phone, boolean is_active, double salary,
            String job) {
        String query = "INSERT INTO employees(name, gender, phone, is_active, salary, job)" +
                "VALUES(?, ?, ?, ?, ?, ?) RETURNING employee_id";
        try (Connection con = connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setBoolean(2, gender);
            pstmt.setString(3, phone);
            pstmt.setBoolean(4, is_active);
            pstmt.setDouble(5, salary);
            pstmt.setString(6, job);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt("employee_id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertCustomerRoom(int customerID, int roomID, int num_of_day) {
        String query = "INSERT INTO bookings(customer_id, room_id, num_of_day, check_in_date)"
                + "VALUES(?, ?, ?, CURRENT_DATE)";
        try (Connection con = connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, customerID);
            pstmt.setInt(2, roomID);
            pstmt.setInt(3, num_of_day);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCheckOutDate(int room_id) {
        String query = "UPDATE bookings SET check_out_date = CURRENT_DATE WHERE room_id = ?";
        try (Connection con = connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, room_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertService(String name, double price) {
        String query = "INSERT INTO services(name, price)" + "VALUES(?, ?) RETURNING service_id";
        try (Connection con = connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt("service_id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertRoomService(int room_id, int service_id) {
        String query = "INSERT INTO booking_services(room_id, service_id, date)" + "VALUES(?, ?, CURRENT_DATE)";
        try (Connection con = connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, room_id);
            pstmt.setInt(2, service_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeEmployee(int employee_id) {
        String query = "DELETE FROM employees WHERE employee_id = ?";
        try (Connection con = connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, employee_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeService(int service_id) {
        String query = "DELETE FROM services WHERE service_id = ?";
        try (Connection con = connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, service_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Room> queryCurStandardCustomerRoom(int id) {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT r.room_id, price, num_of_beds, room_type, having_shower " +
                "FROM customers c " +
                "JOIN customer_rooms cs ON c.id = cs.customer_id " +
                "JOIN rooms r ON cs.room_id = r.room_id " +
                "JOIN standard_rooms sr ON sr.room_id = r.room_id " +
                "WHERE c.id = ? AND check_out_date IS NULL AND e_check_out_date > CURRENT_DATE;";

        try (Connection con = connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                rooms.add(new StandardRoom(rs.getInt("room_id"), rs.getDouble("price"),
                        rs.getInt("num_of_beds"), rs.getBoolean("having_shower")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rooms;
    }

    public List<Room> queryCurDeluxeCustomerRoom(int id) {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT r.room_id, price, num_of_beds, room_type, furniture " +
                "FROM customers c " +
                "JOIN customer_rooms cs ON c.id = cs.customer_id " +
                "JOIN rooms r ON cs.room_id = r.room_id " +
                "JOIN deluxe_rooms dr ON dr.room_id = r.room_id " +
                "WHERE c.id = ? AND check_out_date IS NULL AND e_check_out_date > CURRENT_DATE;";

        try (Connection con = connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                rooms.add(new DeluxeRoom(rs.getInt("room_id"), rs.getDouble("price"),
                        rs.getInt("num_of_beds"), rs.getString("furniture")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rooms;
    }

    public List<Room> queryCurSuiteCustomerRoom(int id) {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT r.room_id, price, num_of_beds, room_type, furniture " +
                "FROM customers c " +
                "JOIN customer_rooms cs ON c.id = cs.customer_id " +
                "JOIN rooms r ON cs.room_id = r.room_id " +
                "JOIN suite_rooms sr ON sr.room_id = r.room_id " +
                "WHERE c.id = ? AND check_out_date IS NULL AND e_check_out_date > CURRENT_DATE;";

        try (Connection con = connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                rooms.add(new SuiteRoom(rs.getInt("room_id"), rs.getDouble("price"),
                        rs.getInt("num_of_beds"), rs.getString("furniture")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rooms;
    }

    public List<Service> queryCurRoomService(int id) {
        String query = "SELECT r.room_id, name, s.price, check_in_date, e_check_out_date, date FROM rooms r" +
        "JOIN room_services rs ON r.room_id = rs.room_id" +
        "JOIN customer_rooms cr ON r.room_id = cr.room_id" +
        "JOIN services s ON rs.service_id = s.service_id" +
        "WHERE check_out_date IS NULL AND r.room_id = ?;";
        List<Service> services = new ArrayList<>();
        try (Connection con = connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                services.add(new Service(rs.getInt("service_id"), rs.getString("name"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return services;
    }

    public List<Room> queryCurCustomerRoom(int id) {
        List<Room> rooms = new ArrayList<>();
        rooms.addAll(queryCurStandardCustomerRoom(id));
        rooms.addAll(queryCurDeluxeCustomerRoom(id));
        rooms.addAll(queryCurSuiteCustomerRoom(id));
        rooms.stream().forEach(r -> {
            r.setBookedService(queryCurRoomService(r.getId()));
        });
        return rooms;
    }

}
