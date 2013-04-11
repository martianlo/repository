package com.ismart.client;

import com.ismart.core.RequestHandler;
import com.ismart.entity.SoapMap;
import com.ismart.entity.SoapMapValue;
import java.util.Date;

import org.apache.log4j.Logger;

import com.ismart.entity.*;
import com.ismart.service.OpenAPI;
import com.ismart.service.OpenAPIService;
import com.ismart.service.OpenAPIServiceLocator;
import com.ismart.util.LoggerFactory;



public class Test {

	  private static Logger log = LoggerFactory.getLogger(RequestHandler.class);
	  
	  public static void main(String[] args) {
		  try
		  {			  
			  System.setProperty("javax.net.ssl.trustStore", "/usr/local/smartswitch/axisclient.jks");
     		  System.setProperty("javax.net.ssl.trustStorePassword","ism4rt!");
		  		
			  OpenAPIService service = new OpenAPIServiceLocator();			  
			  OpenAPI port = service.getOpenAPI();	
     		  
			/*  
			  Topup msg = new Topup();
			  msg.setPin("637822");
			  msg.setSourceMsisdn("628818076860");
			  msg.setDestMsisdn("628811586745");
			  msg.setTerminalID("25001001");
			  msg.setAmount("6300");
			  
			 */ 
			  CheckInventory msg = new CheckInventory();			  
			  msg.setPin("123456");
			  msg.setSourceMsisdn("6288210185443");			  		  
			  
			  /*
			  ChangePIN msg = new ChangePIN();
			  msg.setSourceMsisdn("628818076860");
			  msg.setOldPin("209881");
			  msg.setConfPin("123456");
			  msg.setNewPin("123456");	  
			  
			  
			  Last3 msg = new Last3();
			  msg.setPin("209881");
			  msg.setSourceMsisdn("628818076860");
			  
			  
			  /*
			  LOPGen msg = new LOPGen();
			  msg.setPin("209881");
			  msg.setSourceMsisdn("628818076860");
			  msg.setActualPaid("50000");
			  msg.setGiroRefNumber("1234");
			  msg.setTransferDate("20081210");
			  /*			  
			  
			  ResetPIN msg = new ResetPIN();			  
			  msg.setSourceMsisdn("628818076860");
			  msg.setConfPin("209881");
			  msg.setNewPin("209881");
			  msg.setSecretAnswer("17081945");
			  
			  /*
			  LOPDetails msg = new LOPDetails();
			  msg.setSourceMsisdn("628818076860");
			  msg.setLopID("322786991796");
			  msg.setPin("209881");
			  */
		  				  		
			  System.out.println(new Date());
			  SoapMap values = msg.composeMsg();		  					  
			  port.invoke(values);	  
			  System.out.println(new Date());
			  
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }    
		  
		  
	  }	
}
