# 📝 To-Do List Application

A simple console-based To-Do List application built using **Java** and **Maven**, with persistent storage in a **MySQL database**. This application allows users to manage their tasks (add, view, edit, delete) with data stored securely in a relational database.

---

## 📚 Features
- **Add Task**: Add a new task with a description.
- **View Tasks**: Display all tasks stored in the database.
- **Edit Task**: Update the description of an existing task by its ID.
- **Delete Task**: Remove a task from the database by its ID.
- **Persistent Storage**: Ensures tasks are saved across sessions using MySQL.

---

## 🔧 Tech Stack
- **Language**: Java
- **Build Tool**: Maven
- **Database**: MySQL
- **JDBC**: Java Database Connectivity for database operations

---

## 🚀 Getting Started

### Prerequisites
Ensure you have the following installed:
- [Java JDK 8+](https://www.oracle.com/in/java/technologies/downloads/)
- [MySQL Server](https://www.mysql.com/downloads/)
- IDE (IntelliJ IDEA, Eclipse)

---


### Set Up the Database
- Start your MySQL server.
- Create the database and table by running the following SQL script:
    - CREATE DATABASE ToDoListDB;
    - USE ToDoListDB;

    - CREATE TABLE tasks (
          id INT AUTO_INCREMENT PRIMARY KEY,
          description VARCHAR(255) NOT NULL
      );
