package com.ismart.client;

import java.net.URL;
import java.util.*;
import org.apache.xmlrpc.client.*;

public class Test2 {

	
	public static void main(String[] args) 
	{
		String url = "http://202.169.46.83:8110";
		try
		{
			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			config.setServerURL(new URL(url));
			XmlRpcClient client = new XmlRpcClient();
			client.setConfig(config);		
			
			/*
			    String amount  = struct.get("Amount").toString();
				String destination = struct.get("PhoneNumber").toString();
				String terminalID = struct.get("MSISDN").toString();		
				String sourceMsisdn = struct.get("UserID").toString();
				String pin = struct.get("PIN").toString();
			 */
		
			Hashtable struct = new Hashtable();
			struct.put("Amount","5000");
			struct.put("PhoneNumber","6288210249379");
			struct.put("MSISDN","25001001");
			struct.put("UserID","628818076860");
			struct.put("PIN","123456");
			
			Vector params = new Vector();
			params.add(struct);
			params.add(new Integer(1));
			params.add(new Integer(1861));
			
			HashMap result = (HashMap) client.execute("SmartTelecom.topupRequest", params);
			
			System.out.println("response" +result.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
