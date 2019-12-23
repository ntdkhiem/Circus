import java.util.Scanner;

public class Employee {
    public String firstName, lastName, middleInitial, ss, title, category;

    public Employee(String f, String l, String m, String s, String t, String c) {
        firstName = f;
        lastName = l;
        middleInitial = m;
        ss = s;
        title = t;
        category = c;
    }

    // Precondition: "last first mid social-number category title"
    public Employee(String line) {
        Scanner c = new Scanner(line);
        lastName = c.next();
        firstName = c.next();
        middleInitial = c.next();
        ss = c.next();
        title = c.next();
        category = c.next();
        c.close();
    }

}