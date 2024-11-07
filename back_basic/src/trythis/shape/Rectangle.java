package trythis.shape;

public class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle() {
        this(1, 1);//이렇게 하면 인자있는 생성자에 접근할 수 있다.
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
        return this.length * 2 + this.width * 2;

    }

    double calArea() {
        return getArea();
    }

    public String toString() {
        return "가로:%.1f, 세로:%.1f인 네모의 둘레는 %.1f, 넓이는:%.2f".formatted(getLength(), getWidth(), getPerimeter(), getArea());
    }

}
