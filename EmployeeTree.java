public class EmployeeTree {
    // private IdComparator IdCP;
    private NameComparator NameCP;
    private EmployeeTreeNode root;

    public EmployeeTree() {
        // this(new NameComparator(), new IdComparator());
        this(new NameComparator());
    }

    // public EmployeeTree(NameComparator cp1, IdComparator cp2) {
    // root = null;
    // NameCP = cp1;
    // IdCP = cp2;
    // }
    public EmployeeTree(NameComparator cp1) {
        root = null;
        NameCP = cp1;
    }

    // TODO: Implement add method
    public void add(Employee empl) {
        EmployeeTreeNode node = new EmployeeTreeNode(empl);
        root = add(root, node);
    }

    // add Employee to its final location based on name
    public EmployeeTreeNode add(EmployeeTreeNode localRoot, EmployeeTreeNode node) {
        if (localRoot == null) {
            return node;
        }
        // Add to the left
        if (NameCP.compare(localRoot.getEmployee(), node.getEmployee()) < 0) {
            localRoot.setLeft(add(localRoot.getLeft(), node));
            return localRoot;
        }
        // add to the right
        if (NameCP.compare(localRoot.getEmployee(), node.getEmployee()) > 0) {
            localRoot.setRight(add(localRoot.getRight(), node));
            return localRoot;
        } else {
            return localRoot;
        }
    }
}