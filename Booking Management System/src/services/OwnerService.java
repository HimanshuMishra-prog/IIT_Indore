package services;

import models.Room;
import models.Customer;
import models.Hotel;
import util.JSONUtil;

import java.util.List;
import java.util.stream.Collectors;

public class OwnerService {

    private Hotel hotel;

    public OwnerService(Hotel hotel) {
        this.hotel = hotel;
    }

    public void addRoom(Room room) {
        hotel.getRooms().add(room);
        JSONUtil.saveRoomsToFile(hotel.getRooms());
    }

    public boolean changePrice(int roomNumber, int newPrice) {
        Room room = hotel.getRooms().stream()
                .filter(r -> r.getRoomNumber() == roomNumber)
                .findFirst()
                .orElse(null);

        if (room != null && !room.isOccupied()) {
            room.setPrice(newPrice);
            JSONUtil.saveRoomsToFile(hotel.getRooms());
            return true;
        }
        return false;
    }

    public List<Room> getAvailableRooms() {
        return hotel.getRooms().stream()
                .filter(room -> !room.isOccupied())
                .collect(Collectors.toList());
    }

    public List<Room> getOccupiedRooms() {
        return hotel.getRooms().stream()
                .filter(room -> room.isOccupied())
                .collect(Collectors.toList());
    }

    public List<Customer> getCurrentCustomers() {
        return hotel.getCustomers().stream()
                .filter(Customer::isRoomAlloted)
                .collect(Collectors.toList());
    }
}
