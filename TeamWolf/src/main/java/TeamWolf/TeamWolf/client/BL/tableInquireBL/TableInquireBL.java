package TeamWolf.TeamWolf.client.BL.tableInquireBL;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.BL.applicationBL.MutiRoleService;
import TeamWolf.TeamWolf.client.BL.applicationBL.mutiRole.MutiRoleController;
import TeamWolf.TeamWolf.client.DATAservice.logDATAservice.LogDATAservice;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.DecreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.IncreaseToMatchVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.PresentListVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.RunConditionVO;
import TeamWolf.TeamWolf.client.vo.RunProcessVO;
import TeamWolf.TeamWolf.client.vo.SaleDetialSelectFactVO;
import TeamWolf.TeamWolf.client.vo.SaleDetialVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;
import TeamWolf.TeamWolf.client.vo.TimeVO;
import TeamWolf.TeamWolf.client.vo.financeVO;
/**
 * 
 * @author WHJ
 *
 */
public class TableInquireBL {
	//查表需求最后实现
	String IP;
	MutiRoleService data;
	LogDATAservice logdata;
	ArrayList<SaleDetialVO> saleDetial;
	ArrayList<RunProcessVO> runProcess;
	RunConditionVO runCondition;
	
	public TableInquireBL(String IP){
		this.IP = IP;
		data = new MutiRoleController(IP);
	}
	
