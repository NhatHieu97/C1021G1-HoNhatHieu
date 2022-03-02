package Advanced_Programming_with_Java_2_1.ss5_Access_modifier_static_method_static_property.Bai_tap;

public class AccessModifier {
    private double radius = 1 ;
    private String color = "red";

    public AccessModifier(){
    }

    public AccessModifier(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return 3.14 * this.radius * this.radius;
    }

    public static void main(String[] args) {
        AccessModifier circle = new AccessModifier(2);
        System.out.println(circle.getArea());

    }
}
