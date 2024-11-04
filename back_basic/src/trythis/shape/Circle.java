package trythis.shape;

public class Circle {
		private double radius;

		private String color = "red";

		public Circle() {
				this(1.0);
		}

		public Circle(double radius) {
				this.radius = radius;
				this.color = "red";
		}

		public double getRadius() {
				return radius;
		}

		public void setRadius(double radius) {
				this.radius = radius;
		}

		public double getArea() {
				return Math.PI * Math.pow(this.radius, 2);
		}

		public double getCircumference() {
				return Math.PI * this.radius * 2;
		}

		public String toString() {
				return "Circle[radius=%s]의 둘레는 %f, 면적은 %.2f".formatted(this.radius, this.getCircumference(), this.getArea());
		}
}
