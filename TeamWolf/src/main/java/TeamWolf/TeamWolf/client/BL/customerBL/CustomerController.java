package TeamWolf.TeamWolf.client.BL.customerBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public class CustomerController {
     CustomerOpr co;
     CustomerInfo ci;
     
     public CustomerController(CustomerVO vo){
    	 co = new CustomerOpr(vo);
    	 ci = new CustomerInfo(vo);
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
     
    public int ImportListInfoMod(ImportListVO vo,CustomerVO cvo) {
		return ci.ImportListInfoMod(vo, cvo);
	}
 	public int ImportRejectListMod(ImportRejectListVO vo,CustomerVO cvo) {
		return ci.ImportRejectListMod(vo, cvo);
	}
 	public int SaleListMod(SaleListVO vo,CustomerVO cvo) {
		return ci.SaleListMod(vo, cvo);
	}
 	public int SaleRejectListMod(SaleRejectListVO vo,CustomerVO cvo) {
		return ci.SaleRejectListMod(vo, cvo);
	}
 	public int RecieptListMod(RecieptApplicationVO vo,CustomerVO cvo) {
		return ci.RecieptListMod(vo, cvo);
	}
 	public int PaymentListMod(PaymentApplicationVO vo,CustomerVO cvo) {
		return ci.PaymentListMod(vo, cvo);
	}
 	public int CashListMod(CashApplicationVO vo,CustomerVO cvo) {
		return ci.CashListMod(vo, cvo);
	}
 	public CustomerPO getInfo() {
		return null;
	}
}
