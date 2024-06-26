package Room;
import Service.Service;
import java.util.List;


public class DeluxeRoom extends Room{
    private String type = "DeluxeRoom";
    private String furniture ;

    public DeluxeRoom (double price, int numOfBed, boolean isAvailable, String type, String furniture) {
        super(price, numOfBed,isAvailable);
        this.type = type;
        this.furniture = furniture;
    }
    
    public DeluxeRoom(int room_id, double price, int numOfBed, String furniture, boolean isAvailable, int numOfDay,
            String check_in_date, String e_check_out_date) {
        super(room_id, price, numOfBed, isAvailable, numOfDay, check_in_date, e_check_out_date);
        this.furniture = furniture;

    }
    
    public DeluxeRoom(int room_id, double price, String check_in_date, int numOfDay, int numOfBed, boolean isAvailable,
            String type,  String furniture) {
        super(room_id, price, check_in_date, numOfDay, numOfBed, isAvailable, type);
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
    
    
    public DeluxeRoom(int ID, double price, int numOfBed , String furniture,Boolean isAvailable) {
        super(ID, price, numOfBed, isAvailable);
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
    public String getType() {
        return type;
    }
    public double calculatePrice(){
        return this.getNumOfDay()*this.getPrice() + (this.getNumOfBed()-1)*50;
    }
}
