package TeamWolf.TeamWolf.server.applicationDATA;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import TeamWolf.TeamWolf.client.BL.applicationBL.forStock.DecreaseToMatch;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.StockApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.DecreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.PresentListPO;
import TeamWolf.TeamWolf.client.po.TypePO;
import TeamWolf.TeamWolf.server.FileName;
import TeamWolf.TeamWolf.server.FileOpr;

public class StockApplicationDATA extends UnicastRemoteObject implements StockApplicationDATAservice{

	
	ArrayList<IncreaseToMatchPO> ITMList;
	ArrayList<DecreaseToMatchPO> DTMList;
	ArrayList<PresentListPO> PList;
	
	public StockApplicationDATA() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		initial();
		
		if(ITMList==null)
			ITMList=new ArrayList<IncreaseToMatchPO>();
		if(DTMList==null)
			DTMList=new ArrayList<DecreaseToMatchPO>();
		if(PList==null)
			PList=new ArrayList<PresentListPO>();
	}

	public int submitIncreaseToMatch(IncreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		ITMList.add(po);
		try {
			FileOpr.writeFile(FileName.increaseToMatchFile, ITMList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int submitDecreaseToMatch(DecreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		DTMList.add(po);
		try {
			FileOpr.writeFile(FileName.decreaseToMatchFile, DTMList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	public int submitPresentList(PresentListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		PList.add(po);
		try {
			FileOpr.writeFile(FileName.presnetListFile, PList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	public int approvalIncreaseToMatch(IncreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int approvalDecreaseToMatch(DecreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int approvalPresentList(PresentListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectIncreaseToMatch(IncreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectDecreaseToMatch(DecreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rejectPresentList(PresentListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changeIncreaseToMatch(IncreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changeDecreaseToMatch(DecreaseToMatchPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int changePresentList(PresentListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<PresentListPO> shoPL() throws RemoteException {
		// TODO Auto-generated method stub
		return PList;
	}

	public ArrayList<IncreaseToMatchPO> shoITM() throws RemoteException {
		// TODO Auto-generated method stub
		
		return ITMList;
	}

	public ArrayList<DecreaseToMatchPO> shoDTM() throws RemoteException {
		// TODO Auto-generated method stub
		return DTMList;
	}
	
	private void initial(){
		try {
			ITMList=(ArrayList<IncreaseToMatchPO>)FileOpr.readFile(FileName.increaseToMatchFile);
			DTMList=(ArrayList<DecreaseToMatchPO>)FileOpr.readFile(FileName.decreaseToMatchFile);
			PList=(ArrayList<PresentListPO>)FileOpr.readFile(FileName.presnetListFile);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int todayQuantityOfITM() throws RemoteException {
		// TODO Auto-generated method stub
		int result=0;
	    String date=this.getPresentTime();
		for(IncreaseToMatchPO itm : ITMList){
			String[] number=itm.number.split("-");
			if(number[1].equals(date))
				result++;
		}
		
		return result;
	}

	public int todayQuantityOfDTM() throws RemoteException {
		// TODO Auto-generated method stub
		int result=0;
		String date=this.getPresentTime();
		for(DecreaseToMatchPO dtm : DTMList){
			String[] number=dtm.number.split("-");
			if(number[1].equals(date))
				result++;
		}
		
		return result;
	}
	
	private String getPresentTime(){
 		//获得当前时间
 		Calendar c=Calendar.getInstance();
 		SimpleDateFormat s=new SimpleDateFormat("yyyyMMdd");
 		//SimpleDateFormat s=new SimpleDateFormat("MM-dd HH:mm:ss");
 		String time=s.format(c.getTime());
 		return time;
 	}

	public static void main(String[] args){
		
		try {
			StockApplicationDATA sad=new StockApplicationDATA();
			
			ArrayList<DecreaseToMatchPO> dp=sad.DTMList;
			
			for(DecreaseToMatchPO i : dp){
				System.out.println(i.number);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
