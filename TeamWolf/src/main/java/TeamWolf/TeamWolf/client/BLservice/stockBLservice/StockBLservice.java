
package TeamWolf.TeamWolf.client.BLservice.stockBLservice;
import TeamWolf.TeamWolf.client.vo.*;

/***
 * 此接口包含库存管理（商品分类的增、删、改、显示）功能
 * @author XYJ
 *
 */
public interface StockBLservice {

	
	public int addType(TypeVO t);
	
	public int delType(TypeVO t);
	
	public int updType(TypeVO t);
	
	public TypeListVO shoAllType();

	
}
