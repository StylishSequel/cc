

import java.util.List;


public class DeluxeRoom extends Room{
    private String furniture ;
    private int numOfUnit;
    
    
    // Import data into Database
    
    public DeluxeRoom(int room_id, double price, String check_in_date, int numOfDay, int numOfBed, boolean isAvailable,
            String type, List<Service> bookedService, String furniture, int numOfUnit) {
        super(room_id, price, check_in_date, numOfDay, numOfBed, isAvailable, type, bookedService);
        this.furniture = furniture;
        this.numOfUnit = numOfUnit;
    }
    public DeluxeRoom() {
        super();
        this.furniture = "";
        this.numOfUnit = 0;
    }
    
    public String getFurniture() {
        return furniture;
    }
    public void setFurniture(String furniture) {
        this.furniture = furniture;
    }
    public int getNumOfUnit() {
        return numOfUnit;
    }
    public void setNumOfUnit(int numOfUnit) {
        this.numOfUnit = numOfUnit;
    }

    public double calculatePrice(){
        return this.getNumOfDay()*this.getPrice() + this.numOfUnit*100;
    }
    
}
