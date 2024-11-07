package trythis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
//p.

public class Student {
		private String name;
		private int id;
		private String phoneNo;

		public Student(StringTokenizer tokenizer) {
				//String[] tokens = new String[tokenizer.countTokens()];
				List<String> tokens = new ArrayList<>();
				while (tokenizer.hasMoreTokens()) {
						tokenizer.nextToken();
				}
				try {
						this.name = tokens.get(0);
						this.id = Integer.parseInt(tokens.get(1));
						this.phoneNo = tokens.get(2);
				} catch (IndexOutOfBoundsException ioe) {
						System.out.println(ioe.getMessage());
				}
		}

		public Student(String name, int id, String phoneNo) {
				this.name = name;
				this.id = id;
				this.phoneNo = phoneNo;
		}

		public static void main(String[] args) {
				Map<String, Student> map = new HashMap<>();
				MyScanner scanner = new MyScanner();
				System.out.println("이름, 아이디, 전화번호 순으로 입력하세요: \n");
				while (true) {
						StringTokenizer token = new StringTokenizer(scanner.next(""), " ");

						Student student = new Student(token);
						map.put(student.getName(), student);
						System.out.println(map);
				}
		}

		public String getName() {
				return name;
		}

		@Override
		public String toString() {
				return "%s(%d) : %s".formatted(name, id, phoneNo);
		}
}
