package chap02;

// ���� �ڷ����� int���� �迭(���� ��Ҽ��� 5 : �迭 �ʱ��ڿ� ���� ����)
public class IntArryInit {

	public static void main(String[] args) {
		
		int[] a = {1, 2, 3, 4, 5}; // �迭 �ʱ��ڿ� ���� ����
		
		for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i]);
		}
	}

	/*
	 * a[0] = 1
	 * a[1] = 2
	 * a[2] = 3
	 * a[3] = 4
	 * a[4] = 5
	 */
}
