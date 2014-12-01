package TeamWolf.TeamWolf.client.GUI.saleUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOpr;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOprBLservice;
import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

/**
 * 
 * @author HalaWKS
 *
 */
public class CustomerDelPanel extends JPanel{
	
	ArrayList<CustomerVO> customerList;
	CustomerOprBLservice customerLogic;
	
	private JScrollPane scroll_customer;
	private JTable customerListTable;
	private DefaultTableModel tModel_customer;
	
	private String[] customerInfo = {"选定", "编号", "分类", "等级", "姓名", "电话", "电子邮箱", "应收额度", "默认业务员"};
	private Object[][] object_customerList;
	
	/**
	 * 面板宽度
	 */
	private static final int w = 1000;
	
	/**
	 * 面板高度
	 */
	private static final int h = 500;
	
	/**
	 * 字体
	 */
	Font Btn_FONT = new Font("黑体", Font.BOLD, 16);
	
	/**
	 * 按钮宽、高
	 */
	private static final int btnW = 150;
	private static final int btnH = 40;
	
	/**
	 * 组件间距
	 */
	private static final int Xgap = 100;
	
	public CustomerDelPanel(UserVO user, String ip) {
		customerLogic = new CustomerOpr(ip);
		customerList = customerLogic.getAllCustomerList();
		if(customerList == null){
			customerList = new ArrayList<CustomerVO>();
		}
		
		//设置布局方式
		this.setLayout(null);
		//设置大小
		this.setSize(w, h);
		//添加组件
		this.add(this.customerListTabel());
		this.add(this.showBtn());
		this.add(this.delBtn());
		
		this.setVisible(true);
	}
	
	private JScrollPane customerListTabel(){
		tModel_customer = new DefaultTableModel(object_customerList, customerInfo);
		customerListTable = new JTable(tModel_customer);
		
		
		//表格设置
		customerListTable.setRowHeight(30);
		TableColumn tc0 = customerListTable.getColumnModel().getColumn(0);
		tc0.setCellEditor(customerListTable.getDefaultEditor(Boolean.class));
		tc0.setCellRenderer(customerListTable.getDefaultRenderer(Boolean.class));
		
		scroll_customer = new JScrollPane(customerListTable);
		scroll_customer.setSize(w - 10, h - 100);
		scroll_customer.setLocation(0, 0);
		
		
		return scroll_customer;
	}
	
	/**
	 * 显示按钮
	 * @return
	 */
	private JButton showBtn(){
		JButton show = new JButton("显示");
		
		show.setSize(btnW, btnH);
		show.setLocation(Xgap, scroll_customer.getHeight() + 20);
		show.setFont(Btn_FONT);
		
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBtnEvent();
			}
		});
		
		return show;
	}
	
	/**
	 * 删除按钮
	 * @return
	 */
	private JButton delBtn(){
		JButton delet = new JButton("删除");
		
		delet.setSize(btnW, btnH);
		delet.setLocation(btnW + 2 * Xgap, scroll_customer.getHeight() + 20);
		delet.setFont(Btn_FONT);
		
		delet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		return delet;
	}
	
	/**
	 * 显示按钮事件
	 */
	private void showBtnEvent(){
		clearCustomerTable();
		System.out.println("customerList: " + customerList.size());
//		customerList = TestMain.getCustVOListTEST();
		tModel_customer = (DefaultTableModel) customerListTable.getModel();
		
		for (int i = 0; i < customerList.size(); i++) {
			CustomerVO cvo = customerList.get(i);
			//"选定", "编号", "分类", "等级", "姓名", "电话", "电子邮箱", "应收额度", "默认业务员"
			Object[] data = new Object[9];
			data[0] = new Boolean(false);
			data[1] = cvo.getNum();
			data[2] = cvo.getKind();
			data[3] = cvo.getLevel();
			data[4] = cvo.getName();
			data[5] = cvo.getTel();
			data[6] = cvo.getEmail();
			data[7] = cvo.getTopLimit();
			data[8] = cvo.getBusinessMan();
			
			tModel_customer.addRow(data);
			customerListTable.setModel(tModel_customer);
		}
		
	}
	
	/**
	 * 清空表格方法
	 */
	private void clearCustomerTable(){
		object_customerList = null;
		tModel_customer.setDataVector(object_customerList, customerInfo);
		customerListTable.updateUI();
	}
}
