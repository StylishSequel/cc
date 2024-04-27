

import java.util.List;

public class SuiteRoom extends Room{
    private String electricDevices;
    private int numOfUnit;
   
    public SuiteRoom(int room_id, double price, String check_in_date, int numOfDay, int numOfBed, boolean isAvailable,
            String type, List<Service> bookedService, String electricDevices, int numOfUnit) {
        super(room_id, price, check_in_date, numOfDay, numOfBed, isAvailable, type, bookedService);
        this.electricDevices = electricDevices;
        this.numOfUnit = numOfUnit;
    }

    public SuiteRoom(String electricDevices, int numOfUnit) {
        this.electricDevices = electricDevices;
        this.numOfUnit = numOfUnit;
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

    public double calculatePrice(){
        return this.getNumOfDay()*(this.getPrice() + (this.getNumOfBed()-1)*50) + this.numOfUnit*100;
    }
    

}
