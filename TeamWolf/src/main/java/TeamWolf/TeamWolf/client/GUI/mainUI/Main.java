package TeamWolf.TeamWolf.client.GUI.mainUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Font font = new Font("微软雅黑",Font.BOLD,12);
		UIManager.put("Button.font", font); 
        UIManager.put("Label.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("TabbedPane.font", font);
		Main team_wolf = new Main();
	}
	
}
