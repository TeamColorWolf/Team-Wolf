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

import TeamWolf.TeamWolf.client.BL.saleBL.SaleBLController;
import TeamWolf.TeamWolf.client.BLservice.saleBLservice.SaleBLservice;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.UserVO;

/**
 * 
 * @author HalaWKS
 *
 */
public class ImportListPanel extends JPanel{
	
	SaleBLservice saleLogic;
	
	String[] storage = {"仓库1", "仓库2", "仓库3"};
	String operator = "";
	
	//组件们
	JComboBox<String> customerBox = new JComboBox<String>();
	JComboBox<String> storageBox = new JComboBox<String>(storage);	
	JTextArea remarkArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(remarkArea);

	/**
	 * 面板宽度
	 */
	private static final int w = 1300;
	
	/**
	 * 面板高度
	 */
	private static final int h = 650;	
	
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

		//设置布局方式
		this.setLayout(null);
		//设置大小
		this.setSize(w, h);
		//添加组件
		this.add(this.attributePanel());
		this.add(this.addGoodsPanel(IP));
		this.add(this.subBtnPanel());
	}
	
	/**
	 * 需要填写的属性(供应商，仓库，备注)
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
		JTextField totalField = new JTextField();
		JButton submitBtn = new JButton("提交");
		JButton clearBtn = new JButton("清空");
		JButton returnBtn = new JButton("返回");
		
		//panel设置
		jp.setLayout(null);
		jp.setLocation(-10, 470);
		jp.setSize(w, 140);
//		jp.setBackground(Color.CYAN);
		
		//组件设置
		totalField.setSize(conpW, conpH);
		submitBtn.setSize(btnW, btnH);
		clearBtn.setSize(submitBtn.getSize());
		returnBtn.setSize(submitBtn.getSize());
		
		totalField.setLocation(Xgap, Ygap);
		submitBtn.setLocation(totalField.getX() + totalField.getWidth() + Xgap, Ygap);
		clearBtn.setLocation(submitBtn.getX() + submitBtn.getWidth() + Xgap, Ygap);
		returnBtn.setLocation(clearBtn.getX() + clearBtn.getWidth() + Xgap, Ygap);
		
		totalField.setBorder(BorderFactory.createTitledBorder("全部总额"));
		submitBtn.setFont(ChooseBtn_FONT);
		clearBtn.setFont(ChooseBtn_FONT);
		returnBtn.setFont(ChooseBtn_FONT);
		
		//组件添加监听
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearBtnEvent();
			}
		});
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBtnEvent();
			}
		});
		
		//添加组件
		jp.add(totalField);
		jp.add(submitBtn);
		jp.add(clearBtn);
		jp.add(returnBtn);
		
		
		return jp;
	}
	
	/**
	 * 添加商品面板
	 * @return
	 */
	private JPanel addGoodsPanel(String ip){
		return new GoodsChoosePanel(ip);
	}
	
	/**
	 * 在CustomerBox里添加选择列表
	 */
	private String[] setCustomerBox(){
		String[] customerVOList = null;
		
		return customerVOList;
	}
	
	/**
	 * 提交按钮事件
	 */
	private ImportListVO getImportList(){
		String number = null;
		CustomerVO customer = null;
		String storage = (String) storageBox.getSelectedItem();
		String operator = this.operator;
		ArrayList<GoodsVO> goodsList = GoodsChoosePanel.getGoodsList();
		String remark = remarkArea.getText();
		
		ImportListVO importVO = new ImportListVO(number, customer, storage, operator, goodsList, remark);
		
		return importVO;
	}
	
	/**
	 * 清空按钮事件
	 */
	private void clearBtnEvent(){
		this.repaint();
	}
	
	private void returnBtnEvent(){
		
	}
}

