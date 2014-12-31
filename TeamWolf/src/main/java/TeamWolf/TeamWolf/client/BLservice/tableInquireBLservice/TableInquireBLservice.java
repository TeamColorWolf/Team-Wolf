package TeamWolf.TeamWolf.client.BLservice.tableInquireBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.RunConditionVO;
import TeamWolf.TeamWolf.client.vo.RunProcessVO;
import TeamWolf.TeamWolf.client.vo.SaleDetialSelectFactVO;
import TeamWolf.TeamWolf.client.vo.SaleDetialVO;
import TeamWolf.TeamWolf.client.vo.TimeVO;

public interface TableInquireBLservice {

	public ArrayList<SaleDetialVO> saleDetial(SaleDetialSelectFactVO vo, TimeVO begin, TimeVO end);
	
	public ArrayList<RunProcessVO> runProcess(TimeVO time1, TimeVO time2);
	
	public RunConditionVO runCondition(TimeVO time1, TimeVO time2);
	
	public ArrayList<String> logCheck();
}
