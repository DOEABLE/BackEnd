package oop;

import java.util.Scanner;

public class Account {

		private int accountNo;
		private String name;
		private double balance;

		////alt + insert -> constructor
		public Account(int accountNo, String name, double balance) {
				this.accountNo = accountNo;
				this.name = name;
				this.balance = balance;
		}

		public static void main(String[] args) {
				Scanner scan = new Scanner(System.in);

				//계좌 정보 입력
				System.out.print("계좌번호 입력:");
				int accountNo = scan.nextInt();
				scan.nextLine();
				System.out.print("이름:");
				String name = scan.nextLine();
				System.out.print("잔액:");
				double balance = scan.nextDouble();

		}

		public void checkbalance() {
				if (balance <= 0) {
						System.out.println("잔액을 확인하세요.");
				} else {
						System.out.println("잔액:" + balance);
				}
		}

		public void deposit(double amount) {//입금내역 매서드
				if (amount > 0) {
						balance += amount;
						System.out.println(amount + "원이 입금되었습니다.");
						this.checkbalance();
				} else {
						System.out.println("입금액은 0보다 커야합니다.");
				}

		}

		public void withdraw(double amount) {// 출금매서드
				if (balance >= amount) {
						System.out.println(amount + "원이 출금되었습니다. 잔액: " + balance);
						this.checkbalance();
				} else {
						System.out.println("잔액을 확인하세요.");
				}
		}

		public void display() {
				String output = """
						------------------------
						계좌번호: %d
						예금주: %s
						잔액: %f원
						------------------------
												
						""".formatted(this.accountNo, this.name, this.balance);

				final int hyphenCnt = 15;
				System.out.println("-".repeat(hyphenCnt));
				System.out.println(name + "님" + "계좌번호:" + accountNo + "의 잔액은" + balance + "입니다.");
				System.out.println(output);
		}
}
