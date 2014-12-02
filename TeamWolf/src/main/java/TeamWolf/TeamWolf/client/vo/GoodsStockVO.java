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
	
	public GoodsStockVO(){
		
	}

	public GoodsVO getGood() {
		return good;
	}

	public void setGood(GoodsVO good) {
		this.good = good;
	}

	public double getImportAmount() {
		return importAmount;
	}

	public void setImportAmount(double importAmount) {
		this.importAmount = importAmount;
	}

	public double getImportTotalPrice() {
		return importTotalPrice;
	}

	public void setImportTotalPrice(double importTotalPrice) {
		this.importTotalPrice = importTotalPrice;
	}

	public double getExportAmount() {
		return exportAmount;
	}

	public void setExportAmount(double exportAmount) {
		this.exportAmount = exportAmount;
	}

	public double getExportTotalPrice() {
		return exportTotalPrice;
	}

	public void setExportTotalPrice(double exportTotalPrice) {
		this.exportTotalPrice = exportTotalPrice;
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
	}
}
