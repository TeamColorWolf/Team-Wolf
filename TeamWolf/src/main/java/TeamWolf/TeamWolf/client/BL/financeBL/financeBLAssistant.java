package TeamWolf.TeamWolf.client.BL.financeBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.financeDATAservice;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.client.vo.financeVO;


public class financeBLAssistant {
	financeDATAservice fds;
    String URL;	
    public financeBLAssistant(String IP){
    	URL = "rmi://" + IP + "/financeDATAservice";
    }
    public boolean canAdd(financeVO f){	
    	try {
    		fds = (financeDATAservice)Naming.lookup(URL);
    		financePO po =new financePO(f);
    		if(fds.find(po)!=null)
				return false;
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	return true;
    }
    public boolean canDel(financeVO f){
    	try {
			fds = (financeDATAservice)Naming.lookup(URL);
		} catch (MalformedURLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
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
    	try {
			fds = (financeDATAservice)Naming.lookup(URL);
		} catch (MalformedURLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
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
