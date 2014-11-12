package TeamWolf.TeamWolf.client.BL.saleBL;

import java.util.ArrayList;
import java.util.Date;

import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

/**
 * 
 * @author WKS
 *
 */
public class SaleBL_Stub {
	
	SaleBLAssistant saleAssist;
	Date presentDate;
	
	public SaleBL_Stub(){
		saleAssist = new SaleBLAssistant();
		presentDate = saleAssist.getDate();
	}
	
	public int addCustomer(CustomerVO cvo) {
		int judge = saleAssist.canAddCustomer(cvo);
		//判断能否添加客户
		if(judge == 0){
			
		}
		return judge;
	}

	public int delCustomer(CustomerVO cvo) {
		int judge = 0;
		//判断能否删除客户（应收应付不为0，也不可删除）
		if(saleAssist.canDelCustomer(cvo)){
			
		} else {
			
		}
		return judge;
	}

	public int modCustomer(CustomerVO cvo) {
		int judge = 0;
		return judge;
	}

	public ArrayList<CustomerVO> findCustomer(String keyWord, String number) {
		return null;
	}

	public int createImport(ImportListVO ivo) {
		int judge = saleAssist.canAddImport(ivo);
		if(judge == 0){
			
		}
		return 0;
	}

	public int createImportReject(ImportRejectListVO irvo) {
		int judge = saleAssist.canAddImportReject(irvo);
		if(judge == 0){
			
		}
		return 0;
	}

	public int createSale(SaleListVO svo) {
		int judge = saleAssist.canAddSale(svo);
		if(judge == 0){
			
		}
		return 0;
	}

	public int createSaleReject(SaleRejectListVO srvo) {
		int judge = saleAssist.canAddSaleReject(srvo);
		if(judge == 0){
			
		}
		return 0;
	}

	//获取仓库编号
	public ArrayList<String> getStock() {
		// TODO Auto-generated method stub
		return null;
	}

	//显示单据
	public ArrayList<ApplicationVO> show(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	//提交单据
	public int submit(ApplicationVO avo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
