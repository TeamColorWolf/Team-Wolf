package TeamWolf.TeamWolf.client.vo;
/**
 * 
 * @author XYJ
 * 这是库存查看类型的商品对象
 */

public class GoodsStockVO {

	private GoodsVO good;
	private double importAmount;
	private double importTotalPrice;
	private double exportAmount;
	private double exportTotalPrice;
	private double totalPrice;
	private double averagePrice;
	private String GStockInfo;
	private String[] object;
	
	public GoodsStockVO(){
		
		object=new String[15];
		
	}

	public GoodsVO getGood() {
		return good;
	}

	public void setGood(GoodsVO good) {
		this.good = good;
		object[0]=good.getNumber();
		object[1]=good.getName();
		object[2]=good.getModel();
		object[3]=""+good.getAmount();
		object[5]=""+good.getImprice();
		object[6]=""+good.getExprice();
		object[7]=""+good.getLatestImprice();
		object[8]=""+good.getLatestExprice();
	}

	public double getImportAmount() {
		return importAmount;
	}

	public void setImportAmount(double importAmount) {
		this.importAmount = importAmount;
		object[9]=""+importAmount;
	}

	public double getImportTotalPrice() {
		return importTotalPrice;
	}

	public void setImportTotalPrice(double importTotalPrice) {
		this.importTotalPrice = importTotalPrice;
		object[10]=""+importTotalPrice/(double)importAmount;
		object[11]=""+importTotalPrice;
	}

	public double getExportAmount() {
		return exportAmount;
	}

	public void setExportAmount(double exportAmount) {
		this.exportAmount = exportAmount;
		object[12]=""+exportAmount;
	}

	public double getExportTotalPrice() {
		return exportTotalPrice;
	}

	public void setExportTotalPrice(double exportTotalPrice) {
		this.exportTotalPrice = exportTotalPrice;
		object[13]=""+exportTotalPrice/(double)this.exportAmount;
		object[14]=""+exportTotalPrice;
	}
	
	public String getInfo(){
		return GStockInfo;
	}
	
	public double getIAP(){
		return importTotalPrice/importAmount;
	}
	
	public double getEAP(){
		return exportTotalPrice/exportAmount;
	}
	
	public void setTotalPrice(double totalP){
		this.totalPrice=totalP;
		this.averagePrice=totalP/(double)good.getAmount();
		object[4]=""+averagePrice;
	}
	
    public String getIndexOf(int i){
    	
    	if(i<15){
    		return object[i];
    	}
    	else
    		return null;
    }
}
