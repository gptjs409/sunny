package chap02;

import java.util.Scanner;

// �� �迭�� ������ �Ǵ�
public class ArrayEqual {

	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("a �迭�� ��Ҽ� : ");
		int na = stdIn.nextInt(); // �迭 a�� ��Ҽ�
		int[] a = new int[na];    // ��Ҽ��� na�� �迭
		
		for (int i = 0; i < na; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}
		
		System.out.print("\n�迭 b�� ��Ҽ� : ");
		int nb = stdIn.nextInt(); // �迭 b�� ��Ҽ�
		int[] b = new int[nb];    // ��Ҽ��� nb�� �迭
		
		for (int i = 0; i < nb; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = stdIn.nextInt();
		}
		
		stdIn.close();
		System.out.println("\n�迭 a�� b�� " + (equals(a, b) ? "�����ϴ�" : "���� �ʽ��ϴ�."));
	}
	
	// �� �迭 a, b�� ��� ��Ұ� ������?
	static boolean equals(int[] a, int[] b) {
		
		// �� �迭 a, b�� ��� ��(����) �� > ���� ���� ��� �ٸ� �迭
		if (a.length != b.length)
			return false;
		
		// �� �迭�� ó������ ��ĵ�ϸ鼭 ��Ҹ� �� > ���� ���� ��� �ٸ� �迭
		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i])
				return false;
		
		// ��� ����� ��� ���� �迭
		return true;
	}

}
