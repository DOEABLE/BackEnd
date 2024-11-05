package trythis.shape;

public class ResizableCircle extends Circle implements Resizable {
		public ResizableCircle(double radius) {
				super(radius); // 부모 클래스의 생성자 호출
		}

		public static void main(String[] args) {
				Circle circle1 = new Circle(2);
				System.out.println("Circle1 = " + circle1);
				ResizableCircle circle2 = new ResizableCircle(3);
				System.out.println("Circle2 = " + circle2);

				circle2.resize(10);
				System.out.println("circle2 = " + circle2);

				Resizable circle3 = Math.random() > 0.5 ? new ColorCircle(1, "red") : new ResizableCircle(2);

				Circle circle4 = Math.random() > 0.5 ? new Circle() : new ColorCircle(2, "blue");

				if (circle4 instanceof Resizable x) {
						x.resize(20);
						System.out.println("x = " + x);
				}

		}

		@Override
		public void resize(int percent) {
				setRadius(getRadius() + getRadius() * percent / 100);
		}

		@Override
		public String toString() {
				return "크기를 10퍼센트 크게 변경 후\nResizableCircle[Circle[radius=3.3]]의 둘레는 %.1f, 면적은 %.1f".formatted(getRadius(),
						getPerimeter(), getArea());
		}
}
