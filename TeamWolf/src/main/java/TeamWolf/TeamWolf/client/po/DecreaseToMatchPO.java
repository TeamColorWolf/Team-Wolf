package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;

public class DecreaseToMatchPO extends ApplicationPO implements Serializable{

	 String toDecreaseInfo;		    
     
	 public DecreaseToMatchPO(DecreaseToMatchVO vo){
		 toDecreaseInfo=vo.getInfo();
	 }
	 
     public String getInfo(){
   	  return toDecreaseInfo;
     }
     
}
