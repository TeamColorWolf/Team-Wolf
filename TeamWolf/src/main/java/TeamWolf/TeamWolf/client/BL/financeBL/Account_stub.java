package TeamWolf.TeamWolf.client.BL.financeBL;

import TeamWolf.TeamWolf.client.vo.financeVO;

/**
 * 
 * @author GYQ
 *
 */
public class Account_stub {
    financeBLAssistant_stub fbas;
    
    public Account_stub() {
	    fbas = new financeBLAssistant_stub();
	}
    
    public int add(financeVO f){
    	if(fbas.canAdd(f)){
    		System.out.println("Success add GaoDan");
    	}else{
    		
    	}
    	return 0;
    }
    
    public int del(financeVO f){
    	if(fbas.canDel(f)==0){
    		System.out.println("Success del Gaodan");
    	}else{
    		
    	}
    	return 0;
    }
    public int upd(financeVO f){
    	if(fbas.canUpd(f)){
    		System.out.println("Success upd GD");
    	}else{
    		
    	}
    	return 0;
    } 
    public financeVO find(){
    	financeVO f = new financeVO();
    	System.out.println("GEt GAodan");
    	return f;
    }
}
