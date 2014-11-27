package TeamWolf.TeamWolf.client.GUI.saleUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import TeamWolf.TeamWolf.client.vo.UserVO;


/**
 * 
 * @author HalaWKS
 *
 */
public class CreateListFrame extends JFrame{
	
	/**
	 * 面板宽度
	 */
	private static final int w = 1300;
	
	/**
	 * 面板高度
	 */
	private static final int h = 650;
	
	public CreateListFrame(UserVO user, String ip) {
		//设置布局管理器为“null”
		this.setLayout(null);
		//设置标题
		this.setTitle("销售类单据创建");
		//设置大小
		this.setSize(w, h);
		//居中
		FramUtil.setFrameCenter(this);
		//添加选项卡面板
		this.add(this.createSaleTabPane(user, ip));
		//设置不能变大小
		this.setResizable(false);
		//关闭方式
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	/**
	 * 创建选项卡面板(选择管理)
	 * @return
	 */
	private JTabbedPane createSaleTabPane(UserVO user, String ip) {
		
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("进货单", new ImportListPanel(user, ip));
		jtp.addTab("进货退货单", new ImportRejectListPanel());
		jtp.addTab("销售单", new SaleListPanel());
		jtp.addTab("销售退货单", new SaleRejectListPanel());
		jtp.setSize(w, 650);
		jtp.setLocation(0, 0);
		
		return jtp;
	}
	
	
}
