package com.kimdohee.assignment.bank;

public class MinusAccount extends Account {
		public MinusAccount(long accountNo, String accountOwner) {
				super(accountNo, accountOwner, "마이너스", 0);
		}

		@Override
		public void withdraw(long amount) {//한도 제한이 없다.
				balance -= amount;
				System.out.printf("%s 통장에서 %,d원이 출금되었습니다.\n", accountName, amount);
				System.out.printf("%s님의 %s통장 잔액은 %,d원 입니다.\n\n", this.accountOwner, this.accountName, this.balance);
		}

		public String getAccountInfo() {
				long displayBalance = balance > 0 ? -balance : Math.abs(balance);
				return accountName + " 통장 (계좌번호: " + accountNo + ", 잔액: " + String.format("%,d", balance) + "원, 예금주: "
						+ accountOwner + ")";
		}

		@Override
		public void transfer(Account toAccount, long amount) throws AmountMinusException {
				amount = getAmount("송금액을 입력하시오: ");
				withdraw(amount);
				toAccount.deposit(amount);
				System.out.printf("[이체완료] %s님의 %s계좌에서 %s님의 계좌로 %.0f원이 송금되었습니다.\n", this.accountOwner, this.accountName,
						toAccount.accountOwner, amount);
				getAccountInfo();

		}
}
