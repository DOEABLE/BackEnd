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

		public static void showSelectAccounts(Account[] accounts, Account me) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < accounts.length; i++) {
						if (accounts[i] != me) { // 송금 계좌는 제외하고 출력
								sb.append(i + 1)
										.append(": ")
										.append(accounts[i].accountOwner)
										.append("님의 ")
										.append(accounts[i].accountName)
										.append("계좌\n");
						}
				}

				System.out.print(sb.toString()); // StringBuilder 내용을 한 번에 출력
		}

		public String getAccountOwner() {
				return accountOwner;
		}

		public String getAccountInfo() {
				if (accountName.equals("정기예금")) {
						return accountName + " 통장 (계좌번호: " + accountNo + ", 예치금: " + String.format("%,d", balance) + "원, 예금주: "
								+ accountOwner + ")";
				}
				return accountName + " 통장 (계좌번호: " + accountNo + ", 잔액: " + String.format("%,d", balance) + "원, 예금주: "
						+ accountOwner + ")";

		}

		public void checkBalance() {//잔액이 거래하기에 유효한지 잔액확인
				if (balance > 0) {
						System.out.printf("%s님의 %s통장 잔액은 %,d원 입니다.\n\n", this.accountOwner, this.accountName, this.balance);
				} else {
						System.out.println("잔액을 확인하세요!");
				}
		}

		public int getAmount(String prompt) {
				System.out.print(prompt);
				return scan.nextInt();
		}

		public void deposit(long amount) throws AmountMinusException {//입금내역 매서드
				if (amount <= 0) {
						throw new AmountMinusException("입금 금액은 0보다 커야 합니다.");
				}
				this.balance += amount;
				System.out.printf("%s님의 %s통장에 %,d원이 입금되었습니다.\n", this.accountOwner, this.accountName, amount);
				checkBalance();
		}

		public abstract void withdraw(long amount) throws AccountException;

		public abstract void transfer(Account toAccount, long amount) throws AccountException; // 이체 메서드도 각 계좌에서 오버라이딩

		public boolean isOverdraftAccount() {
				return "마이너스".equals(this.accountName);
		}

		public boolean isNotValidScan() {
				if (this.scan == null) {
						System.out.println("먼저 로그인하세요!");
						return true;
				}
				return false;
		}

		public long getAccountNo() {
				return accountNo;
		}

		public String getName() {
				return accountName;
		}

}
