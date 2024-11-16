package com.kimdohee.assignment.bankInClass;

public class TransferNotSupportedException extends AccountException {
		public TransferNotSupportedException() {
				super("이체할 수 없는 통장입니다!");
		}
}
