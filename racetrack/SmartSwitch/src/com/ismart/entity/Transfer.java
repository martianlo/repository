package com.ismart.entity;

public class Transfer {

	public String serviceName;
	public String sourceMsisdn;
	public String pin;
	public String destMsisdn;
	public String amount;
	public String terminalID;
	
	public Transfer()
	{		
		serviceName = "02";
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
		SoapMapValue[] val = new SoapMapValue[6];

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
		val[4].setName("amount");
		val[4].setSingleValue(amount);

		val[5] = new SoapMapValue();
		val[5].setName("terminalID");
		val[5].setSingleValue(terminalID);

		values.setValues(val);
		
		System.out.println("request"+"{serviceName="+val[0].getSingleValue() + 
				", sourceMsisdn="+val[1].getSingleValue() + ", pin=" + val[2].getSingleValue() +
				", destMsisdn="+val[3].getSingleValue() + ", amount="+val[4].getSingleValue() +
				", terminaID="+val[5].getSingleValue() +
				"}");
		  
		return values;
	}
}
