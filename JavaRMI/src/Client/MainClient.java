/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Client;

import RMI.RemoteInterface;
import Server.ServerImplements;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author Israel Martínez <your.name at your.org>
 */
public class MainClient {
    public static void main(String args[]){
        try{
            String aValue = JOptionPane.showInputDialog("Ingrese primer valor numérico");
            String bValue = JOptionPane.showInputDialog("Ingrese segundo valor numérico");
            double aVal = Double.parseDouble(aValue);
            double bVal = Double.parseDouble(bValue);
            
            Registry myRegistry = LocateRegistry.getRegistry("localhost",1234);
            RemoteInterface ri = (RemoteInterface) myRegistry.lookup("localhost//Mathematics");
            JOptionPane.showMessageDialog(null, "El resultado de la Suma es " + ri.sum(aVal, bVal));
                    
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
    }
    
}
