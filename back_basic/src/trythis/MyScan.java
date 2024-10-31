package trythis;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MyScan {
		public static void main(String[] args) {
				//Scanner scan = scanUserInfo();
				scanTemp();

		}

		private static void scanTemp() {
				final double currTemp = 20;//변하지 않는 수온의 값
				Scanner scan = new Scanner(System.in);
				System.out.println("수심을 입력하시오 :");
				double dept = scan.nextDouble();
				double resultTemp = currTemp - Math.floor((double)dept / 10) * 0.7;
				System.out.println(resultTemp);

		}

		private static Scanner scanUserInfo() {
				Scanner scan = new Scanner(System.in);
				return scan;
		}
}
