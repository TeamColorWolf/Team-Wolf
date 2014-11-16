package TeamWolf.TeamWolf.client.BLservice.financeBLservice;

import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;

public interface TableBlservice {
	public int CreateReceipt(RecieptApplicationVO rvo);
	public int CreatePayment(PaymentApplicationVO pvo);
	public int CreateCash(CashApplicationVO cvo);
}
