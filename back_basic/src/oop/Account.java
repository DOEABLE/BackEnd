package oop;

import java.util.Scanner;

/**
 * 1. account class를 만든다
 * 2. class 내에 주어진 멤버변수를 만든다.(private으로)
 * 3. 생성자에 객체 생성시 멤버변수(계좌정보는 변할 수 없는 정보입니다.)를 받고(this.으로 현재 객체의 매개변수임을 구분)
 * 4. main함수 내에 계좌번호, 이름, 초기 잔액 입력받고 .
 * last: 입금(금액 입력 받기), 출금, display 순으로 출력.
 */
public class Account {
    private static Scanner scan = new Scanner(System.in);
    private final long accountNo;
    private final String accountOwner;
    private double balance;

    //[계좌 생성]예금주 명만 입력받아서 무작위의 계좌번호와 초기잔액 0을 설정한다.
    public Account(long accountNo, String accountOwner) {
        this((long) (Math.random() * 1000000000), accountOwner, 0);
    }

    public Account(long accountNo, String accountOwner, double balance) {
        this.accountNo = accountNo;
        this.accountOwner = accountOwner;
        this.balance = balance;
    }


		//new[s]
		public static void showSelectAccounts(Account[] accounts) {
				showSelectAccounts(accounts, null);
		}

		public static void showSelectAccounts(Account[] accounts, Account me) {
				StringBuilder msg = new StringBuilder();
				for (Account acc : accounts) {
						long no = acc.getAccountNo();
						if (me != null && no == me.getAccountNo()) {
								continue;
						}
						String owner = acc.getAccountOwner();
						if (msg.isEmpty()) {
								msg.append("(%d:%s".formatted(no, owner));
						} else {
								msg.append(",%d:%s".formatted(no, owner));
						}
				}
				msg.append("): ");
		}

		//new[e]
		//[S]
		// Account account = new Account(accountNo, accountOwner, balance);
		//
		// //거래유형(입금:+, 출금:-) 선택 마지막에 거래결과
		// while (true) {
		// 		System.out.print("어떤 거래를 하시겠어요?(입금:+, 출금:-): ");
		// 		char transferType = scan.next().charAt(0);
		//
		// 		if (transferType == '+') {
		// 				account.deposit();
		// 				break;
		// 		} else if (transferType == '-') {
		// 				account.withdraw();
		// 				break;
		// 		} else {
		// 				System.out.println("+와, -중 입력해주세요.(입금:+, 출금:-)");
		// 		}
		// }
		// account.display();
		//[E]
		public static void main(String[] args) {
				//계좌 정보 입력 및 인스턴스생성
				System.out.print("계좌번호 입력: ");
				long accountNo = scan.nextLong();
				scan.nextLine();
				System.out.print("예금주 명: ");
				String accountOwner = scan.nextLine();
				System.out.print("잔액: ");
				double balance = scan.nextDouble();

				System.out.println("송금테스트========================");
				Account[] accounts = {
						new Account(12345, "코난", 10000),
						new Account(54323, "미란", 20000),
						new Account(4234 - 222, "장미", 30000),
						new Account(accountNo, accountOwner, balance)
				};

				// 각 계좌에 일련번호 부여 후 출력
				for (int i = 0; i < accounts.length; i++) {
						System.out.printf("%d번 계좌:\n", i + 1);
						accounts[i].display();
				}
				// for (Account account : accounts) {
				// 		account.display();
				// }

				System.out.print("송금계좌: ");
				int senderIndex = scan.nextInt() - 1;
				System.out.print("수신계좌: ");
				int recipientIndex = scan.nextInt() - 1;

				//선택한 인덱스를 통해 송금자, 수신자 설정
				if (senderIndex >= 0 && senderIndex < accounts.length && recipientIndex >= 0
						&& recipientIndex < accounts.length) {
						Account sender = accounts[senderIndex];
						Account recipient = accounts[recipientIndex];
						try {
								sender.transfer(recipient);//송금시도
						} catch (AccountException e) {
								System.out.println("송금 실패: " + e.getMessage());
						}
				} else {
						System.out.println("잘못된 계좌 번호를 입력했습니다.");//[todo] 예외처리
				}
				//각 계좌에 대한 입,출,송금 실행
				System.out.println("\n[입금테스트] 입금액을 입력하세요: ");
				accounts[0].deposit(scan.nextInt());

        System.out.println("\n[출금테스트]");
        accounts[1].withdraw();

        System.out.println("\n[송금테스트]");
        accounts[3].transfer(accounts[1]);

        System.out.println("\n최종 계좌 정보");
        for (Account account : accounts) {
            account.display();
        }

    }


		public long getAccountNo() {
				return accountNo;
		}

		public String getAccountOwner() {
				return accountOwner;
		}

		public double getBalance() {
				return balance;
		}

		public void checkBalance() {//잔액이 거래하기에 유효한지 잔액확인
				if (balance > 0) {
						System.out.printf("%s님의 잔액은 %.1f원 입니다.\n", this.accountOwner, this.balance);
				} else {
						System.out.println("잔액을 확인하세요!");
				}
		}
>>>>>>> Stashed changes

    public void deposit(int amount) {//입금내역 매서드
        //todo (거래금액 분리)
        //System.out.printf("입금액을 입력하세요: ");
        //int amount = scan.nextInt();
        //int amount = getAmount("입금액을 입력하세요: ");
        this.balance += amount;
        System.out.printf("%d원이 입금되었습니다.\n", amount);
        checkBalance();

    }

		public void withdraw() {//항상 거래후엔 checkBalance
				int amount = getAmount("출금액을 입력하세요: ");
				if (this.balance >= amount) {
						this.balance -= amount;
						System.out.printf("%d원이 출금되었습니다. \n잔액:%.0f원\n", amount, this.balance);
						this.checkBalance();
				} else {
						throw new AccountException("출금 금액이 부족합니다. 현재 잔액: " + this.balance + "원");
				}

    }

    private int getAmount(String prompt) {
        System.out.print(prompt);
        return scan.nextInt();
    }
	
		public void transfer(Account recipient) {
				int amount = getAmount("송금액을 입력하시오: ");
				if (this.balance >= amount) {
						this.balance -= amount;
						System.out.printf("%s님의 계좌에서 %s님에게 %d원이 송금되었습니다.\n", this.accountOwner, recipient.accountOwner, amount);
						checkBalance();
						recipient.deposit(amount);
				} else {
						throw new AccountException("금액이 부족하여 송금실패. 현재 잔액: " + this.balance + "원");
				}
		}

    //display output 변수 출력 -> text blocks이용해 멀티라인 만들기.
    public void display() {
        String output = """
                -----------------------------
                계좌번호:%d
                예금주:%s
                잔액: %.1f
                -----------------------------
                """.formatted(this.accountNo, this.accountOwner, this.balance);
        //        final int dashCnt = 20;
        //        System.out.println("-".repeat(dashCnt));
        System.out.println(output);
    }
}
