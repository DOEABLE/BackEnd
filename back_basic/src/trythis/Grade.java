package trythis;

//todo exam p.289 school.School->강사님 코드 참조 p.320 연습문제

import java.util.ArrayList;
import java.util.List;

interface Comparable {

}

/**
 * MyScanner사용
 */
public class Grade {
		private final int id;
		private final String name;
		private int score;

		public Grade(int id, String name, int score) {
				this.id = id;
				this.name = name;
				this.score = score;
		}

		public static void main(String[] args) {
				List<Student> students = new ArrayList<>();
				MyScanner scanner = new MyScanner("학생정보를 입력합니다:");
				System.out.println("5명 이상의 학생 정보를 입력하세요. 학번에 'q'를 입력하면 입력을 종료합니다.");

				while (true) {
						System.out.printf("학번 입력:");
						String id = scanner.nextString();
						//String id = String.valueOf(scanner.nextInt());//todo 숫자를 받아 string으로 변환해주는 valueOf
						if (id.equalsIgnoreCase("q")) {
								if (students.size() >= 5) {
										break;
								} else {
										System.out.println("최소 5명의 학생정보를 입력해야 합니다.%n 계속 입력해주세요: ");
										continue;
								}
						}
				}

				// students.add(new Student(getId(), this.getName(), this.score));
				//
				// // 학번 기준 정렬 (기본 정렬)
				// students.sort(Comparator.comparing(Student::getId));
				//
				// // 람다 함수를 이용한 학생 정보 출력
				// Consumer<Student> printStudent = student ->
				// 		System.out.printf("이름: %s, 학번: %s, 점수: %d%n",
				// 				student.getName(), student.getId(), student.getScore());
				// List<Integer> scores = new ArrayList<>();
				// List<Integer> min = new ArrayList<>();
				// //min.add(Integer.MIN_VALUE);
				// min.add(100);
				// List<Integer> max = new ArrayList<>();
				// //max.add(Integer.MAX_VALUE);
				// max.add(0);
				// MyScanner myScan = new MyScanner();
				//
				// System.out.println("학생의 점수를 입력하세요: ");

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
				// scores.removeAll(min);
				// scores.removeAll(max);
				//
				// int sum = 0;
				// // Iterator<Integer> iterScores = scores.iterator();
				// int maxScore = 0;
				// for (int score : scores) {
				// 		sum += score;
				// 		if (score > maxScore) {
				// 				maxScore = score;
				// 		}
				// 		//System.out.printf("%d학생의 성적은 %d이며 등급은 %s입니다.%n", (i + 1), score, getGrade(score));
				// }
				// System.out.println("학생들의 성적: " + scores);
				// System.out.println("\n입력된 점수와 학점:");
				// for (int score : scores) {
				// 		String grade = getGrade(score);
				// 		System.out.println("점수: " + score + ", 학점: " + grade);
				// }
				//
				// myScan.nextClose();
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

		//Getter
		public int getId() {
				return id;
		}

		public String getName() {
				return name;
		}

		public int getScore() {
				return score;
		}

		@Override
		public String toString() {
				return "Grade{id=" + id + ", name='" + name + '\'' + ", score=" + score + '}';
		}
}
