package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
import TeamWolf.TeamWolf.client.vo.TimeVO;
import TeamWolf.TeamWolf.client.po.*;

public class PromotionBL_stub extends PromotionBL{

	public PromotionBL_stub(String IP) {
		super(IP);
		// TODO Auto-generated constructor stub
		poList = new ArrayList<PromotionPO>();
		voList = new ArrayList<PromotionVO>();
		TimeVO time = new TimeVO("2000", "01", "01");
		ForVIPPromotionVO vo = new ForVIPPromotionVO(null, null, "1000", "500", "3", time, time);
		ForVIPPromotionPO po = new ForVIPPromotionPO(vo);
		
		poList.add(po);
		voList.add(vo);
	}
	
	public int setForVIP(ForVIPPromotionVO vo) {
		// TODO Auto-generated method stub
		voList.add(vo);
		poList.add(new ForVIPPromotionPO(vo));
		return 0;
	}

	public int setForSpecialGoods(SpecialGoodsPromotionVO vo) {
		// TODO Auto-generated method stub
		voList.add(vo);
		poList.add(new SpecialGoodsPromotionPO(vo));
		return 0;
	}

	public int setForPrice(ForPricePromotionVO vo) {
		// TODO Auto-generated method stub
		voList.add(vo);
		poList.add(new ForPricePromotionPO(vo));
		return 0;
	}

	public PromotionVO getPromotion(String number) {
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
		return vo;
	}

	public ImportListVO adaptPromotionForImportList(ImportListVO vo) {
		// TODO Auto-generated method stub
		return vo;
	}

}
