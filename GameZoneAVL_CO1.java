import java.util.Scanner;

public class GameZoneAVL_CO1 {

    static class Node {

        int key, height;
        Node left, right;

        Node(int key) {

            this.key = key;
            height = 1;
        }
    }

    static Node root;

    // Height Function
    static int height(Node n) {

        if (n == null)
            return 0;

        return n.height;
    }

    // Balance Factor
    static int getBalance(Node n) {

        if (n == null)
            return 0;

        return height(n.left) - height(n.right);
    }

    // Left Rotation
    static Node leftRotate(Node x) {

        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left),
                height(x.right)) + 1;

        y.height = Math.max(height(y.left),
                height(y.right)) + 1;

        return y;
    }

    // Right Rotation
    static Node rightRotate(Node y) {

        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left),
                height(y.right)) + 1;

        x.height = Math.max(height(x.left),
                height(x.right)) + 1;

        return x;
    }

    // Insert Function
    static Node insert(Node node, int key) {

        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);

        else if (key > node.key)
            node.right = insert(node.right, key);

        else
            return node;

        node.height = 1 + Math.max(
                height(node.left),
                height(node.right));

        int balance = getBalance(node);

        // LL Rotation
        if (balance > 1 && key < node.left.key) {

            System.out.println(
            "After inserting " + key +
            " -> LL Rotation at pivot " + node.key);

            return rightRotate(node);
        }

        // RR Rotation
        if (balance < -1 && key > node.right.key) {

            System.out.println(
            "After inserting " + key +
            " -> RR Rotation at pivot " + node.key);

            return leftRotate(node);
        }

        // LR Rotation
        if (balance > 1 && key > node.left.key) {

            System.out.println(
            "After inserting " + key +
            " -> LR Rotation at pivot " + node.key);

            node.left = leftRotate(node.left);

            return rightRotate(node);
        }

        // RL Rotation
        if (balance < -1 && key < node.right.key) {

            System.out.println(
            "After inserting " + key +
            " -> RL Rotation at pivot " + node.key);

            node.right = rightRotate(node.right);

            return leftRotate(node);
        }

        return node;
    }

    // Preorder Traversal
    static void preorder(Node root) {

        if (root != null) {

            System.out.print(root.key + " ");

            preorder(root.left);

            preorder(root.right);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(
        "AVL INSERTION (Player Ranking Order)");

        System.out.println();

        System.out.print(
        "Enter number of Player IDs: ");

        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println(
        "Enter Player IDs:");

        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();
        }

        System.out.println();

        System.out.print("Insertion order: ");

        for (int i = 0; i < n; i++) {

            System.out.print(arr[i]);

            if (i != n - 1)
                System.out.print(", ");

            root = insert(root, arr[i]);
        }

        System.out.println();

        System.out.println();
        System.out.println(
        "PREORDER TRAVERSAL");

        preorder(root);

        System.out.println();

        System.out.println();
        System.out.println(
        "Time Complexity:");

        System.out.println(
        "AVL Insert/Delete : O(log n)");

        System.out.println(
        "Player Search Query : O(log n)");

        System.out.println(
        "Tree Traversal : O(n)");

        sc.close();
    }
}