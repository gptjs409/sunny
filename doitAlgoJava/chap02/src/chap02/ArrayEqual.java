package chap02;

import java.util.Scanner;

// 두 배열이 같은지 판단
public class ArrayEqual {

	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("a 배열의 요소수 : ");
		int na = stdIn.nextInt(); // 배열 a의 요소수
		int[] a = new int[na];    // 요소수가 na인 배열
		
		for (int i = 0; i < na; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}
		
		System.out.print("\n배열 b의 요소수 : ");
		int nb = stdIn.nextInt(); // 배열 b의 요소수
		int[] b = new int[nb];    // 요소수가 nb인 배열
		
		for (int i = 0; i < nb; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = stdIn.nextInt();
		}
		
		stdIn.close();
		System.out.println("\n배열 a와 b는 " + (equals(a, b) ? "같습니다" : "같지 않습니다."));
	}
	
	// 두 배열 a, b의 모든 요소가 같은가?
	static boolean equals(int[] a, int[] b) {
		
		// 두 배열 a, b의 요소 수(길이) 비교 > 같지 않을 경우 다른 배열
		if (a.length != b.length)
			return false;
		
		// 두 배열을 처음부터 스캔하면서 요소를 비교 > 같지 않을 경우 다른 배열
		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i])
				return false;
		
		// 모두 실행된 경우 같은 배열
		return true;
	}

}
