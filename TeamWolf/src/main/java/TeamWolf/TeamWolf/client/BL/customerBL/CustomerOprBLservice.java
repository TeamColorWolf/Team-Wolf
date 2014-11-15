package TeamWolf.TeamWolf.client.BL.customerBL;

import TeamWolf.TeamWolf.client.vo.CustomerVO;

public interface CustomerOprBLservice {
	public int Customerupdate(CustomerVO vo,CustomerVO newvo);
	public int Customeradd(CustomerVO vo);
	public int Customerdel(CustomerVO vo);
}
