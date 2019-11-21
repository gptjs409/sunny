package chap02;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 정해보세요 : ");
		int num = sc.nextInt();
		int[] a = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("a[" + i + "] = ");
			a[i] = sc.nextInt();
		}
		sc.close();
		
		System.out.println("순서를 뒤집어 봅니다.");
		reverse(a);
		
		System.out.println("모든 요소의 합계는 " + sumOf(a) + "입니다.");

	}

	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	static void reverse(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i = 0; i < a.length / 2; i++) {
			System.out.println("a[" + i + "]과(와) a[" + (a.length - i - 1) +"]를 교환합니다.");
			swap(a, i, a.length -i -1);
			for (int j : a) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println("역순 정렬을 마쳤습니다.");
	}
	static int sumOf(int[] a) {
		int sum = 0;
		for (int i : a)
			sum += i;
		return sum;
	}
}

/*
 * 연습문제
 * 
 * Q2. 아래쪽처럼 배열 요소를 역순으로 정렬하는 과정을 하나 하나 나타내는 프로그램을 작성하시오.
 *     5 10 73 2 -5 42
 *     a[0]과(와) a[5]를 교환합니다.
 *     42 10 73 2 -5 5
 *     a[1]과(와) a[4]를 교환합니다.
 *     42 -5 73 2 10 5
 *     a[2]과(와) a[3]를 교환합니다.
 *     42 -5 2 73 10 5
 *     역순 정렬을 마쳤습니다.
 *     
 * Q3. 배열 a의 모든 요소의 합계를 구하여 반환하는 메서드를 작성하시오.
 *     static int sumOf(int[] a)
 *
 */