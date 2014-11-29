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
}
