package trythis;

import java.util.Scanner;

public class MyScan {
		public static void main(String[] args) {
				//Scanner scan = scanUserInfo();
				scanTemp();

		}

		private static void scanTemp() {
				Scanner scan = new Scanner(System.in);
				System.out.println("점수 :");
				int score = scan.nextInt();

				int grade = score / 10;
				switch (grade) {
						case 10:
						case 9:
								System.out.println("A: GOAT");
								break;
						case 8:
								System.out.println("B: 잘했어요");
								break;
						case 7:
								System.out.println("C: 나쁘진 않군");
								break;
						case 6:
								System.out.println("D: 좀 더 노력해");
								break;
						case 5, 4, 3, 2, 1, 0:
								System.out.println("F: 다음학기에 또 봐요~");
								break;
						default:
								System.out.println("점수는 0부터 100사이여야 합니다.");
								break;

				}

		}
}
