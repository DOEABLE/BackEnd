package com.kimdohee.assignment.bank;

public class FixedDepositAccount extends Account {
    //정기예금(출금 및 이체 불가)
    private int maturityMonths; // 만기 개월 수
    private int currentMonths; // 현재 경과 개월 수
    private double interestRate; // 금리

    public FixedDepositAccount(long accountNo, String accountOwner, int maturityMonths, double interestRate) {
        super(accountNo, "정기예금", accountOwner, 50000000); // 기본 예치 금액 5천만 원
        this.maturityMonths = maturityMonths;
        this.interestRate = interestRate;
        this.currentMonths = 0;
    }

    public void addMonth() {
        currentMonths++;
        System.out.println("현재 경과 개월 수: " + currentMonths);
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("정기예금 계좌에서는 출금을 할 수 없습니다.");//[todo] 내 exception 만들기.(설계서 참조)
    }

    @Override
    public void transfer(Account toAccount, double amount) {
        throw new UnsupportedOperationException("정기예금 계좌에서는 이체를 할 수 없습니다.");
    }
}
