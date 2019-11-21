package chap02;

import java.util.Scanner;

public class Exam3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Ctrl + Shift + o = �ڵ� import
		
		System.out.print("�迭�� ũ�⸦ ���غ����� : ");
		int num = sc.nextInt();
		
		int a[] = new int[num];
		int b[] = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("b[" + i + "] = ");
			b[i] = sc.nextInt();
		}
		sc.close();
		
		abprint(a, b);
		
		System.out.println("�迭 b�� �迭 a�� �����ϴ� �޼��� copy ����");
		copy(a, b);
		abprint(a, b);
		
		System.out.println("�迭 b�� �迭 a�� �������� �����ϴ� �޼��� rcopy ����");
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
		System.out.print("�迭 a�� ");
		for (int i : a) {
			System.out.print(i + " ");
		}
		
		System.out.print("\n�迭 b�� ");
		for (int i : b) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}

}

/*
 * ��������
 * 
 * Q4. �迭 b�� ��� ��Ҹ� �迭 a�� �����ϴ� �޼��� copy�� �ۼ��ϼ���.
 * static void copy(int[] a, int[] b)
 * 
 * Q5. �迭 b�� ��� ��Ҹ� �迭 a�� �������� �����ϴ� �޼��� rcopy�� �ۼ��ϼ���.
 * static void rcopy(int[] a, int[] b)
 */