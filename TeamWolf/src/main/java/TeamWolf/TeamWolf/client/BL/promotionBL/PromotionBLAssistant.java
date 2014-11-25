package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.BL.stockBL.ExternalService;
import TeamWolf.TeamWolf.client.BL.stockBL.ExternalServiceController;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodManService;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
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
	public PromotionBLAssistant(String IP){
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
	
	public Date getDate (){
		return date;
	}
}

