//how to write doc coments java8
package eif203.labs.permutate;
import eif203.util.*;

/**
  * Main class to establish which permutation algorithm is going to be tested
  * @author Carlos Loria Saenz loriacarlos@gmail.com
  * @author Adrian Prendas Araya a6r2an@gmail.com
  * @author Genesis
  * @author Flavio
  * @author Joseph
  */
public class TestAll{
  public static int n = HelperPermutate.DEFAULT_PERMUT_SIZE;
  public static String metodo = "all";

  /**
    * to execute all test for permutation <br>
    * @param n to calculate nPr = n!/(n-r)! permutations <br>
    * in this case nPn = n! permutations for each algorithm <br>
    * recursive backtracking <br>
    * recursive heap sedgewick <br>
    * lexicographically <br>
    * naive <br>
    */
  public static void test_permutate_all(int n){
    System.out.println("\n\n\n*** Testing all permutation methods with " + n + " objects ***\n");

    TestPermutate.test_recursive_backtracking(n);
    TestPermutate.test_recursive_heap_sedgewick(n);
    TestPermutate.test_permutate_lexicographically(n);
    TestPermutate.test_permutate_naive(n);
    TestPermutate.test_linkedlist(n);
  }

  /**
    * to choose a method <br>
    * @param method stablish a algorithm to test <br>
    * we can choose: <br>
    * backtrack <br>
    * heap_sedgewick <br>
    * lexicographically <br>
    * naive <br>
    * all <br>
    * @throws Exception if the method does't exist <br>
    */
  public static void test_methods(String method)throws Exception{
    switch(method){
      case "backtrack":TestPermutate.test_recursive_backtracking(n);break;
      case "heap_sedgewick":TestPermutate.test_recursive_heap_sedgewick(n);break;
      case "lexicographic": TestPermutate.test_permutate_lexicographically(n);break;
      case "naive":TestPermutate.test_permutate_naive(n);break;
      case "linkedlist":TestPermutate.test_linkedlist(n);break;
      case "all":test_permutate_all(n);break;
      default:throw new Exception("error con el metodo");
     }
  }
  
  /**
   * Method to parse a <code>String</code> to <code>int</code> <br>
   * @param str String to be parse                             <br>
   * @throws Exception if a <code>String</code> is not Integer <br>
   * if is a number <code>n</code> is set with this value      <br>
   */
  public static void parseInt(String str)throws Exception{
    try{
      int number = Integer.parseInt(str);
      n = number;
    }catch(Exception e){
      throw new Exception("error con -n NaN "+ e.getMessage());
    }
  }

  /**
    * A simple guide to use the program <br>
    * like a program of SO <br>
    */
  public static void help(){
    System.out.println("arguments: [-n] [-v] [-m] [--help]\n");
    System.out.println("opciones:");
    System.out.println("-n \t numero para las permutaciones, entre 2 y 18");
    System.out.println("   \t preferiblemente entre 2 y 8, default=8\n");
    System.out.println("-v \t verbose specifica true, sin este param default=false\n");
    System.out.println("-m \t especifica el algoritmo para las permutaciones");
    System.out.println("   \t [backtrack,heap_sedgewick,lexicographic,naive] defaul=all");
    System.out.println("\nNota: \t nPn = n! permutaciones");
    System.out.println("  \t nPr = n!/(n-r)! /*formula*/ \n\n");
  }

  /**
    * @param arguments in thread main to execute the program
    */
  public static void main(String[] arguments){
    if(arguments.length==0){
      help();
      for(int i=10;i>=0;i--){
      Delayer.delayOpers(100);//seg 
      System.out.println("\t"+i+ "\tto start");
    }
    test_permutate_all(n);
  }else{
    try{
      for(int a=0;a<arguments.length;a++){
        String argumento = arguments[a];
        switch(argumento){
          case "-n": parseInt(arguments[a+1]);break;
          case "-v": Printing.verbose = true;break;
          case "-m": metodo = arguments[a+1];break;
          case "--help":help();return;
        }
      }
      test_methods(metodo);
    }catch(Exception e){System.out.println(e.getMessage());}
  }

}
}







