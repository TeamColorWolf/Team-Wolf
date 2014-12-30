package TeamWolf.TeamWolf.client.BL.stockBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.GiftForPromotionVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

/**
 * 此接口包含库存模块对外部模块提供的功能
 * @author XYJ
 *
 */
public interface ExternalService {

	//获取所有的叶节点商品分类
	public ArrayList<TypeVO> getLeaveType();
	
	public GoodsVO finGoods(String number);
	
	//增加特价包
	public int addSpecialPackage (SpecialGoodsPromotionVO sp);	

	public int handlePresentList(ArrayList<GiftForPromotionVO> gpl, String customer);
}
