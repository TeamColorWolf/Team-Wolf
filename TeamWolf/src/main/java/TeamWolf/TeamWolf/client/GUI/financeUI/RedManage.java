package TeamWolf.TeamWolf.client.GUI.financeUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BLservice.tableInquireBLservice.TableInquireBLservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.FinanceApplicationDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.SaleApplicationDATAservice;
import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.StockApplicationDATAservice;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.GUI.tableInquireUI.RunProcessPanel;
import TeamWolf.TeamWolf.client.GUI.tableInquireUI.TableInquirePanel;
import TeamWolf.TeamWolf.client.po.CashApplicationPO;
import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.po.PaymentApplicationPO;
import TeamWolf.TeamWolf.client.po.RecieptApplicationPO;
import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;
import TeamWolf.TeamWolf.client.vo.RunProcessVO;

public class RedManage {

	TableInquireBLservice service = TableInquirePanel.service;
	Object[][] content;
	ArrayList<RunProcessVO> AppVOList;
	SaleApplicationDATAservice saleads;
	FinanceApplicationDATAservice fads;
	StockApplicationDATAservice stockads;
	String IP;
	String URLsale;
	String URLfinance;
	String URLstock;
	private static RunProcessPanel panel;
	private final static int BW = 80;
	private final static int BH = 25;

	public RedManage(String IP, RunProcessPanel Inputpanel) {

		URLsale = "rmi://" + IP + "/saleApplicationDATAservice";
		URLfinance = "rmi://" + IP + "/financeApplicationDATAservice";
		URLstock = "rmi://" + IP + "/stockApplicationDATAservice";
		DATAfactory();

		AppVOList = new ArrayList<RunProcessVO>();
		panel = new RunProcessPanel();
		this.panel = Inputpanel;
		JButton rdBut = new JButton("红冲");
		rdBut.setLocation(700, 410);
		rdBut.setSize(BW, BH);
		rdBut.setVisible(true);
		rdBut.addActionListener(new RedCheck());
		panel.add(rdBut);
	}

	public void DATAfactory() {
		try {
			saleads = (SaleApplicationDATAservice) Naming.lookup(URLsale);
			fads = (FinanceApplicationDATAservice) Naming.lookup(URLfinance);
			stockads = (StockApplicationDATAservice) Naming.lookup(URLstock);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	public void getContent() {
		ArrayList<RunProcessVO> list = service.runProcess(
				panel.timeSelect.getBeginVO(), panel.timeSelect.getEndVO());
		if (list == null || list.size() < 12) {
			content = new Object[12][7];
		} else {
			content = new Object[list.size()][7];
		}
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				content[i][0] = list.get(i).number;
				content[i][1] = list.get(i).customer;
				content[i][2] = list.get(i).operator;
				content[i][3] = list.get(i).storage;
				content[i][4] = list.get(i).goodsName;
				content[i][5] = list.get(i).goodsAmo;
				content[i][6] = list.get(i).price;
			}
			for (int i = list.size() - 1; i >= 0; i--) {
				String[] checkOne = ((String) content[i][0]).split("-");
				String[] checkTwo = ((String) content[i][0]).split("-");
				// if(!((String)content[i][0]).equals("")&&!content[i][0].equals(null)){
				System.out.println(checkOne[0]);
				System.out.println(checkOne[0]);
				if (checkOne[0].equals(checkTwo[0])) {
					AppVOList.add(list.get(i));
				} else {
					AppVOList.add(list.get(i));
					break;
				}
			}
		}
	}

