package java_20190809;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java_20190719.Customer;

class A extends Thread{
		public void run() {
		System.out.println("스레드2...");
	}
}
public class GabageDemo {
	public static void main(String[] args) {
	
		A a =  new A();
		a.start();
		
		B b = new B();
		Thread t1 = new Thread(b);
		t1.start();
		
		System.out.println("aaaa");
		
		Calendar c = Calendar.getInstance();
		Calendar c1 = new GregorianCalendar();
		
}
	//캘린더 클래스의 메서드만 사용할 수 있음.
	// 단, 그레고리안 캘린더 클래스에서 오버라이딩된 메서드는 사용가능
	public static Calendar getInstance() {
		Calendar c = new GregorianCalendar();
		return new GregorianCalendar();
	}
}

class CustomerDao{
	public Customer[] getCustomer() {
		Customer[] c1= new Customer[10];
		Customer c1 = new Customor("성영한1");
		Customer c2 = new Customor("성영한2");
		Customer c3 = new Customor("성영한3");
		Customer c4 = new Customor("성영한4");
		Customer c5 = new Customor("성영한5");
		Customer c6 = new Customor("성영한6");
		Customer c6 = new Customor("성영한7");
		Customer c8 = new Customor("성영한8");
		Customer c9 = new Customor("성영한9");
		Customer c10 = new Customor("성영한10");
		
		cs[0] = new Customor("성영한1");
		cs[1] = new Customor("성영한2");
		cs[2] = new Customor("성영한3");
		cs[3] = new Customor("성영한4");
		cs[4] = new Customor("성영한5");
		cs[5] = new Customor("성영한6");
		cs[6] = new Customor("성영한7");
		cs[7] = new Customor("성영한8");
		cs[8] = new Customor("성영한9");
		cs[9] = new Customor("성영한10");;
		return cs;
	}
	
	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> list = new ArrayList<Customer> ();
		list.add(new Customer("성영한1"));
		list.add(new Customer("성영한2"));
		list.add(new Customer("성영한3"));
		list.add(new Customer("성영한4"));
		list.add(new Customer("성영한5"));
		list.add(new Customer("성영한6"));
		list.add(new Customer("성영한7"));
		list.add(new Customer("성영한8"));
		list.add(new Customer("성영한9"));
		list.add(new Customer("성영한10"));
		return list;
	}
}
