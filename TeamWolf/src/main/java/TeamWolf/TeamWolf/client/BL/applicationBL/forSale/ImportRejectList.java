package TeamWolf.TeamWolf.client.BL.applicationBL.forSale;

import TeamWolf.TeamWolf.client.BL.applicationBL.Application;
import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
import TeamWolf.TeamWolf.client.vo.ImportRejectListVO;

public class ImportRejectList extends Application{

	public ImportRejectList(ImportRejectListVO vo, String IP) {
		super(vo, IP);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ApplicationVO getApplicationVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationPO getApplicationPO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int submit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int approve() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reject() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int change(ApplicationVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
