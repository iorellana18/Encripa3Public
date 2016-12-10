package Cifrado;

import java.io.Serializable;
import java.util.Vector;

public class CifradoDescifrado
  implements Serializable
{
  private Vector texto;
  private Vector plano;
  private Vector l0;
  private Vector r0;
  private Vector textoCifrado;
  private String textoCifradoFinal = "";
  private String textoCifradoHexadecimal = "";
  private Vector subClaves;
  private int[][] sCaja1 = { { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 }, { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 }, { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 }, { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 } };
  private int[][] sCaja2 = { { 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 }, { 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 }, { 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 }, { 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 } };
  private int[][] sCaja3 = { { 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 }, { 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 }, { 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 }, { 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } };
  private int[][] sCaja4 = { { 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 }, { 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 }, { 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 }, { 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } };
  private int[][] sCaja5 = { { 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 }, { 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 }, { 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 }, { 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } };
  private int[][] sCaja6 = { { 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 }, { 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 }, { 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 }, { 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 } };
  private int[][] sCaja7 = { { 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 }, { 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 }, { 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 }, { 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } };
  private int[][] sCaja8 = { { 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 }, { 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 }, { 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 }, { 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 } };
  private int[][] hexadecimalABinario = { { 0, 0, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 1, 1 }, { 0, 1, 0, 0 }, { 0, 1, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 0, 1, 0 }, { 1, 0, 1, 1 }, { 1, 1, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 1, 0 }, { 1, 1, 1, 1 } };
  private String resumenCifradoDescifrado;
  private int numeroPermutacion = 0;
  
  public String getResumenCifradoDescifrado()
  {
    return this.resumenCifradoDescifrado;
  }
  
  public void setSubClaves(Vector subClaves)
  {
    this.subClaves = subClaves;
  }
  
  public String getTextoCifradoFinal()
  {
    return this.textoCifradoFinal;
  }
  
  public void ejecutarCifrado(String textoPlano, String iv)
  {
    this.textoCifrado = new Vector();
    
    this.resumenCifradoDescifrado = "****************************************************Generaci�n de Algoritmo Cifrado****************************************************\n\n";
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "El Vector Inicial es: " + iv + "\n");
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "El texto es: " + textoPlano + "\n\n");
    
    this.texto = new Vector();
    int particiones;
    if (textoPlano.length() % 8 == 0) {
      particiones = textoPlano.length() / 8;
    } else {
      particiones = textoPlano.length() / 8 + 1;
    }
    for (int contador = 0; contador < particiones; contador++)
    {
      this.numeroPermutacion = 0;
      this.plano = new Vector();
      for (int contador2 = 0; contador2 < 8; contador2++)
      {
        if (contador == 0) {
          transformarTextoABinario(iv.charAt(contador2));
        }
        if (contador * 8 + contador2 < textoPlano.length()) {
          planoABinario(textoPlano.charAt(contador * 8 + contador2));
        } else {
          planoABinario(0);
        }
      }
      this.l0 = new Vector();
      this.r0 = new Vector();
      this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "***************Inicio Cifrado Bloque " + (contador + 1) + "***************\n\n");
      realizarIP();
      
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(0));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(1));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(2));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(3));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(4));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(5));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(6));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(7));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(8));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(9));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(10));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(11));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(12));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(13));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(14));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(15));
      this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "***************Termino Cifrado Bloque " + (contador + 1) + "***************\n\n");
      permutacionFinal();
    }
    this.resumenCifradoDescifrado += "***************Texto Cifrado***************\n\n";
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "El texto cifrado expresado en bits es: " + retornarString(this.textoCifrado, 8) + "\n\n");
    for (int contador = 0; contador < this.textoCifrado.size() / 8; contador++)
    {
      int numeroAscii = 0;
      
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 0)).intValue() * 128;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 1)).intValue() * 64;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 2)).intValue() * 32;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 3)).intValue() * 16;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 4)).intValue() * 8;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 5)).intValue() * 4;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 6)).intValue() * 2;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 7)).intValue() * 1;
      
      char letra = (char)numeroAscii;
      
      this.textoCifradoFinal += letra;
    }
    for (int contador = 0; contador < this.textoCifrado.size() / 4; contador++)
    {
      int numeroHexadecimal = 0;
      char letra = ' ';
      
      numeroHexadecimal += ((Integer)this.textoCifrado.get(contador * 4 + 0)).intValue() * 8;
      numeroHexadecimal += ((Integer)this.textoCifrado.get(contador * 4 + 1)).intValue() * 4;
      numeroHexadecimal += ((Integer)this.textoCifrado.get(contador * 4 + 2)).intValue() * 2;
      numeroHexadecimal += ((Integer)this.textoCifrado.get(contador * 4 + 3)).intValue() * 1;
      switch (numeroHexadecimal)
      {
      case 0: 
        letra = '0';
        break;
      case 1: 
        letra = '1';
        break;
      case 2: 
        letra = '2';
        break;
      case 3: 
        letra = '3';
        break;
      case 4: 
        letra = '4';
        break;
      case 5: 
        letra = '5';
        break;
      case 6: 
        letra = '6';
        break;
      case 7: 
        letra = '7';
        break;
      case 8: 
        letra = '8';
        break;
      case 9: 
        letra = '9';
        break;
      case 10: 
        letra = 'A';
        break;
      case 11: 
        letra = 'B';
        break;
      case 12: 
        letra = 'C';
        break;
      case 13: 
        letra = 'D';
        break;
      case 14: 
        letra = 'E';
        break;
      case 15: 
        letra = 'F';
      }
      this.textoCifradoHexadecimal += letra;
    }
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "El texto cifrado es: " + this.textoCifradoFinal + "\n\n");
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "El texto cifrado expresado en hexadecimal es: " + this.textoCifradoHexadecimal + "\n");
  }
  
  public void ejecutarDescifrado(String textoCifrado, String iv)
  {
    this.textoCifrado = new Vector();
    
    this.resumenCifradoDescifrado = "****************************************************Generaci�n de Algoritmo Descifrado****************************************************\n\n";
    
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "El texto cifrado es: " + textoCifrado + "\n\n");
    
    this.numeroPermutacion = 0;
    for (int contador = 0; contador < textoCifrado.length() / 8; contador++)
    {
      this.numeroPermutacion = 0;
      
      this.texto = new Vector();
      this.plano = new Vector();
      for (int contador2 = 0; contador2 < 8; contador2++)
      {
        planoABinario(textoCifrado.charAt(contador * 8 + contador2));
        if (contador == 0) {
          transformarTextoABinario(iv.charAt(contador2));
        } else {
          transformarTextoABinario(textoCifrado.charAt((contador - 1) * 8 + contador2));
        }
      }
      this.l0 = new Vector();
      this.r0 = new Vector();
      this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "***************Inicio Descifrado Bloque " + (contador + 1) + "***************\n\n");
      realizarIP();
      
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(0));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(1));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(2));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(3));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(4));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(5));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(6));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(7));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(8));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(9));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(10));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(11));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(12));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(13));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(14));
      this.numeroPermutacion += 1;
      aplicarSubclave((Vector)this.subClaves.get(15));
      this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "***************Termino Descifrado Bloque " + (contador + 1) + "***************\n\n");
      permutacionFinal();
    }
    this.resumenCifradoDescifrado += "***************Texto Descifrado***************\n\n";
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "El texto descifrado expresado en bits es: " + retornarString(this.textoCifrado, 8) + "\n\n");
    for (int contador = 0; contador < this.textoCifrado.size() / 8; contador++)
    {
      int numeroAscii = 0;
      
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 0)).intValue() * 128;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 1)).intValue() * 64;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 2)).intValue() * 32;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 3)).intValue() * 16;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 4)).intValue() * 8;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 5)).intValue() * 4;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 6)).intValue() * 2;
      numeroAscii += ((Integer)this.textoCifrado.get(contador * 8 + 7)).intValue() * 1;
      
      char letra = (char)numeroAscii;
      
      this.textoCifradoFinal += letra;
    }
    for (int contador = 0; contador < this.textoCifrado.size() / 4; contador++)
    {
      int numeroHexadecimal = 0;
      char letra = ' ';
      
      numeroHexadecimal += ((Integer)this.textoCifrado.get(contador * 4 + 0)).intValue() * 8;
      numeroHexadecimal += ((Integer)this.textoCifrado.get(contador * 4 + 1)).intValue() * 4;
      numeroHexadecimal += ((Integer)this.textoCifrado.get(contador * 4 + 2)).intValue() * 2;
      numeroHexadecimal += ((Integer)this.textoCifrado.get(contador * 4 + 3)).intValue() * 1;
      
      this.textoCifradoHexadecimal += letra;
    }
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "El texto descifrado es: " + this.textoCifradoFinal + "\n\n");
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "El texto descifrado expresado en hexadecimal es: " + this.textoCifradoHexadecimal + "\n");
  }
  
  public Vector funcionXOR()
  {
    Vector temporal = new Vector();
    for (int i = 0; i < this.plano.size(); i++) {
      temporal.add(Integer.valueOf(((Integer)this.plano.get(i)).intValue() ^ ((Integer)this.texto.get(i)).intValue()));
    }
    return temporal;
  }
  
  public void realizarIP()
  {
    this.l0.add((Integer)this.texto.get(57));
    this.l0.add((Integer)this.texto.get(49));
    this.l0.add((Integer)this.texto.get(41));
    this.l0.add((Integer)this.texto.get(33));
    this.l0.add((Integer)this.texto.get(25));
    this.l0.add((Integer)this.texto.get(17));
    this.l0.add((Integer)this.texto.get(9));
    this.l0.add((Integer)this.texto.get(1));
    this.l0.add((Integer)this.texto.get(59));
    this.l0.add((Integer)this.texto.get(51));
    this.l0.add((Integer)this.texto.get(43));
    this.l0.add((Integer)this.texto.get(35));
    this.l0.add((Integer)this.texto.get(27));
    this.l0.add((Integer)this.texto.get(19));
    this.l0.add((Integer)this.texto.get(11));
    this.l0.add((Integer)this.texto.get(3));
    this.l0.add((Integer)this.texto.get(61));
    this.l0.add((Integer)this.texto.get(53));
    this.l0.add((Integer)this.texto.get(45));
    this.l0.add((Integer)this.texto.get(37));
    this.l0.add((Integer)this.texto.get(29));
    this.l0.add((Integer)this.texto.get(21));
    this.l0.add((Integer)this.texto.get(13));
    this.l0.add((Integer)this.texto.get(5));
    this.l0.add((Integer)this.texto.get(63));
    this.l0.add((Integer)this.texto.get(55));
    this.l0.add((Integer)this.texto.get(47));
    this.l0.add((Integer)this.texto.get(39));
    this.l0.add((Integer)this.texto.get(31));
    this.l0.add((Integer)this.texto.get(23));
    this.l0.add((Integer)this.texto.get(15));
    this.l0.add((Integer)this.texto.get(7));
    
    this.r0.add((Integer)this.texto.get(56));
    this.r0.add((Integer)this.texto.get(48));
    this.r0.add((Integer)this.texto.get(40));
    this.r0.add((Integer)this.texto.get(32));
    this.r0.add((Integer)this.texto.get(24));
    this.r0.add((Integer)this.texto.get(16));
    this.r0.add((Integer)this.texto.get(8));
    this.r0.add((Integer)this.texto.get(0));
    this.r0.add((Integer)this.texto.get(58));
    this.r0.add((Integer)this.texto.get(50));
    this.r0.add((Integer)this.texto.get(42));
    this.r0.add((Integer)this.texto.get(34));
    this.r0.add((Integer)this.texto.get(26));
    this.r0.add((Integer)this.texto.get(18));
    this.r0.add((Integer)this.texto.get(10));
    this.r0.add((Integer)this.texto.get(2));
    this.r0.add((Integer)this.texto.get(60));
    this.r0.add((Integer)this.texto.get(52));
    this.r0.add((Integer)this.texto.get(44));
    this.r0.add((Integer)this.texto.get(36));
    this.r0.add((Integer)this.texto.get(28));
    this.r0.add((Integer)this.texto.get(20));
    this.r0.add((Integer)this.texto.get(12));
    this.r0.add((Integer)this.texto.get(4));
    this.r0.add((Integer)this.texto.get(62));
    this.r0.add((Integer)this.texto.get(54));
    this.r0.add((Integer)this.texto.get(46));
    this.r0.add((Integer)this.texto.get(38));
    this.r0.add((Integer)this.texto.get(30));
    this.r0.add((Integer)this.texto.get(22));
    this.r0.add((Integer)this.texto.get(14));
    this.r0.add((Integer)this.texto.get(6));
    
    this.resumenCifradoDescifrado += "***************L0 y R0***************\n\n";
    
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "L(0) es: " + retornarString(this.l0, 8) + "\n");
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "R(0) es: " + retornarString(this.r0, 8) + "\n\n");
  }
  
  public void aplicarSubclave(Vector subClave)
  {
    Vector rExpandida = new Vector();
    Vector xor = new Vector();
    Vector auxiliar = new Vector();
    Vector p = new Vector();
    
    rExpandida.add((Integer)this.r0.get(31));
    rExpandida.add((Integer)this.r0.get(0));
    rExpandida.add((Integer)this.r0.get(1));
    rExpandida.add((Integer)this.r0.get(2));
    rExpandida.add((Integer)this.r0.get(3));
    rExpandida.add((Integer)this.r0.get(4));
    rExpandida.add((Integer)this.r0.get(3));
    rExpandida.add((Integer)this.r0.get(4));
    rExpandida.add((Integer)this.r0.get(5));
    rExpandida.add((Integer)this.r0.get(6));
    rExpandida.add((Integer)this.r0.get(7));
    rExpandida.add((Integer)this.r0.get(8));
    rExpandida.add((Integer)this.r0.get(7));
    rExpandida.add((Integer)this.r0.get(8));
    rExpandida.add((Integer)this.r0.get(9));
    rExpandida.add((Integer)this.r0.get(10));
    rExpandida.add((Integer)this.r0.get(11));
    rExpandida.add((Integer)this.r0.get(12));
    rExpandida.add((Integer)this.r0.get(11));
    rExpandida.add((Integer)this.r0.get(12));
    rExpandida.add((Integer)this.r0.get(13));
    rExpandida.add((Integer)this.r0.get(14));
    rExpandida.add((Integer)this.r0.get(15));
    rExpandida.add((Integer)this.r0.get(16));
    rExpandida.add((Integer)this.r0.get(15));
    rExpandida.add((Integer)this.r0.get(16));
    rExpandida.add((Integer)this.r0.get(17));
    rExpandida.add((Integer)this.r0.get(18));
    rExpandida.add((Integer)this.r0.get(19));
    rExpandida.add((Integer)this.r0.get(20));
    rExpandida.add((Integer)this.r0.get(19));
    rExpandida.add((Integer)this.r0.get(20));
    rExpandida.add((Integer)this.r0.get(21));
    rExpandida.add((Integer)this.r0.get(22));
    rExpandida.add((Integer)this.r0.get(23));
    rExpandida.add((Integer)this.r0.get(24));
    rExpandida.add((Integer)this.r0.get(23));
    rExpandida.add((Integer)this.r0.get(24));
    rExpandida.add((Integer)this.r0.get(25));
    rExpandida.add((Integer)this.r0.get(26));
    rExpandida.add((Integer)this.r0.get(27));
    rExpandida.add((Integer)this.r0.get(28));
    rExpandida.add((Integer)this.r0.get(27));
    rExpandida.add((Integer)this.r0.get(28));
    rExpandida.add((Integer)this.r0.get(29));
    rExpandida.add((Integer)this.r0.get(30));
    rExpandida.add((Integer)this.r0.get(31));
    rExpandida.add((Integer)this.r0.get(0));
    
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "***************Permutaci�n " + this.numeroPermutacion + "***************\n\n");
    
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "R Expandida es: " + retornarString(rExpandida, 6) + "\n");
    for (int contador = 0; contador < 48; contador++) {
      if ((Integer)rExpandida.get(contador) == (Integer)subClave.get(contador)) {
        xor.add(Integer.valueOf(0));
      } else {
        xor.add(Integer.valueOf(1));
      }
    }
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "Xor es: " + retornarString(xor, 6) + "\n");
    for (int contador = 0; contador < 8; contador++)
    {
      int valor = 0;
      
      int m = ((Integer)xor.get(contador * 6)).intValue() * 2 + ((Integer)xor.get(contador * 6 + 5)).intValue();
      
      int n = ((Integer)xor.get(contador * 6 + 1)).intValue() * 8 + ((Integer)xor.get(contador * 6 + 2)).intValue() * 4 + ((Integer)xor.get(contador * 6 + 3)).intValue() * 2 + ((Integer)xor.get(contador * 6 + 4)).intValue() * 1;
      switch (contador)
      {
      case 0: 
        valor = this.sCaja1[m][n];
        break;
      case 1: 
        valor = this.sCaja2[m][n];
        break;
      case 2: 
        valor = this.sCaja3[m][n];
        break;
      case 3: 
        valor = this.sCaja4[m][n];
        break;
      case 4: 
        valor = this.sCaja5[m][n];
        break;
      case 5: 
        valor = this.sCaja6[m][n];
        break;
      case 6: 
        valor = this.sCaja7[m][n];
        break;
      case 7: 
        valor = this.sCaja8[m][n];
      }
      auxiliar.add(Integer.valueOf(valor / 8));
      valor %= 8;
      auxiliar.add(Integer.valueOf(valor / 4));
      valor %= 4;
      auxiliar.add(Integer.valueOf(valor / 2));
      valor %= 2;
      auxiliar.add(Integer.valueOf(valor / 1));
    }
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "La sustituci�n con las S-Cajas qued�: " + retornarString(auxiliar, 4) + "\n");
    
    p.add((Integer)auxiliar.get(15));
    p.add((Integer)auxiliar.get(6));
    p.add((Integer)auxiliar.get(19));
    p.add((Integer)auxiliar.get(20));
    p.add((Integer)auxiliar.get(28));
    p.add((Integer)auxiliar.get(11));
    p.add((Integer)auxiliar.get(27));
    p.add((Integer)auxiliar.get(16));
    p.add((Integer)auxiliar.get(0));
    p.add((Integer)auxiliar.get(14));
    p.add((Integer)auxiliar.get(22));
    p.add((Integer)auxiliar.get(25));
    p.add((Integer)auxiliar.get(4));
    p.add((Integer)auxiliar.get(17));
    p.add((Integer)auxiliar.get(30));
    p.add((Integer)auxiliar.get(9));
    p.add((Integer)auxiliar.get(1));
    p.add((Integer)auxiliar.get(7));
    p.add((Integer)auxiliar.get(23));
    p.add((Integer)auxiliar.get(13));
    p.add((Integer)auxiliar.get(31));
    p.add((Integer)auxiliar.get(26));
    p.add((Integer)auxiliar.get(2));
    p.add((Integer)auxiliar.get(8));
    p.add((Integer)auxiliar.get(18));
    p.add((Integer)auxiliar.get(12));
    p.add((Integer)auxiliar.get(29));
    p.add((Integer)auxiliar.get(5));
    p.add((Integer)auxiliar.get(21));
    p.add((Integer)auxiliar.get(10));
    p.add((Integer)auxiliar.get(3));
    p.add((Integer)auxiliar.get(24));
    
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "La Permutacion P es: " + retornarString(p, 8) + "\n");
    
    auxiliar = new Vector();
    for (int contador = 0; contador < 32; contador++) {
      if ((Integer)this.l0.get(contador) == (Integer)p.get(contador)) {
        auxiliar.add(Integer.valueOf(0));
      } else {
        auxiliar.add(Integer.valueOf(1));
      }
    }
    this.l0 = new Vector();
    for (int contador = 0; contador < 32; contador++) {
      this.l0.add((Integer)this.r0.get(contador));
    }
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "L(" + this.numeroPermutacion + ") es: " + retornarString(this.l0, 8) + "\n");
    
    this.r0 = new Vector();
    for (int contador = 0; contador < 32; contador++) {
      this.r0.add((Integer)auxiliar.get(contador));
    }
    this.resumenCifradoDescifrado = (this.resumenCifradoDescifrado + "R(" + this.numeroPermutacion + ") es: " + retornarString(this.r0, 8) + "\n\n");
  }
  
  public void permutacionFinal()
  {
    Vector auxiliar = new Vector();
    for (int contador = 0; contador < 32; contador++) {
      auxiliar.add((Integer)this.r0.get(contador));
    }
    for (int contador = 0; contador < 32; contador++) {
      auxiliar.add((Integer)this.l0.get(contador));
    }
    int i = 0;
    
    this.texto = new Vector();
    
    int dato = ((Integer)auxiliar.get(39)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(7)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(47)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(15)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(55)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(23)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(63)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(31)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(38)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(6)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(46)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(14)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(54)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(22)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(62)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(30)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(37)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(5)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(45)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(13)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(53)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(21)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(61)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(29)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(36)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(4)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(44)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(12)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(52)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(20)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(60)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(28)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(35)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(3)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(43)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(11)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(51)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(19)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(59)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(27)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(34)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(2)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(42)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(10)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(50)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(18)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(58)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(26)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(33)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(1)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(41)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(9)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(49)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(17)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(57)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(25)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(32)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(0)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(40)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(8)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(48)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(16)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(56)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
    dato = ((Integer)auxiliar.get(24)).intValue() ^ ((Integer)this.plano.get(i++)).intValue();
    this.textoCifrado.add(Integer.valueOf(dato));
    this.texto.add(Integer.valueOf(dato));
  }
  
  public void transformarTextoABinario(int numeroAscii)
  {
    this.texto.add(Integer.valueOf(numeroAscii / 128));
    numeroAscii %= 128;
    this.texto.add(Integer.valueOf(numeroAscii / 64));
    numeroAscii %= 64;
    this.texto.add(Integer.valueOf(numeroAscii / 32));
    numeroAscii %= 32;
    this.texto.add(Integer.valueOf(numeroAscii / 16));
    numeroAscii %= 16;
    this.texto.add(Integer.valueOf(numeroAscii / 8));
    numeroAscii %= 8;
    this.texto.add(Integer.valueOf(numeroAscii / 4));
    numeroAscii %= 4;
    this.texto.add(Integer.valueOf(numeroAscii / 2));
    numeroAscii %= 2;
    this.texto.add(Integer.valueOf(numeroAscii / 1));
    numeroAscii %= 1;
  }
  
  public void planoABinario(int numeroAscii)
  {
    this.plano.add(Integer.valueOf(numeroAscii / 128));
    numeroAscii %= 128;
    this.plano.add(Integer.valueOf(numeroAscii / 64));
    numeroAscii %= 64;
    this.plano.add(Integer.valueOf(numeroAscii / 32));
    numeroAscii %= 32;
    this.plano.add(Integer.valueOf(numeroAscii / 16));
    numeroAscii %= 16;
    this.plano.add(Integer.valueOf(numeroAscii / 8));
    numeroAscii %= 8;
    this.plano.add(Integer.valueOf(numeroAscii / 4));
    numeroAscii %= 4;
    this.plano.add(Integer.valueOf(numeroAscii / 2));
    numeroAscii %= 2;
    this.plano.add(Integer.valueOf(numeroAscii / 1));
    numeroAscii %= 1;
  }
  
  public String retornarString(Vector listaBits, int grupoBits)
  {
    String retorno = "";
    for (int contador = 0; contador < listaBits.size() / grupoBits; contador++)
    {
      for (int contador2 = 0; contador2 < grupoBits; contador2++) {
        retorno = retorno + listaBits.get(contador * grupoBits + contador2);
      }
      retorno = retorno + " ";
    }
    return retorno;
  }
}