package TeamWolf.TeamWolf.client.BL.saleBL;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	private SaleBLAssistant saleAssist = new SaleBLAssistant();
	private String presentDate;
	
	public SaleBL_Stub(){
		presentDate = saleAssist.getDate();
	}
	
	public int addCustomer(CustomerVO cvo) {
		int judge = saleAssist.canAddCustomer(cvo);
		//判断能否添加客户
		if(judge == 0){
			System.out.println("Add customer successfully");
		}
		return judge;
	}

	public int delCustomer(CustomerVO cvo) {
		int judge = 0;
		//判断能否删除客户（应收应付不为0，也不可删除）
		if(saleAssist.canDelCustomer(cvo)){
			System.out.println("Delete customer successfully");
		} else {
			
		}
		return judge;
	}

	public int modCustomer(CustomerVO cvo) {
		int judge = 0;
		System.out.println("Modify customer successfully");
		return judge;
	}

	public ArrayList<CustomerVO> findCustomer(String keyWord, int number) {
		System.out.println("show the list");
		return null;
	}

	public int createImport(ImportListVO ivo) {
		int judge = saleAssist.canAddImport(ivo);
		if(judge == 0){
			System.out.println("create import list successfully");
		}
		return 0;
	}

	public int createImportReject(ImportRejectListVO irvo) {
		int judge = saleAssist.canAddImportReject(irvo);
		if(judge == 0){
			System.out.println("create import reject list successfully");
		}
		return 0;
	}

	public int createSale(SaleListVO svo) {
		int judge = saleAssist.canAddSale(svo);
		if(judge == 0){
			System.out.println("create sale list successfully");
		}
		return 0;
	}

	public int createSaleReject(SaleRejectListVO srvo) {
		int judge = saleAssist.canAddSaleReject(srvo);
		if(judge == 0){
			System.out.println("create sale reject list successfully");
		}
		return 0;
	}

	//获取仓库编号
	public ArrayList<String> getStock() {
		System.out.println("the number of stock is 1");
		return null;
	}

	//显示单据
	public ArrayList<ApplicationVO> show(String num) {
		System.out.println("show the application list");
		return null;
	}

	//提交单据
	public int submit(ApplicationVO avo) {
		System.out.println("submit " + avo.number + " list successfully");
		return 0;
	}
	
}
