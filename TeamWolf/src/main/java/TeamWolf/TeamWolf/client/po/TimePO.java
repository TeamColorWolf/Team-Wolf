package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;
import java.util.Date;

import TeamWolf.TeamWolf.client.vo.TimeVO;
/**
 * 
 * @author WHJ
 *
 */
public class TimePO implements Serializable{
	Date date;
	public TimePO(TimeVO vo){
		date = vo.date;
	}
	
	public int timeCompare(TimePO t){
		return date.compareTo(t.date);
	}
}
