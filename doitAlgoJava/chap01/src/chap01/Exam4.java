package chap01;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = 0, a = 0, b = 0;
		
		while (num != 1 && num != 2 && num != 3) {
			System.out.println("무슨 작업을 할 지 숫자를 쓰시오");
			System.out.println("1 - Total 합, 2 - 가우스 덧셈, 3 - 2 숫자 포함한 사이 모든 값의 합");
			System.out.print("무슨 작업을 하고 싶습니까? (1/2/3) : ");
			num = sc.nextInt();
		}
				
		if (num == 1) {
			System.out.print("토탈 합을 구할 n 값 : ");
			a = sc.nextInt();
			sumTotal(a);
		}
		else if (num == 2) {
			System.out.print("가우스 덧셈을 이용 합을 구할 n 값 : ");
			a = sc.nextInt();
			System.out.println("가우스 덧셈을 이용한 합 : " + sumGauss(a));
		}
		else {
			System.out.print("a 값 : ");
			a = sc.nextInt();
			System.out.print("b 값 : ");
			b = sc.nextInt();
			System.out.println(a + "와 " + b + " 값 포함한 사이의 합 : " + sumof(a, b));
		}
		
		sc.close();
	}

	// SumFor를 참고하여 n이 7이면 "1 + 2 + 3 + 4 + 5 + 6 + 7 = 28"로 출력하는 프로그램을 작성하시오.
	static void sumTotal (int n) {
		int sum = 0;
		
		for (int i = 1; i <= n; i++) {
			System.out.print(i);
			if (i != n)
				System.out.print(" + ");
			else
				System.out.print(" = ");
			sum += i;
		}
		
		System.out.print(sum);
	}
	
	
	// 1 ~ 10까지의 합은 (1 + 10) * 5와 같은 방법으로 구할 수 있음
	// 가우스의 덧셈이라는 방법을 이용하여 1 ~ n까지의 정수 합을 구하는 프로그램을 작성
	// 가우스의 덧셈 : (첫 값 + 끝 값) * (값의 개수) / 2 = 첫 값 ~ 끝 값까지의 합 
	static int sumGauss (int n) {
		int sum = (1 + n) * n / 2;
		return sum;
	}
	
	// 정수 a, b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 메서드를 작성하시오
	// a와 b의 대소관계에 상관없이 합을 구할 것, (a = 3, b = 5 > 12 // a = 6, b = 4 > 15)
	static int sumof(int a, int b) {
		int sum = 0;
		
		int max = a, min = b;
		
		if (a < b) {
			min = a;
			max = b;	
		}
		
		while (min <= max) {
			sum += min;
			min++;
		}
		
		return sum;
	}
}

/* 
 * 연습문제
 * 
 * Q7. SumFor 클래스를 참고하여 n이 7이면 '1 + 2 + 3 + 4 + 5 + 6 + 7 = 28'로 출력하는 프로그램을 작성하세요.
 * 
 * Q8. 1부터 10까지의 합은 (1 + 10) * 5와 같은 방법으로 구할 수 있습니다.
 *     가우스의 덧셈이라는 방법을 이용하여 1부터 n까지의 정수 합을 구하는 프로그램을 작성하세요.
 *     
 * Q9. 정수 a, b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 아래 메서드를 작성하세요.
 *     static int sumof(int a, int b)
 *     a와 b의 대소 관계에 상관 없이 합을 구하세요.(a가 3, b가 5면 12, a가 6, b가 4면 15)
 */
