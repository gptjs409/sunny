package chap01;

public class Max3m {

	// a, b, c의 최댓값을 구해서 반환(메서드 분리)
	static int max3 (int a, int b, int c) {
		int max = a;
		if (b > max)
			max = b;
		if (c > max)
			max = c;
		
		// 구한 최댓 값을 호출한 곳으로 반
		return max;
	}
	
	public static void main (String[] args) { // 파라미터
		System.out.println("max3(3,2,1) = " + max3(3, 2, 1)); // [A] a > b > c // 아규먼트 
		System.out.println("max3(3,2,2) = " + max3(3, 2, 2)); // [B] a > b = c
		System.out.println("max3(3,1,2) = " + max3(3, 1, 2)); // [C] a > c > b
		System.out.println("max3(3,2,3) = " + max3(3, 2, 3)); // [D] a = c > b
		System.out.println("max3(2,1,3) = " + max3(2, 1, 3)); // [E] c > a > b
		System.out.println("max3(3,3,2) = " + max3(3, 3, 2)); // [F] a = b > c
		System.out.println("max3(3,3,3) = " + max3(3, 3, 3)); // [G] a = b = c
		System.out.println("max3(2,2,3) = " + max3(2, 2, 3)); // [H] c > a = b
		System.out.println("max3(2,3,1) = " + max3(2, 3, 1)); // [I] b > a > c
		System.out.println("max3(2,3,2) = " + max3(2, 3, 3)); // [J] b > a = c
		System.out.println("max3(1,3,2) = " + max3(1, 3, 2)); // [K] b > c > a
		System.out.println("max3(2,3,3) = " + max3(2, 3, 3)); // [L] b = c > a
		System.out.println("max3(1,2,3) = " + max3(1, 2, 3)); // [M] c > b > a
	}
}
