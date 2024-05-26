class Pair<K extends Comparable<K>,V>{
    K key;
    V value;
    Pair(){}
    Pair(K key,V value){
        this.key=key;
        this.value=value;
    }
    public String toString(){
        return "Key: "+key+" Value: "+value;
    }
}
class PairNode<K extends Comparable<K>,V>{
    Pair<K,V> data;
    PairNode<K,V> next;
    PairNode(Pair<K,V> pair,PairNode<K,V> next){
        this.data=pair;
        this.next=next;
    }
}
class SortedChain<K extends Comparable <K>,V>{
    PairNode <K,V> head;
    int dsize;
    public boolean isEmpty(){
        return head==null;
    }
    public int size(){
        return dsize;
    }
    public void insert(Pair<K,V> p){
        PairNode<K,V> npNode= new PairNode<K,V>(p,null);
        PairNode<K,V> temp,prev;
        if(isEmpty())
            head=npNode;
        else if(p.key.compareTo(head.data.key)<0){
            npNode.next=head;
            head=npNode;
        }
        else{
            temp=head;
            prev=null;
            while(temp!=null && p.key.compareTo(temp.data.key)>0){
                prev=temp;
                temp=temp.next;
            }
            npNode.next=temp;
            prev.next=npNode;
        }
        dsize++;
    }
    public void display(){
        PairNode<K,V> temp;
        if(isEmpty()){
            System.out.println("Empty Dictionary");
            return;
        }
        else{
            temp=head;
            while(temp!=null){
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
    }
    public Pair<K,V> find(K fkey){
        Pair<K,V> T=null;
        PairNode<K,V> temp=head;
        while(temp!=null && fkey.compareTo(temp.data.key)>0)
            temp=temp.next;
        if(temp!=null){
                if(temp.data.key.equals(fkey))
                    T=temp.data;
        }
        return T;
    }
    public void delete(K dkey){
        PairNode<K,V> temp=head;
        PairNode<K,V> prev=null;
        if(isEmpty()){
            System.out.println("Empty dict");
            return;
        }
        while(temp!=null && dkey.compareTo(temp.data.key)>0){
            prev=temp;
            temp=temp.next;
        }
        if(temp!=null && temp.data.key.equals(dkey)){
            System.out.println("deleted key: "+temp.data);
            if(temp==head)
                head=head.next;
            else
                prev.next=temp.next;
            dsize--;
        }
        else{
            System.out.println("element not found");
            temp.next=null;
            temp=null;
            prev=null;
        }

    }
}
public class Sorted{
    public static void main(String[] args) {
        SortedChain<Integer,String> s=new SortedChain<Integer,String>();
        Pair<Integer,String> p1=new Pair<Integer,String>(4,"Apple");
        Pair<Integer,String> p5=new Pair<Integer,String>(3,"Orange");
        Pair<Integer,String> p2=new Pair<Integer,String>(1,"Grapes");
        Pair<Integer,String> p3=new Pair<Integer,String>(2,"Banana");
        s.insert(p1);s.insert(p2);s.insert(p3);s.insert(p5);
        System.out.println("Sorted Chain Dictionary :");
        s.display();
        s.delete(1);
        System.out.println("After removing  :");
        s.display();
        System.out.println("Finfing 2 - "+ s.find(2));

    }
}