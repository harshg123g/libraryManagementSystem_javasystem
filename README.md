Library Management System Documentation

Team members: 
1.) Bhavin Prajapat
2.) Harsh Gupta [PCE23CR025] : https://github.com/harshg123g/libraryManagementSystem_javasystem 

Project Description
The Library Management System is a Java-based application designed to manage the operations of a library. It allows users to sign in, issue books, return books, and view the list of available and issued books. The system aims to streamline library management processes, making it easier for users to access and manage books.

Features
User Authentication:

Users can sign in with a username to access library functionalities.
Users can sign out, which resets their session.
Book Management:

A predefined list of available books is initialized at the start of the program.
Users can issue available books, which are then removed from the available list.
Users can return previously issued books, which are added back to the available list.
Viewing Books:

Users can view a list of currently available books in the library.
Users can view the list of books they have issued.
Input Handling:

The program ensures that user inputs are validated. Invalid inputs prompt the user to try again.
The system provides clear instructions and feedback to the user throughout their interaction.
User Interface:

A console-based user interface that is simple and easy to navigate.
The console screen can be cleared to enhance user experience.
Dynamic Data Structures:

Uses ArrayList to manage the list of available books dynamically.
Uses HashMap to track issued books along with the associated user information, enabling efficient data retrieval.
Error Handling:

The application includes error handling for various scenarios, such as attempting to issue a book that is not available or returning a book that was not issued to the user.
How to Run the Application
Setup:

Ensure you have Java Development Kit (JDK) installed on your machine.
Download the source code file and save it as LibraryManagementSystem.java.
Compile the Code: Open your terminal or command prompt and navigate to the directory where the file is saved. Compile the code using:

bash
Copy code
javac LibraryManagementSystem.java
Run the Application: Execute the compiled class with the command:

bash
Copy code
java LibraryManagementSystem
Interact with the System: Follow the prompts in the console to sign in, issue or return books, and view available or issued books.

Future Enhancements
Database Integration: Connect the application to a database for persistent storage of book and user data.
User Management: Implement user roles (e.g., admin, librarian) with additional features such as adding or removing books.
Search Functionality: Add a search feature to allow users to find books by title or author.
User Registration: Allow new users to register within the application.
Graphical User Interface (GUI): Develop a GUI to enhance user interaction and accessibility.
This documentation provides an overview of the Library Management System, detailing its features, setup instructions, and potential future improvements. The application is intended to simplify the management of library resources and improve user experience.
