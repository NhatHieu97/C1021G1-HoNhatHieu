package Advanced_Programming_with_Java_2_1.ss7_Abstract_Class_And_Interface.Thuc_hanh.IterfaceCompable;

import Advanced_Programming_with_Java_2_1.ss6_Ke_thua.Thuc_hanh.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {

    public ComparableCircle(){}

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String colors, boolean filled, double radius) {
        super(colors, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        return (int) (o.getRadius() - getRadius());
    }
}
