package services;

import models.Customer;
import models.Room;
import models.Hotel;
import util.JSONUtil;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

	private Hotel hotel;

	public CustomerService(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Room> searchRoomsBelowPrice(int maxPrice) {
		return hotel.getRooms().stream().filter(room -> room.getPrice() <= maxPrice && !room.isOccupied())
				.collect(Collectors.toList());
	}

	public boolean bookRoom(Customer customer, int roomNumber) {
		if (customer != null && !customer.isRoomAlloted()) {
			Room room = hotel.getRooms().stream().filter(r -> r.getRoomNumber() == roomNumber).findFirst().orElse(null);

			if (room != null && !room.isOccupied()) {
				room.setOccupied(true);
				room.setCustomerId(customer.getId());
				customer.setRoomAlloted(true);
				customer.setRoomNumber(roomNumber);
				JSONUtil.saveRoomsToFile(hotel.getRooms());
				JSONUtil.saveCustomersToFile(hotel.getCustomers());
				return true;

			}
		}
		return false;
	}

	public boolean checkoutRoom(Customer customer) {

		if (customer != null && customer.isRoomAlloted()) {
			Room room = hotel.getRooms().stream().filter(r -> r.getRoomNumber() == customer.getRoomNumber()).findFirst()
					.orElse(null);

			if (room != null) {
				room.setOccupied(false);
				room.setCustomerId(-1);

				customer.setRoomAlloted(false);
				customer.setRoomNumber(-1);

				JSONUtil.saveRoomsToFile(hotel.getRooms());
				JSONUtil.saveCustomersToFile(hotel.getCustomers());
				return true;
			}
		}
		return false;
	}
}
