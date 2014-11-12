package TeamWolf.TeamWolf.client.BL.stockBL;

import TeamWolf.TeamWolf.client.vo.TypeList;
import TeamWolf.TeamWolf.client.vo.TypeVO;
/**
 * 
 * @author XYJ
 *
 */
public class StockBLManager_stub {
	
    StockBLAssistant assistant;
	
	StockBLManager_stub(){
		assistant=new StockBLAssistant();
	}
	
	public int addType(TypeVO t) {
		// TODO Auto-generated method stub
        if(assistant.canAdd(t)){ 
        	//添加商品分类		
		}
		else{ 
			//返回错误：商品已存在于系统中
		}
		return 0;
	}

	public int delType(TypeVO t) {
		// TODO Auto-generated method stub
        if(assistant.canDel(t)==0){ 
		  //删除商品分类
		}
		else{ 
		  //返回错误：商品不存在于系统中
		}
		return 0;
	}
    
	public int updType(TypeVO t) {
		// TODO Auto-generated method stub
        if(assistant.canUpd(t)){
		  //修改商品分类
		}
		else{ 
		 //返回错误：商品不存在于系统中
		}
		return 0;
	}

	public TypeList shoAllType() {
		// TODO Auto-generated method stub
		TypeList t=new TypeList();
		return t;
	}

}
