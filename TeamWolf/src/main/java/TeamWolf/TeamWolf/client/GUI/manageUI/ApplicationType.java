package TeamWolf.TeamWolf.client.GUI.manageUI;

public class ApplicationType {
	enum Type{
		库存报溢单,
		库存报损单,
		库存赠送单,
		进货单,
		进货退货单,
		销售单,
		销售退货单,
		收款单,
		付款单,
		现金费用单
	}
	
	private ApplicationType(){
		
	}
	
	public static String getType(String number){
		if(number == null){
			return "Unknow Application";
		}
		String[] n = number.split("-");
		if(n[0].equals("KCBYD")){
			return Type.库存报溢单.toString();
		}
		else if(n[0].equals("KCBSD")){
			return Type.库存报损单.toString();
		}
		else if(n[0].equals("KCZSD")){
			return Type.库存赠送单.toString();
		}
		else if(n[0].equals("JHD")){
			return Type.进货单.toString();
		}
		else if(n[0].equals("JHTHD")){
			return Type.进货退货单.toString();
		}
		else if(n[0].equals("XSD")){
			return Type.销售单.toString();
		}
		else if(n[0].equals("XSTHD")){
			return Type.销售退货单.toString();
		}
		else if(n[0].equals("SKD")){
			return Type.收款单.toString();
		}
		else if(n[0].equals("FKD")){
			return Type.付款单.toString();
		}
		else if(n[0].equals("XJFYD")){
			return Type.现金费用单.toString();
		}
		else if(n[0].equals("KCZSD")){
			return Type.库存赠送单.toString();
		}
		return "Unknow Application";
	}
}
