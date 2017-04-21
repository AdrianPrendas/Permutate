/*
  a6r1an@gmail.com
*/
/*
  Utility for printing with some margin
*/
package eif203.labs.permutate;

public class Printing{
	public static int margin =0 ;
	public static int increment = 3;
	public static char marginChar = ' ';
	public static boolean verbose = false;

	public static void resetMargin(){
		margin = 0;
		increment = 3;
    	marginChar = ' ';
	}
	public static void incMargin(){
		margin += increment;
	}
	public static void decMargin(){
		margin -= increment;
	}
	public static void printMargin(String s){
		if (! verbose ) return;
		for (int i = 1; i <= margin; i++) 
			System.out.print(marginChar);
		System.out.println(s);
	}
	public static void printPlain(String s){
		if (! verbose ) return;
		System.out.println(s);
	}
}