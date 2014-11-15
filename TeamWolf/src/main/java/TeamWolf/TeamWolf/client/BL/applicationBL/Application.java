package TeamWolf.TeamWolf.client.BL.applicationBL;

import TeamWolf.TeamWolf.client.BL.customerBL.CustomerController;
import TeamWolf.TeamWolf.client.BL.goodsBL.GoodsBLController;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.SaleApplicationDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.StockApplicationDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
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
	
	public Application(ApplicationVO vo, String URL){
		
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
}
