package TeamWolf.TeamWolf.client.BL.saleBL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import TeamWolf.TeamWolf.ErrorTW;
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
			return ErrorTW.listAmountOverFlow;
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

		
		if(number > 99999){
			return ErrorTW.listAmountOverFlow;
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
			return ErrorTW.listAmountOverFlow;
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
			return ErrorTW.listAmountOverFlow;
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
}

