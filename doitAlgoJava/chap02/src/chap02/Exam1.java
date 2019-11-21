package chap02;

import java.util.Random;

public class Exam1 {

	public static void main(String[] args) {
		
		// Random ��� ����
		Random rand = new Random();
		
		System.out.println("Ű�� �ִ��� ���մϴ�.");
		System.out.print("��� �� : ");
		int num = rand.nextInt(100); // �迭�� ��Ҽ�
		
		int[] height = new int[num]; // ��Ҽ��� num�� �迭 ����
		
		System.out.println("Ű ���� �Ʒ��� �����ϴ�.");
		for (int i = 0; i < num; i++) {
			// rand.nextInt(n) �� ������ �����ϴ� �޼���, 0 ~ n - 1������ ������ ��ȯ
			height[i] = 100 + rand.nextInt(90); // ����� ���� ������ ����
			System.out.println("height[" + i + "] : " + height[i]);
		}
		
		System.out.println("�ִ��� " + maxOf(height) + "�Դϴ�.");
	}

	// �迭 a�� �ִ��� ���Ͽ� ��ȯ
	static int maxOf(int [] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];
		return max;
	}

}

/*
 * ��������
 * 
 * Q1. Ű �Ӹ� �ƴ϶� ��� ���� ������ �����ϵ��� MaxOfArrayRand Class�� �����Ͽ� ���α׷��� �ۼ��ϼ���.
 */