package com.kimdohee.assignment.company;


public abstract class Worker implements Employee {
    protected String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public abstract int getPay();

    @Override
    public abstract void showSalaryInfo(String name);
}
