
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

import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataRead;
import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataWrite;
import TeamWolf.TeamWolf.client.po.TypePO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

/**
 * 
 * @author XYJ
 *
 */
public class StockData extends UnicastRemoteObject implements StockDataWrite,StockDataRead {

	ArrayList<TypePO> stockList;
	String path="库存商品//";
	
	protected StockData() throws RemoteException {
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

	public int delType(String name) throws RemoteException {
		// TODO Auto-generated method stub
		TypePO toDel=null;
		for(TypePO t:stockList){
			if(t.getName().equals(name)){
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
			if(tt.getName().equals(t.getName())){
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
	
	public TypePO finType(String name) throws RemoteException {
		// TODO Auto-generated method stub
		TypePO aimType=null;
		for(TypePO t:stockList){
			if(t.getName().equals(name)){
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
		
	  /*	try {
			StockData sd=new StockData();
			TypePO add=new TypePO(null, "1112", "虚拟商品");
			sd.addType(add);
			TypePO fin1=sd.finType("实物商品");
			System.out.println(fin1.getNumber()+" "+fin1.getName());
			TypePO fin2=sd.finType("虚拟商品");
			System.out.println(fin2.getNumber()+" "+fin2.getName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
	}

}

