package TeamWolf.TeamWolf.client.BL.financeBL;

import TeamWolf.TeamWolf.client.vo.financeVO;

public class Account_driver {
     financeController_stub fcs = new financeController_stub();

     public void driver(){
    	 
    	 financeVO f= new financeVO("高蛋",0);
    	 
    	 fcs.Accountmanage(11, f);
    	 fcs.Accountmanage(12, f);
    	 fcs.Accountmanage(13, f);
    	 fcs.upd(14);
         fcs.Eventview(31);
         fcs.Eventview(32);
         fcs.Eventview(33);
         fcs.Initial(41);   	 
     }
     
     public static void main(String args[]){
    	 Account_driver ad = new Account_driver();
    	 ad.driver();
     }
}