package java_20190725;

public class ShapeDemo {
	//추상 클래스의 다형성
	public static void run(Shape s) { //Shape s = new Rectangle()
		s.draw();
	}
//	
//	public static void run(Rectangle r) {
//		r.draw();
//	}
//	public static void run(Circle c) {
//		c.draw();
//	}
//	
	public static void main(String[] args) {
		//추상 클래스는 객체를 생성 할 수 없음..
		//Shape s = new Shape();
		//Rectangle r = new Rectangle();
		//Shape s1 = r;
		//s1.draw();
		
		run(new Rectangle());
		
		Shape s2 = new Circle();
		//s2.draw();
		run(s2);
	}
}
