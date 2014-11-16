package TeamWolf.TeamWolf.client.BL.financeBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class Mock_finance extends Account{
	ArrayList<financeVO> voList;
	ArrayList<financePO> poList;
	public Mock_finance(String IP){
		super(IP);
		voList = new ArrayList<financeVO>();
		poList = new ArrayList<financePO>();
		financeVO GD = new financeVO("GD");
		financeVO JD = new financeVO("JD");
	    voList.add(GD);
	    voList.add(JD);
	    }
	
	public int AddAccount(financeVO Account) {
		for(financeVO v:voList){
			if(v.getName().equals(Account.getName())) return 49123;
		}
		voList.add(Account);
		poList.add(new financePO(Account));
		return 0;
	}
	
}
