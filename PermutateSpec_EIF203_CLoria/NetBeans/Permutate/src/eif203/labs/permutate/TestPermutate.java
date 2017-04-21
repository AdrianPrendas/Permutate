/*
  a6r1an@gmail.com
  Testing different algorithms
  One test for each algorithm
*/
package eif203.labs.permutate;

public class TestPermutate{
	
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
}