package homework2;

public class MemberFindDtoDemo {
	public static void main(String[] args) {
		//1. 객체를 생성한다.
		MemberFindDto m1 = new MemberFindDto(1,"syh@test.com","111","2019-08-01","2019-08-02");
		//2. 객체의 내용을 출력해 본다.
		System.out.println(m1.getSeq());
		System.out.println(m1.getEmail());
		System.out.println(m1.getCode());
		System.out.println(m1.getSdate());
		System.out.println(m1.getEdate());
		//3. 객체의 내용을 수정해 본다.
		m1.setSeq(1111);
		m1.setEmail("syh1111@test.com");
		m1.setCode("12121212");
		m1.setSdate("2019-09-01");
		m1.setEdate("2019-09-02");
		//4. 객체의 내용을 출력해 본다.
		System.out.println(m1.getSeq());
		System.out.println(m1.getEmail());
		System.out.println(m1.getCode());
		System.out.println(m1.getSdate());
		System.out.println(m1.getEdate());
		
		MemberFindDto m2 = new MemberFindDto(
				2,"syh2@test.com","2222","2019-08-02","2019-08-03");
		//1,2,3,4 => homework
		MemberFindDto m3 = new MemberFindDto(
				3,"syh3@test.com","3333","2019-09-02","2019-09-03");
		//1,2,3,4 => homework
		
		
		
		
		
		
	}
}