package TeamWolf.TeamWolf.client.BL.goodsBL;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.promotionBL.PromotionForStockController;
import TeamWolf.TeamWolf.client.BL.promotionBL.PromotionForStockService;
import TeamWolf.TeamWolf.client.BL.saleBL.SaleBLController;
import TeamWolf.TeamWolf.client.BLservice.saleBLservice.SaleBLservice;
import TeamWolf.TeamWolf.client.BLservice.stockBLservice.GoodManService;
import TeamWolf.TeamWolf.client.DATAservice.goodsDATAservice.GoodsDataService;
import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataService;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.TypePO;
import TeamWolf.TeamWolf.client.vo.*;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsManager {

	String URL1, URL2;
	GoodsBLAssistant assistant;
	GoodsDataService GdataService;
	StockDataService SdataService;
    PromotionForStockService promoteController;
    SaleBLservice sbc;
	
	public GoodsManager(String IP){
		
		URL1="rmi://"+IP+"/goodsDATAservice";
		URL2="rmi://"+IP+"/stockDATAservice";
		
		assistant=new GoodsBLAssistant(URL1);
		promoteController=new PromotionForStockController(IP);
		sbc=new SaleBLController(IP);
		
		try {
			
			GdataService=(GoodsDataService)Naming.lookup(URL1);
			SdataService=(StockDataService)Naming.lookup(URL2);
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
	
	public int addGoods(GoodsVO g){
		
		try {
		if(assistant.canAdd(g)){
		
			GoodsPO toAdd=new GoodsPO(g);
			TypePO parent=SdataService.finType(g.getParentNum());
			if(parent.getC()==1){
				return ErrorTW.cannotAddGoods_1;//返回错误类型：父分类下有子分类，不可添加商品
			}
			else{
				//符合前置条件，进行增加商品操作
				parent.addLeaveNode(toAdd);
				SdataService.updType(parent);
				GdataService.addGood(toAdd);
			}			
		}
		else{   return ErrorTW.GoodsIsExisted;//返回错误类型：商品已经存在与系统中
			
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ErrorTW.webError;   //返回通信错误
		}
		return 0;
	}
	
	public int delGoods(GoodsVO g){
		
		try {
		int result=assistant.canDel(g);
		if(result==0){
				
			    TypePO parent=SdataService.finType(g.getParentNum());
			    if(parent.delLeaveNode(g.getNumber())){ //先把商品从父类中删除
			    	GdataService.delGood(g.getNumber());
			    	SdataService.updType(parent);
			    }else{
			    	 return ErrorTW.notMatchToParent;//错误类型:删除的商品与父分类不匹配
			    }
						
		}
		else{   //返回错误类型：商品不存在于系统中或者商品有过交易记录
			
			return result; 
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ErrorTW.webError;   //返回通信错误
		}
		
		return 0;
	}
	
	public int updGoods(GoodsVO g){
		
		try {
		if(assistant.canUpd(g)){
			    
			    //把要修改的商品从持久化数据中找出来，再进行完善
				GoodsPO toUpd=GdataService.finGood(g.getNumber());
				TypePO parent=SdataService.finType(g.getParentNum());
				/*对PO进行修改,完善信息*/
				if(g.getName()!=null)
					toUpd.setName(g.getName());
				if(g.getModel()!=null)
					toUpd.setModel(g.getModel());
				if(g.getExprice()!=0){
					toUpd.setExprice(g.getExprice());
					//System.out.println(g.getExprice());
				}
				if(g.getImprice()!=0){
					toUpd.setImprice(g.getImprice());
					//System.out.println(g.getImprice());
				}
				
				//System.out.println(toUpd.getName()+" "+toUpd.getImprice()+" "+toUpd.getExprice());
				parent.updLeaveNode(toUpd);
				SdataService.updType(parent);
				GdataService.updGood(toUpd);			
			
		}
		else{  return ErrorTW.GoodsIsnotExisted;//返回错误类型：商品不存在于系统中
		
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ErrorTW.webError;  //返回通信错误
		}
		return 0;
	}
	public GoodsVO finGoods(GoodsVO g) {
		
		try {

		GoodsPO found=GdataService.finGood(g.getNumber());
		//对g进行修改(把g的数据完善以回交给展示层)		
        if(found!=null){
            g.setName(found.getName());
            g.setModel(found.getModel());
        	g.setAmount(found.getAmount());
        	g.setExprice(found.getExprice());
        	g.setImprice(found.getImprice());
        	g.setLatestExprice(found.getLatestExprice());
        	g.setLatestImprice(found.getLatestImprice());
        	g.setModel(found.getModel());
        	g.setParent(found.getParent().getName());
        	g.setParentNum(found.getParent().getNumber());
        }
		else{ return null;//返回错误类型：商品不存在于系统中
			
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//返回通信错误
			
		}
		return g;
	}
	
	//根据名称或型号的模糊查找
	public ArrayList<GoodsVO> dimFinGoods(GoodsVO g){
	   
		ArrayList<GoodsVO> result=new ArrayList<GoodsVO>();
		try {
			ArrayList<GoodsPO> agl=GdataService.getGoodList();
			for(GoodsPO gg: agl){
				
				if((g.getName()!=null&&gg.getName().equals(g.getName()))||(g.getModel()!=null&&gg.getModel().equals(g.getModel()))){
					result.add(new GoodsVO(gg));
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return result;
	}
	
	public GoodsListVO shoGoods(){
		
		GoodsListVO gl=new GoodsListVO();
		ArrayList<SpecialGoodsPromotionVO> sgl=promoteController.specialGoodsPackage();
		
		try {
			for(SpecialGoodsPromotionVO sg: sgl){
				gl.addGood(new GoodsVO("0000", "特价包", "", sg.number, "", "0", "0", ""+sg.totalPrice, "0", "0", "0"));
			}
			
			
			
			ArrayList<GoodsPO> agl=GdataService.getGoodList();
			for(GoodsPO g:agl){
				//逐个加入 gl中
				GoodsVO gg=new GoodsVO(g);
				gl.addGood(gg);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
       
		return gl;
	}
	
	//库存查看功能
	public GoodsStockListVO shoStockList(int beginDate, int endDate){
		
		GoodsStockListVO gsl=new GoodsStockListVO();
		ArrayList<GoodsPO> gl=null;
		
		try {
			gl=GdataService.getGoodList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//查找该段时间的交易记录，计算并生成对应的GoodsStockVO
		//读入用于计算的各种交易单据
		ArrayList<ImportListVO> ipl=sbc.getImportList();
		ArrayList<SaleListVO> sl=sbc.getSaleList();
		ArrayList<ImportRejectListVO> iprl=sbc.getImportRejectList();
		ArrayList<SaleRejectListVO> srl=sbc.getSaleRejectList();
	    
	    
	    for(GoodsPO g: gl){
	    	
	    	//System.out.println(g.getName()+":");
	    	
	    	GoodsStockVO gs=new GoodsStockVO();
	    	gs.setGood(new GoodsVO(g));
	    	int ImportAmount=0;
	    	double ImportPrice=0;
	    	int ExportAmount=0;
	    	double ExportPrice=0;
	    	double totalPrice=0;
	    	int totalAmount=0;
	    	
	    	//遍历单据，将在该时间段内的单据用于计算(以下四个循环分别计算四个单据)
	    	for(ImportListVO ip : ipl){
	    		String[] info=ip.number.split("-");
	    		int date=Integer.parseInt(info[1]);
	    		ArrayList<GoodsVO> importGL=ip.getGoodsList();
	    		
	    		for(GoodsVO imported: importGL){
	    		    if(imported.getNumber().equals(g.getNumber())){
	    		    	if(date>=beginDate&&date<=endDate){
	    				      ImportAmount+=imported.getAmount();
	    				      ImportPrice+=imported.getAmount()*imported.getImprice();
	    				      System.out.println("进货 "+imported.getAmount()+" "+imported.getImprice());
	    		    	}
	    		    	totalAmount+=imported.getAmount();
	    		    	totalPrice+=imported.getAmount()*imported.getImprice();
	    		    	System.out.println("ip: "+totalPrice+" "+totalAmount);
	    			 }
	    		}
	    		    			    	  
	    	}
	    	
	    	for(ImportRejectListVO ipr : iprl){
	    		String[] info=ipr.number.split("-");
	    		int date=Integer.parseInt(info[1]);
	    		ArrayList<GoodsVO> importRejectedGL=ipr.getGoodsList();
	    		
	    		for(GoodsVO importR: importRejectedGL){
	    			if(importR.getNumber().equals(g.getNumber())){
	    				if(date>=beginDate&&date<=endDate){
	    				      ImportAmount-=importR.getAmount();
	    				      ImportPrice-=importR.getAmount()*importR.getImprice();
	    				      //System.out.println("进货退货 "+importR.getAmount()+" "+importR.getImprice());
	    				}
	    				double aP=totalPrice/(double)totalAmount;
	    				totalAmount-=importR.getAmount();
	    				totalPrice-=(aP*importR.getAmount());
	    				//System.out.println("irp: "+totalPrice+" "+totalAmount);
	    			}
	    		}
	    	}
	    	
	    	for(SaleListVO sa: sl){
	    		String[] info=sa.number.split("-");
	    		int date=Integer.parseInt(info[1]);
	    		ArrayList<GoodsVO> saleGL=sa.getGoodsList();
	    		
	    		for(GoodsVO sold: saleGL){
	    		   if(sold.getNumber().equals(g.getNumber())){
	    			  if(date>=beginDate&&date<=endDate){  
	    			     ExportAmount+=sold.getAmount();
	    			     ExportPrice+=sold.getExprice()*sold.getAmount();
	    			     System.out.println("销售 "+sold.getAmount()+" "+sold.getImprice());
	    			  }
	    			  
	    			  double aP=totalPrice/(double)totalAmount;
	    			  totalAmount-=sold.getAmount();
	    			  totalPrice-=(aP*sold.getAmount());
	    			  System.out.println("ep: "+totalPrice+" "+totalAmount);
	    		   }
	    		}
	    	}
	    	
	    	for(SaleRejectListVO sar : srl){
	    		String[] info=sar.number.split("-");
	    		int date=Integer.parseInt(info[1]);
	    		ArrayList<GoodsVO> saleRGL=sar.getGoodsList();
	    		
	    		for(GoodsVO soldR: saleRGL){
	    			if(soldR.getNumber().equals(g.getNumber())){
	    				if(date>=beginDate&&date<=endDate){
	    					ExportAmount-=soldR.getAmount();
	    					ExportPrice-=soldR.getExprice()*soldR.getAmount();
	    					//System.out.println("销售退货 "+soldR.getAmount()+" "+soldR.getImprice());
	    				}
	    				
	    				double aP=totalPrice/(double)totalAmount;
	    				totalAmount+=soldR.getAmount();
	    				totalPrice+=(aP*soldR.getAmount());
	    				//System.out.println("erp: "+totalPrice+" "+totalAmount);
	    			}
	    		}
	    		
	    	}
	    	
	    	//设置计算好的库存数据
	    	gs.setExportAmount(ExportAmount);
	    	gs.setExportTotalPrice(ExportPrice);
	    	gs.setImportAmount(ImportAmount);
	    	gs.setImportTotalPrice(ImportPrice);
	    	gs.setTotalPrice(totalPrice);
	    	
	    	//商品库存列表中添加一个商品库存数据
	    	gsl.addGoodSVO(gs);
	    	
	    }
		
		return gsl;
	}
	
	//库存快照功能
	public GoodsStockListVO shoStockDaily(){
		
		int presentDate=Integer.parseInt(assistant.getPresentDate());
		//调用查看库存的方法，起始时间和结束时间均为当天
		return this.shoStockList(presentDate, presentDate);
	}                                                                                                                                                                                                                                                                                                                                                            
	
}
