package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import TeamWolf.TeamWolf.client.BL.stockBL.ExternalService;
import TeamWolf.TeamWolf.client.BL.stockBL.ExternalServiceController;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

/**
 * 负责promotionBL与其他包的交互（获取商品的数据）和一些零散事项（获取当前时间）
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
	
	public ArrayList<TypeVO> getTypeList(){//获取商品分类叶节点
		if(typeList == null){
			typeList = stockService.getLeaveType();
		}
		for(int i = 0; i < typeList.size(); i++){
			if(typeList.get(i).getName().equals("特价包")){
				typeList.remove(i);
				break;
			}
		}
		return typeList;
	}
	
	public GoodsVO findGoods(String number){//获取具体商品
		return stockService.finGoods(number);
	}
	
	public Date getDate (){
		return date;
	}
}

