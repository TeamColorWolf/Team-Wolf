package TeamWolf.TeamWolf.client.BL.tableInquireBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.RunConditionVO;
import TeamWolf.TeamWolf.client.vo.RunProcessVO;
import TeamWolf.TeamWolf.client.vo.SaleDetialSelectFactVO;
import TeamWolf.TeamWolf.client.vo.SaleDetialVO;
import TeamWolf.TeamWolf.client.vo.TimeVO;
/**
 * 
 * @author WHJ
 *
 */
public class TableInquireController {
	TableInquireBL bl;
	
	public ArrayList<SaleDetialVO> saleDetial(SaleDetialSelectFactVO vo) {
		return bl.saleDetial(vo);
	}

	public ArrayList<RunProcessVO> runProcess(TimeVO time1, TimeVO time2) {
		return bl.runProcess(time1, time2);
	}

	public RunConditionVO runCondition(TimeVO time1, TimeVO time2) {
		return bl.runCondition(time1, time2);
	}
}
