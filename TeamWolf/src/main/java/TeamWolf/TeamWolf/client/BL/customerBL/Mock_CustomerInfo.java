package TeamWolf.TeamWolf.client.BL.customerBL;

import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;

public class Mock_CustomerInfo extends CustomerInfo{
	
	CustomerVO vo;
	ImportListVO listvo;
	
	public Mock_CustomerInfo(String ID){
		super(ID);
		listvo = new ImportListVO("","","","",null,"REMARK");
		ImportListInfoMod(listvo);
	}
	
	public int ImportListInfoMod(ImportListVO vo){
		if(vo.getRemark().equals("REMARK")){
    		return 0;
    	}else{
    		return -1;
    	}
		
	}
}
