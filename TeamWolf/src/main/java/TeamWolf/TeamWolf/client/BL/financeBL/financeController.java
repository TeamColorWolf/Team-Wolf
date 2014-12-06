package TeamWolf.TeamWolf.client.BL.financeBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.financeBLservice.AccountBlservice;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.TimeVO;
import TeamWolf.TeamWolf.client.vo.financeVO;
/**
 * 
 * @author GYQQQQ
 *
 */
public class financeController implements AccountBlservice ,AccountInfoBLservice{
	  Account as;
	  AccountInfo ai;
	  Eventview es;
	  Initial is ;
	  Table t;
	  String IP;
	  Mock_finance mf;
	  public financeController(String IP) {
	    	 as = new Account(IP);
	    	 is = new Initial(IP);
	    	 es = new Eventview(IP);
	    	 t = new Table(IP);
	    	 mf = new Mock_finance(IP);
	    	 ai = new AccountInfo(IP);
		}
	
     public int Accountmanage(int operationType,financeVO f,financeVO newf){
    	 if(operationType == financeContoller_helper.ACCOUNTADD){
    		 return as.add(f);
    	 }else if(operationType ==financeContoller_helper.ACCOUNTDEL){
    		 return as.delete(f);
    	 }else if(operationType==financeContoller_helper.ACCOUNTUPD){
    		 return as.update(f,newf);
    	 }
		return 0;
     }
     public int Tablemanage(int operationType, Table t,PaymentApplicationVO pvo,RecieptApplicationVO rvo,CashApplicationVO cvo){
    	 if(operationType == financeContoller_helper.TABLECASH){
    		 return t.CreateCash(cvo);
    	 }else if(operationType ==financeContoller_helper.TABLEPAYMENT){
    		 return t.CreatePayment(pvo);
    	 }else if(operationType==financeContoller_helper.TABLERECEIPT){
    		 return t.CreateReceipt(rvo);
    	 }
 		return 0;
      }
     public int Eventview(int operationType,TimeVO vo1,TimeVO vo2){
    	 if(operationType == financeContoller_helper.VIEWDIRECT){
    		 return es.event();
    	 }else if(operationType == financeContoller_helper.VIEWPEROD){
    		 return es.eventPERIOD();
    	 }else if(operationType == financeContoller_helper.VIEWDATE){
    		return es.eventDATE(vo1, vo2); 
    	 }
 		return 0;
      }
     public int Initial(int operationType,String commodityType, String commodity, String Type,
 			String number, String customerType, String customer,
 			String customerConnect){
    	 if(operationType == financeContoller_helper.INI){
    		 return is.DoInitial(commodityType, commodity, Type, number, customerType, customer, customerConnect);
    	 }
 		return 0;
      }
      

	public int add(financeVO vo) {
		return as.add(vo);
	}

	public int delete(financeVO vo) {
		 return as.delete(vo);
	}

	public int update(financeVO vo, financeVO newvo) {
  		 return as.update(vo,newvo);
	}

	public financeVO find(financeVO vo) {
		return as.find(vo);
	}

	public ArrayList<financeVO> checkVO() {
		return as.checkVO();
	}

	public int RecieptMod(RecieptApplicationVO vo) {
		// TODO 自动生成的方法存根
		return ai.RecieptMod(vo);
	}

	public int PaymentMod(PaymentApplicationVO vo) {
		// TODO 自动生成的方法存根
		return ai.PaymentMod(vo);
	}

	public int CashMod(CashApplicationVO vo) {
		// TODO 自动生成的方法存根
		return ai.CashMod(vo);
	}     
}
