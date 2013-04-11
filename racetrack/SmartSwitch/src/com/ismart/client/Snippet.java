package com.ismart.client;

import com.ismart.entity.SoapMap;
import com.ismart.entity.SoapMapValue;
import java.util.Date;
import com.ismart.entity.*;
import com.ismart.service.*;

public class Snippet {

	  public static void main(String[] args) {
		  try
		  {
			  
			  OpenAPIService service = new OpenAPIServiceLocator();
			  
			  OpenAPI port = service.getOpenAPI();
			/**  
			  Topup msg = new Topup();
			  msg.setPin("209881");
			  msg.setSourceMsisdn("628818076860");
			  msg.setDestMsisdn("628811586625");
			  msg.setTerminalID("25002002");
			  msg.setAmount("5000");
			  **/
			  
			  CheckInventory msg = new CheckInventory();
			  msg.setPin("123456");
			  msg.setSourceMsisdn("628818076860");
			  
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
