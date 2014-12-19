package TeamWolf.TeamWolf.client.GUI.financeUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import TeamWolf.TeamWolf.ErrorTW;
import TeamWolf.TeamWolf.client.BL.applicationBL.FinanceApplicationService;
import TeamWolf.TeamWolf.client.BL.applicationBL.forFinance.FinanceApplicationController;
import TeamWolf.TeamWolf.client.BL.applicationBL.forFinance.RecieptApplication;
import TeamWolf.TeamWolf.client.BLservice.tableInquireBLservice.TableInquireBLservice;
import TeamWolf.TeamWolf.client.GUI.messageUI.MessageFrame;
import TeamWolf.TeamWolf.client.GUI.tableInquireUI.RunProcessPanel;
import TeamWolf.TeamWolf.client.GUI.tableInquireUI.TableInquirePanel;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.RunProcessVO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public class RedManage {
	
	  TableInquireBLservice service = TableInquirePanel.service;
	  public Object[][] content;
	  ArrayList<RunProcessVO> AppVOList;
	  String IP;
	  private static RunProcessPanel panel ;
	  private final static int BW = 80;
	  private final static int BH = 25;
	
      public RedManage(String IP,RunProcessPanel Inputpanel){
    	  
    	  AppVOList = new ArrayList<RunProcessVO>();
    	  panel = new RunProcessPanel();
    	  this.panel = Inputpanel;
    	  JButton rdBut = new JButton("红冲");
    	  rdBut.setLocation(700, 410);
    	  rdBut.setSize(BW, BH);
    	  rdBut.setVisible(true);
    	  rdBut.addActionListener(new RedCheck());
    	  panel.add(rdBut);
      }
      
    public void getContent(){
	    ArrayList<RunProcessVO> list = service.runProcess(panel.timeSelect.getBeginVO(),panel.timeSelect.getEndVO());
	    if(list == null || list.size() < 12){
		content = new Object[12][7];
	  }
	  else{
		content = new Object[list.size()][7];
	  }
	   if(list != null){
		for(int i = 0; i < list.size(); i++){
			content[i][0] = list.get(i).number;
			content[i][1] = list.get(i).customer;
			content[i][2] = list.get(i).operator;
			content[i][3] = list.get(i).storage;
			content[i][4] = list.get(i).goodsName;
			content[i][5] = list.get(i).goodsAmo;
			content[i][6] = list.get(i).price;
		}
		for(int i=list.size()-1;i>=0;i--){
			String[] checkOne = ((String) content[i][0]).split("-");
			String[] checkTwo = ((String) content[i][0]).split("-");
			//if(!((String)content[i][0]).equals("")&&!content[i][0].equals(null)){
			System.out.println(checkOne[0]);
			System.out.println(checkOne[0]);			
			if(checkOne[0].equals(checkTwo[0])){
				AppVOList.add(list.get(i));
			}else{
				AppVOList.add(list.get(i));
				break;
			}
		}
	     }
     }
    
    public int CreateNewApp(){
    	String AppType="";
    	if(AppVOList!=null){
        	String[] AppTypeArray = AppVOList.get(0).number.split("-");
        	AppType = AppTypeArray[0];
        }else{
        	return -1;
        }
        if(AppType.equals("SKD")){
    	    ArrayList<financeVO> accountList = new ArrayList<financeVO>();
    	 //   ArrayList<String> moneyList = new 
		    
        	//RecieptApplicationVO vo = new RecieptApplicationVO(accountList, moneyList, number, operator, note, customer)
        	
        	//RecieptApplication fa = new RecieptApplication(vo, AppType);
        	
        }
    	return 0;
    }
      
      public RunProcessPanel panelBack(){
    	  return panel;
      }
      
  	class RedCheck implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			getContent();
			int lines = panel.content.length/7;
		}

	}
      
}
