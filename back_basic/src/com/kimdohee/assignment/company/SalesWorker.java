package com.kimdohee.assignment.company;

public class SalesWorker extends PermanentWorker {
    private int salesAmount;
    private double bonusRatio;

    public SalesWorker(String name, int salary, int salesAmount, double bonusRatio) {
        super(name, salary);
        this.salesAmount = salesAmount;
        this.bonusRatio = bonusRatio;
    }

    @Override
    public int getPay() {
        return super.getPay() + (int) (salesAmount * bonusRatio);
    }

    @Override
    public void showSalaryInfo(String name) {
        System.out.println("영업직 " + name + "의 급여: " + String.format("%,d", getPay()) + "원");
    }
}

