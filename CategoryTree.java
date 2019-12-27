import java.util.HashSet;
import java.util.ArrayList;

public class CategoryTree {
    public HashSet<String> idSet;
    public ArrayList<String> categoryList;
    private CategoryTreeNode root;

    public CategoryTree() {
        idSet = new HashSet<String>();
        categoryList = new ArrayList<String>();
        root = null;
    }

    public void add(Employee person) {
        root = add(root, person);
        idSet.add(person.ss);
        categoryList.add(person.category);
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
        if (localRoot.getTitle().compareTo(person.category) > 0) {
            localRoot.setLeft(add(localRoot.getLeft(), person));
            return localRoot;
        }
        // add to the right
        if (localRoot.getTitle().compareTo(person.category) < 0) {
            localRoot.setRight(add(localRoot.getRight(), person));
            return localRoot;
        } else {
            // Add employee to EmployeeTree if node already existed
            localRoot.getEmployees().add(person);
            return localRoot;
        }
    }

    public EmployeeDoubleLinkedList sortByName() {
        return sortBy("name", root, new EmployeeDoubleLinkedList());
    }

    public EmployeeDoubleLinkedList sortById() {
        return sortBy("id", root, new EmployeeDoubleLinkedList());
    }

    // TODO: consider put this in EmployeeDoubleLinkedList for cleanness :)
    public EmployeeDoubleLinkedList sortBy(String cmd, CategoryTreeNode localRoot, EmployeeDoubleLinkedList list) {
        // Loop through category
        if (localRoot == null) {
            return list;
        }

        list.addBy(cmd, localRoot.getEmployees().getRoot());

        return sortBy(cmd, localRoot.getRight(), sortBy(cmd, localRoot.getLeft(), list));

    }

    // Check for existence id
    public boolean idIsExist(String id) {
        return idSet.contains(id);
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