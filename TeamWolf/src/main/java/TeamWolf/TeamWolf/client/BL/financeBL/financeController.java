package TeamWolf.TeamWolf.client.BL.financeBL;

import TeamWolf.TeamWolf.client.vo.TimeVO;
import TeamWolf.TeamWolf.client.vo.financeVO;
/**
 * 
 * @author GYQQQQ
 *
 */
public class financeController {
	  Account as;
	  Eventview es;
	  Initial is ;
	  String IP;
	  public financeController(String IP) {
	    	 as = new Account(IP);
	    	 is = new Initial(IP);
	    	 es = new Eventview(IP);
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
     public int Tablemanage(int operationType, Table t){
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
      
     public financeVO upd(){
    	 financeVO f =new financeVO();
    	 return f;
     }     
}
