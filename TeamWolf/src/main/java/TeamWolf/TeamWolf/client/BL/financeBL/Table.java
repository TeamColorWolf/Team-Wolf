package TeamWolf.TeamWolf.client.BL.financeBL;

import TeamWolf.TeamWolf.client.BL.applicationBL.forFinance.FinanceSubmit;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.TableBlservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;

public class Table implements TableBlservice{

	FinanceSubmit fs;
	
	public Table(String iP) {
		// TODO 自动生成的构造函数存根
	}

	public int CreateReceipt(RecieptApplicationVO rvo) {
		return fs.submitRecieptApplication(rvo);
	}

	public int CreatePayment(PaymentApplicationVO pvo) {
		return fs.submitPaymentApplication(pvo);
	}

	public int CreateCash(CashApplicationVO cvo) {
		return fs.submitCashApplication(cvo);
	}


    
}
