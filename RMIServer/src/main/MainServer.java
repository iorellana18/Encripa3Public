/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import Server.ServerImplements;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Israel Martínez <your.name at your.org>
 */
public class MainServer {
    public static void main(String args[]){
        try{
            Registry myRegistry = LocateRegistry.createRegistry(1234);
            myRegistry.rebind("localhost//Mathematics", new ServerImplements());
            System.out.println("Server ON");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
