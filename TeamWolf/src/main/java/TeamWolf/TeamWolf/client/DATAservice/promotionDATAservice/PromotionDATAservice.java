package TeamWolf.TeamWolf.client.DATAservice.promotionDATAservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.PromotionPO;
/**
 * 
 * @author WHJ
 *
 */
public interface PromotionDATAservice {

	public void addPromotion (PromotionPO po) throws RemoteException;
	
	public void delPromotion (PromotionPO po) throws RemoteException;
	
	public PromotionPO findPromotion (PromotionPO po) throws RemoteException;
	
	public ArrayList<PromotionPO> show () throws RemoteException;
	
}
