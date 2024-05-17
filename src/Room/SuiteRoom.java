package Room;

public class SuiteRoom extends Room {
    private String type = "Suite";
    private String electricDevices;

    public SuiteRoom(int room_id, double price, int numOfBed, String electricDevices, boolean isAvailable) {
        super(room_id, price, numOfBed, isAvailable);
        this.electricDevices = electricDevices;

    }

    public SuiteRoom(int room_id, double price, int numOfBed, String electricDevices, boolean isAvailable, int numOfDay,
            String check_in_date, String e_check_out_date) {
        super(room_id, price, numOfBed, isAvailable, numOfDay, check_in_date, e_check_out_date);
        this.electricDevices = electricDevices;

    }

    // public SuiteRoom(int room_id, double price, int numOfBed, String
    // electricDevices) {
    // super( room_id, price, numOfBed);
    // this.electricDevices = electricDevices;
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
        return "Room Name: SuiteRoom, ID: " + this.getId() + ", Number of Beds: " + this.getNumOfBed()
                + ", Electric Devices: "
                + this.getElectricDevices() + ", Price: " + this.getPrice() + ", Check in date: "
                + this.getCheck_in_date() + ", Number of days: " + this.getNumOfDay() + ", Expected Check out date: "
                + this.getECheckOutDate();
    }

    public double calculatePrice() {
        return this.getNumOfDay() * (this.getPrice() + (this.getNumOfBed() - 1) * 50);
    }

}
