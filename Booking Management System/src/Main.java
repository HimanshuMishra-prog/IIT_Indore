import models.Customer;
import models.Owner;
import models.Room;
import models.Hotel;
import services.CustomerService;
import services.OwnerService;
import util.JSONUtil;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Load data
        List<Customer> customers = JSONUtil.loadCustomersFromFile();
        List<Room> rooms = JSONUtil.loadRoomsFromFile();
        Hotel hotel = new Hotel(rooms, customers, null); // Passing null for owners; we'll handle the single owner separately

        // Load the single owner
        Owner owner = JSONUtil.loadOwnerFromFile(); // Assuming you have this method to load the single owner
        hotel.setOwner(owner); // Assuming Hotel has a method to set a single owner

        // Create services
        CustomerService customerService = new CustomerService(hotel);
        OwnerService ownerService = new OwnerService(hotel);

        Scanner scanner = new Scanner(System.in);

        // User login
        System.out.println("WELCOME TO BOOKING MANAGEMENT SYSTEM \n Press \'C\' for customer \'A\' for admin");
        char user = Character.toLowerCase(scanner.next().charAt(0));
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Check if the ID and password match the single owner
        if (user == 'a' && owner != null && owner.getId() == id && owner.getPassword().equals(password)) {
            // Owner login
            System.out.println("Welcome, Owner " + owner.getName());
            boolean exit = false;
            while (!exit) {
                System.out.println("1. Add Room");
                System.out.println("2. Change Price");
                System.out.println("3. View Available Rooms");
                System.out.println("4. View Occupied Rooms");
                System.out.println("5. View Current Customers");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Enter room number: ");
                        int roomNumber = scanner.nextInt();
                        System.out.print("Enter room price: ");
                        int price = scanner.nextInt();
                        scanner.nextLine();
                        Room room =  new Room(roomNumber , price , false , -1);
                        ownerService.addRoom(room);
                        break;
                    case 2:
                        System.out.print("Enter room number: ");
                        roomNumber = scanner.nextInt();
                        System.out.print("Enter new price: ");
                        price = scanner.nextInt();
                        scanner.nextLine();
                        ownerService.changePrice(roomNumber, price);
                        break;
                    case 3:
                        System.out.println("Available Rooms:");
                        List<Room> availableRooms = ownerService.getAvailableRooms();
                        availableRooms.forEach(r -> System.out.println("Room " + r.getRoomNumber() + " - Price: " + r.getPrice()));
                        break;
                    case 4:
                        System.out.println("Occupied Rooms:");
                        List<Room> occupiedRooms = ownerService.getOccupiedRooms();
                        occupiedRooms.forEach(r -> System.out.println("Room " + r.getRoomNumber() + " - Occupied by Customer ID: " + r.getCustomerId()));
                        break;
                    case 5:
                        System.out.println("Current Customers:");
                        List<Customer> currentCustomers = ownerService.getCurrentCustomers();
                        currentCustomers.forEach(c -> System.out.println("Customer ID: " + c.getId() + " - Name: " + c.getName()));
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } else if (user == 'c') {
            Customer customer = hotel.getCustomers().stream()
                    .filter(c -> c.getId() == id && c.getPassword().equals(password))
                    .findFirst()
                    .orElse(null);

            if (customer != null) {
                System.out.println("Welcome, Customer " + customer.getName());
                boolean exit = false;
                while (!exit) {
                    System.out.println("1. Search for Rooms Below a Certain Price");
                    System.out.println("2. Book a Room");
                    System.out.println("3. Checkout from a Room");
                    System.out.println("4. Exit");
                    System.out.print("Choose an option: ");
                    int option = scanner.nextInt();
                    scanner.nextLine();

                    switch (option) {
                        case 1:
                            System.out.print("Enter maximum price: ");
                            int maxPrice = scanner.nextInt();
                            scanner.nextLine();
                            List<Room> affordableRooms = customerService.searchRoomsBelowPrice(maxPrice);
                            affordableRooms.forEach(r -> System.out.println("Room " + r.getRoomNumber() + " - Price: " + r.getPrice()));
                            break;
                        case 2:
                            System.out.print("Enter room number to book: ");
                            int roomNumber = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            boolean booked = customerService.bookRoom(customer, roomNumber);
                            if (booked) {
                                System.out.println("Room booked successfully.");
                            } else {
                                System.out.println("Failed to book room. It may be occupied or invalid.");
                            }
                            break;
                        case 3:
                            boolean checkedOut = customerService.checkoutRoom(customer);
                            if (checkedOut) {
                                System.out.println("Checked out successfully.");
                            } else {
                                System.out.println("Failed to checkout. You may not have a room allocated.");
                            }
                            break;
                        case 4:
                            exit = true;
                            System.out.println("Thankyou for logging in to our system");
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                }
            } else {
                System.out.println("Invalid choice");
            }
        }else {
                System.out.println("Invali user id and password");
        }

        scanner.close();
    }
}
