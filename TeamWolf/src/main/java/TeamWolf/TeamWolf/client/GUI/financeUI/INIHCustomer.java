package TeamWolf.TeamWolf.client.GUI.financeUI;

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
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

public class INIHCustomer extends JPanel{
	
	public static ArrayList<CustomerVO> customerList;
	CustomerOprBLservice customerLogic;
	
	private JScrollPane scroll_customer;
	private JTable customerListTable;
	private DefaultTableModel tModel_customer;
	
	private String[] customerInfo = {"编号", "分类", "等级", "姓名", "电话", "电子邮箱", "应收额度", "默认业务员"};
	private Object[][] object_customerList;
	
	private static final int w = 1000;
	private static final int h = 500;	
	private static final int lineHeight = 25;
	
	public INIHCustomer(String ip) {
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
		
		this.setVisible(true);
		showBtnEvent();
	}
	
	private JScrollPane customerListTabel(){
		tModel_customer = new DefaultTableModel(object_customerList, customerInfo);
		customerListTable = new JTable(tModel_customer);
		
		//表格设置
		customerListTable.setRowHeight(lineHeight);	
		scroll_customer = new JScrollPane(customerListTable);
		scroll_customer.setSize(w - 10, h - 100);
		scroll_customer.setLocation(0, 0);
		
		
		return scroll_customer;
	}
	
	/**
	 * 显示按钮事件
	 */
	private void showBtnEvent(){
		System.out.println("customerList: " + customerList.size());
		tModel_customer = (DefaultTableModel) customerListTable.getModel();
		
		for (int i = 0; i < customerList.size(); i++) {
			CustomerVO cvo = customerList.get(i);
			//"选定", "编号", "分类", "等级", "姓名", "电话", "电子邮箱", "应收额度", "默认业务员"
			Object[] data = new Object[8];
			data[0] = cvo.getNum();
			data[1] = cvo.getKind();
			data[2] = cvo.getLevel();
			data[3] = cvo.getName();
			data[4] = cvo.getTel();
			data[5] = cvo.getEmail();
			data[6] = cvo.getTopLimit();
			data[7] = cvo.getBusinessMan();
			
			tModel_customer.addRow(data);
			customerListTable.setModel(tModel_customer);
		}
		
	}
}
