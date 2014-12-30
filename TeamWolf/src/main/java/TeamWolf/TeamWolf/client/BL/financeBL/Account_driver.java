package TeamWolf.TeamWolf.client.BL.financeBL;

import TeamWolf.TeamWolf.client.vo.financeVO;

//一个driver类
//用去测试驱动
public class Account_driver {
	 String IP;
     financeController_stub fcs = new financeController_stub();
     financeController fc = new financeController(IP);
     
     public Account_driver(String iP) {
		// TODO 自动生成的构造函数存根
	}

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
	
	public int add(financeVO vo){
		return fc.Accountmanage(11, vo,vo);
	}
     
     public static void main(String args[]){
    	 String IP="";
    	 Account_driver ad = new Account_driver(IP);
    	 ad.driver();
     }
}