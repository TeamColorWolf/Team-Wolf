package TeamWolf.TeamWolf.client.po;

import java.io.Serializable;

public class ApplicationPO implements Serializable{
	String number;//单据编号
	String worker;//单据操作员
	int condition;//单据状态（待审批，审批通过，审批不通过）
}
