package chap02;

// 구성 자료형이 int형인 배열(구성 요소수는 5 : 배열 초기자에 의해 생성)
public class IntArryInit {

	public static void main(String[] args) {
		
		int[] a = {1, 2, 3, 4, 5}; // 배열 초기자에 의해 생성
		
		for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i]);
		}
	}

	/*
	 * a[0] = 1
	 * a[1] = 2
	 * a[2] = 3
	 * a[3] = 4
	 * a[4] = 5
	 */
}
