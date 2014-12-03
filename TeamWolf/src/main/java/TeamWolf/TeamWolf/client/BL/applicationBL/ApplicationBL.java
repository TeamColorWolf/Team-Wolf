package TeamWolf.TeamWolf.client.BL.applicationBL;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.ApproveDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.po.DecreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.po.IncreaseToMatchPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
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
	protected String IP;
	protected ApproveDATAservice approve;
	
	public ApplicationBL(String IP){
		this.IP = IP;
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
		else if(n[0].equals("KCBYD")){//库存报溢单
//			return new IncreaseToMatchVO((IncreaseToMatchPO)po); TODO
		}
		else if(n[0].equals("KCBSD")){//库存报损单
//			return new DecreaseToMatchVO((DecreaseToMatchPO)po); TODO
		}
		else if(n[0].equals("FKD")){//付款单
//			return new PaymentApplicationVO((PaymentApplicationPO)po); TODO
		}
		else if(n[0].equals("SKD")){//收款单
//			return new RecieptApplicationVO((RecieptApplicationPO)po); TODO
		}
		else if(n[0].equals("XJFYD")){//现金费用单
//			return new CashApplicationVO((CashApplicationPO)po); TODO
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
		else if(n[0].equals("KCBYD")){//库存报溢单
			return ApplicationType.IncreaseToMatch;
		}
		else if(n[0].equals("KCBSD")){//库存报损单
			return ApplicationType.DecreaseToMatch;
		}
		else if(n[0].equals("FKD")){//付款单
			return ApplicationType.PaymentApplication;
		}
		else if(n[0].equals("SKD")){//收款单
			return ApplicationType.RecieptApplication;
		}
		else if(n[0].equals("XJFYD")){//现金费用单
			return ApplicationType.CashApplication;
		}
		return null;
	}
	
}
