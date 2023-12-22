import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class todolist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("To-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addTask(scanner, tasks);
                    break;
                case 2:
                    viewTasks(tasks);
                    break;
                case 3:
                    deleteTask(scanner, tasks);
                    break;
                case 4:
                    System.out.println("Exiting the to-do list application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }

            System.out.println(); // Add a newline for better readability
        }
    }

    private static void addTask(Scanner scanner, ArrayList<Task> tasks) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        Task task = new Task(description);
        tasks.add(task);

        System.out.println("Task added successfully.");
    }

    private static void viewTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found. Your to-do list is empty.");
        } else {
            System.out.println("Your To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
            }
        }
    }

    private static void deleteTask(Scanner scanner, ArrayList<Task> tasks) {
        viewTasks(tasks);

        if (!tasks.isEmpty()) {
            System.out.print("Enter the task number to delete: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                tasks.remove(taskNumber - 1);
                System.out.println("Task deleted successfully.");
            } else {
                System.out.println("Invalid task number. Please enter a valid task number.");
            }
        }
    }
}
