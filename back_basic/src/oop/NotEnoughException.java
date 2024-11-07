package oop;

public class NotEnoughException extends AccountException {
    public NotEnoughException() {
        super("잔액이 부족합니다!");
    }

    public NotEnoughException(String message) {
        super(message + "부족!");
        System.out.println("NotEnoughException = " + message);
    }
}
