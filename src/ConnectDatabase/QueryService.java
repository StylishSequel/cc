package ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Service.Service;

public class QueryService implements IQuery<Service> {
    private Connector connector;

    public QueryService(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void insert(Service service) {
        String query = "INSERT INTO service (service_name, price) VALUES (?, ?)";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, service.getName());
            pstmt.setDouble(2, service.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Service service) {
        String query = "UPDATE service SET service_name = ?, price = ? WHERE service_id = ?";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, service.getName());
            pstmt.setDouble(2, service.getPrice());
            pstmt.setInt(3, service.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Service service) {
        String query = "DELETE FROM service WHERE service_id = ?";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, service.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Service select(int id) {
        String query = "SELECT * FROM services WHERE id = ?";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return new Service(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Service> selectAll() {
        String query = "SELECT * FROM services";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            List<Service> services = new ArrayList<>();
            while (rs.next()) {
                services.add(new Service(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
            return services;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
