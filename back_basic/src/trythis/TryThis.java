package trythis;

import trythis.comp.Employee;
import trythis.comp.InvoiceItem;
import trythis.shape.Circle;
import trythis.shape.Rectangle;

public class TryThis {
		public static void main(String[] args) {
				Circle circle1 = new Circle();
				Circle circle2 = new Circle(2);

				System.out.println("circle1 = " + circle1);
				System.out.println("circle2 = " + circle2);

				Rectangle rectangle = new Rectangle(2, 3);
				System.out.println("rectangle =" + rectangle);

				Employee emp1 = new Employee(1, "코난", 25000000);
				Employee emp2 = new Employee(1, "장미", 30000000);
				Employee emp3 = new Employee(1, "미란", 40000000);

				double dbl = 3.7;
				int inum = 5;

				System.out.println("inum = " + inum);
				System.out.println("dbl = " + inum);

				InvoiceItem invoiceItem = new InvoiceItem("item1", "pongpong", 5, 3000);
				System.out.println("invoiceItem = " + invoiceItem);

				//
				System.out.println("=======p.273 연습문제=======");
				
		}
}
