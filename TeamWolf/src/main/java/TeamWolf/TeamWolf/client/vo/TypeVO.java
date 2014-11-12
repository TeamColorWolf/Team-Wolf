package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.TypePO;
/**
 * 
 * @author XYJ
 *
 */
public class TypeVO {
	
	private String parent;
    private ArrayList<String> child;
    private int C;//�жϸ÷�����Ů�Ƿ���Ҷ�ڵ�
    private String number;
	private String name;
	private ArrayList<GoodsVO> leaveNode=new ArrayList<GoodsVO>(); 
	
	private int packSuccess;
	
	public TypeVO(String parent, String number, String name){
		
		this.parent=parent;
		this.child=new ArrayList<String>();
		this.number=number;
		this.name=name;
		
	}
	
    public TypeVO(String parent, ArrayList<String> child, String number, String name){
		
		this.parent=parent;
		this.child=child;
		this.number=number;
		this.name=name;
		
	}
    
    public TypeVO(TypePO tp){
    	
    }
	
    
    public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public ArrayList<String> getChildList() {
		return child;
	}
	public void setChild(ArrayList<String> childList) {
		this.child = childList;
	}
	public void addToChild(String child){
		this.child.add(child);
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
		this.leaveNode.add(g);
	}
	public ArrayList<GoodsVO> getAllLeave(){		
		return leaveNode;
	}
	public int isPackSuccess(){
		return packSuccess;
	}
        
}
