package chap01;

import java.util.Scanner;

// SumWhile에서 while 문이 종료될 때 변수 i 값이 n+1이 됨을 확인하시오
// 변수 i 값을 출력하도록 프로그램을 수정 

//1, 2, ... , n의 합 구하기
public class Exam3 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("1부터 n까지의 합을 구해보자");
		System.out.print("n은? : ");
		int n = stdIn.nextInt();
		stdIn.close();
		
		int sum = 0; // 합
		int i = 1;   // 반복문에서 사용할 변수 
		
		System.out.println("i = " + i);
		while (i <= n) { // i가 n 이하면 반복
			sum += i;    // sum에 i를 더함
			i++;         // i값을 1만큼 증가 
			if (i <= n)
				System.out.println("i + 1 = " + i);
		}
		System.out.println("1부터 " + n + "까지의 합은 " + sum +"입니다.");
	}

}

/* 
 * 연습문제
 * 
 * Q6. SumWhile 클래스에서 while문이 종료될 때 변수 i 값이 n + 1이 됨을 확인하세요.
 *     (변수 i값을 출력하도록 프로그램을 수정하세요.)
 */