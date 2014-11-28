package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.po.GoodsPO;
import TeamWolf.TeamWolf.client.po.TypePO;
/**
 * 
 * @author XYJ
 *
 * 注：特价包是一种特殊的分类，其底下必有商品，其上没有父类，编号是特殊编号（正常分类编号为四位，特价包为五位）
 *
 */
public class TypeVO {
	
	private String parent;
	private String parentNumber;
    private ArrayList<String> child=new ArrayList<String>();
    private int C;//�жϸ÷�����Ů�Ƿ���Ҷ�ڵ�
    private String number;
	private String name;
	private ArrayList<GoodsVO> leaveNode=new ArrayList<GoodsVO>(); 
	
	private int packSuccess;
	
	public TypeVO(String parentNum, String parent, String number, String name){
		
		this.parentNumber=parentNum;
		this.parent=parent;
		this.child=new ArrayList<String>();
		this.number=number;
		this.name=name;
		
	}
	
    public TypeVO(String parentNum, String parent, ArrayList<String> child, String number, String name){
		
    	this.parentNumber=parentNum;
		this.parent=parent;
		this.child=child;
		this.number=number;
		this.name=name;
		
	}
    
    public TypeVO(TypePO tp){
    	
    	this.C=tp.getC();
    	this.name=tp.getName();
    	this.number=tp.getNumber();
    	if(tp.getParent()!=null){
    	    this.parent=tp.getParent().getName();
    	    this.parentNumber=tp.getParent().getNumber();
    	}
        this.child=new ArrayList<String>();
        this.leaveNode=new ArrayList<GoodsVO>();
    	
    	if(this.C==1){
    		
    		ArrayList<TypePO> childL=tp.getChild();
    		for(TypePO t:childL){
    			child.add(t.getNumber());
    		}
    	}
    	else if(this.C==2){
    		ArrayList<GoodsPO> goodsL=tp.getLeaveNode();
    		for(GoodsPO g: goodsL){
    			leaveNode.add(new GoodsVO(g));
    		}
    	}
    }
	
    
    public void serParentNum(String parentNum){
    	parentNumber=parentNum;
    }
    public String getParentNum(){
    	return parentNumber;
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
