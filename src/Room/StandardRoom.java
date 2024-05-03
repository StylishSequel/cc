package Room;
import Service.Service;
import java.util.List;

public class StandardRoom extends Room {
    private boolean havingShower ;
    
    
    public StandardRoom(int room_id, double price, String check_in_date, int numOfDay, int numOfBed,
            boolean isAvailable, String type, List<Service> bookedService, boolean havingShower) {
        super(room_id, price, check_in_date, numOfDay, numOfBed, isAvailable, type, bookedService);
        this.havingShower = havingShower;
    }

    public StandardRoom(boolean havingShower) {
        this.havingShower = havingShower;
    }

    public StandardRoom( double price, int numOfBed, boolean havingShower) {
        super(price, numOfBed);
        this.havingShower = havingShower;
    }

    public StandardRoom(int id, double price, int num_of_bed, boolean havingShower) {
        super(id, price, num_of_bed);
        this.havingShower = havingShower;
    }

    public boolean isHavingShower() {
        return havingShower;
    }

    public void setHavingShower(boolean havingShower) {
        this.havingShower = havingShower;
    };
    public String toString() {
        return "Room Name: StandardRoom, ID: " + this.getId() + ", Number of Beds: " + this.getNumOfBed();
    }
    public double calculatePrice(){
        int showerPrice = this.isHavingShower() ? 50 : 0;
        return this.getNumOfDay() * (this.getPrice() + this.getNumOfBed() * 50 + showerPrice);
    }

    
}
