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
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

/**
 * 
 * @author HalaWKS
 *
 */
public class ImportRejectListPanel extends JPanel{
	
	SaleBLservice saleLogic;
	
	public static ArrayList<ImportListVO> importList;
	ArrayList<ImportRejectListVO> importRejectList;
	ArrayList<GoodsVO> goodsList;
	
	private DefaultTableModel tModel_import;
	private DefaultTableModel tModel_goods;
	private JTable importListTable;
	private JTable goodsInfoTable;
	private JScrollPane scroll_import;
	private JScrollPane scroll_goods;
	JButton submitBtn;
	JButton showBtn;
	JTextArea remarkArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(remarkArea);
	
	private String[] goodsInfo = {"商品名称", "商品数量", "商品单价", "单项商品总价"};
	private Object[][] object_goodsList;
	
	private String[] importInfo = {"选择", "编号", "进货商", "总额合计", "备注"};
	private Object[][] object_importList;

	/**
	 * 面板宽度
	 */
	private static final int w = 1300;
	
	/**
	 * 面板高度
	 */
	private static final int h = 600;	
	
	/**
	 * 按钮宽、高
	 */
	private static final int btnW = 150;
	private static final int btnH = 40;
	
	/**
	 * 组件宽度(不包括按钮)
	 */
	private static final int conpW = 200;
	
	/**
	 * 组件高度(不包括按钮)
	 */
	private static final int conpH = 60;
	
	/**
	 * 组件间距
	 */
	private static final int Xgap = 100;
	
	/**
	 * 字体
	 */
	Font ChooseBtn_FONT = new Font("黑体", Font.BOLD, 16);
	
	public ImportRejectListPanel(UserVO user, String IP) {
		saleLogic = new SaleBLController(IP);

		importList = saleLogic.getImportList();
		importRejectList = saleLogic.getImportRejectList();
		if(importList == null){
			importList = new ArrayList<ImportListVO>();
		}
		if(importRejectList == null){
			importRejectList = new ArrayList<ImportRejectListVO>();
		}
		//设置布局方式
		this.setLayout(null);
		//设置大小
		this.setSize(w, h);
		//添加组件
		this.add(this.createImportList());
		this.add(this.createGoodsInfo());
		this.add(this.submitBtn());
		this.add(this.showBtn());
		this.add(this.remarkFld());
		
	}
	
	/**
	 * 商品信息显示面板
	 * @return
	 */
	private JScrollPane createGoodsInfo(){
		tModel_goods = new DefaultTableModel(new Object[][] {}, goodsInfo);
		goodsInfoTable = new JTable(tModel_goods);
		scroll_goods = new JScrollPane(goodsInfoTable);
		
		//表格设置
		importListTable.setRowHeight(30);
		scroll_goods.setSize(w / 2 - 10, 400);
		scroll_goods.setLocation(w / 2, 0);
		
		
		return scroll_goods;
	}
	
	/**
	 * 表格显示进货单
	 * @return
	 */
	private JScrollPane createImportList(){
		tModel_import = new DefaultTableModel(object_importList, importInfo);
		importListTable = new JTable(tModel_import);
		scroll_import = new JScrollPane(importListTable);
		
		//表格设置
		importListTable.setRowHeight(30);
		TableColumn tc0 = importListTable.getColumnModel().getColumn(0);
		tc0.setCellEditor(importListTable.getDefaultEditor(Boolean.class));
		tc0.setCellRenderer(importListTable.getDefaultRenderer(Boolean.class));
	
		importListTable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				int row = importListTable.getSelectedRow();
				clearGoodsInfoTable();
				showGoodsInfo(row);
			}
		});
		
		//scroll设置
		scroll_import.setSize(w / 2 - 10, 400);
		scroll_import.setLocation(0, 0);
		
		return scroll_import;
	}

	/**
	 * 在右边table里显示商品信息
	 */
	private void showGoodsInfo(int index){
		goodsInfoTable.setRowHeight(25);
		goodsList = importList.get(index).getGoodsList();
		tModel_goods = (DefaultTableModel) goodsInfoTable.getModel();
		object_goodsList = new Object[goodsList.size()][4];
		for (int i = 0; i < goodsList.size(); i++) {
			GoodsVO gvo = goodsList.get(i);

			object_goodsList[i][0] = gvo.getName();
			object_goodsList[i][1] = gvo.getAmount();
			object_goodsList[i][2] = gvo.getImprice();
			object_goodsList[i][3] = gvo.getAmount() * gvo.getImprice();
		
			
		}
		tModel_goods.setDataVector(object_goodsList, goodsInfo);
		goodsInfoTable.updateUI();
	}
	
	/**
	 * 备注填写
	 * @return
	 */
	private JScrollPane remarkFld(){
		
		scrollPane.setSize(conpW * 2, conpH * 3 / 2);
		scrollPane.setLocation(Xgap, scroll_import.getHeight() + 5);
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
		submitBtn.setLocation(2 * Xgap + conpW * 2 + 3 * Xgap, scroll_import.getHeight() + 40);
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
		showBtn.setLocation(2 * Xgap + conpW * 2, scroll_import.getHeight() + 40);
		showBtn.setFont(ChooseBtn_FONT);
		
		showBtn.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {	
				showBtnAction();
			}
		});
		
		return showBtn;
	}
	
	/**
	 * 显示按钮事件
	 */
	private void showBtnAction(){
//		clearImportInfoTable();
//		importList = TestMain.getImportListTEST();
		tModel_import = (DefaultTableModel) importListTable.getModel();
		
		for (int i = 0; i < importList.size(); i++) {
			
			ImportListVO ivo = importList.get(i);

			Object[] data = new Object[5];
			data[0] = new Boolean(false);
			data[1] = ivo.number;
			data[2] = ivo.getCustomer().getName();
			data[3] = ivo.getTotal();
			data[4] = ivo.getRemark();
			
			tModel_import.addRow(data);
			importListTable.setModel(tModel_import);
		}
		
		showBtn.setEnabled(false);
	}
	
	/**
	 * 提交按钮事件
	 */
	private void subBtnAction(){
		ImportListVO ivo = null;
		for (int i = 0; i < importList.size(); i++) {
			if(importListTable.getValueAt(i, 0).equals(true)){
				ivo = importList.get(i);
			}
		}
		if(ivo == null){
			return;
		}
		ImportRejectListVO irvo = new ImportRejectListVO(importRejectListNum(),
				remarkArea.getText(), ivo);
		irvo.condition = 0;
		
		saleLogic.createImportReject(irvo);
	}
	
	private String importRejectListNum(){
		String num = "JHTHD-";
		String date = saleLogic.getPresentDate();
		String number = String.format("%05d", importRejectList.size() + 1);
		num = num + date + "-" + number;
		return num;
	}

	
	/**
	 * 清空表格方法
	 */
	private void clearGoodsInfoTable(){
		object_goodsList = null;
		tModel_goods.setDataVector(object_goodsList, goodsInfo);
		goodsInfoTable.updateUI();
	}
}
