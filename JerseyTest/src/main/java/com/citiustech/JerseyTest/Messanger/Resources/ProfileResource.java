package com.citiustech.JerseyTest.Messanger.Resources;

import java.util.List;

import javax.validation.constraints.Past;
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
import com.citiustech.JerseyTest.Messanger.Model.Profile;
import com.citiustech.JerseyTest.Messanger.Service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	ProfileService ps1 = new ProfileService();
	
	@GET	
	public List<Profile> getAllProfiles(){
		return ps1.getAllProfiles();
	}
	
	@GET	
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName){
		return ps1.getProfile(profileName);
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return ps1.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
		profile.setProfilename(profileName);
		return ps1.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void removeProfile(@PathParam("profileName") String profileName) {
		ps1.removeProfile(profileName);
	}
	
}
