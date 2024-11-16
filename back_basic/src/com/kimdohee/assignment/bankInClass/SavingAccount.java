package com.kimdohee.assignment.bankInClass;

public class SavingAccount extends Account {
		private static final int[] MONS = {1, 3, 6, 9, 12, 24, 36, 48};
		private static final String[] RATES = {"3.0", "3.35", "3.4", "3.35", "3.35", "2.9", "2.9", "2.9"
		};//금리를 String으로 받겠다.

		public SavingAccount(String accountName, int accountId, String accountOwner, int balance) {
				super(accountName, accountId, accountOwner, balance);
		}

		private double findRate(int month) {
				for (int i = RATES.length - 1; i >= 0; i--) {
						if (month >= MONS[i]) {
								return Double.parseDouble(RATES[i]);
						}
				}
				return 0;
		}

		public void deposit() {
				try {
						int month = scanInt("예치 개월 수를 입력하세요", 2);
						if (month < 1) {
								throw new AccountException("최소 1개월 이상 입력하세요!");
						}
						double rate = findRate(month);
						String yn = scan("%d개월(적용금리 %.1f%%로 만기 처리하시겠어요?(y/n)".formatted(month, rate), 3);
						if (yn.equalsIgnoreCase("Y")) {
								balance = balance + balance * (long)(rate / 100);
								Transferable transfer = (Account account) -> {
										account.deposit(balance, true);
										balance = 0;
								};
								super.selectTransferTargetAccount(transfer);
								accounts.remove(this);
								System.out.println("정기예금 통장이 해지되었습니다.");
								startMenu();
						} else {
								choiceMenu();
						}
				} catch (Exception e) {
						System.out.println(e.getMessage());
						deposit();
				}
		}

		public void choiceMenu() {
				super.choiceMenu("계좌가 만기되었습니다.", "만기처리");
		}

		protected void printInfo() {
				super.printInfo("예치금");
				for (int i = 0; i < RATES.length; i++) {
						System.out.printf("\t%d개월 이상: %s%%\n", MONS[i], RATES[i]);
				}
		}
}
