package GUI;

public class Room {
    private String roomName;
    private String roomType;
    private int roomCapacity;
    public Room(String roomName,int roomCapacity, String roomType) {
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomCapacity = roomCapacity;
    }
    public String getName() {
        return roomName;
    }
    public void setName(String roomName) {
        this.roomName = roomName;
    }
    public String getType() {
        return roomType;
    }
    public void setType(String roomType) {
        this.roomType = roomType;
    }
    public int getCapacity() {
        return roomCapacity;
    }
}
