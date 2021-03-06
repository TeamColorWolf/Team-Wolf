package TeamWolf.TeamWolf.client.GUI.manageUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.applicationBL.ManageApproveService;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;

public class ApplicationPanel extends JPanel{
	ManageApproveService service = ApprovePanel.service;
	ArrayList<ApplicationVO> list;
	
	static String[] column = {"单据类型", "单据编号", "操作员", "审批结果"};
	DefaultTableModel tableModel = new DefaultTableModel();
	TableColumn approve;
	JTable table;
	JScrollPane scroll;
	Object[][] content;
	
	JComboBox<String> choice = new JComboBox<String>();
	
	private final static int width = ManageFrame.width/2;
	private final static int height = ManageFrame.height-60;
	private final static int rowH = 25;
	private final static int tableW = 450;
	
	public ApplicationPanel(){
		choice.addItem("通过");
		choice.addItem("驳回");
		choice.addItem("搁置");
		choice.setBackground(Color.white);
		this.getContent();
		tableModel.setDataVector(content, column);
		table = new JTable(tableModel);
		table.setRowHeight(rowH);
		approve = table.getColumnModel().getColumn(3);
		approve.setCellEditor(new DefaultCellEditor(choice));
		
		scroll = new JScrollPane(table);
		scroll.setSize(tableW, height);
		scroll.setLocation(0, 0);
		
		this.add(scroll);
		
		this.setSize(width, height);
		this.setLocation(0, 0);
		this.setLayout(null);
		this.setVisible(true);
		
		table.addMouseListener(new TableListener());
	}
	
	public ArrayList<ApplicationVO> getResult(){
		if(list != null){
			for(int i = 0; i < list.size(); i++){
				if(table.getValueAt(i, 3) != null){
					if(((String)table.getValueAt(i, 3)).equals("通过")){
						list.get(i).condition = 1;
					}
					else if(((String)table.getValueAt(i, 3)).equals("驳回")){
						list.get(i).condition = -1;
					}
				}
			}
		}
		return list;
	}
	
	public void flashPanel(){
		getContent();
		tableModel.setDataVector(content, column);
		approve = table.getColumnModel().getColumn(3);
		approve.setCellEditor(new DefaultCellEditor(choice));
		table.updateUI();
		table.setRowHeight(rowH);
	}
	
	private void getContent(){
		list = service.getUnsetApplicationList();
		if(list == null){
			new MessageFrame(ErrorTW.manageServerError);
		}
		if(list == null || list.size() < 18){
			content = new Object[18][4];
		}
		else{
			content = new Object[list.size()][4];
		}
		if(list != null){
			for(int i = 0; i < list.size(); i++){
				ApplicationVO vo = list.get(i);
				content[i][0] = ApplicationType.getType(vo.number);
				content[i][1] = vo.number;
				content[i][2] = vo.operator;
			}
		}
	}
	
	class TableListener implements MouseListener{

		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int row = table.getSelectedRow();
			if(row < list.size())
				ApprovePanel.detial.flashPanel(list.get(row));
			else
				ApprovePanel.detial.flashPanel(null);
		}

		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}
		public void mousePressed(MouseEvent arg0) {}
		public void mouseReleased(MouseEvent arg0) {}
	}
}
