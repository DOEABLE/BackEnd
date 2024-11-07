package trythis;

import java.io.InputStream;
import java.util.Scanner;

//todo exam
public class MyScanner {
		private final Scanner scanner;

		public MyScanner() {
				this(System.in);
		}

		public MyScanner(InputStream inputStreams) {
				this.scanner = new Scanner(inputStreams);//todo System.in이 뭔데?
		}

		public static void main(String[] args) {
				MyScanner scanner1 = new MyScanner();

				scanner1.<Integer>next("xxx");
		}

		//TODO
		public <T> T next(String message) {
				System.out.print("점수를 입력하세요(-1: 종료)");
				return (T)scanner.next();
		}
		//T는 new할 수 없다. T instanceof 도 안됌.
		//TODO

		// public int nextInt() {
		// 		while (!scanner.hasNextInt()) {
		// 				System.out.println("정수가 아닙니다: ");
		// 				scanner.nextInt();
		// 		}
		// 		return scanner.nextInt();
		// }
		public int nextInt(String message) {
				System.out.print(message);
				return this.scanner.nextInt();
		}

		public double nextDouble() {
				while (!scanner.hasNextDouble()) {
						System.out.println("올바른 실수를 입력하세요: ");
						scanner.nextDouble();
				}
				return scanner.nextDouble();
		}

		public String nextString() {
				return scanner.next();
		}

		public void nextClose() {
				this.scanner.close();
		}
}
