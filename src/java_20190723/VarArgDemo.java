package java_20190723;

public class VarArgDemo {
	public VarArgDemo() {}
	public long sum(int... temp){// temp 변수는 배열로 처리함
		long sum = 0;//지역변수 , 메세드내에서 유효함.
		
		for(int i=0;i<temp.length;i++) {
			sum += temp[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		VarArgDemo v1 =new VarArgDemo();
		
		long s1 = v1.sum(1,2);
		System.out.println(s1);
		long s2 = v1.sum(1,2,3,4);
		System.out.println(s2);
		
	}
	
}
