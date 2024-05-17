package Room;

import Service.Service;
import java.util.List;

public class StandardRoom extends Room {
    private String type = "StandardRoom";
    private boolean havingShower;

    public StandardRoom(int room_id, double price, String check_in_date, int numOfDay, int numOfBed,
            boolean isAvailable, String type, boolean havingShower) {
        super(room_id, price, check_in_date, numOfDay, numOfBed, isAvailable, type);
        this.havingShower = havingShower;
    }

    public StandardRoom() {
        super();
        this.havingShower = false;

    }

    public StandardRoom(int room_id, double price, int numOfBed, Boolean havingShower, boolean isAvailable, int numOfDay,
            String check_in_date, String e_check_out_date) {
        super(room_id, price, numOfBed, isAvailable, numOfDay, check_in_date, e_check_out_date);
        this.havingShower = havingShower;

    }

    public StandardRoom(int id, double price, int num_of_bed, boolean havingShower, boolean isAvailable) {
        super(id, price, num_of_bed, isAvailable);
        this.havingShower = havingShower;
    }

    public StandardRoom(double price, int num_of_bed, boolean havingShower) {
        super(price, num_of_bed);
        this.havingShower = havingShower;
        this.setAvailable(true);
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

    public double calculatePrice() {
        int showerPrice = this.isHavingShower() ? 50 : 0;
        return this.getNumOfDay() * (this.getPrice() + this.getNumOfBed() * 50 + showerPrice);
    }

}
