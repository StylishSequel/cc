package Room;


public class SuiteRoom extends Room{
    private String type = "Suite";
    private String electricDevices;

   
    public SuiteRoom(int room_id, double price, int numOfDay, String type, String electricDevices) {
        super(room_id, price, numOfDay);
        this.electricDevices = electricDevices;
        
    }

    public SuiteRoom(int room_id, double price, int numOfDay, String electricDevices) {
        super();
        this.electricDevices = "";
    }
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
        return "SuiteRoom [electricDevices=" + electricDevices + ", getId()=" + getId() + ", getPrice()=" + getPrice()
                + ", getNumOfDay()=" + getNumOfDay() + ", getNumOfBed()=" + getNumOfBed() + "]";
    }
    public double calculatePrice(){
        return this.getNumOfDay()*(this.getPrice() + (this.getNumOfBed()-1)*50) ;
    }

    
}
