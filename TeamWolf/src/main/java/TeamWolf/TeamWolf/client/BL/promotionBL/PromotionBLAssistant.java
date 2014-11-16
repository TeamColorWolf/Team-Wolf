package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodManService;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;

/**
 * 
 * @author WKS
 *
 */
public class PromotionBLAssistant {
	
	GoodManService good = new GoodsBLController();
	Date date;
	final SimpleDateFormat sdf = new  SimpleDateFormat("yyyy/MM/dd");
	public PromotionBLAssistant(){
		Calendar c=Calendar.getInstance();
		date = c.getTime();
		sdf.format(date);
	}
	
	public ArrayList<GoodsVO> getGoodsList (){
		return good.shoGoods().gList;
	}
	
	public Date getDate (){
		return date;
	}
}

