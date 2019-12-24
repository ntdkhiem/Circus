import java.util.HashSet;

public class CategoryTree {
    private HashSet<String> idSet;
    private CategoryTreeNode root;

    public CategoryTree() {
        idSet = new HashSet<String>();
        root = null;
    }

    public void add(String line) {
        // check if line is not null
        if (line.compareTo("") != 0) {
            // create an Employee object
            Employee person = new Employee(line);
            // create a TreeNode object
            root = add(root, person);
            // TODO: add employee's id to idSet
        }
    }

    // add treenode (by compare it's title) to its final location
    public CategoryTreeNode add(CategoryTreeNode localRoot, Employee person) {
        // create new EmployeeTree if not exist
        if (localRoot == null) {
            CategoryTreeNode node = new CategoryTreeNode(person.category);
            // add current employee as root
            node.getEmployees().add(person);
            return node;
        }

        // add to the left
        if (localRoot.getTitle().compareTo(person.category) < 0) {
            localRoot.setLeft(add(localRoot.getLeft(), person));
            return localRoot;
        }
        // add to the right
        if (localRoot.getTitle().compareTo(person.category) > 0) {
            localRoot.setRight(add(localRoot.getRight(), person));
            return localRoot;
        } else {
            // Add employee to EmployeeTree if node already existed
            localRoot.getEmployees().add(person);
            return localRoot;
        }
    }

    public void printSideways() {
        printSideways(root, 0);
    }

    public void printSideways(CategoryTreeNode root, int level) {
        if (root != null) {
            printSideways(root.getRight(), level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("            ");
            }
            System.out.println(root.getTitle());
            printSideways(root.getLeft(), level + 1);
        }
    }
}