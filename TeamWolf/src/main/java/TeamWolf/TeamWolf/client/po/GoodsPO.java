package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.TypeVO;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsPO implements Serializable {

    String parentNum;
	String parentName;
	TypePO parent;
	String number;
	String name;
	String model;
	int amount;
	double imprice;
	double exprice;
	double latestImprice;
	double latestExprice;
	int WarningLine;
	
	
	public GoodsPO(GoodsVO g) {
		// TODO Auto-generated constructor stub
		this.number=g.getNumber();
		this.name=g.getName();
		this.amount=g.getAmount();
		this.exprice=g.getExprice();
		this.imprice=g.getImprice();
		this.parentNum=g.getParentNum();
		this.parentName=g.getParent();
		this.WarningLine=g.gerWarningLine();
		this.model=g.getModel();
		this.latestExprice=g.getLatestExprice();
		this.latestImprice=g.getLatestImprice();
		
	}
	public GoodsPO(TypePO parent, String number, String name, String model, int amount, double imprice, double exprice, double latestImprice, double latestExprice){
		
		this.parent=parent;
		this.number=number;
		this.name=name;
		this.model=model;
		this.amount=amount;
		this.imprice=imprice;
		this.exprice=exprice;
		this.latestImprice=latestImprice;
		this.latestExprice=latestExprice;
	}
	
	public String getParentName(){
		return parentName;
	}
	public String getParentNumber(){
		return parentNum;
	}
	public TypePO getParent() {
		return parent;
	}
	public void setParent(TypePO parent) {
		this.parent = parent;
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getImprice() {
		return imprice;
	}
	public void setImprice(double imprice) {
		this.imprice = imprice;
	}
	public double getExprice() {
		return exprice;
	}
	public void setExprice(double exprice) {
		this.exprice = exprice;
	}
	public double getLatestImprice() {
		return latestImprice;
	}
	public void setLatestImprice(double latestImprice) {
		this.latestImprice = latestImprice;
	}
	public double getLatestExprice() {
		return latestExprice;
	}
	public void setLatestExprice(double latestExprice) {
		this.latestExprice = latestExprice;
	}
	public void setWarningLine(int WL){
		this.WarningLine=WL;
	}
	public boolean checkWL(){
		return amount<=WarningLine;
	}
	public int getWL() {
		// TODO Auto-generated method stub
		return this.WarningLine;
	}
	
}
