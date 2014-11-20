package TeamWolf.TeamWolf.client.DATAservice.promotionDATAservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.PromotionPO;
/**
 * 
 * @author WHJ
 *
 */
public interface PromotionDATAservice extends Remote{

	public int addPromotion (PromotionPO po) throws RemoteException;
	
	public int delPromotion (PromotionPO po) throws RemoteException;
	
	public PromotionPO findPromotion (String number) throws RemoteException;
	
	public ArrayList<PromotionPO> show () throws RemoteException;
	
}
