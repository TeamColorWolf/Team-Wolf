<<<<<<< HEAD
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

import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataWrite;
import TeamWolf.TeamWolf.client.po.TypePO;

public class StockWrite extends UnicastRemoteObject implements StockDataWrite {

	ObjectOutputStream OWriter;
	ObjectInputStream OReader;
	String path="库存商品//";
	
	protected StockWrite() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int addType(TypePO t) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			OWriter=new ObjectOutputStream(new FileOutputStream(path+t.getNumber()+".tw"));
			OWriter.writeObject(t);
			OWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//返回读写错误
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回读写错误
		}
		return 0;
	}

	public int delType(String name) throws RemoteException {
		// TODO Auto-generated method stub
		File toDel=new File("库存商品//"+name+".tw");
		toDel.delete();
		return 0;
	}

	public int updType(TypePO t) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			OWriter=new ObjectOutputStream(new FileOutputStream(path+t.getName()+".tw"));
			OWriter.writeObject(t);
			OWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//返回读写错误
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回读写错误
		}
		return 0;
	}
	
	public static void main(String[] args){
		
		TypePO t=new TypePO(null, "1101", "goods");
		try {
			StockWrite sw=new StockWrite();
			sw.addType(t);
			t.setNumber("2222");
			t.setName("goods");
			sw.updType(t);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
=======
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

import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataWrite;
import TeamWolf.TeamWolf.client.po.TypePO;

public class StockWrite extends UnicastRemoteObject implements StockDataWrite {

	ObjectOutputStream OWriter;
	ObjectInputStream OReader;
	String path="库存商品//";
	
	protected StockWrite() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public int addType(TypePO t) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			OWriter=new ObjectOutputStream(new FileOutputStream(path+t.getName()+".tw"));
			OWriter.writeObject(t);
			OWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//返回读写错误
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回读写错误
		}
		return 0;
	}

	public int delType(String name) throws RemoteException {
		// TODO Auto-generated method stub
		File toDel=new File("库存商品//"+name+".tw");
		toDel.delete();
		return 0;
	}

	public int updType(TypePO t) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			OWriter=new ObjectOutputStream(new FileOutputStream(path+t.getName()+".tw"));
			OWriter.writeObject(t);
			OWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//返回读写错误
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回读写错误
		}
		return 0;
	}
	
	public static void main(String[] args){
		
		TypePO t=new TypePO(null, "1101", "goods");
		try {
			StockWrite sw=new StockWrite();
			sw.addType(t);
			t.setNumber("2222");
			t.setName("goods");
			sw.updType(t);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
>>>>>>> origin/master
