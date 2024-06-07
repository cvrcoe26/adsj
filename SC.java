class Pair<K extends Comparable<K>, V> {
    K key;
    V val;

    Pair(K key, V val) {
        this.key = key;
        this.val = val;
    }

    public String toString() {
        return key + "-" + val;
    }
}

class PairNode<K extends Comparable<K>, V> {
    Pair<K, V> data;
    PairNode<K, V> next;

    PairNode(Pair<K, V> data, PairNode<K, V> next) {
        this.data = data;
        this.next = next;
    }
}

class SeperateChain<K extends Comparable<K>, V> {
    PairNode<K, V>[] sc;
    int size, no;

    SeperateChain(int n) {
        size = n;
        no = 0;
        sc = new PairNode[n];
        for (int i = 0; i < n; i++)
            sc[i] = null;
    }

    int hash(K key) {
        return Math.abs(key.hashCode() % size);
    }

    boolean isEmpty() {
        return no == 0;
    }

    void insert(Pair<K, V> d) {
        int home = hash(d.key);
        PairNode<K, V> newNode = new PairNode<>(d, null);
        if (sc[home] == null)
            sc[home] = newNode;
        else {
            PairNode<K, V> temp = sc[home];
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        no++;
    }

    void display() {
        if (isEmpty())
            System.out.println("empty");
        else {
            System.out.println("Entries: ");
            for (int i = 0; i < size; i++) {
                if (sc[i] == null)
                    System.out.println(i+": NULL");
                else {
                    PairNode<K, V> temp = sc[i];
                    System.out.print(i + ": ");
                    while (temp != null) {
                        System.out.print(temp.data + " ");
                        temp = temp.next;
                    }
                    System.out.println();
                }
            }
        }
    }

    void delete(K dkey) {
        if (isEmpty()) {
            System.out.println("empty");
            return;
        }
        int home = hash(dkey);
        PairNode<K, V> curr = sc[home], prev = null;
        while (curr != null && !curr.data.key.equals(dkey)) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            if (curr == sc[home])
                sc[home] = curr.next;
            else
                prev.next = curr.next;
            System.out.println("Deleted: " + curr.data);
            no--;
        } else
            System.out.println("Not found");
    }

    void find(K fkey) {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        int home = hash(fkey);
        PairNode<K, V> curr = sc[home];
        while (curr != null && !curr.data.key.equals(fkey))
            curr = curr.next;
        if (curr != null)
            System.out.println("found: " + curr.data);
        else
            System.out.println("not found");
    }
}

public class SC {
    public static void main(String[] args) {
        SeperateChain<Integer, String> sp = new SeperateChain<>(5);
        Pair<Integer, String> p1, p2, p3, p4;
        p1 = new Pair<>(3, "Java");
        p2 = new Pair<>(6, "C");
        p3 = new Pair<>(23, "Python");
        p4 = new Pair<>(19, "HTML");
        sp.insert(p1);
        sp.insert(p2);
        sp.insert(p3);
        sp.insert(p4);
        sp.display();
        sp.delete(3);
        sp.find(19);
    }
}
