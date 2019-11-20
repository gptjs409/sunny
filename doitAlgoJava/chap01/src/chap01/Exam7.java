package chap01;

import java.util.Scanner;

public class Exam7 {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		
		do {
			System.out.print("임의의 자연수를 입력하세요 : ");
			n = sc.nextInt();
		} while (n <= 0);
		
		sc.close();
		
		System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력");
		triangleLB(n);
		
		System.out.println();
		System.out.println("왼쪽 위가 직각인 이등변 삼각형을 출력");
		triangleLU(n);
		
		System.out.println();
		System.out.println("오른쪽 위가 직각인 이등변 삼각형을 출력");
		triangleRU(n);
		
		System.out.println();
		System.out.println("오른쪽 아래가 직각인 이등변 삼각형을 출력");
		triangleRB(n);
		
		System.out.println();
		System.out.println("n단의 피라미드를 출력");
		spira(n);

		System.out.println();
		System.out.println("아래를 향한 n단의 숫자 피라미드를 출력");
		npira(n);

	}
	
	static void triangleLB(int n) {    // 왼쪽 아래가 직각인 이등변 삼각형을 출력 
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	static void triangleLU(int n) {    // 왼쪽 위가 직각인 이등변 삼각형을 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	static void triangleRU(int n) {    // 오른쪽 위가 직각인 이등변 삼각형을 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++)
				System.out.print(" ");
			for (int j = 0; j < n - i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	static void triangleRB(int n) {    // 오른쪽 아래가 직각인 이등변 삼각형을 출력
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n - i; j++)
				System.out.print(" ");
			for (int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}	
	}
	
	static void spira(int n) {         // n단의 피라미드를 출력
		for (int i = 1 ; i <= n; i++) {
			for (int j = 1; j <= n - ((i - 1) * 2 + 1) / 2; j++)
				System.out.print(" ");
			for (int j = 1; j <= (i - 1) * 2 + 1; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	static void npira(int n) {         // 아래를 향한 n단의 숫자 피라미드를 출력
		for (int i = 1 ; i <= n; i++) {
			for (int j = 1; j <= n - ((i - 1) * 2 + 1) / 2; j++)
				System.out.print(" ");
			for (int j = 1; j <= (i - 1) * 2 + 1; j++)
				System.out.print(i);
			System.out.println();
		}	
	}
}

/*
 * 연습문제
 * 
 * Q15. 직각 이등변 삼각형을 출력하는 부분을 아래와 같은 형식의 메서드로 작성하세요.
 *      static void triangleLB(int n)    // 왼쪽 아래가 직각인 이등변 삼각형을 출력 
 *      또 왼쪽 위, 오른쪽 위, 오른쪽 아래가 직각인 이등변 삼각형을 출력하는 메서드를 작성하세요. 
 *      static void triangleLU(int n)    // 왼쪽 위가 직각인 이등변 삼각형을 출력 
 *      static void triangleRU(int n)    // 오른쪽 위가 직각인 이등변 삼각형을 출력
 *      static void triangleRB(int n)    // 오른쪽 아래가 직각인 이등변 삼각형을 출력 
 *      
 * Q16. n단의 피라미드를 출력하는 메서드를 작성하세요. (아래는 4단의 예)
 *      static void spira(int n)
 *      i행에는 (i - 1) * 2 + 1개의 기호문자 *가 출력되게 하세요.
 *      (마지막 n행에는 (n - 1) * 2 + 1개의 기호 문자 *를 출력하게 됩니다.
 *          *
 *         ***
 *        *****
 *       *******
 *      
 * Q17. 아래쪽과 같이 아래를 향한 n단의 숫자 피라미드를 출력하는 메서드를 작성하세요.
 *      static void npira(int n)
 *      i행에 출력되는 숫자는 i % 10으로 구하세요.
 *          1
 *         222
 *        33333
 *       4444444
 */