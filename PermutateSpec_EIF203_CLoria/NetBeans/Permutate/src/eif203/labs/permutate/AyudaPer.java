package eif203.labs.permutate;

import java.lang.reflect.Array;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Josh
 */
public class AyudaPer {

    static int aux = 0;

    public static void escribe(String a, LinkedList<Character> conjunto) {
        if (conjunto.size() == 1) {
            aux++;
            System.out.println(aux + ")" + a + conjunto.get(0));
        }
        for (int i = 0; i < conjunto.size(); i++) {
            Character b = conjunto.remove(i);
            escribe(a + b, conjunto);
            conjunto.add(i, b);
        }
    }

    public static void escribe2(char[] vec) {

        char[] aux = vec;
        int swp = vec.length - 1;
        int canSwp = -1;
        int aux1 = 0;
        while (aux1 < 120) {
            aux1++;
            System.out.println(aux1 + ")" + new String(vec));
            aux1++;
            System.out.print(aux1 + ")");
            for (int i = vec.length - 1; i >= 0; i--) {
                System.out.print(Array.get(vec, i));
            }
            System.out.println("");
            canSwp++;
            char pos1 = vec[canSwp];
            char pos2 = vec[canSwp + 1];
            vec[canSwp] = pos2;
            vec[canSwp + 1] = pos1;

            if (canSwp == swp - 1) {
                canSwp = 0;
            }
        }

    }

    public static void main(String[] args) {

        LinkedList<Character> conjunto = new LinkedList<Character>();
        conjunto.add('1');
        conjunto.add('2');
        conjunto.add('3');
        conjunto.add('4');
        conjunto.add('5');

        escribe("", conjunto);
        System.out.println(aux);
    }
}
