package TeamWolf.TeamWolf.client.BLservice.financeBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.INIPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsStockListVO;
import TeamWolf.TeamWolf.client.vo.INIVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public interface InitialBLservice {
	public int DoInitial(int number,ArrayList<financeVO> accArray,GoodsStockListVO gslArray,
			ArrayList<CustomerVO> cusArray);
	public INIVO FinInitial(int number);
	public ArrayList<INIVO> getINIList();
}
