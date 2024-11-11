package com.kimdohee.assignment.bank;

import java.util.Scanner;

public abstract class Account {
		protected static Scanner scan = new Scanner(System.in);
		protected final long accountNo;
		protected final String accountOwner;
		protected final String accountName;
		protected long balance;

		public Account(long accountNo, String accountOwner, String accountName) {
				this((long)(Math.random() * 10000000), accountName, accountOwner, (long)0);
		}

		public Account(long accountNo, String accountOwner, String accountName, long balance) {
				this.accountNo = accountNo;
				this.accountOwner = accountOwner;
				this.accountName = accountName;
				this.balance = balance;
		}

		public static void showSelectAccounts(oop.Account[] accounts, oop.Account me) {
				StringBuilder msg = new StringBuilder();
				for (oop.Account acc : accounts) {
						long no = acc.getAccountNo();
						if (me != null && no == me.getAccountNo()) {
								continue;
						}
						String owner = acc.getAccountOwner();
						if (msg.isEmpty()) {
								msg.append("(%d:%s".formatted(no, owner));
						} else {
								msg.append(",%d:%s".formatted(no, owner));
						}
				}
				msg.append("): ");
		}

		public String getAccountInfo() {
				return "계좌번호: " + accountNo + ", 예금주: " + accountOwner + ", 계좌명: " + accountName + ", 잔액: " + String.format(
						"%,d", balance) + "원";
		}

		public void checkBalance() {//잔액이 거래하기에 유효한지 잔액확인
				if (balance > 0) {
						System.out.printf("%s님의 잔액은 %d원 입니다.\n\n", this.accountOwner, this.balance);
				} else {
						System.out.println("잔액을 확인하세요!");
				}
		}

		public int getAmount(String prompt) {
				System.out.print(prompt);
				return scan.nextInt();
		}

		public void deposit(double amount) throws AmountMinusException {//입금내역 매서드
				if (amount <= 0) {
						throw new AmountMinusException("입금 금액은 0보다 커야 합니다.");
				}
				this.balance += amount;
				System.out.printf("%s님의 %s통장에 %.0f원이 입금되었습니다.\n", this.accountOwner, this.accountName, amount);
				checkBalance();
		}

		public abstract void withdraw(double amount) throws AccountException;

		public abstract void transfer(Account toAccount, double amount) throws AccountException; // 이체 메서드도 각 계좌에서 오버라이딩

}
