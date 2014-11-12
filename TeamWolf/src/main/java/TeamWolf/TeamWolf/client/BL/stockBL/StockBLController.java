package TeamWolf.TeamWolf.client.BL.stockBL;

import TeamWolf.TeamWolf.client.BLservice.stockBLservice.StockBLservice;
import TeamWolf.TeamWolf.client.vo.TypeList;
import TeamWolf.TeamWolf.client.vo.TypeVO;

/**
 * 
 * @author XYJ
 *
 */
public class StockBLController implements StockBLservice{

	StockBLManager sbm;
	
	StockBLController(){
		sbm=new StockBLManager();
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

	public TypeList shoAllType() {
		// TODO Auto-generated method stub
		return sbm.shoAllType();
	}
}
