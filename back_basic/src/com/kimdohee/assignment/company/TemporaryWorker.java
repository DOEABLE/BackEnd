package com.kimdohee.assignment.company;

public class TemporaryWorker extends Worker {
    private int payPerHour;
    private int workTime;

    public TemporaryWorker(String name, int payPerHour, int workTime) {
        super(name);
        this.payPerHour = payPerHour;
        this.workTime = workTime;
    }

    @Override
    public int getPay() {
        return payPerHour * workTime;
    }

    @Override
    public void showSalaryInfo(String name) {
        System.out.println("임시직 " + name + "의 급여: " + String.format("%,d", getPay()) + "원");
    }
}

