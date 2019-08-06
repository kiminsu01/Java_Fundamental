package java_20190806;

import java.net.InetAddress;
import java.rmi.UnknownHostException;

public class InetAddressDemo {
	
	public static void main(String[] args) throws UnknownHostException, java.net.UnknownHostException {
	InetAddress i = InetAddress.getLocalHost();
	
	System.out.printf("호스트 이름 : %s%n", i.getHostName());
	System.out.printf("호스트 IP : %s%n", i.getHostAddress());
	
	InetAddress i1 = InetAddress.getByName("naver.com");
	System.out.printf("호스트 이름 : %s%n", i.getHostName());
	System.out.printf("호스트 IP : %s%n", i.getHostAddress());
	}
}
