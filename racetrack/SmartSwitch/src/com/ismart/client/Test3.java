package com.ismart.client;

import java.net.URL;

import com.ismart.entity.CheckInventory;
import com.ismart.entity.SoapMap;
import com.ismart.entity.SoapMapValue;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import com.ismart.entity.*;
import com.ismart.service.OpenAPI;
import com.ismart.service.OpenAPIService;
import com.ismart.service.OpenAPIServiceLocator;

public class Test3 {

	public static void main(String[] args)
	{		  
	  try
	  {		  

//		  System.setProperty("javax.net.ssl.trustStore", "/usr/local/smartswitch/axisclient.jks");
		  System.setProperty("javax.net.ssl.trustStore", "D:/Documents and Settings/martianlo/Desktop/axisclient.jks");
		  
 		  System.setProperty("javax.net.ssl.trustStorePassword","ism4rt!");
	/* 				   
	      Topup msg = new Topup();
		  msg.setPin("142536");
		  msg.setSourceMsisdn("6288210185443");
		  msg.setTerminalID("25001001");
//		  msg.setDestMsisdn("628811000938");
//		  msg.setAmount("6000");		  
//  	  msg.setDestMsisdn("628811586597");
//		  msg.setAmount("7000");		  
		  msg.setDestMsisdn("6288210126849");
		  msg.setAmount("8000");		  
	
		 */
		  CheckInventory msg = new CheckInventory();			  
		  msg.setPin("686168");		  		//142536 //130133	  
		  msg.setSourceMsisdn("6288210185443");			  		  
		  
	/*	  
		  ChangePIN msg = new ChangePIN();
		  msg.setSourceMsisdn("6288210185443");
		  msg.setOldPin("123456");
		  msg.setConfPin("654321");
		  msg.setNewPin("654321");	  
		  
		/* 
		  Last3 msg = new Last3();
		  msg.setPin("123456");
		  msg.setSourceMsisdn("6288210185443");
		  		  
		  /*	   
		  LOPGen msg = new LOPGen();
		  msg.setPin("123456");
		  msg.setSourceMsisdn("6288210185443");
		  msg.setActualPaid("100001");
		  msg.setGiroRefNumber("I-Smarttest");
		  msg.setTransferDate("19042010");
		  /*			 
		   
		  ResetPIN msg = new ResetPIN();			  
		  msg.setSourceMsisdn("6288210185443");
		  msg.setConfPin("123456");
		  msg.setNewPin("123456");
		  msg.setSecretAnswer("17081945");
		  
		  /*
		  LOPDetails msg = new LOPDetails();
		  msg.setSourceMsisdn("6288210185443");
		  msg.setLopID("322786991796");
		  msg.setPin("123456");
		  */
 		 /*
 		  TrxInq msg= new TrxInq();
 		  msg.setSourceMsisdn("6288210185443");
 		  msg.setPin("123456");
 		  msg.setTransactionID("1002833");
 		 */
		  OpenAPIServiceLocator service = new OpenAPIServiceLocator();
		  OpenAPI port = service.getOpenAPI();					  
		  
		  System.out.println(new Date());

		  System.out.println("compose Request message");
		  
		  SoapMap values = msg.composeMsg();  
		  SoapMap soap = port.invoke(values);		  
		  
		  Hashtable result = null;		  
		  result= msg.composeResponse(soap); 

		  System.out.println("");
		  System.out.println(new Date());
		  System.out.println("compose Response message");
		  System.out.println("response" +result.toString());
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }    
	}
	
}
