package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public class ApplicationController {
	public ArrayList<ApplicationVO> getUnsetApplicationList(){
		return null;
	}
	
	public ArrayList<ApplicationVO> getApprovalApplicationList(){
		return null;
	}
	
	public Application findApplication(String number){
		return null;
	}
	
	public ArrayList<String> getResult(String workNumber){
		return null;
	}
	
	public int approveOver(ArrayList<ApplicationVO> list){
		return 0;
	}
	
	//Stock
	public int submitIncreaseToMatch(IncreaseToMatchVO vo){
		return 0;
	}
	
	public int submitDecreaseToMatch(DecreaseToMatchVO vo){
		return 0;
	}
	
	public int submitPresentList(PresentListVO vo){
		return 0;
	}
	
	//Sale
	public int submitImportList(ImportListVO vo){
		return 0;
	}
	public int submitImportRejectList(ImportRejectListVO vo){
		return 0;
	}
	public int submitSaleList(SaleListVO vo){
		return 0;
	}
	public int submitSaleRejectList(SaleRejectListVO vo){
		return 0;
	}
	
	//Finance
	public int submitRecieptApplication(RecieptApplicationVO vo){
		return 0;
	}
	
	public int submitPaymentApplication(PaymentApplicationVO vo){
		return 0;
	}
	
	public int submitCashApplication(CashApplicationVO vo){
		return 0;
	}
	
}
