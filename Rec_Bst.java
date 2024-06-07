import java.util.*;

class Pair<K extends Comparable<K>, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "Key:" + key + " Value:" + value;
    }
}

class TreeNode<K extends Comparable<K>, V> {
    Pair<K, V> data;
    TreeNode<K, V> lchild;
    TreeNode<K, V> rchild;

    TreeNode(Pair<K, V> P, TreeNode<K, V> lchild, TreeNode<K, V> rchild) {
        this.data = P;
        this.lchild = lchild;
        this.rchild = rchild;
    }
}

class BSTDictionary<K extends Comparable<K>, V> {
    TreeNode<K, V> Root;
    int dsize;

    boolean isEmpty() {
        return Root == null;
    }

    int size() {
        return dsize;
    }

    void insert(Pair<K, V> P) {
        Root = insertRec(Root, P);
        dsize++;
    }

    private TreeNode<K, V> insertRec(TreeNode<K, V> node, Pair<K, V> P) {
        if (node == null) {
            return new TreeNode<>(P, null, null);
        }

        if (P.key.compareTo(node.data.key) < 0) {
            node.lchild = insertRec(node.lchild, P);
        } else if (P.key.compareTo(node.data.key) > 0) {
            node.rchild = insertRec(node.rchild, P);
        }

        return node;
    }

    Pair<K, V> find(K key) {
        return findRec(Root, key);
    }

    private Pair<K, V> findRec(TreeNode<K, V> node, K key) {
        if (node == null || node.data.key.equals(key)) {
            return node == null ? null : node.data;
        }

        if (key.compareTo(node.data.key) < 0) {
            return findRec(node.lchild, key);
        } else {
            return findRec(node.rchild, key);
        }
    }

    void delete(K key) {
        Root = deleteRec(Root, key);
    }

    private TreeNode<K, V> deleteRec(TreeNode<K, V> root, K key) {
        if (root == null) {
            return root;
        }

        if (key.compareTo(root.data.key) < 0) {
            root.lchild = deleteRec(root.lchild, key);
        } else if (key.compareTo(root.data.key) > 0) {
            root.rchild = deleteRec(root.rchild, key);
        } else {
            if (root.lchild == null) {
                return root.rchild;
            } else if (root.rchild == null) {
                return root.lchild;
            }

            root.data = findMin(root.rchild);
            root.rchild = deleteRec(root.rchild, root.data.key);
        }

        return root;
    }

    private Pair<K, V> findMin(TreeNode<K, V> node) {
        Pair<K, V> min = node.data;
        while (node.lchild != null) {
            min = node.lchild.data;
            node = node.lchild;
        }
        return min;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }

        System.out.println("MENU");
        System.out.println("1. INORDER TRAVERSAL");
        System.out.println("2. PREORDER TRAVERSAL");
        System.out.println("3. POSTORDER");
        System.out.println("Enter Choice:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                inorder(Root);
                break;
            case 2:
                preorder(Root);
                break;
            case 3:
                postorder(Root);
                break;
        }
    }

    void inorder(TreeNode<K, V> Root) {
        if (Root != null) {
            inorder(Root.lchild);
            System.out.println(Root.data);
            inorder(Root.rchild);
        }
    }

    void preorder(TreeNode<K, V> Root) {
        if (Root != null) {
            System.out.println(Root.data);
            preorder(Root.lchild);
            preorder(Root.rchild);
        }
    }

    void postorder(TreeNode<K, V> Root) {
        if (Root != null) {
            postorder(Root.lchild);
            postorder(Root.rchild);
            System.out.println(Root.data);
        }
    }
}

class Main {
    public static void main(String args[]) {
        BSTDictionary<Integer, String> bst = new BSTDictionary<Integer, String>();
        Scanner sc = new Scanner(System.in);
        int choice;
        Integer key;
        String value;
        Pair<Integer, String> P;
        do {
            System.out.println("BST DICTIONARY OPERATIONS");
            System.out.println("1.Insert");
            System.out.println("2.Delete");
            System.out.println("3.Find");
            System.out.println("4.Display");
            System.out.println("Enter an operation you like to perform");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the key:");
                    key = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the value:");
                    value = sc.nextLine();
                    P = new Pair<Integer, String>(key, value);
                    bst.insert(P);
                    break;
                case 2:
                    System.out.println("Enter the key:");
                    key = sc.nextInt();
                    bst.delete(key);
                    break;
                case 3:
                    System.out.println("Enter the key:");
                    key = sc.nextInt();
                    P = bst.find(key);
                    if (P == null)
                        System.out.println("Entry not found");
                    else
                        System.out.println("Entry found: Key :" + P.key + " Value :" + P.value);
                    break;
                case 4:
                    bst.display();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }
}
