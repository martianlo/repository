package com.ismart.entity;

public class OTATrigger {

	public String serviceName;
	public String sourceMsisdn;
	public String pin;
	
	public OTATrigger()
	{
		serviceName = "08";
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
}
