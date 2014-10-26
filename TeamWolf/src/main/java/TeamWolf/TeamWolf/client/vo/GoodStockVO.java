package TeamWolf.TeamWolf.client.vo;

public class GoodStockVO {

	private GoodsVO good;
	private double importAmount;
	private double importTotalPrice;
	private double exportAmount;
	private double exportTotalPrice;
	
	GoodStockVO(){
		
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
		return null;
	}
	
}
