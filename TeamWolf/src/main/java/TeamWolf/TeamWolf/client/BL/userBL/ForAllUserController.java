package TeamWolf.TeamWolf.client.BL.userBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.userBLservice.ForAllUserService;

public class ForAllUserController implements ForAllUserService{
	String IP;
	public ArrayList<String> getWorkNumberList() {
		// TODO Auto-generated method stub
		return new ForAllUser(IP).getWorkNumberList();
	}

}
