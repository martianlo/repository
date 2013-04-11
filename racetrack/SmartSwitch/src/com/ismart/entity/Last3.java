package com.ismart.entity;

import java.util.Hashtable;

public class Last3 {

	public String serviceName;
	public String sourceMsisdn;
	public String pin;
	
	public Last3()
	{
		serviceName = "05";
		sourceMsisdn = "";
		pin = "";
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
		SoapMapValue[] val = new SoapMapValue[3];	

		val[0] = new SoapMapValue();
		val[0].setName("serviceName");
		val[0].setSingleValue(serviceName);
		
		val[1] = new SoapMapValue();
		val[1].setName("sourceMsisdn");
		val[1].setSingleValue(sourceMsisdn);

		val[2] = new SoapMapValue();
		val[2].setName("pin");
		val[2].setSingleValue(pin);

	
		values.setValues(val);

		System.out.println("request"+"{serviceName="+val[0].getSingleValue() + 
				", sourceMsisdn="+val[1].getSingleValue() + ", pin=" + val[2].getSingleValue() +
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
		String transactionID="";
		String activity="";
		String status="";
		String dateTime="";
		String amount="";
		String transaction1="";
		String transaction2="";
		String transaction3="";
		String transaction4="";
		String transaction5="";

		for(int i = 0;i < retval.length;i++)
		{
			String name = retval[i].getName();
						
			if(name.equals("transaction1"))
			{
				transaction1= transaction1 + " " + retval[i].getSingleValue();
			}				
			if(name.equals("transaction2"))
			{
				transaction2= transaction2 + " " + retval[i].getSingleValue();
			}				
			if(name.equals("transaction3"))
			{
				transaction3= transaction3 + " " + retval[i].getSingleValue();
			}				
			if(name.equals("transaction4"))
			{
				transaction4= transaction4 + " " + retval[i].getSingleValue();
			}				
			if(name.equals("transaction5"))
			{
				transaction5= transaction5 + " " + retval[i].getSingleValue();
			}			
			if(name.equals("returnCode"))
			{
				returnCode =  retval[i].getSingleValue();
			}
			if(name.equals("errorCode"))
			{
				errorCode = errorCode + " " + retval[i].getSingleValue();
			}
			if(name.equals("transactionStatus"))
			{
				transactionStatus = retval[i].getSingleValue();
			}
			if(name.equals("transactionId"))
			{
				serialNo =  retval[i].getSingleValue();
			}
			if(name.equals("errorDescription"))
			{
				errorDescription = errorDescription + " " + retval[i].getSingleValue();
			}			
			if(name.equals("status"))
			{
				status =  retval[i].getSingleValue();
			}		
			if(name.equals("dateTime"))
			{
				dateTime =  retval[i].getSingleValue();
			}					
			if(name.equals("amount"))
			{
				amount =  retval[i].getSingleValue();
			}					
		}

		result.put("ReturnCode", returnCode);
		result.put("ErrorCode", errorCode);		
		result.put("Transaction1", transaction1);
		result.put("Transaction2", transaction2);
		result.put("Transaction3", transaction3);
		result.put("Transaction4", transaction4);
		result.put("Transaction5", transaction5);
		result.put("AdditionalData", errorDescription);

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
