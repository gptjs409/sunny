package chap02;

import java.util.Scanner;

public class CardConvRev {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int no;                    // 변환할 정수
		int cd;                    // 기수
		int dno;                   // 변환 후 자릿 수
		String retry;              // 다시 한 번?
		char[] cno = new char[32]; // 변환 후 각 자릿수를 넣어두는 문자 배열
		
		System.out.println("10진수를 기수변환 합니다.");
		do {
			do {
				System.out.print("변환하는 음이 아닌 정수 : ");
				no = stdIn.nextInt();
			} while (no < 0);
			
			do {
				System.out.print("어떤 진수로 변환할까요? (2~36) : ");
				cd = stdIn.nextInt();
			} while (cd < 2 || cd > 36);
			
			dno = cardConvR(no, cd, cno); // no를 cd진수로 변환하여 cno에 담음
			
			System.out.print(cd + "진수로는 ");
			// 윗 자리부터 차례로 나타냄 = 즉 뒤에서부터 읽어옴
			for (int i = dno - 1; i >= 0; i--) {
				System.out.print(cno[i]);
			}
			System.out.println("입니다.");
			
			System.out.println("한 번 더 할까요? (할거면 y) : ");
			retry = stdIn.next();
		} while (retry.equals("y"));
		
		stdIn.close();
	}
	
	// 정수값 x를 r진수로 변환하여 배열 d에 아랫자리부터 넣어두고 자릿수를 반환합니다.
	static int cardConvR(int x, int r, char[] d) {
		int digits = 0; // 변환 후의 자릿수
		
		// dchar.charAt(0 .. 35)로 접근 가능
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			// 후위형 증가 연산자, 식 완료 후에 digits + 1
			d[digits++] = dchar.charAt(x % r); // r로 나눈 나머지 저장
			x /= r;
		} while (x != 0);
		
		return digits;
	}

}

/*
 * 기수 : 수를 나타내는데 기초가 되는 수, 10진법에서는 0~9, 일, 이, 삼 ...
 * 서수 : 사물의 순서를 나타내는 수 - 첫째, 둘째, 셋째, ...
 * 
 * 수 / 진수 했을 때 나오는 나머지들이 순차적으로 아랫자리 => 윗자리
 */