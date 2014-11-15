package TeamWolf.TeamWolf.client.vo;

import java.io.Serializable;

public class ApplicationVO implements Serializable{
	
	/**
	 * 单据编号
	 */
	public String number;
	
	/**
	 * 单据操作员
	 */
	public String operator;
	
	/**
	 * 单据状态（待审批，审批通过，审批不通过）
	 */
	public int condition;
	
}
