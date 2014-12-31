package TeamWolf.TeamWolf.client.BL.financeBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BLservice.financeBLservice.AccountBlservice;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsStockListVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.TimeVO;
import TeamWolf.TeamWolf.client.vo.financeVO;
/**
 * 
 * @author GYQQQQ
 *
 */
//Controller
//处理各类账户相关请求
public class financeController implements AccountBlservice ,AccountInfoBLservice{
	  Account as;
	  AccountInfo ai;
	  Eventview es;
	  Initial is ;
	  Table t;
	  String IP;
	  Mock_finance mf;
	  //构造方法
	  public financeController(String IP) {
	    	 as = new Account(IP);
	    	 is = new Initial(IP);
	    	 es = new Eventview(IP);
	    	 t = new Table(IP);
	    	 mf = new Mock_finance(IP);
	    	 ai = new AccountInfo(IP);
		}
	 //账户管理方法
	 //用于处理某些桩和驱动的内容
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
     //账户单据处理
     //已经废弃，只在桩中出现
     //相关功能已经转移
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
     //操作日志查看
     //已经废弃，只在桩中出现
     //相关功能已经转移
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
     //期初建账管理
     public int Initial(int operationType,int number, ArrayList<financeVO> accArray,
				GoodsStockListVO gslArray, ArrayList<CustomerVO> cusArray){
    	 if(operationType == financeContoller_helper.INI){
    		 return is.DoInitial(number,accArray,
    					gslArray, cusArray);
    	 }
 		return 0;
      }
      

     //Controller账户增加
	public int add(financeVO vo) {
		return as.add(vo);
	}
//Controller账户删除
	public int delete(financeVO vo) {
		 return as.delete(vo);
	}
	//Controller账户更新

	public int update(financeVO vo, financeVO newvo) {
  		 return as.update(vo,newvo);
	}

	//Controller账户查找
	public financeVO find(financeVO vo) {
		return as.find(vo);
	}

	//Controller获取所有账户对象VO
	public ArrayList<financeVO> checkVO() {
		return as.checkVO();
	}

	//COntroller处理收款单引起的账户变化
	public int RecieptMod(RecieptApplicationVO vo) {
		// TODO 自动生成的方法存根
		return ai.RecieptMod(vo);
	}
	//COntroller处理付款单引起的账户变化
	public int PaymentMod(PaymentApplicationVO vo) {
		// TODO 自动生成的方法存根
		return ai.PaymentMod(vo);
	}
	//COntroller处理现金费用单引起的账户变化
	public int CashMod(CashApplicationVO vo) {
		// TODO 自动生成的方法存根
		return ai.CashMod(vo);
	}     
}
