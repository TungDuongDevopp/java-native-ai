package treemap;


public class BinarySearchTree {
    static class Node {
        int value;
        Node left, right;
        Node(int value) { this.value = value; }
    }

    private Node root;
    void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node node, int value) {
        if (node == null) return new Node(value);
        if (value < node.value) node.left = insertNode(node.left, value);
        else if (value > node.value) node.right = insertNode(node.right, value);
        return node;
    }

    boolean search(int value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node node, int value) {
        if (node == null) return false;          // 📝 đi hết cây mà không thấy
        if (value == node.value) return true;
        return value < node.value
                ? searchNode(node.left, value)         // 📝 nhỏ hơn → tìm bên trái
                : searchNode(node.right, value);       // 📝 lớn hơn → tìm bên phải
    }

    private int findMinNode(Node node) {
        if (node == null) return -1;

        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }
    public int findMin() {
        return findMinNode(this.root);
    }
    public void printInOrder() {
        System.out.print("Cây BST theo thứ tự tăng dần: ");
        inOrderTraversal(this.root);
        System.out.println(); // Xuống dòng sau khi in xong
    }

    // 2. Hàm xử lý đệ quy nội bộ (Left -> Root -> Right)
    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);        // ⬅️ Bước 1: Đi hết sang bên trái
        System.out.print(node.value + " "); // 🏠 Bước 2: In giá trị node hiện tại
        inOrderTraversal(node.right);       // ➡️ Bước 3: Đi sang bên phải
    }
    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String prefix, boolean isTail) {
        if (node == null) return;

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.value);

        if (node.left != null || node.right != null) {
            if (node.left != null) {
                printTree(
                        node.left,
                        prefix + (isTail ? "    " : "│   "),
                        node.right == null
                );
            }

            if (node.right != null) {
                printTree(
                        node.right,
                        prefix + (isTail ? "    " : "│   "),
                        true
                );
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        bst.insert(40);// false
        bst.insert(50);
        bst.insert(60);
        bst.insert(70);
        bst.insert(80);
        bst.insert(90);
        bst.insert(100);
        bst.printTree();

    }
}
