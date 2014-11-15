package TeamWolf.TeamWolf.client.BL.financeBL;

import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.financeDATAservice;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class financeBLAssistant_stub {
	financeDATAservice fds;
	public financeBLAssistant_stub() {
		//
	}
	
    public boolean canAdd(financeVO f){
    	if(f.getName().equals("高蛋"))
    	  return true;
    	else 
    	  return false;  	
    }
    public int canDel(financeVO f){
    	if(f.getName().equals("高蛋"))
    		return 0;
    	else
    		return 1;
    }
    public boolean canUpd(financeVO f){
    	if(f.getName().equals("高蛋"))
    		return true;
    	else
    		return false;    	
    }

}
