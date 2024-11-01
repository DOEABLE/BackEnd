package trythis;

import java.util.Scanner;

/**
 * Date: 2024.11.01
 * Description: 학생인원, 각 인원의 점수에 따른 학점 계산
 */
public class StudentsGrade {//***grade 메소드로 분리하기

    public static void main(String[] args) {//studentsScore 매서드로 출력하라
        studentsScore();
    }

    private static void studentsScore() {
        Scanner scan = new Scanner(System.in);//1.학생수를 입력받음
        System.out.printf("학생수를 입력하세요: ");
        int student = scan.nextInt();
        int[] scores = new int[student];

        //2. 학생 수 만큼 점수를 배열로 입력받는다.
        for (int i = 0; i < scores.length; i++) {
            System.out.print(i + "번 학생의 점수를 입력하세요: ");
            int score = scan.nextInt();
            scores[i] = score;
        }

        System.out.println(student + "명의 학생 성적은 다음과 같습니다.");
        System.out.println();
        //3. for문을 사용해 점수의 길이만큼 학생의 점수와 학점을 출력해준다.
        for (int i = 0; i < scores.length; i++) {
            System.out.println(i + "번 학생의 점수: " + scores[i]);
            System.out.println("학점: " + grade(scores[i]));
        }

    }

    //학점 계산기 (args : 1. 학생점수, 등급을 넣을 변수선언 후 등급 return, else if문 이용하여 계산 return타입주의)
    public static String grade(int score) {
        String grade = null;
        if (score >= 90 && score <= 100) {
            grade = "A";
        } else if (score >= 80 && score <= 90) {
            grade = "B";
        } else if (score >= 70 && score <= 80) {
            grade = "B";
        } else if (score >= 60 && score <= 70) {
            grade = "B";
        } else if (score < 60 && score >= 0) {
            grade = "F";
        } else {
            System.out.println("점수는 0~100까지 입니다.");
        }
        return grade;
    }

}
