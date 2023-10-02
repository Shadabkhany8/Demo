package com.example.demo.model;

public class SMSSendRequest {

	private String desSMSNumber;
	private String smsMessage;

	public String getDesSMSNumber() {
		return desSMSNumber;
	}

	public void setDesSMSNumber(String desSMSNumber) {
		this.desSMSNumber = desSMSNumber;
	}

	public String getSmsMessage() {
		return smsMessage;
	}

	public void setSmsMessage(String smsMessage) {
		this.smsMessage = smsMessage;
	}

	public SMSSendRequest(String desSMSNumber, String smsMessage) {
		super();
		this.desSMSNumber = desSMSNumber;
		this.smsMessage = smsMessage;
	}

	public SMSSendRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SMSSendRequest [desSMSNumber=" + desSMSNumber + ", smsMessage=" + smsMessage + "]";
	}

}
