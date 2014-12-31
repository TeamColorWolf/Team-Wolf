package TeamWolf.TeamWolf.client.BL.financeBL;

import TeamWolf.TeamWolf.client.vo.TimeVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

/**
 * 
 * @author GYQQQQQQQQQQQQQ
 *
 */

//Controller的桩
public class financeController_stub {
     Account_stub as;
     EventView_stub es;
     Initial_stub is ;
     public financeController_stub() {
    	 as = new Account_stub();
    	 is = new Initial_stub();
    	 es = new EventView_stub();
	}
     public int Accountmanage(int operationType,financeVO f){
    	 if(operationType == financeContoller_helper.ACCOUNTADD){
    		 return as.add(f);
    	 }else if(operationType ==financeContoller_helper.ACCOUNTDEL){
    		 return as.delete(f);
    	 }else if(operationType==financeContoller_helper.ACCOUNTUPD){
    		 return as.update(f);
    	 }
		return 0;
     }
     public int Eventview(int operationType){
    	 if(operationType ==financeContoller_helper.VIEWDIRECT){
    		 return es.event();
    	 }else if(operationType == financeContoller_helper.VIEWDATE){
    		 TimeVO t1 =new TimeVO("1999","01","01");
    		 TimeVO t2 =new TimeVO("2015","01","01");
    		 return es.eventDATE(t1, t2);
    	 }else if(operationType == financeContoller_helper.VIEWPEROD){
    		 return es.eventPERIOD();
    	 }
 		return 0;
      }
     public int Initial(int operationType){
    	 if(operationType ==financeContoller_helper.INI){
    		 return is.DoInitial("", "", "","", "", "","");
    	 }
 		return 0;
      }
     public financeVO upd(int operationType){
    	 financeVO f = new financeVO();
    	 if(operationType ==financeContoller_helper.ACCOUNTFIN){
    	   return f;
    	 }else
    		 return f;
     }
      
}
