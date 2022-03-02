package Advanced_Programming_with_Java_2_1.ss6_Ke_thua.Thuc_hanh;

import Advanced_Programming_with_Java_2_1.ss7_Abstract_Class_And_Interface.Bai_tap.Resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius = 1;

    public Circle(){
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(String colors, boolean filled, double radius) {
        super(colors, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPerimeter(){
        return 2 * getRadius() * Math.PI;
    }

    public double getArea(){
        return getRadius() * getRadius() * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius = "
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        setRadius(getRadius() + (percent/100));
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(5);
        System.out.println(circle);

        circle = new Circle("blue", true, 7.5);
        System.out.println(circle);


    }


}
