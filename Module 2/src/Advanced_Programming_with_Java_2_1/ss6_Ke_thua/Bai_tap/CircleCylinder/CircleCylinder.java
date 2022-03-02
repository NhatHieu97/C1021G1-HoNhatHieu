package Advanced_Programming_with_Java_2_1.ss6_Ke_thua.Bai_tap;

public class CircleCylinder {
    public double radius;
    public String color;

    public CircleCylinder(){
    }

    public CircleCylinder(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getPerimeter(){
        return 2 * getRadius() * Math.PI;
    }

    public double getArea(){
        return getRadius() * getRadius() * Math.PI;
    }

    @Override
    public String toString() {
        return "CircleCylinder:" +
                "radius= " + radius +
                ", color= " + color +
                ", getPerimeter= " + getPerimeter() +
                ", getArea= " + getArea();
    }

    public static void main(String[] args) {
        CircleCylinder circleCylinder = new CircleCylinder();
        System.out.println(circleCylinder);

        circleCylinder = new CircleCylinder(5 , "yellow");
        System.out.println(circleCylinder);

    }
}
