package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;
/**
 * 
 * @author WHJ
 *
 */
public class PromotionVO {
	public PromotionTypeVO type;
	public int error;
	public TimeVO begin;
	public TimeVO end;
	public String number;
	public PromotionVO(PromotionTypeVO t, TimeVO Begin, TimeVO End){
		error = 0;
		type = t;
		begin = Begin;
		end = End;
		if(timeCompare(begin, end) > 0){
			error = 20001;//结束时间长于开始时间
		}
	}
	
	private int timeCompare(TimeVO time1, TimeVO time2){
		return time1.date.compareTo(time2.date);
	}
	
	protected double string_to_double(String d){
		double t = -1;
		try{
			t = Double.parseDouble(d);
			if(t < 0){
				error = 10010;//必须输入正数
			}
		}catch(Exception e){
			error = 10000;//必须输入数字
		}
		return t;
	}
	
	protected int string_to_int(String i){
		int t = -1;
		try{
			t = Integer.parseInt(i);
			if(t < 0){
				error = 10010;//必须输入正数
			}
		}catch(Exception e){
			error = 10001;//必须输入整数
		}
		return t;
	}
	
	protected ArrayList<GiftForPromotionVO> setGiftList(ArrayList<String> gNameList, ArrayList<String> sendNum){
		ArrayList<GiftForPromotionVO> list = new ArrayList<GiftForPromotionVO>();
		if(gNameList != null)
			for(int i = 0; i < gNameList.size(); i++){
				int send = string_to_int(sendNum.get(i));
				GiftForPromotionVO vo = new GiftForPromotionVO(gNameList.get(i), send);
				list.add(vo);
			}
		return list;
	}
	
}
