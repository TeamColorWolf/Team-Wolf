package TeamWolf.TeamWolf.server;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileOpr {
	
	static FileInputStream ifile;
	static FileOutputStream ofile;
	static ObjectInputStream ois;
	static ObjectOutputStream oos;
	
	public static Object readFile(String fileName) throws IOException, ClassNotFoundException{
		ifile = new FileInputStream(fileName);
		ois = new ObjectInputStream(ifile);
		Object o = ois.readObject();
		ifile.close();
		ois.close();
		return o;
	}
	
	public static void writeFile(String fileName, Object o) throws IOException{
		ofile = new FileOutputStream(fileName);
		oos = new ObjectOutputStream(ofile);
		oos.writeObject(o);
		ofile.close();
		oos.close();
	}
	
}
