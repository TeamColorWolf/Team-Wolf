package TeamWolf.TeamWolf.client.GUI.manageUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import TeamWolf.TeamWolf.client.BL.applicationBL.ManageApproveService;
import TeamWolf.TeamWolf.client.BL.applicationBL.forManage.ManageApproveController;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public class ApprovePanel extends JPanel{
	static ManageApproveService service = new ManageApproveController(ManageFrame.IP);
	
	static ApplicationPanel approve;
	static DetialPanel detial;
	
	JButton over = new JButton("审批完成");
	
	public ApprovePanel(){
		super();
		
		approve = new ApplicationPanel();
		detial = new DetialPanel();
		
		over.setSize(100, 30);
		over.setLocation(ManageFrame.width-300, ManageFrame.height-100);
		over.setVisible(true);
		
		this.add(approve);
		this.add(detial);
		
		this.add(over, 0);
		
		this.setLayout(null);
		this.setSize(ManageFrame.width, ManageFrame.height-ManageFrame.sho);
		this.setVisible(true);
		this.setLocation(0, ManageFrame.sho);
		
		over.addActionListener(new ApproveOverListener());
	}
	
	class ApproveOverListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			ArrayList<ApplicationVO> list = approve.getResult();
			service.approveOver(list);
			approve.flashPanel();
			detial.flashPanel(null);
		}
		
	}
	
}
