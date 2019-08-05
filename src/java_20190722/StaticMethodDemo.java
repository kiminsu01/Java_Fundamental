package java_20190722;

public class StaticMethodDemo {
	static {
		System.out.println("static block");
		interestRate = 4.20;
	}
	{
		System.out.println("instance block");
		name="성영한";
		
	}
	String name;
	static double interestRate;
	
	public StaticMethodDemo() {
		System.out.println("생성자");
	}
	
	public void m1() {
		System.out.println("m1() 메서드 호출");
	}
	public void m2() {
		//instance method에서는 
		//instance 변수, static 변수 사용가능
		//instance 메서드, static 메서드 호출 가능
		this.name = "성영한";
		StaticMethodDemo.interestRate = 0.1;
		this.m1();
		StaticMethodDemo.m3();
	}
	
	public static void m3() {
		System.out.println("m3() 메서드 호출");
	}
	public static void m4() {
		//static method에서는 this를 사용할 수 없음.
		//static method에서는 
		//instance 변수 사용할 수 없음, static 변수 사용가능
		//instance 메서드 호출 불가능, static 메서드 호출 가능
		//name = "홍길동";
		interestRate = 0.2;
		//m1();
		m3();
		
		
		
	}
	public static void main(String[] args) {
		System.out.println("main");
		
		
		StaticMethodDemo s1 = new StaticMethodDemo();
		
	}
	
}







