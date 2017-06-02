package eif203.labs.permutate;

/**
  * This class contain testing for each algorithms
  * @author Carlos Loria Saenz loriacarlos@gmail.com
  * @author Adrian Prendas Araya a6r2an@gmail.com
  * @author Genesis
  * @author Flavio
  * @author Joseph
  */
public class TestPermutate{
	/**
	 * this method test the algorithm recursive backtracking
	 * and the time that cost <br>
	 * the <code>PermTester</code> ensure that the permutation are complete
	 * to storage the data on the  file
	 * @param n the size of the permutation, in this case nPn = n! permutations
	  */
	public static void test_recursive_backtracking(int n){
		System.out.println("\n*** Testing recursive_backtracking ***");
		HelperPermutate.reset();
		char[] a = HelperPermutate.genArray(n);
		HelperPermutate.method = HelperPermutate.BACKTRACKING;
		HelperPermutate.permTester = new PermTester(HelperPermutate.method, n);
		double before = System.currentTimeMillis();
		Permutate.recursive_backtracking(a, a.length - 1, HelperPermutate.doit);
		double after = System.currentTimeMillis();
		System.out.println("\n*** Count of recursive_backtracking swaps = " + HelperPermutate.swaps + " (" + (after - before) + " ms)");
		HelperPermutate.permTester.ensureComplete();
		/*try{
			HelperPermutate.permTester.toCSV("data/csvJava/"+("n_"+n+"m_"+HelperPermutate.method+"_java.csv"));		
		}
		catch(Exception e){}*/
		
	}
	/**
	  * this method test the algorithm recursive heap sedgewick
	  * and the time that cost <br>
	  * the <code>PermTester</code> ensure that the permutation are complete
	  * to storage the data on the .csv file
	  * @param n the size of the permutation, in this case nPn = n! permutations
	  */
	public static void test_recursive_heap_sedgewick(int n){
		System.out.println("\n*** Testing recursive_heap_sedgewick ***");
		HelperPermutate.reset();
		char[] a = HelperPermutate.genArray(n);
		HelperPermutate.method = HelperPermutate.HEAP_SEDGEWICK;
		HelperPermutate.permTester = new PermTester(HelperPermutate.method, n);
		double before = System.currentTimeMillis();
		Permutate.recursive_heap_sedgewick(a, a.length - 1, HelperPermutate.doit);
		double after = System.currentTimeMillis();
		System.out.println("\n*** Count of recursive_heap_sedgewick swaps = " + HelperPermutate.swaps + " (" + (after - before) + " ms)");
		HelperPermutate.permTester.ensureComplete();
		/*try{
			HelperPermutate.permTester.toCSV("data/csvJava/"+("n_"+n+"m_"+HelperPermutate.method+"_java.csv"));	
		}
		catch(Exception e){}*/
	}
	/**
	  * this method test the algorithm lexicographically
	  * and the time that cost <br>
	  * the <code>PermTester</code> ensure that the permutation are complete
	  * to storage the data on the .csv file
	  * @param n the size of the permutation, in this case nPn = n! permutations
	  */
	public static void test_permutate_lexicographically(int n){
		System.out.println("\n*** Testing lexicographically ***");
		HelperPermutate.reset();
		char[] a = HelperPermutate.genArray(n);
		HelperPermutate.method = HelperPermutate.LEXIC;
		HelperPermutate.permTester = new PermTester(HelperPermutate.method, n);
		double before = System.currentTimeMillis();
		Permutate.permutate_lexicographically(a, HelperPermutate.doit);
		double after = System.currentTimeMillis();
		System.out.println("\n*** Count of lexicographically swaps = " + HelperPermutate.swaps + " (" + (after - before) + " ms)");
		HelperPermutate.permTester.ensureComplete();
		/*try{
			HelperPermutate.permTester.toCSV("data/csvJava/"+("n_"+n+"m_"+HelperPermutate.method+"_java.csv"));		
		}
		catch(Exception e){}*/
	}
	/**
	  * this method test the algorithm naive
	  * and the time that cost <br>
	  * the <code>PermTester</code> ensure that the permutation are complete
	  * to storage the data on the .csv file
	  * @param n the size of the permutation, in this case nPn = n! permutations
	  */
	public static void  test_permutate_naive(int n){
		System.out.println("\n*** Testing naive all_permutations ***");
		HelperPermutate.reset();
		char[] a = HelperPermutate.genArray(n);
		HelperPermutate.method = HelperPermutate.NAIVE;
		HelperPermutate.permTester = new PermTester(HelperPermutate.method, n);
		double before = System.currentTimeMillis();
		char[][] perms = Permutate.permutate_naively(a);
		for (int i = 0; i < perms.length; i++){
			HelperPermutate.showPermutation(perms[i]);
    	}
		double after = System.currentTimeMillis();
		System.out.println("\n*** Count of naive all insertions = " + HelperPermutate.insertions + " (" + (after - before) + " ms)");
		HelperPermutate.permTester.ensureComplete();
		/*try{
			HelperPermutate.permTester.toCSV("data/csvJava/"+("n_"+n+"m_"+HelperPermutate.method+"_java.csv"));		
		}
		catch(Exception e){}*/
	}

	public static void test_tree(int n){
		System.out.println("\n*** Testing tree ***");
		HelperPermutate.reset();
		char[] a = HelperPermutate.genArray(n);
		HelperPermutate.method = HelperPermutate.TREE;
		HelperPermutate.permTester = new PermTester(HelperPermutate.method, n);
		double before = System.currentTimeMillis();
		Permutate.tree(a,' ',' ',new char [0],HelperPermutate.doit);
		double after = System.currentTimeMillis();
		System.out.println("\n*** Count of tree swaps = " + HelperPermutate.swaps + " (" + (after - before) + " ms)");
		HelperPermutate.permTester.ensureComplete();
		/*try{
			HelperPermutate.permTester.toCSV("data/csvJava/"+("n_"+n+"m_"+HelperPermutate.method+"_java.csv"));	
		}
		catch(Exception e){}*/
	}
}