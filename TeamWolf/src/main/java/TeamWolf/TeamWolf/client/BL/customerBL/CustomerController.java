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

//CustomerCOntroller.
//处理与客户相关的服务
public class CustomerController {
     CustomerOpr co;
     CustomerInfo ci;
     Mock_CustomerOpr mc;
     
     public CustomerController(String IP){
    	 co = new CustomerOpr(IP);
    	 ci = new CustomerInfo(IP);
    	 mc = new Mock_CustomerOpr(IP);
     }
     //增加客户
     public int addCustomer(CustomerVO vo){
    	// return co.Customeradd(vo);
    	 return mc.AddCustomer(vo);
     }
     //删除客户
     public int removeCustomer(CustomerVO cvo){
    	 return co.Customerdel(cvo);
     }
     //修改客户
     public int update(CustomerVO vo, CustomerVO newVO){
    	 return co.Customerupdate(vo, newVO);
     }
     //获取所有客户对象的VO
     public ArrayList<CustomerVO> checkCustomerVO(String keyWord, String num){
    	 return co.checkCustomerVO(keyWord, num);
     }
     //处理进货单引起的客户信息修改
    public int ImportListInfoMod(ImportListVO vo) {
		return ci.ImportListInfoMod(vo);
	}
    //处理进货退货单引起的客户信息修改
 	public int ImportRejectListMod(ImportRejectListVO vo) {
		return ci.ImportRejectListMod(vo);
	}
    //处理销售单引起的客户信息修改
 	public int SaleListMod(SaleListVO vo) {
		return ci.SaleListMod(vo);
	}
    //处理销售退货单引起的客户信息修改
 	public int SaleRejectListMod(SaleRejectListVO vo) {
		return ci.SaleRejectListMod(vo);
	}
    //处理收款单引起的客户信息修改
 	public int RecieptListMod(RecieptApplicationVO vo) {
		return ci.RecieptListMod(vo);
	}
    //处理付款单引起的客户信息修改
 	public int PaymentListMod(PaymentApplicationVO vo) {
		return ci.PaymentListMod(vo);
	}
    //处理现金费用单引起的客户信息修改
 	public int CashListMod(CashApplicationVO vo) {
		return ci.CashListMod(vo);
	}
}
