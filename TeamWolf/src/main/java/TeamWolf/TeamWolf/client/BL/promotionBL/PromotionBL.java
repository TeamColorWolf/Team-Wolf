package TeamWolf.TeamWolf.client.BL.promotionBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BLservice.manageBLservice.PromotionBLservice;
import TeamWolf.TeamWolf.client.DATAservice.promotionDATAservice.PromotionDATAservice;
import TeamWolf.TeamWolf.client.po.ForPricePromotionPO;
import TeamWolf.TeamWolf.client.po.ForVIPPromotionPO;
import TeamWolf.TeamWolf.client.po.PromotionPO;
import TeamWolf.TeamWolf.client.po.PromotionTypePO;
import TeamWolf.TeamWolf.client.po.SpecialGoodsPromotionPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ForPricePromotionVO;
import TeamWolf.TeamWolf.client.vo.ForVIPPromotionVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.PromotionTypeVO;
import TeamWolf.TeamWolf.client.vo.PromotionVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SpecialGoodsPromotionVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;
/**
 * 
 * @author WHJ
 *
 */
public class PromotionBL{
	PromotionDATAservice data;
	PromotionBLAssistant proAssist;
	Date presentDate;
	ArrayList<PromotionPO> poList;
	ArrayList<PromotionVO> voList;
	String URL;
	
	public PromotionBL(String IP){
		URL = "rmi://" + IP + "/promotionDATAservice";
		this.initial();
		proAssist = new PromotionBLAssistant(IP);
	}
	
	public int addPromotion(PromotionVO vo){
		vo.number = this.creatPromotionNumber(vo);
		try {
			data = (PromotionDATAservice)Naming.lookup(URL);
			PromotionPO po = this.getPOfromVO(vo);
			int success = data.addPromotion(po);
			if(success == 0){
				poList.add(po);
				voList.add(vo);
			}
			return success;
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
		return ErrorTW.webError;
	}
	
//	public int setForVIP(ForVIPPromotionVO vo) {
//		// TODO Auto-generated method stub
//		try {
//			data = (PromotionDATAservice)Naming.lookup(URL);
//			return data.addPromotion(new ForVIPPromotionPO(vo));
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NotBoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ErrorTW.webError;
//	}
//
//	public int setForSpecialGoods(SpecialGoodsPromotionVO vo) {
//		// TODO Auto-generated method stub
//		try {
//			data = (PromotionDATAservice)Naming.lookup(URL);
//			return data.addPromotion(new SpecialGoodsPromotionPO(vo));
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NotBoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ErrorTW.webError;
//	}
//
//	public int setForPrice(ForPricePromotionVO vo) {
//		// TODO Auto-generated method stub
//		try {
//			data = (PromotionDATAservice)Naming.lookup(URL);
//			return data.addPromotion(new ForPricePromotionPO(vo));
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NotBoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ErrorTW.webError;
//	}

	public PromotionVO getPromotion(String number) {
		// TODO Auto-generated method stub
		for(int i = 0; i < voList.size(); i++){
			if(voList.get(i).number.equals(number)){
				return voList.get(i);
			}
		}
		try {
			data = (PromotionDATAservice)Naming.lookup(URL);
			PromotionPO po = data.findPromotion(number);
			return this.getVOfromPO(po);
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
		return null;
	}

	public int delet(String number) {
		// TODO Auto-generated method stub
		try {
			data = (PromotionDATAservice)Naming.lookup(URL);
			int success = data.delPromotion(number);
			if(success == 0){
				for(int i = 0; i < poList.size(); i++){
					if(poList.get(i).number.equals(number)){
						poList.remove(i);
						voList.remove(i);
					}
				}
			}
			return success;
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
		return ErrorTW.webError;
	}
	
	public int update(PromotionVO vo) {
		// TODO Auto-generated method stub
		try {
			data = (PromotionDATAservice)Naming.lookup(URL);
			PromotionPO po = this.getPOfromVO(vo);
			int success = data.updPromotion(po);
			if(success == 0){
				this.initial();
			}
			return success;
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
		return ErrorTW.webError;
	}

	public ArrayList<PromotionVO> check() {
		// TODO Auto-generated method stub
		return voList;
	}
	
	public int creatPresentList(PromotionPO po, CustomerVO customer){
		return proAssist.creatPresentList(po, customer);
	}
	
	public ArrayList<TypeVO> getLeaveType(){
		return proAssist.getTypeList();
	}

	public SaleListVO adaptPromotionForSaleList(SaleListVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ImportListVO adaptPromotionForImportList(ImportListVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String creatPromotionNumber(PromotionVO vo){
		int max = 0;
		for(int i = 0; i < voList.size(); i++){
			if(voList.get(i).type == vo.type){
				String[] array = voList.get(i).number.split("_");
				int temp = Integer.parseInt(array[1]);
				if(temp > max){
					max = temp;
				}
			}
		}
		max++;
		return vo.type+"_"+max;
	}
	
	private PromotionVO getVOfromPO(PromotionPO po){
		if(po.type == PromotionTypePO.forVIP){
			return new ForVIPPromotionVO((ForVIPPromotionPO)po);
		}
		else if(po.type == PromotionTypePO.forPrice){
			return new ForPricePromotionVO((ForPricePromotionPO)po);
		}
		else if(po.type == PromotionTypePO.specialGoods){
			return new SpecialGoodsPromotionVO((SpecialGoodsPromotionPO)po);
		}
		return null;
	}
	
	private PromotionPO getPOfromVO(PromotionVO vo){
		if(vo.type == PromotionTypeVO.forVIP){
			return new ForVIPPromotionPO((ForVIPPromotionVO)vo);
		}
		else if(vo.type == PromotionTypeVO.forPrice){
			return new ForPricePromotionPO((ForPricePromotionVO)vo);
		}
		else if(vo.type == PromotionTypeVO.specialGoods){
			return new SpecialGoodsPromotionPO((SpecialGoodsPromotionVO)vo);
		}
		return null;
	}
	
	private void initial(){
		try {
			data = (PromotionDATAservice)Naming.lookup(URL);
			poList = data.show();
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
		if(poList == null){
			poList = new ArrayList<PromotionPO>();
		}
		voList = new ArrayList<PromotionVO>();
		for(int i = 0; i < poList.size(); i++){
			PromotionVO vo = this.getVOfromPO(poList.get(i));
			voList.add(vo);
		}
	}

}
