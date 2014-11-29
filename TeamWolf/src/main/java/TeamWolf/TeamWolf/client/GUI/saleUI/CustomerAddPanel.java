package TeamWolf.TeamWolf.client.GUI.saleUI;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import TeamWolf.TeamWolf.client.vo.UserVO;

/**
 * 
 * @author HalaWKS
 *
 */
public class CustomerAddPanel extends JPanel{

	
	JComboBox<String> kindBox;
	JComboBox<String> levelBox;
	JComboBox<String> salesManBox;
	
	/**
	 * 面板宽度
	 */
	private static final int w = 1000;
	
	/**
	 * 面板高度
	 */
	private static final int h = 500;
	
	public CustomerAddPanel(UserVO user, String ip) {
		// TODO Auto-generated constructor stub
		//设置布局方式
		this.setLayout(null);
		//设置大小
		this.setSize(w, h);
		//添加组件
		
		this.setVisible(true);
	}
	
}
