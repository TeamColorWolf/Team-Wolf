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
	
	/**
	 * 按钮宽、高
	 */
	private static final int btnW = 150;
	private static final int btnH = 40;
	
	
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
		this.add(this.returnButton());
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
		jtp.addTab("进货退货单", new ImportRejectListPanel(user, ip));
		jtp.addTab("销售单", new SaleListPanel(user, ip));
		jtp.addTab("销售退货单", new SaleRejectListPanel());
		jtp.setSize(w, 535);
		jtp.setLocation(0, 0);
		
		return jtp;
	}
	
	private JButton returnButton(){
		JButton returnBtn = new JButton("返回");
		Font ChooseBtn_FONT = new Font("黑体", Font.BOLD, 16);
		
		returnBtn.setSize(btnW, btnH);
		returnBtn.setLocation(1000, 550);
		returnBtn.setFont(ChooseBtn_FONT);
		
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBtnEvent();
			}
		});
		
		
		return returnBtn;
	}
	
	
	private void returnBtnEvent(){
		this.dispose();
	}
	
}
