package TeamWolf.TeamWolf.client.BL.stockBL;

import TeamWolf.TeamWolf.client.po.TypePO;
import TeamWolf.TeamWolf.client.vo.*;

/**
 * 
 * @author XYJ
 *
 */
public class StockBLManager{

	StockBLAssistant assistant;
	
	
	StockBLManager(){
		assistant=new StockBLAssistant();
	}

	public int addType(TypeVO t) {
		// TODO Auto-generated method stub
		if(assistant.canAdd(t)){ //输入合法，能加入系统，进行加入工作
			
			TypePO toAdd=new TypePO(); //根据合法的VO生成PO持久化对象
			
			/* ...完善PO持久化对象内容...*/
			
			
		}
		else{ //因输入非法无法加入系统，返回错误类型
			
		}
		return 0;
	}

	public int delType(TypeVO t) {
		// TODO Auto-generated method stub
        if(assistant.canDel(t)){ //输入合法，进行删除工作
        	
        }else{ //因输入非法无法进行删除操作，返回错误类型
        	
        }
		return 0;
	}
    
	public int updType(TypeVO t) {
		// TODO Auto-generated method stub
		if(assistant.canUpd(t)){ //输入合法，进行修改工作
			
		}else{ //因输入非法无法进行修改，返回错误类型
			
		}
		return 0;
	}

	public TypeList shoAllType() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
