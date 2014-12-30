package TeamWolf.TeamWolf.server.logDATA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.logDATAservice.LogDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.PromotionPO;
import TeamWolf.TeamWolf.client.po.TypePO;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.server.FileName;

public class LogDATA implements LogDATAservice, WriteLogService{

	static FileWriter logFile = null;
	static BufferedWriter writer = null;
	
	public LogDATA(){
		if(logFile == null || writer == null){
			try {
				logFile = new FileWriter(FileName.logFile, true);
				writer = new BufferedWriter(logFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<String> readLog() throws RemoteException {
		ArrayList<String> loglist = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FileName.logFile));
			String temp = null;
			while((temp = reader.readLine()) != null){
				loglist.add(temp);
			}
			reader.close();
			return loglist;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return loglist;
		}
	}

	public int addUser(UserPO po) {
		
		return 0;
	}

	public int updateUser(UserPO po) {
		
		return 0;
	}

	public int deleteUser(UserPO po) {
		
		return 0;
	}

	public int addGoodsType(TypePO po) {
		
		return 0;
	}

	public int updateGoodsType(TypePO po) {
		
		return 0;
	}

	public int deleteGoodsType(TypePO po) {
		
		return 0;
	}

	public int addGoods(GoodsPO po) {
		return 0;
	}

	public int updateGoods(GoodsPO po) {
		return 0;
	}

	public int delectGoods(GoodsPO po) {
		return 0;
	}

	public int addCustomer(CustomerPO po) {
		return 0;
	}

	public int updateCustomer(CustomerPO po) {
		return 0;
	}

	public int deleteCustomer(CustomerPO po) {
		return 0;
	}

	public int addFinance(financePO po) {
		return 0;
	}

	public int updateFinance(financePO po) {
		return 0;
	}

	public int deleteFinance(financePO po) {
		return 0;
	}

	public int addPromotion(PromotionPO po) {
		return 0;
	}

	public int deletePromotion(PromotionPO po) {
		return 0;
	}

	public int submitApplication(ApplicationPO po) {
		return 0;
	}

	public int approveApplication(ApplicationPO po) {
		return 0;
	}

	public int rejectApplication(ApplicationPO po) {
		return 0;
	}
	
	private void write(String data) throws IOException{
		writer.write(data+"\n");
	}

}
