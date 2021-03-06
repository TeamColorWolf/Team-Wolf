package TeamWolf.TeamWolf.client.BL.applicationBL.forStock;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.StockApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.DecreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.PresentListPO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;

public class StockRead {

	StockApplicationDATAservice dataService;
	
	public StockRead(String IP){
		
		String URL="rmi://"+IP+"/stockApplicationDATAservice";
		try {
			dataService=(StockApplicationDATAservice)Naming.lookup(URL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getITMList(){
		
		ArrayList<String> result=new ArrayList<String>();
		
		try {
			ArrayList<IncreaseToMatchPO> ITML=dataService.shoITM();
			for(IncreaseToMatchPO itm: ITML){
				String[] info=itm.number.split("-");
		        result.add(info[1]+":  "+itm.getInfo());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<String> getDTMList(){
		
		ArrayList<String> result=new ArrayList<String>();		

		try {
			ArrayList<DecreaseToMatchPO> DTML=dataService.shoDTM();
			for(DecreaseToMatchPO dtm: DTML){
				String[] info=dtm.number.split("-");
				result.add(info[1]+":  "+dtm.getInfo());
			}
		} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return result;
	}
	
	public int todayQuantityOfITM(){
		int result=0;
		try {
			result=dataService.todayQuantityOfITM();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int todayQuantityOfDTM(){
		int result=0;
		try {
			result=dataService.todayQuantityOfDTM();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<PresentListVO> getPresentList(){
		
		ArrayList<PresentListVO> result=new ArrayList<PresentListVO>();
		
		try {
			ArrayList<PresentListPO> poList=dataService.getPresentList();
			for(PresentListPO g: poList){
				if(g!=null){
					//System.out.println(g.number);
				    result.add(new PresentListVO(g));
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
