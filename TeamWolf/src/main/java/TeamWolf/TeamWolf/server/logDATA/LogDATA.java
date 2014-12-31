package TeamWolf.TeamWolf.server.logDATA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import TeamWolf.TeamWolf.client.DATAservice.logDATAservice.LogDATAservice;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.INIPO;
import TeamWolf.TeamWolf.client.po.PromotionPO;
import TeamWolf.TeamWolf.client.po.TimePO;
import TeamWolf.TeamWolf.client.po.TypePO;
import TeamWolf.TeamWolf.client.po.UserPO;
import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.server.FileName;

public class LogDATA implements LogDATAservice, WriteLogService{
	static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public ArrayList<String> readLog() throws RemoteException {
		ArrayList<String> loglist = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FileName.logFile));
			String temp = null;
			while((temp = reader.readLine()) != null){
				loglist.add(temp);
			}
			reader.close();
			return loglist;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return loglist;
		}
	}

	public int addUser(UserPO po) {
		write("添加用户--ID:" + po.userName + " 密码:" + po.password + " 编号:" + po.workID + " 类型:" + po.power);
		return 0;
	}

	public int updateUser(UserPO po) {
		write("更新用户--ID:" + po.userName + " 密码:" + po.password + " 编号:" + po.workID + " 类型:" + po.power);
		return 0;
	}

	public int deleteUser(UserPO po) {
		write("删除用户--ID:" + po.userName + " 密码:" + po.password + " 编号:" + po.workID + " 类型:" + po.power);
		return 0;
	}

	public int addGoodsType(TypePO po) {
		if(po.getParent() != null)
			write("添加商品分类--分类名:" + po.getName() + " 分类编号:" + po.getNumber() + " 父类编号:" + po.getParent().getNumber());
		else
			write("添加商品分类--分类名:" + po.getName() + " 分类编号:" + po.getNumber() + " 父类编号:" + 0);
		return 0;
	}

	public int updateGoodsType(TypePO po) {
		if(po.getParent() != null)
			write("更新商品分类--分类名:" + po.getName() + " 分类编号:" + po.getNumber() + " 父类编号:" + po.getParent().getNumber());
		else
			write("更新商品分类--分类名:" + po.getName() + " 分类编号:" + po.getNumber() + " 父类编号:" + 0);
		return 0;
	}

	public int deleteGoodsType(TypePO po) {
		if(po.getParent() != null)
			write("删除商品分类--分类名:" + po.getName() + " 分类编号:" + po.getNumber() + " 父类编号:" + po.getParent().getNumber());
		else
			write("删除商品分类--分类名:" + po.getName() + " 分类编号:" + po.getNumber() + " 父类编号:" + 0);
		return 0;
	}

	public int addGoods(GoodsPO po) {
		write("添加商品--商品名:" + po.getName() + " 商品编号:" + po.getNumber() + " 父类名称:" + po.getParentName() + " 默认进价:" + po.getImprice() + " 默认售价:" + po.getExprice());
		return 0;
	}

	public int updateGoods(GoodsPO po) {
		write("更新商品--商品名:" + po.getName() + " 商品编号:" + po.getNumber() + " 父类名称:" + po.getParentName() + " 默认进价:" + po.getImprice() + " 默认售价:" + po.getExprice());
		return 0;
	}

	public int delectGoods(GoodsPO po) {
		write("删除商品--商品名:" + po.getName() + " 商品编号:" + po.getNumber() + " 父类名称:" + po.getParentName() + " 默认进价:" + po.getImprice() + " 默认售价:" + po.getExprice());
		return 0;
	}

	public int addCustomer(CustomerPO po) {
		write("添加客户--客户名:" + po.getName() + " 客户编号:" + po.getNum() + " 客户类型:" + po.getKind() + " 客户等级:" + po.getLevel() + " 默认业务员:" + po.getBusinessMan());
		return 0;
	}

	public int updateCustomer(CustomerPO po) {
		write("更新客户--客户名:" + po.getName() + " 客户编号:" + po.getNum() + " 客户类型:" + po.getKind() + " 客户等级:" + po.getLevel() + " 默认业务员:" + po.getBusinessMan());
		return 0;
	}

	public int deleteCustomer(CustomerPO po) {
		write("删除客户--客户名:" + po.getName() + " 客户编号:" + po.getNum() + " 客户类型:" + po.getKind() + " 客户等级:" + po.getLevel() + " 默认业务员:" + po.getBusinessMan());
		return 0;
	}

	public int addFinance(financePO po) {
		write("添加账户--账户名:" + po.getName() + " 账户余额:" + po.getAccount());
		return 0;
	}

	public int updateFinance(financePO po) {
		write("更新账户--账户名:" + po.getName() + " 账户余额:" + po.getAccount());
		return 0;
	}

	public int deleteFinance(financePO po) {
		write("删除账户--账户名:" + po.getName() + " 账户余额:" + po.getAccount());
		return 0;
	}

	public int addPromotion(PromotionPO po) {
		write("添加促销策略--促销策略类型:" + po.type + " 促销策略编号:" + po.number + " 促销策略持续时间:" + TimePO.sdf.format(po.begin) + "~~" + TimePO.sdf.format(po.end));
		return 0;
	}

	public int deletePromotion(PromotionPO po) {
		write("删除促销策略--促销策略类型:" + po.type + " 促销策略编号:" + po.number + " 促销策略持续时间:" + TimePO.sdf.format(po.begin) + "~~" + TimePO.sdf.format(po.end));
		return 0;
	}

	public int submitApplication(ApplicationPO po) {
		write("提交单据--单据编号:" + po.number + " 单据操作员:" + po.operator);
		return 0;
	}

	public int approveApplication(ApplicationPO po) {
		write("审批通过单据--单据编号" + po.number + " 单据操作员:" + po.operator);
		return 0;
	}

	public int rejectApplication(ApplicationPO po) {
		write("审批驳回单据--单据编号" + po.number + " 单据操作员:" + po.operator);
		return 0;
	}
	
	public int initial(INIPO po){
		write("第 " + (po.getNumber() + 1) + " 次期初建账");
		return 0;
	}
	
	private void write(String data){
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FileName.logFile, true));
			writer.write(sdf.format(date) + ">>" + data + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
