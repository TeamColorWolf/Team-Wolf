package TeamWolf.TeamWolf.client.GUI.SaleUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


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
	
	
	public CreateListFrame() {
		//设置布局管理器为“null”
		this.setLayout(null);
		//设置标题
		this.setTitle("销售类单据创建");
		//设置大小
		this.setSize(w, h);
		//居中
		FramUtil.setFrameCenter(this);
		//添加选项卡面板
		this.add(this.createSaleTabPane());
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
	private JTabbedPane createSaleTabPane() {
		
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("进货单", new ImportListPanel());
		jtp.addTab("进货退货单", new ImportRejectListPanel());
		jtp.addTab("销售单", new SaleListPanel());
		jtp.addTab("销售退货单", new SaleRejectListPanel());
		jtp.setSize(w, h);
		jtp.setLocation(0, 0);
		
		return jtp;
	}

	
}
