package com.example.nagoyameshi.event;

import com.example.nagoyameshi.entity.User;

import lombok.Getter;

@Getter
public class PasswordresetEvent {
	
	private User user;
    private String requestUrl;        

    public PasswordresetEvent(Object source, User user, String requestUrl) {
//    	super(source);
        
        this.user = user;        
        this.requestUrl = requestUrl;
    }

}
