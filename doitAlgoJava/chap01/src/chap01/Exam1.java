package chap01;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = 0, a = 0, b = 0, c = 0, d = 0;
		String want = "";
		
		while (num != 3 && num != 4) {
			System.out.println("몇 개의 값을 비교하실 건지 3과 4 둘 중 하나만 쓰세요.");
			num = sc.nextInt();			
		}
		
		System.out.print("a의 값을 입력하세요 : ");
		a = sc.nextInt();
		System.out.print("b의 값을 입력하세요 : ");
		b = sc.nextInt();
		System.out.print("c의 값을 입력하세요 : ");
		c = sc.nextInt();
		
		if (num == 4) {
			System.out.print("d의 값을 입력하세요 : ");
			d = sc.nextInt();
		}
		
		while (!want.equals("finish")) {
			System.out.println("당신이 구하고 싶은 것은 무엇입니까?");
			System.out.println("max / min / finish");
			
			want = sc.next();
			
			if (num == 4 && want.equals("max")) {
				System.out.println(a + ", " + b + ", " + c + ", " + d + " 중 가장 큰 값은 " + max4(a, b, c, d));
			} else if (num == 4 && want.equals("min")) {
				System.out.println(a + ", " + b + ", " + c + ", " + d + " 중 가장 작은 값은 " + min4(a, b, c, d));
			} else if (num == 3 && want.equals("max")) {
				System.out.println(a + ", " + b + ", " + c + " 중 가장 큰 값은 " + max3(a, b, c));
			} else if (num == 3 && want.equals("min")) {
				System.out.println(a + ", " + b + ", " + c + " 중 가장 큰 값은 " + min3(a, b, c));
			} else if (want.equals("finish")) {
				System.out.println("고생하셨어요. 다음에 만나요!");
			} else {
				System.out.println("이상한데요...? 다시 해봅시다.");
			}
		}
		
		sc.close();
	
	}

	// 세 값의 최댓값을 구하는 max3 메서드를 작성
	static int max3 (int a, int b, int c) {
		int max = a;
		if (max < b) max = b;
		if (max < c) max = c;
		return max;
	}
	
	// 네 값의 최댓값을 구하는 max4 메서드를 작성 
	static int max4 (int a, int b, int c, int d) {
		int max = a;
		if (max < b) max = b;
		if (max < c) max = c;
		if (max < d) max = d;
		return max;
	}
	
	// 세 값의 최솟값을 구하는 min3 메서드를 작성 
	static int min3 (int a, int b, int c) {
		int min = a;
		if (min > b) min = b;
		if (min > c) min = c;
		return min;
	}
	
	// 네 값의 최솟값을 구하는 min4 메서드를 작성 
	static int min4 (int a, int b, int c, int d) {
		int min = a;
		if (min > b) min = b;
		if (min > c) min = c;
		if (min > d) min = d;
		return min;
	}
}

/*
 * 연습문제
 * 
 * Q1. 네 값의 최댓값을 구하는 max4 메서드를 작성하세요.
 *     static int max4(int a, int b, int c, int d)
 *     작성한 메서드를 테스트하기 위해 main 메서드를 포함한 프로그램을 작성해야 합니다. 이후의 문제도 마찬가지입니다.
 *     
 * Q2. 세 값의 최솟값을 구하는 min3 메서드를 작성하세요.
 *     static int min3(int a, int b, int c)
 *     
 * Q3. 네 값의 최솟값을 구하는 min4 메서드를 작성하세요.
 * 	   static int min4(int a, int b, int c, int d)
 */
