package treemap;


public class AVLTree {

    static class Node {
        int value;
        int height;

        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node node, int value) {
        // 1. Insert như BST bình thường
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insertNode(node.left, value);
        } else if (value > node.value) {
            node.right = insertNode(node.right, value);
        } else {
            // Không thêm duplicate
            return node;
        }

        // 2. Cập nhật chiều cao
        node.height = 1 + Math.max(
                getHeight(node.left),
                getHeight(node.right)
        );

        // 3. Kiểm tra độ lệch
        int balance = getBalance(node);

        // =========================
        // Case 1: Left Left
        // =========================
        if (balance > 1 && value < node.left.value) {
            return rotateRight(node);
        }

        // =========================
        // Case 2: Right Right
        // =========================
        if (balance < -1 && value > node.right.value) {
            return rotateLeft(node);
        }

        // =========================
        // Case 3: Left Right
        // =========================
        if (balance > 1 && value > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // =========================
        // Case 4: Right Left
        // =========================
        if (balance < -1 && value < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.left) - getHeight(node.right);
    }

    // =========================
    // Rotate Right
    // =========================
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node temp = x.right;

        x.right = y;
        y.left = temp;

        // update height
        y.height = 1 + Math.max(
                getHeight(y.left),
                getHeight(y.right)
        );

        x.height = 1 + Math.max(
                getHeight(x.left),
                getHeight(x.right)
        );

        return x;
    }

    // =========================
    // Rotate Left
    // =========================
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node temp = y.left;

        y.left = x;
        x.right = temp;

        // update height
        x.height = 1 + Math.max(
                getHeight(x.left),
                getHeight(x.right)
        );

        y.height = 1 + Math.max(
                getHeight(y.left),
                getHeight(y.right)
        );

        return y;
    }

    public boolean search(int value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node node, int value) {
        if (node == null) return false;

        if (value == node.value) return true;

        return value < node.value
                ? searchNode(node.left, value)
                : searchNode(node.right, value);
    }

    public void printInOrder() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node node) {
        if (node == null) return;

        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }

    // In cây để nhìn structure
    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String prefix, boolean isTail) {
        if (node == null) return;

        System.out.println(
                prefix +
                        (isTail ? "└── " : "├── ") +
                        node.value +
                        " (h=" + node.height + ")"
        );

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

        AVLTree tree = new AVLTree();

        for (int i = 1; i <= 10; i++) {
            tree.insert(i);

            System.out.println("\nSau khi thêm " + i + ":");
            tree.printTree();
        }

        System.out.println("\nIn-order:");
        tree.printInOrder();
    }
}