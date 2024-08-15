package models;

public class Customer {
	private int id;
	private String name;
	private String password;
	private boolean isRoomAlloted;
	private int roomNumber;

	public Customer(int id, String password, String name, boolean isRoomAllocated, int roomNumber) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.isRoomAlloted = isRoomAllocated;
		this.roomNumber = roomNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRoomAlloted() {
		return isRoomAlloted;
	}

	public void setRoomAlloted(boolean isRoomAllocated) {
		this.isRoomAlloted = isRoomAllocated;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + id + ", password='" + password + '\'' + ", name='" + name + '\''
				+ ", isRoomAlloted=" + isRoomAlloted + ", roomNumber=" + roomNumber + '}';
	}
}
