
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static ArrayList <String> todoList = new ArrayList<String>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    viewItems();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("----- To-Do List Menu -----");
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. View Items");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addItem() {
        System.out.print("Enter the item to add: ");
        String item = scanner.nextLine();
        todoList.add(item);
        System.out.println("Item added to the to-do list: " + item);
    }

    private static void removeItem() {
        if (todoList.isEmpty()) {
            System.out.println("The to-do list is empty. Nothing to remove.");
            return;
        }

        System.out.println("Current items in the to-do list:");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }

        System.out.print("Enter the number of the item to remove: ");
        int indexToRemove = scanner.nextInt();

        if (indexToRemove >= 1 && indexToRemove <= todoList.size()) {
            String removedItem = todoList.remove(indexToRemove - 1);
            System.out.println("Item removed from the to-do list: " + removedItem);
        } else {
            System.out.println("Invalid index. No item removed.");
        }
    }

    private static void viewItems() {
        if (todoList.isEmpty()) {
            System.out.println("The to-do list is empty.");
        } else {
            System.out.println("Current items in the to-do list:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }
}
