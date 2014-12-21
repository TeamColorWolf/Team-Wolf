package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;

public class DecreaseToMatchPO extends ApplicationPO implements Serializable{

	 public String[] toDecreaseInfo;		    
     
	 public DecreaseToMatchPO(DecreaseToMatchVO vo){
		 this.number=vo.number;
		 this.operator=vo.operator;
		 toDecreaseInfo=new String[5];
    	 toDecreaseInfo[0]=vo.getNumber();
    	 toDecreaseInfo[1]=vo.getName();
    	 toDecreaseInfo[2]=vo.getModel();
    	 toDecreaseInfo[3]=vo.getAmount();
    	 toDecreaseInfo[4]=vo.getImprice();
	 }

	public String getInfo() {
		// TODO Auto-generated method stub
		return toDecreaseInfo[0]+" "+toDecreaseInfo[1]+" "+toDecreaseInfo[2]+" "+toDecreaseInfo[3];
	}
     
}
