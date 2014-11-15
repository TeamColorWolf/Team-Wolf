package TeamWolf.TeamWolf.client.BL.customerBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;

public class Mock_CustomerOpr extends CustomerOpr{
	
	public Mock_CustomerOpr(String IP){
		super(IP);
		voList = new ArrayList<CustomerVO>();
   	    CustomerVO GD = new CustomerVO("", "", "", "GD", "", "", "", "", "", "", "", "");
	    CustomerVO GD2 = new CustomerVO("", "", "", "GAODAN", "", "", "", "", "", "", "", "");
	    CustomerVO GD3 = new CustomerVO("", "", "", "FTW", "", "", "", "", "", "", "", "");
	    CustomerVO GD4 = new CustomerVO("", "", "", "WAM", "", "", "", "", "", "", "", "");
	    voList.add(GD);
	    voList.add(GD2);
	    voList.add(GD3);
	    voList.add(GD4);
	}
	
	@Override
	public ArrayList<CustomerVO> getAllCustomerList(){
		return voList;
	}

}
