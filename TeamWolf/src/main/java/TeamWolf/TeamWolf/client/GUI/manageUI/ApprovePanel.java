package TeamWolf.TeamWolf.client.GUI.manageUI;

import javax.swing.JPanel;

import TeamWolf.TeamWolf.client.BL.applicationBL.ManageApproveService;
import TeamWolf.TeamWolf.client.BL.applicationBL.forManage.ManageApproveController;

public class ApprovePanel extends JPanel{
	static ManageApproveService service = new ManageApproveController(ManageFrame.IP);
	
	static ApplicationPanel approve;
	static DetialPanel detial;
	
	public ApprovePanel(){
		super();
		
		approve = new ApplicationPanel();
		detial = new DetialPanel();
		
		this.add(approve);
		this.add(detial);
		
		this.setLayout(null);
		this.setSize(ManageFrame.width, ManageFrame.height-ManageFrame.sho);
		this.setVisible(true);
		this.setLocation(0, ManageFrame.sho);
	}
	
}
