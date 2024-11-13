package com.kimdohee.assignment.bank;

public class FailTransactionException extends AccountException {
		public FailTransactionException() {
				super("거래 할 수 없는 통장입니다.");
		}

		public FailTransactionException(String message) {
				super(message + "할 수 없는 통장입니다.");
		}

}
