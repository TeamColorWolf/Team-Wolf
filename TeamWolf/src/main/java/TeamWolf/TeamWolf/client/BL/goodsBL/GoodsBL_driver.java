package TeamWolf.TeamWolf.client.BL.goodsBL;

import TeamWolf.TeamWolf.client.vo.GoodsVO;

public class GoodsBL_driver {

	GoodsBLController_stub gc=new GoodsBLController_stub();
	
    public void driver(){
    	
    	GoodsVO g=new GoodsVO(null, null, null, null, null, null, null, null, null, null);
    	gc.addGoods(g);
    	gc.finGoods(g);
    	gc.updGoods(g);
    	gc.setWaringLine(g);
    	gc.delGoods(g);
    	gc.shoGoods();
    	gc.shoStockDaily();
    	gc.shoStockList(20141111, 20141114);
    	gc.setWaringLine(g);
    	gc.decreaseToMatch(g);
    	gc.increaseToMatch(g);
        	
    }
    
    public static void main(String[] args){
    	
    	GoodsBL_driver gd=new GoodsBL_driver();
    	gd.driver();
    }
}
