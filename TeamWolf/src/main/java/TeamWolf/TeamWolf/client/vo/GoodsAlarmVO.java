package TeamWolf.TeamWolf.client.vo;

import TeamWolf.TeamWolf.client.po.GoodsAlarmPO;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsAlarmVO {

	
	String Info;
	
	
	public GoodsAlarmVO(GoodsAlarmPO ga){
		this.Info=ga.getWarningInfo();
	}
	
	public String getWarningInfo(){
		return Info;
	}
}
