package chap02;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no = 0, cd = 0, dno = 0;
		String retry = "";
		char[] cno = new char[32];
		
		System.out.println("10������ �����ȯ �Ұſ���");
		
		do {
			do {
				System.out.print("��ȯ�Ϸ��� ���� �ƴ� ���� : ");
				no = sc.nextInt();
			} while (no < 0);
			
			do {
				System.out.println("��ȯ�Ϸ��� ���� (2 ~ 36) : ");
				cd = sc.nextInt();
			} while (cd < 2 || cd > 36);
			
			dno = cardConv(no, cd, cno);
			
			System.out.print(cd + "�����δ� ? ");
			for (int i = 0; i < dno; i++)
				System.out.print(cno[i]);
			System.out.println(" �Դϴ�.");
			
			System.out.println("\n------------------------------");
			System.out.println("������ ����Ʈ�غ�����.");
			process(no, cd, cno);
			System.out.println("------------------------------\n");
			
			System.out.println("�� �� �� �Ͻ÷��� y�� �����ּ��� : ");
			retry = sc.next();
		} while (retry.equals("y"));
		
		sc.close();
	}

	static int cardConv(int x, int r, char[] d) {
		int digits = 0, tmp = x;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		while (!(tmp == 0)) {
			tmp /= r;
			digits++;
		}
		
		for (int i = digits -1 ; i >= 0; i--) {
			d[i] = dchar.charAt(x % r);
			x /= r;
		}
		
		return digits;
	}
	
	static void process(int x, int r, char[] d) {
		int digits = 0, tmp = x;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		int cx = 0;   // ����� �ڸ���
		int cr = 0;   // ������ �ڸ���
		int ctmp = 0; // �ڸ����� ���ϱ� ���� �ӽð�
		
		// ����� �ڸ����� ���غ���.
		ctmp = x;
		while (ctmp != 0) {
			ctmp /= 10;
			cx++;
		}
		
		// ������ �ڸ����� ���غ���.
		ctmp = r;
		while (ctmp != 0) {
			ctmp /= 10;
			cr++;
		}
		
		while (!(tmp == 0)) {
			tmp /= r;
			digits++;
		}
		
		// 1��
		System.out.println(r + "|     " + x);
		
		// 2��
		for (int i = 0; i < cr; i++)
			System.out.print("-");
		System.out.print("+-----");
		for (int i = 0; i < cx; i++)
			System.out.print("-");
		System.out.println();
		
		for (int i = digits -1 ; i >= 0; i--) {

			d[i] = dchar.charAt(x % r);
			x /= r;
			
			// ���� ����� ���
			int ncx = 0;
			ctmp = x;
			while (ctmp != 0) {
				ctmp /= 10;
				ncx++;
			}
			
			if (x == 0) {
				ncx = 1;
				// 1�� - ���� ���
				System.out.print("       ");
			} else {
			    // 1�� - ���� ���
			    System.out.print(r + "|     ");
			}
			// 1�� - blank ��� [���� ����� - ���� ����� ��ŭ)
			for (int j = 0; j < cx - ncx; j++)
				System.out.print(" ");
			
			// 1�� - ����ܿ��� ���
			System.out.println(x + "  �� " + d[i]);
			
			if (x == 0) break;
			
			// 2�� - "-" ���
			for (int j = 0; j < cr; j++)
				System.out.print("-");

			// 2�� - "+-----" ���
			System.out.print("+-----");

			for (int j = 0; j < cx + ncx; j++)
				System.out.print("-");
			
			System.out.println();				
		}

		System.out.print(r + "������ ");
		for (int i = 0; i < digits; i++) {
			System.out.print(d[i]);
		}
		System.out.println(" �Դϴ�.");
	}
}

/*
 * ��������
 * 
 * Q6. �迭�� ���ʿ� �Ʒ��ڸ��� �ƴ� ���ڸ��� �־�δ� �޼��带 �ۼ��ϼ���.
 *     static int cardConv(int x, int r, char[] d)
 *     
 * Q7. �Ʒ���ó�� ��� ��ȯ ������ �ڼ��� ��Ÿ���� ���α׷��� �ۼ��ϼ���.
 *     2|     59
 *     -+-------
 *     2|     29  �� 1
 *     -+---------
 *     2|     14  �� 1
 *     -+---------
 *     2|      7  �� 0
 *     -+--------
 *     2|      3  �� 1
 *     -+--------
 *     2|      1  �� 1
 *     -+--------
 *             0  �� 1
 *     2������ 111011 �Դϴ�.
 */