package TeamWolf.TeamWolf.server.promotionDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.DATAservice.promotionDATAservice.PromotionDATAservice;
import TeamWolf.TeamWolf.client.po.PromotionPO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;
import TeamWolf.TeamWolf.server.logDATA.LogDATA;

public class PromotionDATA extends UnicastRemoteObject implements PromotionDATAservice{
	
	static ArrayList<PromotionPO> list;
	LogDATA log = new LogDATA();
	public PromotionDATA() throws RemoteException {
		super();
		this.getList();
		if(list == null){
			list = new ArrayList<PromotionPO>();
		}
	}

	public int addPromotion(PromotionPO po) throws RemoteException {
		list.add(po);
		try {
			FileOpr.writeFile(FileName.promotionFile, list);
			log.addPromotion(po);
			return 0;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ErrorTW.webError;
	}

	public int delPromotion(String number) throws RemoteException {
		for(int i = 0; i < list.size(); i++){
			if(number.equals(list.get(i).number)){
				log.deletePromotion(list.get(i));
				list.remove(i);
				try {
					FileOpr.writeFile(FileName.promotionFile, list);
					return 0;
				} catch (IOException e) {
					e.printStackTrace();
				}
				return ErrorTW.webError;
			}
		}
		return ErrorTW.notFound;//未找到
	}
	
	public int updPromotion(PromotionPO po) throws RemoteException {//界面层未实现
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).number.equals(po.number)){
				list.get(i).begin = po.begin;
				list.get(i).end = po.end;
				try {
					FileOpr.writeFile(FileName.promotionFile, list);
					return 0;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ErrorTW.notFound;
	}
	public PromotionPO findPromotion(String number) throws RemoteException {
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).number.equals(number)){
				return list.get(i);
			}
		}
		return null;
	}

	public ArrayList<PromotionPO> show() throws RemoteException {
		return list;
	}
	
	@SuppressWarnings("unchecked")
	private void getList(){
		try {
			list = (ArrayList<PromotionPO>)FileOpr.readFile(FileName.promotionFile);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
