package com.kimdohee.assignment.bankInClass;

public class OneHanaBank {
		//main에서는 제외

		public static void main(String[] args) {
				Account free = new FreeAccount("자유입출금", 1, "홍길동", 0);
				Account saving = new SavingAccount("정기예금", 2, "홍길동", 50000000);
				Account minus = new MinusAccount("마이너스", 3, "홍길동", 0);

				try {
						free.startMenu();
				} catch (Exception e) {
						throw new RuntimeException(e);
				}
		}
}
