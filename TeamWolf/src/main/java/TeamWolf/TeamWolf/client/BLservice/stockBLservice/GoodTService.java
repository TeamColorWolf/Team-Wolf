package TeamWolf.TeamWolf.client.BLservice.stockBLservice;

import java.util.ArrayList;

import TeamWolf.TeamWolf.client.vo.*;

public interface GoodTService {


    /**
     * �鿴�ض���Ʒ������ϸ��Ϣ
     * @param number
     * @return
     */
	public PresentListVO checkPL(int number);
	/**
	 * �鿴������Ʒ���Ĵ�����Ϣ
	 * @return
	 */
	public ArrayList<PresentListVO> shoSimplifiedPL();
	
	public int goodsExport(SaleListVO sl);
	
	public int goodsExportReject(SaleRejectListVO srl);
	
	public int goodsImport(ImportListVO il);
	
	public int goodsImportReject(ImportRejectListVO irl);
	
}
