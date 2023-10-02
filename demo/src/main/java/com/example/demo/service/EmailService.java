package com.example.demo.service;

import com.example.demo.dto.EmailDetail;

public interface EmailService {

	String sendSimpleMail(EmailDetail details);
}
