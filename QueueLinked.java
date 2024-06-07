import java.util.*;
class GenericQueue<T>{
	class Node{
		T data;
		Node next;
		Node(T ele){
			this.data=ele;
			this.next=null;
		}
	}
	Node rear,front;
	GenericQueue(){
		rear=front=null;
	}
	public void enqueue(T ele){
		Node nn=new Node(ele);
		if(rear==null && front==null)
			rear=front=nn;
		else{
			rear.next=nn;
			rear=nn;
		}
	}
	public T dequeue(){
		T ele=front.data;
		Node curr=front;
		if(rear==front)
			rear=front=null;
		else
			front=front.next;
		curr=null;
		return ele;
	}
	public void display(){
		System.out.println("Queue Elements are:");
		Node curr=front;
		while(curr!=null){
			System.out.print(curr.data+" ");
			curr=curr.next;
		}
	}
	boolean isEmpty(){
		if(rear==null&& front==null)
			return true;
		else
			return false;
	}
}
public class QueueLinked{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int ch;
		String ele;
		GenericQueue<String> q=new GenericQueue<>();
		do{
			System.out.printf("****MENU*****\n1.ENQUEUE\n2.DEQUEUE\n3.DISPLAY\n4.EXIT\nEnter choice :");
			ch=sc.nextInt();
			switch(ch){
				case 1:System.out.println("Enter element : ");
					ele=sc.next();
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
