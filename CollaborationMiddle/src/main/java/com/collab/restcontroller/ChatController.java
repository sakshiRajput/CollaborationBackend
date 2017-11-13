package com.collab.restcontroller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.collab.CollaborationBack.model.Message;
import com.collab.CollaborationBack.model.OutputMessage;

@Controller
public class ChatController {

	  
	  @MessageMapping("/chat")   ///sendMessage
	  @SendTo("/topic/message")        //receiveMessage
	  public OutputMessage sendMessage(Message message) {
		  
	    return new OutputMessage(message,new Date()); 
	    
	  
	  
	  }

	
}
