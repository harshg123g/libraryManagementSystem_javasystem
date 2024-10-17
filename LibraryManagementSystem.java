import java.util.ArrayList;  // Importing ArrayList class for dynamic array operations
import java.util.HashMap;    // Importing HashMap class for key-value pair storage
import java.util.Scanner;    // Importing Scanner class for input handling

public class LibraryManagementSystem {
    // Declaring constants and variables
    private static final Scanner scanner = new Scanner(System.in); // Scanner for user input
    private static final ArrayList<String> availableBooks = new ArrayList<>(); // List to store available books
    private static final HashMap<String, String> issuedBooks = new HashMap<>(); // Map to store issued books with user info
    private static String loggedInUser = null; // Variable to track the logged-in user

    public static void main(String[] args) {
        initializeBooks(); // Initialize the list of books

        while (true) { // Infinite loop for the program
            clearScreen(); // Clear the console screen
            System.out.println("Welcome to the Library Management System");
            if (loggedInUser == null) { // Check if the user is not logged in
                signIn(); // Call sign-in method
            } else {
                showMainMenu(); // Call method to show the main menu if logged in
            }
        }
    }

    private static void initializeBooks() {
        // Adding books to the availableBooks list
        availableBooks.add("Java Programming");
        availableBooks.add("Data Structures");
        availableBooks.add("Design Patterns");
        availableBooks.add("Algorithms");
    }

    private static void clearScreen() {
        // Method to clear the console screen depending on the OS
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // For Windows
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor(); // For Unix/Linux
            }
        } catch (Exception e) {
            System.err.println("Error clearing the screen: " + e.getMessage()); // Error handling
        }
    }

    private static void signIn() {
        // Method for user sign-in
        System.out.print("Enter username to sign in: ");
        loggedInUser = scanner.nextLine(); // Get username from user input
        System.out.println("Signed in as " + loggedInUser);
        pressEnterToContinue(); // Pause for user to read message
    }

    private static void signOut() {
        // Method for user sign-out
        loggedInUser = null; // Reset logged-in user
        System.out.println("Signed out successfully!");
        pressEnterToContinue(); // Pause for user to read message
    }

    private static void showMainMenu() {
        // Method to show the main menu options
        while (true) { // Loop for menu options
            System.out.println("1. Issue Book");
            System.out.println("2. Return Book");
            System.out.println("3. View Available Books");
            System.out.println("4. View Issued Books");
            System.out.println("5. Sign Out");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) { // Check for valid integer input
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                continue; // Restart loop for valid input
            }

            int choice = scanner.nextInt(); // Get user's menu choice
            scanner.nextLine(); // Consume newline character

            switch (choice) { // Handle user's choice
                case 1:
                    issueBook(); // Call method to issue a book
                    break;
                case 2:
                    returnBook(); // Call method to return a book
                    break;
                case 3:
                    viewAvailableBooks(); // Call method to view available books
                    break;
                case 4:
                    viewIssuedBooks(); // Call method to view issued books
                    break;
                case 5:
                    signOut(); // Call method to sign out
                    return; // Exit the loop on sign out
                default:
                    System.out.println("Invalid choice! Please try again."); // Handle invalid choice
                    pressEnterToContinue(); // Pause for user to read message
            }
        }
    }

    private static void issueBook() {
        // Method to issue a book to the logged-in user
        System.out.print("Enter the name of the book to issue: ");
        String bookName = scanner.nextLine(); // Get book name from user input
        if (availableBooks.contains(bookName)) { // Check if the book is available
            availableBooks.remove(bookName); // Remove book from available list
            issuedBooks.put(bookName, loggedInUser); // Record book issuance in the map
            System.out.println("Book issued: " + bookName + " to " + loggedInUser);
        } else {
            System.out.println("Book is not available."); // Notify user if book is not available
        }
        pressEnterToContinue(); // Pause for user to read message
    }

    private static void returnBook() {
        // Method to return a book that was issued
        System.out.print("Enter the name of the book to return: ");
        String bookName = scanner.nextLine(); // Get book name from user input
        if (issuedBooks.containsKey(bookName) && issuedBooks.get(bookName).equals(loggedInUser)) {
            // Check if the book was issued to the logged-in user
            availableBooks.add(bookName); // Add book back to available list
            issuedBooks.remove(bookName); // Remove book from issued map
            System.out.println("Book returned: " + bookName);
        } else {
            System.out.println("You haven't issued this book."); // Notify user if they try to return a book not issued
        }
        pressEnterToContinue(); // Pause for user to read message
    }

    private static void viewAvailableBooks() {
        // Method to display available books
        System.out.println("Available Books:");
        if (availableBooks.isEmpty()) { // Check if there are available books
            System.out.println("No books available."); // Notify user if no books are available
        } else {
            for (String book : availableBooks) { // Loop through available books
                System.out.println("- " + book); // Display each book
            }
        }
        pressEnterToContinue(); // Pause for user to read message
    }

    private static void viewIssuedBooks() {
        // Method to display books issued to the logged-in user
        System.out.println("Books Issued to " + loggedInUser + ":");
        boolean hasIssuedBooks = false; // Flag to check if user has issued books

        for (String book : issuedBooks.keySet()) { // Loop through issued books
            if (issuedBooks.get(book).equals(loggedInUser)) { // Check if the book is issued to the user
                System.out.println("- " + book); // Display issued book
                hasIssuedBooks = true; // Set flag to true
            }
        }

        if (!hasIssuedBooks) { // If user has no issued books
            System.out.println("No books issued."); // Notify user
        }
        pressEnterToContinue(); // Pause for user to read message
    }

    private static void pressEnterToContinue() {
        // Method to pause and wait for user to press Enter
        System.out.print("Press Enter to continue...");
        scanner.nextLine(); // Wait for user input
    }
}