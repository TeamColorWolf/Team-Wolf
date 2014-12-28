package TeamWolf.TeamWolf.client.BL.stockBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.promotionBL.PromotionForStockController;
import TeamWolf.TeamWolf.client.BL.promotionBL.PromotionForStockService;
import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataService;
import TeamWolf.TeamWolf.client.po.TypePO;
import TeamWolf.TeamWolf.client.vo.*;

/**
 * 
 * @author XYJ
 *
 */
public class StockBLManager{

	String URL;
	StockBLAssistant assistant;
	StockDataService dataService;
	PromotionForStockService promoteController;
	
	public StockBLManager(String IP){
		
		URL="rmi://"+IP+"/stockDATAservice";
		assistant=new StockBLAssistant(URL);
		promoteController=new PromotionForStockController(IP);
		
		try {
			dataService=(StockDataService)Naming.lookup(URL);
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

	public int addType(TypeVO t) {
		// TODO Auto-generated method stub
		try {
		if(assistant.canAdd(t)){ //输入合法，能加入系统，进行加入工作
			
			TypePO toAdd=new TypePO(t); //根据合法的VO生成PO持久化对象
			
			/* ...完善PO持久化对象内容...*/
			
				   //对象通过唯一编号来寻找
			if(t.getParentNum()!=null){   //若被添加分类有父母分类则还需修改其父母分类的属性
				   TypePO parent=dataService.finType(t.getParentNum());
				   toAdd.setParent(parent);
				   if(parent.addChildType(toAdd)){
					   dataService.updType(parent);  
				   }
				   else{
					  return 1001;//返回不可在有商品的分类下添加子分类
				   }					
			}
			
		    dataService.addType(toAdd);
		}
		else{ 
			return 1002;  //返回部分逻辑错误类型:商品已存在于系统中
		}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return 30000;   //返回通信错误
		}	
		return 0;
	}

	public int delType(TypeVO t) {
		// TODO Auto-generated method stub
		try {
        if(assistant.canDel(t)){ //输入合法，进行删除工作
        	
        	
				TypePO toDel=dataService.finType(t.getNumber());
				if(toDel.getC()!=0){
					return 1003; //返回其下有子女，不可删除
				}
				else{ //执行删除操作，需要对父母类进行修改
					if(t.getParent()!=null){
					     TypePO parent=dataService.finType(t.getParentNum());
					     parent.delChildType(t.getNumber());
					     dataService.updType(parent); //更新其父母类
					}
					dataService.delType(t.getNumber());
				}
			
            
        }else{ 
        	 return 1004; // 错误类型：商品分类不存在于系统中        	
        }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 30000;    //返回通信错误
		}
		
        return 0; //操作成功
	}
    
	//修改分类只支持改名
	public int updType(TypeVO t) {
		// TODO Auto-generated method stub
		try {
		   
			if(assistant.canUpd(t)){ //输入合法，进行修改工作
								
				 TypePO toUpd = dataService.finType(t.getNumber());				
				 /*...完善修改PO...*/
				 if(t.getName()!=null){
					 toUpd.setName(t.getName());
					 if(t.getParentNum()!=null){
						 TypePO parent=dataService.finType(t.getParentNum());    //如果有父类，修改父类里该子类的信息
						 parent.updChildType(t);
						 dataService.updType(parent);
					 }
				 }
				 else
					 return 1005;//返回错误类型：信息填写不完整
				 
				 dataService.updType(toUpd);									            
		}else{ //因输入非法无法进行修改，返回错误类型：商品不存于系统中
			return 1004;
		}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			//返回通信错误
			e1.printStackTrace();
			return 30000;
		}
		
		return 0; //操作成功
	}

	//展示分类结构时调用
	public TypeListVO shoAllType() {
		// TODO Auto-generated method stub
		
		TypeListVO tl=new TypeListVO();
		try {
			ArrayList<TypePO> atl=dataService.shoTypeList();
			for(TypePO t:atl){
				tl.addType(new TypeVO(t));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tl;
	}
	
	public ArrayList<TypeVO> getLeaveType(){
		
		ArrayList<TypeVO> leaveTypeL=new ArrayList<TypeVO>();
		ArrayList<SpecialGoodsPromotionVO> sgl=promoteController.specialGoodsPackage();
		
		try {
			ArrayList<TypePO> atl=dataService.shoTypeList();
			for(TypePO t:atl){
			    if(t.getName().equals("特价包")){
			    	 TypeVO special=new TypeVO(t);
			    	 for(SpecialGoodsPromotionVO sg: sgl){
			    		 special.addLeave(new GoodsVO("0000", "特价包", "", sg.number, "", "0", "0", ""+sg.totalPrice, "0", "0", "0"));
			    	 }
			    	 leaveTypeL.add(special);
			    }
			    else if(t.getC()==2){
			    	 leaveTypeL.add(new TypeVO(t));
			     }
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return leaveTypeL;
	}
}
