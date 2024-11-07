package trythis;

//todo exam p.289 school.School->강사님 코드 참조

import java.util.ArrayList;
import java.util.List;

/**
 * MyScanner사용해서
 */
public class Grade {

		public static void main(String[] args) {
				List<Integer> scores = new ArrayList<>();
				List<Integer> min = new ArrayList<>();
				//min.add(Integer.MIN_VALUE);
				min.add(100);
				List<Integer> max = new ArrayList<>();
				//max.add(Integer.MAX_VALUE);
				max.add(0);
				MyScanner myScan = new MyScanner();

				System.out.println("학생의 점수를 입력하세요: ");

				// while (true) {
				// 		System.out.print("점수 입력:");
				// 		//int score = myScan.nextInt();
				//
				// 		if (score < 0) {
				// 				break;
				// 		}
				// 		if (score < min.get(0)) {
				// 				min.add(score);
				// 		}
				// 		if (score < max.get(0)) {
				// 				max.add(score);
				// 		}
				// 		scores.add(score);
				// }
				scores.removeAll(min);
				scores.removeAll(max);

				int sum = 0;
				// Iterator<Integer> iterScores = scores.iterator();
				int maxScore = 0;
				for (int score : scores) {
						sum += score;
						if (score > maxScore) {
								maxScore = score;
						}
						//System.out.printf("%d학생의 성적은 %d이며 등급은 %s입니다.%n", (i + 1), score, getGrade(score));
				}
				System.out.println("학생들의 성적: " + scores);
				System.out.println("\n입력된 점수와 학점:");
				for (int score : scores) {
						String grade = getGrade(score);
						System.out.println("점수: " + score + ", 학점: " + grade);
				}

				myScan.nextClose();
		}

		private static String getGrade(Integer score) {
				if (score >= 90)
						return "A: GOAT";
				else if (score >= 80)
						return "B: 잘했어요";
				else if (score >= 70)
						return "C: 나쁘진 않군";
				else if (score >= 60)
						return "D: 좀 더 노력해";
				else if (score >= 0)
						return "F: 다음학기에 또 봐요~";
				else
						return "점수는 0부터 100사이여야 합니다.";
		}
}
