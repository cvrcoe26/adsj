import java.util.*;

class AVLTree<T extends Comparable<T>> {

    class Node {
        T key;
        int height;
        Node left, right;

        Node(T d) {
            key = d;
            height = 1;
        }
    }

    AVLTree() {
        root = null;
    }

    Node root;

    boolean isEmpty() {
        return root == null;
    }

    int height(Node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rightRotate(Node P) // LL Rotation
    {
        Node A = P.left;
        P.left = A.right;
        A.right = P;

        P.height = max(height(P.left), height(P.right)) + 1;
        A.height = max(height(A.left), height(A.right)) + 1;

        return A;
    }

    Node leftRotate(Node P) // RR Rotation
    {
        Node B = P.right;
        P.right = B.left;
        B.left = P;

        P.height = max(height(P.left), height(P.right)) + 1;
        B.height = max(height(B.left), height(B.right)) + 1;

        return B;
    }

    void insert(T key) {
        root = insert(root, key);
    }

    private Node insert(Node node, T key) {
        if (node == null)
            return new Node(key);

        if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key);
        else
            node.right = insert(node.right, key);

        node.height = 1 + max(height(node.left), height(node.right));

        int bal = getBalance(node);

        if (bal > 1 && key.compareTo(node.left.key) < 0)
            return rightRotate(node); // LL Rotation
        if (bal < -1 && key.compareTo(node.right.key) > 0)
            return leftRotate(node); // RR Rotation
        if (bal > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left); // LR Rotation
            return rightRotate(node);
        }
        if (bal < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right); // RL Rotation
            return leftRotate(node);
        }
        return node;
    }

    private int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    void display() {
        if (root == null)
            System.out.println("There are no elements in the AVL tree.");
        else {
            System.out.print("The elements in the tree are ");
            inorder(root);
        }
    }

    void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.key + " ");
            inorder(t.right);
        }
    }

    boolean search(T key) {
        Node t = root;
        while (t != null) {
            if (key.equals(t.key))
                return true;
            if (key.compareTo(t.key) < 0)
                t = t.left;
            else
                t = t.right;
        }
        return false;
    }

    Node minValueNode(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }

    Node delete(Node root, T key) {
        if (root == null) {
            System.out.println("Data to be deleted, not found");
            return root;
        }

        if (key.compareTo(root.key) < 0)
            root.left = delete(root.left, key);

        else if (key.compareTo(root.key) > 0)
            root.right = delete(root.right, key);

        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
            }
        }

        if (root == null)
            return root;

        root.height = max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    Node delete(T key) {

        if (root.left == null && root.right == null) {
            root = null;
            return root;
        }
        Node temp = delete(root, key);
        return temp;
    }

    boolean delete() {
        if (root == null)
            return false;
        else {
            return true;
        }
    }
}

public class AVL {
    public static void main(String[] args) {
        // Fill your code
        Scanner sc = new Scanner(System.in);
        System.out.println("AVL Tree Implementation.\n");
        System.out.println("Enter the data type of the data to be added");
        System.out.println("1.Integer\n2.Double\n");
        int n = sc.nextInt();
        String s = "";
        System.out.println("Choice 1: Insert an element.\nChoice 2: Delete an element.\nChoice 3: Display.\n");
        if (n == 1) {
            AVLTree<Integer> a = new AVLTree<>();
            while (true) {
                System.out.println("Enter your choice :");
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Enter the element to be inserted :");
                        a.insert(sc.nextInt());

                        break;
                    case 2:
                        boolean x = a.delete();
                        if (x == false)
                            System.out.println("Tree is empty");
                        else {
                            System.out.println("Enter the element to be deleted :");
                            a.delete(sc.nextInt());

                        }
                        break;

                    case 3:
                        a.display();
                        System.out.println();
                        break;
                    default:
                        System.exit(0);
                }
            }
        }
        if (n == 2) {
            AVLTree<Double> a = new AVLTree<>();
            while (true) {
                System.out.println("Enter your choice :");
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Enter the element to be inserted :");
                        a.insert(sc.nextDouble());

                        break;
                    case 2:
                        boolean x = a.delete();
                        if (x == false)
                            System.out.println("Tree is empty");
                        else {
                            System.out.println("Enter the element to be deleted :");
                            a.delete(sc.nextDouble());

                        }
                        break;

                    case 3:
                        a.display();
                        System.out.println();
                        break;
                    default:
                        System.exit(0);
                }
            }
        }
    }

}