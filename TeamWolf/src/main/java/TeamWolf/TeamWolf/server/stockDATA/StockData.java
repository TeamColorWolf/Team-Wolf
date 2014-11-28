
package TeamWolf.TeamWolf.server.stockDATA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataService;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.TypePO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

/**
 * 
 * @author XYJ
 *
 */
public class StockData extends UnicastRemoteObject implements StockDataService {

	ArrayList<TypePO> stockList;
	String path="库存商品//";
	
	public StockData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.initial();
		if(stockList==null)
			stockList=new ArrayList<TypePO>();
	}

	public int addType(TypePO t) throws RemoteException {
		// TODO Auto-generated method stub
		stockList.add(t);
		try {
			FileOpr.writeFile(FileName.stockFile, stockList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回文件读写错误
		}
		return 0;
	}

	public int delType(String number) throws RemoteException {
		// TODO Auto-generated method stub
		TypePO toDel=null;
		for(TypePO t:stockList){
			if(t.getNumber().equals(number)){
				toDel=t;
				break;
			}
		}
		if(toDel!=null){
		   stockList.remove(toDel);
		   try {
			FileOpr.writeFile(FileName.stockFile, stockList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回文件读写错误
		}
		}
		return 0;
	}

	public int updType(TypePO t) throws RemoteException {
		// TODO Auto-generated method stub
		TypePO toUpd=null;
		for(TypePO tt:stockList){
			if(tt.getNumber().equals(t.getNumber())){
				toUpd=t;
				break;
			}
		}
		try {
			FileOpr.writeFile(FileName.stockFile, stockList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public TypePO finType(String number) throws RemoteException {
		// TODO Auto-generated method stub
		TypePO aimType=null;
		for(TypePO t:stockList){
			if(t.getNumber().equals(number)){
				aimType=t;
				break;
			}
		}
		return aimType;
	}

	public ArrayList<TypePO> shoTypeList() throws RemoteException {
		// TODO Auto-generated method stub
		return stockList;
	}

	private void initial(){
		try {
			stockList=(ArrayList<TypePO>)FileOpr.readFile(FileName.stockFile);
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
			StockData sd=new StockData();
			/*TypePO add=new TypePO(null, "1114", "虚拟商品");
			GoodsPO addGoods=new GoodsPO(null, "111201", "Happy", "HH", 3, 9.0, 12.4, 8.99, 12.333);
			if(add.addLeaveNode(addGoods))
				System.out.println("Success");
			sd.addType(add);
			TypePO fin1=sd.finType("1111");
			System.out.println(fin1.getNumber()+" "+fin1.getName());
			TypePO fin2=sd.finType("1112");
			System.out.println(fin2.getNumber()+" "+fin2.getName());
			TypePO fin3=sd.finType("1114");
			ArrayList<GoodsPO> list=fin3.getLeaveNode();
			for(GoodsPO g: list){
				System.out.println(g.getNumber()+"-"+g.getName());
			}*/
			ArrayList<TypePO> l=sd.stockList;
			for(TypePO t:l){
				System.out.println(t.getNumber()+" "+t.getName());
				if(t.getC()==2){
				ArrayList<GoodsPO> list=t.getLeaveNode();
				for(GoodsPO g: list){
					System.out.println(g.getNumber()+"-"+g.getName());
				}
				}
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

