package chap01;

import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		System.out.println("다음 중 작업하실 것을 골라 숫자를 입력해주세요.");
		System.out.println("1 : b - a / 2 : 자리수 세기");
		
		do {
			System.out.print("1 또는 2를 입력하세요. : ");
			num = sc.nextInt();
		} while (num != 1 && num != 2);
		
		if (num == 1) {
			System.out.print("a를 입력하세요 : ");
			int a = sc.nextInt(), b = 0;
			
			do {
				System.out.print("a보다 큰 수인 b를 입력하세요 : ");
				b = sc.nextInt();
			} while (b <= a);
		
			System.out.println("b - a는 " + (b - a) + "입니다");
		} else {
			System.out.print("자릿수가 궁금한 수를 입력해보세요. : ");
			int a = sc.nextInt();
			System.out.println("그 수는 " + (a + "").length() + "자리 입니다.");
		}
		sc.close();
	}

}

/* 
 * 연습문제
 * 
 * Q10. 아래쪽과 같이 두 변수 a, b에 정수를 입력하고 b - a를 출력하는 프로그램을 작성하세요.
 *      단, 변수 b에 입력된 값이 a 이하면 변수 b의 값을 다시 입력하세요.
 *      a의 값 : 6
 *      b의 값 : 6
 *      a보다 큰 값을 입력하세요!
 *      b의 값 : 8
 *      b - a는 2입니다.
 *      
 * Q11. 양의 정수를 입력하고 자릿수를 출력하는 프로그램을 작성하세요.
 *      예를 들어 135를 입력하면 '그 수는 3자리입니다,'라고 출력하고, 1314를 입력하면 '그 수는 4자리입니다.'라고 출력하면 됩니다. 
 */