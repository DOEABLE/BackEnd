package com.kimdohee.assignment.bank;

import java.util.Scanner;
import java.util.Stack;

public class Main {
		private static Stack<String> navigationStack = new Stack<>(); // 뒤로가기 스택

		// 이전 단계로 돌아갈지 검사하는 메서드
		static boolean isBackOrEmpty(String input) {
				return input.equals("0") || input.isEmpty();
		}

<<<<<<< Updated upstream
		public static void main(String[] args) throws AccountException {
				Scanner scanner = new Scanner(System.in);
=======
        Account[] accounts = {
                new Account(12345, "코난", 10000),
                new Account(54323, "미란", 20000),
                new Account(4234 - 222, "장미", 30000),
                // new Account(accountNo, accountOwner, balance)
        };
        // 자유입출금 통장 생성 및 테스트
        FreeDepositAccount freeAcc = new FreeDepositAccount(1, "홍길동");
>>>>>>> Stashed changes

				// 자유입출금 통장 생성 및 테스트
				FreeDepositAccount freeAcc = new FreeDepositAccount(1, "홍길동");
				FixedDepositAccount fixedAcc = new FixedDepositAccount(2, "홍길동", 12, 2.0); // 만기 12개월, 금리 2%
				MinusAccount minusAcc = new MinusAccount(3, "홍길동");

				Account[] accounts = new Account[] {freeAcc, fixedAcc, minusAcc};
				for (Account account : accounts) {
						System.out.println(account.getAccountInfo());
				}

				while (true) {
						System.out.print("\n>> 통장을 선택하세요(1: 자유입출금, 2: 정기예금, 3: 마이너스): ");
						String input = scanner.nextLine().trim();
						if (input.isEmpty()) {
								System.out.println("금일 OneHanaBank는 영업을 종료합니다. 감사합니다.");
								break;
						} else if (isBackOrEmpty(input)) {
								continue;
						}

						int choice;
						try {
								choice = Integer.parseInt(input);
						} catch (NumberFormatException e) {
								continue;
						}

						Account selectedAcc;
						switch (choice) {
								case 1:
										selectedAcc = freeAcc;
										break;
								case 2:
										selectedAcc = fixedAcc;
										break;
								case 3:
										selectedAcc = minusAcc;
										break;
								default:
										System.out.println("잘못된 선택입니다.");
										continue;
						}
						System.out.println(selectedAcc.getAccountInfo());

						// 여기에서 원하시는 업무를 한 번만 출력하도록 수정
						boolean operationExit = false;
						while (!operationExit) {
								if (selectedAcc == fixedAcc) {
										System.out.println("\n정기 예금이 만기되었습니다. (+:만기처리, -:출금, T:이체, I:계좌정보)");
								} else {
										System.out.println("\n원하시는 업무는? (+:입금, -:출금, T:이체, I:계좌정보)");
								}

								String operationInput = scanner.nextLine().trim();

								if (!operationInput.isEmpty()) {
										char operation = operationInput.charAt(0);
										if (operation == '+') { // 입금
												if (selectedAcc == fixedAcc) {
														fixedAcc.processMaturity(accounts, operation);
														break;
												} else {
														System.out.print("입금 하실 금액은? ");
														long depositAmount = scanner.nextLong();
														selectedAcc.deposit(depositAmount);
														scanner.nextLine();
												}
										} else if (operation == '-') {
												while (true) {
														if (selectedAcc == fixedAcc) {
																try {
																		fixedAcc.processMaturity(accounts, operation);
																} catch (FailTransactionException e) {
																		break;
																}
																break;
														} else {
																try {
																		System.out.print("출금 하실 금액은? ");
																		String withdrawInput = scanner.next().trim();
																		if (isBackOrEmpty(withdrawInput)) {
																				break;
																		}
																		long withdrawAmount = Long.parseLong(withdrawInput);
																		selectedAcc.withdraw(withdrawAmount);
																} catch (NotEnoughException e) {
																		e.getMessage();
																		break;
																}
																break;
														}
												}
										} else if (Character.toUpperCase(operation) == 'T') {
												if (selectedAcc == fixedAcc) {
														try {
																fixedAcc.processMaturity(accounts, operation);
														} catch (FailTransactionException e) {
																continue;
														}
														break;
												} else {
														System.out.print("어디로 보낼까요? (2: 정기예금, 3: 마이너스): ");
														int targetChoice = scanner.nextInt();

														Account targetAcc;

														switch (targetChoice) {
																case 2:
																		targetAcc = fixedAcc;
																		break;
																case 3:
																		targetAcc = minusAcc;
																		break;
																default:
																		System.out.println("잘못된 선택입니다.");
																		continue;
														}

														while (true) {
																try {
																		System.out.printf("%s 통장에 보낼 금액은?  ", targetAcc.accountName);
																		long transferAmount = scanner.nextLong();
																		selectedAcc.transfer(targetAcc, transferAmount);
																		break;
																} catch (NotEnoughException e) {
																		e.getMessage();
																}
														}
												}
										} else if (Character.toUpperCase(operation) == 'I') { // 정보 조회
												System.out.println(selectedAcc.getAccountInfo());
										} else {
												operationExit = true; // 종료 조건
										}
								}
						}
				}
		}
}
