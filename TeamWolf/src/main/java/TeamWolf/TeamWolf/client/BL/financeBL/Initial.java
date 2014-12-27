package TeamWolf.TeamWolf.client.BL.financeBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOprBLservice;
import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.AccountBlservice;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.InitialBLservice;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodManService;
import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.INIDATAservice;
import TeamWolf.TeamWolf.client.po.INIPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsStockListVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class Initial implements InitialBLservice{
	INIDATAservice ids;
	AccountBlservice abs;
	CustomerOprBLservice cobs;
	GoodManService gms;
	public Initial(String iP) {
		// TODO 自动生成的构造函数存根
	}

	public int DoInitial(int number, ArrayList<financeVO> accArray,
			GoodsStockListVO gslArray, ArrayList<CustomerVO> cusArray) {
		// TODO 自动生成的方法存根
		return 0;
	}
	
	public int FinInitial(int number){
		return 0;		
	}



}
