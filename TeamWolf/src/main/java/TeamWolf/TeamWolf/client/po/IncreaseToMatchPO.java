package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;

public class IncreaseToMatchPO extends ApplicationPO implements Serializable {

	 String toIncreaseInfo;
		
         
     public IncreaseToMatchPO(IncreaseToMatchVO vo){
    	 this.toIncreaseInfo=vo.getInfo();
     }
     
     public String getInfo(){
   	  return toIncreaseInfo;
     }
     
}
