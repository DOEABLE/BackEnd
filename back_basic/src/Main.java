public class Main {
		public static void main(String[] args) {//main 메서드
				if (args.length == 2) {//두개의 인자가 전달 되었는가?
						int i = Integer.parseInt((args[1]));//두번째 인자를 정수로 변환해 반복횟수 설정
						nPrintln(args[0], i);//0번쨰 인자와 함께 nPrintln메서드 호출
				} else {                            //인자가 두개가 아닐 경우.
						System.out.println("입력 정보 오류!");
				}
		}

		public static void nPrintln(String s, int n) {
				for (int i = 0; i < n; i++) {
						System.out.println(s);
				}
		}
}
