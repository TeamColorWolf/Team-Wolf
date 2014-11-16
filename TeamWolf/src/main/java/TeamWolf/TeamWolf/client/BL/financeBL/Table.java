package TeamWolf.TeamWolf.client.BL.financeBL;

import TeamWolf.TeamWolf.client.BL.applicationBL.forFinance.FinanceApplicationController;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.TableBlservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;

public class Table implements TableBlservice{

	FinanceApplicationDATAservice fads;
	
	public Table(String iP) {
		// TODO 自动生成的构造函数存根
	}

	public int CreateReceipt(RecieptApplicationVO rvo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int CreatePayment(PaymentApplicationVO pvo) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public int CreateCash(CashApplicationVO cvo) {
		// TODO 自动生成的方法存根
		return 0;
	}


    
}
