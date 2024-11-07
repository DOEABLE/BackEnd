package trythis;

import oop.AmountMinusException;
import oop.NotEnoughException;

import java.util.Scanner;

public class AccountInClass {
    private final long accountNo;
    private final String name;
    private double balance;
    private Scanner scan;

    public AccountInClass(long accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public AccountInClass(int accountNo, String name) {
        this(accountNo, name, 0);
    }

    public static void showSelectAccounts(AccountInClass[] accounts) {
        showSelectAccounts(accounts, null);
    }

    public static void showSelectAccounts(AccountInClass[] accounts, AccountInClass me) {
        StringBuilder msg = new StringBuilder();
        for (AccountInClass acc : accounts) {
            long no = acc.getAccountNo();
            if (me != null && no == me.getAccountNo()) {
                continue;
            }
            String name = acc.getName();
            if (msg.isEmpty()) {
                msg.append(" (%d:%s".formatted(no, name));
            } else {
                msg.append(", %d:%s".formatted(no, name));
            }
        }
        msg.append("): ");
        System.out.print(msg);
    }

    public long getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    private void deposit() throws AmountMinusException {
        System.out.print("입금할 금액은? ");
        double amt = scan.nextDouble();
        if (amt < 0) {
            throw new AmountMinusException("Need plus number!!");
        }
        this.balance += amt;
        System.out.printf("%.1f원이 입금되었습니다!\n", amt);
        this.checkBalance();
    }

    private void withdraw() throws NotEnoughException {
        System.out.print("출금할 금액은? ");
        double amt = scan.nextDouble();
        if (this.balance < amt) {
            // System.out.println("\n잔액이 부족합니다!!");
            // return;
            throw new NotEnoughException();
        }
        this.balance -= amt;
        System.out.printf("%.1f원이 출금되었습니다!\n", amt);
        this.checkBalance();
    }

    public void checkBalance() {
        System.out.printf("%s님의 잔액은 %.1f원 입니다.\n\n", this.name, this.balance);
    }

    private void display() {
        // String.format()
        String output = """
                ------------------------------
                계좌번호: %d
                예금주: %s
                잔액: %.1f원
                ------------------------------
                """.formatted(this.accountNo, this.name, this.balance);
        final int hyphenCnt = 15;
        System.out.println(output);
    }

    public void transfer(AccountInClass[] accounts) throws NotEnoughException {
        if (this.isNotValidScan()) {
            return;
        }
        System.out.println("누구에게 송금하시겠어요? ");
        AccountInClass.showSelectAccounts(accounts, this);
        int selectedAccNo = this.scan.nextInt();
        AccountInClass toAccount = accounts[selectedAccNo - 1];

        System.out.print("얼마를 송금하시겠어요? ");
        double transAmount = this.transferTo(toAccount, this.scan.nextDouble());

        System.out.printf("transAmount = %,.1f\n", transAmount);

    }

    public double transferTo(AccountInClass another, double amount) throws NotEnoughException {
        System.out.printf("%s이 %s에게 %,.1f원 송금 시도!\n", this.getName(), another.getName(), amount);
        if (this.balance < amount) {
            // System.out.println("잔액이 부족합니다!");
            // return 0;
            throw new NotEnoughException();
        }

        this.balance -= amount;
        another.balance += amount;

        // System.out.println("송금 완료!!");
        System.out.printf("%s이 %s에게 %,.1f원 송금 완료!\n", this.getName(), another.getName(), amount);

        this.checkBalance();
        another.checkBalance();

        return this.balance;
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

        // this.action();
        this.display();
    }

    public void action() {
        if (isNotValidScan()) {
            return;
        }

        while (true) {
            System.out.print("\nCommand(+:입금, -:출금, q:종료) : ");
            String cmd = scan.next();
            scan.skip(".*");

            try {
                switch (cmd) {
                    case "+" -> this.deposit();
                    case "-" -> this.withdraw();
                    case "q" -> {
                        return;
                    }

                    default -> System.out.println("잘 못된 명령입니다!");
                }

            } catch (NotEnoughException | AmountMinusException e) {
                System.out.println("Error:" + e.getMessage());
            }
        }
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

    @Override
    public String toString() {
        return "Account[id=%s, name=%s, balance=%,1f]".formatted(getAccountNo(), getName(), getBalance());
    }

}

class T {
    public static void main(String[] args) throws Exception {
        AccountInClass accConan = new AccountInClass(1, "코난", 100000);
        AccountInClass accRose = new AccountInClass(2, "장미", 100000);
        AccountInClass accMiran = new AccountInClass(3, "미란", 100000);

        AccountInClass[] accounts = new AccountInClass[]{accConan, accRose, accMiran};

        Scanner scan = new Scanner(System.in);
        System.out.println("계좌를 선택하세요:");
        AccountInClass.showSelectAccounts(accounts);
        int selectedAccNo = scan.nextInt();
        AccountInClass workingAccount = accounts[selectedAccNo - 1];
        workingAccount.login(scan);
        workingAccount.transfer(accounts);
        workingAccount.logout();

        // Account acc = new Account(111, "Hong", 10000);
        // acc.login();
        // acc.action();
        // acc.logout();
    }
}
