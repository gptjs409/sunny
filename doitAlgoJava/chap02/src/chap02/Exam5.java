package chap02;

import java.util.Scanner;

public class Exam5 {

	// 각 달의 일 수
	static int[][] mdays = {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 평년
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // 윤년
	};

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int retry;			// 다시 한 번?
		
		System.out.println("그 해 경과일수를 구합니다.");
		
		do {
			System.out.print("년 : ");
			int year = stdIn.nextInt();  // 년
			System.out.print("월 : ");
			int month = stdIn.nextInt(); // 월
			System.out.print("일 : ");
			int day = stdIn.nextInt();   // 일
			
			System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, day));
			
			System.out.print("한 번 더 하려면 1을 누르세요 : ");
			retry = stdIn.nextInt();
		} while (retry == 1);
		
		stdIn.close();
	}
	
	// 서기 year년은 윤년인가? (윤년 : 1 / 평년 : 0)
	// 윤년 : 4로 나뉘어지는 해, 100으로 나눠지는데 400으로 나눠지지 않는 해는 평년(100, 200, 300, 500)
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 100 || year % 400 == 0) ? 1 : 0;
	}
	
//	// 서기 y년 m월 d일의 그 해 경과 일 수를 구함
//	static int dayOfYear(int y, int m, int d) {
//		int tmp = m;
//		while (tmp > 1) {
//			d += mdays[isLeap(y)][m]; //isLeap(y) : 윤년이면 1 / 평년이면 0
//			tmp--;
//		}
//		return d;
//	}
	
}

/*
 * 연습문제
 * 
 * Q8. DayOfYear 클래스의 메서드 dayOfYear를 변수 i와 days 없이 구현하세요. while문을 사용하세요.
 * 
 * Q9. y년 m월 d일의 그 해 남은 일 수(12월 31일이면 0, 12월 30일이면 1)을 구하는 아래 메서드를 작성하세요.
 *     static int leftDayOfYear(int y, int m, int d);
 */