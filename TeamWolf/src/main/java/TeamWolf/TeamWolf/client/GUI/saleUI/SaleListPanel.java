package TeamWolf.TeamWolf.client.GUI.saleUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOpr;
import TeamWolf.TeamWolf.client.BL.customerBL.CustomerOprBLservice;
import TeamWolf.TeamWolf.client.BL.saleBL.SaleBLController;
import TeamWolf.TeamWolf.client.BLservice.saleBLservice.SaleBLservice;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;
import TeamWolf.TeamWolf.client.vo.UserType;
import TeamWolf.TeamWolf.client.vo.UserVO;

/**
 * 
 * @author HalaWKS
 *
 */
public class SaleListPanel extends JPanel{

	SaleBLservice saleLogic;
	CustomerOprBLservice custServ;
	ArrayList<CustomerVO> custList;
	ArrayList<SaleListVO> saleList;
	
	UserType power;
	String operator = "";
	
	//组件们
	JComboBox<String> customerBox = new JComboBox<String>();
	JTextArea businessManArea = new JTextArea();
	JTextArea remarkArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(remarkArea);
	GoodsChoosePanel goodschoose;
	JTextField discountField;
	JTextField preTotalField;
	JTextField totalField;
	JButton ensureBtn;
	JButton submitBtn;
	JButton clearBtn;
	
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
	private static final int conpW = 150;
	
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
	
	public SaleListPanel(UserVO user, String ip) {
		this.operator = user.workID; 
		saleLogic = new SaleBLController(ip);
		goodschoose = new GoodsChoosePanel(ip);
		custServ = new CustomerOpr(ip);
		power = user.power;

		custList = custServ.getAllCustomerList();
		saleList = saleLogic.getSaleList();
		
		if(saleList == null){
			saleList = new ArrayList<SaleListVO>();
		}
		if(custList == null){
			custList = new ArrayList<CustomerVO>();
		}
		
		//设置布局方式
		this.setLayout(null);
		//设置大小
		this.setSize(w, h);
		//添加组件
		this.add(goodschoose);
		this.add(this.subBtnPanel());
		this.add(this.attributePanel());
		
		this.setVisible(true);
	}
	
	/**
	 * 需要填写的属性(销售商，业务员，备注)
	 * @return
	 */
	private JPanel attributePanel(){
		JPanel jp = new JPanel();
//		jp.setBackground(Color.CYAN);

		
		//panel设置
		jp.setLayout(null);
		jp.setSize(w, 100);
		jp.setLocation(0, 0);
	    
		//组件设置
		customerBox.setSize(conpW, conpH);
		businessManArea.setSize(customerBox.getSize());
		customerBox.setLocation(Xgap, Ygap);
		businessManArea.setLocation(customerBox.getX() + customerBox.getWidth() + Xgap, Ygap);
		customerBox.setBorder(BorderFactory.createTitledBorder("销售商选择"));
		businessManArea.setBorder(BorderFactory.createTitledBorder("业务员"));
		customerBox.setEnabled(true);
		businessManArea.setEditable(false);
		scrollPane.setSize(conpW * 2, conpH * 3 / 2);
		scrollPane.setLocation(businessManArea.getX() + businessManArea.getWidth() + Xgap, Ygap / 4);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		scrollPane.setBorder(BorderFactory.createTitledBorder("备注填写"));
		
		
		setCustomerBox();
		customerBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		jp.add(customerBox);
		jp.add(businessManArea);
		jp.add(scrollPane);
		
		
		return jp;
	}
	
