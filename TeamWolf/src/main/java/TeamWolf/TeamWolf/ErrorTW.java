package TeamWolf.TeamWolf;

public class ErrorTW {
	public static final int webError = 30000;
	public static final int notFound = 404;
	public static final int timeError = 20000;//结束时间早于起始时间
	public static final int shouldBeInteger = 10001;//商品数量必须为整数
	public static final int shoulbBePositive = 10010;//商品数量或价格必须为正数
	public static final int shouldBeDouble = 10011;//商品价格必须为小数
	public static final int powerError=1000;   //权限不足（如库存管理员无法编辑特价包）
	public static final int cannotAddType_1=1001;  //返回不可在有商品的分类下添加子分类
	public static final int cannotAddType_2=1002;  //商品分类已存在于系统中
	public static final int connotDelType_1=1003;  //不可删除底下有子女的分类
	public static final int cannotOperateForNotExist=1004; // 错误类型：商品不存在于系统中
    public static final int notComplete=1005;  //错误类型：信息填写不完整
    public static final int cannotAddGoods_1=2001;  //分类下有子分类不可添加商品
    public static final int GoodsIsExisted=2002;  //商品已存在
    public static final int notMatchToParent=2003; //商品与父类不匹配
    public static final int GoodsIsnotExisted=2004; //商品不存在
    public static final int notEnough=2006; //库存不足
    public static final int specialGoodsGone=2007; //特价包已不存在
    public static final int illegalTime=2008; //时间不合法
	public static final int lackListInfo = 7001;//进货单(销售单)信息填写不完整
	public static final int chooseNoItem = 7002;//未选择需要退的单据
	public static final int containsSpecialGoods = 7003;//销售单包含特价商品，不能退货
	public static final int wrongGoodsNum = 7004;//商品数量小于等于0,或者为小数
	public static final int wrongDiscountNum = 7005;//折让金额不能小于0
	public static final int moreThanDiscount = 7006;//折让金额过多
	public static final int shouldReduceDiscount = 7007;//折让导致总额为负数
	public static final int listAmountOverFlow = 7008;//单据数量达到上限
	public static final int lackCustomerInfo = 701;//客户信息不完整
	public static final int stillShouldPay = 702;//未结算清，无法删除
	public static final int notFondCustomer = 703;//未找到对应客户
	public static final int haveAlreadyExist = 704;//客户已经存在（添加客户时）
	public static final int chooseNoCustomer = 705;//未选择要删除的客户
	public static final int wrongTopLimit = 706;//应收额度小于0
	public static final int someApplicationFailed = 40001;//存在审批失败的单据
	public static final int manageServerError = 40000;//总经理服务器端出错
	public static final int approveWithoutApplication = 40002;//必须有单据时审批
	public static final int userServerError = 50000;//用户服务器端出错
	public static final int userMessageLack = 50001;//用户信息必须填写完整
	public static final int userNameExist = 50002;//该用户名已经存在
	public static final int userNameNotExist = 50003;//该用户名不存在
	public static final int userInformationError = 50004;//用户名或密码错误
	public static final int userInformationLack = 50005;//输入用户信息不全
	public static final int accountNameExist = 99991;//账户名称已存在
	public static final int accountNameNotExist = 99992;//账户名称不存在
}
