package chap02;

// Random 사용시 Import
import java.util.Random;
import java.util.Scanner;

// 배열 요소의 최댓값을 나타냄(값은 난수로 생성)
public class MaxOfArrayRand {
	
	public static void main(String[] args) {
		
		// Random 사용 선언
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수 : ");
		int num = stdIn.nextInt(); // 배열의 요소수
		stdIn.close();
		
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
 * Random 클래스의 인스턴스는 일련의 의사 난수를 생성
 *     > 의사 난수 : 의사 = 실제와 비슷함, 진짜 난수는 아니지만(로또 번호 뽑듯), 그와 비슷하게 처리
 *     > seed 값과 컴퓨터 환경이 같다면, 결과 값이 항상 같음
 *     > 보통 seed 값을 겹치지 않게 하기 위해 현재 시간을 이용하는 것이 일반적
 * 난수는 seed(씨앗)이라는 수의 값을 바탕으로 여러 연산을 수행하여 얻음
 * Random 클래스에서는 48비트의 seed를 사용, 이 seed는 선형 합동법이라는 계산법에 의해 특정 수(난수)로 바뀜
 * Random random = new Random();
 *     > 난수 생성기를 새로 만듦, Random 클래스의 다른 인스턴스와 겹치지 않도록 seed 값을 자동 결정
 * Random random = new Random(n);
 *     > 난수 생성기를 새로 만들되, seed값을 n으로 설정
 */