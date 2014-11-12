package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;
/**
 * 
 * @author XYJ
 *
 */
public class TypeVO {
	
	private String parent;
    private String child;
    private int C;//�жϸ÷�����Ů�Ƿ���Ҷ�ڵ�
    private String number;
	private String name;
	private ArrayList<GoodsVO> leaveNode=new ArrayList<GoodsVO>(); 
	
	private int packSuccess;
	
	TypeVO(String parent, String child, String number, String name){
		
		this.parent=parent;
		this.child=child;
		this.number=number;
		this.name=name;
		
	}
    
	
    
    public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getChild() {
		return child;
	}
	public void setChild(String child) {
		this.child = child;
	}
	public int getC() {
		return C;
	}
	public void setC(int c) {
		C = c;
	}
	public String getNumber() {
			return number;
    }
	public void setNumber(String number) {
			this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addLeave(GoodsVO g){
		
	}
	public ArrayList<GoodsVO> getAllLeave(){		
		return leaveNode;
	}
	public int isPackSuccess(){
		return packSuccess;
	}
        
}
