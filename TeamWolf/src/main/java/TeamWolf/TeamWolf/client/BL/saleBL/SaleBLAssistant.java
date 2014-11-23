package TeamWolf.TeamWolf.client.BL.saleBL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import TeamWolf.TeamWolf.client.DATAservice.saleDATAservice.SaleDATAservice;
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
	SaleDATAservice sds;
	
	public int canAddCustomer (CustomerVO cvo){
		return 0;
	}
	
	public boolean canDelCustomer (CustomerVO cvo){
		return true;
	}
	
	/**
	 * 判断是否能够添加进货单
	 * @param ivo
	 * @return 0：添加成功；1：单据数量达到上限；2：进货数量错误（为0或小于0）
	 */
	public int canAddImport (ImportListVO ivo){
		
		int number = Integer.parseInt(ivo.number);
		ArrayList<GoodsVO> goodsList = ivo.getGoodsList();
		if(number > 99999){
			return 1;
		}
		for(int i = 0; i < goodsList.size(); i++){
			int goodsNum = Integer.parseInt(goodsList.get(i).getNumber());
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
		
		int number = Integer.parseInt(irvo.number);
		ArrayList<GoodsVO> goodsList = irvo.getGoodsList();
		
		if(number > 99999){
			return 1;
		}
		
		
		return 0;
	}
	
	/**
	 * 判断是否能够添加销售单
	 * @param svo
	 * @return 0：添加成功；1：单据数量达到上限；2：销售数量错误（为0或小于0）
	 */
	public int canAddSale (SaleListVO svo){
		return 0;
	}
	
	/**
	 * 判断是否能够添加销售退货单
	 * @param svo
	 * @return 0：添加成功；1：单据数量达到上限；2：未找到对应的销售单
	 */
	public int canAddSaleReject (SaleRejectListVO srvo){
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
