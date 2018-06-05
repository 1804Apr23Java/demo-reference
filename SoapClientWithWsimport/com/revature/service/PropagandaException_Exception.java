
package com.revature.service;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "PropagandaException", targetNamespace = "http://service.revature.com/")
public class PropagandaException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private PropagandaException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public PropagandaException_Exception(String message, PropagandaException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public PropagandaException_Exception(String message, PropagandaException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.revature.service.PropagandaException
     */
    public PropagandaException getFaultInfo() {
        return faultInfo;
    }

}
