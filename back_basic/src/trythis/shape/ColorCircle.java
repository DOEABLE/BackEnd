package trythis.shape;

public class ColorCircle extends ResizableCircle {
		private final String color;

		public ColorCircle(double radius, String color) {
				super(radius);
				this.color = color;
		}

		public String getColor() {
				return color;
		}

		@Override
		public String toString() {
				return "ColorCircle(%s)[radius=%s]의 둘레는 %f, 면적은 %.2f".formatted(getColor(), getRadius(), this.getPerimeter(),
						this.getArea());
		}
}
