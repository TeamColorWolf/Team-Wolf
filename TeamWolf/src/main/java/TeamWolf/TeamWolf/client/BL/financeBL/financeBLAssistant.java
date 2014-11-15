package TeamWolf.TeamWolf.client.BL.financeBL;

import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.financeDATAservice;
import TeamWolf.TeamWolf.client.po.financePO;

public class financeBLAssistant {
	financeDATAservice fds;
	
    public boolean canAdd(financePO f){	
    	try {
    		if(fds.find(f.getName())==null)
				return false;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	return true;
    }
    public int canDel(financePO f){
    	return 0;
    			}
    public boolean canUpd(financePO f){
    		return true;
    }
}
