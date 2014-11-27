package TeamWolf.TeamWolf.client.GUI.saleUI;

import javax.swing.JPanel;
import javax.swing.JTable;

import TeamWolf.TeamWolf.client.vo.UserVO;

/**
 * 
 * @author HalaWKS
 *
 */
public class ImportRejectListPanel extends JPanel{

	
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
	
	public ImportRejectListPanel(UserVO user, String IP) {
		//设置布局方式
		this.setLayout(null);
		//设置大小
		this.setSize(w, h);
	}
	
	private JTable importList(){
		JTable importlist = new JTable();
		
		
		
		return importlist;
	}
	
}
