package com.citiustech.JerseyTest.Messanger.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.citiustech.JerseyTest.Messanger.Database.DatabaseClass;
import com.citiustech.JerseyTest.Messanger.Model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		// profiles.put("Trupti", new Profile(1L, "Trupti","Shrimant","Shrimant1"));
	}
	
public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
}

public Profile getProfile(String profileName){
	return profiles.get(profileName);
}

public Profile addProfile(Profile profile){
	profile.setId(profiles.size()+1);
	profiles.put(profile.getProfilename(), profile);
	return profile;
}

public Profile updateProfile(Profile profile){
	if(profile.getProfilename().isEmpty())
		return null;
	profiles.put(profile.getProfilename(), profile);
	return profile;
}

public Profile removeProfile(String profileName){
	return profiles.remove(profileName);
}

}
