package chap02;

import java.util.Random;

public class Exam1 {

	public static void main(String[] args) {
		
		// Random 사용 선언
		Random rand = new Random();
		
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int num = rand.nextInt(100); // 배열의 요소수
		
		int[] height = new int[num]; // 요소수가 num인 배열 생성
		
		System.out.println("키 값은 아래와 같습니다.");
		for (int i = 0; i < num; i++) {
			// rand.nextInt(n) → 난수를 생성하는 메서드, 0 ~ n - 1까지의 난수를 반환
			height[i] = 100 + rand.nextInt(90); // 요소의 값을 난수로 결정
			System.out.println("height[" + i + "] : " + height[i]);
		}
		
		System.out.println("최댓값은 " + maxOf(height) + "입니다.");
	}

	// 배열 a의 최댓값을 구하여 반환
	static int maxOf(int [] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];
		return max;
	}

}

/*
 * 연습문제
 * 
 * Q1. 키 뿐만 아니라 사람 수도 난수로 생성하도록 MaxOfArrayRand Class를 수정하여 프로그램을 작성하세요.
 */