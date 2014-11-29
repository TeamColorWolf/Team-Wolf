package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import TeamWolf.TeamWolf.client.BL.applicationBL.forStock.PresentList;
import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.BL.stockBL.ExternalService;
import TeamWolf.TeamWolf.client.BL.stockBL.ExternalServiceController;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodManService;
import TeamWolf.TeamWolf.client.po.ForPricePromotionPO;
import TeamWolf.TeamWolf.client.po.ForVIPPromotionPO;
import TeamWolf.TeamWolf.client.po.PromotionPO;
import TeamWolf.TeamWolf.client.po.PromotionTypePO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

/**
 * 
 * @author WKS
 *
 */
public class PromotionBLAssistant {
	ExternalService stockService;
	Date date;
	ArrayList<TypeVO> typeList;
	final SimpleDateFormat sdf = new  SimpleDateFormat("yyyy/MM/dd");
	String IP;
	public PromotionBLAssistant(String IP){
		this.IP = IP;
		Calendar c=Calendar.getInstance();
		date = c.getTime();
		stockService = new ExternalServiceController(IP);
		typeList = stockService.getLeaveType();
	}
	
	public ArrayList<TypeVO> getTypeList(){
		if(typeList == null){
			typeList = stockService.getLeaveType();
		}
		return typeList;
	}
	
	public int creatPresentList(PromotionPO po, CustomerVO customer){
		PresentListVO PL = new PresentListVO();
		if(po.type == PromotionTypePO.forPrice){
			ForPricePromotionPO forPrice = (ForPricePromotionPO)po;
			for(int i = 0; i < forPrice.list.size(); i++){
				GoodsVO vo = stockService.finGoods(forPrice.list.get(i).GoodsNum);
				vo.setAmount(forPrice.list.get(i).sendNumber);
				PL.addPresent(vo);
			}
			PL.setCustomer(customer);
		}
		else if(po.type == PromotionTypePO.forVIP){
			ForVIPPromotionPO forVIP = (ForVIPPromotionPO)po;
			for(int i = 0; i < forVIP.list.size(); i++){
				GoodsVO vo = stockService.finGoods(forVIP.list.get(i).GoodsNum);
				vo.setAmount(forVIP.list.get(i).sendNumber);
				PL.addPresent(vo);
			}
			PL.setCustomer(customer);
		}
		PresentList presentList = new PresentList(PL, IP);
		return presentList.submit();
	}
	
	public GoodsVO findGoods(String number){
		return stockService.finGoods(number);
	}
	
	public Date getDate (){
		return date;
	}
}

