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
import TeamWolf.TeamWolf.client.vo.TypeVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

/**
 * 
 * @author HalaWKS
 *
 */
public class ImportListPanel extends JPanel{
	
	SaleBLservice saleLogic;
	CustomerOprBLservice custServ;
	ArrayList<CustomerVO> custList;
	ArrayList<ImportListVO> importList;
	
	String[] storage = {"仓库1", "仓库2", "仓库3"};
	String operator = "";
	
	
	//组件们
	JComboBox<String> customerBox = new JComboBox<String>();
	JComboBox<String> storageBox = new JComboBox<String>(storage);	
	JTextArea remarkArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(remarkArea);
	GoodsChoosePanel goodschoose;
	JTextField totalField;
	
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
	
	public ImportListPanel(UserVO user, String IP) {
		this.operator = user.workID; 
		saleLogic = new SaleBLController(IP);
		custServ = new CustomerOpr(IP);
		goodschoose = new GoodsChoosePanel(IP);
		
		custList = custServ.getAllCustomerList();
		importList = saleLogic.getImportList();
		
		if(importList == null){
			importList = new ArrayList<ImportListVO>();
		}
		if(custList == null){
			custList = new ArrayList<CustomerVO>();
		}
		
		//设置布局方式
		this.setLayout(null);
		//设置大小
		this.setSize(w, h);
		//添加组件
		this.add(this.attributePanel());
		this.add(goodschoose);
		this.add(this.subBtnPanel());
	}
	
	/**
	 * 需要填写的属性(供应商，仓库，备注)
	 * @return
	 */
	private JPanel attributePanel(){
		JPanel jp = new JPanel();

		//panel设置
		jp.setLayout(null);
		jp.setSize(w, 100);
		jp.setLocation(0, 0);
		
		//组件设置
		customerBox.setSize(conpW, conpH);
		storageBox.setSize(customerBox.getSize());
		customerBox.setLocation(Xgap, Ygap);
		storageBox.setLocation(customerBox.getX() + customerBox.getWidth() + Xgap, Ygap);
		customerBox.setBorder(BorderFactory.createTitledBorder("进货商选择"));
		storageBox.setBorder(BorderFactory.createTitledBorder("仓库选择"));
		customerBox.setEnabled(true);
		storageBox.setEnabled(true);
		scrollPane.setSize(conpW * 2, conpH * 3 / 2);
		scrollPane.setLocation(storageBox.getX() + storageBox.getWidth() + Xgap, Ygap / 4);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		scrollPane.setBorder(BorderFactory.createTitledBorder("备注填写"));
		
		setCustomerBox();
		
		jp.add(customerBox);
		jp.add(storageBox);
		jp.add(scrollPane);
		
		
		return jp;
	}
	
	/**
	 * 提交按钮面板
	 * @return
	 */
	private JPanel subBtnPanel(){
		JPanel jp = new JPanel();
		
		Font ChooseBtn_FONT = new Font("黑体", Font.BOLD, 16);
		
		//组件们
		totalField = new JTextField("0.0");
		JButton ensureBtn = new JButton("确定");
		JButton submitBtn = new JButton("提交");
		JButton clearBtn = new JButton("清空");
		
		//panel设置
		jp.setLayout(null);
		jp.setLocation(-10, 400);
		jp.setSize(w, 200);
//		jp.setBackground(Color.CYAN);
		
		//组件设置
		totalField.setSize(conpW, conpH);
		ensureBtn.setSize(btnW, btnH);
		submitBtn.setSize(btnW, btnH);
		clearBtn.setSize(submitBtn.getSize());
		
		totalField.setLocation(Xgap, Ygap);
		ensureBtn.setLocation(totalField.getX() + totalField.getWidth() + Xgap, Ygap);
		submitBtn.setLocation(ensureBtn.getX() + ensureBtn.getWidth() + Xgap, Ygap);
		clearBtn.setLocation(submitBtn.getX() + submitBtn.getWidth() + Xgap, Ygap);
		
		totalField.setBorder(BorderFactory.createTitledBorder("全部总额"));
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
				getImportList();
			}
		});
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearBtnEvent();
			}
		});
		
		//添加组件
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
		for (int i = 0, k = 0; i < custList.size(); i++) {
			if(custList.get(i).getKind().equals("进货商")){
				customerBox.addItem(custList.get(i).getName());
			}
		}

	}
	
	/**
	 * 提交按钮事件
	 */
	private void getImportList(){
		String number = importListNum();
		CustomerVO customer = getAcustomer((String) customerBox.getSelectedItem());
		String storage = (String) storageBox.getSelectedItem();
		String operator = this.operator;
		String remark = remarkArea.getText();
		String total = totalField.getText();
		
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
		
		ImportListVO importVO = new ImportListVO(number, customer, storage, operator, goodsList, remark, total);
		importVO.condition = 0;
		
		if(ImportRejectListPanel.importList == null){
			ImportRejectListPanel.importList = new ArrayList<ImportListVO>();
		}
		ImportRejectListPanel.importList.add(importVO);
		saleLogic.createImport(importVO);
	}
	

	/**
	 * 获取CustomerVO
	 * @return
	 */
	private CustomerVO getAcustomer(String name){
		CustomerVO cvo = null;
		System.out.println("客户单列表  " + custList.size());
		for (int i = 0; i < custList.size(); i++) {
			if(custList.get(i).getName().equals(name) && custList.get(i).getKind().equals("进货商")){
				cvo = custList.get(i);
			}
		}
		System.out.println(cvo.getNum() + " " + cvo.getName());
		return cvo;
	}
	
	/**
	 * 清空按钮事件
	 */
	private void clearBtnEvent(){
		goodschoose.removeAllGoods();
		totalField.setText("0.0");
	}
	
	private String importListNum(){
		String num = "JHD-";
		String date = saleLogic.getPresentDate();
		String number = String.format("%05d", importList.size() + 1);
		num = num + date + "-" + number;
		return num;
	}
	
	private void ensureBtnEvent(){
		double allTotal = 0;
		for (int i = 0; i < goodschoose.giftNum; i++) {
			allTotal = allTotal + Double.parseDouble(goodschoose.totalPriceListField.get(i).getText());
		}
		System.out.println("total = " + allTotal);
		totalField.setText(Double.toString(allTotal));
	}
}

