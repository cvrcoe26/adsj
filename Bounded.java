import java.util.*;
class GenNumber<T extends Number>{
	T[] vals;
	GenNumber(T[] obj){
		this.vals=obj;
	}
	double average(){
		int len=vals.length;
		double sum=0.0;
		for(T ele:vals)
			sum+=ele.doubleValue();
		return sum/len;
	}
	boolean isAvgSame(GenNumber<?> obj){
		if(this.average()==obj.average())
			return true;
		else
			return false;
	}
}
public class Bounded{
	public static void main(String[] args){
		Integer[] i={1,2,3,4,5,6};
		GenNumber<Integer> a1=new GenNumber<>(i);
		Double[] d={1.0,2.0,3.0,4.0,5.0,6.0};
		GenNumber<Double> a2=new GenNumber<>(d);
		System.out.println("Average of a1: "+a1.average());
		System.out.println("Average of a2: "+a2.average());
		if(a1.isAvgSame(a2))
			System.out.println("Average is same");
		else
			System.out.println("Average is not same");
	}
}
		
