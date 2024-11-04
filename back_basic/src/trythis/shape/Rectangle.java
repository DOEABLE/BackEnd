package trythis.shape;

public class Rectangle {

		private double length;
		private double width;

		public Rectangle() {
				this(1, 1);//이렇게 하면 인자있는 생성자에 접근할 수 있다.

				this.length = 1.0;//초기화
				this.width = 1.0;

		}

		public Rectangle(double length, double width) {
				this.length = length;
				this.width = width;
		}

		public double getLength() {
				return length;
		}

		public void setLength(double length) {
				this.length = length;
		}

		public double getWidth() {
				return width;
		}

		public void setWidth(double width) {
				this.width = width;
		}

		public double getArea() {
				return this.width * this.length;
		}

		public double getPerimeter() {
				return (this.length + this.width) * 2;

		}

		public String toString() {
				return "Rectangle[length=%s,width=%s]의 둘레는 %f, 면적은 %.2f".formatted(this.length, this.width, this.getPerimeter(),
						this.getArea());
		}

}
