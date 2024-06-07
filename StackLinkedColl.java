import java.util.*;

public class StackLinkedColl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch, ele;
        GenericStack<Integer> st = new GenericStack<>();
        
        do {
            System.out.printf("1.PUSH\n2.POP\n3.TOP\n4.DISPLAY\n5.EXIT\nEnter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter element: ");
                    ele = sc.nextInt();
                    st.push(ele);
                    break;
                case 2:
                    if (st.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        ele = st.pop();
                        System.out.println("Popped element: " + ele);
                    }
                    break;
                case 3:
                    if (st.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        ele = st.top();
                        System.out.println("Top element: " + ele);
                    }
                    break;
                case 4:
                    if (st.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Stack elements: ");
                        st.display();
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (ch != 5);
    }
}

class GenericStack<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void push(T item) {
        list.addFirst(item);
    }

    public T pop() {
        return list.removeFirst();
    }

    public T top() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        System.out.println(list);
    }
}
