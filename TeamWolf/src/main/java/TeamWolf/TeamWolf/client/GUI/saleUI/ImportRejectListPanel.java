package TeamWolf.TeamWolf.client.GUI.saleUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import TeamWolf.TeamWolf.client.BL.saleBL.SaleBLController;
import TeamWolf.TeamWolf.client.BLservice.saleBLservice.SaleBLservice;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

/**
 * 
 * @author HalaWKS
 *
 */
public class ImportRejectListPanel extends JPanel{
	
	SaleBLservice saleLogic;
	
	ArrayList<ImportListVO> importList;
	
	private DefaultTableModel tModel;
	private JTable importListTable;
	private JScrollPane scroll;
	
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
	private static final int Ygap = 30;
	
	/**
	 * 字体
	 */
	Font ChooseBtn_FONT = new Font("黑体", Font.BOLD, 16);
	
	public ImportRejectListPanel(UserVO user, String IP) {
		saleLogic = new SaleBLController(IP);
		
		//设置布局方式
		this.setLayout(null);
		//设置大小
		this.setSize(w, h);
		//添加组件
		this.add(this.createImportList());
		this.add(this.submitBtn());
		this.add(this.showBtn());
		
	}
	
	/**
	 * 表格显示进货单
	 * @return
	 */
	private JScrollPane createImportList(){
		tModel = new DefaultTableModel(new Object[][] {}, new String[] {"选择", 
				"编号", "进货商", "进货商品显示", "商品数量", "总额合计", "备注"});
		importListTable = new JTable(tModel);
		scroll = new JScrollPane(importListTable);
		
		//表格设置
		TableColumn tc0 = importListTable.getColumnModel().getColumn(0);
		tc0.setCellEditor(importListTable.getDefaultEditor(Boolean.class));
		tc0.setCellRenderer(importListTable.getDefaultRenderer(Boolean.class));
		
		JComboBox<String> combo = new JComboBox<String>();
		
		TableColumn tc3 = importListTable.getColumnModel().getColumn(3);
		tc3.setCellEditor(new DefaultCellEditor(combo));
		
		//scroll设置
		scroll.setSize(w - 10, 400);
		scroll.setLocation(0, 0);
		
		return scroll;
	}

	
	/**
	 * 提交按钮
	 * @return
	 */
	private JButton submitBtn(){
		JButton submit = new JButton("提交");
		
		//button设置
		submit.setSize(btnW, btnH);
		submit.setLocation(btnW + 2 * Xgap, scroll.getHeight() + 40);
		submit.setFont(ChooseBtn_FONT);
		
		submit.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {	
				subBtnAction();
			}
		});
		
		return submit;
	}
	
	/**
	 * 显示按钮
	 * @return
	 */
	private JButton showBtn(){
		JButton show = new JButton("显示");
		
		show.setSize(btnW, btnH);
		show.setLocation(Xgap, scroll.getHeight() + 40);
		show.setFont(ChooseBtn_FONT);
		
		show.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {	
				showBtnAction();
			}
		});
		
		return show;
	}
	
	/**
	 * 显示按钮事件
	 */
	private void showBtnAction(){
		//TODO
	}
	
	/**
	 * 提交按钮事件
	 */
	private void subBtnAction(){
		//TODO
	}
}