	/**
	 * 提交按钮面板(折让金额、折让前总额、折让后总额、确定、提交、清空)
	 * @return
	 */
	private JPanel subBtnPanel(){
		JPanel jp = new JPanel();
		
		Font ChooseBtn_FONT = new Font("黑体", Font.BOLD, 16);
		
		//组件们
		discountField = new JTextField();
		preTotalField = new JTextField();
		totalField = new JTextField();
		ensureBtn = new JButton("确定");
		submitBtn = new JButton("提交");
		clearBtn = new JButton("清空");
		
		//panel设置
		jp.setLayout(null);
		jp.setLocation(-10, 400);
		jp.setSize(w, 200);
//		jp.setBackground(Color.CYAN);
		
		//组件设置
		discountField.setSize(conpW, conpH);
		preTotalField.setSize(conpW, conpH);
		totalField.setSize(conpW, conpH);
		ensureBtn.setSize(btnW, btnH);
		submitBtn.setSize(btnW, btnH);
		clearBtn.setSize(submitBtn.getSize());
		
		discountField.setLocation(Xgap / 2, Ygap);
		preTotalField.setLocation(discountField.getX() + discountField.getWidth() + Xgap / 2, Ygap);
		totalField.setLocation(preTotalField.getX() + preTotalField.getWidth() + Xgap / 2, Ygap);
		ensureBtn.setLocation(totalField.getX() + totalField.getWidth() + Xgap / 2, Ygap);
		submitBtn.setLocation(ensureBtn.getX() + ensureBtn.getWidth() + Xgap / 2, Ygap);
		clearBtn.setLocation(submitBtn.getX() + submitBtn.getWidth() + Xgap / 2, Ygap);
		
		discountField.setBorder(BorderFactory.createTitledBorder("折让金额"));
		preTotalField.setBorder(BorderFactory.createTitledBorder("折让前总额"));
		totalField.setBorder(BorderFactory.createTitledBorder("最终总额"));
		ensureBtn.setFont(ChooseBtn_FONT);
		submitBtn.setFont(ChooseBtn_FONT);
		clearBtn.setFont(ChooseBtn_FONT);
		
		//组件添加监听
		ensureBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ensureBtnEvent();
			}
		});
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodschoose.removeAllGoods();
			}
		});
		
		//添加组件
		jp.add(discountField);
		jp.add(preTotalField);
		jp.add(totalField);
		jp.add(ensureBtn);
		jp.add(submitBtn);
		jp.add(clearBtn);
		
		return jp;
	}
	
	/**
	 * 在CustomerBox里添加选择列表
	 */
	private void setCustomerBox(){
		custList = TestMain.getCustVOListTEST();
		for (int i = 0, k = 0; i < custList.size(); i++) {
			if(custList.get(i).getKind().equals("销售商")){
				customerBox.addItem(custList.get(i).getName());
			}
		}
	}
	
	/**
	 * 确定按钮事件
	 */
	private void ensureBtnEvent(){
		double allTotal = 0;
		for (int i = 0; i < goodschoose.giftNum; i++) {
			allTotal = allTotal + Double.parseDouble(goodschoose.totalPriceListField.get(i).getText());
		}
		System.out.println("total = " + allTotal);
		preTotalField.setText(Double.toString(allTotal));
	}
	
	
	/**
	 * 提交按钮事件
	 */
	private void getSaleList(){
		String number = SaleListNum();
		CustomerVO customer = getAcustomer((String) customerBox.getSelectedItem());
//		String storage = (String) storageBox.getSelectedItem();
		String salesMan = customer.getBusinessMan();
		businessManArea.setText(salesMan);
		String operator = this.operator;
		String remark = remarkArea.getText();
		String total = totalField.getText();
		String discount = discountField.getText();
		String storage = "仓库1";
		
		ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
		ArrayList<TypeVO> typeList = goodschoose.typeList;
		for (int i = 0; i < goodschoose.giftNum; i++) {
			for (int j = 0; j < typeList.size(); j++) {
				if(goodschoose.goodsTypeListBox.get(i).getSelectedItem().equals(typeList.get(j).getName())){
					for (int k = 0; k < typeList.get(j).getAllLeave().size(); k++) {
						if(goodschoose.goodsListBox.get(i).getSelectedItem().equals(
								typeList.get(j).getAllLeave().get(k).getName() + " " + 
						           typeList.get(j).getAllLeave().get(k).getModel())){
							GoodsVO gvo = typeList.get(j).getAllLeave().get(k);
							gvo.setAmount(Integer.parseInt(goodschoose.numListField.get(i).getText()));
							goodsList.add(gvo);
						}
					}
				}
			}
		}
		
		for (int i = 0; i < goodsList.size(); i++) {
			System.out.println(goodsList.get(i).getName() + " " + goodsList.get(i).getModel() + " " + goodsList.get(i).getAmount()); 
		}
		
		SaleListVO saleVO = new SaleListVO(number, customer, salesMan,
				operator, storage, goodsList, discount, "0", remark);
		saleVO.condition = 0;
		
		saleLogic.createSale(saleVO);
	}
	
	/**
	 * 获取CustomerVO
	 * @return
	 */
	private CustomerVO getAcustomer(String name){
		CustomerVO cvo = null;
		System.out.println("客户单列表  " + custList.size());
		for (int i = 0; i < custList.size(); i++) {
			if(custList.get(i).getName().equals(name) && custList.get(i).getKind().equals("销售商")){
				cvo = custList.get(i);
			}
		}
		System.out.println(cvo.getNum() + " " + cvo.getName());
		return cvo;
	}
	
	private String SaleListNum(){
		String num = "JHD-";
		String date = saleLogic.getPresentDate();
		String number = String.format("%05d", saleList.size() + 1);
		num = num + date + "-" + number;
		return num;
	}
}
