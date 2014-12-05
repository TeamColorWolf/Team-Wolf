package TeamWolf.TeamWolf.client.BL.financeBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;

public interface AccountInfoBLservice {

	public int RecieptMod(RecieptApplicationVO vo);
	public int PaymentMod(PaymentApplicationVO vo);
	public int CashMod(CashApplicationVO vo);
}
