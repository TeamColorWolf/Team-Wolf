package TeamWolf.TeamWolf.client.BL.financeBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.financeDATAservice;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class AccountInfo implements AccountInfoBLservice{
	
	public String URL = "";
	public static financeDATAservice fds;

	public AccountInfo(String IP){
		URL = "rmi://" + IP + "/financeDATAservice";
	}
	
	public int RecieptMod(RecieptApplicationVO vo) {
		ArrayList<financeVO> volist = vo.getAccountList();
		
		return 0;
	}

	public int PaymentMod(PaymentApplicationVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int CashMod(CashApplicationVO vo) {
		// TODO 自动生成的方法存根
		return 0;
	}




}
