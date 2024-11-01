package com.hana.greetings;

import java.util.Scanner;

public class Hi {
		public static void main(String[] args) {
				studentsScore();
		}

		private static void studentsScore() {
				Scanner scan = new Scanner(System.in);
				System.out.println("학생 수를 입력하세요 :");
				int students = scan.nextInt();
				int[] scores = new int[students];

				for (int score : scores) {
						String grade;
						if (score >= 90) {
								grade = "A";
						} else if (score >= 80) {
								grade = "B";
						} else if (score >= 70) {
								grade = "C";
						} else if (score >= 60) {
								grade = "D";
						} else {
								grade = "F";
						}

						for (int i = 0; i < scores.length; i++) {
								System.out.println(i + "번 학생의 점수를 입력하세요");
								scores[i] = scan.nextInt();
						}

						System.out.println(students + "명의 학생 성적은 다음과 같습니다.");

						for (int i = 0; i < scores.length; i++) {
								System.out.println(i + "번 학생의 점수: " + scores[i]);
						}
						for (int s : scores) {
								System.out.println(scores[s] + "번 학생의 등급은" + grade + "입니다.");

						}
				}
		}
}
