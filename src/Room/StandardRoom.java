package Room;



public class StandardRoom extends Room {
    private String type ="StandardRoom";
    private boolean havingShower ;
    
    
    public StandardRoom(int room_id, double price, String check_in_date, int numOfDay, int numOfBed,
            boolean isAvailable, String type, boolean havingShower) {
        super(room_id, price, check_in_date, numOfDay, numOfBed, isAvailable, type);
        this.havingShower = havingShower;
    }

    

    

    public StandardRoom(int id, double price, int num_of_bed, boolean havingShower, boolean isAvailable) {
        super(id, price, num_of_bed, isAvailable);
        this.havingShower = havingShower;

    }

    public StandardRoom(double price, int beds, boolean b) {
        super(price, beds);
        this.havingShower = b;
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
    public String getType() {
        return type;
    }
    public double calculatePrice(){
        int showerPrice = this.isHavingShower() ? 50 : 0;
        return this.getNumOfDay() * (this.getPrice() + this.getNumOfBed() * 50 + showerPrice);
    }

    
}
