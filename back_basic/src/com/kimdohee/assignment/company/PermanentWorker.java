package com.kimdohee.assignment.company;

public class PermanentWorker extends Worker {
    private int salary;

    public PermanentWorker(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public int getPay() {
        return salary;
    }

    @Override
    public void showSalaryInfo(String name) {
        System.out.println("정규직 " + name + "의 급여: " + String.format("%,d", getPay()) + "원");
    }
}

