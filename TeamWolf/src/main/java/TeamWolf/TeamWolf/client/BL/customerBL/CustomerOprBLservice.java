package TeamWolf.TeamWolf.client.BL.customerBL;

import TeamWolf.TeamWolf.client.po.CustomerPO;

public interface CustomerOprBLservice {
	public int Customerupdate(CustomerPO po,CustomerPO newpo);
	public int Customeradd(CustomerPO po);
}
