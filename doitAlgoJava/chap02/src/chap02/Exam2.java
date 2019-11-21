package chap02;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("�迭�� ũ�⸦ ���غ����� : ");
		int num = sc.nextInt();
		int[] a = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("a[" + i + "] = ");
			a[i] = sc.nextInt();
		}
		sc.close();
		
		System.out.println("������ ������ ���ϴ�.");
		reverse(a);
		
		System.out.println("��� ����� �հ�� " + sumOf(a) + "�Դϴ�.");

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
			System.out.println("a[" + i + "]��(��) a[" + (a.length - i - 1) +"]�� ��ȯ�մϴ�.");
			swap(a, i, a.length -i -1);
			for (int j : a) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println("���� ������ ���ƽ��ϴ�.");
	}
	static int sumOf(int[] a) {
		int sum = 0;
		for (int i : a)
			sum += i;
		return sum;
	}
}

/*
 * ��������
 * 
 * Q2. �Ʒ���ó�� �迭 ��Ҹ� �������� �����ϴ� ������ �ϳ� �ϳ� ��Ÿ���� ���α׷��� �ۼ��Ͻÿ�.
 *     5 10 73 2 -5 42
 *     a[0]��(��) a[5]�� ��ȯ�մϴ�.
 *     42 10 73 2 -5 5
 *     a[1]��(��) a[4]�� ��ȯ�մϴ�.
 *     42 -5 73 2 10 5
 *     a[2]��(��) a[3]�� ��ȯ�մϴ�.
 *     42 -5 2 73 10 5
 *     ���� ������ ���ƽ��ϴ�.
 *     
 * Q3. �迭 a�� ��� ����� �հ踦 ���Ͽ� ��ȯ�ϴ� �޼��带 �ۼ��Ͻÿ�.
 *     static int sumOf(int[] a)
 *
 */