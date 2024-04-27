
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class Customer extends Person {
    private List<Room> bookedRooms;

    // Constructor

    public Customer(int ID, String name, boolean gender, String phone, List<Room> bookedRooms, int rate) {
        super(ID, name, gender, phone);
        this.bookedRooms = bookedRooms;

    }
    
    public Customer(List<Room> bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public List<Room> getBookedRooms() {
        return bookedRooms;
    }
    public void setBookedRooms(List<Room> bookedRooms) {
        this.bookedRooms = bookedRooms;
    }
    // Method
    public void bookRoom(Room room) {
        if (!room.isAvailable()) {
            System.out.println("Room is not available");
            return;
        } else {
            if (this.bookedRooms == null) {
                this.bookedRooms = new ArrayList<>();
            }
            this.bookedRooms.add(room);
            Connection connection = null;
            
            try {
                ConnectDatabase db = new ConnectDatabase();
                connection = db.ConnectToDatabase();
                String query = "INSERT INTO booking_rooms (check_in_date, customer_id, room_id, num_of_day, type)"
                    +
                    "VALUES(?, ?, ?, ?,?);";
    
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setDate(1, Date.valueOf(room.getCheck_in_date()));
                    preparedStatement.setInt(2, this.getID());
                    preparedStatement.setInt(3, room.getRoom_id());
                    preparedStatement.setInt(4, room.getNumOfDay());
                    // Kiểm tra xem room thuộc loại nào
                    if(room instanceof SuiteRoom){
                        preparedStatement.setString(5, "Suite");
                    }
                    else if(room instanceof StandardRoom){
                        preparedStatement.setString(5, "Standard");
                    }
                    else{
                        preparedStatement.setString(5, "Deluxe");
                    
                    }
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
    
                // Kiểm tra loại phòng và cập nhật thông tin trong bảng tương ứng
     
                String queryRoom = "UPDATE rooms " +
                        "SET is_available = false " +
                        "WHERE room_id = ?";
                try (PreparedStatement preparedStatementSuiteRoom = connection.prepareStatement(queryRoom)) {
                    preparedStatementSuiteRoom.setInt(1, room.getRoom_id());
                    preparedStatementSuiteRoom.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
    
                System.out.println("Add room successfully");
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test
        Customer customer = new Customer(1, "Duc", true, "123456789", null, 5);
        Room  room1 = new SuiteRoom(6, 100, "2021-01-01", 5, 2, true, "Suite", null, "TV", 2);
        customer.bookRoom(room1);
        Service service1 = new Service(1, "Breakfast", 10);
        customer.getBookedRooms().get(0).bookService(service1);
        String lol = customer.getBookedRooms().get(0).getCheck_out_date();
        System.out.println(lol);
    }


    


    

}
