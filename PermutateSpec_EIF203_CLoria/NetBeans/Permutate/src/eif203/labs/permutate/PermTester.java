package eif203.labs.permutate;
import java.util.*;
import eif203.util.*;

/*
 loriacarlos@gmail.com
*/
public class PermTester extends Hashtable<String, Permutation> {
	protected int n;
	protected int max_size;
	final String method;
	final protected String[] OBJECTS = {"A", "B", "C", "D", "E",
	                                    "F", "G", "H", "I", "J",
										"K", "L", "M", "N", "O",
										"P", "Q", "R", "S", "T"
	};
	final Permutation seed;
	final String source;
	
	public PermTester(String method, int n){
		this.method = method;
		this.n = n;
		// set max_size
		int f = 1;
		for(int i = 1; i <= n; f *= i, i++);
		this.max_size = f;
		// Set seed and source
		this.seed = new Permutation(method, Arrays.copyOfRange(OBJECTS, 0, n % OBJECTS.length));
		this.source = this.seed.source();
	}
	 
	public void add(Permutation p){
		if ( !this.source.equals(p.source())){
			throw new RuntimeException("Invalid source: " + p + " != " + this.source);
		}
		if (size() + 1 > this.max_size){
			throw new RuntimeException("Size beeing exceeded: " + (size() + 1) + " > " + this.max_size);
		}
		String key = p.toString();
		if ( get(key) != null){
			throw new RuntimeException("Duplicated key: " + key);
		}
		if (p.size() != this.n){
			throw new RuntimeException("Invalid size: " + p.size() + " != " + this.n);
		}
		super.put(key, p);
	}
	
	public void ensureComplete(){
		if (size() != this.max_size ) {
			throw new RuntimeException("Incomplete.: " + this.max_size + " != " + this.size());
		}
		
	}
	
	public void toCSV(String filename) throws Exception {///n y swaps para el csv, heap el mejor
		ensureComplete();
		StringBuffer b = new StringBuffer();
		// Headers
		b.append("Method,");
		for(int i = 0; i < this.n - 1; i++)
			b.append("p[" + i + "],");
		b.append("p[" + (this.n - 1) + "],");
		b.append("Cost(ms)\n");
		// Permutations
		for(String key : keySet()){
			Permutation p = get(key);
			b.append(p.getMethod() + ",");
			String[] value = p.getValue();
			for(int i = 0; i < value.length; i++){
			   b.append(value[i] + ",");
			}
			b.append(p.getCost() + "\n");
		}
		IOServices.writeText("", filename, b.toString());
	}
	
}