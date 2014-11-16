package TeamWolf.TeamWolf.client.BL.tableInquireBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.mutiRole.MutiRoleController;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
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
public class TableInquireBL {
	//查表需求最后实现
	MutiRoleController data;
	ArrayList<SaleDetialVO> saleDetial;
	ArrayList<RunProcessVO> runProcess;
	RunConditionVO runCondition;
	
	public ArrayList<SaleDetialVO> saleDetial(SaleDetialSelectFactVO vo) {
		return saleDetial;
	}

	public ArrayList<RunProcessVO> runProcess(TimeVO time1, TimeVO time2) {
		return runProcess;
	}

	public RunConditionVO runCondition(TimeVO time1, TimeVO time2) {
		return runCondition;
	}
	/**
	 * 该方法内部调用
	 * @return
	 */
	private ArrayList<ApplicationVO> getAllApplication(){
		return data.getApprovalApplicationList();
	}
}
