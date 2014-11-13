package TeamWolf.TeamWolf.client.vo;
/**
 * 
 * @author XYJ
 *
 */
public class GoodsAlarmVO {

	String warningGood;
	String warn;
	
	
	public GoodsAlarmVO(String WG, String warn){
		this.warningGood=WG;
		this.warn=warn;
	}
	
	public String getWarningInfo(){
		return warningGood+warn;
	}
}
