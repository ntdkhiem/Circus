import java.util.HashSet;

public class CategoryTree {
    private HashSet<String> idSet;
    private TreeNode root;

    public CategoryTree() {
        idSet = new HashSet<String>();
        root = null;
    }

    // TODO: Implement add method
    public void add(String line) {
        // check if line is not null
        if (line.compareTo("") != 0) {
            // create an Employee object
            Employee person = new Employee(line);
            // create a TreeNode object
            TreeNode node = new TreeNode(person.category, person);
            root = add(root, node);
        }
    }

    public TreeNode add(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }

        // add to the left
        // add to the right
    }
}

// static HashSet idSet = new HashSet<String>();
