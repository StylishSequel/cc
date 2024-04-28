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

    public StandardRoom(int int1, double double1, int int2, boolean boolean1) {
        super(int1, double1, int2);
        this.havingShower = boolean1;
    }

    public boolean isHavingShower() {
        return havingShower;
    }

    public void setHavingShower(boolean havingShower) {
        this.havingShower = havingShower;
    };

    public double calculatePrice(){
        int showerPrice = this.isHavingShower() ? 50 : 0;
        return this.getNumOfDay() * (this.getPrice() + this.getNumOfBed() * 50 + showerPrice);
    }

    
}
