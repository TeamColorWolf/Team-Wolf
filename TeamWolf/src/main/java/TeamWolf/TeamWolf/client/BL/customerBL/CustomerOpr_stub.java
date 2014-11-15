package TeamWolf.TeamWolf.client.BL.customerBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.CustomerVO;
	
//stub of customer
//Actually I think is means nothing.......FTW
public class CustomerOpr_stub extends CustomerOpr{

	public CustomerOpr_stub(String IP) {
		super(IP);
		// TODO 自动生成的构造函数存根
	}
	     
	     public int addCustomer(CustomerVO vo){
	    	 if(vo.getName().equals("GD")){
	    		 System.out.println("ADD GAODAN");
	    		 return 0;
	    	 }else
	    		 return -1;
	     }
	     
	     public int removeCustomer(CustomerVO vo){
	    	 if(vo.getName().equals("FTW")){
	    		 System.out.println("REMOVE GAODAN");
	    		 return 0;
	    	 }else
	    		 return -1;
	     }
	     public int update(CustomerVO vo,CustomerVO newvo){
	    	 if(vo.getName().equals("GD")&&newvo.getName().equals("GAODAN")){
	    		 System.out.println("UPD GAODAN");
	    		 return 0;
	    	 }else
	    		 return -1;
	     }
	     public ArrayList<CustomerVO> checkCustomerVO(){
	    	 CustomerVO GD = new CustomerVO("", "", "", "GD", "", "", "", "", "", "", "", "");
	    	 CustomerVO GD2 = new CustomerVO("", "", "", "GAODAN", "", "", "", "", "", "", "", "");
	    	 CustomerVO GD3 = new CustomerVO("", "", "", "FTW", "", "", "", "", "", "", "", "");
	    	 CustomerVO GD4 = new CustomerVO("", "", "", "WAM", "", "", "", "", "", "", "", "");
	    	 ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();
	    	 list.add(GD);
	    	 list.add(GD2);
	    	 list.add(GD3);
	    	 list.add(GD4);
	    	 return list;
	     }
	     

	
}