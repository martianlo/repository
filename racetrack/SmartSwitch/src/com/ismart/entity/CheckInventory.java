package com.ismart.entity;

import java.util.Hashtable;

public class CheckInventory {

	public String serviceName;
	public String sourceMsisdn;
	public String pin;
	
	public CheckInventory()
	{
		serviceName = "03";
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
		val[0].setName("sourceMsisdn");
		val[0].setSingleValue(sourceMsisdn);

		val[1] = new SoapMapValue();
		val[1].setName("pin");
		val[1].setSingleValue(pin);
		
		val[2] = new SoapMapValue();
		val[2].setName("serviceName");
		val[2].setSingleValue(serviceName);		
	
		values.setValues(val);
						
		System.out.println("request"+"{serviceName="+val[2].getSingleValue() + 
				", sourceMsisdn="+val[0].getSingleValue() + ", pin=" + val[1].getSingleValue() +
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
		String balance="";

		for(int i = 0;i < retval.length;i++)
		{
			String name = retval[i].getName();
			
			System.out.println(retval[i].getName());

			if(name.equals("returnCode"))
			{
				returnCode =  retval[i].getSingleValue();
			}
			if(name.equals("errorDescription"))
			{
				errorDescription = errorDescription + " " + retval[i].getSingleValue();
			}
			if(name.equals("errorCode"))
			{
				errorCode = errorCode + " " + retval[i].getSingleValue();
			}
			if(name.equals("balance"))
			{
				balance =  retval[i].getSingleValue();
			}			
		}

		result.put("ReturnCode", returnCode);
		result.put("errorCode", returnCode);
		result.put("AdditionalData", errorDescription);
		result.put("Balance", balance);

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
