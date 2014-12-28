package TeamWolf.TeamWolf.client.BL.financeBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
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
import TeamWolf.TeamWolf.client.vo.INIVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class Initial implements InitialBLservice{
	String URL;
	INIDATAservice ids;
	ArrayList<INIVO> iList;
	ArrayList<INIPO> pList;
	public Initial(String IP) {
		URL = "rmi://" + IP + "/iniDATAservice";
		this.ini();
		this.getINIList();
	}

	public int DoInitial(int number, ArrayList<financeVO> accArray,
			GoodsStockListVO gslArray, ArrayList<CustomerVO> cusArray) {
		try {
			ids = (INIDATAservice) Naming.lookup(URL);
			INIPO po = new INIPO(number,accArray,gslArray,cusArray); 
			ids.insert(po);
			iList.add(new INIVO(po));
			pList.add(po);
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}
	
	public INIVO FinInitial(int number){
		try {
			ids = (INIDATAservice) Naming.lookup(URL);
			if(ids.find(number)==null){
				return null;
			}else{
				return new INIVO(ids.find(number));
			}
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<INIVO> getINIList() {
		if(iList==null){
			try {
				ids = (INIDATAservice) Naming.lookup(URL);
				pList = ids.getINIList();
				iList = new ArrayList<INIVO>();
				for(int i=0;i<pList.size();i++){
					INIVO vo = new INIVO(pList.get(i));
					iList.add(vo);
				}
			} catch (MalformedURLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return iList;	
	}
	
	private void ini(){
		try {
			ids = (INIDATAservice) Naming.lookup(URL);
			pList = ids.getINIList();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}



}
