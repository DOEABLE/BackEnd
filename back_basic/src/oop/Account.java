package oop;

import java.util.Scanner;

/**
 * 1. account class를 만든다
 * 2. class 내에 주어진 멤버변수를 만든다.(private으로)
 * 3. 생성자에 객체 생성시 멤버변수(계좌정보는 변할 수 없는 정보입니다.)를 받고(this.으로 현재 객체의 매개변수임을 구분)
 * 4. main함수 내에 입금을 할지 출금을 할지 선택.
 * last: 입금(금액 입력 받기), 출금, display 순으로 출력.
 */
public class Account {
    private static Scanner scan = new Scanner(System.in);
    private final double accountNo;
    private final String accountOwner;
    private double balance;

    ////alt + insert -> constructor
    public Account(double accountNo, String accountOwner, double balance) {
        this.accountNo = accountNo; //accountNo 초기화
        this.accountOwner = accountOwner;
        this.balance = balance;
    }

    public static void main(String[] args) {
        //계좌 정보 입력
        System.out.print("계좌번호 입력:");
        double accountNo = scan.nextDouble();
        scan.nextLine();
        System.out.print("이름:");
        String accountOwner = scan.nextLine();
        System.out.print("초기 잔액:");
        double balance = scan.nextDouble();
        Account account = new Account(accountNo, accountOwner, balance);

        System.out.println("어떤 거래를 원하세요?(입금:+, 출금:-): ");
        char transactionType = scan.next().charAt(0);
        switch (transactionType) {
            case '+'://account.deposit매서드 호출
                account.deposit();
                break;
            case '-'://account.withdraw매서드 호출
                account.withdraw(3000);
                break;
        }
//        account.deposit();
//        account.withdraw(3000);
        account.display();
    }

    public void checkBalance() {//잔액이 거래하기에 유효한지
        if (balance <= 0) {
            System.out.println("잔액을 확인하세요.");
        } else {
            System.out.printf("%S님의 잔액: %.1f원 입니다.\n", this.accountOwner, this.balance);
        }
    }

    public void deposit() {//입금내역 매서드
        System.out.println("입금금액을 입력하세요: ");
        double amount = scan.nextDouble();
        if (amount > 0) {
            this.balance += amount;
            System.out.printf("%.1f원이 입금되었습니다.", amount);
            this.checkBalance();
        } else {
            System.out.println("입금액은 0보다 커야합니다.");
        }

    }

    public void withdraw(double amount) {// 출금매서드
        if (balance >= amount) {
            this.balance -= amount;
            System.out.println(amount + "원이 출금되었습니다. 잔액: " + this.balance);
            this.checkBalance();
        } else {
            System.out.println("출금 금액 부족");
            return;
        }
    }

    public void display() {
        String output = """
                ------------------------
                계좌번호: %.0f
                예금주: %s
                잔액: %.1f원
                ------------------------
                						
                """.formatted(this.accountNo, this.accountOwner, this.balance);
        final int hyphenCnt = 15;
        System.out.println("-".repeat(hyphenCnt));
        System.out.printf("%s님의 계좌 %.0f의 잔액은 %.1f입니다.", this.accountOwner, this.accountNo, this.balance);
        System.out.println(output);
    }
}
