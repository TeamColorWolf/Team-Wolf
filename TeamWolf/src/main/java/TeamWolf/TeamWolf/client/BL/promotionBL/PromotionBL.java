package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;
import TeamWolf.TeamWolf.client.DATAservice.promotionDATAservice.PromotionDATAservice;
import TeamWolf.TeamWolf.client.po.ForPricePromotionPO;
import TeamWolf.TeamWolf.client.po.ForVIPPromotionPO;
import TeamWolf.TeamWolf.client.po.PromotionPO;
import TeamWolf.TeamWolf.client.po.PromotionTypePO;
import TeamWolf.TeamWolf.client.po.SpecialGoodsPromotionPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
/**
 * 
 * @author WHJ
 *
 */
public class PromotionBL{
	PromotionDATAservice data;
	PromotionBLAssistant proAssist;
	Date presentDate;
	ArrayList<PromotionPO> poList;
	ArrayList<PromotionVO> voList;
	String URL;
	
	public PromotionBL(String IP){
		URL = "rmi://" + IP + "/promotionDATAservice";
	}
	
	public int setForVIP(ForVIPPromotionVO vo) {
		// TODO Auto-generated method stub
		try {
			data = (PromotionDATAservice)Naming.lookup(URL);
			return data.addPromotion(new ForVIPPromotionPO(vo));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 30000;
	}

	public int setForSpecialGoods(SpecialGoodsPromotionVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int setForPrice(ForPricePromotionVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public PromotionVO getPromotion(String describe) {
		// TODO Auto-generated method stub
		try {
			data = (PromotionDATAservice)Naming.lookup(URL);
			PromotionPO po = data.findPromotion(describe);
			if(po.type == PromotionTypePO.forVIP){
				return new ForVIPPromotionVO((ForVIPPromotionPO)po);
			}
			else if(po.type == PromotionTypePO.forPrice){
				return new ForPricePromotionVO((ForPricePromotionPO)po);
			}
			else if(po.type == PromotionTypePO.specialGoods){
				return new SpecialGoodsPromotionVO((SpecialGoodsPromotionPO)po);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int delet(PromotionVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int update(PromotionVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<PromotionVO> check() {
		// TODO Auto-generated method stub
		return voList;
	}

	public SaleListVO adaptPromotionForSaleList(SaleListVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ImportListVO adaptPromotionForImportList(ImportListVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
