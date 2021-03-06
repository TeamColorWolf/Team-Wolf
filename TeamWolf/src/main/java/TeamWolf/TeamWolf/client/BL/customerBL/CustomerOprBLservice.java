package TeamWolf.TeamWolf.client.BL.customerBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;

//接口
//处理客户信息的增删改查
public interface CustomerOprBLservice {
	public int Customerupdate(CustomerVO vo,CustomerVO newVO);
	public int Customeradd(CustomerVO vo);
	public int Customerdel(CustomerVO cvo);
	public ArrayList<CustomerVO> checkCustomerVO(String keyWord, String number);
	public CustomerVO findCustomer(String name,String number);
	public CustomerVO findCustomer(String nameOrnumber);
	public ArrayList<CustomerVO> getAllCustomerList();
}
