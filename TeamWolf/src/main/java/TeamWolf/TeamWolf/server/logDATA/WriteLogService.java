package TeamWolf.TeamWolf.server.logDATA;

import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.INIPO;
import TeamWolf.TeamWolf.client.po.PromotionPO;
import TeamWolf.TeamWolf.client.po.TypePO;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.client.po.financePO;

public interface WriteLogService {
	public int addUser(UserPO po);
	public int updateUser(UserPO po);
	public int deleteUser(UserPO po);
	
	public int addGoodsType(TypePO po);
	public int updateGoodsType(TypePO po);
	public int deleteGoodsType(TypePO po);
	
	public int addGoods(GoodsPO po);
	public int updateGoods(GoodsPO po);
	public int delectGoods(GoodsPO po);
	
	public int addCustomer(CustomerPO po);
	public int updateCustomer(CustomerPO po);
	public int deleteCustomer(CustomerPO po);
	
	public int addFinance(financePO po);
	public int updateFinance(financePO po);
	public int deleteFinance(financePO po);
	
	public int addPromotion(PromotionPO po);
	public int deletePromotion(PromotionPO po);
	
	public int submitApplication(ApplicationPO po);
	public int approveApplication(ApplicationPO po);
	public int rejectApplication(ApplicationPO po);
	
	public int initial(INIPO po);
}
