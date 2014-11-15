package TeamWolf.TeamWolf.client.BL.customerBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;

public interface CustomerOprBLservice {
	public int Customerupdate(CustomerVO vo,CustomerVO newvo);
	public int Customeradd(CustomerVO vo);
	public int Customerdel(CustomerVO vo);
	public ArrayList<CustomerVO> checkCustomerVO();
	public CustomerVO findCustomer(String name);
}
