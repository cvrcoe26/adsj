import java.util.*;
interface Gs<T>{
	void push(T ele);
	T pop();
	T topS();
	void display();
	boolean isEmpty();
	boolean isFull();
}

class GenStackArray<T> implements Gs<T>{
	T arr[];
	int top,size;
	GenStackArray(int size){
		this.arr=(T[])new Object[size];
		top=-1;
		this.size=size;
		
	}
	public void push(T ele){
		arr[++top]=ele;
	}
	public T pop(){
		return arr[top--];
	}
	public T topS(){
		return arr[top];
	}
	public void display(){
		for(int i=top;i>=0;i--)
			System.out.println(arr[i]);
		
	}
	public boolean isEmpty(){
		if(top<=-1)
			return true;
		else
			return false;
	}
	public boolean isFull(){
		if(top==size-1)
			return true;
		else
			return false;
	}
}
public class StackArray{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n,ch;
		String ele;
		System.out.println("Enter array size: ");
		n=sc.nextInt();
		GenStackArray<String> s=new GenStackArray<>(n);
		do{
			System.out.printf("****MENU*****\n1.PUSH\n2.POP\n3.TOP\n4.DISPLAY\n5.EXIT\nEnter choice :");
			ch=sc.nextInt();
			switch(ch){
				case 1:if(s.isFull())
						System.out.println("Stack is full");
					else{
						System.out.println("Enter element : ");
						ele=sc.next();
						s.push(ele);
					}
					break;
				case 2:if(s.isEmpty())
						System.out.println("Stack is empty");
					else{
						ele=s.pop();
						System.out.println("Popped element : "+ele);
					}
					break;
				case 3:if(s.isEmpty())
						System.out.println("Stack is empty");
					else{
						ele=s.topS();
						System.out.println("Top element : "+ele);
					}
					break;
				case 4:if(s.isEmpty())
						System.out.println("Stack is empty");
					else{
						System.out.println("Stack elements : ");
						s.display();
					}
					break;
				case 5:System.exit(0);
					break;
				default:System.out.println("Invalid choice");
			}
		}while(ch!=5);
	}
}	
