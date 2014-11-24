package TeamWolf.TeamWolf.client.BL.stockBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.TypeVO;

public class ExternalServiceController implements ExternalService{

	StockBLManager man;
	String IP;
	
	public ExternalServiceController(String IP){
		this.IP=IP;
		man=new StockBLManager(IP);
	}
	
	public ArrayList<TypeVO> getLeaveType() {
		// TODO Auto-generated method stub
		return man.getLeaveType();
	}

}
