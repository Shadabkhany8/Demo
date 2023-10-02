package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.service.SMSService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.annotation.PostConstruct;

@Service
public class SMSServiceImpl implements SMSService {

	@Value("${valoux.account.sid}")
	String ACCOUNT_SID;

	@Value("${valoux.account.token}")
	String AUTH_TOKEN;

	@Value("${valoux.account.from.phone.no}")
	String OUTGOING_PHONE_NUMBER;

	@PostConstruct
	private void setup() {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	}

	@Override
	public String sendSMS(String smsNumber, String smsMessage) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message
				.creator(new PhoneNumber(smsNumber), new PhoneNumber(OUTGOING_PHONE_NUMBER), smsMessage).create();

		return message.getStatus().toString();

	}
}
