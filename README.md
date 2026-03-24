💰Expense Tracker (Java + JDBC + MySQL):

A modular, console-based expense management system built using Core Java, JDBC, and MySQL.
The application enables users to securely manage their expenses with authentication, structured data storage, and reporting features.


🚀 Overview:

This project demonstrates a layered backend architecture where business logic, database access, and user interaction are clearly separated.

It simulates a real-world financial tracking system with user-specific data handling and database-driven operations.


✨ Key Features:

🔐 Authentication Module

- User Registration with validation
- Secure Login system
- User-specific session handling

💸 Expense Management

- Add new expense entries
- View all expenses (user-specific)
- Delete expenses securely

📊 Reporting

- Monthly expense summary
- Aggregated data using SQL functions

⚙️ System Design

- Modular class structure
- Separation of concerns (DAO-like pattern)
- Reusable database connection utility


🏗️ Architecture:

User (Console Input)
        ↓
ExpenseTrackerApp (Controller Layer)
        ↓
UserManager / ExpenseManager (Service Layer)
        ↓
DatabaseConnection (Data Access Layer)
        ↓
MySQL Database


🛠️ Tech Stack:

Technology| Purpose
Java| Core application logic
JDBC| Database interaction
MySQL| Persistent data storage
Apache NetBeans| Development environment


📂 Project Structure:

ExpenseTracker/
│
├── src/
│   └── expensetracker/
│        ├── DatabaseConnection.java   # Handles DB connectivity
│        ├── UserManager.java          # User operations (register/login)
│        ├── ExpenseManager.java       # Expense CRUD operations
│        └── ExpenseTrackerApp.java    # Main controller (entry point)
│
├── database.sql                       # Database schema
├── screenshots/                      # (Optional) UI output images
└── README.md


⚙️ Database Schema:

CREATE DATABASE expense_tracker;

USE expense_tracker;

CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE expenses(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    category VARCHAR(100),
    amount DOUBLE,
    description VARCHAR(255),
    date DATE,
    FOREIGN KEY (user_id) REFERENCES users(id)
);


▶️ Execution Guide:

1. Clone the repository
2. Open in Apache NetBeans
3. Execute "database.sql" in MySQL
4. Configure DB credentials in "DatabaseConnection.java"
5. Run "ExpenseTrackerApp.java"


🔒 Configuration (Security Note):

private static final String PASSWORD = "your_password";

⚠️ Avoid committing real credentials. Replace with placeholders before pushing to GitHub.


📊 Sample Workflow:

1. Register User
2. Login
3. Add Expense
4. View/Delete Expenses
5. Generate Monthly Report


📸 Screenshots:

Add console screenshots here to improve project visibility.


🎯 Learning Outcomes:

This project demonstrates:

- Object-Oriented Programming (OOP)
- JDBC-based database integration
- CRUD operations with PreparedStatement
- Basic backend system design
- Exception handling & input validation
- Modular application architecture


📌 Future Enhancements:

- GUI using Java Swing / JavaFX
- REST API using Spring Boot
- Role-based authentication
- Data visualization dashboards
- Dockerized deployment
- Cloud database integration (AWS / Firebase)


🧠 Key Highlights:

- Clean separation of logic layers
- Secure SQL queries using PreparedStatement
- Scalable structure for future upgrades
- Beginner-friendly yet industry-relevant


👨‍💻 Author:

Puli Sai Srinivasa Teja


⭐ Support

If you found this project useful:

- ⭐ Star this repository
- 🍴 Fork it
- 📢 Share with others.
