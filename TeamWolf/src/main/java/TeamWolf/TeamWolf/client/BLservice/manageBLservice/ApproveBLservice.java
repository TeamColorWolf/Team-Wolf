package TeamWolf.TeamWolf.client.BLservice.manageBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;

public interface ApproveBLservice {
	public ArrayList<Application> checkApplication();
	
	public ArrayList<Application> approve();
	
	public ArrayList<Application> reject();
	
}
