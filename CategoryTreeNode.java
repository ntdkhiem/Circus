class CategoryTreeNode {
    private CategoryTreeNode left, right;
    private String title;
    private Employee data;
    // private EmployeeTree employees;

    public CategoryTreeNode(String t, Employee d) {
        left = null;
        right = null;
        title = t;
        data = d;
    }

    public CategoryTreeNode getLeft() {
        return left;
    }

    public void setLeft(CategoryTreeNode l) {
        left = l;
    }

    public CategoryTreeNode getRight() {
        return right;
    }

    public void setRight(CategoryTreeNode r) {
        right = r;
    }

    public Employee getData() {
        return data;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return "Title: " + title + "  Data: " + data.toString();
    }
}