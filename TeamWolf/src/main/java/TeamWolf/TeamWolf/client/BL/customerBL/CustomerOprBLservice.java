package TeamWolf.TeamWolf.client.BL.customerBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;

public interface CustomerOprBLservice {
	public int Customerupdate(CustomerVO vo,CustomerVO newVO);
	public int Customeradd(CustomerVO vo);
	public int Customerdel(CustomerVO cvo);
	public ArrayList<CustomerVO> checkCustomerVO(String keyWord, String number);
	public CustomerVO findCustomer(String name);
}
