package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.forStock.PresentList;
import TeamWolf.TeamWolf.client.BL.stockBL.ExternalService;
import TeamWolf.TeamWolf.client.BL.stockBL.ExternalServiceController;
import TeamWolf.TeamWolf.client.DATAservice.promotionDATAservice.PromotionDATAservice;
import TeamWolf.TeamWolf.client.po.ForPricePromotionPO;
import TeamWolf.TeamWolf.client.po.ForVIPPromotionPO;
import TeamWolf.TeamWolf.client.po.PromotionPO;
import TeamWolf.TeamWolf.client.po.PromotionTypePO;
import TeamWolf.TeamWolf.client.po.SpecialGoodsPromotionPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.GiftForPromotionVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;
import TeamWolf.TeamWolf.client.vo.PromotionTypeVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
import TeamWolf.TeamWolf.client.vo.TimeVO;

public class PromotionForOther {
	PromotionDATAservice data;
	ExternalService stockService;
	ArrayList<PromotionVO> voList;
	String URL;
	String IP;
	
	public PromotionForOther(String IP){
		this.IP = IP;
		URL = "rmi://" + IP + "/promotionDATAservice";
		initial();
	}
	
	public double adaptPromotionForSaleList(SaleListVO vo) {
		// TODO Auto-generated method stub
		initial();
		int rank = vo.getCustomer().getLevel();
		double total = vo.getTotal();
		double discount = vo.getDiscount();
		ArrayList<GiftForPromotionVO> giftlist = new ArrayList<GiftForPromotionVO>();
		TimeVO time = getTime(vo);
		for(int i = 0; i < voList.size(); i++){
			PromotionVO p = voList.get(i);
			if(p.begin.timeCompare(time) < 0 && p.end.timeCompare(time) > 0){
				if(p.type == PromotionTypeVO.forVIP){//对forVIP进行的操作
					ForVIPPromotionVO f = (ForVIPPromotionVO)p;
					if(rank >= f.VIPrank){
						for(int j = 0; j < f.list.size(); j++){
							giftlist.add(f.list.get(j));
						}
						discount += f.discount;
					}
				}
				if(p.type == PromotionTypeVO.forPrice){//对forPrice进行的操作
					ForPricePromotionVO f = (ForPricePromotionVO)p;
					if(f.workCondition <= total){
						for(int j = 0; j < f.list.size(); j++){
							giftlist.add(f.list.get(j));
						}
					}
				}
			}
		}
		if(giftlist.size() != 0){//TODO 生成库存赠送单
			creatPresentList(giftlist, vo.getCustomer());
		}
		return discount;
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
		ArrayList<PromotionPO> poList = null;
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
	
	private void creatPresentList(ArrayList<GiftForPromotionVO> gift, CustomerVO cus){
		stockService = new ExternalServiceController(IP);
		PresentListVO PL = new PresentListVO();
		for(int i = 0; i < gift.size(); i++){
			GoodsVO vo = new GoodsVO(null, null, gift.get(i).GoodsName, null, null, gift.get(i).sendNumber+"", null, null, null, null, null);
			PL.addPresent(vo);
		}
		PL.setCustomer(cus);
		new PresentList(PL, IP).submit();
	}
	
	private TimeVO getTime(SaleListVO vo){
		String[] n = vo.number.split("-");
		return new TimeVO(n[1].substring(0, 4), n[1].substring(4, 6), n[1].substring(6, 8));
	}
}
