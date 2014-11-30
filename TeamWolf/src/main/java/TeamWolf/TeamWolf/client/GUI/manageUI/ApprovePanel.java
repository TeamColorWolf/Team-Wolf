package TeamWolf.TeamWolf.client.GUI.manageUI;

import javax.swing.JPanel;

import TeamWolf.TeamWolf.client.BL.applicationBL.ManageApproveService;
import TeamWolf.TeamWolf.client.BL.applicationBL.forManage.ManageApproveController;

public class ApprovePanel extends JPanel{
	static ManageApproveService service = new ManageApproveController(ManageFrame.IP);
	
	SaleApprovePanel approve;
	
	public ApprovePanel(){
		super();
		
		approve = new SaleApprovePanel();
		
		this.add(approve);
		
		this.setLayout(null);
		this.setSize(ManageFrame.width, ManageFrame.height-ManageFrame.sho);
		this.setVisible(true);
		this.setLocation(0, ManageFrame.sho);
	}
	
}
