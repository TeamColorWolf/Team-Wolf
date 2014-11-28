package TeamWolf.TeamWolf.client.vo;

import java.util.ArrayList;

/**
 * 
 * @author XYJ
 *
 */
public class TypeListVO {

	public ArrayList<TypeVO> typeL=new ArrayList<TypeVO>();
	private String TypeListInfo;
	
	public void addType(TypeVO t){
		typeL.add(t);
	}
	public String getInfo(){
		return TypeListInfo;
	}
	
}
