package com.kimdohee.assignment.bank;

import java.util.Scanner;
import java.util.Stack;

public class Main {
		private static Stack<String> navigationStack = new Stack<>(); // 뒤로가기 스택

		public static void main(String[] args) throws AccountException {
				Scanner scanner = new Scanner(System.in);

				// 자유입출금 통장 생성 및 테스트
				//@formatter:off
				FreeDepositAccount 	freeAcc 	= new FreeDepositAccount	(1, "홍길동");
				FixedDepositAccount fixedAcc 	= new FixedDepositAccount	(2, "홍길동", 12, 2.0); // 만기 12개월, 금리 2%
				MinusAccount 				minusAcc	= new MinusAccount				(3, "홍길동");
				//@formatter:on

				Account[] accounts = {freeAcc, fixedAcc, minusAcc};
				for (Account account : accounts) {
						System.out.println(account.getAccountInfo());
				}

				while (true) {
						System.out.print("\n>> 통장을 선택하세요(1: 자유입출금, 2: 정기예금, 3: 마이너스): ");
						int choice = scanner.nextInt();

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

						while (true) {
								System.out.println("\n원하시는 업무는? (+:입금, -:출금, T:이체, I:계좌정보)");
								char operation = scanner.next().charAt(0);

								if (operation == '+') { // 입금
										System.out.print("입금 하실 금액은? ");
										double depositAmount = scanner.nextDouble();
										selectedAcc.deposit(depositAmount);
								} else if (operation == '-') { // 출금
										try {
												System.out.print("출금 하실 금액은? ");
												double withdrawAmount = scanner.nextDouble();
												selectedAcc.withdraw(withdrawAmount);
										} catch (NotEnoughException e) {
												goBack();
										} catch (AmountMinusException e) {
												System.out.println(e.getMessage());//출금액은 0보다 커야합니다.
										} catch (AccountException e) {
												System.out.println("알 수 없는 오류: 영업점에 문의하세요." + e.getMessage());
										}
								} else if (operation == 'T') { // 이체
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
										System.out.println("송금액을 입력하세요: ");
										double amount = scanner.nextDouble();
										selectedAcc.transfer(targetAcc, amount);
								} else if (operation == 'I') { // 정보 조회
										System.out.println(selectedAcc.getAccountInfo());
								} else {
										break; // 뒤로가기 또는 종료 조건
								}

								//freeAcc.deposit(100000);
								//freeAcc.withdraw(50000);

								// 마이너스 통장 생성 및 테스//트

								//minusAcc.withdraw(200000); // 마이너스 한도 없음

								// 정기예금 생성 및 테스트 (출금 불가)

								try {
										fixedAcc.withdraw(1000000); // 정기예금에서 출금을 시도하면 오류 발생
								} catch (UnsupportedOperationException e) {
										System.out.println(e.getMessage());
								}

								try {
										fixedAcc.transfer(minusAcc, 1000000); // 정기예금에서 이체를 시도하면 오류 발생
								} catch (UnsupportedOperationException e) {
										System.out.println(e.getMessage());
								}

								// 자유입출금 통장에서 마이너스 통장으로 이체 테스트
								freeAcc.transfer(minusAcc, 30000);

								System.out.println(freeAcc.getAccountInfo());
								System.out.println(minusAcc.getAccountInfo());
						}
				}
		}

		// 뒤로가기 기능 구현
		private static void goBack() {
				if (!navigationStack.isEmpty()) {
						String previousPage = navigationStack.pop(); // 스택에서 이전 상태 꺼내기
						System.out.println(previousPage + " 화면으로 돌아갑니다.");
				} else {
						System.out.println("더 이상 뒤로 갈 수 없습니다.");
				}
		}

		// 현재 위치를 스택에 저장하는 메서드
		private static void navigateTo(String pageName) {
				navigationStack.push(pageName);
		}
}
