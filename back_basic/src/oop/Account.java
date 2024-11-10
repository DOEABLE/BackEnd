package oop;


import com.kimdohee.assignment.bank.AccountException;
import com.kimdohee.assignment.bank.AmountMinusException;
import com.kimdohee.assignment.bank.NotEnoughException;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 1. account class를 만든다
 * 2. class 내에 주어진 멤버변수를 만든다.(private으로)
 * 3. 생성자에 객체 생성시 멤버변수(계좌정보는 변할 수 없는 정보입니다.)를 받고(this.으로 현재 객체의 매개변수임을 구분)
 * 4. main함수 내에 계좌번호, 이름, 초기 잔액 입력받고 .
 * last: 입금(금액 입력 받기), 출금, display 순으로 출력.
 * todo 계좌번호의 무작위 계좌생성-> 고유한 계좌번호인지 보장하는 매커니즘 ->계좌번호의 유효성 검사
 */

public class Account {
    private static Scanner scan = new Scanner(System.in);

    private final long accountNo;
    private final String accountOwner;

    private double balance;


    public Account(long accountNo, String accountOwner) {
        this((long) (Math.random() * 1000000000), accountOwner, 0);
    }

    public Account(long accountNo, String accountOwner, double balance) {
        this.accountNo = accountNo;
        this.accountOwner = accountOwner;
        this.balance = balance;
    }

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

    public static void main(String[] args) {
        //계좌 정보 입력 및 인스턴스생성
        System.out.print("계좌번호 입력: ");
        long accountNo = scan.nextLong();
        scan.nextLine();
        System.out.print("예금주 명: ");
        String accountOwner = scan.nextLine();
        System.out.print("잔액: ");
        double balance = scan.nextDouble();

        System.out.println("============계좌 내역============");
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
        while (true) {
            System.out.print("어떤 거래를 하시겠어요?\n(입금:+, 출금:-, 송금:$): ");
            char transferType = scan.next().charAt(0);

            try {
                if (transferType == '+') {
                    System.out.printf("\n입금계좌를 선택하세요.\n(1~%d번까지의 계좌가 존재합니다): ", accounts.length);
                    int depositIndex = scan.nextInt() - 1;
                    accounts[depositIndex].deposit(scan.nextInt());
                    break;
                } else if (transferType == '-') {
                    System.out.printf("\n출금계좌를 선택하세요.\n(1~%d번까지의 계좌가 존재합니다): ", accounts.length);
                    int withdrawIndex = scan.nextInt() - 1;
                    accounts[withdrawIndex].withdraw();
                    break;
                } else if (transferType == '$') {
                    try {
                        System.out.printf("송금계좌를 선택하세요.\n(1~%d번까지의 계좌가 존재합니다): ", accounts.length);
                        int senderIndex = scan.nextInt() - 1;

                        if (senderIndex < 0 || senderIndex >= accounts.length) {
                            throw new AmountMinusException("잘못된 송금계좌 번호를 입력했습니다.");
                        }

                        System.out.print("수신계좌: ");
                        int recipientIndex = scan.nextInt() - 1;

                        if (recipientIndex < 0 || recipientIndex >= accounts.length) {
                            throw new AmountMinusException("잘못된 수신계좌 번호를 입력했습니다.");
                        }

                        Account sender = accounts[senderIndex];
                        Account recipient = accounts[recipientIndex];

                        try {
                            sender.transfer(recipient);//송금계좌.transfer(수신계좌)
                        } catch (AccountException e) {
                            System.out.println("송금 실패: " + e.getMessage());
                        }
                        break;//없으면 while문 무한으로 돈다.
                    } catch (AmountMinusException e) {
                        System.out.println("오류 발생: " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("오류 발생: 올바른 숫자를 입력해주세요.");
                        scan.nextLine(); // 입력 버퍼 비우기
                    }
                } else {
                    System.out.println("+와, -중 입력해주세요.(입금:+, 출금:-,송금:$)");
                }
            } catch (NotEnoughException | AmountMinusException e) {
                System.out.println(e.getMessage());
            } catch (AccountException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("\n최종 계좌 정보");
        for (Account account : accounts) {
            account.display();
        }


    }

    public void action() {
        if (isNotValidScan()) {
            return;
        }
    }

    public void login() {
        this.login(null);
    }

    public void login(Scanner scan) {
        if (this.scan == null) {
            if (scan != null) {
                this.scan = scan;
            } else {
                this.scan = new Scanner(System.in);
            }
        }
        this.display();
    }

    private boolean isNotValidScan() {
        if (this.scan == null) {
            System.out.println("먼저 로그인하세요!");
            return true;
        }
        return false;
    }

    public void logout() {
        if (this.scan != null) {
            this.scan.close();
        }
        this.display();
    }

    public long getAccountNo() {
        return accountNo;
    }

    //[계좌 생성]예금주 명만 입력받아서 무작위의 계좌번호와 초기잔액 0을 설정한다.

    public String getAccountOwner() {
        return accountOwner;
    }

    public double getBalance() {
        return balance;
    }

    public void checkBalance() {//잔액이 거래하기에 유효한지 잔액확인
        if (balance > 0) {
            System.out.printf("%s님의 잔액은 %.1f원 입니다.\n\n", this.accountOwner, this.balance);
        } else {
            System.out.println("잔액을 확인하세요!");
        }
    }

    public void deposit(int amount) throws AmountMinusException {//입금내역 매서드
        if (amount < 0) {
            throw new AmountMinusException("Need plus number!!");
        }
        this.balance += amount;
        System.out.printf("%s님의 계좌로 %d원이 입금되었습니다.\n", this.accountOwner, amount);
        checkBalance();
    }

    public void withdraw() throws AccountException {//항상 거래후엔 checkBalance
        int amount = getAmount("출금액을 입력하세요: ");
        if (amount < 0) {
            throw new AmountMinusException("출금액은 0보다 커야합니다!");
        }
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.printf("%d원이 출금되었습니다. \n잔액:%.0f원\n", amount, this.balance);
            this.checkBalance();
        } else {
            throw new NotEnoughException("출금 잔액");
        }

    }

    private int getAmount(String prompt) {
        System.out.print(prompt);
        return scan.nextInt();
    }

    //todo transfer try-catch문으로 바꾸고 main 간소화
    public void transfer(Account recipient) throws NotEnoughException, AmountMinusException {
        int amount = getAmount("송금액을 입력하시오: ");
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.printf("%s님의 계좌에서 %s님에게 %d원이 송금되었습니다.\n", this.accountOwner, recipient.accountOwner, amount);
            checkBalance();
            recipient.deposit(amount);
        } else {
            //System.out.printf("금액이 부족하여 송금실패. 현재 잔액: " + this.balance + "원");
            throw new NotEnoughException("출금계좌 잔액");
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
