package chap01;

import java.util.Scanner;

// 하나의 변수를 사용하는 반복문은 while보다 for가 좋음 
public class SumFor {

	public static void main(String[] args) {
		
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("1부터 n까지의 합을 구해보자");
		System.out.print("n은? : ");
		int n = stdIn.nextInt();
		stdIn.close();
		
		int sum = 0; // 합
		
		for (int i = 1; i <= n; i++) { // i가 n 이하면 반복
			sum += i;    // sum에 i를 더함
		}
		
		System.out.println("1부터 " + n + "까지의 합은 " + sum +"입니다.");
	}
}
