package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;
import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

 /**
  * 
  * @author XYJ
  *
  * 注：特价包是一种特殊的分类，其底下必有商品，其上没有父类，编号是特殊编号（正常分类编号为四位，特价包为五位）
  */
 
 public class TypePO implements Serializable {

	private TypePO parent;
    private ArrayList<TypePO> child;
    private int C;// 0为没有子女，1为有子分类， 2为有商品
    private String number;
	private String name;
	private ArrayList<GoodsPO> leaveNode;
	
	
	public TypePO(TypePO parent, String number, String name){
		child=new ArrayList<TypePO>();
		leaveNode=new ArrayList<GoodsPO>();
		this.parent=parent;
		this.number=number;
		this.name=name;
	}
	
	public TypePO(TypeVO t) {
		// TODO Auto-generated constructor stub
		child=new ArrayList<TypePO>();
		leaveNode=new ArrayList<GoodsPO>();
	    number=t.getNumber();
	    name=t.getName();
	    C=t.getC();
		
	}

	public TypePO getParent() {
		return parent;
	}
	public void setParent(TypePO parent) {
		this.parent = parent;
	}
	public ArrayList<TypePO> getChild() {
		return child;
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
	public boolean addChildType(TypePO t){
		if(C!=2){
			 t.parent=this;
		     child.add(t);
		     C=1;
		     return true;
		}
		else
			return false;
	}
	public boolean addLeaveNode(GoodsPO g){
		if(C!=1){
			g.parent=this;
		    leaveNode.add(g);
		    C=2;
		    return true;
		}
		else
			return false;
	}
	public boolean delChildType(String number){
		if(C==1){
			TypePO toDel=null;
			for(TypePO t:child){
				if(t.getNumber().equals(number)){
					toDel=t;
				}
			}
			if(toDel!=null){
				child.remove(toDel);
				if(child.isEmpty())
					C=0;
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	public boolean delLeaveNode(String number){
		if(C==2){
			GoodsPO toDel=null;
			for(GoodsPO g:leaveNode){
			    if(g.getNumber().equals(number)){
			    	toDel=g;
			    }
			}
			if(toDel!=null){
				leaveNode.remove(toDel);
				if(leaveNode.isEmpty())  //检查是否已经空了
					C=0;
				return true;
			}
			else 
				return false;
		}
		else 
			return false;
	}

	public void updChildType(TypeVO t) {
		// TODO Auto-generated method stub
		int toUpd=0;
		boolean finded=false;
		TypePO UPD=null;
		for(TypePO tt: child){
			if(tt.getNumber().equals(t.getNumber())){
				UPD=tt;
				UPD.setName(t.getName());
				toUpd=child.indexOf(tt);
				finded=true;
			}
		}
		if(finded==true){
			child.remove(toUpd);
			child.add(toUpd, UPD);
		}
	}
}
