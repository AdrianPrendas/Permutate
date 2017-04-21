/*
 a6r1an@gmail.com
 EIF203
 Project Permutate
 Traslate from js to java
*/
//////////////// Algorithms /////////////////
/*
    1) Backtracking recursivo
	2) Recursivo Heap-Sedgewick
	3) Lexicografico
	4) Naive		
*/
package eif203.labs.permutate;
import java.util.function.*;
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;

public class Permutate{
	////////////////////////////////////////////////
	/*
   		1) Backtracking recursivo
	*/
	public static void recursive_backtracking(char[] a,int i,Function<char[],Void> doit){
		Printing.incMargin();
		Printing.printMargin("Enter Round i=" + i + " " + new String(a));
		if (i == 0){
			doit.apply(a);
			Printing.decMargin();
	    	return;
		}
	
		for (int j = 0; j <= i; j++){
			Printing.printMargin("Enter cycle i=" + i + " j=" + j + " " + new String(a));
			HelperPermutate.swap(a, i, j);// se puede quitar // cuando i es impar, rotacion a la derecha
			recursive_backtracking(a, i - 1, doit);
			HelperPermutate.swap(a, i, j);
		}
		
		Printing.printMargin("Leave Round i=" + i + " " + new String(a));
		Printing.decMargin();
	}
	////////////////////////////////////////////////////
	/*
	  2) Recursivo Heap-Sedgewick
	*/
	public static void recursive_heap_sedgewick(char[] a,int i,Function<char[],Void> doit){
		Printing.incMargin();
		Printing.printMargin("Enter Round i=" + i + " " + new String(a));
		if (i == 0){
			doit.apply(a);
			Printing.decMargin();
	    	return;
		}

		for (int j = 0; j <= i; j++){
			recursive_heap_sedgewick(a, i - 1, doit);
			Printing.printMargin("return-and-swap: i=" + i + " j=" + j);
			HelperPermutate.swap(a, (i % 2 == 0) ? 0 : j, i);//(i % 2 == 0) ? 0 : j //IDEA DEL PROFE // CAMBIAR Y COMPILAR
		}
		Printing.printMargin("Leave Round i=" + i + " " + new String(a));
		Printing.decMargin();
	}
	////////////////////////////////////////////////////
	/*
	  3) Lexicografico
	*/
	public static void next_lexicographic_permutation(char[] a){//podria retornar 0 o 1 si hay pico
		int i, k;
		// Find a peak;
		for( i = a.length - 2; i > 0 && a[i] > a[i + 1] ; i-- );
		if (i < 0){//-i cuando no hay pico
			return;
		}
		// i >= 0 && a[i] < a[i + 1] > a[i + 2] > ... > a[a.length - 1]
		// Find the least k st. a[k] > a[i]
		for (k = a.length - 1; k >= 0 && a[i] > a[k]; k--);
		HelperPermutate.swap(a, i, k);
		// reverse from i+1 .. a.length - 1
		for(int l = i + 1, r = a.length - 1;  l <= r; l++, r--){
			HelperPermutate.swap(a, l, r);
		}
	}
	public static void permutate_lexicographically(char[] a,Function<char[],Void> doit){
		for (int i = 0; i < HelperPermutate.fact(a.length); i++){//no es necesario el factorial, cuando ya no haya un pico
			Printing.printMargin("Round i=" + i + " " + new String(a));
			doit.apply(a);
			next_lexicographic_permutation(a);
		}
	}

	/*
		Demo
  		Very expensive recursive permutations generation
  		All permutations are first genearted
	*/
	////////////////////////////////////////////////////
	/*
   		4) Naive //simplon // alguien que le contamos una mentira cualquiera y se la cree
   		un simplo xD
	*/ 
	public static char[][] permutate_naively(char[] p){
		if (p.length == 0) return new char[0][0];
		if (p.length == 1){
                    char [][] arr = new char[1][1];
                    arr[0] = p;
                    return arr;
                } 
		char first = p[0];
		char[][] withoutFirst = permutate_naively(Arrays.copyOfRange(p,1,p.length));
		return insertFirstIntoAll(first, withoutFirst);
		
	}
	
	public static char[][] insertFirstIntoAll(char first,char[][] withoutFirst){
		char[][] res = new char [0][0];
		for(int i = 0; i < withoutFirst.length; i++){
			char[][] allWithFirst = insertFirstIntoOne(first, withoutFirst[i]);
			res = (char[][]) ArrayUtils.addAll(res, allWithFirst);
		}
		return res;
		
	}
	
	public static char[][] insertFirstIntoOne(char first,char[] p){ // p = [p[0], p[1], ..., p[n]]
		char[][] res = new char[p.length+1][0];
                int c = 0;
		for(int i = 0; i <= p.length; i++){
			char[] s = HelperPermutate.insertAt(p, i, first);
                        res[c++] = s;
		}
		return res;
	}

}
