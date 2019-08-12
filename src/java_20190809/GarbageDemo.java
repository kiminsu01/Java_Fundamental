package java_20190809;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

class A extends Thread{
	public void run() {
		//System.out.println("스레드1....");
	}
}

class B implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}


class Customer{
	String name;
	Customer(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class CustomerDao{
	public Customer[] getCustomer() {
		Customer[] cs = new Customer[10];
		cs[0]  = new Customer("성영한1");
		cs[1]  = new Customer("성영한2");
		cs[2]  = new Customer("성영한3");
		cs[3]  = new Customer("성영한4");
		cs[4]  = new Customer("성영한5");
		cs[5]  = new Customer("성영한6");
		cs[6]  = new Customer("성영한7");
		cs[7]  = new Customer("성영한8");
		cs[8]  = new Customer("성영한9");
		cs[9]  = new Customer("성영한10");
		return cs;
		
	}
	
	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> list = new ArrayList<Customer>(20);
		for(int i=0;i<10;i++) {
			list.add(new Customer("성영한"+i));
		}
		return list;
	}
}

public class GarbageDemo {
	
	
	
	public static void main(String[] args) throws IOException {
		//Dao (Data Access Object)
		CustomerDao cdao = new CustomerDao();
		Customer[] customers = cdao.getCustomer();
		
		for (Customer customer : customers) {
			System.out.println(customer.getName());
		}
		
		ArrayList<Customer> list = cdao.getCustomers();
		for (Customer customer : list) {
			System.out.println(customer.getName());
		}
	}
	
}








