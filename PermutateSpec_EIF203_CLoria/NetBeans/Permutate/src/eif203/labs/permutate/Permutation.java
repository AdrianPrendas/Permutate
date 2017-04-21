package eif203.labs.permutate;
import java.util.*;
/*
 loriacarlos@gmail.com
*/
public class Permutation {
	protected String method;
	protected String[] value;
	protected long cost;
	
	public String[] getValue(){
		return this.value;
	}
	public String getMethod(){
		return this.method;
	}
	public int getSize(){
		return this.value.length;
	}
	public long getCost(){
		return this.cost;
	}
	
	public Permutation(String method, String[] value, long cost){
		this.method = method;
		this.value = value;
		this.cost = cost;
	}
	public Permutation(String method, String[] value){
		this(method, value, 0);
	}
	public String toString(){
		return String.format("{%s}%s", this.method, Arrays.toString(this.value));
	}
	public int size(){
		return this.value.length;
	}
	
	public String source(){
		String[] c = copy();
		Arrays.sort(c);
		return (new Permutation(this.method, c)).toString();
	}
	protected String[] copy(){
		String[] c = new String[this.value.length];
	    for (int i = 0; i < c.length; i++){
		   c[i] = this.value[i];
	    }
		return c;
	}
}
