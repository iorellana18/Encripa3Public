/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Server;

import Objects.Message;
import RMI.RemoteInterface;
import java.math.BigInteger;
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
    public void sendMessage(String message, String origin, String destination, int type){
        messages.add(new Message(message, origin, destination, type));
    }
    
    @Override
    public void sendParameter(BigInteger value, String origin, String destination, int type) throws Exception {
        messages.add(new Message(value, origin, destination, type));
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
    public Message getMessageByDestination(String destination, int type){
        for(Message msg : messages){
            if(destination.compareTo(msg.getDestination()) == 0
                    && msg.getType() == type) return msg;
        }
        return null;
    }
    
    @Override
    public Message getMessageByType(String origin, String destination, int type) throws Exception {
        for(Message msg : messages){
            if(destination.compareTo(msg.getDestination()) == 0 && origin.compareTo(msg.getOrigin()) == 0 && msg.getType() == type) return msg;
        }
        return null;
    }

    @Override
    public void bindMessage(String uniqueid) throws Exception {
        for(Message msg : messages){
            if(msg.getUniqueMessageId().compareTo(uniqueid) == 0){
                msg.setDestination("--");
                msg.setOrigin("--");
            }
        }
    }
     
}
