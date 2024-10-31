package trythis;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MyScan {
		public static void main(String[] args) {
				Scanner scan = new Scanner(System.in);
				System.out.print("Name:");
				String name = scan.nextLine();
				System.out.print("Age:");
				int age = scan.nextInt();
				System.out.print("Addr:");
				String addr = scan.nextLine();
				System.out.print("Height:");
				float height = scan.nextFloat();

				System.out.printf("name is %s, addr is %s, age is %d years old, height is %f", name, addr, age, height);
		}
}