	public int CreateNewApp() {
		String AppType = "";
		if (AppVOList != null) {
			String[] AppTypeArray = AppVOList.get(0).number.split("-");
			AppType = AppTypeArray[0];
		} else {
			return -1;
		}
		// ---------------------------------------------------------------------------------------------------------

		if (AppType.equals("JHD")) {
			String NUMBER = AppVOList.get(0).number;
			ArrayList<ImportListPO> poList = new ArrayList<ImportListPO>();
			ImportListPO old = null;
			try {
				poList = saleads.getImportList();
				for (int i = 0; i < poList.size(); i++) {
					if (NUMBER.equals(poList.get(i).number)) {
						old = poList.get(i);
						break;
					}
				}
				if (old == null) {
					MessageFrame mf = new MessageFrame(ErrorTW.webError);
					return -1;
				}
				String[] numberAdjustArray = old.number.split("-");
				double numberAdjust = Double.parseDouble(numberAdjustArray[2]) + 1;
				numberAdjustArray[2] = "" + numberAdjust;
				String newNumber = numberAdjustArray.toString();
				old.number = newNumber;
				ArrayList<GoodsPO> goodsList = old.getGoodsList();
				for (int i = 0; i < goodsList.size(); i++) {
					String oldNumber = goodsList.get(i).getNumber();
					String oppsiteNumber = ""
							+ (Double.parseDouble(oldNumber) * (-1));
					goodsList.get(i).setNumber(oppsiteNumber);
				}
				old.setGoodsList(goodsList);
				saleads.submitImportList(old);
				saleads.approvalImportList(old);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

		// -------------------------------------------------------------------------------------------------------

		else if (AppType.equals("JHTHD")) {
			String NUMBER = AppVOList.get(0).number;
			ArrayList<ImportRejectListPO> poList = new ArrayList<ImportRejectListPO>();
			ImportRejectListPO old = null;
			try {
				poList = saleads.getImportRejectList();
				for (int i = 0; i < poList.size(); i++) {
					if (NUMBER.equals(poList.get(i).number)) {
						old = poList.get(i);
						break;
					}
				}
				if (old == null) {
					MessageFrame mf = new MessageFrame(ErrorTW.webError);
					return -1;
				}
				String[] numberAdjustArray = old.number.split("-");
				double numberAdjust = Double.parseDouble(numberAdjustArray[2]) + 1;
				numberAdjustArray[2] = "" + numberAdjust;
				String newNumber = numberAdjustArray.toString();
				old.number = newNumber;
				ArrayList<GoodsPO> goodsList = old.getGoodsList();
				for (int i = 0; i < goodsList.size(); i++) {
					String oldNumber = goodsList.get(i).getNumber();
					String oppsiteNumber = ""
							+ (Double.parseDouble(oldNumber) * (-1));
					goodsList.get(i).setNumber(oppsiteNumber);
				}
				old.setGoodsList(goodsList);
				saleads.submitImportRejectList(old);
				saleads.approvalImportRejectList(old);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		// ---------------------------------------------------------------------------------------------------
		else if (AppType.equals("XSD")) {
			String NUMBER = AppVOList.get(0).number;
			ArrayList<SaleListPO> poList = new ArrayList<SaleListPO>();
			SaleListPO old = null;
			try {
				poList = saleads.getSaleList();
				for (int i = 0; i < poList.size(); i++) {
					if (NUMBER.equals(poList.get(i).number)) {
						old = poList.get(i);
						break;
					}
				}
				if (old == null) {
					MessageFrame mf = new MessageFrame(ErrorTW.webError);
					return -1;
				}
				String[] numberAdjustArray = old.number.split("-");
				double numberAdjust = Double.parseDouble(numberAdjustArray[2]) + 1;
				numberAdjustArray[2] = "" + numberAdjust;
				String newNumber = numberAdjustArray.toString();
				old.number = newNumber;
				ArrayList<GoodsPO> goodsList = old.getGoodsList();
				for (int i = 0; i < goodsList.size(); i++) {
					String oldNumber = goodsList.get(i).getNumber();
					String oppsiteNumber = ""
							+ (Double.parseDouble(oldNumber) * (-1));
					goodsList.get(i).setNumber(oppsiteNumber);
				}
				old.setGoodsList(goodsList);
				saleads.submitExportList(old);
				saleads.approvalExportList(old);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		// ------------------------------------------------------------------------------------------------------

		else if (AppType.equals("XSTHD")) {
			String NUMBER = AppVOList.get(0).number;
			ArrayList<SaleRejectListPO> poList = new ArrayList<SaleRejectListPO>();
			SaleRejectListPO old = null;
			try {
				poList = saleads.getSaleRejectList();
				for (int i = 0; i < poList.size(); i++) {
					if (NUMBER.equals(poList.get(i).number)) {
						old = poList.get(i);
						break;
					}
				}
				if (old == null) {
					MessageFrame mf = new MessageFrame(ErrorTW.webError);
					return -1;
				}
				String[] numberAdjustArray = old.number.split("-");
				double numberAdjust = Double.parseDouble(numberAdjustArray[2]) + 1;
				numberAdjustArray[2] = "" + numberAdjust;
				String newNumber = numberAdjustArray.toString();
				old.number = newNumber;
				ArrayList<GoodsPO> goodsList = old.getGoodsList();
				for (int i = 0; i < goodsList.size(); i++) {
					String oldNumber = goodsList.get(i).getNumber();
					String oppsiteNumber = ""
							+ (Double.parseDouble(oldNumber) * (-1));
					goodsList.get(i).setNumber(oppsiteNumber);
				}
				old.setGoodsList(goodsList);
				saleads.submitExportRejectList(old);
				saleads.submitExportRejectList(old);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

		// ------------------------------------------------------------------------------------------------------

		else if (AppType.equals("SKD")) {
			String NUMBER = AppVOList.get(0).number;
			ArrayList<RecieptApplicationPO> poList = new ArrayList<RecieptApplicationPO>();
			RecieptApplicationPO old = null;
			try {
				poList = fads.getAllRecieptList();
				for (int i = 0; i < poList.size(); i++) {
					if (NUMBER.equals(poList.get(i).number)) {
						old = poList.get(i);
						break;
					}
				}
				if (old == null) {
					MessageFrame mf = new MessageFrame(ErrorTW.webError);
					return -1;
				}
				String[] numberAdjustArray = old.number.split("-");
				double numberAdjust = Double.parseDouble(numberAdjustArray[2]) + 1;
				numberAdjustArray[2] = "" + numberAdjust;
				String newNumber = numberAdjustArray.toString();
				old.number = newNumber;
				ArrayList<String> moneyList = old.getMoneyList();
				for (int i = 0; i < moneyList.size(); i++) {
					String oldmoney = moneyList.get(i);
					String oppsiteNumber = ""
							+ (Double.parseDouble(oldmoney) * (-1));
					moneyList.set(i, oppsiteNumber);
				}
				old.setMoneyList(moneyList);
				fads.submitRecieptApplication(old);
				fads.approvalRecieptApplication(old);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		// ------------------------------------------------------------------------------------------------------

		else if (AppType.equals("FKD")) {
			String NUMBER = AppVOList.get(0).number;
			ArrayList<PaymentApplicationPO> poList = new ArrayList<PaymentApplicationPO>();
			PaymentApplicationPO old = null;
			try {
				poList = fads.getAllPaymentList();
				for (int i = 0; i < poList.size(); i++) {
					if (NUMBER.equals(poList.get(i).number)) {
						old = poList.get(i);
						break;
					}
				}
				if (old == null) {
					MessageFrame mf = new MessageFrame(ErrorTW.webError);
					return -1;
				}
				String[] numberAdjustArray = old.number.split("-");
				double numberAdjust = Double.parseDouble(numberAdjustArray[2]) + 1;
				numberAdjustArray[2] = "" + numberAdjust;
				String newNumber = numberAdjustArray.toString();
				old.number = newNumber;
				ArrayList<String> moneyList = old.getMoneyList();
				for (int i = 0; i < moneyList.size(); i++) {
					String oldmoney = moneyList.get(i);
					String oppsiteNumber = ""
							+ (Double.parseDouble(oldmoney) * (-1));
					moneyList.set(i, oppsiteNumber);
				}
				old.setMoneyList(moneyList);
				fads.submitPaymentApplication(old);
				fads.approvalPaymentApplication(old);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

		// ------------------------------------------------------------------------------------------------------

		else if (AppType.equals("XJFYD")) {
			String NUMBER = AppVOList.get(0).number;
			ArrayList<CashApplicationPO> poList = new ArrayList<CashApplicationPO>();
			CashApplicationPO old = null;
			try {
				poList = fads.getAllCashList();
				for (int i = 0; i < poList.size(); i++) {
					if (NUMBER.equals(poList.get(i).number)) {
						old = poList.get(i);
						break;
					}
				}
				if (old == null) {
					MessageFrame mf = new MessageFrame(ErrorTW.webError);
					return -1;
				}
				String[] numberAdjustArray = old.number.split("-");
				double numberAdjust = Double.parseDouble(numberAdjustArray[2]) + 1;
				numberAdjustArray[2] = "" + numberAdjust;
				String newNumber = numberAdjustArray.toString();
				old.number = newNumber;
				ArrayList<String> moneyList = old.getMoneyList();
				for (int i = 0; i < moneyList.size(); i++) {
					String oldmoney = moneyList.get(i);
					String oppsiteNumber = ""
							+ (Double.parseDouble(oldmoney) * (-1));
					moneyList.set(i, oppsiteNumber);
				}
				old.setMoneyList(moneyList);
				fads.submitCashApplication(old);
				fads.submitCashApplication(old);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

		// ------------------------------------------------------------------------------------------------------

		else {
			MessageFrame mf = new MessageFrame(ErrorTW.RedError);
			return -1;
		}

		// ------------------------------------------------------------------------------------------------------
		return 0;
	}

	public RunProcessPanel panelBack() {
		return panel;
	}

	class RedCheck implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			getContent();
			int success = CreateNewApp();
			if(success == 0){
				MessageFrame mf = new MessageFrame(0);
			}
			int lines = panel.content.length / 7;
		}

	}

}
