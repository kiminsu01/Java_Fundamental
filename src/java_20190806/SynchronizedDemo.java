package java_20190806;

public class SynchronizedDemo implements Runnable {
	int x;
	int y;


 public void run() { 
	 // public synchronized void run() { // 동일한 객체를 사용하는 두개 쓰레드의 충돌방지 => synchronized
	 						            // 단 처리속도는 느려진다.	
	 // synchronized (this) { 
	 synchronized (SynchronizedDemo.class) { //  synchronized 블록설정
	 for(int i=0; i<1000;i++) {
	 	x++;
	 	y++;
	 	String threadName = Thread.currentThread().getName();
	 	System.out.printf("x : %d, y: %d - %s%n", x, y,threadName);
	 		}
	 }
}	

	public static void main(String[] args) {
		SynchronizedDemo s1 = new SynchronizedDemo();
				
		Thread t1 =  new Thread(s1); // t1과 t2가 s1이라는 동일한 객체를 사용
		Thread t2 =  new Thread(s1);
		
		t1.start();
		t2.start();
	}
	}
