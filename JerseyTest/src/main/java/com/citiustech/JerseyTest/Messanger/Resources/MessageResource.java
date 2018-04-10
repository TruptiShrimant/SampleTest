package com.citiustech.JerseyTest.Messanger.Resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.citiustech.JerseyTest.Messanger.Model.Message;
import com.citiustech.JerseyTest.Messanger.Service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService ms1 = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return ms1.getAllMessages();
	}
}
