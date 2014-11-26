package TeamWolf.TeamWolf.client.BL.financeBL;

import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.financeDATAservice;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class financeBLAssistant {
	financeDATAservice fds;
	
    public boolean canAdd(financeVO f){	
    	try {
    		financePO po =new financePO(f);
    		if(fds.find(po)!=null)
				return false;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	return true;
    }
    public boolean canDel(financeVO f){
    	financePO po = new financePO(f);
    	try {
			if(fds.find(po)==null||fds.find(po).getAccount()!=0){
				return false;
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	return true;
    			}
    public boolean canUpd(financeVO f , financeVO newf){
    	financePO po = new financePO(f);
    	financePO newpo = new financePO(newf);
    	try {
			if(fds.find(po)==null&&fds.find(newpo)==null){
				return true;
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    		return true;
    }
}
