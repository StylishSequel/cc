package ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Service.Service;

public class QueryRoomService {
    private Connector connector;

    public QueryRoomService(Connector connector) {
        this.connector = connector;
    }

    public void insertRoomService(int room_id, int service_id) {
        String query = "INSERT INTO booking_services(room_id, service_id, date)" + "VALUES(?, ?, CURRENT_DATE)";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, room_id);
            pstmt.setInt(2, service_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Service> queryCurRoomService(int id) {
        String query = "SELECT r.room_id, name, s.price, check_in_date, e_check_out_date, date FROM rooms r" +
                "JOIN room_services rs ON r.room_id = rs.room_id" +
                "JOIN customer_rooms cr ON r.room_id = cr.room_id" +
                "JOIN services s ON rs.service_id = s.service_id" +
                "WHERE check_out_date IS NULL AND r.room_id = ?;"+
                "AND date > check_in_date";
        List<Service> services = new ArrayList<>();
        try (Connection con = connector.connect();
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

    public double calculateRoomService(int roomId) {
        String query = "SELECT SUM(s.price) AS total " +
        "FROM rooms r " +
        "JOIN customer_rooms cr ON r.room_id = cr.room_id " +
        "JOIN room_services rs ON r.room_id = rs.room_id " +
        "JOIN services s ON rs.service_id = s.service_id " +
        "WHERE cr.check_out_date IS NULL AND date > check_in_date AND r.room_id = ?";
    
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, roomId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("total");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    
        return 0.0;
    }

    public List<Double> calculateRoomServiceTotals(int customerId) {
        String query = "SELECT SUM(s.price) AS total " +
        "FROM rooms r " +
        "JOIN customer_rooms cr ON r.room_id = cr.room_id " +
        "JOIN room_services rs ON r.room_id = rs.room_id " +
        "JOIN services s ON rs.service_id = s.service_id " +
        "WHERE cr.check_out_date IS NULL AND date > check_in_date " +
        "GROUP BY r.room_id" +
        "WHERE cr.customer_id = ?";
    
        List<Double> totals = new ArrayList<>();
    
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                totals.add(rs.getDouble("total"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    
        return totals;
    }
}
