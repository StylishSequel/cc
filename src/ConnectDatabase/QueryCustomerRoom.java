package ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Room.DeluxeRoom;
import Room.Room;
import Room.StandardRoom;
import Room.SuiteRoom;

public class QueryCustomerRoom {
    private Connector connector;

    public QueryCustomerRoom(Connector connector) {
        this.connector = connector;
    }

    public void insertCustomerRoom(int customerID, String checkInDate, int roomID, int num_of_day) {
        String query = "INSERT INTO customer_rooms(customer_id, room_id, num_of_day, check_in_date, e_check_out_date)"
                + "VALUES(?, ?, ?, ?, (?::date + ? * INTERVAL '1 day'))";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, customerID);
            pstmt.setInt(2, roomID);
            pstmt.setInt(3, num_of_day);

            java.sql.Date sqlCheckInDate = java.sql.Date.valueOf(checkInDate);
            pstmt.setDate(4, sqlCheckInDate);
            pstmt.setDate(5, sqlCheckInDate);

            pstmt.setInt(6, num_of_day);
            pstmt.executeUpdate();
            System.out.println("Customer with ID " + customerID + " has checked in room with ID " + roomID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        QueryRoom queryRoom = new QueryRoom(connector);
        queryRoom.updateAvailableRoom(roomID, false);
    }

    public List<Room> selectCurStandardCustomerRoom(int id) {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT r.room_id, price, num_of_beds, room_type, having_shower,  check_in_date, num_of_day, e_check_out_date " +
                "FROM customers c " +
                "JOIN customer_rooms cs ON c.id = cs.customer_id " +
                "JOIN rooms r ON cs.room_id = r.room_id " +
                "JOIN standard_rooms sr ON sr.room_id = r.room_id " +
                "WHERE c.id = ? AND check_out_date IS NULL AND e_check_out_date > CURRENT_DATE;";

        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                rooms.add(new StandardRoom(rs.getInt("room_id"), rs.getDouble("price"),
                        rs.getInt("num_of_beds"), rs.getBoolean("having_shower"), false, rs.getInt("num_of_day"),
                        rs.getString("check_in_date"), rs.getString("e_check_out_date")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rooms;
    }

    public List<Room> selectCurDeluxeCustomerRoom(int id) {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT r.room_id, price, num_of_beds, room_type, furniture , check_in_date, num_of_day, e_check_out_date " +
                "FROM customers c " +
                "JOIN customer_rooms cs ON c.id = cs.customer_id " +
                "JOIN rooms r ON cs.room_id = r.room_id " +
                "JOIN deluxe_rooms dr ON dr.room_id = r.room_id " +
                "WHERE c.id = ? AND check_out_date IS NULL AND e_check_out_date > CURRENT_DATE;";

        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                rooms.add(new DeluxeRoom(rs.getInt("room_id"), rs.getDouble("price"),
                        rs.getInt("num_of_beds"), rs.getString("furniture"), false, rs.getInt("num_of_day"),
                        rs.getString("check_in_date"), rs.getString("e_check_out_date")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rooms;
    }

    public List<Room> selectCurSuiteCustomerRoom(int id) {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT r.room_id, price, num_of_beds, room_type, electric_devices, check_in_date, num_of_day, e_check_out_date "
                +
                "FROM customers c " +
                "JOIN customer_rooms cs ON c.id = cs.customer_id " +
                "JOIN rooms r ON cs.room_id = r.room_id " +
                "JOIN suite_rooms sr ON sr.room_id = r.room_id " +
                "WHERE c.id = ? AND check_out_date IS NULL AND e_check_out_date > CURRENT_DATE;";

        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                rooms.add(new SuiteRoom(rs.getInt("room_id"), rs.getDouble("price"),
                        rs.getInt("num_of_beds"), rs.getString("electric_devices"), false, rs.getInt("num_of_day"),
                        rs.getString("check_in_date"), rs.getString("e_check_out_date")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rooms;
    }

    public List<Room> selectCustomerRooms(int id) {
        List<Room> rooms = new ArrayList<>();
        rooms.addAll(selectCurStandardCustomerRoom(id));
        rooms.addAll(selectCurDeluxeCustomerRoom(id));
        rooms.addAll(selectCurSuiteCustomerRoom(id));
        return rooms;
    }

    public void updateCheckOutDate(int customerID, int roomID) {
        String query = "UPDATE customer_rooms SET check_out_date = CURRENT_DATE WHERE customer_id = ? AND room_id = ? AND check_out_date IS NULL";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, customerID);
            pstmt.setInt(2, roomID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double calculateCurTotalRoomPrice(int customerId) {
        String query = "SELECT SUM(" +
                "CASE " +
                "WHEN CURRENT_DATE < cs.e_check_out_date THEN " +
                "r.price * cs.num_of_day " +
                "ELSE " +
                "r.price * (CURRENT_DATE - cs.check_in_date) " +
                "END " +
                ") AS total " +
                "FROM customers c " +
                "JOIN customer_rooms cs ON c.id = cs.customer_id " +
                "JOIN rooms r ON r.room_id = cs.room_id " +
                "WHERE c.id = ? AND cs.check_out_date IS NULL";

        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0.0;
    }
}
