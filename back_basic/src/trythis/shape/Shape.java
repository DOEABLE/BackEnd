package trythis.shape;

import java.math.BigDecimal;


abstract class Shape {
    public static void main(String[] args) {
        /**
         * Circle과 네모, ColorCircle을 배열에 받아 각각의 넓이의 출력과 그 면적의 합을 구하시오.
         */
        Shape[] shapes = {new Circle(1), new Rectangle(2, 3), new ColorCircle(2, "red")};
        BigDecimal totalArea = BigDecimal.ZERO;
        for (Shape shape : shapes) {
            System.out.println("Area: " + shape.calArea());
            totalArea = totalArea.add(BigDecimal.valueOf(shape.calArea()));
        }
        System.out.println("totalArea = " + totalArea);
        System.out.println("0.1+0.2 = " + (0.1 + 0.2));
        BigDecimal bd = BigDecimal.valueOf(0.1).add(BigDecimal.valueOf(0.2));
        System.out.println(bd);
    }

    abstract double calArea();
}
