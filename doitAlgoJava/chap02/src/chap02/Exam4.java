package chap02;

import java.util.Scanner;

public class Exam4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no = 0, cd = 0, dno = 0;
		String retry = "";
		char[] cno = new char[32];
		
		System.out.println("10진수를 기수변환 할거에요");
		
		do {
			do {
				System.out.print("변환하려는 음이 아닌 정수 : ");
				no = sc.nextInt();
			} while (no < 0);
			
			do {
				System.out.println("변환하려는 진수 (2 ~ 36) : ");
				cd = sc.nextInt();
			} while (cd < 2 || cd > 36);
			
			dno = cardConv(no, cd, cno);
			
			System.out.print(cd + "진수로는 ? ");
			for (int i = 0; i < dno; i++)
				System.out.print(cno[i]);
			System.out.println(" 입니다.");
			
			System.out.println("\n------------------------------");
			System.out.println("계산식을 프린트해볼께요.");
			process(no, cd, cno);
			System.out.println("------------------------------\n");
			
			System.out.println("한 번 더 하시려면 y를 눌러주세요 : ");
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
		
		int cx = 0;   // 기수의 자리수
		int cr = 0;   // 진법의 자리수
		int ctmp = 0; // 자리수를 구하기 위한 임시값
		
		// 기수의 자리수를 구해보자.
		ctmp = x;
		while (ctmp != 0) {
			ctmp /= 10;
			cx++;
		}
		
		// 진법의 자리수를 구해보자.
		ctmp = r;
		while (ctmp != 0) {
			ctmp /= 10;
			cr++;
		}
		
		while (!(tmp == 0)) {
			tmp /= r;
			digits++;
		}
		
		// 1줄
		System.out.println(r + "|     " + x);
		
		// 2줄
		for (int i = 0; i < cr; i++)
			System.out.print("-");
		System.out.print("+-----");
		for (int i = 0; i < cx; i++)
			System.out.print("-");
		System.out.println();
		
		for (int i = digits -1 ; i >= 0; i--) {

			d[i] = dchar.charAt(x % r);
			x /= r;
			
			// 현재 기수값 계산
			int ncx = 0;
			ctmp = x;
			while (ctmp != 0) {
				ctmp /= 10;
				ncx++;
			}
			
			if (x == 0) {
				ncx = 1;
				// 1줄 - 진법 출력
				System.out.print("       ");
			} else {
			    // 1줄 - 진법 출력
			    System.out.print(r + "|     ");
			}
			// 1줄 - blank 출력 [원래 기수값 - 현재 기수값 만큼)
			for (int j = 0; j < cx - ncx; j++)
				System.out.print(" ");
			
			// 1줄 - 기수잔여값 출력
			System.out.println(x + "  … " + d[i]);
			
			if (x == 0) break;
			
			// 2줄 - "-" 출력
			for (int j = 0; j < cr; j++)
				System.out.print("-");

			// 2줄 - "+-----" 출력
			System.out.print("+-----");

			for (int j = 0; j < cx + ncx; j++)
				System.out.print("-");
			
			System.out.println();				
		}

		System.out.print(r + "진수로 ");
		for (int i = 0; i < digits; i++) {
			System.out.print(d[i]);
		}
		System.out.println(" 입니다.");
	}
}

/*
 * 연습문제
 * 
 * Q6. 배열의 앞쪽에 아랫자리가 아닌 윗자리를 넣어두는 메서드를 작성하세요.
 *     static int cardConv(int x, int r, char[] d)
 *     
 * Q7. 아래쪽처럼 기수 변환 과정을 자세히 나타내는 프로그램을 작성하세요.
 *     2|     59
 *     -+-------
 *     2|     29  … 1
 *     -+---------
 *     2|     14  … 1
 *     -+---------
 *     2|      7  … 0
 *     -+--------
 *     2|      3  … 1
 *     -+--------
 *     2|      1  … 1
 *     -+--------
 *             0  … 1
 *     2진수로 111011 입니다.
 */