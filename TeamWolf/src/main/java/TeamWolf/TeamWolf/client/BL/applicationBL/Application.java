package TeamWolf.TeamWolf.client.BL.applicationBL;

import TeamWolf.TeamWolf.client.BL.applicationBL.forSale.ImportList;
import TeamWolf.TeamWolf.client.BL.applicationBL.forSale.ImportRejectList;
import TeamWolf.TeamWolf.client.BL.applicationBL.forSale.SaleList;
import TeamWolf.TeamWolf.client.BL.applicationBL.forSale.SaleRejectList;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerController;
import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.SaleApplicationDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.StockApplicationDATAservice;
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
//所有方法需要 @Override 验证确保覆盖了
/**
 * 
 * @author WHJ
 *
 */
public abstract class Application {
	protected ApplicationType type;
	protected int condition;//0 表示未审批， 1 表示审批通过， -1表示审批不通过
	protected GoodsBLController goodsController;
	protected CustomerController customerController;
	
	protected FinanceApplicationDATAservice finance;
	protected StockApplicationDATAservice stock;
	protected SaleApplicationDATAservice sale;
	
	public Application(ApplicationVO vo, String IP){
		
	}
	
	public abstract ApplicationVO getApplicationVO();
	
	public abstract ApplicationPO getApplicationPO();
	
	public abstract int submit();
	
	public int getResult(){
		return condition;
	}
	
	public abstract int approve();
	
	public abstract int reject();
	
	public abstract int change(ApplicationVO vo);
	
	public ApplicationType getApplicationType(){
		return type;
	}
	
	public static Application getApplication(ApplicationVO vo, String IP){
		String[] n = vo.number.split("-");
		if(n[0].equals("JHD")){//进货单
			return new ImportList((ImportListVO)vo, IP);
		}
		else if(n[0].equals("JHTHD")){//进货退货单
			return new ImportRejectList((ImportRejectListVO)vo, IP);
		}
		else if(n[0].equals("XSD")){//销售单
			return new SaleList((SaleListVO)vo, IP);
		}
		else if(n[0].equals("XSTHD")){//销售退货单
			return new SaleRejectList((SaleRejectListVO)vo, IP);
		}
//		else if(n[0].equals("KCBYD")){//库存报溢单
//			return new IncreaseToMatch((IncreaseToMatchVO)vo); TODO
//		}
//		else if(n[0].equals("KCBSD")){//库存报损单
//			return new DecreaseToMatch((DecreaseToMatchVO)vo); TODO
//		}
//		else if(n[0].equals("FKD")){//付款单
//			return new PaymentApplication((PaymentApplicationVO)vo); TODO
//		}
//		else if(n[0].equals("SKD")){//收款单
//			return new RecieptApplication((RecieptApplicationVO)vo); TODO
//		}
//		else if(n[0].equals("XJFYD")){//现金费用单
//			return new CashApplication((CashApplicationVO)vo); TODO
//		}
		return null;
	}
}
