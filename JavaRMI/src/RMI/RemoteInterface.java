/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RMI;

import java.rmi.Remote;

/**
 *
 * @author Israel Martínez <your.name at your.org>
 */
public interface RemoteInterface extends Remote{
    public double sum(double x, double y) throws Exception;
    public double subtraction(double x, double y) throws Exception;
    public double multiplication(double x, double y) throws Exception;
    public double division(double x, double y) throws Exception;
}
