import java.util.Scanner;
import java.io.File;

import java.io.FileNotFoundException;

public class Circus_Client {
    static Scanner console = new Scanner(System.in);

    // static boolean newEmployeeAdded = false; // to reset EmployeeLinkedList when
    // a new employee added.

    public static void main(String[] args) throws FileNotFoundException {
        // Global linkedlists
        EmployeeDoubleLinkedList employeesSortedByName = null;
        EmployeeDoubleLinkedList employeesSortedById = null;

        // Step 1: Build the data structure
        Scanner data = new Scanner(new File("s_database.txt"));
        CategoryTree cttree = new CategoryTree();
        while (data.hasNextLine()) {
            String line = data.nextLine();
            if (!line.equals("")) {
                Employee person = new Employee(line);
                if (!cttree.idIsExist(person.ss)) {
                    cttree.add(person);
                }
            }
        }
        data.close();
        // cttree.printSideways();
        // Step 2: Do things in the menu
        int choice = menu(console);

        // TODO: Finish implement this
        while (choice != 9) {
            switch (choice) {
            case 1:
                if (employeesSortedByName == null) {
                    employeesSortedByName = cttree.sortByName();
                }
                System.out.println(employeesSortedByName.toString());
                return;
            case 2:
                if (employeesSortedById == null) {
                    employeesSortedById = cttree.sortById();
                }
                System.out.println(employeesSortedById.toString());
                return;
            case 3:
                return;
            case 4:
                return;
            case 5:
                return;
            case 6:
                return;
            case 7:
                return;
            case 8:
                return;
            }
        }
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