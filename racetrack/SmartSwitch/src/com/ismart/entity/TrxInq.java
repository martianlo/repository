package com.ismart.entity;

import java.util.Hashtable;

public class TrxInq {

	public String serviceName;
	public String sourceMsisdn;
	public String pin;
	public String transactionID;
	
	public TrxInq()
	{
		serviceName = "09";
		sourceMsisdn = "";
		pin = "";
		transactionID = "";
	}
	
	public String getTransactionID() {
		return transactionID;
	}


	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}


	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getSourceMsisdn() {
		return sourceMsisdn;
	}

	public void setSourceMsisdn(String sourceMsisdn) {
		this.sourceMsisdn = sourceMsisdn;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public SoapMap composeMsg()
	{
		SoapMap values = new SoapMap();
		SoapMapValue[] val = new SoapMapValue[4];

		val[0] = new SoapMapValue();
		val[0].setName("serviceName");
		val[0].setSingleValue(serviceName);

		val[1] = new SoapMapValue();
		val[1].setName("transactionID");
		val[1].setSingleValue(transactionID);
		
		val[2] = new SoapMapValue();
		val[2].setName("sourceMsisdn");
		val[2].setSingleValue(sourceMsisdn);

		val[3] = new SoapMapValue();
		val[3].setName("pin");
		val[3].setSingleValue(pin);
			
		values.setValues(val);
		  
		System.out.println("request"+"{serviceName="+val[0].getSingleValue() + 
				", transactionID="+val[1].getSingleValue() + ", sourceMsisdn=" + val[2].getSingleValue() +
				", pin="+val[3].getSingleValue() + 
				"}");
		
		return values;
	}
	
	public Hashtable composeResponse(SoapMap map)
	{
		Hashtable result = new Hashtable();

		SoapMapValue[] retval = map.getValues();
		
		String serialNo = "";
		String transactionStatus = "";
		String returnCode = "1";
		String errorDescription = "";
		String errorCode = "";
		String lopId="";
		String transactionID1="";
		String activity="";
		String status="";
		String dateTime="";
		String amount="";

		for(int i = 0;i < retval.length;i++)
		{
			String name = retval[i].getName();

			if(name.equals("returnCode"))
			{
				returnCode =  retval[i].getSingleValue();
			}
			if(name.equals("lopID"))
			{
				lopId = retval[i].getSingleValue();
			}
			if(name.equals("errorDescription"))
			{
				errorDescription =  retval[i].getSingleValue();
			}
			if(name.equals("errorCode"))
			{
				errorCode = errorCode + " " + retval[i].getSingleValue();
			}	
			if(name.equals("activity"))
			{
				activity = errorCode + " " + retval[i].getSingleValue();
			}	
			if(name.equals("status"))
			{
				status= errorCode + " " + retval[i].getSingleValue();
			}		
			if(name.equals("dateTime"))
			{
				dateTime = errorCode + " " + retval[i].getSingleValue();
			}		
			if(name.equals("amount"))
			{
				amount = errorCode + " " + retval[i].getSingleValue();
			}			
		}

		result.put("ReturnCode", returnCode);
		result.put("lopId", lopId);		
		result.put("errorCode", errorCode);
		result.put("AdditionalData", errorDescription);
		result.put("transactionID", transactionID1);	
		result.put("activity",activity);	
		result.put("status",status);	
		result.put("dateTime",dateTime);	
		result.put("amount",amount);

		try
		{
			if(Integer.parseInt(returnCode)==0)
			{
				if(Integer.parseInt(transactionStatus)== 1)
				{
					result.put("ResponseCode", "00");
					result.put("TETransactionID", serialNo);
				}
				else if(Integer.parseInt(transactionStatus)== 4)
				{
					result.put("ResponseCode", "61");
					result.put("TETransactionID", serialNo);
				}
				else
				{
					result.put("ResponseCode", "99");
					result.put("TETransactionID", serialNo);
				}
			}
			else
			{
				result.put("ResponseCode", "99");
			}
		}
		catch(Exception e)
		{
			result.put("ResponseCode", "92");
		}

		return result;
	}			
	
	
}
