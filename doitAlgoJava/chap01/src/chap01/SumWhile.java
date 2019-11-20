package chap01;

import java.util.Scanner;

// 1, 2, ... , n의 합 구하기
public class SumWhile {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("1부터 n까지의 합을 구해보자");
		System.out.print("n은? : ");
		int n = stdIn.nextInt();
		stdIn.close();
		
		int sum = 0; // 합
		int i = 1;   // 반복문에서 사용할 변수 
		
		while (i <= n) { // i가 n 이하면 반복
			sum += i;    // sum에 i를 더함
			i++;         // i값을 1만큼 증가  
		}
		
		System.out.println("1부터 " + n + "까지의 합은 " + sum +"입니다.");
	}

}
