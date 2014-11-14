package TeamWolf.TeamWolf.client.BL.stockBL;

import TeamWolf.TeamWolf.client.vo.TypeVO;

public class StockBL_driver {
	
	StockBLController_stub sbc=new StockBLController_stub();
	
	public void driver(){
		
		TypeVO t=new TypeVO(null, null, null, "飞利浦电灯");
		
		sbc.addType(t);
		sbc.updType(t);
		sbc.delType(t);
		sbc.shoAllType();
	}
	
	public static void main(String[] args){
		
		StockBL_driver sd=new StockBL_driver();
		sd.driver();
	}

}
