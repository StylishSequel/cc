package Person;
import ConnectDatabase.ConnectDatabase;
import Room.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Hotel.Hotel;



public class Customer extends Person {
    private List<Room> bookedRoom;
    // private List<Service> Services;

    public Customer(int ID, String name, boolean gender, String phone){
        super(ID, name, gender, phone);
        bookedRoom = new ArrayList<>();
        
    }
    public List<Room> getBookedRoom(){
        return bookedRoom;
    }
    // public List<Service> getServices(){
    //     return Services;
    // }

    // public void bookRoom(Hotel hotel){
    //     System.out.println("Enter room id: ");
    //     Scanner sc = new Scanner(System.in);
    //     int id = sc.nextInt();
    //     List<Room> rooms = hotel.getAvailableRoom();
    //     for(Room room : rooms){
    //         if(room.getId() == id){
    //             bookedRoom.add(room);
    //             room.setAvailable(false);
    //             System.out.println("Room booked successfully");
    //         }
    //         else {
    //             System.out.println("Room is not found");
    //         }
    //     }
    // }
    // public void bookService(Hotel h){
    //     System.out.println("Enter service id: ");
    //     Scanner sc = new Scanner(System.in);
    //     int id = sc.nextInt();
    //     List<Service> services = h.getServices();
    //     for(Service service : services){
    //         if(service.getId() == id){
    //             Services.add(service);
    //             System.out.println("Service booked successfully");
    //         }
    //         else {
    //             System.out.println("Service is not found");
    //         }
    //     }
    // }
    public void bookRoom(Hotel hotel){
        System.out.println("Enter room id: ");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Enter num of day: ");
            int numOfDay = sc1.nextInt();
            
            

            List<Room> rooms = hotel.getAvailableRoom();
            ConnectDatabase connect = new ConnectDatabase();
            for(Room room : rooms){
                if(room.getId() == id){
                    bookedRoom.add(room);
                    room.setAvailable(false);
                    connect.insertBookingRoom(this.getID(),id, numOfDay) ;
                    System.out.println("Room booked successfully");
                }
                else {
                    System.out.println("Room is not found");
                }
            }

    }
    public void printBookedRoom(){
        for(Room room : bookedRoom){
            System.out.println(room);
        }
    }

    // public void printServices(){
    //     for(Service service : Services){
    //         System.out.println(service.toString());
    //     }
    // }
    
    // public double printBill() {
    //     double total = 0;
    //     for (Room room : bookedRoom) {
    //         total += room.getPrice();
    //     }
    //     for(Service service : Services){
    //         total += service.getPrice();
    //     }
    //     System.out.print("Total: " + total);
    //     return total;
    // }
}

