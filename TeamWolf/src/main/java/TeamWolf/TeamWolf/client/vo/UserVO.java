package TeamWolf.TeamWolf.client.vo;

public class UserVO {
	public String userName;//用户名
	public String password;//密码
	public String workID;//工作编号
	public int power;//权限
	
	public UserVO(String Name, String Password, String WorkID, String Power){
		userName = Name;
		password = Password;
		workID = WorkID;
		if(Power.equals("库存管理员")){
			power = 1;
		}
		else if(Power.equals("销售人员")){
			power = 2;
		}
		else if(Power.equals("销售经理")){
			power = 3;
		}
		else if(Power.equals("财务人员")){
			power = 4;
		}
		else if(Power.equals("总经理")){
			power = 5;
		}
	}
}
