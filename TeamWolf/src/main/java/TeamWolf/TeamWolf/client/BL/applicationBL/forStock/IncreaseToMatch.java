package TeamWolf.TeamWolf.client.BL.applicationBL.forStock;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;

public class IncreaseToMatch extends Application{
	IncreaseToMatchPO application;
	
	public IncreaseToMatch(IncreaseToMatchVO vo) {
		super(vo);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ApplicationVO getApplicationVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationPO getApplicationPO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int submit() {
		return 0;
	}
	@Override
	public int approve(){
		//改变其状态并且进行后续操作
		condition = 1;
		return 0;
	}
	@Override
	public int reject(){
		//改变其状态并且进行后续操作
		condition = -1;
		return 0;
	}
	@Override
	public int change(ApplicationVO vo){
		return 0;
	}

}