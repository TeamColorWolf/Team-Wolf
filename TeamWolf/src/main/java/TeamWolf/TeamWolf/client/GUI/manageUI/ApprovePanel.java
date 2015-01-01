package TeamWolf.TeamWolf.client.GUI.manageUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.applicationBL.ManageApproveService;
import TeamWolf.TeamWolf.client.BL.applicationBL.forManage.ManageApproveController;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public class ApprovePanel extends JPanel{
	static ManageApproveService service = new ManageApproveController(ManageFrame.IP);
	
	static ApplicationPanel approve;
	static DetialPanel detial;
	
	JButton over = new JButton("审批完成");
	JButton flash = new JButton("刷新");
	
	public ApprovePanel(){
		super();
		
		approve = new ApplicationPanel();
		detial = new DetialPanel();
		
		over.setSize(100, 30);
		over.setLocation(ManageFrame.width-400, ManageFrame.height-100);
		over.setVisible(true);
		
		flash.setSize(100, 30);
		flash.setLocation(ManageFrame.width-200, ManageFrame.height-100);
		flash.setVisible(true);
		
		this.add(approve);
		this.add(detial);
		
		this.add(over, 0);
		this.add(flash, 0);
		
		this.setLayout(null);
		this.setSize(ManageFrame.width, ManageFrame.height-ManageFrame.sho);
		this.setVisible(true);
		this.setLocation(0, ManageFrame.sho);
		
		over.addActionListener(new ApproveOverListener());
		flash.addActionListener(new FlashListener());
	}
	
	class ApproveOverListener implements ActionListener{
		//提交当前审批结果并且刷新
		public void actionPerformed(ActionEvent arg0) {
			int success = -1;
			ArrayList<ApplicationVO> list = approve.getResult();
			if(list == null || list.size() == 0){
				new MessageFrame(ErrorTW.approveWithoutApplication);
			}
			success = service.approveOver(list);
			new MessageFrame(success);
			approve.flashPanel();
			detial.flashPanel(null);
		}
		
	}
	
	class FlashListener implements ActionListener{
		//刷新该Panel
		public void actionPerformed(ActionEvent arg0) {
			approve.flashPanel();
			detial.flashPanel(null);
		}
		
	}
	
}
