package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.PromotionPO;
import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
import TeamWolf.TeamWolf.client.vo.TimeVO;

public class Promotion_driver {
	PromotionBLController bc;
	ArrayList<PromotionPO> poList;
	ArrayList<PromotionVO> voList;
	public Promotion_driver(String IP){
		bc = new PromotionBLController(IP);
		
		ArrayList<String> gift = new ArrayList<String>();
		ArrayList<String> send = new ArrayList<String>();
		TimeVO time = new TimeVO("2000", "01", "01");
		ForVIPPromotionVO fVvo = new ForVIPPromotionVO(gift, send, "1000", "500", "1", time, time);
		fVvo.number = "FV_1";
		ForPricePromotionVO fPvo = new ForPricePromotionVO(gift, send, "1000", "100000", time, time);
		SpecialGoodsPromotionVO spvo = new SpecialGoodsPromotionVO(gift, send, "0", time, time);
		System.out.println(bc.addPromotion(fVvo));
		ForVIPPromotionVO fff = (ForVIPPromotionVO)bc.getPromotion(fVvo.number);
		System.out.println(fff.number + " " + fff.discount + " " + fff.cashCoupon + " " + fff.begin.date + " " + fff.end.date);
		
	}
	
	public static void main(String[] args) throws IOException{
		System.out.print("servier IP : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Promotion_driver pd = new Promotion_driver(br.readLine());
		
	}
}
