package chap01;

public class Exam2 {

	// 세 값의 대소 관계 13 종류의 모든 조합에 대해 중앙값을 구하여 출력하는 프로그램 작성 (기존 실습 참고)
	public static void main(String[] args) {
		
		System.out.println("med3(3,2,1) = " + med3(3, 2, 1)); // [A] a > b > c
		System.out.println("med3(3,2,2) = " + med3(3, 2, 2)); // [B] a > b = c
		System.out.println("med3(3,1,2) = " + med3(3, 1, 2)); // [C] a > c > b
		System.out.println("med3(3,2,3) = " + med3(3, 2, 3)); // [D] a = c > b
		System.out.println("med3(2,1,3) = " + med3(2, 1, 3)); // [E] c > a > b
		System.out.println("med3(3,3,2) = " + med3(3, 3, 2)); // [F] a = b > c
		System.out.println("med3(3,3,3) = " + med3(3, 3, 3)); // [G] a = b = c
		System.out.println("med3(2,2,3) = " + med3(2, 2, 3)); // [H] c > a = b
		System.out.println("med3(2,3,1) = " + med3(2, 3, 1)); // [I] b > a > c
		System.out.println("med3(2,3,2) = " + med3(2, 3, 3)); // [J] b > a = c
		System.out.println("med3(1,3,2) = " + med3(1, 3, 2)); // [K] b > c > a
		System.out.println("med3(2,3,3) = " + med3(2, 3, 3)); // [L] b = c > a
		System.out.println("med3(1,2,3) = " + med3(1, 2, 3)); // [M] c > b > a
	}

	static int med3 (int a, int b, int c) {
		int med = a;
		
		if (a >= b)
			if (b >= c)
				med = b;  // [A] [B] [F] [G]
			else if (a <= c) 
				{}        // [D] [E] [H]
			else
				med = c;  // [C]
		else if (a > c)
			{}            // [I]
		else if (b > c)
			med = c;      // [J] [K]
		else
			med = b;      // [L] [M]
		
		return med;
	}
	
	// 해당 메서드가 med3보다 효율이 떨어지는 이유?
	/* 
	 * 비교 연산자가 더 많이 들어가서가 아닐까?
	 */
	static int med3d (int a, int b, int c) {
		int med3d = a;
		
		if ((b >= a && c <= a) || (b <= a && c >= a))
			{}
		else if ((a > b && c < b) || (a < b && c > b))
			med3d = b;
		else 
			med3d = c;
		
		return med3d;
	}
}

/*  
 * 연습문제
 * 
 * Q4. 세 값의 대소 관계 13종류의 모든 조합에 대해 중앙값을 구하여 출력하는 프로그램을 작성하세요.
 *     Max3m 클래스와 Median 클래스를 참고하세요.
 *     
 * Q5. 중앙 값을 구하는 메서드는 다음과 같이 작성할 수도 있습니다.
 *     그러나 Median 클래스의 med3 메서드에 비해 효율이 떨어지는데, 그 이유를 설명하세요.
 *     static int med3 (int a, int b, int c) {
 *       if ((b >= a && c <= a) || (b <= a && c >= a))
 *           return a;
 *       else if ((a > b && c < b) || (a < b && c > b))
 *           return b;
 *       return c;
 */