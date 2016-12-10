package Cifrado;

import java.io.Serializable;
import java.util.Vector;

public class SubClave
  implements Serializable
{
  private Vector subClaveUno;
  private Vector subClaveDos;
  private Vector subClaveTres;
  private Vector subClaveCuatro;
  private Vector subClaveCinco;
  private Vector subClaveSeis;
  private Vector subClaveSiete;
  private Vector subClaveOcho;
  private Vector subClaveNueve;
  private Vector subClaveDiez;
  private Vector subClaveOnce;
  private Vector subClaveDoce;
  private Vector subClaveTrece;
  private Vector subClaveCatorce;
  private Vector subClaveQuince;
  private Vector subClaveDiezySeis;
  private Vector claveAuxiliar;
  private Vector c0;
  private Vector d0;
  private String resumenClave;
  
  public String getResumenClave()
  {
    return this.resumenClave;
  }
  
  public Vector getSubClaveCatorce()
  {
    return this.subClaveCatorce;
  }
  
  public Vector getSubClaveCinco()
  {
    return this.subClaveCinco;
  }
  
  public Vector getSubClaveCuatro()
  {
    return this.subClaveCuatro;
  }
  
  public Vector getSubClaveDiez()
  {
    return this.subClaveDiez;
  }
  
  public Vector getSubClaveDiezySeis()
  {
    return this.subClaveDiezySeis;
  }
  
  public Vector getSubClaveDoce()
  {
    return this.subClaveDoce;
  }
  
  public Vector getSubClaveDos()
  {
    return this.subClaveDos;
  }
  
  public Vector getSubClaveNueve()
  {
    return this.subClaveNueve;
  }
  
  public Vector getSubClaveOcho()
  {
    return this.subClaveOcho;
  }
  
  public Vector getSubClaveOnce()
  {
    return this.subClaveOnce;
  }
  
  public Vector getSubClaveQuince()
  {
    return this.subClaveQuince;
  }
  
  public Vector getSubClaveSeis()
  {
    return this.subClaveSeis;
  }
  
  public Vector getSubClaveSiete()
  {
    return this.subClaveSiete;
  }
  
  public Vector getSubClaveTrece()
  {
    return this.subClaveTrece;
  }
  
  public Vector getSubClaveTres()
  {
    return this.subClaveTres;
  }
  
  public Vector getSubClaveUno()
  {
    return this.subClaveUno;
  }
  
  public void generarSubClaves(String clave)
  {
    this.claveAuxiliar = new Vector();
    for (int contador = 0; contador < 8; contador++)
    {
      int numeroAscii = clave.charAt(contador);
      transformarTextoABinario(numeroAscii);
    }
    this.resumenClave = "****************************************************Generaci�n de SubClaves****************************************************\n\n";
    this.resumenClave = (this.resumenClave + "La clave original es: " + clave + "\n");
    
    this.resumenClave = (this.resumenClave + "La clave original en Bits es: " + retornarString(this.claveAuxiliar, 8) + "\n\n");
    
    this.c0 = new Vector();
    this.d0 = new Vector();
    
    permutacionUno();
    
    this.resumenClave += "***************C(0) y D(0)***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(0) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(0) es: " + retornarString(this.d0, 7) + "\n\n");
    
    rotarUno();
    this.subClaveUno = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�1***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(1) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(1) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Uno es: " + retornarString(this.subClaveUno, 6) + "\n\n");
    
    rotarUno();
    this.subClaveDos = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�2***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(2) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(2) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Dos es: " + retornarString(this.subClaveDos, 6) + "\n\n");
    
    rotarDos();
    this.subClaveTres = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�3***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(3) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(3) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Tres es: " + retornarString(this.subClaveTres, 6) + "\n\n");
    
    rotarDos();
    this.subClaveCuatro = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�4***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(4) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(4) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Cuatro es: " + retornarString(this.subClaveCuatro, 6) + "\n\n");
    
    rotarDos();
    this.subClaveCinco = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�5***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(5) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(5) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Cinco es: " + retornarString(this.subClaveCinco, 6) + "\n\n");
    
    rotarDos();
    this.subClaveSeis = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�6***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(6) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(6) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Seis es: " + retornarString(this.subClaveSeis, 6) + "\n\n");
    
    rotarDos();
    this.subClaveSiete = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�7***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(7) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(7) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Siete es: " + retornarString(this.subClaveSiete, 6) + "\n\n");
    
    rotarDos();
    this.subClaveOcho = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�8***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(8) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(8) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Ocho es: " + retornarString(this.subClaveOcho, 6) + "\n\n");
    
    rotarUno();
    this.subClaveNueve = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�9***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(9) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(9) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Nueve es: " + retornarString(this.subClaveNueve, 6) + "\n\n");
    
    rotarDos();
    this.subClaveDiez = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�10***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(10) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(10) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Diez es: " + retornarString(this.subClaveDiez, 6) + "\n\n");
    
    rotarDos();
    this.subClaveOnce = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�11***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(11) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(11) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Once es: " + retornarString(this.subClaveOnce, 6) + "\n\n");
    
    rotarDos();
    this.subClaveDoce = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�12***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(12) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(12) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Doce es: " + retornarString(this.subClaveDoce, 6) + "\n\n");
    
    rotarDos();
    this.subClaveTrece = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�13***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(13) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(13) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Trece es: " + retornarString(this.subClaveTrece, 6) + "\n\n");
    
    rotarDos();
    this.subClaveCatorce = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�14***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(14) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(14) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Catorce es: " + retornarString(this.subClaveCatorce, 6) + "\n\n");
    
    rotarDos();
    this.subClaveQuince = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�15***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(15) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(15) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Quince es: " + retornarString(this.subClaveQuince, 6) + "\n\n");
    
    rotarUno();
    this.subClaveDiezySeis = obtenerSubclaveKi();
    
    this.resumenClave += "***************Clave N�16***************\n\n";
    
    this.resumenClave = (this.resumenClave + "C(16) es: " + retornarString(this.c0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "D(16) es: " + retornarString(this.d0, 7) + "\n");
    this.resumenClave = (this.resumenClave + "SubClave Diez y Seis es: " + retornarString(this.subClaveDiezySeis, 6) + "\n\n");
  }
  
  public void transformarTextoABinario(int numeroAscii)
  {
    this.claveAuxiliar.add(Integer.valueOf(numeroAscii / 128));
    numeroAscii %= 128;
    this.claveAuxiliar.add(Integer.valueOf(numeroAscii / 64));
    numeroAscii %= 64;
    this.claveAuxiliar.add(Integer.valueOf(numeroAscii / 32));
    numeroAscii %= 32;
    this.claveAuxiliar.add(Integer.valueOf(numeroAscii / 16));
    numeroAscii %= 16;
    this.claveAuxiliar.add(Integer.valueOf(numeroAscii / 8));
    numeroAscii %= 8;
    this.claveAuxiliar.add(Integer.valueOf(numeroAscii / 4));
    numeroAscii %= 4;
    this.claveAuxiliar.add(Integer.valueOf(numeroAscii / 2));
    numeroAscii %= 2;
    this.claveAuxiliar.add(Integer.valueOf(numeroAscii / 1));
    numeroAscii %= 1;
  }
  
  public void permutacionUno()
  {
    this.c0.add((Integer)this.claveAuxiliar.get(56));
    this.c0.add((Integer)this.claveAuxiliar.get(48));
    this.c0.add((Integer)this.claveAuxiliar.get(40));
    this.c0.add((Integer)this.claveAuxiliar.get(32));
    this.c0.add((Integer)this.claveAuxiliar.get(24));
    this.c0.add((Integer)this.claveAuxiliar.get(16));
    this.c0.add((Integer)this.claveAuxiliar.get(8));
    this.c0.add((Integer)this.claveAuxiliar.get(0));
    this.c0.add((Integer)this.claveAuxiliar.get(57));
    this.c0.add((Integer)this.claveAuxiliar.get(49));
    this.c0.add((Integer)this.claveAuxiliar.get(41));
    this.c0.add((Integer)this.claveAuxiliar.get(33));
    this.c0.add((Integer)this.claveAuxiliar.get(25));
    this.c0.add((Integer)this.claveAuxiliar.get(17));
    this.c0.add((Integer)this.claveAuxiliar.get(9));
    this.c0.add((Integer)this.claveAuxiliar.get(1));
    this.c0.add((Integer)this.claveAuxiliar.get(58));
    this.c0.add((Integer)this.claveAuxiliar.get(50));
    this.c0.add((Integer)this.claveAuxiliar.get(42));
    this.c0.add((Integer)this.claveAuxiliar.get(34));
    this.c0.add((Integer)this.claveAuxiliar.get(26));
    this.c0.add((Integer)this.claveAuxiliar.get(18));
    this.c0.add((Integer)this.claveAuxiliar.get(10));
    this.c0.add((Integer)this.claveAuxiliar.get(2));
    this.c0.add((Integer)this.claveAuxiliar.get(59));
    this.c0.add((Integer)this.claveAuxiliar.get(51));
    this.c0.add((Integer)this.claveAuxiliar.get(43));
    this.c0.add((Integer)this.claveAuxiliar.get(35));
    
    this.d0.add((Integer)this.claveAuxiliar.get(62));
    this.d0.add((Integer)this.claveAuxiliar.get(54));
    this.d0.add((Integer)this.claveAuxiliar.get(46));
    this.d0.add((Integer)this.claveAuxiliar.get(38));
    this.d0.add((Integer)this.claveAuxiliar.get(30));
    this.d0.add((Integer)this.claveAuxiliar.get(22));
    this.d0.add((Integer)this.claveAuxiliar.get(14));
    this.d0.add((Integer)this.claveAuxiliar.get(6));
    this.d0.add((Integer)this.claveAuxiliar.get(61));
    this.d0.add((Integer)this.claveAuxiliar.get(53));
    this.d0.add((Integer)this.claveAuxiliar.get(45));
    this.d0.add((Integer)this.claveAuxiliar.get(37));
    this.d0.add((Integer)this.claveAuxiliar.get(29));
    this.d0.add((Integer)this.claveAuxiliar.get(21));
    this.d0.add((Integer)this.claveAuxiliar.get(13));
    this.d0.add((Integer)this.claveAuxiliar.get(5));
    this.d0.add((Integer)this.claveAuxiliar.get(60));
    this.d0.add((Integer)this.claveAuxiliar.get(52));
    this.d0.add((Integer)this.claveAuxiliar.get(44));
    this.d0.add((Integer)this.claveAuxiliar.get(36));
    this.d0.add((Integer)this.claveAuxiliar.get(28));
    this.d0.add((Integer)this.claveAuxiliar.get(20));
    this.d0.add((Integer)this.claveAuxiliar.get(12));
    this.d0.add((Integer)this.claveAuxiliar.get(4));
    this.d0.add((Integer)this.claveAuxiliar.get(27));
    this.d0.add((Integer)this.claveAuxiliar.get(19));
    this.d0.add((Integer)this.claveAuxiliar.get(11));
    this.d0.add((Integer)this.claveAuxiliar.get(3));
  }
  
  public void rotarUno()
  {
    int auxiliarC0 = ((Integer)this.c0.get(0)).intValue();
    int auxiliarD0 = ((Integer)this.d0.get(0)).intValue();
    for (int contador = 0; contador < 27; contador++)
    {
      this.c0.set(contador, (Integer)this.c0.get(contador + 1));
      this.d0.set(contador, (Integer)this.d0.get(contador + 1));
    }
    this.c0.set(27, Integer.valueOf(auxiliarC0));
    this.d0.set(27, Integer.valueOf(auxiliarD0));
  }
  
  public void rotarDos()
  {
    int auxiliarC01 = ((Integer)this.c0.get(0)).intValue();
    int auxiliarD01 = ((Integer)this.d0.get(0)).intValue();
    int auxiliarC02 = ((Integer)this.c0.get(1)).intValue();
    int auxiliarD02 = ((Integer)this.d0.get(1)).intValue();
    for (int contador = 0; contador < 26; contador++)
    {
      this.c0.set(contador, (Integer)this.c0.get(contador + 2));
      this.d0.set(contador, (Integer)this.d0.get(contador + 2));
    }
    this.c0.set(26, Integer.valueOf(auxiliarC01));
    this.d0.set(26, Integer.valueOf(auxiliarD01));
    this.c0.set(27, Integer.valueOf(auxiliarC02));
    this.d0.set(27, Integer.valueOf(auxiliarD02));
  }
  
  public Vector obtenerSubclaveKi()
  {
    Vector subClave = new Vector();
    Vector auxiliar = new Vector();
    for (int contador = 0; contador < 28; contador++) {
      auxiliar.add((Integer)this.c0.get(contador));
    }
    for (int contador = 0; contador < 28; contador++) {
      auxiliar.add((Integer)this.d0.get(contador));
    }
    subClave.add((Integer)auxiliar.get(13));
    subClave.add((Integer)auxiliar.get(16));
    subClave.add((Integer)auxiliar.get(10));
    subClave.add((Integer)auxiliar.get(23));
    subClave.add((Integer)auxiliar.get(0));
    subClave.add((Integer)auxiliar.get(4));
    subClave.add((Integer)auxiliar.get(2));
    subClave.add((Integer)auxiliar.get(27));
    subClave.add((Integer)auxiliar.get(14));
    subClave.add((Integer)auxiliar.get(5));
    subClave.add((Integer)auxiliar.get(20));
    subClave.add((Integer)auxiliar.get(9));
    subClave.add((Integer)auxiliar.get(22));
    subClave.add((Integer)auxiliar.get(18));
    subClave.add((Integer)auxiliar.get(11));
    subClave.add((Integer)auxiliar.get(3));
    subClave.add((Integer)auxiliar.get(25));
    subClave.add((Integer)auxiliar.get(7));
    subClave.add((Integer)auxiliar.get(15));
    subClave.add((Integer)auxiliar.get(6));
    subClave.add((Integer)auxiliar.get(26));
    subClave.add((Integer)auxiliar.get(19));
    subClave.add((Integer)auxiliar.get(12));
    subClave.add((Integer)auxiliar.get(1));
    subClave.add((Integer)auxiliar.get(40));
    subClave.add((Integer)auxiliar.get(51));
    subClave.add((Integer)auxiliar.get(30));
    subClave.add((Integer)auxiliar.get(36));
    subClave.add((Integer)auxiliar.get(46));
    subClave.add((Integer)auxiliar.get(54));
    subClave.add((Integer)auxiliar.get(29));
    subClave.add((Integer)auxiliar.get(39));
    subClave.add((Integer)auxiliar.get(50));
    subClave.add((Integer)auxiliar.get(44));
    subClave.add((Integer)auxiliar.get(32));
    subClave.add((Integer)auxiliar.get(47));
    subClave.add((Integer)auxiliar.get(43));
    subClave.add((Integer)auxiliar.get(48));
    subClave.add((Integer)auxiliar.get(38));
    subClave.add((Integer)auxiliar.get(55));
    subClave.add((Integer)auxiliar.get(33));
    subClave.add((Integer)auxiliar.get(52));
    subClave.add((Integer)auxiliar.get(45));
    subClave.add((Integer)auxiliar.get(41));
    subClave.add((Integer)auxiliar.get(49));
    subClave.add((Integer)auxiliar.get(35));
    subClave.add((Integer)auxiliar.get(28));
    subClave.add((Integer)auxiliar.get(31));
    
    return subClave;
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