package oop;

import java.util.Scanner;

/**
 * 1. account class를 만든다
 * 2. class 내에 주어진 멤버변수를 만든다.(private으로)
 * 3. 생성자에 객체 생성시 멤버변수(계좌정보는 변할 수 없는 정보입니다.)를 받고(this.으로 현재 객체의 매개변수임을 구분)
 * 4. main함수 내에 계좌번호, 이름, 초기 잔액 입력받고 .
 * last: 입금(금액 입력 받기), 출금, display 순으로 출력.
 */
public class Account {
    private static Scanner scan = new Scanner(System.in);
    private final double accountNo;
    private final String accountOwner;
    private double balance;
    //alt + insert -> constructor


    public Account(double accountNo, String accountOwner, double balance) {
        this.accountNo = accountNo;
        this.accountOwner = accountOwner;
        this.balance = balance;
    }

    public static void main(String[] args) {
        //계좌 정보 입력 및 인스턴스생성
        System.out.print("계좌번호 입력: ");
        double accountNo = scan.nextDouble();
        scan.nextLine();
        System.out.print("예금주 명: ");
        String accountOwner = scan.nextLine();
        System.out.print("잔액: ");
        double balance = scan.nextDouble();

        Account account = new Account(accountNo, accountOwner, balance);

        //거래유형(입금:+, 출금:-) 선택 마지막에 거래결과
        while (true) {
            System.out.print("어떤 거래를 하시겠어요?(입금:+, 출금:-): ");
            char transferType = scan.next().charAt(0);


            if (transferType == '+') {
                account.deposit();
                break;
            } else if (transferType == '-') {
                account.withdraw();
                break;
            } else {
                System.out.println("+와, -중 입력해주세요.(입금:+, 출금:-)");
                //거래유형이 옳지 않다면 다시 입력받도록 하고싶어.
            }
        }
        account.display();
    }


    public void checkBalance() {//잔액이 거래하기에 유효한지 잔액확인
        if (balance > 0) {
            System.out.printf("%s님의 잔액은 %.1f원 입니다.\n", this.accountOwner, this.balance);
        } else {
            System.out.println("잔액을 확인하세요!");
        }
    }

    public void deposit() {//입금내역 매서드
        //todo (거래금액 분리)
        //System.out.printf("입금액을 입력하세요: ");
        //int amount = scan.nextInt();
        int amount = getAmount("입금액을 입력하세요: ");
        this.balance += amount;
        System.out.printf("%d원이 입금되었습니다.\n", amount);
        checkBalance();

    }

    public void withdraw() {// 1. 출금액 입력받기 출금매서드(잔액보다 출금금액이 크면 출금안돼.) 항상 거래후엔 checkBalance
        int amount = getAmount("출금액을 입력하세요: ");
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.printf("%d원이 출금되었습니다. \n잔액:%.0f원\n", amount, this.balance);
            this.checkBalance();
        } else {
            System.out.printf("출금 금액이 부족합니다.\n 잔액: %.0f원\n", this.balance);
        }

    }

    private int getAmount(String prompt) {
        System.out.print(prompt);
        return scan.nextInt();
    }

    //display output 변수 출력 -> text blocks이용해 멀티라인 만들기.
    public void display() {
        String output = """
                -----------------------------
                계좌번호:%.0f
                예금주:%s
                잔액: %.1f
                -----------------------------
                """.formatted(this.accountNo, this.accountOwner, this.balance);
//        final int dashCnt = 20;
//        System.out.println("-".repeat(dashCnt));
        System.out.println(output);
    }
}
