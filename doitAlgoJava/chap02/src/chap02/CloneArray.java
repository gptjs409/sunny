package chap02;

// �迭�� �����մϴ�.
// ���� : �迭�̸�.clone()
public class CloneArray {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		int[] b = a.clone();       // b�� a�� qhrwpfmf ckawh
		
		b[3] = 0; // �� ��ҿ��� 0�� ����
		
		System.out.print("a = ");
		for (int i : a)
			System.out.print(" " + i);
		
		System.out.print("\nb = ");
		for (int i : b)
			System.out.print(" " + i);
	}

	/* 
	 * a =  1 2 3 4 5
	 * b =  1 2 3 0 5
	 */
}
