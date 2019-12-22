import java.util.Scanner;
import java.io.File;

public class Circus_Client {
    static Scanner console = new Scanner(System.in);

    // static EmployeeLinkedList employeeListByName= null;
    // static EmployeeLinkedList employeeListById = null;
    public static void main(String[] args) {
        // Step 1: Build the data structure

        // Step 2: Do things in the menu
        int choice = menu(console);

    }

    public static int menu(Scanner console) {
        System.out.println("(1)   Print list alphabetically");
        System.out.println("(2)   Print list by IdNum");
        System.out.println("(3)   Insert new Employee");
        System.out.println("(4)	  Delete an Employee");
        System.out.println("(5)	  Print only a particular category list of employees alphabetically");
        System.out.println("(6)	  Print entire list of all employees by category alphabetically");
        System.out.println("(7)	  Add a category");
        System.out.println("(8)	  Delete a category (and ALL corresponding employees)");
        System.out.println("(9)	  Quit");
        System.out.print("What is your selection: ");
        return console.nextInt();
    }
}