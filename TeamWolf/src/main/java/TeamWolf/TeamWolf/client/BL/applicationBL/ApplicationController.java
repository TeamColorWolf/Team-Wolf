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
/**
 * Author WHJ
 */
public class ApplicationController {
	//Manage
	public ArrayList<ApplicationVO> getUnsetApplicationList(){
		return new ManageApprove().getUnsetApplicationList();
	}
	
	public int approveOver(ArrayList<ApplicationVO> list){
		return new ManageApprove().approveOver(list);
	}
	//MutiRole
	public ArrayList<ApplicationVO> getApprovalApplicationList(){
		return new ApplicationBL().getApprovalApplicationList();
	}
	
	public ApplicationVO findApplication(String number){
		return new ApplicationBL().findApplication(number);
	}
	
	public ArrayList<String> getResult(String workNumber){
		return new ApplicationBL().getResult(workNumber);
	}
	
	//Stock
	public int submitIncreaseToMatch(IncreaseToMatchVO vo){
		return new StockSubmit().submitIncreaseToMatch(vo);
	}
	
	public int submitDecreaseToMatch(DecreaseToMatchVO vo){
		return new StockSubmit().submitDecreaseToMatch(vo);
	}
	
	public int submitPresentList(PresentListVO vo){
		return new StockSubmit().submitPresentList(vo);
	}
	
	//Sale
	public int submitImportList(ImportListVO vo){
		return new SaleSubmit().submitImportList(vo);
	}
	public int submitImportRejectList(ImportRejectListVO vo){
		return new SaleSubmit().submitImportRejectList(vo);
	}
	public int submitSaleList(SaleListVO vo){
		return new SaleSubmit().submitSaleList(vo);
	}
	public int submitSaleRejectList(SaleRejectListVO vo){
		return new SaleSubmit().submitSaleRejectList(vo);
	}
	
	//Finance
	public int submitRecieptApplication(RecieptApplicationVO vo){
		return new FinanceSubmit().submitRecieptApplication(vo);
	}
	
	public int submitPaymentApplication(PaymentApplicationVO vo){
		return new FinanceSubmit().submitPaymentApplication(vo);
	}
	
	public int submitCashApplication(CashApplicationVO vo){
		return new FinanceSubmit().submitCashApplication(vo);
	}
	
}
