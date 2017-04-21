/*
  a6r1an@gmail.com
*/
  package eif203.labs.permutate;
  import eif203.util.*;
//how to write doc coments java8
  public class TestAll{
    public static int n = HelperPermutate.DEFAULT_PERMUT_SIZE;
    public static String metodo = "all";

    public static void test_permutate_all(int n){
      System.out.println("\n\n\n*** Testing all permutation methods with " + n + " objects ***\n");
      
      TestPermutate.test_recursive_backtracking(n);
      TestPermutate.test_recursive_heap_sedgewick(n);
      TestPermutate.test_permutate_lexicographically(n);
      TestPermutate.test_permutate_naive(n);
    }
    
    public static void test_methods(String method)throws Exception{
      switch(method){
        case "backtrack":TestPermutate.test_recursive_backtracking(n);break;
        case "heap_sedgewick":TestPermutate.test_recursive_heap_sedgewick(n);break;
        case "lexicographic": TestPermutate.test_permutate_lexicographically(n);break;
        case "naive":TestPermutate.test_permutate_naive(n);break;
        case "all":test_permutate_all(n);break;
        default:throw new Exception("error con el metodo");
      }
    }
  public static void parseInt(String str)throws Exception{
    try{
      int number = Integer.parseInt(str);
      n = number;
    }catch(Exception e){
      throw new Exception("error con -n NaN "+ e.getMessage());
    }
  }
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


  

  


