package com.kimdohee.assignment.bank;

public class NotEnoughException extends AccountException {
		private double currentBalance;

		public NotEnoughException() {
				super("잔액이 부족합니다!");
		}

		public NotEnoughException(double currentBalance) {
				super("잔액이 부족합니다! (잔액: " + String.format("%,.0f", currentBalance) + "원)");
				this.currentBalance = currentBalance;
		}

		public double getCurrentBalance() {
				return currentBalance;
		}
}
