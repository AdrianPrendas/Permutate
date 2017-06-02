/*
  a6r1an@gmail.com EIF203
*/
package eif203.labs.permutate;
import eif203.util.Delayer;
import java.lang.*;
import java.util.*;
import java.util.function.*;
import org.apache.commons.lang3.ArrayUtils;

/**
  * Helper variables and helper functions
  * @author Carlos Loria Saenz loriacarlos@gmail.com
  * @author Adrian Prendas Araya a6r2an@gmail.com
  * @author Genesis
  * @author Flavio
  * @author Joseph
  */
public class HelperPermutate{
	/**
	  * counts swaps 
	  */
	public static int swaps = 0;           
	/**
	  * counts permutations 
	  */
	public static int permutation = 0;
	/**
	  * counts insertions 
	  */
	public static int insertions = 0;
	/**
	  * verifies correctness
	  */  
	public static PermTester permTester = null;
	/**
	  * indicates the algroithms currently used
	  */ 
	public static String method = "";
	/**
	  * if not indicated algorithms uses this number for generation
	  */ 
	public static final int DEFAULT_PERMUT_SIZE = 8;
	
	// Algorithm names (method)
	public static final String BACKTRACKING   = "backtrack";
	public static final String HEAP_SEDGEWICK = "heap_sedgewick";
	public static final String LEXIC          = "lexicographic";
	public static final String NAIVE          = "naive";
	public static final String TREE           = "tree";
	
	/**
	  * Array of letters used to permutate (max = 20)
	  */
	public static char[] baseArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
	                 				  'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
					 				  'Q', 'R', 'S', 'T'
	                				 };
	
	/**
	  * this function is a pointer to other function <br>
	  * that receive a param (a) array of char that is a permutation <br>
	  * to save and or show 
	  */
	public static Function<char[],Void> doit =  a -> {HelperPermutate.showPermutation(a);return null;};
	/**
	  * time of the SO
	  * @return Current time of the SO in milli secs
	  */
    public static long cTM(){return System.currentTimeMillis();}

    /**
	  * @param a permutation to save and or show <br>
	  * depends of a verbose from Printing<br>
	  * @see Printing verbose
	  */
	public static void showPermutation(char[] a){
		if (HelperPermutate.permTester!=null)
			HelperPermutate.permTester.add(new Permutation(method, new String(a).split("")));//,tiempo()
		Printing.printPlain(String.format("(%d) %s", ++permutation, Arrays.toString(a)));
	}


	/**
 	  * Simple exchange function with counter (reset every time a function is tested)
 	  * @param a permutation
 	  * @param i index of first element
 	  * @param j index of second element <hr>
 	  * this two elements change their position one for another
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
	/**
	  * inserts x a every position i in p with counting
	  * @param p permutation
	  * @param i index
	  * @param x the element to insert in the position "i"
	  * @return a new permutation
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
	/**
	  * calculate factorial
	  * @param n the factorial for this <code>int</code>
	  * @return factorial
	  */
	public static int fact(int n){
		//System.out.println("factorial");
		int f = 1;
		for (int i = 1; i <=n; f *= i, i++);
		return f;
	}
	/**
	  * Generate an array base of n and baseArray
	  * @param n the elemento of the new array
	  * @return a new array with number of elements that is on margin of lenght baseArray 
	  */
	public static char[] genArray(int n){
		n = (n>1 && n<20) ? n : DEFAULT_PERMUT_SIZE;
		n = n % baseArray.length;
		return Arrays.copyOfRange(baseArray,0,n);
	}
    /**
	  * reset the values for test each of algoritm<br>
	  * also reset the printing values
	  * @see Printing
	  */
	public static void reset(){
		Printing.resetMargin();
		permutation = 0;
		swaps = 0;
		insertions = 0;
		method = "";
		HelperPermutate.permTester = null;
	}
}

