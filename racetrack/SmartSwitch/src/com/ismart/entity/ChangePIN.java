package com.ismart.entity;

import java.util.Hashtable;

public class ChangePIN {

	public String serviceName;
	public String sourceMsisdn;
	public String oldPin;
	public String newPin;
	public String confPin;
	
	public ChangePIN() {
		serviceName="04";
		sourceMsisdn = "";
		oldPin = "";
		newPin = "";
		confPin = "";
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

	public String getOldPin() {
		return oldPin;
	}

	public void setOldPin(String oldPin) {
		this.oldPin = oldPin;
	}

	public String getNewPin() {
		return newPin;
	}

	public void setNewPin(String newPin) {
		this.newPin = newPin;
	}

	public String getConfPin() {
		return confPin;
	}

	public void setConfPin(String confPin) {
		this.confPin = confPin;
	}
	
	public SoapMap composeMsg()
	{
		SoapMap values = new SoapMap();
		SoapMapValue[] val = new SoapMapValue[5];

		val[0] = new SoapMapValue();
		val[0].setName("serviceName");
		val[0].setSingleValue(serviceName);
		
		val[1] = new SoapMapValue();
		val[1].setName("sourceMsisdn");
		val[1].setSingleValue(sourceMsisdn);

		val[2] = new SoapMapValue();
		val[2].setName("oldPin");
		val[2].setSingleValue(oldPin);

		val[3] = new SoapMapValue();
		val[3].setName("newPin");
		val[3].setSingleValue(newPin);

		val[4] = new SoapMapValue();
		val[4].setName("confPin");
		val[4].setSingleValue(confPin);

		values.setValues(val);				
		
		System.out.println("request"+"{serviceName="+val[0].getSingleValue() + 
				", sourceMsisdn="+val[1].getSingleValue() + ", oldPin=" + val[2].getSingleValue() +
				", newPin="+val[3].getSingleValue() + ", confPin=" + val[4].getSingleValue() +				
				"}");		
		  
		return values;
	}
	
	public Hashtable composeResponse(SoapMap map)
	{
		Hashtable result = new Hashtable();

		SoapMapValue[] retval = map.getValues();

		System.out.println("Compose Response message");
		
		String serialNo = "";
		String transactionStatus = "";
		String returnCode = "1";
		String errorDescription = "";
		String errorCode="";

		for(int i = 0;i < retval.length;i++)
		{
			String name = retval[i].getName();

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
		}

		result.put("ReturnCode", returnCode);
		result.put("errorCode", errorCode);
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
