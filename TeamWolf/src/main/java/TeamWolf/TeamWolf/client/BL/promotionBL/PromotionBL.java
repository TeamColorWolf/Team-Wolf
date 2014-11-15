package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;
import TeamWolf.TeamWolf.client.DATAservice.promotionDATAservice.PromotionDATAservice;
import TeamWolf.TeamWolf.client.po.PromotionPO;
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
		try {
			data = (PromotionDATAservice)Naming.lookup(URL);
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
	}
	
//	public PromotionBL(){
//		proAssist = new PromotionBLAssistant();
//		presentDate = new Date();
//	}
//
//	public int createForVIP(CustomerVO cvo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int createGoods(GoodsVO gvo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int createGifts(GoodsVO gvo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int createDiscount(String num) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int createCashCoupon(String discount) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public ArrayList<PromotionVO> show() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public int setForVIP(ForVIPPromotionVO vo) {
		// TODO Auto-generated method stub
		return 0;
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
