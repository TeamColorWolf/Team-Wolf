package TeamWolf.TeamWolf.client.GUI.saleUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import TeamWolf.TeamWolf.client.vo.UserVO;

/**
 * 
 * @author HalaWKS
 *
 */
public class CustomerAdminFrame extends JFrame{
	
	/**
	 * 面板宽度
	 */
	private static final int w = 1000;
	
	/**
	 * 面板高度
	 */
	private static final int h = 600;
	
	/**
	 * 按钮宽、高
	 */
	private static final int btnW = 150;
	private static final int btnH = 40;
	
	public CustomerAdminFrame(UserVO user, String ip) {
		//设置布局管理器为“null”
		this.setLayout(null);
		//设置标题
		this.setTitle("客户管理");
		//设置大小
		this.setSize(w, h);
		//居中
		FramUtil.setFrameCenter(this);
		//添加选项卡面板
		this.add(this.createCustomerAdminPane(user, ip));
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
	private JTabbedPane createCustomerAdminPane(UserVO user, String ip) {
		
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("增加客户", new CustomerAddPanel(user, ip));
		jtp.addTab("删除客户", new CustomerDelPanel(user, ip));
		jtp.addTab("修改客户", new CustomerModPanel(user, ip));
		jtp.addTab("查找客户", new CustomerFinPanel(user, ip));
		jtp.setSize(w, 500);
		jtp.setLocation(0, 0);
		
		return jtp;
	}
	
	/**
	 * 返回按钮
	 * @return
	 */
	private JButton returnButton(){
		JButton returnBtn = new JButton("返回");
		Font ChooseBtn_FONT = new Font("黑体", Font.BOLD, 16);
		
		returnBtn.setSize(btnW, btnH);
		returnBtn.setLocation(700, 515);
		returnBtn.setFont(ChooseBtn_FONT);
		
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBtnEvent();
			}
		});
		
		
		return returnBtn;
	}
	
	/**
	 * 返回按钮事件
	 */
	private void returnBtnEvent(){
		this.dispose();
	}
}
