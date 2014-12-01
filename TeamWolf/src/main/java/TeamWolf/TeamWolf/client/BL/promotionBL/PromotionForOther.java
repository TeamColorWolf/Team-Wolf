package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.promotionDATAservice.PromotionDATAservice;
import TeamWolf.TeamWolf.client.po.ForPricePromotionPO;
import TeamWolf.TeamWolf.client.po.ForVIPPromotionPO;
import TeamWolf.TeamWolf.client.po.PromotionPO;
import TeamWolf.TeamWolf.client.po.PromotionTypePO;
import TeamWolf.TeamWolf.client.po.SpecialGoodsPromotionPO;
import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.PromotionTypeVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;

public class PromotionForOther {
	PromotionDATAservice data;
	ArrayList<PromotionPO> poList;
	ArrayList<PromotionVO> voList;
	String URL;
	
	public PromotionForOther(String IP){
		URL = "rmi://" + IP + "/promotionDATAservice";
	}
	
	public SaleListVO adaptPromotionForSaleList(SaleListVO vo) {
		// TODO Auto-generated method stub
		initial();
		return null;
	}

	public ImportListVO adaptPromotionForImportList(ImportListVO vo) {
		// TODO Auto-generated method stub
		initial();
		return null;
	}
	
	public ArrayList<SpecialGoodsPromotionVO> specialGoodsPackage() {
		initial();
		ArrayList<SpecialGoodsPromotionVO> list = new ArrayList<SpecialGoodsPromotionVO>();
		if(voList != null){
			for(int i = 0; i < voList.size(); i++){
				if(voList.get(i).type == PromotionTypeVO.specialGoods){
					list.add((SpecialGoodsPromotionVO)voList.get(i));
				}
			}
		}
		return list;
	}
	
	private void initial(){
		try {
			data = (PromotionDATAservice)Naming.lookup(URL);
			poList = data.show();
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
		if(poList == null){
			poList = new ArrayList<PromotionPO>();
		}
		voList = new ArrayList<PromotionVO>();
		for(int i = 0; i < poList.size(); i++){
			PromotionVO vo = this.getVOfromPO(poList.get(i));
			voList.add(vo);
		}
	}
	
	private PromotionVO getVOfromPO(PromotionPO po){
		if(po.type == PromotionTypePO.forVIP){
			return new ForVIPPromotionVO((ForVIPPromotionPO)po);
		}
		else if(po.type == PromotionTypePO.forPrice){
			return new ForPricePromotionVO((ForPricePromotionPO)po);
		}
		else if(po.type == PromotionTypePO.specialGoods){
			return new SpecialGoodsPromotionVO((SpecialGoodsPromotionPO)po);
		}
		return null;
	}
}