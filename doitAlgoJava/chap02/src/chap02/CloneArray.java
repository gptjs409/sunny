package chap02;

// 배열을 복제합니다.
// 복제 : 배열이름.clone()
public class CloneArray {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		int[] b = a.clone();       // b는 a의 qhrwpfmf ckawh
		
		b[3] = 0; // 한 요소에만 0을 대입
		
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
