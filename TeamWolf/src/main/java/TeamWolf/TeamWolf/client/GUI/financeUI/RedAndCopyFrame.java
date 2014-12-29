package TeamWolf.TeamWolf.client.GUI.financeUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.applicationBL.forSale.ImportList;
import TeamWolf.TeamWolf.client.BL.applicationBL.forSale.ImportRejectList;
import TeamWolf.TeamWolf.client.BL.financeBL.Initial;
import TeamWolf.TeamWolf.client.BLservice.financeBLservice.InitialBLservice;
import TeamWolf.TeamWolf.client.GUI.financeUI.INIAccount.HistoryListener;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.GUI.saleUI.ImportListPanel;
import TeamWolf.TeamWolf.client.GUI.saleUI.ImportRejectListPanel;
import TeamWolf.TeamWolf.client.GUI.saleUI.SaleListPanel;
import TeamWolf.TeamWolf.client.GUI.saleUI.SaleRejectListPanel;
import TeamWolf.TeamWolf.client.vo.INIVO;

public class RedAndCopyFrame extends JFrame{
	String IP;
	String Content="";
	
	PaymentPanel pp;
	CashPanel cp;
	ReceiptPanel rp;
	ImportListPanel ilp;
	ImportRejectListPanel irlp;
	SaleListPanel slp;
	SaleRejectListPanel srlp;
	
	JTabbedPane tab = new JTabbedPane();
	public static final int width = 960;
	public static final int height = 640;
	public static final int LH = 25;
	public static final int LL = 200;
	public RedAndCopyFrame(String IP,int number){
		super("新单据信息输入");
		this.IP = IP;
		tab.setSize(width, height);
		tab.setVisible(true);
		
		switch(number){
		case 1:
		      ilp = new ImportListPanel(FinanceFrame.user, IP);
              tab.add(ilp,"根据上一个单据复制新的单据并进行创建——进货单");
		      break;
		case 2:
			  irlp = new ImportRejectListPanel(FinanceFrame.user, IP);
			  tab.add(irlp,"根据上一个单据复制新的单据并进行创建——进货退货单");
			  break;
		case 3:
			  slp = new SaleListPanel(FinanceFrame.user, IP);
			  tab.add(slp,"根据上一个单据复制新的单据并进行创建——销售单");
			  break;
		case 4:
			  srlp = new SaleRejectListPanel(FinanceFrame.user, IP);
			  tab.add(srlp,"根据上一个单据复制新的单据并进行创建——销售退货单");
			  break;
		case 5:
			  rp = new ReceiptPanel(IP);
			  tab.add(rp,"根据上一个单据复制新的单据并进行创建——收款单");
			  break;
		case 6:
			  pp = new PaymentPanel(IP);
			  tab.add(pp,"根据上一个单据复制新的单据并进行创建——付款单");
			  break;
		case 7:
			  cp = new CashPanel(IP);
			  tab.add(cp,"根据上一个单据复制新的单据并进行创建——现金费用单");
			  break;
			
		}
		
		this.setSize(width, height);
		this.getFocusableWindowState();
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);

		this.add(tab);
		this.setVisible(true);
	}

}

