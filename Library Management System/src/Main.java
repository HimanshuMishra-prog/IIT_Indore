import models.*;
import services.*;

import java.util.InputMismatchException;
//import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		LibraryService libraryService = new LibraryService();
		UserService userService = new UserService();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("Welcome to the Library Management System!");
			System.out.println("1. Login");
			System.out.println("2. Exit");
			choice = scanner.nextInt();
			scanner.nextLine();

			if (choice == 1) {
				System.out.println("Enter ID:");
				String id = scanner.nextLine();
				System.out.println("Enter Password:");
				String password = scanner.nextLine();

				User user = userService.login(id, password);
				if (user != null) {
					System.out.println("Logged in as: " + user.getClass().getSimpleName());
					if (user instanceof Admin) {
						handleAdmin((Admin) user, libraryService, userService, scanner);
					} else if (user instanceof Librarian) {
						handleLibrarian((Librarian) user, libraryService, userService, scanner);
					} else if (user instanceof Member) {
						handleMember((Member) user, libraryService, scanner);
					}
				} else {
					System.out.println("Invalid credentials");
				}
			}
		} while (choice != 2);
		System.out.println("Thankyou for logging in");
	}

	private static void handleAdmin(Admin admin, LibraryService libraryService, UserService userService,
			Scanner scanner) {
		int choice = 0;
		do {
			System.out.println("Admin Menu:");
			System.out.println("1. Add Librarian");
			System.out.println("2. Add Member");
			System.out.println("3. Add Book");
			System.out.println("4. Remove Librarian");
			System.out.println("5. Remove Member");
			System.out.println("6. Remove Book");
			System.out.println("7. Logout");
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid choice");
			}
			scanner.nextLine();

			switch (choice) {
			case 1:
				// Add Librarian
				System.out.println("Enter Librarian ID:");
				String libId = scanner.nextLine();
				System.out.println("Enter Password:");
				String libPassword = scanner.nextLine();
				System.out.println("Enter Name:");
				String libName = scanner.nextLine();
				userService.addUser(new Librarian(libId, libPassword, libName));
				break;

			case 2:
				// Add Member
				System.out.println("Enter Member ID:");
				String memId = scanner.nextLine();
				System.out.println("Enter Password:");
				String memPassword = scanner.nextLine();
				System.out.println("Enter Name:");
				String memName = scanner.nextLine();
				userService.addUser(new Member(memId, memPassword, memName, false));
				break;

			case 3:
				// Add Book
				System.out.println("Enter Book ID:");
				String bookId = scanner.nextLine();
				System.out.println("Enter Title:");
				String title = scanner.nextLine();
				System.out.println("Enter Author:");
				String author = scanner.nextLine();
				libraryService.addBook(new Book(bookId, title, author, false));
				break;

			case 4:
				// Remove Librarian
				System.out.println("Enter Librarian ID to Remove:");
				String removeLibId = scanner.nextLine();
				userService.removeUser(removeLibId);
				break;

			case 5:
				// Remove Member
				System.out.println("Enter Member ID to Remove:");
				String removeMemId = scanner.nextLine();
				userService.removeUser(removeMemId);
				break;

			case 6:
				// Remove Book
				System.out.println("Enter Book ID to Remove:");
				String removeBookId = scanner.nextLine();
				libraryService.removeBook(removeBookId);
				break;

			case 7:
				System.out.println("Successfully Logged Out");
				break;

			default:
				System.out.println("Invalid option");
				break;
			}
		} while (choice != 7);
	}

	private static void handleLibrarian(Librarian librarian, LibraryService libraryService, UserService userService,
			Scanner scanner) {
		// Librarian-specific operations
		int choice = 0;
		do {
			System.out.println("Librarian Menu:");
			System.out.println("1. Issue Book");
			System.out.println("2. Return Book");
			System.out.println("3. Suspend Member");
			System.out.println("4. Logout");
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid choice");
			}
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				// Issue Book
				System.out.println("Enter Book ID:");
				String bookId = scanner.nextLine();
				libraryService.changeBookStatus(bookId, true);
				break;

			case 2:
				// Return Book
				System.out.println("Enter Book ID:");
				String returnBookId = scanner.nextLine();
				libraryService.changeBookStatus(returnBookId, false);
				break;

			case 3:
				// Suspend Member
				System.out.println("Enter Member ID:");
				String memberId = scanner.nextLine();
				userService.suspendMember(memberId);
				break;
				
			case 4:
				System.out.println("Successfully Logged Out");
				break;

			default:
				System.out.println("Invalid option");
				break;
			}
		} while (choice != 4);
	}

	private static void handleMember(Member member, LibraryService libraryService, Scanner scanner) {
		// Member-specific operations
		int choice = 0;
		do {
			System.out.println("Member Menu:");
			System.out.println("1. Search Book");
			System.out.println("2. Issue Book");
			System.out.println("3. Return Book");
			System.out.println("4. Logout");
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Invalid choice");
			}
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				// Search Book
				System.out.println("Enter Book Title:");
				String title = scanner.nextLine();
				if (libraryService.searchBook(title)) {
					System.out.println("Your book with " + title + "is present");
				} else {
					System.err.println("The required book is not present");
				}
				break;

			case 2:
				// Issue Book
				System.out.println("Enter Book ID:");
				String bookId = scanner.nextLine();
				libraryService.changeBookStatus(bookId, true);
				break;

			case 3:
				// Return Book
				System.out.println("Enter Book ID:");
				String returnBookId = scanner.nextLine();
				libraryService.changeBookStatus(returnBookId, false);
				break;
			
			case 4:
				System.out.println("Successfully Logged Out");
				break;

			default:
				System.out.println("Invalid option");
				break;
			}
		} while (choice != 4);
	}
}
