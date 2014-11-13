package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;
/**
 * 
 * @author WHJ
 *
 */
public class ApplicationPO implements Serializable{
	protected String number;//单据编号
	protected String worker;//单据操作员
	protected int condition;//单据状态（待审批，审批通过，审批不通过）
}
