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
            CategoryTreeNode node = new CategoryTreeNode(person.category, person);
            root = add(root, node);
            // TODO: add employee's id to idSet
        }
    }

    // add treenode (by compare it's title) to its final location
    public CategoryTreeNode add(CategoryTreeNode root, CategoryTreeNode node) {
        if (root == null) {
            return node;
        }

        // add to the left
        if (root.getTitle().compareTo(node.getTitle()) < 0) {
            root.setLeft(add(root.getLeft(), node));
            return root;
        }
        // add to the right
        if (root.getTitle().compareTo(node.getTitle()) > 0) {
            root.setRight(add(root.getRight(), node));
            return root;
        } else {
            // TODO: Add employee to EmployeeTree if node already existed
            return root;
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
            System.out.println(root.getData());
            printSideways(root.getLeft(), level + 1);
        }
    }
}

// static HashSet idSet = new HashSet<String>();

// public void printSideways() {
// printSideways(overallRoot, 0);
// }

// // post: prints in reversed preorder the tree with given
// // root, indenting each line to the given level
// private void printSideways(IntTreeNode root, int level) {
// if (root != null) {
// printSideways(root.right, level + 1);
// for (int i = 0; i < level; i++) {
// System.out.print(" ");
// }
// System.out.println(root.data);
// printSideways(root.left, level + 1);
// }
// }