package eif203.labs.permutate;

/**
  * Utility for printing with some margin
  * @author Carlos Loria Saenz loriacarlos@gmail.com
  * @author Adrian Prendas Araya a6r2an@gmail.com
  * @author Genesis
  * @author Flavio
  * @author Joseph
  */
public class Printing{
	/**
	  *default=<code>0</code>
	  */
	public static int margin =0 ;
	/**
	  * default=<code>3</code>
	  */
	public static int increment = 3;
	/**
	  * default=<code>' '</code>
	  */
	public static char marginChar = ' ';
	/**
	  * is the most important parameter for this class <br>
	  * this parameter establish if the algorithms show the procedure <br>
	  * to go for a next permutation and each of the permutation generate <br>
	  * <br>default=<code>false</code>
	  */
	public static boolean verbose = false;
	

	/**
	  * to restore at default values to print except verbose
	  */
	public static void resetMargin(){
		margin = 0;
		increment = 3;
    	marginChar = ' ';
	}
	/**
	  * increment  <code>margin</code>  in <code>increments</code>
	  */
	public static void incMargin(){
		margin += increment;
	}
	/**
	  * decrement  <code>margin</code>  in <code>increments</code>
	  */
	public static void decMargin(){
		margin -= increment;
	}
	/**
	  * to print with margins
	  * @param s to show
	  */
	public static void printMargin(String s){
		if (! verbose ) return;
		for (int i = 1; i <= margin; i++) 
			System.out.print(marginChar);
		System.out.println(s);
	}
	/**
	  * to print without margins
      * @param s to show
	  */
	public static void printPlain(String s){
		if (! verbose ) return;
		System.out.println(s);
	}
}