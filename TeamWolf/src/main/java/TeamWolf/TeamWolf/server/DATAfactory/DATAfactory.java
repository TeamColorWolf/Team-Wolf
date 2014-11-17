package TeamWolf.TeamWolf.server.DATAfactory;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import TeamWolf.TeamWolf.server.userDATA.UserDATA;


public class DATAfactory {
	UserDATA user;
	
	public DATAfactory(){
		try {
			user = new UserDATA();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Naming.rebind("userDATAservice", user);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws UnknownHostException{
		InetAddress addr = InetAddress.getLocalHost();
		String ip=addr.getHostAddress().toString();//获得本机IP
		System.out.println("My IP : " + ip);
		DATAfactory fac = new DATAfactory();
	}
}
