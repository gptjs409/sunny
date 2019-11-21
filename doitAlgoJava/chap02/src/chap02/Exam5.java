package chap02;

import java.util.Scanner;

public class Exam5 {

	// �� ���� �� ��
	static int[][] mdays = {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // ���
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // ����
	};

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int retry;			// �ٽ� �� ��?
		
		System.out.println("�� �� ����ϼ��� ���մϴ�.");
		
		do {
			System.out.print("�� : ");
			int year = stdIn.nextInt();  // ��
			System.out.print("�� : ");
			int month = stdIn.nextInt(); // ��
			System.out.print("�� : ");
			int day = stdIn.nextInt();   // ��
			
			System.out.printf("�� �� %d��°�Դϴ�.\n", dayOfYear(year, month, day));
			
			System.out.print("�� �� �� �Ϸ��� 1�� �������� : ");
			retry = stdIn.nextInt();
		} while (retry == 1);
		
		stdIn.close();
	}
	
	// ���� year���� �����ΰ�? (���� : 1 / ��� : 0)
	// ���� : 4�� ���������� ��, 100���� �������µ� 400���� �������� �ʴ� �ش� ���(100, 200, 300, 500)
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 100 || year % 400 == 0) ? 1 : 0;
	}
	
//	// ���� y�� m�� d���� �� �� ��� �� ���� ����
//	static int dayOfYear(int y, int m, int d) {
//		int tmp = m;
//		while (tmp > 1) {
//			d += mdays[isLeap(y)][m]; //isLeap(y) : �����̸� 1 / ����̸� 0
//			tmp--;
//		}
//		return d;
//	}
	
}

/*
 * ��������
 * 
 * Q8. DayOfYear Ŭ������ �޼��� dayOfYear�� ���� i�� days ���� �����ϼ���. while���� ����ϼ���.
 * 
 * Q9. y�� m�� d���� �� �� ���� �� ��(12�� 31���̸� 0, 12�� 30���̸� 1)�� ���ϴ� �Ʒ� �޼��带 �ۼ��ϼ���.
 *     static int leftDayOfYear(int y, int m, int d);
 */