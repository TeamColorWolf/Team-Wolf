package TeamWolf.TeamWolf.client.BL.customerBL;

import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.FinancePO;
import TeamWolf.TeamWolf.client.po.SaleListPO;

public interface CustomerInfoBLservice {
	public int FinanceInfo(FinancePO po);
	public int SaleInfo(SaleListPO po);
	public CustomerPO getInfo();
}
