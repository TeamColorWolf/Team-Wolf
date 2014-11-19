package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;
/**
 * 
 * @author WHJ
 *
 */
public class ApplicationPO implements Serializable{
	public String number;//单据编号
	public String operator;//单据操作员
	public int condition;//单据状态（待审批，审批通过，审批不通过）
}
