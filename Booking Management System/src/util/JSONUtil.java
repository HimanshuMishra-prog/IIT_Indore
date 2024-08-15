package util;

import models.Customer;
import models.Owner;
import models.Room;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JSONUtil {

	public static List<Customer> loadCustomersFromFile() {
		List<Customer> customers = new ArrayList<>();
		try {
			String content = new String(Files.readAllBytes(Paths.get("data/customer.json")));
			JSONArray jsonArray = new JSONArray(content);
			for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Customer customer = new Customer(
                        jsonObject.getInt("id"),
                        jsonObject.getString("password"),
                        jsonObject.getString("name"),
                        jsonObject.getBoolean("isRoomAlloted"),
                        jsonObject.getInt("roomNumber")
                );
                customers.add(customer);
            }
		} catch (IOException e) {
			e.printStackTrace();
			return customers;
		}
		return customers;
	}

	public static List<Room> loadRoomsFromFile() {
		List<Room> rooms = new ArrayList<>();
		try {
			String content = new String(Files.readAllBytes(Paths.get("data/room.json")));
			JSONArray jsonArray = new JSONArray(content);
			for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Room room = new Room(
                		jsonObject.getInt("roomNumber"),
                		jsonObject.getInt("price"),
                        jsonObject.getBoolean("isOccupied"),
                        jsonObject.getInt("customerId")
                );
                rooms.add(room);
            }
		} catch (IOException e) {
			e.printStackTrace();
			return rooms;
		}
		return rooms;
	}

	public static void saveCustomersToFile(List<Customer> customers) {
		JSONArray jsonArray = new JSONArray();
		customers.forEach(customer -> {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("id", customer.getId());
			jsonObj.put("password", customer.getPassword());
			jsonObj.put("name", customer.getName());
			jsonObj.put("isRoomAlloted", customer.isRoomAlloted());
			jsonObj.put("roomNumber", customer.getRoomNumber());
			jsonArray.put(jsonObj);
		});
		try (FileWriter file = new FileWriter("data/customer.json")) {
			file.write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveRoomsToFile(List<Room> rooms) {
		JSONArray jsonArray = new JSONArray();
		rooms.forEach(room -> {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("roomNumber", room.getRoomNumber());
			jsonObj.put("price", room.getPrice());
			jsonObj.put("isOccupied", room.isOccupied());
			jsonObj.put("customerId", room.getCustomerId());
			jsonArray.put(jsonObj);
		});
		try (FileWriter file = new FileWriter("data/room.json")) {
			file.write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Owner loadOwnerFromFile() {
		try {
			String content = new String(Files.readAllBytes(Paths.get("data/owner.json")));
			JSONArray jsonArray = new JSONArray(content);
			JSONObject ownerJson = jsonArray.getJSONObject(0);
			Owner owner = new Owner(ownerJson.getInt("id"), ownerJson.getString("password"),
					ownerJson.getString("name"));
			return owner;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
