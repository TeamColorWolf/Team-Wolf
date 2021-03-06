package TeamWolf.TeamWolf.client.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import TeamWolf.TeamWolf.client.po.TimePO;

/**
 * 
 * @author WHJ
 *
 */
public class TimeVO {
	public int error;
	public Date date;
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	public TimeVO(String Year, String Month, String Day){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			date = sdf.parse(Year+"/"+Month+"/"+Day);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			error = 20000;
		}
	}
	
	public TimeVO(TimePO po){
		date = po.date;
		error = 0;
	}
	
	public String toString(){
		return sdf.format(date);
	}
	
	public int timeCompare(TimeVO t){
		return date.compareTo(t.date);
	}
}
