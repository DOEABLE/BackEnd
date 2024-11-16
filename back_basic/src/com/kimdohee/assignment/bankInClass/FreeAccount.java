package com.kimdohee.assignment.bankInClass;

public class FreeAccount extends Account implements Transferable, Withdrawable {
		protected boolean isUnLimit = false;

		public FreeAccount(String accountName, long accountNo, String accountOwner, long balance) {
				this(accountName, accountNo, accountOwner, balance, false);
		}

		public FreeAccount(String acountName, long accountNo, String accountOwner, long balance, boolean isUnLimit) {
				super(acountName, accountNo, accountOwner, balance);
				this.isUnLimit = isUnLimit;
		}

		@Override
		public void withdraw() {
				this.withdraw(-1);
		}

		@Override
		public void withdraw(int amount) {
				try {
						if (amount == -1) {
								amount = scanInt("출금하실 금액은?", 2);
						}
						if (!isUnLimit && amount > balance) {
								throw new InsufficentException();
						}
						balance -= amount;
						System.out.printf("%s 통장에서 %,d원이 출금되었습니다.%n", accountName, amount);
						System.out.printf("%s 통장의 잔액은 %,d원 입니다.", accountName, balance);

						if (amount == -1) {
								choiceMenu();
						}
				} catch (InterruptedException e) {
						System.out.printf("잔액이 부족합니다!(잔액: %d원)%n", balance);
						withdraw();
				} catch (Exception e) {
						System.out.println(e.getMessage());
						withdraw();
				}
		}

		@Override
		public void transfer(Account account) throws TransferNotSupportedException {
				try {
						super.selectTransferTargetAccount();
				} catch (Exception e) {
						transfer();
				}
		}

		@Override
		public void printInfo() {
				super.printInfo();
				choiceMenu();
		}
}
