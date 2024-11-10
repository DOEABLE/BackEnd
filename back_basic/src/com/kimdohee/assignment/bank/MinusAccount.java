package com.kimdohee.assignment.bank;

public class MinusAccount extends Account {
    public MinusAccount(long accountNo, String accountOwner) {
        super(accountNo, "마이너스", accountOwner, 0);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
    }

    @Override
    public void transfer(Account toAccount, double amount) throws AmountMinusException {
        amount = getAmount("송금액을 입력하시오: ");
        withdraw(amount);
        toAccount.deposit(amount);
        System.out.printf("[이체완료] %s님의 %s계좌에서 %s님의 계좌로 %.0f원이 송금되었습니다.\n", this.accountOwner, this.accountName, toAccount.accountOwner, amount);
        checkBalance();

    }
}
