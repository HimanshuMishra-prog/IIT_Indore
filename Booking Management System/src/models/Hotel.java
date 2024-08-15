package models;

import java.util.List;

public class Hotel {
    private List<Room> rooms;
    private List<Customer> customers;
    private Owner owner;

    // Constructors
    public Hotel(List<Room> rooms, List<Customer> customers, Owner owner) {
        this.rooms = rooms;
        this.customers = customers;
        this.owner = owner;
    }

    public List<Room> getRooms() {return rooms;}
    public void setRooms(List<Room> rooms) {this.rooms = rooms;}
    public List<Customer> getCustomers() {return customers;}
    public void setCustomers(List<Customer> customers) { this.customers = customers;}
    public Owner getOwner() {return owner;}
    public void setOwner(Owner owner) { this.owner = owner;}

    @Override
    public String toString() {
        return "Hotel{" +
                "rooms=" + rooms +
                ", customers=" + customers +
                '}';
    }
}
