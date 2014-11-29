package TeamWolf.TeamWolf.client.GUI.messageUI;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;

public class GetMessage {
	
	static FileInputStream fr;
	static BufferedReader br;
	static String unknowError = "未知错误";
	
	public static String getMessage(int error){
		try {
			fr = new FileInputStream("反馈信息//message.tw");
			br = new BufferedReader(new InputStreamReader(fr, "GBK"));
			String message;
			try {
				while((message = br.readLine()) != null){
					String[] a = message.split("==");//分隔数字和String的符号位 "=="，如 0==操作成功
					if(error == Integer.parseInt(a[0])){
						fr.close();
						br.close();
						return a[1];
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return unknowError;
	}
	
	public static ImageIcon getImageIcon(int error){
		if(error == 0){
			return new ImageIcon("反馈信息//right.png");
		}
		else{
			return new ImageIcon("反馈信息//error.png");
		}
	}
}
