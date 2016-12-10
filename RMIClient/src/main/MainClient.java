/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import RMI.RemoteInterface;
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
            String origin = JOptionPane.showInputDialog("Ingrese Nombre de origen");
            String destination = JOptionPane.showInputDialog("Ingrese Nombre de destino");
            String message = JOptionPane.showInputDialog("Ingrese Mensaje");
            
            Registry myRegistry = LocateRegistry.getRegistry("localhost",1234);
            RemoteInterface ri = (RemoteInterface) myRegistry.lookup("localhost//Messages");
            ri.sendMessage(message, origin, destination);
            int seeMsg = JOptionPane.showConfirmDialog(null, origin+"¿Desea ver mensajes de entrada?");
            if (seeMsg == JOptionPane.OK_OPTION){
               String msgOrigin = ri.getMessageByDestination(origin).getOrigin();
               String msgDestination = ri.getMessageByDestination(origin).getDestination();
               String msg = ri.getMessageByDestination(origin).getMessage();
                JOptionPane.showMessageDialog(null, "El mensaje de " + msgOrigin + " hacia " + msgDestination + "es: \n" + msg);
            }
                    
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
    }
    
}
