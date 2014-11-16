package TeamWolf.TeamWolf.client.BL.stockBL;

import TeamWolf.TeamWolf.client.vo.TypeListVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

public class StockBLController_stub {

    StockBLManager_stub sbm;
    
	
	StockBLController_stub(String IP){
		sbm=new StockBLManager_stub(IP);
	}
	
	public int addType(TypeVO t) {
		// TODO Auto-generated method stub
		return sbm.addType(t);
	}

	public int delType(TypeVO t) {
		// TODO Auto-generated method stub
		return sbm.delType(t);
	}
    
	public int updType(TypeVO t) {
		// TODO Auto-generated method stub
		return sbm.updType(t);
	}

	public TypeListVO shoAllType() {
		// TODO Auto-generated method stub
		return sbm.shoAllType();
	}
}
