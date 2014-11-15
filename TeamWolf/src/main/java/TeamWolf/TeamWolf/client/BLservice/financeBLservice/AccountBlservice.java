package TeamWolf.TeamWolf.client.BLservice.financeBLservice;

import TeamWolf.TeamWolf.client.po.financePO;
import TeamWolf.TeamWolf.client.vo.financeVO;

public interface AccountBlservice {
    public int add(financeVO vo);
    public int delete(financeVO vo);
    public int update(financeVO vo,financeVO newvo);
    public financeVO find(financeVO vo);
 
}
