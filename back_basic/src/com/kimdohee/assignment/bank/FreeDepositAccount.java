package com.kimdohee.assignment.bank;

import java.util.Scanner;

/**
 * 자유입출금 통장
 */
public class FreeDepositAccount extends Account {
		Scanner scanner = new Scanner(System.in);

		public FreeDepositAccount(long accountNo, String accountOwner) {
				super(accountNo, accountOwner, "자유입출금", 0);
		}

		@Override
		public void withdraw(long amount) throws AccountException {//항상 거래후엔 checkBalance
				if (amount < 0) {
						throw new AmountMinusException("출금액은 0보다 커야합니다!");
				}
				if (this.balance >= amount) {
						this.balance -= amount;
				} else {
						throw new NotEnoughException(this.balance);
				}
		}

		@Override
		public void transfer(Account toAccount, long amount) throws AccountException {

				if (amount <= 0) {
						throw new AmountMinusException("이체 금액은 0보다 커야 합니다!");
				}
				if (this.balance >= amount) {
						withdraw(amount);
						toAccount.deposit(amount);
						System.out.printf("[이체완료] %s님의 %s계좌에서 %s님의 %s계좌로 %d원이 송금되었습니다.\n", this.accountOwner, this.accountName,
								toAccount.accountOwner, toAccount.accountName, amount);
						getAccountInfo();
				} else {
						throw new NotEnoughException(this.balance);
				}

		}

}
