/**
 * OpenAPIServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ismart.service;
import com.ismart.core.ISmartGWConnection;

public class OpenAPIServiceLocator extends org.apache.axis.client.Service implements OpenAPIService {
		
    public OpenAPIServiceLocator() {
    }


    public OpenAPIServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public OpenAPIServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    } 

    											//https://mcomm.smart-telecom.co.id/H2H
    // Use to get a proxy class for OpenAPI		  
    //  private java.lang.String OpenAPI_address = "https://mcomm.smart-telecom.co.id/DEVELOPMENT/H2H";
    //  private java.lang.String OpenAPI_address = "https://mcomm.smart-telecom.co.id/H2H";
     
      private java.lang.String OpenAPI_address = ISmartGWConnection.getAddress();
    
    //private java.lang.String OpenAPI_address = "https://202.70.62.42:443/WinFacadeWeb/services/OpenAPI";
    //private java.lang.String OpenAPI_address = "http://202.70.62.42/WinFacadeWeb/services/OpenAPI";
    //private java.lang.String OpenAPI_address = "http://127.0.0.1:8000/WinFacadeWeb/services/OpenAPI";

    public java.lang.String getOpenAPIAddress() {
        return OpenAPI_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String OpenAPIWSDDServiceName = "OpenAPI";

    public java.lang.String getOpenAPIWSDDServiceName() {
        return OpenAPIWSDDServiceName;
    }

    public void setOpenAPIWSDDServiceName(java.lang.String name) {
        OpenAPIWSDDServiceName = name;
    }

    public OpenAPI getOpenAPI() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(OpenAPI_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getOpenAPI(endpoint);
    }

    public OpenAPI getOpenAPI(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            OpenAPISoapBindingStub _stub = new OpenAPISoapBindingStub(portAddress, this);
            _stub.setPortName(getOpenAPIWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setOpenAPIEndpointAddress(java.lang.String address) {
        OpenAPI_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (OpenAPI.class.isAssignableFrom(serviceEndpointInterface)) {
                OpenAPISoapBindingStub _stub = new OpenAPISoapBindingStub(new java.net.URL(OpenAPI_address), this);
                _stub.setPortName(getOpenAPIWSDDServiceName());
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
        if ("OpenAPI".equals(inputPortName)) {
            return getOpenAPI();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:openApi", "OpenAPIService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:openApi", "OpenAPI"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("OpenAPI".equals(portName)) {
            setOpenAPIEndpointAddress(address);
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