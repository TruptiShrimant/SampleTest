package com.citiustech.JerseyTest.Messanger.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.citiustech.JerseyTest.Messanger.Database.DatabaseClass;
import com.citiustech.JerseyTest.Messanger.Model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(messages.values());
		
		/*
		Message m1 = new Message(1, "hello World", "trupti");
		Message m2 = new Message(2, "hello trupti", "trupti");
		
		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		return list;
		*/
	}
	
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0)
			return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	
	
}
