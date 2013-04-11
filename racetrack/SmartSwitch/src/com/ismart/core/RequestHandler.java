package com.ismart.core;

import java.util.Hashtable;
import java.util.Date;
import com.ismart.service.OpenAPI;
import com.ismart.service.OpenAPIServiceLocator;
import com.ismart.util.*;
import org.apache.log4j.Logger;

import com.ismart.entity.SoapMap;
import com.ismart.entity.Topup;
import javax.net.ssl.*;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class RequestHandler {

	private static Logger log = LoggerFactory.getLogger(RequestHandler.class);
	
	public Hashtable topupRequest(Hashtable struct, Integer stan, Integer groupID)
	{
		Hashtable result = null;
		
		log.info("Params ::" + struct.toString());
		
		String amount  = struct.get("Amount").toString();
		String destination = struct.get("PhoneNumber").toString();
		String terminalID = struct.get("MSISDN").toString();		
		String sourceMsisdn = struct.get("UserID").toString();
		String pin = struct.get("PIN").toString();
		
		if(destination.startsWith("0"))
		{
			destination = "62" + destination.substring(1);
		}
		
		try
		{		
			System.setProperty("javax.net.ssl.trustStore", "/usr/local/smartswitch/axisclient.jks");
			System.setProperty("javax.net.ssl.trustStorePassword","ism4rt!");
			//accept();
			Topup topupMsg = new Topup();
			topupMsg.setDestMsisdn(destination);
			topupMsg.setTerminalID(terminalID);
			topupMsg.setAmount(amount);
			topupMsg.setSourceMsisdn(sourceMsisdn);
			topupMsg.setPin(pin);
			
			SoapMap params = topupMsg.composeMsg();
			
			OpenAPIServiceLocator service = new OpenAPIServiceLocator();
			OpenAPI port = service.getOpenAPI();			
			SoapMap soap = port.invoke(params);
			
			result =  topupMsg.composeResponse(soap);
			
			result.put("ReceivedDate", new Date());
			result.put("TransactionID", Integer.toString(stan));
			result.put("Destination", destination);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		log.info("Response : " + result.toString());
		
		return result;
	}

	public Hashtable checkInventoryRequest(Hashtable struct, Integer stan, Integer groupID)
	{
		Hashtable result = null;
		
		log.info("Params ::" + struct.toString());
		
		String amount  = struct.get("Amount").toString();
		String destination = struct.get("PhoneNumber").toString();
		String terminalID = struct.get("MSISDN").toString();		
		String sourceMsisdn = struct.get("UserID").toString();
		String pin = struct.get("PIN").toString();
		
		if(destination.startsWith("0"))
		{
			destination = "62" + destination.substring(1);
		}
		
		try
		{	
			System.setProperty("javax.net.ssl.trustStore", "/usr/local/smartswitch/axisclient.jks");
			System.setProperty("javax.net.ssl.trustStorePassword","ism4rt!");
			//accept();
			Topup topupMsg = new Topup();
			topupMsg.setDestMsisdn(destination);
			topupMsg.setTerminalID(terminalID);
			topupMsg.setAmount(amount);
			topupMsg.setSourceMsisdn(sourceMsisdn);
			topupMsg.setPin(pin);
			
			SoapMap params = topupMsg.composeMsg();
			
			OpenAPIServiceLocator service = new OpenAPIServiceLocator();
			OpenAPI port = service.getOpenAPI();			
			SoapMap soap = port.invoke(params);
			
			result =  topupMsg.composeResponse(soap);
			
			result.put("ReceivedDate", new Date());
			result.put("TransactionID", Integer.toString(stan));
			result.put("Destination", destination);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		log.info("Response : " + result.toString());
		
		return result;
	}	
	
	public void accept()
	{
		 // Create a trust manager that does not validate certificate chains
	    TrustManager[] trustAllCerts = new TrustManager[] {
	        new X509TrustManager() {
	            public X509Certificate[] getAcceptedIssuers() {
	                return null;
	            }
	 
	            public void checkClientTrusted(X509Certificate[] certs, String authType) {
	                // Trust always
	            }
	 
	            public void checkServerTrusted(X509Certificate[] certs, String authType) {
	                // Trust always
	            }
	        }
	    };
	 
	    try {
			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			// Create empty HostnameVerifier
			HostnameVerifier hv = new HostnameVerifier() {
			            public boolean verify(String arg0, SSLSession arg1) {
			                    return true;
			            }
			};

			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(hv);
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
