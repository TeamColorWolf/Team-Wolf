package TeamWolf.TeamWolf.client.GUI.financeUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class AccountPanel extends JPanel{

	
	public static final int width = 960;
	public static final int height = 540;
	
	JTabbedPane tab;
	
	AccountnewPanel anp;
	AccountOprPanel aop;
	
	public AccountPanel(){
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setSize(width, height);
		tab.setVisible(true);
		
		anp = new AccountnewPanel();
		aop = new AccountOprPanel();
		
		tab.add("添加新的账户",anp);
		tab.add("对现在的账户进行修改",aop);
		
		this.add(tab);
		
		this.setLayout(null);
		this.setVisible(true);
	}
}