/*
  a6r1an@gmail.com EIF203
*/
package eif203.labs.permutate;
import eif203.util.Delayer;
import java.lang.*;
import java.util.*;
import java.util.function.*;
import org.apache.commons.lang3.ArrayUtils;

public class HelperPermutate{
	// Helper variables and helper functions
	public static int swaps = 0;             // counts swaps
	public static int permutation = 0;      // counts permutations
	public static int insertions = 0;      // counts insertions
	public static PermTester permTester = null;  // verifies correctness
	public static String method = "";    // indicates the algroithms currently used

	// if not indicated algorithms uses this number for generation
	public static final int DEFAULT_PERMUT_SIZE = 8;
	
	// Algorithm names (method)
	public static final String BACKTRACKING   = "backtrack";
	public static final String HEAP_SEDGEWICK = "heap_sedgewick";
	public static final String LEXIC          = "lexicographic";
	public static final String NAIVE          = "naive";
	
	// Array of letters used to permutate (max = 20)
	public static char[] baseArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
	                 				  'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
					 				  'Q', 'R', 'S', 'T'
	                				 };
	
	/*
		saving Permutation
	*/
	public static Function<char[],Void> doit =  a -> {HelperPermutate.showPermutation(a);return null;};
    public static long cTM(){return System.currentTimeMillis();}
    private static long antes = 0;
    public static long tiempo(){
    	if(antes == 0)
    		antes = cTM();
    	return cTM() - antes;

    }
	public static void showPermutation(char[] a){
		if (HelperPermutate.permTester!=null)
			HelperPermutate.permTester.add(new Permutation(method, new String(a).split("")));//,tiempo()
		Printing.printPlain(String.format("(%d) %s", ++permutation, new String(a)));
	}


	/*
 	Simple exchange function with counter (reset every time a function is tested)
	*/
	public static void swap(char[] a,int i,int j){
		if ( i == j) 
			return;
		swaps += 4;//numero de accesos al arreglo
		char t = a[i];
		a[i] = a[j];
		a[j] = t;
		//Delayer.delayOpers(10,4);
	}
	/*
	  inserts x a every position i in p with counting
	*/
	public static char[] insertAt(char []p, int i, char x){
		char[] res = new char[p.length+1];//2
        int A=0;//1
		for(int k = 0; k < i; k++){//i
			insertions++;//1
			res[A++]= p[k];//3
		}
		insertions++;//1
        res[A++]= x;//3
		for(int k = i; k < p.length; k++){//p-i
			insertions++;//1
			res[A++]= p[k];//5
		}
		//Delayer.delayOpers(10,7 + i*4 + (p.length-i)*6);
		return res;
	}

	public static int fact(int n){
		int f = 1;
		for (int i = 1; i <=n; f *= i, i++);
		return f;
	}

	public static char[] genArray(int n){
		n = (n>1 && n<20) ? n : DEFAULT_PERMUT_SIZE;
		n = n % baseArray.length;
		return Arrays.copyOfRange(baseArray,0,n);
	}
    
	public static void reset(){
		Printing.resetMargin();
		permutation = 0;
		swaps = 0;
		insertions = 0;
		method = "";
		HelperPermutate.permTester = null;
		antes=0;
	}
}

