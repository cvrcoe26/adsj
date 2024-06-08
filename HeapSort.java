import java.util.ArrayList;

class HeapSort<T extends Comparable<T>> {
  ArrayList<T> Arr;
  int n;
  T temp;

  HeapSort(T[] A, int s) {
    Arr = new ArrayList(s + 1);
    Arr.add(0, null);
    n = s;
    for (int i = 0; i < n; i++)
      Arr.add(i + 1, A[i]);
  }

  void hsort() {
    heapInitialize();
    heapExchange_Heapify();
    display();
  }

  void heapInitialize() {
    for (int I = n / 2; I >= 1; I--) {
      heapify(Arr, I, n);
    }
  }

  void heapExchange_Heapify() {
    for (int lastelepos = n; lastelepos > 1; lastelepos--) {
      temp = Arr.get(1);
      Arr.set(1, Arr.get(lastelepos));
      Arr.set(lastelepos, temp);
      heapify(Arr, 1, lastelepos - 1);
    } 
  } 

  void heapify(ArrayList<T> Arr, int rootpos, int m) {
    temp = Arr.get(rootpos);
    int parent = rootpos;
    int child = parent * 2;
    while (child <= m) {
      if (child < m && Arr.get(child).compareTo(Arr.get(child + 1)) < 0)
        child++;
      if (Arr.get(child).compareTo(temp) > 0) {
        Arr.set(parent, Arr.get(child));
        parent = child;
        child = child * 2;

      } else
        break;
    } 
    Arr.set(parent, temp);

  }

  void display() {
    for (int i = 1; i <= n; i++)
      System.out.print(Arr.get(i) + "   ");
  }

  public static void main(String[] args) {
    Integer[] A = new Integer[] { 4, 7, 8, 2, 15, 9, 20, 25, 17, 11 };
    HeapSort<Integer> hs = new HeapSort<Integer>(A, 10);
    hs.hsort();
  }
}
