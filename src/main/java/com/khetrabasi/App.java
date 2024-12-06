package com.khetrabasi;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        ToDoListManager manager = new ToDoListManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Edit Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    manager.addTask(description);
                }
                case 2 -> manager.viewTasks();
                case 3 -> {
                    System.out.print("Enter task ID to edit: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter new task description: ");
                    String newDescription = scanner.nextLine();
                    manager.editTask(id, newDescription);
                }
                case 4 -> {
                    System.out.print("Enter task ID to delete: ");
                    int id = scanner.nextInt();
                    manager.deleteTask(id);
                }
                case 5 -> {
                    System.out.println("Exiting application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
