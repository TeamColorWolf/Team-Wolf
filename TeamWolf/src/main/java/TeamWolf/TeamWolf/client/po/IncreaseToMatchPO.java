package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;

public class IncreaseToMatchPO extends ApplicationPO implements Serializable {

	 public String[] toIncreaseInfo;
		
         
     public IncreaseToMatchPO(IncreaseToMatchVO vo){
    	 this.number=vo.number;
    	 this.operator=vo.operator;
    	 toIncreaseInfo=new String[5];
    	 toIncreaseInfo[0]=vo.getNumber();
    	 toIncreaseInfo[1]=vo.getName();
    	 toIncreaseInfo[2]=vo.getModel();
    	 toIncreaseInfo[3]=vo.getAmount();
    	 toIncreaseInfo[4]=vo.getImprice();
     }


	public String getInfo() {
		// TODO Auto-generated method stub
		return toIncreaseInfo[0]+" "+toIncreaseInfo[1]+" "+toIncreaseInfo[2]+" "+toIncreaseInfo[3];
	}
     
 
     
}
