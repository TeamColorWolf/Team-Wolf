package TeamWolf.TeamWolf.client.BL.stockBL;

import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataRead;
import TeamWolf.TeamWolf.client.DATAservice.stockDATAservice.StockDataWrite;
import TeamWolf.TeamWolf.client.po.TypePO;
import TeamWolf.TeamWolf.client.vo.*;

/**
 * 
 * @author XYJ
 *
 */
public class StockBLManager{

	StockBLAssistant assistant;
	StockDataWrite writer;
	StockDataRead reader;
	
	StockBLManager(){
		assistant=new StockBLAssistant();
		// 实例化writer和reader
		
	}

	public int addType(TypeVO t) {
		// TODO Auto-generated method stub
		if(assistant.canAdd(t)){ //输入合法，能加入系统，进行加入工作
			
			TypePO toAdd=new TypePO(t); //根据合法的VO生成PO持久化对象
			
			/* ...完善PO持久化对象内容...*/
			
			try {
				writer.addType(toAdd);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				//返回通信错误
				e.printStackTrace();
			}
		}
		else{ //因输入非法无法加入系统，返回部分逻辑错误类型:商品已存在于系统中
			
		}
		return 0;
	}

	public int delType(TypeVO t) {
		// TODO Auto-generated method stub
		int  result=assistant.canDel(t);
		
        if(result==0){ //输入合法，进行删除工作
        	     	
            try {
				writer.delType(t.getNumber());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				//返回通信错误
				e.printStackTrace();
			}
            
        }else{ //因输入非法无法进行删除操作，返回部分逻辑错误类型：商品不存在于系统中，或者商品底下有子类
        	return result;
        }
		return 0; //操作成功
	}
    
	public int updType(TypeVO t) {
		// TODO Auto-generated method stub
		if(assistant.canUpd(t)){ //输入合法，进行修改工作
			
			
			try {
				TypePO toUpd = reader.finType(t.getNumber());				
				/*...完善修改PO...*/
				toUpd.updType(t);
				writer.updType(toUpd);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				//返回通信错误
				e1.printStackTrace();
			}						
            
		}else{ //因输入非法无法进行修改，返回错误类型：商品不存于系统中
			
		}
		
		return 0; //操作成功
	}

	//展示分类结构时调用
	public TypeListVO shoAllType() {
		// TODO Auto-generated method stub
		
		TypeListVO tl=new TypeListVO();
		try {
			ArrayList<TypePO> atl=reader.shoTypeList();
			for(TypePO t:atl){
				tl.addType(new TypeVO(t));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tl;
	}
	
	
}
