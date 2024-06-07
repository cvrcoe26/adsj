import java.util.*;
class GenericQueue<T>{
	T arr[];
	int rear,front,size;
	GenericQueue(int size){
		arr=(T[])new Object[size];
		rear=-1;
		front=-1;
		this.size=size;
		
	}
	public void enqueue(T ele){
		if(rear==-1 && front==-1){
			arr[++rear]=ele;
			++front;
            return;
		}
		arr[++rear]=ele;
	}
	public T dequeue(){
		T ele= arr[front];
		if(front==0 && rear==0)
			front=rear=-1;
		else{
			for(int i=front;i<rear;i++)
				arr[i]=arr[i+1];
			rear--;
		}
		return ele;
	}
	public void display(){
		System.out.println("Queue elements are:");
		for(int i=front;i<=rear;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		
	}
	boolean isEmpty(){
		if(rear==-1 && front==-1)
			return true;
		else
			return false;
	}
	boolean isFull(){
		if(rear==size-1)
			return true;
		else
			return false;
	}
}
public class QueueArray{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n,ch;
		String ele;
		System.out.println("Enter array size: ");
		n=sc.nextInt();
		GenericQueue<String> q=new GenericQueue<>(n);
		do{
			System.out.printf("****MENU*****\n1.ENQUEUE\n2.DEQUEUE\n3.DISPLAY\n4.EXIT\nEnter choice :");
			ch=sc.nextInt();
			switch(ch){
				case 1:if(q.isFull())
						System.out.println("Queue is full");
					else{
						System.out.println("Enter element : ");
						ele=sc.next();
						q.enqueue(ele);
					}
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
