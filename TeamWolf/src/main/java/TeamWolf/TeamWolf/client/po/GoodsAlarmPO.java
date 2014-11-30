package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

public class GoodsAlarmPO implements Serializable {

	String Date;
	String warningGood;
	String warn;
	
	
	public GoodsAlarmPO(String date, String WG, String warn){
		this.Date=date;
		this.warningGood=WG;
		this.warn=warn;
	}
	
	public String getWarningInfo(){
		return Date+": "+warningGood+" "+warn;
	}
	
	
}
