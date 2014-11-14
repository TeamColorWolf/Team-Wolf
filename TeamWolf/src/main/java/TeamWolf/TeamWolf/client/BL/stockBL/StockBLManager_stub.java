package TeamWolf.TeamWolf.client.BL.stockBL;

import TeamWolf.TeamWolf.client.vo.TypeListVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;
/**
 * 
 * @author XYJ
 *
 */
public class StockBLManager_stub {
	
    StockBLAssistant_stub assistant;
	
	StockBLManager_stub(){
		assistant=new StockBLAssistant_stub();
	}
	
	public int addType(TypeVO t) {
		// TODO Auto-generated method stub
        if(assistant.canAdd(t)){ 
        	System.out.println("添加成功！");//添加商品分类		
		}
		else{ 
			//返回错误：商品已存在于系统中
		}
		return 0;
	}

	public int delType(TypeVO t) {
		// TODO Auto-generated method stub
        if(assistant.canDel(t)==0){ 
		    System.out.println("删除成功！");//删除商品分类
		}
		else{ 
		  //返回错误：商品不存在于系统中
		}
		return 0;
	}
    
	public int updType(TypeVO t) {
		// TODO Auto-generated method stub
        if(assistant.canUpd(t)){
		  System.out.println("更新成功！");//修改商品分类
		}
		else{ 
		 //返回错误：商品不存在于系统中
		}
		return 0;
	}

	public TypeListVO shoAllType() {
		// TODO Auto-generated method stub
		TypeListVO t=new TypeListVO();
		System.out.println("商品分类列表！");
		return t;
	}

}
