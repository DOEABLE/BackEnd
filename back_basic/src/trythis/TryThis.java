package trythis;

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

				Account account = new Account("k67", "jkj", 300);
		}
}
