/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import RMI.RemoteInterface;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Israel Martínez <your.name at your.org>
 */
public class ServerImplements extends UnicastRemoteObject implements RemoteInterface{
    public ServerImplements()throws Exception{
        super();
    }
    
    @Override
    public double sum(double x, double y){
        return (x + y);
    }
    @Override
    public double subtraction(double x, double y){
        return (x - y);
    }
    @Override
    public double multiplication(double x, double y){
        return (x * y);
    }
    @Override
    public double division(double x, double y){
        return (x / y);
    }
}
