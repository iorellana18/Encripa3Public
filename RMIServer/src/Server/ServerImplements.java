/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import Objects.Message;
import RMI.RemoteInterface;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Israel Martínez <your.name at your.org>
 */
public class ServerImplements extends UnicastRemoteObject implements RemoteInterface{
    List<Message> messages;
    
    public ServerImplements()throws Exception{
        super();
        this.messages = new ArrayList<>();
    }
    @Override
    public void sendMessage(String message, String origin, String destination){
        messages.add(new Message(message, origin, destination));
    }
    @Override 
    public Message getMessageByIndex(int index){
        return messages.get(index);
    }
    @Override
    public Message getMessageByMessageId(String uniqueId){
        for(Message msg : messages){
            if(uniqueId.compareTo(msg.getUniqueMessageId()) == 0) return msg;
        }
        return null;
    }
    @Override 
    public Message getMessageByDestination(String destination){
        for(Message msg : messages){
            if(destination.compareTo(msg.getDestination()) == 0) return msg;
        }
        return null;
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
