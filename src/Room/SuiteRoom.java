package Room;


public class SuiteRoom extends Room{
    private String type = "Suite";
    private String electricDevices;

   
    public SuiteRoom(int room_id, double price, int numOfBed, String electricDevices, boolean isAvailable) {
        super(room_id, price, numOfBed, isAvailable);
        this.electricDevices = electricDevices;
        
    }

    // public SuiteRoom(int room_id, double price, int numOfBed, String electricDevices) {
    //     super( room_id, price, numOfBed);
    //     this.electricDevices = electricDevices;
    // }
    public SuiteRoom(double price, int numOfBed, String electricDevices) {
        super(price, numOfBed);
        this.electricDevices = electricDevices;
    }



    public String getElectricDevices() {
        return electricDevices;
    }

    public void setElectricDevices(String electricDevices) {
        this.electricDevices = electricDevices;
    }




    public String getType() {
        return type;
    }
    public String toString() {
        return "Room Name: SuiteRoom, ID: " + this.getId() + ", Number of Beds: " + this.getNumOfBed();
    }
    public double calculatePrice(){
        return this.getNumOfDay()*(this.getPrice() + (this.getNumOfBed()-1)*50) ;
    }

    
}
