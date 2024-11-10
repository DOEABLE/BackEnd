package com.kimdohee.assignment.company;

import java.util.ArrayList;
import java.util.List;

public class ManagerService {
    private List<Worker> workers = new ArrayList<>();

    public ManagerService() {
        // 생성자에서 workers 리스트 초기화
    }

    // 직원 추가
    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    // 모든 직원의 급여 정보 출력
    public void showAllSalaryInfo() {
        for (Worker worker : workers) {
            worker.showSalaryInfo(worker.name);
        }
    }

    // 특정 이름의 직원 급여 정보 출력
    public void showSalaryInfo(String name) {
        for (Worker worker : workers) {
            if (worker.name.equals(name)) {
                worker.showSalaryInfo(name);
                return;
            }
        }
        System.out.println("해당 이름의 직원이 없습니다.");
    }

    // 총 급여 계산 및 출력
    public void showTotalSalary() {
        int totalSalary = 0;
        for (Worker worker : workers) {
            totalSalary += worker.getPay();
        }
        System.out.println("전체 직원의 총 급여: " + String.format("%,d", totalSalary) + "원");
    }

}

