import java.util.*;
class Pair<K extends Comparable<K>,V>
{
	K key;
	V value;
	Pair(K key, V value){
		this.key=key;
		this.value=value;
	}
	public String toString(){
		return "Key:"+key +" Value:"+ value;
	}
}
class TreeNode<K extends Comparable<K>,V>
{
	Pair<K,V> data;
	TreeNode<K,V> lchild;
	TreeNode<K,V> rchild;
	TreeNode(Pair<K,V> P, TreeNode<K,V> lchild, TreeNode<K,V> rchild) {
		this.data=P;
		this.lchild=lchild;
		this.rchild=rchild;
	}
}
class BSTDictionary<K extends Comparable<K>, V> {
	TreeNode<K,V> Root;
	int dsize;
	boolean isEmpty(){
		return Root==null;
	}
	int size(){
		return dsize;
	}
	void insert(Pair<K,V> P){
		TreeNode<K,V> nn=new TreeNode<K,V>(P,null,null);
		TreeNode<K,V> Parent=null;
		TreeNode<K,V> Child;
		if(isEmpty())
			Root=nn;
		else{ 
			Child=Root;
			while(Child!=null){
				Parent=Child;
				if(P.key.compareTo(Child.data.key)>0)
					Child=Child.rchild;
				else
					Child=Child.lchild;
			}//while
			if(P.key.compareTo(Parent.data.key)>0)
				Parent.rchild=nn;
			else
				Parent.lchild=nn;
		}
		dsize++;
	}
	Pair<K,V> find(K key){
		TreeNode<K,V> Temp=Root;
		while(Temp!=null&&!key.equals(Temp.data.key)){
			if(key.compareTo(Temp.data.key)>0)
				Temp=Temp.rchild;
			else if(key.compareTo(Temp.data.key)<0)
				Temp=Temp.lchild;
		}
		if(Temp!=null)
			return Temp.data;
		else
			return null;
	}
	void display(){
		if(isEmpty()){
		System.out.println("Tree is empty");
	return;
		}
	System.out.println("MENU");
	System.out.println("1. INORDER TRAVERSAL");
	System.out.println("2. PREORDER TRAVERSAL");
	System.out.println("3. POSTORDER");
	System.out.println("Enter Choice:");
	Scanner sc=new Scanner(System.in);
	int choice=sc.nextInt();
	switch(choice){
		case 1: inOrder(Root);
			break;
		case 2:preorder(Root);
			break;
		case 3:postorder(Root);
			break;
	}
	}
	void inorder( TreeNode<K,V> Root){
		if(Root!=null){
			inorder(Root.lchild);
			System.out.println(Root.data);
			inorder(Root.rchild);
		}
	}
	void inOrder( TreeNode<K,V> Root){
		if(Root!=null){	
			inorder(Root.lchild);
			System.out.println(Root.data);
			inorder(Root.rchild);
		}
	}
	void preorder( TreeNode<K,V> Root){
		if(Root!=null){
			System.out.println(Root.data);
			inorder(Root.lchild);
			inorder(Root.rchild);
		}
	}
	void postorder( TreeNode<K,V> Root){
		if(Root!=null){
			inorder(Root.lchild);
			inorder(Root.rchild);
			System.out.println(Root.data);
		}
	}
	void delete(K key){
		TreeNode<K,V> Parent=null;
		TreeNode<K,V> Child;
		TreeNode<K,V> ps;
		TreeNode<K,V> s;
		if(isEmpty()){
			System.out.println("Tree is empty");
		return;
		}
		else
		{ 
			Child=Root;
			while(Child!=null && !key.equals(Child.data.key)){
			Parent=Child;
			if(key.compareTo(Child.data.key)>0)
				Child=Child.rchild;
			else if(key.compareTo(Child.data.key)<0)
				Child=Child.lchild;
			}//while
			if(Child==null){
				System.out.println("Entry not found");
			return;
		}
		if(Child.lchild!=null && Child.rchild!=null){
			ps=Child;
			s=Child.lchild;
			while(s.rchild!=null){
				ps=s;
				s=s.rchild;
			}
			Child.data=s.data;
			Child=s;
			Parent=ps;
		}
		TreeNode<K,V> c;
		if(Child.lchild==null)
			c=Child.rchild;
		else
			c=Child.lchild;
		if(Child==Root)
			Root=c;
		else if(Child==Parent.rchild)
			Parent.rchild=c;
		else
			Parent.lchild=c;
	}
    }
}
class BSTMain{
	public static void main(String args[]){
	      BSTDictionary<Integer, String> bst=new BSTDictionary<Integer,String>();
		Scanner sc=new Scanner(System.in);
		int choice;
		Integer key;
		String value;
		Pair<Integer,String> P;
	do{
		System.out.println("BST DICTIONARY OPERATIONS");
		System.out.println("1.Insert");
		System.out.println("2.Delete");
		System.out.println("3.Find");
		System.out.println("4.Display");
		System.out.println("Enter an operation you like to perform");
		choice=sc.nextInt();
		switch (choice){
			case 1 :
				System.out.println("Enter the key:");
				key=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the value:");
				value=sc.nextLine();
				P=new Pair<Integer,String>(key,value);
				bst.insert(P);
				break;
			case 2:
				System.out.println("Enter the key:");
				key=sc.nextInt();
				bst.delete(key);
				break;
			case 3:
				System.out.println("Enter the key:");
				key=sc.nextInt();
				P=bst.find(key);
				if(P==null)
					System.out.println("Entry not found");
				else
					System.out.println("Entry found:Key :"+ P.key + " Value :"+P.value);
				break;
			case 4:bst.display();
				break;
			case 5:
				System.exit(0);
			}
		}while(true);
	}
}