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
//Customer的driver
public class Customer_driver {
    CustomerController controller;
    ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
	 CustomerVO GD = new CustomerVO("", "", "", "GD", "", "", "", "", "", "", "", "");
	 CustomerVO GD2 = new CustomerVO("", "", "", "GAODAN", "", "", "", "", "", "", "", "");
	 CustomerVO GD3 = new CustomerVO("", "", "", "FTW", "", "", "", "", "", "", "", "");
	 CustomerVO GD4 = new CustomerVO("", "", "", "WAM", "", "", "", "", "", "", "", "");
	 
	 public Customer_driver(String IP){
		 controller = new CustomerController(IP);
		 this.addCustomer(GD);
		 this.removeCustomer(GD3);
		 this.update(GD, GD2);
		 list = this.checkCustomerVO(GD.getName(), GD.getNum());
	 }
	 
     public int addCustomer(CustomerVO vo){
    	 return controller.addCustomer(vo);
     }
     
     public int removeCustomer(CustomerVO cvo){
    	 return controller.removeCustomer(cvo);
     }
     public int update(CustomerVO vo,CustomerVO newvo){
    	 return controller.update(vo, newvo);
     }
     public ArrayList<CustomerVO> checkCustomerVO(String keyWord, String num){
    	 return controller.checkCustomerVO(keyWord, num);
     }
     
    public int ImportListInfoMod(ImportListVO vo) {
		return controller.ImportListInfoMod(vo);
	}
 	public int ImportRejectListMod(ImportRejectListVO vo) {
		return controller.ImportRejectListMod(vo);
	}
 	public int SaleListMod(SaleListVO vo) {
		return controller.SaleListMod(vo);
	}
 	public int SaleRejectListMod(SaleRejectListVO vo) {
		return controller.SaleRejectListMod(vo);
	}
 	public int RecieptListMod(RecieptApplicationVO vo) {
		return controller.RecieptListMod(vo);
	}
 	public int PaymentListMod(PaymentApplicationVO vo) {
		return controller.PaymentListMod(vo);
	}
 	public int CashListMod(CashApplicationVO vo) {
		return controller.CashListMod(vo);
	}
 	public CustomerPO getInfo() {
		return null;
	}
 	
 	public static void main(String[]args){
 		Customer_driver cd = new Customer_driver("00");
 	   
 		
 	}
}
