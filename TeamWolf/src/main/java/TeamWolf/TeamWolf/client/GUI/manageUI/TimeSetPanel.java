package TeamWolf.TeamWolf.client.GUI.manageUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimeSetPanel extends JPanel{
	
	public JComboBox<Integer> by;
	public JComboBox<Integer> bm;
	public JComboBox<Integer> bd;
	
	public JComboBox<Integer> ey;
	public JComboBox<Integer> em;
	public JComboBox<Integer> ed;
	
	private JLabel begin = new JLabel("开始时间");
	private JLabel end = new JLabel("结束时间");
	
	final static Calendar c = Calendar.getInstance();
	
	static int year = 0;
	static int month = 0;
	static int date = 0;
	
	final static int BH = 25;
	final static int BW = 80;
	
	final static int width = ManageFrame.width;
	final static int height = ManageFrame.height-2*ManageFrame.sho;
	
	final static int up = 30;
	final static int gap = 20;
	final static int left = 100;
	final static int right = 580;
	
	private BeginListener bl = new BeginListener();
	private EndListener el = new EndListener();
	
	public TimeSetPanel(){
		super();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH) + 1;
		date = c.get(Calendar.DAY_OF_MONTH);
		
		begin.setSize(BW, BH);
		end.setSize(BW, BH);
		
		begin.setLocation(left-BW, up);
		end.setLocation(right-BW, up);
		
		by = new JComboBox<Integer>();
		bm = new JComboBox<Integer>();
		bd = new JComboBox<Integer>();
		ey = new JComboBox<Integer>();
		em = new JComboBox<Integer>();
		ed = new JComboBox<Integer>();
		
		by.setSize(BW, BH);
		bm.setSize(BW, BH);
		bd.setSize(BW, BH);
		ey.setSize(BW, BH);
		em.setSize(BW, BH);
		ed.setSize(BW, BH);
		
		by.setBackground(Color.WHITE);
		bm.setBackground(Color.WHITE);
		bd.setBackground(Color.WHITE);
		ey.setBackground(Color.WHITE);
		em.setBackground(Color.WHITE);
		ed.setBackground(Color.WHITE);
		
		by.setLocation(left, up);
		bm.setLocation(left+BW+gap, up);
		bd.setLocation(left+2*BW+2*gap, up);
		ey.setLocation(right, up);
		em.setLocation(right+BW+gap, up);
		ed.setLocation(right+2*BW+2*gap, up);
		
		this.add(begin);
		this.add(end);
		
		this.add(by);
		this.add(bm);
		this.add(bd);
		this.add(ey);
		this.add(em);
		this.add(ed);
		
		for(int i = 0; i < 10; i++){
			by.addItem(year+i);
			ey.addItem(year+i);
		}
		by.setSelectedIndex(0);
		ey.setSelectedIndex(0);
		
		for(int i = 1; i < 13; i++){
			bm.addItem(i);
			em.addItem(i);
		}
		bm.setSelectedIndex(month-1);
		em.setSelectedIndex(month-1);
		
		for(int i = 1; i <= setDate(year, month); i++){
			bd.addItem(i);
			ed.addItem(i);
		}
		bd.setSelectedIndex(date-1);
		ed.setSelectedIndex(date-1);
		
		by.addActionListener(bl);
		bm.addActionListener(bl);
		
		ey.addActionListener(el);
		em.addActionListener(el);
		
		this.setLayout(null);
		this.setSize(width, height);
		this.setVisible(true);
		this.setOpaque(false);
	}
	
	private int setDate(int year, int month){
		boolean runNian = false;
		int day = 0;
		if((year%400 == 0) || (year%100 != 0 && year%4 == 0)){
			runNian = true;
		}
		else{
			runNian = false;
		}
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
			day = 31;
		}
		else if(month == 2){
			if(runNian){
				day = 29;
			}
			else{
				day = 28;
			}
		}
		else{
			day = 30;
		}
		return day;
	}
	
	private void setComboBoxDate(JComboBox<Integer> y, JComboBox<Integer> m, JComboBox<Integer> d){
		int sy = (Integer)y.getSelectedItem();
		int sm = (Integer)m.getSelectedItem();
		int day = setDate(sy, sm);
		d.removeAllItems();
		for(int i = 1; i <= day; i++){
			d.addItem(i);
		}
	}
	
	class BeginListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			setComboBoxDate(by, bm, bd);
		}
		
	}
	
	class EndListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			setComboBoxDate(ey, em, ed);
		}
		
	}
	
	public static void main(String[] args){
		TimeSetPanel p = new TimeSetPanel();
		System.out.println(p.year + " " + p.month + " " + p.date);
	}
	
}
