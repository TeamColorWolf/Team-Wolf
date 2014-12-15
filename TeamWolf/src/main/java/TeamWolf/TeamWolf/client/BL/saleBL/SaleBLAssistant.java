package TeamWolf.TeamWolf.client.BL.saleBL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice.SaleApplicationDATAservice;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.GoodsVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

/**
 * 
 * @author WKS
 *
 */
public class SaleBLAssistant {
	SaleApplicationDATAservice sads;
	
	public int canAddCustomer (CustomerVO cvo){
		return 0;
	}
	
	public boolean canDelCustomer (CustomerVO cvo){
		return true;
	}
	
	/**
	 * 判断是否能够添加进货单
	 * @param ivo
	 * @return 0：添加成功；1：单据数量达到上限；2：进货数量错误（为0或小于0或小数）
	 */
	public int canAddImport (ImportListVO ivo){
		String numSplit[] = ivo.number.split("-");
		int number = Integer.parseInt(numSplit[2]);
		ArrayList<GoodsVO> goodsList = ivo.getGoodsList();
		if(number > 99999){
			return 1;
		}
		for(int i = 0; i < goodsList.size(); i++){
			int goodsNum = goodsList.get(i).getAmount();
			if(goodsNum <= 0){
				return 2;
			}
		}
		
		return 0;
	}
	
	/**
	 * 判断是否能够添加进货退货单
	 * @param irvo
	 * @return 0：添加成功；1：单据数量达到上限；2：未找到对应的进货单
	 */
	public int canAddImportReject (ImportRejectListVO irvo){
		String numSplit[] = irvo.number.split("-");
		int number = Integer.parseInt(numSplit[2]);
		ArrayList<GoodsVO> rejectGoodsList = irvo.getGoodsList();
		ArrayList<ImportListVO> importList = getImportList();
		boolean b = true, a = true;
		
		if(number > 99999){
			return 1;
		}
		for(int j = 0; j < importList.size(); j++){
			//b是用来判断是否存在对应进货单的;a是用来判断当前（第j项）进货单是否与要生成的退货单信息一致
			b = true;
			a = true;
			//获取其中一条进货单据的商品列表
			ArrayList<GoodsVO> importGoodsList = importList.get(j).getGoodsList();
			
			for(int i = 0; i < rejectGoodsList.size(); i++){			
				//当前退货单商品列表中第i项的信息（商品名、商品数量）
				String rejectName = rejectGoodsList.get(i).getName();
				int rejectNum = rejectGoodsList.get(i).getAmount();
				
				for(int k = 0; k < importGoodsList.size(); k++){
					//如果遇到名字相同的商品，再比较它们的数量是否一致
					if(rejectName.equals(importGoodsList.get(k).getName())){
						if(rejectNum == importGoodsList.get(k).getAmount()){
							//如果当前退货商品单中第i项商品找到了对应的商品，则跳出这层循环，转而对第i+1项扫描
							break;
						}
					}
					if(k + 1 == importGoodsList.size()){
						//扫描了一遍都没发现相同的数据，则证明当前进货单不符合要求，转而对第j+1条进货单进行扫描
						a = false;
						b = false;
						break;
					}
				}
				//如果a为false（即当前（第j项）进货单已经不符合要求，跳出第二层循环，找到第j+1个进货单）
				if(!a){
					break;
				}
			}
		}
		
		//b为false，说明没找到对应的进货单，返回2
		if(!b){
			return 2;
		}
		
		return 0;
	}
	
	/**
	 * 判断是否能够添加销售单
	 * @param svo
	 * @return 0：添加成功；1：单据数量达到上限；2：销售数量错误（为0或小于0）
	 */
	public int canAddSale (SaleListVO svo){
		String numSplit[] = svo.number.split("-");
		int number = Integer.parseInt(numSplit[2]);
		ArrayList<GoodsVO> goodsList = svo.getGoodsList();
		if(number > 99999){
			return 1;
		}
		for(int i = 0; i < goodsList.size(); i++){
			int goodsNum = goodsList.get(i).getAmount();
			if(goodsNum <= 0){
				return 2;
			}
		}
		return 0;
	}
	
	/**
	 * 判断是否能够添加销售退货单
	 * @param svo
	 * @return 0：添加成功；1：单据数量达到上限；2：未找到对应的销售单
	 */
	public int canAddSaleReject (SaleRejectListVO srvo){
		String numSplit[] = srvo.number.split("-");
		int number = Integer.parseInt(numSplit[2]);
		if(number > 99999){
			return 1;
		}
		return 0;
	}
	
	public String getDate (){
		String date = "";
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		date = sdf.format(dt);
		return date;
	}
	
	/**
	 * 获取进货单
	 * @return
	 */
	public ArrayList<ImportListVO> getImportList(){
		return null;
	}
	
	/**
	 * 获取销售单
	 * @return
	 */
	public ArrayList<SaleListVO> getSaleList(){
		return null;
	}
}
