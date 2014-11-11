package TeamWolf.TeamWolf.client.BL.applicationBL;

import TeamWolf.TeamWolf.client.po.ApplicationPO;
import TeamWolf.TeamWolf.client.vo.ApplicationVO;
//所有方法需要 @Override 验证确保覆盖了
/**
 * Author WHJ
 */
public class Application {
	protected ApplicationType type;
	protected int condition;//0 表示未审批， 1 表示审批通过， -1表示审批不通过
	
	public Application(ApplicationVO vo){
		
	}
	
	public ApplicationVO getApplicationVO(){
		return null;
	}
	
	public ApplicationPO getApplicationPO(){
		return null;
	}
	
	public int submit(){
		return 0;
	}
	
	public int getResult(){
		return condition;
	}
	
	public int approve(){
		condition = 1;
		return 0;
	}
	
	public int reject(){
		condition = -1;
		return 0;
	}
	
	public int change(ApplicationVO vo){
		return 0;
	}
	
	public ApplicationType getApplicationType(){
		return type;
	}
}
