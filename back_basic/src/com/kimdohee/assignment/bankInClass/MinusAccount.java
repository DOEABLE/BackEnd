package com.kimdohee.assignment.bankInClass;

public class MinusAccount extends FreeAccount {
		public MinusAccount(String accountName, int accountId, String owner, int balance) {
				super(accountName, accountId, owner, balance, true);
		}
}
