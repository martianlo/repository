package com.ismart.entity;

import java.util.Hashtable;

public class LOPDetails {

	public String serviceName;
	public String sourceMsisdn;
	public String pin;
	public String lopID;
	
	public LOPDetails() {
		serviceName = "10";
		sourceMsisdn = "";
		pin = "";
		lopID = "";
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

	public String getLopID() {
		return lopID;
	}

	public void setLopID(String lopID) {
		this.lopID = lopID;
	}
	
	public SoapMap composeMsg()
	{
		SoapMap values = new SoapMap();
		SoapMapValue[] val = new SoapMapValue[4];

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
		val[3].setName("lopID");
		val[3].setSingleValue(lopID);
	
		values.setValues(val);

		System.out.println("request"+"{serviceName="+val[0].getSingleValue() + 
				", sourceMsisdn="+val[1].getSingleValue() + ", pin=" + val[2].getSingleValue() +
				", lopId="+val[3].getSingleValue() +
				"}");		
		
		return values;
	}
	
	public Hashtable composeResponse(SoapMap map)
	{
		Hashtable result = new Hashtable();

		SoapMapValue[] retval = map.getValues();
		
		String serialNo = "";
		String returnCode = "1";
		String lopID1="";
		String creationTime="";
		String errorDescription = "";
		String errorCode = "";
		String transactionID="";
		String activity="";
		String status="";
		String dateTime="";
		String amount="";
		String balance="";
		String transactionStatus="";
		String createdBy="";
		String distributorName="";
		String amountPaid="";
		String distributedBy="";
		String distributedTime="";
		String approvedBy="";
		String approvedTime="";

		for(int i = 0;i < retval.length;i++)
		{
			String name = retval[i].getName();

			if(name.equals("returnCode"))
			{
				returnCode =  retval[i].getSingleValue();
			}
			if(name.equals("lopID"))
			{
				 lopID1 = retval[i].getSingleValue();
			}
			if(name.equals("creationTime"))
			{
				creationTime = retval[i].getSingleValue();
			}
			if(name.equals("createdBy"))
			{
				createdBy = retval[i].getSingleValue();
			}			
			if(name.equals("distributorName"))
			{
				distributorName = retval[i].getSingleValue();
			}
			if(name.equals("amountPaid"))
			{
				amountPaid= retval[i].getSingleValue();
			}		
			if(name.equals("balance"))
			{
				balance= retval[i].getSingleValue();
			}		
			if(name.equals("status"))
			{
				status =  retval[i].getSingleValue();
			}			
			if(name.equals("distributedBy"))
			{
				distributedBy =  retval[i].getSingleValue();
			}
			if(name.equals("distributedTime"))
			{
				distributedTime =  retval[i].getSingleValue();
			}
			if(name.equals("approvedBy"))
			{
				approvedBy =  retval[i].getSingleValue();
			}					
			if(name.equals("approvedTime"))
			{
				approvedTime =  retval[i].getSingleValue();
			}	
			if(name.equals("transactionStatus"))
			{
				transactionStatus = retval[i].getSingleValue();
			}
			if(name.equals("errorCode"))
			{
				errorCode = errorCode + " " + retval[i].getSingleValue();
			}
			if(name.equals("errorDescription"))
			{
				errorDescription = errorDescription + " " + retval[i].getSingleValue();
			}
			if(name.equals("activity"))
			{
				activity= activity + " " + retval[i].getSingleValue();
			}		
			if(name.equals("dateTime"))
			{
				dateTime =  retval[i].getSingleValue();
			}					
			if(name.equals("amount"))
			{
				dateTime =  retval[i].getSingleValue();
			}					
		}

		result.put("balance", balance);
		result.put("ReturnCode", returnCode);
		result.put("TransactionStatus", transactionStatus);
		result.put("Status", status);
		result.put("CreatedBy",createdBy);
		result.put("CreationTime",creationTime);
		result.put("amountPaid", amountPaid);
		result.put("lopID",lopID1);
		result.put("approvedTime", distributedTime);
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
