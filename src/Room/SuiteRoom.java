package Room;


public class SuiteRoom extends Room{
    private String type = "Suite";
    private String electricDevices;
    private int numOfUnit;
   
    public SuiteRoom(int room_id, double price, int numOfDay, String type, String electricDevices) {
        super(room_id, price, numOfDay);
        this.electricDevices = electricDevices;
        
    }

    public SuiteRoom(String electricDevices, int numOfUnit) {
        this.electricDevices = electricDevices;
        this.numOfUnit = numOfUnit;
    }

    public SuiteRoom(int int1, double double1, int int2, String string) {
        super(int1, double1, int2);
        this.electricDevices = string;
    }

    public String getElectricDevices() {
        return electricDevices;
    }

    public void setElectricDevices(String electricDevices) {
        this.electricDevices = electricDevices;
    }

    public int getNumOfUnit() {
        return numOfUnit;
    }

    public void setNumOfUnit(int numOfUnit) {
        this.numOfUnit = numOfUnit;
    }
    public String getType() {
        return type;
    }
    public double calculatePrice(){
        return this.getNumOfDay()*(this.getPrice() + (this.getNumOfBed()-1)*50) + this.numOfUnit*100;
    }

    
}
