package TeamWolf.TeamWolf.client.DATAservice.promotionDATAservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.PromotionPO;

public interface PromotionDATAservice {

	public void addPromotion (PromotionPO ppo) throws RemoteException;
	
	public void delPromotion (PromotionPO ppo) throws RemoteException;
	
	public PromotionPO findPromotion (PromotionPO ppo) throws RemoteException;
	
	public ArrayList<PromotionPO> show () throws RemoteException;
	
}
