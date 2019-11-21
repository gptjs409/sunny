package chap02;

import java.util.Scanner;

public class CardConvRev {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int no;                    // ��ȯ�� ����
		int cd;                    // ���
		int dno;                   // ��ȯ �� �ڸ� ��
		String retry;              // �ٽ� �� ��?
		char[] cno = new char[32]; // ��ȯ �� �� �ڸ����� �־�δ� ���� �迭
		
		System.out.println("10������ �����ȯ �մϴ�.");
		do {
			do {
				System.out.print("��ȯ�ϴ� ���� �ƴ� ���� : ");
				no = stdIn.nextInt();
			} while (no < 0);
			
			do {
				System.out.print("� ������ ��ȯ�ұ��? (2~36) : ");
				cd = stdIn.nextInt();
			} while (cd < 2 || cd > 36);
			
			dno = cardConvR(no, cd, cno); // no�� cd������ ��ȯ�Ͽ� cno�� ����
			
			System.out.print(cd + "�����δ� ");
			// �� �ڸ����� ���ʷ� ��Ÿ�� = �� �ڿ������� �о��
			for (int i = dno - 1; i >= 0; i--) {
				System.out.print(cno[i]);
			}
			System.out.println("�Դϴ�.");
			
			System.out.println("�� �� �� �ұ��? (�ҰŸ� y) : ");
			retry = stdIn.next();
		} while (retry.equals("y"));
		
		stdIn.close();
	}
	
	// ������ x�� r������ ��ȯ�Ͽ� �迭 d�� �Ʒ��ڸ����� �־�ΰ� �ڸ����� ��ȯ�մϴ�.
	static int cardConvR(int x, int r, char[] d) {
		int digits = 0; // ��ȯ ���� �ڸ���
		
		// dchar.charAt(0 .. 35)�� ���� ����
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			// ������ ���� ������, �� �Ϸ� �Ŀ� digits + 1
			d[digits++] = dchar.charAt(x % r); // r�� ���� ������ ����
			x /= r;
		} while (x != 0);
		
		return digits;
	}

}

/*
 * ��� : ���� ��Ÿ���µ� ���ʰ� �Ǵ� ��, 10���������� 0~9, ��, ��, �� ...
 * ���� : �繰�� ������ ��Ÿ���� �� - ù°, ��°, ��°, ...
 * 
 * �� / ���� ���� �� ������ ���������� ���������� �Ʒ��ڸ� => ���ڸ�
 */