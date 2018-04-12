package com.citiustech.JerseyTest.Messanger.Resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.citiustech.JerseyTest.Messanger.Model.Message;
import com.citiustech.JerseyTest.Messanger.Service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService ms1 = new MessageService();
	
	@GET
	public List<Message> getMessages(){
		return ms1.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage( @PathParam("messageId") long messageId){
		return ms1.getMessage(messageId);
	}
	
	@POST
	public Message addMessage(Message message){
		return ms1.addMessage(message);
		
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message){
		message.setId(messageId);
		return ms1.updateMessage(message);
		
	}
	
	@DELETE
	@Path("/{messageId}")
		public void deleteMessage(@PathParam("messageId") long messageId){
		ms1.removeMessage(messageId);
	}
	
	@GET
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() { //( @PathParam("messageId") long messageId){
		return new CommentResource();
	}
	
}
