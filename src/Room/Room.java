package Room;

import Service.Service;

import java.util.List;

import ConnectDatabase.ConnectDatabase;
import ConnectDatabase.Connector;
import ConnectDatabase.QueryAll;

import java.util.Scanner;

public abstract class Room {
    private int room_id;
    private double price;
    private String check_in_date;

    private String check_out_date;
    private String e_check_out_date;
    private int numOfDay;
    private int numOfBed;

    private boolean isAvailable;
    private String type;

    public Room() {
        this.room_id = 0;
        this.price = 0;
        this.check_in_date = "";
        this.check_out_date = "";
        this.numOfDay = 0;
        this.numOfBed = 0;
        this.isAvailable = true;
        this.type = "";

    }

    public Room(int room_id, double price, String check_in_date, int numOfDay, int numOfBed,
            boolean isAvailable, String type) {
        this.room_id = room_id;
        this.price = price;
        this.check_in_date = check_in_date;
        this.check_out_date = "";
        this.numOfDay = numOfDay;
        this.numOfBed = numOfBed;
        this.isAvailable = isAvailable;
        this.type = type;

    }

    public Room( double price, int numOfBed, boolean isAvailable) {
        this.price = price;
        this.numOfBed = numOfBed;
        this.isAvailable = isAvailable;
    }
    public Room(int room_id, double price, int numOfBed, boolean isAvailable) {
        this.room_id = room_id;
        this.price = price;
        this.numOfBed = numOfBed;
        this.isAvailable = isAvailable;
    }

    public Room(int room_id, double price, int numOfBed, boolean isAvailable, int numOfDay, String check_in_date,
            String e_check_out_date) {
        this.room_id = room_id;
        this.price = price;
        this.numOfBed = numOfBed;
        this.isAvailable = isAvailable;
        this.numOfDay = numOfDay;
        this.check_in_date = check_in_date;
        this.e_check_out_date = e_check_out_date;
    }

    public Room(double price, int numOfBed) {
        this.price = price;
        this.numOfBed = numOfBed;
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

    public String getECheckOutDate() {
        return e_check_out_date;
    }

    public List<Service> getBookedService() {
        Connector connector = new Connector();
        QueryAll connectToDb = new QueryAll(connector);
        return connectToDb.queryRoomService.selectCurRoomService(this.getId());
    }
    // public void setBookedService(List<Service> queryCurRoomService) {
    // this.bookedService = queryCurRoomService;
    // }

    // public void bookService(){
    // System.out.println("Enter service id: ");
    // try (Scanner sc = new Scanner(System.in)) {
    // int id = sc.nextInt();
    // ConnectDatabase connect = new ConnectDatabase();
    // connect.insertRoomService(this.getId(), id);
    // this.bookedService.add(connect.queryService(id));
    // }
    // System.out.println("Service booked successfully");

    // }
    public void bookService(int id,String check_in_date) {
        Connector connector = new Connector();
        QueryAll connectToDb = new QueryAll(connector);
        List<Service> services = connectToDb.queryService.selectAll();
        boolean flag = services.stream().anyMatch(service -> service.getId() == id);
        if (!flag) {
            System.out.println("Service is not found");
            return;
        }
        connectToDb.queryRoomService.insertRoomService(this.getId(), id,check_in_date);

        System.out.println("Service booked successfully");
    }

    abstract double calculatePrice();

}
