package TeamWolf.TeamWolf.server.goodsDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataService;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

public class GoodsData extends UnicastRemoteObject implements GoodsDataService {

	ArrayList<GoodsPO> goodsList;
	
	public GoodsData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.initial();
		if(goodsList==null){
			goodsList=new ArrayList<GoodsPO>();
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

	public ArrayList<GoodsPO> getGoodList() throws RemoteException {
		// TODO Auto-generated method stub
		return goodsList;
	}

	private void initial(){
		try {
			goodsList=(ArrayList<GoodsPO>)FileOpr.readFile(FileName.goodsFile);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args){
		 try {
			GoodsData gd=new GoodsData();
			GoodsPO g=new GoodsPO(null, "00002", "电灯", "GZ", 8, 0, 0, 0, 0);
			gd.addGood(g);
			GoodsPO fin=gd.finGood("00002");
			System.out.println(fin.getNumber()+" "+g.getName()+" "+fin.getModel());
			gd.delGood("00002");
			GoodsPO fin2=gd.finGood("00002");
			if(fin2==null){
				System.out.println("已删除");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}