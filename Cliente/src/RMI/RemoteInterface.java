/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

/**
 *
 * @author Carlos
 */
import Objects.Message;
import java.math.BigInteger;
import java.rmi.Remote;

public interface RemoteInterface extends Remote{
    public void sendMessage(String message, String origin, String destination, int type) throws Exception;
    public Message getMessageByIndex(int index) throws Exception;
    public Message getMessageByMessageId(String uniqueId) throws Exception;
    public Message getMessageByDestination(String destination, int type) throws Exception;
    public Message getMessageByType(String origin, String destination, int type) throws Exception;
    public void sendParameter(BigInteger value, String origin, String destination, int type) throws Exception;
    public void bindMessage(String uniqueid) throws Exception;
}
