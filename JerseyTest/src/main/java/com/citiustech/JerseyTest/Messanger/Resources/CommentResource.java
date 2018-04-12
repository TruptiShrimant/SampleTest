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

import com.citiustech.JerseyTest.Messanger.Service.CommentService;
import com.citiustech.JerseyTest.Messanger.Model.Comment;
import com.citiustech.JerseyTest.Messanger.Model.Message;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService cs1 = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageid) {
		return cs1.getAllComments(messageid);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageid, @PathParam("commentId") long commentid) {
		return cs1.getComment(messageid, commentid);
	}
	

	@POST
	@Path("/{commentId}")
	public Comment addComment(@PathParam("messageId") long messageid, Comment comment){
		return cs1.addComment(messageid,comment);
		
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment modifyComment(@PathParam("messageId") long messageid, @PathParam("commentId") long commentid, Comment comment){
		comment.setId(commentid);
		return cs1.modifyComment(messageid, comment);
		
	}
	
	@DELETE
	@Path("/{commentId}")
		public void removeComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentid){
		cs1.removeComment(messageId, commentid);
	}
}
