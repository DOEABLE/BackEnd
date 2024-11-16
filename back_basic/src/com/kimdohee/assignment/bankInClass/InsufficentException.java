package com.kimdohee.assignment.bankInClass;

public class InsufficentException extends AccountException {
		public InsufficentException() {
				super("잔액이 부족합니다!");
		}
}
