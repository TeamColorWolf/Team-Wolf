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
     
     public CustomerController(String IP){
    	 co = new CustomerOpr(IP);
    	 ci = new CustomerInfo(IP);
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
     
    public int ImportListInfoMod(ImportListVO vo) {
		return ci.ImportListInfoMod(vo);
	}
 	public int ImportRejectListMod(ImportRejectListVO vo) {
		return ci.ImportRejectListMod(vo);
	}
 	public int SaleListMod(SaleListVO vo) {
		return ci.SaleListMod(vo);
	}
 	public int SaleRejectListMod(SaleRejectListVO vo) {
		return ci.SaleRejectListMod(vo);
	}
 	public int RecieptListMod(RecieptApplicationVO vo) {
		return ci.RecieptListMod(vo);
	}
 	public int PaymentListMod(PaymentApplicationVO vo) {
		return ci.PaymentListMod(vo);
	}
 	public int CashListMod(CashApplicationVO vo) {
		return ci.CashListMod(vo);
	}
 	public CustomerPO getInfo() {
		return null;
	}
}
