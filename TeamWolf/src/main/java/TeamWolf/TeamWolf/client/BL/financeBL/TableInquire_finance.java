package TeamWolf.TeamWolf.client.BL.financeBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.tableInquireBLservice.RedBLservice;
import TeamWolf.TeamWolf.client.BLservice.tableInquireBLservice.TableInquireBLservice;
import TeamWolf.TeamWolf.client.vo.RunConditionVO;
import TeamWolf.TeamWolf.client.vo.RunProcessVO;
import TeamWolf.TeamWolf.client.vo.SaleDetialSelectFactVO;
import TeamWolf.TeamWolf.client.vo.SaleDetialVO;
import TeamWolf.TeamWolf.client.vo.TimeVO;

//相关功能已经转移
//红冲与经营历程查看
//该类已废弃
//只在桩中出现

public class TableInquire_finance implements TableInquireBLservice, RedBLservice{

	public int red() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int redAndCopy() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<SaleDetialVO> saleDetial(SaleDetialSelectFactVO vo,
			TimeVO begin, TimeVO end) {
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
