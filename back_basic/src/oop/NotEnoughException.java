package oop;

public class NotEnoughException extends AccountException {
		public NotEnoughException(String message) {
				super(message + "부족!");

		}
}
