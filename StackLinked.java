import java.util.*;
class LLIStack<T>{
	class Node{
		T data;
		Node next;
		Node(T data){
			this.data=data;
			this.next=null;
		}
	}
	Node top;
	LLIStack(){
		top=null;
	}
	public void push(T ele){
		Node nn=new Node(ele);
		nn.next=top;
		top=nn;
	}
	public T pop(){
		T ele=top.data;
		Node curr=top;
		top=top.next;
		curr=null;
	return ele;
	}
	public T topS(){
		 T ele=top.data;
		 return ele;
	}
	public void display(){
		System.out.println("Stack elements are:");
		Node curr=top;
		while(curr!=null){
			System.out.println(curr.data);
			curr=curr.next;
		}	
	}
	boolean isEmpty(){
		if(top==null)
			return true;
		else
			return false;
	}
}
public class StackLinked{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int ch;
		int ele;
		LLIStack<Integer> s=new LLIStack<>();
		do{
			System.out.printf("****MENU*****\n1.PUSH\n2.POP\n3.TOP\n4.DISPLAY\n5.EXIT\nEnter choice :");
			ch=sc.nextInt();
			switch(ch){
				case 1:System.out.println("Enter element : ");
					ele=sc.nextInt();
					s.push(ele);					
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
					else
						s.display();
					
					break;
				case 5:System.exit(0);
					break;
				default:System.out.println("Invalid choice");
			}
		}while(ch!=5);
	}
}	
