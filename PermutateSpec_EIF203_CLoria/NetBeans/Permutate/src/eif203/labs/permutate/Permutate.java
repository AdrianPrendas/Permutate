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

/**
 * Permutations Algorithms
 *
 * @author Carlos Loria Saenz loriacarlos@gmail.com
 * @author Adrian Prendas Araya a6r2an@gmail.com
 * @author Genesis
 * @author Flavio
 * @author Joseph
 */
public class Permutate {

    /**
     * Recursive Backtracking
     *
     * @param a an array of elements to permutate
     * @param i an index for array
     * @param doit a function to do when find a new permutation
     */
    public static void recursive_backtracking(char[] a, int i, Function<char[], Void> doit) {
        Printing.incMargin();
        Printing.printMargin("Enter Round i=" + i + " " + new String(a));
        if (i == 0) {
            doit.apply(a);
            Printing.decMargin();
            return;
        }

        for (int j = 0; j <= i; j++) {
            Printing.printMargin("Enter cycle i=" + i + " j=" + j + " " + new String(a));
            if (i % 2 != 0) {
                HelperPermutate.swap(a, i, j);// se puede quitar // cuando i es impar, rotacion a la derecha
            }
            recursive_backtracking(a, i - 1, doit);
            HelperPermutate.swap(a, i, j);
        }

        Printing.printMargin("Leave Round i=" + i + " " + new String(a));
        Printing.decMargin();
    }

    /**
     * Recursive Heap-Sedgewick
     *
     * @param a an array of elements to permutate
     * @param i an index for array
     * @param doit a function to do when find a new permutation
     */
    public static void recursive_heap_sedgewick(char[] a, int i, Function<char[], Void> doit) {
        Printing.incMargin();
        Printing.printMargin("Enter Round i=" + i + " " + new String(a));
        if (i == 0) {
            doit.apply(a);
            Printing.decMargin();
            return;
        }

        for (int j = 0; j <= i; j++) {
            recursive_heap_sedgewick(a, i - 1, doit);
            Printing.printMargin("return-and-swap: i=" + i + " j=" + j);
            HelperPermutate.swap(a, (i % 2 == 0) ? 0 : j, i);//(i % 2 == 0) ? 0 : j //IDEA DEL PROFE // CAMBIAR Y COMPILAR
        }
        Printing.printMargin("Leave Round i=" + i + " " + new String(a));
        Printing.decMargin();
    }
    ////////////////////////////////////////////////////

    /**
     * this method find a new permutation
     *
     * @param a an array of elements to permutate
     */
    public static void next_lexicographic_permutation(char[] a) {//podria retornar 0 o 1 si hay pico
        int i, k;
        // Find a peak;
        for (i = a.length - 2; i > 0 && a[i] > a[i + 1]; i--);
        if (i < 0) {//-i cuando no hay pico
            return;
        }
        // i >= 0 && a[i] < a[i + 1] > a[i + 2] > ... > a[a.length - 1]
        // Find the least k st. a[k] > a[i]
        for (k = a.length - 1; k >= 0 && a[i] > a[k]; k--);
        HelperPermutate.swap(a, i, k);
        // reverse from i+1 .. a.length - 1
        for (int l = i + 1, r = a.length - 1; l <= r; l++, r--) {
            HelperPermutate.swap(a, l, r);
        }
    }

    /**
     * Lexicographically
     *
     * @param a an array of elements to permutate
     * @param doit a function to do when find a new permutation
     */
    public static void permutate_lexicographically(char[] a, Function<char[], Void> doit) {
        int fact = HelperPermutate.fact(a.length);
        for (int i = 0; i < fact; i++) {//no es necesario el factorial, cuando ya no haya un pico
            Printing.printMargin("Round i=" + i + " " + new String(a));
            doit.apply(a);
            next_lexicographic_permutation(a);
        }
    }

    /*
   	  4) Naive //simplon // alguien que le contamos una mentira cualquiera y se la cree
   	  un simplo xD
     */
    /**
     * Naive Demo<br>
     * Very expensive recursive permutations generation<br>
     * All permutations are first genearted<br>
     *
     * @param p an array of elements to permutate
     * @return array with each of the permutation
     */
    public static char[][] permutate_naively(char[] p) {
        if (p.length == 0) {
            return new char[0][0];
        }
        if (p.length == 1) {
            char[][] arr = new char[1][1];
            arr[0] = p;
            return arr;
        }
        char first = p[0];
        char[][] withoutFirst = permutate_naively(Arrays.copyOfRange(p, 1, p.length));
        return insertFirstIntoAll(first, withoutFirst);

    }

    /**
     * insert first element in all permutations but in diferents position
     *
     * @param first the first element of the permutate
     * @param withoutFirst array of permutations
     * @return an array with all permutations complete
     */
    public static char[][] insertFirstIntoAll(char first, char[][] withoutFirst) {
        char[][] res = new char[0][0];
        for (int i = 0; i < withoutFirst.length; i++) {
            char[][] allWithFirst = insertFirstIntoOne(first, withoutFirst[i]);
            res = (char[][]) ArrayUtils.addAll(res, allWithFirst);
        }
        return res;

    }

    /**
     * insert first element in to the array in the position <code>i+1</code>
     *
     * @param first the first element of the current array
     * @param p current array of elements without the first element
     * @return array with all permutations with first element in each position
     * of each permutation
     */
    public static char[][] insertFirstIntoOne(char first, char[] p) { // p = [p[0], p[1], ..., p[n]]
        char[][] res = new char[p.length + 1][0];
        int c = 0;
        for (int i = 0; i <= p.length; i++) {
            char[] s = HelperPermutate.insertAt(p, i, first);
            res[c++] = s;
        }
        return res;
    }
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////

    public static void tree(char[] arr, char i, char d, char[] sol, Function<char[], Void> doit) {
        if (sol.length == 0) {//caso inicialz
            tree(Arrays.copyOfRange(arr, 2, arr.length), arr[0], arr[1], arr, doit);
            tree(arr, arr[1], arr[0], arr, doit);
        } else {
            char[] nArr;
            if (i < d) {//izquierda
                if (arr.length == 0) {
                    doit.apply(sol);
                    //System.out.println(Arrays.toString(sol));
                    return;
                }

                nArr = Arrays.copyOf(arr, arr.length + 1);//push
                nArr[nArr.length - 1] = i;//push

                tree(Arrays.copyOfRange(arr, 1, arr.length), d, arr[0], sol, doit);
                tree(Arrays.copyOfRange(nArr, 1, nArr.length), arr[0], d, sol, doit);

            } else {//derecha
                intercambio(i, d, sol);
                if (arr.length == 0) {
                    doit.apply(sol);
                    //System.out.println(Arrays.toString(sol));
                    return;
                }
                nArr = Arrays.copyOf(arr, arr.length + 1);//push
                nArr[nArr.length - 1] = nArr[0];//push
                nArr[0] = i;//push

                tree(Arrays.copyOfRange(arr, 0, arr.length-1), d, arr[arr.length-1], sol, doit);
                tree(nArr, arr[arr.length-1], d, sol, doit);

            }
        }
    }

    public static char[] intercambio(char i, char d, char[] sol) {
        int ii = 0;
        int dd = 0;
        for (int c = 0; c < sol.length; c++) {
            if (i == sol[c]) {
                ii = c;
            }
            if (d == sol[c]) {
                dd = c;
            }
        }
        sol[ii] = d;
        sol[dd] = i;
        return sol;
    }

}
