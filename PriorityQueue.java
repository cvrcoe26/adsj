import java.util.*;

class PriorityQueue<T extends Comparable<T>> {
    T heap[];
    int noelements;

    PriorityQueue(T heap[]) {
        this.heap = heap;
        noelements = 0;
    }

    void enqueue(T newele) {
        noelements++;
        int newelepos = noelements;
        while (newelepos > 1 && heap[newelepos / 2].compareTo(newele) < 0) {
            heap[newelepos] = heap[newelepos / 2];
            newelepos = newelepos / 2;
        }
        heap[newelepos] = newele;
    }

    void dequeue() {
        T lastele = heap[noelements--];
        int parent = 1;
        int child = 2;
        while (child <= noelements) {
            if (heap[child].compareTo(heap[child + 1]) < 0)
                child++;
            if (heap[child].compareTo(lastele) > 0) {
                heap[parent] = heap[child];
                parent = child;
                child = child * 2;

            } else
                break;
        }
        heap[parent] = lastele;
    }

    void display() {
        for (int i = 1; i <= noelements; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    void topele() {
        if (noelements == 0) {
            System.out.println("Priority queue is empty");
            return;
        }
        System.out.print("Top element is " + heap[1]);

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        int n = sc.nextInt();
        n = n + 1;
        Integer A[] = new Integer[n];
        PriorityQueue<Integer> PQ = new PriorityQueue<Integer>(A);
        System.out.println("1.insert \n 2.delete\n3.Top element\n4.display");
        System.out.println("4.exit");
        while (true) {
            System.out.println("enter your choice");
            ;
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("enter element");
                    PQ.enqueue(sc.nextInt());
                    break;
                case 2:
                    PQ.dequeue();
                    break;

                case 3:
                    PQ.topele();
                    break;
                case 4:
                    PQ.display();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}