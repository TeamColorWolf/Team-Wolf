package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.ApproveDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;
/**
 * Author WHJ
 */
public class ApplicationBL {
	protected ArrayList<Application> list;
	protected ArrayList<ApplicationPO> poList;
	protected ArrayList<ApplicationVO> voList;
	protected String URL;
	protected ApproveDATAservice approve;
	
	public ApplicationBL(String IP){
		
	}
	
	protected ApplicationVO getVOfromPO(ApplicationPO po){
		String[] n = po.number.split("-");
		if(n[0].equals("JHD")){//进货单
			return new ImportListVO((ImportListPO)po);
		}
		else if(n[0].equals("JHTHD")){//进货退货单
			return new ImportRejectListVO((ImportRejectListPO)po);
		}
		else if(n[0].equals("XSD")){//销售单
			return new SaleListVO((SaleListPO)po);
		}
		else if(n[0].equals("XSTHD")){//销售退货单
			return new SaleRejectListVO((SaleRejectListPO)po);
		}
		return null;
	}
	
	protected ApplicationType getPOType(ApplicationPO po){
		String[] n = po.number.split("-");
		if(n[0].equals("JHD")){//进货单
			return ApplicationType.ImportList;
		}
		else if(n[0].equals("JHTHD")){//进货退货单
			return ApplicationType.ImportRejectList;
		}
		else if(n[0].equals("XSD")){//销售单
			return ApplicationType.SaleList;
		}
		else if(n[0].equals("XSTHD")){//销售退货单
			return ApplicationType.SaleRejectList;
		}
		//还有，待添加 TODO
		return null;
	}
	
}
