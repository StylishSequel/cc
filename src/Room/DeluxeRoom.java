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
    
    public DeluxeRoom(int int1, double double1, int int2, String string) {
        super(int1, double1, int2);
        this.furniture = string;

    }
    public String getFurniture() {
        return furniture;
    }
    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }
    

    public double calculatePrice(){
        return this.getNumOfDay()*this.getPrice() + (this.getNumOfBed()-1)*50;
    }
}
