package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.example.demo.model.SMSSendRequest;
import com.example.demo.service.SMSService;

@RestController
@Slf4j
public class SMSController {

	@Autowired
	private SMSService smsService;

	@PostMapping("/smsSend")
	public String sendSMS(@RequestBody SMSSendRequest sendRequest) {
		
		log.info("Procces start : "+sendRequest.toString());
		
		return smsService.sendSMS(sendRequest.getDesSMSNumber(),sendRequest.getSmsMessage());
	}

}
