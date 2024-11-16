package trythis.vote;

import java.math.BigDecimal;
import java.util.Random;

public class AreaDistrict {
    private String name;
    private BigDecimal rate; // 개표율
    private Random random; // 랜덤 객체

    public AreaDistrict(String name) {
        this.name = name;
        this.rate = BigDecimal.ZERO; // 초기 개표율은 0%
        this.random = new Random(); // 랜덤 객체 초기화
    }

    // 개표율 업데이트 메서드
    public void updateRate() {
        int increment = random.nextInt(5) + 1; // 1~5 사이의 임의의 증가율
        if (rate.compareTo(BigDecimal.valueOf(100)) < 0) { // 100% 미만일 때만 업데이트
            rate = rate.add(BigDecimal.valueOf(increment));
            if (rate.compareTo(BigDecimal.valueOf(100)) > 0) {
                rate = BigDecimal.valueOf(100); // 최대 100%로 제한
            }
            System.out.printf("%s 개표율: %.0f%% (개표 증가율: %d%%)%s\n",
                    name, rate, increment, "*".repeat(rate.intValue()));
        }
    }

    public BigDecimal getRate() {
        return rate;
    }
}

class DistrictThread extends Thread {
    private AreaDistrict district;

    public DistrictThread(AreaDistrict district) {
        this.district = district;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (district.getRate().compareTo(BigDecimal.valueOf(100)) < 0) { // 개표율이 100% 미만일 때 실행
            district.updateRate();
            try {
                Thread.sleep(random.nextInt(1000)); // 임의의 시간 동안 대기 (최대 1초)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {

        // 지역구 생성
        AreaDistrict[] districts = {
                new AreaDistrict("제1지역구"),
                new AreaDistrict("제2지역구"),
                new AreaDistrict("제3지역구")
        };

        // 각 지역구에 대해 쓰레드 생성 및 시작
        DistrictThread[] threads = new DistrictThread[districts.length];
        for (int i = 0; i < districts.length; i++) {
            threads[i] = new DistrictThread(districts[i]);
            threads[i].start();
        }

        // 모든 쓰레드가 종료될 때까지 대기
        for (DistrictThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("모든 지역구의 개표가 완료되었습니다.");
    }
}
