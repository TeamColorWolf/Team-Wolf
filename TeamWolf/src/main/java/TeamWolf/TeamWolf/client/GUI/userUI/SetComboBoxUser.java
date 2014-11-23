package TeamWolf.TeamWolf.client.GUI.userUI;

import javax.swing.JComboBox;

import TeamWolf.TeamWolf.client.vo.UserType;

public class SetComboBoxUser {
	public static void set(JComboBox power){
		power.addItem(UserType.库存管理员);
		power.addItem(UserType.销售人员);
		power.addItem(UserType.销售经理);
		power.addItem(UserType.财务人员);
		power.addItem(UserType.总经理);
		power.addItem(UserType.系统管理员);
	}
	
	public static void setDefault(JComboBox power, UserType type){
		int choice = -1;
		if(type == UserType.库存管理员){
			choice = 0;
		}
		else if(type == UserType.销售人员){
			choice = 1;
		}
		else if(type == UserType.销售经理){
			choice = 2;
		}
		else if(type == UserType.财务人员){
			choice = 3;
		}
		else if(type == UserType.总经理){
			choice = 4;
		}
		else if(type == UserType.系统管理员){
			choice = 5;
		}
		power.setSelectedIndex(choice);
	}
}
