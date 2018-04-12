package com.citiustech.JerseyTest.Messanger.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.citiustech.JerseyTest.Messanger.Database.DatabaseClass;
import com.citiustech.JerseyTest.Messanger.Model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		//messages.put(1L,new Message(1, "hello World", "trupti"));
		//messages.put(2L,new Message(2, "hello trupti", "trupti"));
	}
	
	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}

	public List<Message> getMessageByYear(int year){
		List<Message> mfy = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()) {
			if(cal.get(Calendar.YEAR)== year)
				mfy.add(message);
		}
		return mfy;
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
 