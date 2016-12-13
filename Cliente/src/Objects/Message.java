/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.UUID;

/**
 *
 * @author Carlos
 */
public class Message  implements Serializable{
    String uniqueMessageId;
    String message;
    String origin;
    String destination;
    int type;
    BigInteger value;

    public Message(String message, String origin, String destination, int type) {
        this.uniqueMessageId = UUID.randomUUID().toString();
        this.message = message;
        this.origin = origin;
        this.destination = destination;
        this.type = type;
    }
    
    public Message(BigInteger value, String origin, String destination, int type) {
        this.uniqueMessageId = UUID.randomUUID().toString();
        this.value = value;
        this.origin = origin;
        this.destination = destination;
        this.type = type;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }
    
    
    public int getType() {
        return type;
    }

    public String getUniqueMessageId() {
        return uniqueMessageId;
    }

    public void setUniqueMessageId(String uniqueId) {
        this.uniqueMessageId = uniqueId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