	public ArrayList<SaleDetialVO> saleDetial(SaleDetialSelectFactVO vo, TimeVO begin, TimeVO end) {
		saleDetial = new ArrayList<SaleDetialVO>();
		ArrayList<ApplicationVO> applist = rightTimeList(begin, end);
		//填充SaleDetialVO信息
		if(applist != null){
			for(int i = 0; i < applist.size(); i++){
				ApplicationVO app = applist.get(i);
				if(app instanceof SaleListVO){
					SaleListVO sale = (SaleListVO)app;
					if(vo.customer == null || vo.customer.equals(sale.getCustomer().getName())){
						if(vo.storage == null || vo.storage.equals(sale.getStorage())){
							if(vo.workID == null || vo.workID.equals(sale.getSalesman())){
								ArrayList<GoodsVO> goodslist = sale.getGoodsList();
								if(goodslist != null){
									for(int j = 0; j < goodslist.size(); j++){
										if(vo.goodsName == null || vo.goodsName.equals(goodslist.get(j).getName())){
											GoodsVO goods = goodslist.get(j);
											SaleDetialVO detial = new SaleDetialVO(sale.number, sale.getCustomer().getName(), sale.getSalesman(), sale.getStorage(), goods.getName(), goods.getAmount(), goods.getExprice());
											saleDetial.add(detial);
										}
									}
								}
							}
						}
					}
				}
				else if(app instanceof SaleRejectListVO){
					SaleRejectListVO sale = (SaleRejectListVO)app;
					if(vo.customer == null || vo.customer.equals(sale.getCustomer().getName())){
						if(vo.storage == null || vo.storage.equals(sale.getStorage())){
							if(vo.workID == null || vo.workID.equals(sale.getSalesman())){
								ArrayList<GoodsVO> goodslist = sale.getGoodsList();
								if(goodslist != null){
									for(int j = 0; j < goodslist.size(); j++){
										if(vo.goodsName == null || vo.goodsName.equals(goodslist.get(j).getName())){
											GoodsVO goods = goodslist.get(j);
											SaleDetialVO detial = new SaleDetialVO(sale.number, sale.getCustomer().getName(), sale.getSalesman(), sale.getStorage(), goods.getName(), -goods.getAmount(), goods.getExprice());
											saleDetial.add(detial);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return saleDetial;
	}

	public ArrayList<RunProcessVO> runProcess(TimeVO time1, TimeVO time2) {
		ArrayList<ApplicationVO> applist = rightTimeList(time1, time2);
		runProcess = new ArrayList<RunProcessVO>();
		for(int i = 0; i < applist.size(); i++){
			ApplicationVO app = applist.get(i);
			//填充RunProcessVO信息
			if(app instanceof SaleListVO){
				SaleListVO sale = (SaleListVO)app;
				ArrayList<GoodsVO> goodslist = sale.getGoodsList();
				if(goodslist != null){
					for(int j = 0; j < goodslist.size(); j++){
						GoodsVO goods = goodslist.get(j);
						RunProcessVO process = new RunProcessVO(sale.number, sale.getCustomer().getName(), sale.getSalesman(), sale.getStorage(), goods.getName(), goods.getAmount(), goods.getExprice());
						runProcess.add(process);
					}
				}
			}
			else if(app instanceof SaleRejectListVO){
				SaleRejectListVO sale = (SaleRejectListVO)app;
				ArrayList<GoodsVO> goodslist = sale.getGoodsList();
				if(goodslist != null){
					for(int j = 0; j < goodslist.size(); j++){
						GoodsVO goods = goodslist.get(j);
						RunProcessVO process = new RunProcessVO(sale.number, sale.getCustomer().getName(), sale.getSalesman(), sale.getStorage(), goods.getName(), goods.getAmount(), goods.getExprice());
						runProcess.add(process);
					}
				}
			}
			else if(app instanceof ImportListVO){
				ImportListVO im = (ImportListVO)app;
				ArrayList<GoodsVO> goodslist = im.getGoodsList();
				if(goodslist != null){
					for(int j = 0; j < goodslist.size(); j++){
						GoodsVO goods = goodslist.get(j);
						RunProcessVO process = new RunProcessVO(im.number, im.getCustomer().getName(), null, im.getStorage(), goods.getName(), goods.getAmount(), goods.getImprice());
						runProcess.add(process);
					}
				}
			}
			else if(app instanceof ImportRejectListVO){
				ImportRejectListVO im = (ImportRejectListVO)app;
				ArrayList<GoodsVO> goodslist = im.getGoodsList();
				if(goodslist != null){
					for(int j = 0; j < goodslist.size(); j++){
						GoodsVO goods = goodslist.get(j);
						RunProcessVO process = new RunProcessVO(im.number, im.getCustomer().getName(), null, im.getStorage(), goods.getName(), goods.getAmount(), goods.getImprice());
						runProcess.add(process);
					}
				}
			}
			else if(app instanceof RecieptApplicationVO){
				RecieptApplicationVO ra = (RecieptApplicationVO)app;
				ArrayList<financeVO> flist = ra.getAccountList();
				ArrayList<String> mlist = ra.getMoneyList();
				if(flist != null){
					for(int j = 0; j < flist.size(); j++){
						RunProcessVO process = new RunProcessVO(ra.number, flist.get(j).getName(), ra.operator, null, null, 0, Double.parseDouble(mlist.get(j)));
						runProcess.add(process);
					}
				}
			}
			else if(app instanceof PaymentApplicationVO){
				PaymentApplicationVO ra = (PaymentApplicationVO)app;
				ArrayList<financeVO> flist = ra.getAccountList();
				ArrayList<String> mlist = ra.getMoneyList();
				if(flist != null){
					for(int j = 0; j < flist.size(); j++){
						RunProcessVO process = new RunProcessVO(ra.number, flist.get(j).getName(), ra.operator, null, null, 0, Double.parseDouble(mlist.get(j)));
						runProcess.add(process);
					}
				}
			}
			else if(app instanceof CashApplicationVO){
				CashApplicationVO ra = (CashApplicationVO)app;
				ArrayList<financeVO> flist = ra.getAccountList();
				ArrayList<String> mlist = ra.getMoneyList();
				if(flist != null){
					for(int j = 0; j < flist.size(); j++){
						RunProcessVO process = new RunProcessVO(ra.number, flist.get(j).getName(), ra.operator, null, null, 0, Double.parseDouble(mlist.get(j)));
						runProcess.add(process);
					}
				}
			}
		}
		return runProcess;
	}

	public RunConditionVO runCondition(TimeVO time1, TimeVO time2) {
		runCondition = new RunConditionVO();
		ArrayList<ApplicationVO> applist = rightTimeList(time1, time2);
		for(int i = 0; i < applist.size(); i++){
			ApplicationVO app = applist.get(i);
			//填充RunConditionVO信息
			if(app instanceof SaleListVO){
				SaleListVO sale = (SaleListVO)app;
				runCondition.discount += sale.getDiscount();
				runCondition.saleIncome += sale.getTotal();
			}
			else if(app instanceof SaleRejectListVO){
				SaleRejectListVO sale = (SaleRejectListVO)app;
				runCondition.discount -= sale.getDiscount();
				runCondition.saleIncome -= sale.getTotal();
			}
			else if(app instanceof ImportListVO){
				ImportListVO im = (ImportListVO)app;
				runCondition.SaleOutcome += im.getTotal();
			}
			else if(app instanceof ImportRejectListVO){
				ImportRejectListVO im = (ImportRejectListVO)app;
				runCondition.saleIncome -= im.getTotal();
			}
			else if(app instanceof IncreaseToMatchVO){
				IncreaseToMatchVO itm = (IncreaseToMatchVO)app;
				runCondition.stockIncome += Integer.parseInt(itm.getAmount()) * Double.parseDouble(itm.getImprice());
			}
			else if(app instanceof DecreaseToMatchVO){
				DecreaseToMatchVO dtm = (DecreaseToMatchVO)app;
				runCondition.StockOutcome += Integer.parseInt(dtm.getAmount()) * Double.parseDouble(dtm.getImprice());
			}
			else if(app instanceof PresentListVO){
				PresentListVO pl = (PresentListVO)app;
				ArrayList<GoodsVO> glist = pl.getPList();
				if(glist != null){
					for(int j = 0; j < glist.size(); j++){
						runCondition.StockOutcome += glist.get(j).getImprice() * glist.get(j).getAmount();
					}
				}
			}
			runCondition.profit = runCondition.saleIncome + runCondition.stockIncome - runCondition.discount - runCondition.SaleOutcome - runCondition.StockOutcome;
		}
		return runCondition;
	}
	
	public ArrayList<String> logCheck(){
		try {
			logdata = (LogDATAservice)Naming.lookup("rmi://" + IP + "/logDATAservice");
			return logdata.readLog();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 该方法内部调用
	 * @return
	 */
	private ArrayList<ApplicationVO> getAllApplication(){
		return data.getApprovalApplicationList();
	}
	
	private ArrayList<ApplicationVO> rightTimeList(TimeVO begin, TimeVO end){
		ArrayList<ApplicationVO> templist = getAllApplication();
		ArrayList<ApplicationVO> list = new ArrayList<ApplicationVO>();
		if(templist != null){
			for(int i = 0; i < templist.size(); i++){
				TimeVO app = getAppTime(templist.get(i));
				if(app.timeCompare(begin) >= 0 && app.timeCompare(end) <= 0){
					list.add(templist.get(i));
				}
			}
		}
		return list;
	}
	
	private TimeVO getAppTime(ApplicationVO vo){
		String[] n = vo.number.split("-");
		return new TimeVO(n[1].substring(0, 4), n[1].substring(4, 6), n[1].substring(6, 8));
	}
}
