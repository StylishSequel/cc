package Room;
import Service.Service;

import java.util.List;

import ConnectDatabase.ConnectDatabase;
import java.util.Scanner ;

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
    
    public Room(int room_id2, double price2, int numOfDay2) {
        this.room_id = room_id2;
        this.price = price2;
        this.numOfDay = numOfDay2;
    }
    public int getId() {
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
        return check_out_date;
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
    public void bookService(){
        System.out.println("Enter service id: ");
        try (Scanner sc = new Scanner(System.in)) {
            int id = sc.nextInt();
            ConnectDatabase connect = new ConnectDatabase();
            connect.insertBookingService(this.getId(), id);
            this.bookedService.add(connect.executeQueryService(id));
        }
        System.out.println("Service booked successfully");
        
    }
    abstract double calculatePrice();
    
}
