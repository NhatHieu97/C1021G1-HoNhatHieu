package Advanced_Programming_with_Java_2_1.ss6_Ke_thua.Bai_tap;

public class Cylinder extends CircleCylinder {
    public double heigth;

    public Cylinder(){
    }

    public Cylinder(double heigth) {
        this.heigth = heigth;
    }

    public Cylinder(double radius, String color, double heigth) {
        super(radius, color);
        this.heigth = heigth;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public double getVolume(){
        return Math.PI * getRadius() * getHeigth();
    }

    @Override
    public String toString() {
        return "Cylinder:" +
                "height= " + heigth +
                ", getVolume= " + getVolume() +
                "," + super.toString();
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(3.5, "blue", 6.3);
        System.out.println(cylinder);
    }
}

