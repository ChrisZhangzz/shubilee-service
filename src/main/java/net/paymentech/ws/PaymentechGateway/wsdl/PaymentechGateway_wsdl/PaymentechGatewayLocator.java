/**
 * PaymentechGatewayLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl;

public class PaymentechGatewayLocator extends org.apache.axis.client.Service implements net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGateway {

/**
 * gSOAP 2.6.2 generated service definition
 */

    public PaymentechGatewayLocator() {
    }


    public PaymentechGatewayLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PaymentechGatewayLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PaymentechGateway
    private java.lang.String PaymentechGateway_address = "https://wsvar.paymentech.net/PaymentechGateway";

    public java.lang.String getPaymentechGatewayAddress() {
        return PaymentechGateway_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PaymentechGatewayWSDDServiceName = "PaymentechGateway";

    public java.lang.String getPaymentechGatewayWSDDServiceName() {
        return PaymentechGatewayWSDDServiceName;
    }

    public void setPaymentechGatewayWSDDServiceName(java.lang.String name) {
        PaymentechGatewayWSDDServiceName = name;
    }

    public net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayPortType getPaymentechGateway() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PaymentechGateway_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPaymentechGateway(endpoint);
    }

    public net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayPortType getPaymentechGateway(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayStub _stub = new net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayStub(portAddress, this);
            _stub.setPortName(getPaymentechGatewayWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPaymentechGatewayEndpointAddress(java.lang.String address) {
        PaymentechGateway_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayStub _stub = new net.paymentech.ws.PaymentechGateway.wsdl.PaymentechGateway_wsdl.PaymentechGatewayStub(new java.net.URL(PaymentechGateway_address), this);
                _stub.setPortName(getPaymentechGatewayWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PaymentechGateway".equals(inputPortName)) {
            return getPaymentechGateway();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://ws.paymentech.net/PaymentechGateway/wsdl/PaymentechGateway.wsdl", "PaymentechGateway");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://ws.paymentech.net/PaymentechGateway/wsdl/PaymentechGateway.wsdl", "PaymentechGateway"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PaymentechGateway".equals(portName)) {
            setPaymentechGatewayEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
