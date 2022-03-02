package Advanced_Programming_with_Java_2_1.ss7_Abstract_Class_And_Interface.Thuc_hanh.IterfaceCompable;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ComparableCircle[] Circles = new ComparableCircle[3];
        Circles[0] = new ComparableCircle(3.6);
        Circles[1] = new ComparableCircle();
        Circles[2] = new ComparableCircle("blue", true, 5);
        System.out.println("Pre-sorted: ");
        for (ComparableCircle circle : Circles){
            System.out.println(circle);
        }
        System.out.println("--------------");
        Arrays.sort(Circles);

        for (ComparableCircle circle : Circles){
            System.out.println(circle);
        }


    }
}
