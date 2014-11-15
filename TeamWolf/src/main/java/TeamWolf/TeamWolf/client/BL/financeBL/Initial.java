package TeamWolf.TeamWolf.client.BL.financeBL;

import java.rmi.RemoteException;

import TeamWolf.TeamWolf.client.BLservice.financeBLservice.InitialBLservice;
import TeamWolf.TeamWolf.client.DATAservice.financeDATAservice.INIDATAservice;
import TeamWolf.TeamWolf.client.po.INIPO;

public class Initial implements InitialBLservice{
	INIDATAservice ids;
	public Initial(String iP) {
		// TODO 自动生成的构造函数存根
	}

	public int DoInitial(String commodityType, String commodity, String Type,
			String number, String customerType, String customer,
			String customerConnect) {
		INIPO po = new INIPO(commodityType,commodity,Type,number,customerType,customer,customerConnect);
		try {
			ids.insert(po);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}

}
