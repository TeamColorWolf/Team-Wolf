package TeamWolf.TeamWolf.client.BL.applicationBL;

import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public class IncreaseToMatch extends Application{
	IncreaseToMatchPO application;
	
	public IncreaseToMatch(ApplicationVO vo) {
		super(vo);
		// TODO Auto-generated constructor stub
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
