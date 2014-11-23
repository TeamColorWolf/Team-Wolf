package TeamWolf.TeamWolf.client.BL.goodsBL;

import TeamWolf.TeamWolf.client.vo.GoodsVO;

public class GoodsBL_driver {
	

	String IP;
	GoodsBLController_stub gc;
	
	public GoodsBL_driver(String IP){
		this.IP=IP;
		gc=new GoodsBLController_stub(IP);
	}
	
    public void driver(){
    	
    	
    	GoodsVO g=new GoodsVO(null, null, null, "飞利浦日光灯", null, null, null, null, null, null, null);
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
    
    public int addGoods(GoodsVO g){
    	return gc.addGoods(g);
    }
    
    public int finGoods(GoodsVO g){
    	if(gc.finGoods(g)==null)
    		return 1112;
    	else 
    		return 0;
    }
    
    public int updGoods(GoodsVO g){
        return gc.updGoods(g);
    }
    
    public int setWaringLine(GoodsVO g){
    	return gc.setWaringLine(g);
    }
	
    public int delGoods(GoodsVO g){
	    return gc.delGoods(g);
    }
    public int shoGoods(){
	   if(gc.shoGoods()==null)
		   return 1112;
	   else 
		   return 0;
    }
    public int shoStockD(){
       if(gc.shoStockDaily()==null)
    	   return 1112;
       else 
    	   return 0;
    }
	public int shoStock(){
	   if(gc.shoStockList(20141111, 20141114)==null)
		   return 1112;
	   else 
		   return 0;
	}
	public int decreaseToMatch(GoodsVO g){
	   return gc.decreaseToMatch(g);
	}
	public int increaseToMatch(GoodsVO g){
	   return gc.increaseToMatch(g);
	}    
	
    public static void main(String[] args){
    	
    	GoodsBL_driver gd=new GoodsBL_driver("IP");
    	gd.driver();
    }
}
