package trythis.shape;

public class Circle extends Shape implements GeomericObject {
    private double radius;

    public Circle() {
        this(5.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    protected void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {//GeromericObject내의 메서드를 반드시 구현해줘야 함.
        return Math.PI * this.radius * 2;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    double calArea() {
        return getArea();
    }

    public String toString() {
        return "Circle[radius=%s]의 둘레는 %f, 면적은 %.2f".formatted(this.radius, this.getPerimeter(), this.getArea());
    }
}
