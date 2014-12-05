package TeamWolf.TeamWolf.client.BL.financeBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;

public interface AccountInfoBLservice {

	public int RecieptMod(RecieptApplicationVO volist);
	public int PaymentMod(PaymentApplicationVO volist);
	public int CashMod(CashApplicationVO volist);
}
