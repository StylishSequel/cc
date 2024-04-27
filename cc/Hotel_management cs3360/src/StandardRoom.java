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

    public boolean isHavingShower() {
        return havingShower;
    }

    public void setHavingShower(boolean havingShower) {
        this.havingShower = havingShower;
    };

    @Override
    public double calculatePrice(){
        int showerPrice = this.isHavingShower() ? 50 : 0;
        return this.getNumOfDay() * (this.getPrice() + this.getNumOfBed() * 50 + showerPrice);
    }

    
}
