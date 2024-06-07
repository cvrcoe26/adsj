import java.util.*;

public class QueueArrayColl {
    public static void main(String[] args) {
        GenericQueue<Integer> q = new GenericQueue<>();
		Scanner sc=new Scanner(System.in);
		int n,ch,ele;
		do{
			System.out.printf("1.ENQUEUE\n2.DEQUEUE\n3.DISPLAY\n4.EXIT\nEnter choice:");
			ch=sc.nextInt();
			switch(ch){
				case 1:
						System.out.println("Enter element : ");
						ele=sc.nextInt();
						q.enqueue(ele);
					break;
				case 2:if(q.isEmpty())
						System.out.println("Queue is empty");
					else{
						ele=q.dequeue();
						System.out.println("Dequeued element : "+ele);
					}
					break;
				case 3:if(q.isEmpty())
						System.out.println("Queue is empty");
					else
						q.display();
					break;
				case 4:System.exit(0);
					break;
				default:System.out.println("Invalid choice");
			}
		}while(ch!=4);
	}

    }


class GenericQueue<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void enqueue(T element) {
        list.add(element);
    }

    public T dequeue() {
        return list.remove(0);
    }

    public T peek() {
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void display() {
        System.out.println(list);
    }
}
