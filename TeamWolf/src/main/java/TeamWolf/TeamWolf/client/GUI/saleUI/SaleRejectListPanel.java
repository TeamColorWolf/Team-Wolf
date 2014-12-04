package TeamWolf.TeamWolf.client.GUI.saleUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import TeamWolf.TeamWolf.client.BL.saleBL.SaleBLController;
import TeamWolf.TeamWolf.client.BLservice.saleBLservice.SaleBLservice;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

/**
 * 
 * @author HalaWKS
 *
 */
public class SaleRejectListPanel extends JPanel{
	
	SaleBLservice saleLogic;
	
	public static ArrayList<SaleListVO> saleList;
	ArrayList<SaleRejectListVO> saleRejectList;
	ArrayList<GoodsVO> goodsList;
	
	private DefaultTableModel tModel_sale;
	private DefaultTableModel tModel_goods;
	private JTable saleListTable;
	private JTable goodsInfoTable;
	private JScrollPane scroll_sale;
	private JScrollPane scroll_goods;
	JButton submitBtn;
	JButton showBtn;
	JTextArea remarkArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(remarkArea);
	
	private String[] goodsInfo = {"商品名称", "商品数量", "商品单价", "单项商品总价"};
	private Object[][] object_goodsList;
	
	private String[] saleInfo = {"选择", "编号", "销售商", "折让金额", "折让后总额", "备注"};
	private Object[][] object_saleList;
	
	/**
	 * 面板宽度
	 */
	private static final int w = 1300;
	
	/**
	 * 面板高度
	 */
	private static final int h = 600;	
	
	/**
	 * 组件宽度(不包括按钮)
	 */
	private static final int conpW = 200;
	
	/**
	 * 组件高度(不包括按钮)
	 */
	private static final int conpH = 60;
	
	/**
	 * 按钮宽、高
	 */
	private static final int btnW = 150;
	private static final int btnH = 40;
	
	/**
	 * 组件间距
	 */
	private static final int Xgap = 100;
	
	/**
	 * 字体
	 */
	Font ChooseBtn_FONT = new Font("黑体", Font.BOLD, 16);
	
	public SaleRejectListPanel(UserVO user, String ip) {
		saleLogic = new SaleBLController(ip);
		
		saleList = saleLogic.getSaleList();
		saleRejectList = saleLogic.getSaleRejectList();
		if(saleList == null){
			saleList = new ArrayList<SaleListVO>();
		}
		if(saleRejectList == null){
			saleRejectList = new ArrayList<SaleRejectListVO>();
		}
		//设置布局方式
		this.setLayout(null);
		//设置大小
		this.setSize(w, h);
		//添加组件
		this.add(this.createSaleList());
		this.add(this.createGoodsInfo());
		this.add(this.remarkFld());
		this.add(this.showBtn());
		this.add(this.submitBtn());
		
		this.setVisible(true);
	}
	
