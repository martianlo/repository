package com.ismart.entity;

import java.util.Hashtable;

public class Topup {

	public String serviceName;
	public String sourceMsisdn;
	public String pin;
	public String destMsisdn;
	public String bucketType;
	public String amount;
	public String terminalID;

	public Topup()
	{		
		serviceName = "01";
		bucketType = "Reg";
		sourceMsisdn = "";
		destMsisdn = "";
		amount = "";
		terminalID = "";
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

	public String getDestMsisdn() {
		return destMsisdn;
	}

	public void setDestMsisdn(String destMsisdn) {
		this.destMsisdn = destMsisdn;
	}

	public String getBucketType() {
		return bucketType;
	}

	public void setBucketType(String bucketType) {
		this.bucketType = bucketType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTerminalID() {
		return terminalID;
	}

	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}

	public SoapMap composeMsg()
	{
		SoapMap values = new SoapMap();
		SoapMapValue[] val = new SoapMapValue[7];

		val[0] = new SoapMapValue();
		val[0].setName("serviceName");
		val[0].setSingleValue(serviceName);

		val[1] = new SoapMapValue();
		val[1].setName("sourceMsisdn");
		val[1].setSingleValue(sourceMsisdn);

		val[2] = new SoapMapValue();
		val[2].setName("pin");
		val[2].setSingleValue(pin);

		val[3] = new SoapMapValue();
		val[3].setName("destMsisdn");
		val[3].setSingleValue(destMsisdn);
	
		val[4] = new SoapMapValue();
		val[4].setName("bucketType");
		val[4].setSingleValue(bucketType);
		
		val[5] = new SoapMapValue();
		val[5].setName("amount");
		val[5].setSingleValue(amount);

		val[6] = new SoapMapValue();
		val[6].setName("terminalID");
		val[6].setSingleValue(terminalID);

		values.setValues(val);

		System.out.println("request"+"{serviceName="+val[0].getSingleValue() + 
				", sourceMsisdn="+val[1].getSingleValue() + ", pin=" + val[2].getSingleValue() +
				", destMsisdn="+val[3].getSingleValue() + ", bucketType=" + val[4].getSingleValue() +				
				", amount="+val[5].getSingleValue() +", terminaID="+val[6].getSingleValue() +
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

		for(int i = 0;i < retval.length;i++)
		{
			String name = retval[i].getName();

			if(name.equals("returnCode"))
			{
				returnCode =  retval[i].getSingleValue();
			}
			if(name.equals("transactionStatus"))
			{
				transactionStatus = retval[i].getSingleValue();
			}
			if(name.equals("transactionID"))
			{
				serialNo =  retval[i].getSingleValue();
			}
			if(name.equals("errorDescription"))
			{
				errorDescription = errorDescription + " " + retval[i].getSingleValue();
			}
			if(name.equals("errorCode"))
			{
				errorDescription = errorDescription + " " + retval[i].getSingleValue();
			}
		}

		result.put("ReturnCode", returnCode);
		result.put("TransactionStatus", transactionStatus);
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
