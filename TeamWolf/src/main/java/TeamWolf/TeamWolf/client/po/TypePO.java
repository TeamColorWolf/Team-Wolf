package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

 /**
  * 
  * @author XYJ
  *
  */
 
 public class TypePO implements Serializable {

	private TypePO parent;
    private TypePO child;
    private int C;//�жϸ÷�����Ů�Ƿ���Ҷ�ڵ�
    private String number;
	private String name;
	private ArrayList<GoodsPO> leaveNode=new ArrayList<GoodsPO>();
	
	
	public TypePO(){
		
	}
	
	public TypePO(TypeVO t) {
		// TODO Auto-generated constructor stub
	}

	public TypePO getParent() {
		return parent;
	}
	public void setParent(TypePO parent) {
		this.parent = parent;
	}
	public TypePO getChild() {
		return child;
	}
	public void setChild(TypePO child) {
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
	public ArrayList<GoodsPO> getLeaveNode() {
		return leaveNode;
	}
	public void setLeaveNode(ArrayList<GoodsPO> leaveNode) {
		this.leaveNode = leaveNode;
	} 
	
}
