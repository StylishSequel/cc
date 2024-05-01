package Person;
import ConnectDatabase.ConnectDatabase;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Hotel.Hotel;
import Room.*;
import Service.Service;

public class Customer extends Person {
    private List<Room> bookedRoom;


    public Customer(int ID, String name, boolean gender, String phone){
        super(ID, name, gender, phone);
        bookedRoom = new ArrayList<>();
    }
    public List<Room> getBookedRoom(){
        return bookedRoom;
    }

    

//    public void bookService(Hotel h){
//        System.out.println("Enter service id: ");
//        Scanner sc = new Scanner(System.in);
//        int id = sc.nextInt();
//        List<Service> services = h.getServices();
//        for(Service service : services){
//            if(service.getId() == id){
//                Services.add(service);
//                System.out.println("Service booked successfully");
//            }
//            else {
//                System.out.println("Service is not found");
//            }
//        }
//    }

    public void printBookedRoom(){
        for(Room room : bookedRoom){
            System.out.println(room);
        }
    }

    public void printServices(){
        for(Room room : bookedRoom){
            List<Service> s = room.getBookedService();
            for(Service service : s){
                System.out.println(service.toString());
            }
        }
    }

    public double getBill() {
        double total = 0;
        for (Room room : bookedRoom) {
            total += room.getPrice();
            List<Service> s = room.getBookedService();
            for(Service service : s){
                total += service.getPrice();
            }
        }
        System.out.print("Total: " + total);
        return total;
    }

    public double printBill() {
        double total = 0;
        for (Room room : bookedRoom) {
            double curTotal = 0;
            total += room.getPrice();
            List<Service> s = room.getBookedService();

            System.out.println(room.toString());
            for(Service service : s){
                total += service.getPrice();
                curTotal += service.getPrice();

                System.out.println(service.toString());
            }
            curTotal = room.getPrice();
            System.out.println("Total: " + curTotal);
        }
        System.out.print("Total: ");
        return total;
    }
    public void bookRoom(Hotel hotel){
        System.out.println("Enter room id: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        List<Room> rooms = hotel.getAvailableRoom();
        for(Room room : rooms){
            if(room.getId() == id){
                System.out.println("Enter num of day: ");
                int numOfDay = sc.nextInt();
                bookedRoom.add(room);
                hotel.getAvailableRoom().remove(room);
                room.setAvailable(false);
                ConnectDatabase connector = new ConnectDatabase();
                connector.insertCustomerRoom(this.getID(), id, numOfDay);
                System.out.println("Room booked successfully");
            }
            else {
                System.out.println("Room is not found");
            }
        }

        
            // ID chỉ có 1 nên không cần dùng for
    
            // Room r = rooms.stream().filter(room -> room.getId() == id).findFirst().orElse(null);
            // if (r == null) {
            //     System.out.println("Room is not found");
            //     return;
            // }
            // r.setAvailable(false);
            // System.out.println("Room booked successfully");
            // bookedRoom.add(r);
        
        sc.close();
    }
}

