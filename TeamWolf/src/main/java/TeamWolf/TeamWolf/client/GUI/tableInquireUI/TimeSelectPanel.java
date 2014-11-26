package TeamWolf.TeamWolf.client.GUI.tableInquireUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import TeamWolf.TeamWolf.client.vo.TimeVO;

public class TimeSelectPanel extends JPanel{
	public JComboBox<Integer> by;
	public JComboBox<Integer> bm;
	public JComboBox<Integer> bd;
	
	public JComboBox<Integer> ey;
	public JComboBox<Integer> em;
	public JComboBox<Integer> ed;
	
	public JButton check = new JButton("查询");
	
	private JLabel begin = new JLabel("开始时间");
	private JLabel end = new JLabel("结束时间");
	
	private JLabel byear = new JLabel(" 年");
	private JLabel bmonth = new JLabel(" 月");
	private JLabel bday = new JLabel(" 日");
	
	private JLabel eyear = new JLabel(" 年");
	private JLabel emonth = new JLabel(" 月");
	private JLabel eday = new JLabel(" 日");
	
	final static Calendar c = Calendar.getInstance();
	
	static int year = 0;
	static int month = 0;
	static int date = 0;
	
	final static int BH = 25;
	final static int BW = 80;
	
	final static int width = 960;
	final static int height = 100;
	
	final static int up = 30;
	final static int gap = 20;
	final static int left = 100;
	final static int right = 500;
	
	private BeginListener bl = new BeginListener();
	private EndListener el = new EndListener();
	
	public TimeSelectPanel(){
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
		
		byear.setSize(gap, BH);
		bmonth.setSize(gap, BH);
		bday.setSize(gap, BH);
		eyear.setSize(gap, BH);
		emonth.setSize(gap, BH);
		eday.setSize(gap, BH);
		
		byear.setLocation(left-gap, up);
		bmonth.setLocation(left+BW, up);
		bday.setLocation(left+2*BW+gap, up);
		eyear.setLocation(right-gap, up);
		emonth.setLocation(right+BW, up);
		eday.setLocation(right+2*BW+gap, up);
		
		this.add(byear);
		this.add(bmonth);
		this.add(bday);
		this.add(eyear);
		this.add(emonth);
		this.add(eday);
		
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
		
		check.setSize(BW, BH);
		check.setLocation(width-2*BW+gap, up);
		
		this.add(check);
		
		this.setLayout(null);
		this.setSize(width, height);
		this.setVisible(true);
		this.setOpaque(false);
	}
	
	public TimeVO getBeginVO(){
		int year = (Integer)by.getSelectedItem();
		int month = (Integer)bm.getSelectedItem();
		int day = (Integer)bd.getSelectedItem();
		return new TimeVO(year+"", month+"", day+"");
	}
	
	public TimeVO getEndVO(){
		int year = (Integer)ey.getSelectedItem();
		int month = (Integer)em.getSelectedItem();
		int day = (Integer)ed.getSelectedItem();
		return new TimeVO(year+"", month+"", day+"");
	}
	
	public void setCheckListener(ActionListener listener){
		check.addActionListener(listener);
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
		TimeSelectPanel t = new TimeSelectPanel();
		JFrame f = new JFrame();
		
		f.add(t);
		
		f.setSize(width, height);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
