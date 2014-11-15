package TeamWolf.TeamWolf.client.GUI.mainUI;

import java.awt.Font;

import javax.swing.UIManager;

import TeamWolf.TeamWolf.client.GUI.userUI.LoginFrame;
/**
 * 
 * @author WHJ
 *
 */
public class Main {
	static LoginFrame login;
	public Main(){
		login = new LoginFrame();
		login.addLoginListener(new LoginButtonListener());
	}
	
	public static void main(String[] args){
		Font font = new Font("微软雅黑",Font.BOLD,12);
		UIManager.put("Button.font", font); 
        UIManager.put("Label.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("TabbedPane.font", font);
		Main team_wolf = new Main();
	}
	
}
