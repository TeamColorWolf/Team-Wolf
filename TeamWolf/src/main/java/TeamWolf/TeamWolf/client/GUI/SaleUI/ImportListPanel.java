package TeamWolf.TeamWolf.client.GUI.SaleUI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author HalaWKS
 *
 */
public class ImportListPanel extends JPanel{

	/**
	 * 面板宽度
	 */
	private static final int w = 1300;
	
	/**
	 * 面板高度
	 */
	private static final int h = 650;	
	
	/**
	 * 组件宽度
	 */
	private static final int conpW = 150;
	
	/**
	 * 组件高度
	 */
	private static final int conpH = 60;
	
	/**
	 * 组件间距
	 */
	private static final int Xgap = 200;
	
	private static final int Ygap = 30;
	
	public ImportListPanel() {
		//设置布局方式
		this.setLayout(null);
		//设置大小
		this.setSize(w, h);
		//添加组件
		this.add(this.attributePanel());
		this.add(this.addGoodsPanel());
		this.add(this.btnPanel());
		this.add(this.messagePanel());
		
	}
	
	/**
	 * 需要填写的属性(供应商，仓库)
	 * @return
	 */
	private JPanel attributePanel(){
		//TODO
		JPanel jp = new JPanel();
//		jp.setBackground(Color.CYAN);
		String[] storage = {"仓库1", "仓库2", "仓库3"};
		//组件们
		JComboBox<String> customerBox = new JComboBox<String>(setCustomerBox());
		JComboBox<String> storageBox = new JComboBox<String>(storage);		
		
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
		
		jp.add(customerBox);
		jp.add(storageBox);
		
		
		return jp;
	}
	
	/**
	 * 按钮面板
	 * @return
	 */
	private JPanel btnPanel(){
		//TODO
		JPanel jp = new JPanel();
		
		
		return jp;
	}
	
	/**
	 * 备注填写与总额合计显示面板
	 * @return
	 */
	private JPanel messagePanel(){
		//TODO
		JPanel jp = new JPanel();
		
		
		return jp;
	}
	
	/**
	 * 添加商品面板
	 * @return
	 */
	private JPanel addGoodsPanel(){
		return new GoodsChoosePanel();
	}
	
	/**
	 * 在CustomerBox里添加选择列表
	 */
	private String[] setCustomerBox(){
		String[] customerVOList = null;
		
		return customerVOList;
	}
	
}
