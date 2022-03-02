package Advanced_Programming_with_Java_2_1.ss6_Ke_thua.Bai_tap.ShapeTriangle;

import Advanced_Programming_with_Java_2_1.ss6_Ke_thua.Bai_tap.Shape1;

public class Triangle extends Shape1 {
    public String color = "blue";

    public Triangle(){}

    public Triangle(String color) {
        this.color = color;
    }

    public Triangle(double side1, double side2, double side3, String color) {
        super(side1, side2, side3);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + " color : " + color;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle);

        triangle = new Triangle("red");
        System.out.println(triangle);

        triangle = new Triangle(3.0, 4.0, 4.0, "yellow");
        System.out.println(triangle);
    }
}
