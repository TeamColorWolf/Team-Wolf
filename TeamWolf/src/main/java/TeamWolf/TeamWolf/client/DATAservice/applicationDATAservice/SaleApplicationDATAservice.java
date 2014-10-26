package TeamWolf.TeamWolf.client.DATAservice.applicationDATAservice;

import TeamWolf.TeamWolf.client.po.SaleListPO;
import TeamWolf.TeamWolf.client.po.SaleRejectListPO;
import TeamWolf.TeamWolf.client.po.ImportListPO;
import TeamWolf.TeamWolf.client.po.ImportRejectListPO;

public interface SaleApplicationDATAservice {
	public int submitImportList(ImportListPO po);
	
	public int submitImportRejectList(ImportRejectListPO po);
	
	public int submitExportList(SaleListPO po);
	
	public int submitExportRejectList(SaleRejectListPO po);
	
	public int approvalImportList(ImportListPO po);
	
	public int approvalImportRejectList(ImportRejectListPO po);
	
	public int approvalExportList(SaleListPO po);
	
	public int approvalExportRejectList(SaleRejectListPO po);
}
