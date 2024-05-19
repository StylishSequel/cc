package Person;

import ConnectDatabase.*;

import java.util.List;

import Room.*;
import Service.Service;

public class Customer extends Person {
    Connector connector = new Connector();
    QueryCustomerRoom queryCustomerRoom = new QueryCustomerRoom(connector);
    QueryRoomService queryRoomService = new QueryRoomService(connector);
    QueryRoom queryRoom = new QueryRoom(connector);


    public Customer() {

    }

    public Customer(int ID, String name, boolean gender, String phone, boolean is_active) {
        super(ID, name, gender, phone, is_active);

    }

    public Customer(String name, boolean gender, String phone, boolean is_active) {
        super(name, gender, phone, is_active);

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
            for (Service service : s) {
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
    // System.out.println("Enter room id: ");
    // Scanner sc = new Scanner(System.in);
    // int id = sc.nextInt();
    // List<Room> rooms = hotel.getAvailableRoom();
    // Room room = rooms.stream().filter(r -> r.getId() ==
    // id).findFirst().orElse(null);
    // System.out.println("Enter num of day: ");
    // int numOfDay = sc.nextInt();
    // bookedRoom.add(room);
    // hotel.getAvailableRoom().remove(room);
    // room.setAvailable(false);
    // ConnectDatabase connector = new ConnectDatabase();
    // connector.insertCustomerRoom(this.getID(), id, numOfDay);
    // System.out.println("Room booked successfully");
    public void bookRoom(int room_id, int numOfDay, String checkindate) {
        
        List<Room> availableRoom = queryRoom.selectAll();
        boolean flag = availableRoom.stream().anyMatch(room -> room.getId() == room_id);
        if (flag) {
            queryCustomerRoom.insertCustomerRoom(this.getID(), checkindate, room_id, numOfDay);
            System.out.println("Room booked successfully");
            return;
        }
        System.out.println("Room is not available");

    }

    public void checkOut(int room_id) {
        queryRoom.updateAvailableRoom(room_id, true);
        queryCustomerRoom.updateCheckOutDate(this.getID(), room_id);
        System.out.println("Check out successfully");
    }

    public List<Room> getBookedRoom() {
        List<Room> roomList = queryCustomerRoom.selectCustomerRooms(this.getID());
        return roomList;
    }

    public List<Room> getBookedRoom(int roomId) {
        List<Room> roomList = queryCustomerRoom.selectCustomerRooms(this.getID(), roomId);
        return roomList;
    }

    public double CalculatePrice(int room_id) {
        double service = queryRoomService.calculateRoomService(room_id);
        Room room = queryCustomerRoom.selectCustomerRooms(this.getID(), room_id).get(0);
        return service + room.getPrice() * room.getNumOfDay();
    }
    //
    // public static void main(String[] args) {
    // Customer c = new Customer(1, "Huy", true, "123", true);
    // c.bookRoom(1, 2);
    // c.bookRoom(2, 3);
    // c.printBookedRoom();
    // c.printServices();
    // c.printBill();
    // }

}
