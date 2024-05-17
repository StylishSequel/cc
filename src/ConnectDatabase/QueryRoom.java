package ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Person.Employee;
import Room.DeluxeRoom;
import Room.Room;
import Room.StandardRoom;
import Room.SuiteRoom;

public class QueryRoom implements IQuery<Room> {
    private Connector connector;

    public QueryRoom(Connector connector) {
        this.connector = connector;
    }

    @Override
    public void insert(Room room) {
        int id;
        String query = "INSERT INTO rooms(price, is_available, num_of_beds, room_type)"
                + "VALUES(? ,?, ?, ?) RETURNING room_id";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setDouble(1, room.getPrice());
            pstmt.setBoolean(2, room.isAvailable());
            pstmt.setInt(3, room.getNumOfBed());
            pstmt.setString(4, room.getType());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            id = rs.getInt("room_id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (room instanceof StandardRoom) {
            StandardRoom standardRoom = (StandardRoom) room;
            query = "INSERT INTO standard_rooms(room_id, having_shower) VALUES(?, ?)";
            try (Connection con = connector.connect();
                    PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, id);
                pstmt.setBoolean(2, standardRoom.isHavingShower());
                pstmt.executeUpdate();
                System.out.println("Standard room inserted successfully!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (room instanceof DeluxeRoom) {
            DeluxeRoom deluxeRoom = (DeluxeRoom) room;
            query = "INSERT INTO deluxe_rooms(room_id, furniture) VALUES(?, ?)";
            try (Connection con = connector.connect();
                    PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, id);
                pstmt.setString(2, deluxeRoom.getFurniture());
                pstmt.executeUpdate();
                System.out.println("Deluxe room inserted successfully!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            SuiteRoom suiteRoom = (SuiteRoom) room;
            query = "INSERT INTO suite_rooms(room_id, electric_devices) VALUES(?, ?)";
            try (Connection con = connector.connect();
                    PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setInt(1, id);
                pstmt.setString(2, suiteRoom.getElectricDevices());
                pstmt.executeUpdate();
                System.out.println("Suite room inserted successfully!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void update(Room room) {
        String query = "UPDATE rooms SET price = ?, is_available = ?, num_of_beds = ? WHERE room_id = ?";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setDouble(1, room.getPrice());
            pstmt.setBoolean(2, room.isAvailable());
            pstmt.setInt(3, room.getNumOfBed());
            pstmt.setInt(4, room.getId());
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new RuntimeException("No room found with id: " + room.getId());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (room instanceof StandardRoom) {
            query = "UPDATE standard_rooms SET having_shower = ? WHERE room_id = ?";
            try (Connection con = connector.connect();
                    PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setBoolean(1, ((StandardRoom) room).isHavingShower());
                pstmt.setInt(2, room.getId());
                pstmt.executeUpdate();
                System.out.println("Standard room updated successfully!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (room instanceof DeluxeRoom) {
            query = "UPDATE deluxe_rooms SET furniture = ? WHERE room_id = ?";
            try (Connection con = connector.connect();
                    PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, ((DeluxeRoom) room).getFurniture());
                pstmt.setInt(2, room.getId());
                pstmt.executeUpdate();
                System.out.println("Deluxe room updated successfully!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            query = "UPDATE suite_rooms SET electric_devices = ? WHERE room_id = ?";
            try (Connection con = connector.connect();
                    PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, ((SuiteRoom) room).getElectricDevices());
                pstmt.setInt(2, room.getId());
                pstmt.executeUpdate();
                System.out.println("Suite room updated successfully!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void delete(Room room) {
        String query = "DELETE FROM rooms WHERE room_id = ?";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, room.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Room select(int id) {
        double price;
        int numOfBed;
        boolean isAvailable;
        String type;
        String query = "SELECT * FROM rooms WHERE room_id = ?";
        try (Connection con = connector.connect();
                PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                price = rs.getDouble("price");
                numOfBed = rs.getInt("num_of_beds");
                isAvailable = rs.getBoolean("is_available");
                type = rs.getString("room_type");
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        query = "SELECT * FROM rooms "
                + "FULL OUTER JOIN standard_rooms ON rooms.room_id = standard_rooms.room_id "
                + "FULL OUTER JOIN deluxe_rooms ON rooms.room_id = deluxe_rooms.room_id "
                + "FULL OUTER JOIN suite_rooms ON rooms.room_id = suite_rooms.room_id "
                + "WHERE rooms.room_id = ?;";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if (type.equals("Standard")) {
                    return new StandardRoom(id, price, numOfBed, isAvailable,
                            rs.getBoolean("having_shower"));
                } else if (type.equals("Deluxe")) {
                    return new DeluxeRoom(id, price, numOfBed, rs.getString("furniture"),
                            isAvailable);
                } else {
                    return new SuiteRoom(id, price, numOfBed, rs.getString("electric_devices"),
                            isAvailable);
                }
            } else {
                throw new RuntimeException("No room found with id: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StandardRoom> selectStandardRooms() {
        String query = "SELECT r.room_id, r.price, r.num_of_beds, r.room_type, s.having_shower, r.is_available " +
                "FROM rooms r " +
                "JOIN standard_rooms s ON s.room_id = r.room_id " +
                "WHERE r.is_available = true";
        List<StandardRoom> standardRooms = new ArrayList<>();
        try (Connection con = connector.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                standardRooms.add(new StandardRoom(rs.getInt("room_id"), rs.getDouble("price"),
                        rs.getInt("num_of_beds"), rs.getBoolean("having_shower"), rs.getBoolean("is_available")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return standardRooms;
    }

    public List<DeluxeRoom> selectDeluxeRooms() {
        String query = "SELECT r.room_id, r.price, r.num_of_beds, r.room_type, d.furniture, r.is_available " +
                "FROM rooms r " +
                "JOIN deluxe_rooms d ON d.room_id = r.room_id " +
                "WHERE r.is_available = true";
        List<DeluxeRoom> deluxeRooms = new ArrayList<>();
        try (Connection con = connector.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                deluxeRooms.add(new DeluxeRoom(rs.getInt("room_id"), rs.getDouble("price"),
                        rs.getInt("num_of_beds"), rs.getString("furniture"), rs.getBoolean("is_available")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deluxeRooms;
    }

    public List<SuiteRoom> selectSuiteRooms() {
        String query = "SELECT r.room_id, r.price, r.num_of_beds, r.room_type, s.electric_devices, r.is_available " +
                "FROM rooms r " +
                "JOIN suite_rooms s ON s.room_id = r.room_id " +
                "WHERE r.is_available = true";
        List<SuiteRoom> suiteRooms = new ArrayList<>();
        try (Connection con = connector.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                suiteRooms.add(new SuiteRoom(rs.getInt("room_id"), rs.getDouble("price"),
                        rs.getInt("num_of_beds"), rs.getString("electric_devices"), rs.getBoolean("is_available")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return suiteRooms;
    }

    @Override
    public List<Room> selectAll() {
        List<Room> rooms = new ArrayList<>();
        rooms.addAll(selectStandardRooms());
        rooms.addAll(selectDeluxeRooms());
        rooms.addAll(selectSuiteRooms());
        return rooms;
    }

    public ResultSet selectStandardRoomsRS(int num_of_beds) {
        String query = "SELECT r.room_id, r.price, r.num_of_beds, r.room_type, s.having_shower, r.is_available " +
                "FROM rooms r " +
                "JOIN standard_rooms s ON s.room_id = r.room_id " +
                "WHERE r.is_available = true";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, num_of_beds);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet selectDeluxeRoomsRS(int num_of_beds) {
        String query = "SELECT r.room_id, r.price, r.num_of_beds, r.room_type, d.furniture, r.is_available " +
                "FROM rooms r " +
                "JOIN deluxe_rooms d ON d.room_id = r.room_id " +
                "WHERE r.is_available = true";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, num_of_beds);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet selectSuiteRoomsRS(int num_of_beds) {
        String query = "SELECT r.room_id, r.price, r.num_of_beds, r.room_type, s.electric_devices, r.is_available " +
                "FROM rooms r " +
                "JOIN suite_rooms s ON s.room_id = r.room_id " +
                "WHERE r.is_available = true AND r.num_of_beds = ?";
        try (Connection con = connector.connect();
                PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, num_of_beds);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
