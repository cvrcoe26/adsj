
class pair<k, v> {
    k key;
    v value;

    pair(k key, v value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return this.key + " " + this.value;
    }
}

class lp<k, v> {
    pair<k, v> htable[];
    boolean bit[];
    int size;

    lp(int n) {
        this.size = n;
        htable = new pair[size];
        bit = new boolean[size];
        for (int i = 0; i < size; i++) {
            htable[i] = null;
            bit[i] = true;
        }
    }

    void insert(pair<k, v> entry) {
        int home = hash(entry.key);
        int i = probe(home);
        if (i != -1) {
            htable[i] = entry;
            bit[i] = false;
        } else {
            System.out.println("hash table is full, insertion not possible");
        }
    }

    int hash(k key) {
        return key.hashCode() % size;
    }

    int probe(int home) {
        int i = home;
        do {
            if (htable[i] == null)
                return i;
            i = (i + 1) % size;
        } while (i != home);
        return -1;
    }

    void display() {
        if (isEmpty())
            System.out.println("hash table is empty");
        else {
            System.out.println("hash table entries are:");
            for (int i = 0; i < size; i++) {
                if (htable[i] == null)
                    System.out.println(i + " null");
                else
                    System.out.println(i + " " + htable[i]);
            }
        }
    }

    boolean isEmpty() {
        boolean f = true;
        for (int i = 0; i < size; i++) {
            if (htable[i] == null)
                f = false;
        }
        return f;
    }

    void delete(k key) {
        int home = hash(key);
        int i = home;
        do {
            if (htable[i] != null && htable[i].key.equals(key)) {
                System.out.println("delted key:" + htable[i]);
                htable[i] = null;
                return;
            } else {
                i = (i + 1) % size;
            }
        } while (bit[i] != true && i != home);
        System.out.println("key not found");
    }

    void find(k key) {
        int home = hash(key);
        int i = home;
        do {
            if (htable[i] != null && htable[i].key.equals(key)) {
                System.out.println("found at:" + i);
                return;
            } else
                i = (i + 1) % size;
        } while (bit[i] != true && i != home);
        System.out.println("not found");
    }
}

public class linearProbing {
    public static void main(String[] args) {
        lp<Integer, String> a = new lp<>(5);
        pair<Integer, String> p1, p2, p3, p4;
        p1 = new pair<>(2, "apple");
        p2 = new pair<>(6, "banana");
        p3 = new pair<>(7, "grapes");
        p4 = new pair<>(12, "pineapple");
        a.insert(p1);
        a.insert(p2);
        a.insert(p3);
        a.insert(p4);
        a.display();
        a.delete(6);
        a.find(2);
    }
}
