package TeamWolf.TeamWolf.client.BLservice.financeBLservice;

import TeamWolf.TeamWolf.client.vo.financeVO;

public interface AccountBlservice {
    public int add(String name);
    public int delete(String name);
    public int update(String previousname,String newname);
    public financeVO find(String name);
 
}