	/**
	 * 表格显示进货单
	 * @return
	 */
	private JScrollPane createSaleList(){
		tModel_sale = new DefaultTableModel(object_saleList, saleInfo);
		saleListTable = new JTable(tModel_sale);
		scroll_sale = new JScrollPane(saleListTable);
		
		//表格设置
		saleListTable.setRowHeight(30);
		TableColumn tc0 = saleListTable.getColumnModel().getColumn(0);
		tc0.setCellEditor(saleListTable.getDefaultEditor(Boolean.class));
		tc0.setCellRenderer(saleListTable.getDefaultRenderer(Boolean.class));
	
		saleListTable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				int row = saleListTable.getSelectedRow();
				clearGoodsInfoTable();
				showGoodsInfo(row);
			}
		});
		
		//scroll设置
		scroll_sale.setSize(w / 2 - 10, 400);
		scroll_sale.setLocation(0, 0);
		
		return scroll_sale;
	}
	
	/**
	 * 商品信息显示面板
	 * @return
	 */
	private JScrollPane createGoodsInfo(){
		tModel_goods = new DefaultTableModel(object_goodsList, goodsInfo);
		goodsInfoTable = new JTable(tModel_goods);
		scroll_goods = new JScrollPane(goodsInfoTable);
		
		//表格设置
		saleListTable.setRowHeight(30);
		scroll_goods.setSize(w / 2 - 10, 400);
		scroll_goods.setLocation(w / 2, 0);

		return scroll_goods;
	}
	
	/**
	 * 备注填写
	 * @return
	 */
	private JScrollPane remarkFld(){
		
		scrollPane.setSize(conpW * 2, conpH * 3 / 2);
		scrollPane.setLocation(Xgap, scroll_sale.getHeight() + 5);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		scrollPane.setBorder(BorderFactory.createTitledBorder("备注填写"));
		scrollPane.setEnabled(true);
		
		return scrollPane;
	}
	
	/**
	 * 提交按钮
	 * @return
	 */
	private JButton submitBtn(){
		submitBtn = new JButton("提交");
		
		//button设置
		submitBtn.setSize(btnW, btnH);
		submitBtn.setLocation(2 * Xgap + conpW * 2 + 3 * Xgap, scroll_sale.getHeight() + 40);
		submitBtn.setFont(ChooseBtn_FONT);
		
		submitBtn.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {	
				subBtnAction();
			}
		});
		
		return submitBtn;
	}
	
	/**
	 * 显示按钮
	 * @return
	 */
	private JButton showBtn(){
		showBtn = new JButton("显示");
		
		showBtn.setSize(btnW, btnH);
		showBtn.setLocation(2 * Xgap + conpW * 2, scroll_sale.getHeight() + 40);
		showBtn.setFont(ChooseBtn_FONT);
		
		showBtn.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {	
				showBtnAction();
			}
		});
		
		return showBtn;
	}
	
	/**
	 * 在右边table里显示商品信息
	 */
	private void showGoodsInfo(int index){
		goodsInfoTable.setRowHeight(25);
		goodsList = saleList.get(index).getGoodsList();
		tModel_goods = (DefaultTableModel) goodsInfoTable.getModel();
		object_goodsList = new Object[goodsList.size()][4];
		for (int i = 0; i < goodsList.size(); i++) {
			GoodsVO gvo = goodsList.get(i);

			object_goodsList[i][0] = gvo.getName();
			object_goodsList[i][1] = gvo.getAmount();
			object_goodsList[i][2] = gvo.getExprice();
			object_goodsList[i][3] = gvo.getAmount() * gvo.getExprice();

		}
		tModel_goods.setDataVector(object_goodsList, goodsInfo);
		goodsInfoTable.updateUI();
	}
	
	/**
	 * 显示按钮事件
	 */
	private void showBtnAction(){
		clearSaleInfoTable();
//		saleList = TestMain.getSaleListTEST();
		tModel_sale = (DefaultTableModel) saleListTable.getModel();
		
		for (int i = 0; i < saleList.size(); i++) {
			SaleListVO svo = saleList.get(i);

			Object[] data = new Object[6];
			data[0] = new Boolean(false);
			data[1] = svo.number;
			data[2] = svo.getCustomer().getName();
			data[3] = svo.getDiscount();
			data[4] = svo.getTotalAfterDiscount();
			data[5] = svo.getRemark();
			
			tModel_sale.addRow(data);
			saleListTable.setModel(tModel_sale);
		}
		
	}
	
	/**
	 * 提交按钮事件
	 */
	private void subBtnAction(){
		SaleListVO svo = null;
		for (int i = 0; i < saleList.size(); i++) {
			if(saleListTable.getValueAt(i, 0).equals(true)){
				svo = saleList.get(i);
				//从当前界面持有的SaleList里删除该对应进货单，以免重复退货
				saleList.remove(i);
			}
		}
		if(svo == null){
			return;
		}
		SaleRejectListVO srvo = new SaleRejectListVO(saleRejectListNum(), remarkArea.getText(), svo);
		srvo.condition = 0;
		System.out.println(srvo.number);
		
		//显示退货之后剩余进货单
		showBtnAction();
		//清空商品显示table
		clearGoodsInfoTable();
		
		saleLogic.createSaleReject(srvo);
	}
	
	/**
	 * 获取单据编号
	 */
	private String saleRejectListNum(){
		String num = "XSTHD-";
		String date = saleLogic.getPresentDate();
		String number = String.format("%05d", saleRejectList.size() + 1);
		num = num + date + "-" + number;
		return num;
	}
	
	/**
	 * 清空SaleList表格
	 */
	private void clearSaleInfoTable(){
		object_saleList = null;
		tModel_sale.setDataVector(object_saleList, saleInfo);
		TableColumn tc0 = saleListTable.getColumnModel().getColumn(0);
		tc0.setCellEditor(saleListTable.getDefaultEditor(Boolean.class));
		tc0.setCellRenderer(saleListTable.getDefaultRenderer(Boolean.class));
		saleListTable.updateUI();
	}
	
	/**
	 * 清空商品信息表格
	 */
	private void clearGoodsInfoTable(){
		object_goodsList = null;
		tModel_goods.setDataVector(object_goodsList, goodsInfo);
		goodsInfoTable.setRowHeight(25);
		goodsInfoTable.updateUI();
	}
	
}
