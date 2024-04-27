
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public abstract class Room {
    private int room_id;
    private double price;
    private String check_in_date;
    
    private String check_out_date;
    private int numOfDay ;
    private int numOfBed ;

    private boolean isAvailable;
    private String type;
    private List<Service> bookedService;
    
    public Room() {
        this.room_id = 0;
        this.price = 0;
        this.check_in_date = "";
        this.check_out_date = "";
        this.numOfDay = 0;
        this.numOfBed = 0;
        this.isAvailable = true;
        this.type = "";
        this.bookedService = null;

    }
    public Room(int room_id, double price, String check_in_date, int numOfDay, int numOfBed,
            boolean isAvailable, String type, List<Service> bookedService) {
        this.room_id = room_id;
        this.price = price;
        this.check_in_date = check_in_date;
        this.check_out_date = "";
        this.numOfDay = numOfDay;
        this.numOfBed = numOfBed;
        this.isAvailable = isAvailable;
        this.type = type;
        this.bookedService = bookedService;
    }

    
    public int getRoom_id() {
        return room_id;
    }
    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCheck_in_date() {
        return check_in_date;
    }
    public void setCheck_in_date(String check_in_date) {
        this.check_in_date = check_in_date;
    }
    public String getCheck_out_date() {
        Connection connection = null;
        try {
            ConnectDatabase db = new ConnectDatabase();
            connection = db.ConnectToDatabase();
            String query = "SELECT check_out_date FROM booking_rooms WHERE room_id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, this.getRoom_id());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    this.check_out_date = resultSet.getString("check_out_date");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return check_out_date;
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
    public void setCheck_out_date(String check_out_date) {
        this.check_out_date = check_out_date;
    }
    public int getNumOfDay() {
        return numOfDay;
    }
    public void setNumOfDay(int numOfDay) {
        this.numOfDay = numOfDay;
    }
    public int getNumOfBed() {
        return numOfBed;
    }
    public void setNumOfBed(int numOfBed) {
        this.numOfBed = numOfBed;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public List<Service> getBookedService() {
        return bookedService ;
    }
    public void setBookedService(List<Service> bookedService) {
        this.bookedService = bookedService;
    }
    public void bookService(Service service){
        if (this.bookedService == null) {
        this.bookedService = new ArrayList<>();
    }
        this.bookedService.add(service);
        Connection connection = null;
        //import to database 
        try {
            ConnectDatabase db = new ConnectDatabase();
            connection = db.ConnectToDatabase();
            String query = "INSERT INTO booking_services (booking_room_id,services, price) VALUES( ?, ?, ?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, this.getRoom_id());
                preparedStatement.setString(2, service.getName());
                
                
                preparedStatement.setDouble(3, service.getPrice());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } finally {
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Booked service successfully");

    }
    abstract double calculatePrice();
    
}
