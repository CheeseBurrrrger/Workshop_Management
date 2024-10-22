# Workshop Management System

This project is a Workshop Management System developed as part of the Advanced Programming Class (first year). The system helps manage workshop services, spare parts, and user information, providing a simple interface for administrators and workshop employees to handle day-to-day operations.

## Features
- **Login & User Authentication**: A login page for authenticating users and controlling access.
- **Service Management**: Create, view, update, and delete services offered by the workshop.
- **Spare Parts Management**: Manage spare part inventory, including adding and removing parts.
- **User Management**: Handle user data such as customer information and employees.

## Technologies Used
- **JavaFX**: For building the graphical user interface.
- **JDBC (Java Database Connectivity)**: For connecting and interacting with a MySQL database.
- **MySQL**: Database management system used for storing workshop data.
- **Object-Oriented Programming (OOP)**: Implemented with Java, encapsulating data and functionality.

## Installation and Setup
1. **Clone the repository**:
   ```bash
   git clone <repository_url>
   ```
2. **Set up MySQL database**:
   - Install MySQL and create a database for the application.
   - Use the appropriate JDBC connection in the `MainController` to connect to your database.
   
3. **Run the Application**:
   - Open the project in an IDE (e.g., IntelliJ or Eclipse).
   - Run the `Main.java` file located in the `src/application/` directory.
   - Ensure you have MySQL running and properly configured.

## License
This project is for educational purposes and is not licensed for commercial use.
