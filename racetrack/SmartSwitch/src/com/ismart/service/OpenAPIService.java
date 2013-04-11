/**
 * OpenAPIService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ismart.service;

public interface OpenAPIService extends javax.xml.rpc.Service {
    public java.lang.String getOpenAPIAddress();

    public OpenAPI getOpenAPI() throws javax.xml.rpc.ServiceException;

    public OpenAPI getOpenAPI(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}