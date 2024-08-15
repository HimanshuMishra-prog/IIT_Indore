package models;


public class Room {
	private int roomNumber;
    private int price;
    private boolean isOccupied;
    private int customerId;

    public Room(int roomNumber, int price, boolean isOccupied, int customerId) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.isOccupied = isOccupied;
        this.customerId = customerId;
    }
    
    public int getPrice() { return price;}

    public void setPrice(int price) {
        this.price = price;
    }
    public boolean isOccupied() {return isOccupied;}
    public void setOccupied(boolean occupied) {isOccupied = occupied;}
    public int getCustomerId() {return customerId;}
    public void setCustomerId(int customerId) { this.customerId = customerId;}
    public int getRoomNumber() {return roomNumber;}
    public void setRoomNumber(int roomNumber) {this.roomNumber = roomNumber;}

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", price=" + price +
                ", isOccupied=" + isOccupied +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}

