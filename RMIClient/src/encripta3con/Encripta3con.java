/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encripta3con;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author ian
 */
public class Encripta3con {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        tools t = new tools();
        Acciones actions = new Acciones();
        int a = t.randomPrime();
        int b = t.randomPrime();
        BigInteger p;
        BigInteger g;
        if(a > b){
            p = BigInteger.valueOf(a);
            g = BigInteger.valueOf(b);
        }else{ 
            p  =BigInteger.valueOf(b);
            g = BigInteger.valueOf(a);
        }
        System.out.println("Random P: "+p);
        System.out.println("Random G: "+g);
        a = t.randomClave(0, a);
        b = t.randomClave(0, a);
        
        System.out.println("Random a: "+a);
        System.out.println("Random b: "+b);
        BigInteger R1=g.modPow(BigInteger.valueOf(a), p);
        BigInteger R2=g.modPow(BigInteger.valueOf(b), p);
        System.out.println("B->A: "+R2);
        BigInteger K1 = R2.modPow(BigInteger.valueOf(a), p);
        BigInteger K2 = R1.modPow(BigInteger.valueOf(b), p);
        //Claves para encriptar
        System.out.println(K1+"-"+K2);
        System.out.println("A manda mensaje encriptado a B");
        String encriptado=actions.Encripta("palabra", String.valueOf(K1), 100);
        System.out.println(encriptado);
        String desencriptado = actions.Desencripta(encriptado, String.valueOf(K2));
    }
   
}
