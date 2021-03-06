package TeamWolf.TeamWolf.client.vo;

import java.io.Serializable;

import TeamWolf.TeamWolf.client.po.GoodsPO;

/**
 * 
 * @author XYJ
 *
 */
public class GoodsVO implements Serializable{

	private String parent;
	private String parentNumber;
	private String number;
	private String name;
	private String model;
	private int amount;
	private int WarningLine;
	private double imprice;
	private double exprice;
	private double latestImprice;
	private double latestExprice;
	private String goodsInfo;
	private int packSuccess;
	
	//添加商品
	public GoodsVO(String parentNum, String parent, String number, String name, String model, String amount, String imprice, String exprice, String latestImprice, String latestExprice, String WL){
		
		this.parentNumber=parentNum;
		this.parent=parent;
		this.number=number;
		this.name=name;
		this.model=model;
		
		try{
             if(WL!=null)		
			    this.WarningLine=Integer.parseInt(WL);
             if(amount!=null)
			    this.amount=Integer.parseInt(amount);
             if(imprice!=null)
			    this.imprice=Double.parseDouble(imprice);
             if(exprice!=null)
			    this.exprice=Double.parseDouble(exprice);
             if(latestExprice!=null)
			    this.latestExprice=Double.parseDouble(latestExprice);
             if(latestImprice!=null)
			    this.latestImprice=Double.parseDouble(latestImprice);
			}catch(Exception e){
				packSuccess=1;
			}
	}
	
	public GoodsVO(GoodsPO g) {
		// TODO Auto-generated constructor stub
		parentNumber=g.getParentNumber();
		parent=g.getParentName();
		number=g.getNumber();
		name=g.getName();
		model=g.getModel();
		amount=g.getAmount();
		imprice=g.getImprice();
		exprice=g.getExprice();
		latestImprice=g.getLatestImprice();
		latestExprice=g.getLatestExprice();
		WarningLine=g.getWL();
	}

	public void setParentNum(String parentNum){
		parentNumber=parentNum;
	}
	public String getParentNum(){
		return parentNumber;
	}
	public int gerWarningLine(){
		return WarningLine;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
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
	
	public String getInfo(){
		
		goodsInfo=number+"; "+name+"; "+model+"; "+amount+"; "+imprice+"; "+exprice+"; "+latestImprice+"; "+latestExprice;
		
		return goodsInfo;
	}
	
	public int isPackSuccess(){
		return packSuccess;
	}
}
