package TeamWolf.TeamWolf.server.goodsDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataService;
import TeamWolf.TeamWolf.client.po.GoodsAlarmPO;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.TypePO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

public class GoodsData extends UnicastRemoteObject implements GoodsDataService {

	ArrayList<GoodsPO> goodsList;
	ArrayList<GoodsAlarmPO> alarmList;
	
	
	public GoodsData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.initial();
		if(goodsList==null){
			goodsList=new ArrayList<GoodsPO>();
		}
		if(alarmList==null){
			alarmList=new ArrayList<GoodsAlarmPO>();
		}
	}

	public int addGood(GoodsPO g) throws RemoteException {
		// TODO Auto-generated method stub
		goodsList.add(g);
		try {
			FileOpr.writeFile(FileName.goodsFile, goodsList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回文件读写错误
		}
		return 0;
	}

	public int delGood(String number) throws RemoteException {
		// TODO Auto-generated method stub
		GoodsPO toDel=null;
		for(GoodsPO g: goodsList){
		   if(g.getNumber().equals(number)){
			   toDel=g;
			   break;
		   }
		}
		if(toDel!=null){
			goodsList.remove(toDel);
			try {
				FileOpr.writeFile(FileName.goodsFile, goodsList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//返回文件读写错误
			}
		}
		return 0;
	}

	public int updGood(GoodsPO g) throws RemoteException {
		// TODO Auto-generated method stub
		for(GoodsPO gg: goodsList){
			if(gg.getNumber().equals(g.getNumber())){
                  gg=g;
                  break;
			}
		}
		try {
			FileOpr.writeFile(FileName.goodsFile, goodsList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public GoodsPO finGood(String number) throws RemoteException {
		// TODO Auto-generated method stub
		GoodsPO aimGoods=null;
		for(GoodsPO g: goodsList){
			if(g.getNumber().equals(number)){
				aimGoods=g;
				break;
			}
		}
		return aimGoods;
	}
	
	public int addGoodsAlarm(GoodsAlarmPO ga){
		
		alarmList.add(ga);
		try {
			FileOpr.writeFile(FileName.alarmFile, alarmList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//错误类型:文件读写错误
		}
		return 0;
	}
	
	public ArrayList<GoodsAlarmPO> getAlarmList(){
		return alarmList;
	}

	public ArrayList<GoodsPO> getGoodList() throws RemoteException {
		// TODO Auto-generated method stub
		return goodsList;
	}

	private void initial(){
		try {
			goodsList=(ArrayList<GoodsPO>)FileOpr.readFile(FileName.goodsFile);
			alarmList=(ArrayList<GoodsAlarmPO>)FileOpr.readFile(FileName.alarmFile);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		 try {
			   GoodsData gd=new GoodsData();
			   TypePO parent=new TypePO(null, "0001", "");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
