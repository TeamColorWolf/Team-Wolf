package TeamWolf.TeamWolf.client.GUI.mainUI;

import TeamWolf.TeamWolf.client.GUI.userUI.LoginFrame;

public class Main {
	
	public Main(){
		LoginFrame login = new LoginFrame();
		login.addLoginListener(new LoginButtonListener());
	}
	
	public static void main(String[] args){
		Main team_wolf = new Main();
	}
	
}
