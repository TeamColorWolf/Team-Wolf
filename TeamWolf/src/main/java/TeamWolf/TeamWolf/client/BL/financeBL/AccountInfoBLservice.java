package TeamWolf.TeamWolf.client.BL.financeBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
//接口
//处理各类单据对账户的修改
public interface AccountInfoBLservice {

	public int RecieptMod(RecieptApplicationVO vo);
	public int PaymentMod(PaymentApplicationVO vo);
	public int CashMod(CashApplicationVO vo);
}
