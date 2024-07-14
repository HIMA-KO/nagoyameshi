package com.example.nagoyameshi.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.example.nagoyameshi.entity.User;

	@Component
	public class PasswordresetEventPublisher {
	 private final ApplicationEventPublisher applicationEventPublisher;
	     
	     public PasswordresetEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
	         this.applicationEventPublisher = applicationEventPublisher;                
	     }
	     
	     public void publishPasswordresetEventPublisher(User user, String requestUrl) {
	         applicationEventPublisher.publishEvent(new SignupEvent(this, user, requestUrl));
	     }

	}


