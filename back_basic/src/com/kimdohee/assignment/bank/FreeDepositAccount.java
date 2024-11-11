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
		public void withdraw(double amount) throws AccountException {//항상 거래후엔 checkBalance
				//amount = getAmount("출금 하실 금액은?");
				if (amount < 0) {
						throw new AmountMinusException("출금액은 0보다 커야합니다!");
				}
				if (this.balance >= amount) {
						this.balance -= amount;
						System.out.printf("%d원이 출금되었습니다. \n잔액:%.0f원\n", amount, this.balance);
						this.checkBalance();
				} else {
						throw new NotEnoughException(this.balance);
				}
		}

		@Override
		public void transfer(Account toAccount, double amount) throws AccountException {
				amount = getAmount("송금액을 입력하시오: ");
				if (this.balance >= amount) {
						withdraw(amount);
						toAccount.deposit(amount);
						System.out.printf("[이체완료] %s님의 %s계좌에서 %s님의 계좌로 %.0f원이 송금되었습니다.\n", this.accountOwner, this.accountName,
								toAccount.accountOwner, amount);
						checkBalance();
				} else {
						//System.out.printf("금액이 부족하여 송금실패. 현재 잔액: " + this.balance + "원");
						throw new NotEnoughException(this.balance);
				}
		}

}
