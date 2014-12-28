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
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataService;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.INIPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsStockListVO;
import TeamWolf.TeamWolf.client.vo.GoodsStockVO;
import TeamWolf.TeamWolf.client.vo.INIVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class Initial implements InitialBLservice{
	String URL;
	String goodsURL;
	GoodsBLController gbcontroller;
	INIDATAservice ids;
	GoodsDataService gds;
	ArrayList<INIVO> iList;
	ArrayList<INIPO> pList;
	int beginYear, endYear, beginMonth, endMonth, beginDay, endDay; 
	public Initial(String IP) {
		URL = "rmi://" + IP + "/iniDATAservice";
		goodsURL = "rmi://" + IP + "/goodsDATAservice";
		this.ini();
		this.getINIList();
		gbcontroller = new GoodsBLController(IP);
	}

	public int DoInitial(int number, ArrayList<financeVO> accArray,
			GoodsStockListVO gslArray, ArrayList<CustomerVO> cusArray) {
		try {
			ids = (INIDATAservice) Naming.lookup(URL);
			gds = (GoodsDataService) Naming.lookup(goodsURL);
			ArrayList<GoodsPO> goodsList =  gds.getGoodList();
			for(int i=0;i<goodsList.size();i++){
				goodsList.get(i).setLatestImprice(0);
				goodsList.get(i).setLatestExprice(0);
				gds.updGood(goodsList.get(i));
				gds.updGood(goodsList.get(i));
			}
			int beginDate=beginYear*10000+beginMonth*100+beginDay;
			int endDate=endYear*10000+endMonth*100+endDay;
			gslArray =  gbcontroller.shoStockList(beginDate, endDate);
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
