package TeamWolf.TeamWolf;

public class ErrorTW {
	public static final int webError = 30000;
	public static final int notFound = 404;
	public static final int timeError = 20000;
	public static final int shouldBeInteger = 10001;
	public static final int shoulbBePositive = 10010;
	public static final int powerError=1000;   //权限不足（如库存管理员无法编辑特价包）
	public static final int cannotAddType_1=1001;  //返回不可在有商品的分类下添加子分类
	public static final int cannotAddType_2=1002;  //商品分类已存在于系统中
	
	public static final int cannotOperateForNotExist=1004; // 错误类型：商品不存在于系统中
	public static final int lackListInfo = 7001;//进货单(销售单)信息填写不完整
	public static final int chooseNoItem = 7002;//未选择需要退的单据
	public static final int containsSpecialGoods = 7003;//销售单包含特价商品，不能退货
	public static final int lackCustomerInfo = 701;//客户信息不完整
	public static final int stillShouldPay = 702;//未结算清，无法删除
	public static final int notFondCustomer = 703;//未找到对应客户
}
