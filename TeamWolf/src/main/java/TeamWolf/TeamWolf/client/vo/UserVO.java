package TeamWolf.TeamWolf.client.vo;
/**
 * 
 * @author WHJ
 *
 */
public class UserVO {
	public String userName;//用户名
	public String password;//密码
	public String workID;//工作编号
	public UserType power;//权限
	
	public UserVO(String Name, String Password, String WorkID, UserType Power){
		userName = Name;
		password = Password;
		workID = WorkID;
		power = Power;
	}
}
