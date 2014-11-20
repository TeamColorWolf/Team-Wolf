package TeamWolf.TeamWolf.server.promotionDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.promotionDATAservice.PromotionDATAservice;
import TeamWolf.TeamWolf.client.po.PromotionPO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

public class PromotionDATA extends UnicastRemoteObject implements PromotionDATAservice{
	
	static ArrayList<PromotionPO> list;
	
	public PromotionDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.getList();
		if(list == null){
			list = new ArrayList<PromotionPO>();
		}
	}

	public int addPromotion(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		list.add(po);
		try {
			FileOpr.writeFile(FileName.promotionFile, list);
			return 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 30000;
	}

	public int delPromotion(PromotionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i = 0; i < list.size(); i++){
			if(po.number.equals(list.get(i).number)){
				list.remove(i);
				try {
					FileOpr.writeFile(FileName.promotionFile, list);
					return 0;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 30000;
			}
		}
		return 40002;//未找到
	}

	public PromotionPO findPromotion(String number) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).number.equals(number)){
				return list.get(i);
			}
		}
		return null;
	}

	public ArrayList<PromotionPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private void getList(){
		try {
			list = (ArrayList<PromotionPO>)FileOpr.readFile(FileName.promotionFile);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
