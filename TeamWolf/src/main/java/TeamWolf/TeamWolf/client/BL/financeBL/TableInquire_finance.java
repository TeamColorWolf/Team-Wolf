package TeamWolf.TeamWolf.client.BL.financeBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.tableInquireBLservice.RedBLservice;
import TeamWolf.TeamWolf.client.BLservice.tableInquireBLservice.TableInquireBLservice;
import TeamWolf.TeamWolf.client.vo.RunConditionVO;
import TeamWolf.TeamWolf.client.vo.RunProcessVO;
import TeamWolf.TeamWolf.client.vo.SaleDetialVO;
import TeamWolf.TeamWolf.client.vo.TimeVO;

public class TableInquire_finance implements TableInquireBLservice, RedBLservice{

	public int red() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int redAndCopy() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<SaleDetialVO> saleDetial(TimeVO time1, TimeVO time2) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<RunProcessVO> runProcess(TimeVO time1, TimeVO time2) {
		// TODO Auto-generated method stub
		return null;
	}

	public RunConditionVO runCondition(TimeVO time1, TimeVO time2) {
		// TODO Auto-generated method stub
		return null;
	}

}
