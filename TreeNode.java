class TreeNode {
    private TreeNode left, right;
    private String title;
    private Employee data;

    public TreeNode(Employee d) {
        left = null;
        right = null;
        data = d;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode l) {
        left = l;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode r) {
        right = r;
    }

    public Employee getData() {
        return data;
    }

    public String getTitle() {
        return title;
    }
}