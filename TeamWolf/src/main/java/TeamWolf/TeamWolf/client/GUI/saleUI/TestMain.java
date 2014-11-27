package TeamWolf.TeamWolf.client.GUI.saleUI;

import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserVO user = new UserVO("WKS", "131250196", "0001", UserType.销售人员);
		String ip = "127.0.0.1";
		FunctionChoose fc = new FunctionChoose(user, ip);
	}

}
