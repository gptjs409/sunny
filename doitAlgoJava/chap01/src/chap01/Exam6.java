package chap01;

import java.util.Scanner;

public class Exam6 {

	public static void main (String[] args) {
		System.out.print("임의의 1자리 숫자를 입력하세요 : ");
		
		Scanner sc = new Scanner(System.in);
		int n = 0;
		
		do {
			n = sc.nextInt();
			sc.close();
		} while (n <= 0 || n >= 10);
		
		System.out.println("곱셈표를 출력하겠습니다.");
		multi99tables(n);
		
		System.out.println("");
		System.out.println("덧셈표도 출력하겠습니다.");
		plus99tables(n);
		
		System.out.println("");
		System.out.println(n + "을 한 변으로 갖는 * 정사각형도 출력해 보겠습니다.");
		starNumber(n);
	}
	
	static void multi99tables (int n) {
		System.out.print(" |");
		for (int i = 1; i <= n; i++) {
			System.out.print("  " + i);
		}
		System.out.println("");
		
		System.out.print("-+");
		for (int i = 0; i < n; i++) {
			System.out.print("---");
		}
		System.out.println("");	

		for (int i = 1; i <= n; i++) {
			System.out.print(i + "|");
			for (int j = 1; j <= n; j++) {
				System.out.print(" ");
				if (i * j <= 9)
					System.out.print(" ");
				System.out.print(i * j);
			}
			System.out.println("");
		}
	}
	
	static void plus99tables (int n) {
		System.out.print(" |");
		for (int i = 1; i <= n; i++) {
			System.out.print("  " + i);
		}
		System.out.println("");
		
		System.out.print("-+");
		for (int i = 0; i < n; i++) {
			System.out.print("---");
		}
		System.out.println("");	

		for (int i = 1; i <= n; i++) {
			System.out.print(i + "|");
			for (int j = 1; j <= n; j++) {
				System.out.print(" ");
				if (i + j <= 9)
					System.out.print(" ");
				System.out.print(i + j);
			}
			System.out.println("");
		}		
	}
	
	static void starNumber (int n) {
		System.out.println("사각형을 출력합니다.");
		System.out.println("단 수 : " + n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}

/*
 * 연습문제
 * 
 * Q12. 아래와 같이 위쪽과 왼쪽에 곱하는 수가 있는 곱셈표를 출력하는 프로그램을 작성하세요.
 *      구분선은 수직선 기호 (|), 마이너스 기호(-), 플러스 기호(+)를 사용하세요.
 *       |  1  2  3  4  5  6  7  8  9
 *      -+---------------------------
 *      1|  1  2  3  4  5  6  7  8  9
 *      2|  2  4  6  8 10 12 14 16 18
 *      3|  3  6  9 12 15 18 21 24 27
 *      4|  4  8 12 16 20 24 28 32 36
 *      5|  5 10 15 20 25 30 35 40 45
 *      6|  6 12 18 24 30 36 42 48 54
 *      7|  7 14 21 28 35 42 49 56 63
 *      8|  8 16 24 32 40 48 56 64 72
 *      9|  9 18 27 36 45 54 63 72 81
 *      
 * Q13. 곱셈이 아니라 덧셈을 출력하는 프로그램을 작성하세요.
 *      Q12와 같이 표의 위쪽과 왼쪽에 더하는 수를 출력하세요.
 *       |  1  2  3  4  5  6  7  8  9
 *      -+---------------------------
 *      1|  2  3  4  5  6  7  8  9 10
 *      2|  3  4  5  6  7  8  9 10 11
 *      3|  4  5  6  7  8  9 10 11 12
 *      4|  5  6  7  8  9 10 11 12 13
 *      5|  6  7  8  9 10 11 12 13 14
 *      6|  7  8  9 10 11 12 13 14 15
 *      7|  8  9 10 11 12 13 14 15 16
 *      8|  9 10 11 12 13 14 15 16 17
 *      9| 10 11 12 13 14 15 16 17 18
 *      
 * Q14. 아래쪽과 같이 입력한 수를 한 변으로 하는 정사각형을 * 기호로 출력하는 프로그램을 작성하세요.
 *      사각형을 출력합니다.
 *      단 수 : 9
 *      *********
 *      *********
 *      *********
 *      *********
 *      *********
 *      *********
 *      *********
 *      *********
 *      *********
 */