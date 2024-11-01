import java.util.Scanner;

public class Main {
    //두 개의 인자를 받아 첫번째 인자를 지정한 횟수만큼 출력.
    //1. 문자열과 반복횟수(int)를 입력받는다.
    //2. i에 입력받은 반복횟수를 넣는다.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("출력할 문자열을 입력하세요: ");
        String printText = scan.nextLine();
        System.out.print("문자열을 몇 번 입력할까요?: ");
        int printCount = scan.nextInt();

        int i = 0;
        try {
            i = printCount;
        } catch (NumberFormatException e) {
            System.out.println("??");
        }
        nPrintln(printText, i);
    }

    //문자열과 횟수를 입력받아 문자열을 횟수만큼 출력해주는 함수.
    public static void nPrintln(String s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(s);
        }
    }
}
