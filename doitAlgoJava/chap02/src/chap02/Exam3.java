package chap02;

import java.util.Scanner;

public class Exam3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Ctrl + Shift + o = 자동 import
		
		System.out.print("배열의 크기를 정해보세요 : ");
		int num = sc.nextInt();
		
		int a[] = new int[num];
		int b[] = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("b[" + i + "] = ");
			b[i] = sc.nextInt();
		}
		sc.close();
		
		abprint(a, b);
		
		System.out.println("배열 b를 배열 a에 복사하는 메서드 copy 실행");
		copy(a, b);
		abprint(a, b);
		
		System.out.println("배열 b를 배열 a에 역순으로 복사하는 메서드 rcopy 실행");
		rcopy(a, b);
		abprint(a, b);
	}
	
	static void copy(int[] a, int[] b) {
		for(int i = 0; i < a.length; i++)
			a[i] = b[i];
	}
	
	static void rcopy(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++)
			a[i] = b[a.length - 1 - i];
	}
	
	static void abprint(int[] a, int[] b) {
		System.out.print("배열 a는 ");
		for (int i : a) {
			System.out.print(i + " ");
		}
		
		System.out.print("\n배열 b는 ");
		for (int i : b) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}

}

/*
 * 연습문제
 * 
 * Q4. 배열 b의 모든 요소를 배열 a에 복사하는 메서드 copy를 작성하세요.
 * static void copy(int[] a, int[] b)
 * 
 * Q5. 배열 b의 모든 요소를 배열 a에 역순으로 복사하는 메서드 rcopy를 작성하세요.
 * static void rcopy(int[] a, int[] b)
 */