package com.kimdohee.assignment.bank;

import java.util.Scanner;

public class FixedDepositAccount extends Account {
		//정기예금(출금 및 이체 불가)
		private int maturityMonths; // 만기 개월 수
		private int currentMonths;  // 현재 경과 개월 수
		private double interestRate;// 적용 금리
		private boolean isMatured;  // 만기 여부

		public FixedDepositAccount(long accountNo, String accountOwner, int maturityMonths, double interestRate) {
				super(accountNo, accountOwner, "정기예금", 50000000); // 기본 예치 금액 5천만 원
				this.maturityMonths = maturityMonths;
				this.interestRate = interestRate;
				this.currentMonths = 0;
				this.isMatured = true;
				this.interestRate = 0.0;//초기금리
		}

		// 만기 처리 메서드
		public void processMaturity(Account[] accounts, char operation) throws AccountException {
				Scanner scanner = new Scanner(System.in);
				//[s]
				while (true) {
						//.char operation = scanner.next().charAt(0);

						if (operation == '+') { // 만기처리
								System.out.print("예치 개월 수를 입력하세요 (1 ~ 60개월): ");
								int months = scanner.nextInt();

								// 적용 금리 설정 (예시로 단순화)
								if (months >= 1 && months < 3) {
										this.interestRate = 3.0;
								} else if (months >= 3 && months < 6) {
										this.interestRate = 3.35;
								} else if (months >= 6 && months < 12) {
										this.interestRate = 3.4;
								} else if (months >= 12) {
										this.interestRate = 2.9;
								}

								System.out.printf("%d개월(적용금리 %.2f%%)로 만기 처리하시겠어요? (y/n): ", months, this.interestRate);
								char confirm = scanner.next().charAt(0);

								if (Character.toUpperCase(confirm) == 'Y') {
										this.isMatured = true; // 만기 처리 완료
										long amount = (long)(this.balance + (this.balance * this.interestRate / 100));

										System.out.println("어디로 보낼까요?");
										Account.showSelectAccounts(accounts, this);
										int selectedAccNo = this.scan.nextInt();
										Account toAccount = accounts[selectedAccNo - 1];
										System.out.printf("%s님의 %s통장에 %,d원이 입금되었습니다.\n", String.format(this.accountOwner),
												toAccount.accountName, amount);
										transfer(toAccount, amount);
										System.out.printf("정기 예금 통장은 해지되었습니다. 감사합니다.");
										break;
								} else {
								}
						} else if (operation == '-') {
								throw new FailTransactionException("출금");
						} else if (Character.toUpperCase(operation) == 'T') { // 이체
								throw new FailTransactionException("이체");
						} else if (Character.toUpperCase(operation) == 'I') { // 정보 조회
								System.out.println(getAccountInfo());
						} else {
								break; // 뒤로가기 또는 종료 조건
						}
				}

		}

		@Override
		public void withdraw(long amount) throws AccountException {
				if (amount < 0) {
						throw new AmountMinusException("출금액은 0보다 커야합니다!");
				}
				if (this.balance >= amount) {
						this.balance -= amount;
						this.checkBalance();
				} else {
						throw new NotEnoughException(this.balance);
				}
		}

		@Override
		public void transfer(Account toAccount, long amount) throws AccountException {
				// 받는사람의 계좌가 마이너스 통장이라면 잔액검사 안하고 거래 하도록 수정.
				if (this.balance >= amount || toAccount.isOverdraftAccount()) {
						System.out.printf("[이체완료] %s님의 %s계좌에서 %s님의 %s계좌로 %,d원이 송금되었습니다.\n",
								this.accountOwner, this.accountName,
								toAccount.accountOwner, toAccount.accountName, amount);
						getAccountInfo();
				} else {
						throw new NotEnoughException(this.balance);
				}
		}

}
