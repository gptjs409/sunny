package chap02;

import java.util.Scanner;

// 배열 요소의 최댓값을 나타냅니다(값을 입력받음)
public class MaxOfArray {
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int num = stdIn.nextInt();  // 배열의 요소수를 입력
		
		int[] height = new int[num]; // 요소수가 num인 배열 생성
		
		for (int i = 0; i < num; i++) {
			System.out.print("heigh[" + i + "] : ");
			height[i] = stdIn.nextInt();
		}
		
		stdIn.close();
		
		System.out.println("최댓값은 " + maxOf(height) + "입니다.");
	}
	/*
	 * 키의 최댓값을 구합니다.
	 * 사람 수 : 4
	 * heigh[0] : 1
	 * heigh[1] : 5
	 * heigh[2] : 6
	 * heigh[3] : 5
	 * 최댓값은 6입니다.
	 */

	// 배열 a의 최댓값을 구하여 반환합니다.
	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}
}
