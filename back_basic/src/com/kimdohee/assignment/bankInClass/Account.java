package com.kimdohee.assignment.bankInClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Account {
		public static final List<Account> accounts = new ArrayList<>();

		private static final Scanner scanner = new Scanner(System.in);
		protected final long accountNo;
		protected final String accountOwner;
		protected final String accountName;
		protected long balance;

		public Account(String accountName, long accountNo, String accountOwner, long balance) {
				this.accountNo = accountNo;
				this.accountOwner = accountOwner;
				this.accountName = accountName;
				this.balance = balance;
				accounts.add(this);
		}

		public long getAccountNo() {
				return accountNo;
		}

		public void setTransferTargetAccount(Account account) {
				try {
						int amount = scanInt("%s에 보낼 금액은?".formatted(account.accountName), 2);
						this.withdraw(amount);

						account.deposit(amount, false, this);
				} catch (Exception e) {
						throw new RuntimeException(e);
				}
		}

		public void selectTransferTargetAccount() throws Exception {
				selectTransferTargetAccount(null);
		}

		public void selectTransferTargetAccount(Transferable transfer) throws Exception {
				int accId = scanInt("어디로 보낼까요? %s".formatted(exceptMe()), 2);
				Account account = accounts.stream().filter(a -> a.getAccountNo() == accId).findFirst().orElse(null);
		}

		public List<Account> exceptMe() {
				return accounts.stream().filter(a -> !a.equals(this)).toList();
		}

		public void deposit() {//입금내역 매서드
				try {
						int amount = scanInt("입금하실 금액은? ", 2);
						this.deposit(amount, false);
				} catch (Exception e) {
						System.out.println(e.getMessage());
						deposit();
				}
		}

		public void deposit(long amount, boolean isHideMenu) {
				deposit(amount, isHideMenu, this);
		}

		public void deposit(long amount, boolean isHideMenu, Account account) {
				balance += amount;
				System.out.printf("%s통장에 %d원이 입금 되었습니다.%n", account, amount);
				if (!isHideMenu) {
						account.choiceMenu();
				}
		}

		public void withdraw() throws WithdrawNotSupportedException {
				this.withdraw(-1);
		}

		public void withdraw(int amount) throws WithdrawNotSupportedException {
				if (this instanceof Withdrawable) {
						withdraw(amount);
				} else {
						throw new WithdrawNotSupportedException();
				}
		}

		public void transfer() throws TransferNotSupportedException {
				try {
						((Transferable)this).transfer(null);
				} catch (ClassCastException e) {
						throw new TransferNotSupportedException();
				}
		} // 이체 메서드도 각 계좌에서 오버라이딩

		private void setCurrentAccount(Account account) {
				account.printInfo();
		}

		protected void printInfo() {
				//정기예금만 안내가 다름.
				printInfo("잔액");
		}

		protected void printInfo(String balanceMsg) {
				System.out.printf("%s (계좌번호: %s, 잔액:%d, 예금주:%s)%n", accountName, accountNo, balanceMsg, balance, accountOwner);
		}

		@Override
		public int hashCode() {
				return Objects.hashCode(accountNo);
		}

		public void startMenu() {
				String msg = "통장을 선택하세요 %s ".formatted(accounts);
				try {
						int accId = scanInt(msg, 0);
						// accounts.stream().filter(a->a.getAccountId==accId).findFirst().ifPresent(this::setCurrentAccount);
						Account account = accounts.stream().filter(a -> a.getAccountNo() == accId).findFirst().orElse(null);
				} catch (Exception e) {
						System.out.println("계좌번호를 정확히 입력하세요!");
						startMenu();
				}
		}

		public void choiceMenu() {
				this.choiceMenu("원하시는 업무는?", "입금");
		}

		public void choiceMenu(String preMsg, String plusMsg) {
				try {
						String job = scan("%s (+ %s,-: 출금, T:이체, I:정보)".formatted(preMsg, plusMsg), 1);

						switch (job) {
								case "+" -> deposit();
								case "-" -> withdraw();
								case "T", "t" -> transfer();
								case "I", "i" -> printInfo();
								default -> {
										throw new Exception("다시 선택해 주세요!");
								}//재입력 받도록
						}
				} catch (Exception e) {
						System.out.println(e.getMessage());
						choiceMenu(preMsg, plusMsg);
				}
		}

		//오버로딩
		public int scanInt(String msg, int depth) throws Exception {
				return Integer.parseInt(this.scan(msg, depth));
		}

		public String scan(String msg, int depth) throws Exception {
				System.out.println(msg);
				String ret = scanner.nextLine();
				if (ret.equals("0") || ret.isEmpty()) {
						if (depth == 0) {
								System.exit(0);
						} else if (depth == 1) {
								startMenu();
						} else if (depth == 2) {
								choiceMenu();
						} else {
								throw new Exception();
						}
				}
				return ret;
		}

		@Override
		public boolean equals(Object o) {
				if (this == o) {
						return true;
				}
				if (o == null || getClass() != o.getClass()) {
						return false;
				}
				Account account = (Account)o;
				return accountNo == account.getAccountNo();
		}

		@Override
		public String toString() {
				return "%d: %s".formatted(accountNo, accountName);
		}
}
