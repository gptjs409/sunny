package chap02;

import java.util.Scanner;

// �迭 ����� �ִ��� ��Ÿ���ϴ�(���� �Է¹���)
public class MaxOfArray {
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("Ű�� �ִ��� ���մϴ�.");
		System.out.print("��� �� : ");
		int num = stdIn.nextInt();  // �迭�� ��Ҽ��� �Է�
		
		int[] height = new int[num]; // ��Ҽ��� num�� �迭 ����
		
		for (int i = 0; i < num; i++) {
			System.out.print("heigh[" + i + "] : ");
			height[i] = stdIn.nextInt();
		}
		
		stdIn.close();
		
		System.out.println("�ִ��� " + maxOf(height) + "�Դϴ�.");
	}
	/*
	 * Ű�� �ִ��� ���մϴ�.
	 * ��� �� : 4
	 * heigh[0] : 1
	 * heigh[1] : 5
	 * heigh[2] : 6
	 * heigh[3] : 5
	 * �ִ��� 6�Դϴ�.
	 */

	// �迭 a�� �ִ��� ���Ͽ� ��ȯ�մϴ�.
	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}
}
