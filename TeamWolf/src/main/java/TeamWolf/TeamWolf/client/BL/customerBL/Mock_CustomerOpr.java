package TeamWolf.TeamWolf.client.BL.customerBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class Mock_CustomerOpr extends CustomerOpr{
	
	public Mock_CustomerOpr(String IP){
		super(IP);
		voList = new ArrayList<CustomerVO>();
		poList = new ArrayList<CustomerPO>();
		CustomerVO GD = new CustomerVO("1", "1", "1", "GD", "1", "1", "1", "1", "1", "1", "1", "1");
		CustomerVO GD2 = new CustomerVO("1", "1", "1", "GAODAN", "1", "1", "1", "1", "1", "1", "1", "1");
		CustomerVO GD3 = new CustomerVO("1", "1", "1", "FTW", "1", "1", "1", "1", "1", "1", "1", "1");
		CustomerVO GD4 = new CustomerVO("1", "1", "1", "WAM", "1", "1", "1", "1", "1", "1", "1", "1");
		CustomerVO GOGOGO = new CustomerVO("1", "1", "1", "TEEEE", "1", "1", "1", "1", "1", "1", "1", "1");
	    voList.add(GD);
	    voList.add(GD2);
	    voList.add(GD3);
	    voList.add(GD4);
	    voList.add(GOGOGO);
	    }
	
	public int AddCustomer(CustomerVO Customer) {
		for(CustomerVO v:voList){
			if(v.getName().equals(Customer.getName())) return 12138;
		}
		voList.add(Customer);
		poList.add(new CustomerPO(Customer));
		return 0;
	}
	
	@Override
	public ArrayList<CustomerVO> getAllCustomerList(){
		return voList;
	}

}
