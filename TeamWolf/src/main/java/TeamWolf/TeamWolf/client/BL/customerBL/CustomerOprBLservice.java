package TeamWolf.TeamWolf.client.BL.customerBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;

public interface CustomerOprBLservice {
	public int Customerupdate(CustomerVO vo);
	public int Customeradd(CustomerVO vo);
	public int Customerdel(String name, String number);
	public ArrayList<CustomerVO> checkCustomerVO(String keyWord, int number);
	public CustomerVO findCustomer(String name);
}
