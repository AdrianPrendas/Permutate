package eif203.labs.permutate;

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
        if (conjunto.size()==1) {
                    aux++;
            System.out.println(aux+")"+a+conjunto.get(0));
        }
        for (int i=0;i<conjunto.size();i++) {
            Character b = conjunto.remove(i);
            escribe (a+b, conjunto);
            conjunto.add(i,b);
        }
    }
    public static void AyudaPer(){
       
        LinkedList<Character> conjunto =new LinkedList<Character>();
        conjunto.add('1');
        conjunto.add('2');
        conjunto.add('3');
        conjunto.add('4');
        conjunto.add('5');
 
        escribe ("", conjunto);
        System.out.println(aux);
    }
}