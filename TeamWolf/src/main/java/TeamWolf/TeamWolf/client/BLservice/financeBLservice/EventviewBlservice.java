package TeamWolf.TeamWolf.client.BLservice.financeBLservice;

import TeamWolf.TeamWolf.client.vo.TimeVO;

public interface EventviewBlservice {
     public int event();
     public int eventDATE(TimeVO time1, TimeVO time2);
     public int eventPERIOD();
}
