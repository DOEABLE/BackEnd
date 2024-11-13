package com.kimdohee.assignment.bank;

public class AccountException extends Exception {
		public AccountException(String message) {
				super(message);
				System.out.println(message);
		}
}
