package TeamWolf.TeamWolf.client.GUI.manageUI;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import TeamWolf.TeamWolf.client.BL.applicationBL.ManageApproveService;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public class SaleApprovePanel extends JPanel{
	ManageApproveService service;
	ArrayList<ApplicationVO> list;
	
	
	static String[] column = {"单据类型", "单据编号", "操作员", "审批结果"};
	JTable table;
	JScrollPane scroll;
	Object[][] content;
	
	JComboBox<String> choice = new JComboBox<String>();
	
	private final static int width = ManageFrame.width;
	private final static int height = ManageFrame.height-ManageFrame.sho;
	private final static int rowH = 25;
	private final static int tableW = 450;
	
	public SaleApprovePanel(){
		
	}
	
	private void getContent(){
		list = service.getUnsetApplicationList();
		if(list.size() < 16){
			content = new Object[16][4];
		}
		else{
			content = new Object[list.size()][4];
		}
		for(int i = 0; i < list.size(); i++){
			ApplicationVO vo = list.get(i);
			String[] n = vo.number.split("-");
			
		}
	}
}
