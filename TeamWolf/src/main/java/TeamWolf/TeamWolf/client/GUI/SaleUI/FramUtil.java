package TeamWolf.TeamWolf.client.GUI.SaleUI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * 
 * @author HalaWKS
 *
 */
public class FramUtil {
	
	/**
	 * 窗口居中
	 */
	public static void setFrameCenter(JFrame jf){
		//居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();/*获得显示器大小*/
		int x = screen.width-jf.getWidth() >> 1;
		int y = (screen.height-jf.getHeight() >> 1)-32;
		jf.setLocation(x, y);
	}
	
}
