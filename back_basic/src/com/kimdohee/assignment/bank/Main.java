package com.kimdohee.assignment.bank;

import oop.Account;

import java.util.Stack;

public class Main {
    private static Stack<String> navigationStack = new Stack<>(); // 뒤로가기 스택

    public static void main(String[] args) throws AccountException {

        Account[] accounts = {
                new Account(12345, "코난", 10000),
                new Account(54323, "미란", 20000),
                new Account(4234 - 222, "장미", 30000),
                new Account(accountNo, accountOwner, balance)
        };
        // 자유입출금 통장 생성 및 테스트
        FreeDepositAccount freeAcc = new FreeDepositAccount(1, "홍길동");

        freeAcc.deposit(100000);
        freeAcc.withdraw(50000);

        // 마이너스 통장 생성 및 테스트
        MinusAccount minusAcc = new MinusAccount(3, "홍길동");

        minusAcc.withdraw(200000); // 마이너스 한도 없음

        // 정기예금 생성 및 테스트 (출금 불가)
        FixedDepositAccount fixedAcc = new FixedDepositAccount(2, "홍길동", 12, 2.0); // 만기 12개월, 금리 2%

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
