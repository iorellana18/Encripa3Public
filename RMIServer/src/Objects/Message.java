/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import java.util.UUID;
import java.io.Serializable;

/**
 *
 * @author Israel Martínez <your.name at your.org>
 */
public class  Message implements Serializable{
    String uniqueMessageId;
    String message;
    String origin;
    String destination;

    public Message(String message, String origin, String destination) {
        this.uniqueMessageId = UUID.randomUUID().toString();
        this.message = message;
        this.origin = origin;
        this.destination = destination;
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
