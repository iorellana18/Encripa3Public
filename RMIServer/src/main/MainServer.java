/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import GraphicInterface.UserInterfaceRMIServer;
import Server.ServerImplements;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Israel Martínez <your.name at your.org>
 */
public class MainServer {
    public static void main(String args[]){
        UserInterfaceRMIServer server = new UserInterfaceRMIServer();
        server.setVisible(true);
    }
    
}
