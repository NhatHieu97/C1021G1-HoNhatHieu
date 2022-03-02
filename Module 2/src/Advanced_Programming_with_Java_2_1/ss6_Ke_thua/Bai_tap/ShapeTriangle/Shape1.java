package Advanced_Programming_with_Java_2_1.ss6_Ke_thua.Bai_tap;

public class Shape1  {
    public double side1 = 1.0;
    public double side2 = 1.0;
    public double side3 = 1.0;

    public Shape1() {
    }

    public Shape1(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter() {
        return (side1 + side2 + side3) / 2;
    }

    public double getArea() {
        return Math.sqrt(getPerimeter() * (getPerimeter() - side1) *
                (getPerimeter() - side2) * (getPerimeter() - side3));
    }

    @Override
    public String toString() {
        return "side1 = " + side1 +
                ", side2 = " + side2 +
                ", side3 = " + side3 +
                ", diện tích là: " + getArea() +
                ", chu vi là: " + getPerimeter();
    }

    public static void main(String[] args) {
        Shape1 shape = new Shape1();
        System.out.println(shape);

        shape = new Shape1(7.0,8.0,9.0);
        System.out.println(shape);
    }
}
