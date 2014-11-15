package TeamWolf.TeamWolf.client.BL.customerBL;

import TeamWolf.TeamWolf.client.po.CustomerPO;
import TeamWolf.TeamWolf.client.vo.CashApplicationVO;
import TeamWolf.TeamWolf.client.vo.CustomerVO;
import TeamWolf.TeamWolf.client.vo.ImportListVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;
import TeamWolf.TeamWolf.client.vo.PaymentApplicationVO;
import TeamWolf.TeamWolf.client.vo.RecieptApplicationVO;
import TeamWolf.TeamWolf.client.vo.SaleListVO;
import TeamWolf.TeamWolf.client.vo.SaleRejectListVO;

public class CustomerInfo_stub extends CustomerInfo{
	public CustomerInfo_stub(String IP){
		super(IP);
	}
	
    public int ImportListInfoMod(ImportListVO vo) {
    	if(vo.getRemark().equals("REMARKTEST")){
    		return 0;
    	}else{
    		return -1;
    	}
	}
 	public int ImportRejectListMod(ImportRejectListVO vo) {
 		if(vo.getRemark().equals("REMARKTEST")){
    		return 0;
    	}else{
    		return -1;
    	}
	}
 	public int SaleListMod(SaleListVO vo) {
 		if(vo.getRemark().equals("REMARKTEST")){
    		return 0;
    	}else{
    		return -1;
    	}
	}
 	public int SaleRejectListMod(SaleRejectListVO vo) {
 		if(vo.getRemark().equals("REMARKTEST")){
    		return 0;
    	}else{
    		return -1;
    	}
	}
 	public int RecieptListMod(RecieptApplicationVO vo) {
 		if(vo.getNumber().equals("NUMBERTEST")){
    		return 0;
    	}else{
    		return -1;
    	}
	}
 	public int PaymentListMod(PaymentApplicationVO vo) {
 		if(vo.getNumber().equals("NUMBERTEST")){
    		return 0;
    	}else{
    		return -1;
    	}
	}
 	public int CashListMod(CashApplicationVO vo) {
 		if(vo.getNumber().equals("NUMBERTEST")){
    		return 0;
    	}else{
    		return -1;
    	}
	}
 	public CustomerPO getInfo() {
		return null;
	}
}
