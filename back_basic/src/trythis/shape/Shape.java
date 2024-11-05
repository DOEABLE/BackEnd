package trythis.shape;

import java.math.BigDecimal;

abstract class Shape {
		public static void main(String[] args) {
				Shape[] shapes = {new Circle(5), new Rectangle(3, 4), new ColorCircle(1, "black")};

				double totalArea = 0;
				for (Shape shape : shapes) {
						totalArea += shape.calArea();
				}
				System.out.println("totalArea = " + totalArea);

				System.out.println();
				System.out.println(BigDecimal.valueOf(0.1).add(BigDecimal.valueOf(0.2)));
		}

		abstract double calArea();
}
