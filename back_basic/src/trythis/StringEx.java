package trythis;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.StringTokenizer;

public class StringEx {
		public static void main(String[] args) {
				StringBuilder sb = new StringBuilder("This%n");
				System.out.println("sb.hashcode = " + sb.hashCode());
				sb.append("is a pencil");
				System.out.println("toString= " + sb.toString());
				sb.insert(3, "나야 들기름");
				sb.delete(8, 10);
				sb.replace(7, 9, "replace");
				sb.reverse();
				System.out.println("sb= 1234567".repeat(3));
				System.out.println("sb = " + sb.toString());
				System.out.printf("capa=%d, len=%d, (%d)%n", sb.capacity(), sb.length(), sb.capacity() - sb.length());
				//todo string 조작을 할 때 편리함.-> stringBuilder를 자주쓰고 builder를 buffer로 바꿔보기.hashmap도 더 많이 사용됨.
				//1
				String query = "name=conan&addr=ran's&age=10";
				StringTokenizer tokenizer = new StringTokenizer(query, "&=");
				while (tokenizer.hasMoreTokens()) {
						System.out.println(tokenizer.nextToken());
				}
				//2
				String dadakim = "장화/홍길동/홍련/콩쥐/팥쥐";
				StringTokenizer tokenizer1 = new StringTokenizer(dadakim, "/");
				try {
						String tmp;

						while ((tmp = tokenizer1.nextToken()) != null) {
								System.out.println("tmp= " + tmp);
						}
				} catch (NoSuchElementException e) {
						System.out.println(e.getMessage());
				}

				//1-5사이의 난수 생성
				Random r = new Random();
				for (int i = 0; i < 10; i++) {
						if (i < 7) {//7번까지는 같은 값을 줄래(1번 큐를 준다)
								r.setSeed(3333L);
						}
						System.out.print(r.nextInt(5) + 1);
				}
				//Date
				Date now = new Date();
				String strNow1 = now.toString();
				System.out.println();
				System.out.println(strNow1);

				SimpleDateFormat fmt = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초 -a%n");
				String strNow2 = now.toString();

				//p.265 calendar
				Calendar cal = Calendar.getInstance();  //new 안해줘도 되는 특징이 있음.
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				int date = cal.get(Calendar.DATE);

				System.out.printf("%d-%d-%d%n", year, month + 1, date);
				System.out.println(fmt.format(cal.getTime()));
				//todo thread로 LazyDate라는 걸 만들어 쓴다.
				cal.add(Calendar.DATE, -5);
				System.out.printf("%d-%d-%d%n", year, month + 1, date);

		}
}
