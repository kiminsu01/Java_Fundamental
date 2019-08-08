package homework2;

public class MemberFindDtoDemo {
	public static void main(String[] args) {
		// 1. 객체를 생성해 본다.
		MemberFindDto m1 = new MemberFindDto(1,"ddd@test.com","2323","2019-09-02");
		// 2. 객체의 내용을 출력해 본다.
		System.out.println(m1.getSeq());
		System.out.println(m1.getEmail());
		System.out.println(m1.getCode());
		System.out.println(m1.getSdate());
		System.out.println(m1.getEdate());
		// 3. 객체의 내용을 수정해 본다.
		
		// 4. 객체의 내용을 출력해 본다. 
		MemberFindDto m2 = new MemberFindDto(1,"ddd@test.com","2323","2019-09-02");
	}
}
