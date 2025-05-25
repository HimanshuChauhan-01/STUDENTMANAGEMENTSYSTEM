# 🎓 Student Management System (Java Swing + MySQL)

A desktop-based **Student Management System** that allows users to manage student records via a graphical interface. Built with **Java Swing** and backed by a **MySQL database**, it supports basic CRUD operations like adding, searching, and deleting students.

---

## 📦 Features

- Add student details: Name, Roll Number, and Course
- Search students using a keyword
- Delete selected student from the database
- Reset view to display all students
- Displays a university logo (customizable)

---

## 🧰 Technologies Used

| Technology          | Role                                     |
|---------------------|------------------------------------------|
| Java (JDK 8+)        | Core language                           |
| Java Swing           | GUI framework                          |
| MySQL                | Backend database                        |
| JDBC                 | Java Database Connectivity (with MySQL) |
| MySQL Connector/JAR  | JDBC driver to connect Java and MySQL   |
| IDE (VS Code/Eclipse)| Development and execution               |

---

## 🗂 Project Structure

StudentManagementSystem/
│
├── src/
│ ├── model/
│ │ └── Student.java # Student data class
│ ├── dao/
│ │ ├── DatabaseConnection.java # Handles MySQL connection
│ │ └── StudentDAO.java # CRUD operations
│ ├── ui/
│ │ └── StudentManagementSystem.java # Main GUI class
│
├── resources/
│ └── galgotias-university-logo.png # Optional logo for branding
│
├── sql/
│ └── student_management.sql # DB creation script
│
└── README.md
