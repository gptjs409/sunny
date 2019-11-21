package chap02;

// ���� �伭�� �ڷ����� int���� �迭 (���� ��Ҽ��� 5 : new�� ���� ��ü�� ����)
public class IntArray {

	public static void main(String[] args) {
		int[] a = new int[5]; // �迭�� ����
		
		a[1] = 37;        // a[1]�� 47�� ����
		a[2] = 51;        // a[2]�� 51�� ����
		a[4] = a[1] * 2;  // a[4]�� a[1] * 2, �� 74�� ����
		
		for (int i = 0; i < a.length; i++) { // �� ����� ���� ��Ÿ��
			System.out.println("a[" + i + "] = " + a[i]);
		}
	}

	/* 
	 * a[0] = 0
	 * a[1] = 37
	 * a[2] = 51
	 * a[3] = 0
	 * a[4] = 74
	 */
}
