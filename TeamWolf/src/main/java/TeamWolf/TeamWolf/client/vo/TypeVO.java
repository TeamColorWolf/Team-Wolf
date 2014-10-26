package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

public class TypeVO {
	
	private TypeVO parent;
    private TypeVO child;
    private int C;//�жϸ÷�����Ů�Ƿ���Ҷ�ڵ�
    private String number;
	private String name;
	private ArrayList<GoodsVO> leaveNode=new ArrayList<GoodsVO>(); 
	
	private int packSuccess;
	
	TypeVO(String parent, TypeVO child, String number, String name){
		
	}
    
	
    
    public TypeVO getParent() {
		return parent;
	}
	public void setParent(TypeVO parent) {
		this.parent = parent;
	}
	public TypeVO getChild() {
		return child;
	}
	public void setChild(TypeVO child) {
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
