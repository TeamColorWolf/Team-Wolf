package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

public class GiftForPromotionPO implements Serializable{
	public String GoodsName;
	public int sendNumber;
	
	public GiftForPromotionPO(String gName, int number){
		GoodsName = gName;
		sendNumber = number;
	}
}
