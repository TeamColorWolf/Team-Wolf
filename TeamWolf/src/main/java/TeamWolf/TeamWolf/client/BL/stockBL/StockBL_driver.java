package TeamWolf.TeamWolf.client.BL.stockBL;

import TeamWolf.TeamWolf.client.vo.TypeVO;

public class StockBL_driver {
	
	String IP;
	StockBLController_stub sbc;
	
	public StockBL_driver(String IP){
		this.IP=IP;
		sbc=new StockBLController_stub(IP);
	}
	
	public void driver(){	
		
		TypeVO t=new TypeVO(null, null, null, "照明灯类");
		addType(t);		
		delType(t);
		updType(t);
		shoAllType();
	}
	
	public int addType(TypeVO t){
		return sbc.addType(t);
	}
	
	public int delType(TypeVO t){
		return sbc.delType(t);
	}
	
	public int updType(TypeVO t){
		return sbc.updType(t);
	}
	
	public int shoAllType(){
		if(sbc.shoAllType()!=null)
			return 0;
		else
			return 1111;
	}
	
	public static void main(String[] args){
		
		StockBL_driver sd=new StockBL_driver("IP");
		sd.driver();
	}

}
