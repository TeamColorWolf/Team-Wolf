package TeamWolf.TeamWolf.client.BL.customerBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;

public class CustomerController {
     CustomerOpr co;
     
     public CustomerController(CustomerVO vo){
    	 co = new CustomerOpr(vo);
     }
     
     public int addCustomer(CustomerVO vo){
    	 return co.Customeradd(vo);
     }
     
     public int removeCustomer(CustomerVO vo){
    	 return co.Customerdel(vo);
     }
     public int update(CustomerVO vo,CustomerVO newvo){
    	 return co.Customerupdate(vo, newvo);
     }
     public ArrayList<CustomerVO> checkCustomerVO(){
    	 return co.checkCustomerVO();
     }
}
