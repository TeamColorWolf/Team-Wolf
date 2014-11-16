package TeamWolf.TeamWolf.client.BL.stockBL;

import TeamWolf.TeamWolf.client.BLservice.stockBLservice.StockBLservice;
import TeamWolf.TeamWolf.client.vo.TypeListVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

/**
 * 
 * @author XYJ
 *
 */
public class StockBLController implements StockBLservice{

	
	StockBLManager sbm;
	
    public	StockBLController(String IP){
		sbm=new StockBLManager(IP);
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
