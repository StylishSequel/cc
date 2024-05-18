package Person;

import ConnectDatabase.*;

import java.util.List;



import Room.*;
import Service.Service;

public class Customer extends Person {
    
    public Customer() {

    }
    public Customer(int ID, String name, boolean gender, String phone, boolean is_active) {
        super(ID, name, gender, phone, is_active);
        
    }

    public Customer(String name, boolean gender, String phone, boolean is_active) {
        super(name, gender, phone, is_active);
        
    }

    public List<Room> getBookedRoom() {
        ConnectDatabase connector = new ConnectDatabase();
        return connector.queryCurCustomerRoom(this.getID());
    }
     

    // public void bookService(Hotel h){
    // System.out.println("Enter service id: ");
    // Scanner sc = new Scanner(System.in);
    // int id = sc.nextInt();
    // List<Service> services = h.getServices();
    // for(Service service : services){
    // if(service.getId() == id){
    // Services.add(service);
    // System.out.println("Service booked successfully");
    // }
    // else {
    // System.out.println("Service is not found");
    // }
    // }
    // }


    public void printBookedRoom() {
        for (Room room : this.getBookedRoom()) {
            System.out.println(room);
        }
    }

    public void printServices() {
        for (Room room : this.getBookedRoom()) {
            List<Service> services = room.getBookedService();
            if (services != null) {
                services.stream().forEach(service -> System.out.println(service));
            }
        }
    }

    public double getBill() {
        double total = 0;
        for (Room room : this.getBookedRoom()) {
            total += room.getPrice();
            List<Service> services = room.getBookedService();
            if (services != null) {
                for (Service service : services) {
                    total += service.getPrice();
                }
            }
        }
        // System.out.print("Total all the: " + total);
        return total;
    }

    public double printBill() {
        double total = 0;
        for (Room room : this.getBookedRoom()) {
            double curTotal = 0;
            total += room.getPrice();
            List<Service> s = room.getBookedService();

            System.out.println(room.toString());
            if (s == null) {
                System.out.println("Total: " + room.getPrice());
                continue;
            }
            for(Service service : s){
                total += service.getPrice();
                curTotal += service.getPrice();

                System.out.println(service.toString());
            }
            curTotal = room.getPrice();
            System.out.println("Total: " + curTotal);
        }
        System.out.print("Total all the rooms: ");
        return total;
    }
    // public void bookRoom(Hotel hotel){
    //     System.out.println("Enter room id: ");
    //     Scanner sc = new Scanner(System.in);
    //     int id = sc.nextInt();
    //     List<Room> rooms = hotel.getAvailableRoom();
    //     Room room = rooms.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    //     System.out.println("Enter num of day: ");
    //             int numOfDay = sc.nextInt();
    //             bookedRoom.add(room);
    //             hotel.getAvailableRoom().remove(room);
    //             room.setAvailable(false);
    //             ConnectDatabase connector = new ConnectDatabase();
    //             connector.insertCustomerRoom(this.getID(), id, numOfDay);
    //             System.out.println("Room booked successfully");
    public void bookRoom(int room_id, int numOfDay,String checkindate){
        Connector connector = new Connector();
        QueryAll connectToDb = new QueryAll(connector);
        List<Room> availableRoom = connectToDb.queryRoom.selectAll();
        boolean flag = availableRoom.stream().anyMatch(room -> room.getId() == room_id);
        if(flag){
            connectToDb.queryCustomerRoom.insertCustomerRoom(this.getID(), checkindate,room_id, numOfDay);
            System.out.println("Room booked successfully");
            return;
        }
        System.out.println("Room is not available");
        
    }
    public void checkOut(int room_id){
        Connector connector = new Connector();
        QueryAll connectToDb = new QueryAll(connector);
        List<Room> bookedRoom = connectToDb.queryCustomerRoom.selectCustomerRooms(this.getID());
        bookedRoom.stream().filter(room -> room.getId() == room_id).findFirst().ifPresent(room -> {
            connectToDb.queryCustomerRoom.updateCheckOutDate(this.getID(),room_id);
//            connectToDb.queryRoom.updateRoomAvailable(room_id,true);

            
        });
        ConnectDatabase connection = new ConnectDatabase();
        connection.updateActiveCustomer(this.getID(),false);
        System.out.println("Check out successfully");
        
    }
//
//    public static void main(String[] args) {
//        Customer c = new Customer(1, "Huy", true, "123", true);
//        c.bookRoom(1, 2);
//        c.bookRoom(2, 3);
//        c.printBookedRoom();
//        c.printServices();
//        c.printBill();
//    }
}

    

   
