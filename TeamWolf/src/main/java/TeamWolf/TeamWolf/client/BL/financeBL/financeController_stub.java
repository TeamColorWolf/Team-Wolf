package TeamWolf.TeamWolf.client.BL.financeBL;

import TeamWolf.TeamWolf.client.vo.financeVO;

/**
 * 
 * @author GYQQQQQQQQQQQQQ
 *
 */
public class financeController_stub {
     Account_stub as;
     public financeController_stub() {
    	 as = new Account_stub();
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
     public int Tablemanage(int operationType, Table t){
 		return 0;
      }
     public int Eventview(int operationType){
 		return 0;
      }
     public int Initial(){
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
