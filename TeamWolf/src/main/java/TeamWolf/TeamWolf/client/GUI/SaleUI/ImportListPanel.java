package TeamWolf.TeamWolf.client.GUI.SaleUI;

import java.awt.Color;

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
	 * 需要填写的属性()
	 * @return
	 */
	private JPanel attributePanel(){
		//TODO
		JPanel jp = new JPanel();
		jp.setBackground(Color.CYAN);
		
		jp.setSize(w, 100);
		jp.setLocation(0, 0);
		
		
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
	
}
