import java.util.Scanner;
import java.io.File;

import java.io.FileNotFoundException;

public class Circus_Client {
    static Scanner console = new Scanner(System.in);
    static CategoryTree cttree;

    // static boolean newEmployeeAdded = false; // to reset EmployeeLinkedList when
    // a new employee added.

    public static void main(String[] args) throws FileNotFoundException {
        // Global linkedlists
        EmployeeDoubleLinkedList employeesSortedByName = null;
        EmployeeDoubleLinkedList employeesSortedById = null;

        // Step 1: Build the data structure
        Scanner data = new Scanner(new File("s_database.txt"));
        cttree = new CategoryTree();
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
                break;
            case 2:
                if (employeesSortedById == null) {
                    employeesSortedById = cttree.sortById();
                }
                System.out.println(employeesSortedById.toString());
                break;
            case 3:
                Employee e = newEmployee(console);
                while (cttree.idIsExist(e.ss)) {
                    System.out.println("social security number should not be the same. Please try again...");
                    e = newEmployee(console);
                }
                cttree.add(e);
                // Reset all cached dataset
                employeesSortedById = employeesSortedByName = null;
                break;
            case 4:
                System.out.print("What is employee's social security number: ");
                String ssNum = console.next();
                // check in idSet
                while (!cttree.idIsExist(ssNum)) {
                    System.out.println("No such id.");
                    System.out.print("What is employee's social security number: ");
                    ssNum = console.next();
                }
                // Find the employee
                // delete it
                cttree.deleteEmployee(ssNum);
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            }
            System.out.println();
            choice = menu(console);
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

    public static Employee newEmployee(Scanner console) {
        Employee e = new Employee();
        System.out.print("What is employee's first name: ");
        e.firstName = console.next();
        System.out.print("What is employee's last name: ");
        e.lastName = console.next();
        System.out.print("What is employee's middle initial: ");
        e.middleInitial = console.next();
        System.out.print("What is employee's social security number: ");
        e.ss = console.next();
        System.out.print("What is employee's title: ");
        e.title = console.next();
        for (int i = 0; i < cttree.categoryList.size(); i++) {
            System.out.println(i + ". " + cttree.categoryList.get(i));
        }
        System.out.print("choose your category: ");
        e.category = cttree.categoryList.get(console.nextInt());
        return e;
    }
}