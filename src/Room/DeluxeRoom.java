package Room;
import Service.Service;
import java.util.List;


public class DeluxeRoom extends Room{
    private String furniture ;
    
    

    
    public DeluxeRoom(int room_id, double price, String check_in_date, int numOfDay, int numOfBed, boolean isAvailable,
            String type, List<Service> bookedService, String furniture) {
        super(room_id, price, check_in_date, numOfDay, numOfBed, isAvailable, type, bookedService);
        this.furniture = furniture;
    
    }
    public DeluxeRoom() {
        super();
        this.furniture = "";
       
    }
    public DeluxeRoom(double price, int numOfBed, String furniture) {
        super(price, numOfBed);
        this.furniture = furniture;
    }
    
    
    public DeluxeRoom(int ID, double price, int numOfBed , String furniture) {
        super(ID, price, numOfBed);
        this.furniture = furniture;
    }
    public String getFurniture() {
        return furniture;
    }
    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }
    public String toString() {
        return "Room Name: DeluxeRoom, ID: " + this.getId() + ", Number of Beds: " + this.getNumOfBed();
    }

    public double calculatePrice(){
        return this.getNumOfDay()*this.getPrice() + (this.getNumOfBed()-1)*50;
    }
}
