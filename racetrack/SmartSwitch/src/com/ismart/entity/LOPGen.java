package com.ismart.entity;

import java.util.Hashtable;

public class LOPGen {

	public String serviceName;
	public String sourceMsisdn;
	public String pin;
	public String actualPaid;
	public String transferDate;
	public String giroRefNumber;
	
	public LOPGen(){
		serviceName = "07";
		sourceMsisdn = "";
		pin = "";
		actualPaid = "";
		transferDate = "";
		giroRefNumber = "";
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

	public String getActualPaid() {
		return actualPaid;
	}

	public void setActualPaid(String actualPaid) {
		this.actualPaid = actualPaid;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	public String getGiroRefNumber() {
		return giroRefNumber;
	}

	public void setGiroRefNumber(String giroRefNumber) {
		this.giroRefNumber = giroRefNumber;
	}
	
	public SoapMap composeMsg()
	{
		SoapMap values = new SoapMap();
		SoapMapValue[] val = new SoapMapValue[6];

		val[0] = new SoapMapValue();
		val[0].setName("serviceName");
		val[0].setSingleValue(serviceName);
		
		val[1] = new SoapMapValue();
		val[1].setName("sourceMsisdn");
		val[1].setSingleValue(sourceMsisdn);
		
		val[2] = new SoapMapValue();
		val[2].setName("actualPaid");
		val[2].setSingleValue(actualPaid);

		val[3] = new SoapMapValue();
		val[3].setName("transferDate");
		val[3].setSingleValue(transferDate);
		
		val[4] = new SoapMapValue();
		val[4].setName("giroRefNumber");
		val[4].setSingleValue(giroRefNumber);
	
		val[5] = new SoapMapValue();
		val[5].setName("pin");
		val[5].setSingleValue(pin);		
		
		values.setValues(val);
		
		System.out.println("request"+"{serviceName="+val[0].getSingleValue() + 
				", sourceMsisdn="+val[1].getSingleValue() + ", actualPaid=" + val[2].getSingleValue() +
				", transferDate="+val[1].getSingleValue() + ", giroRefNumber=" + val[2].getSingleValue() +
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
		}

		result.put("ReturnCode", returnCode);
		result.put("lopId", lopId);		
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
