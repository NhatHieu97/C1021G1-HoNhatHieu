package Advanced_Programming_with_Java_2_1.ss8_Clean_Code_And_Refactoring.Thuc_hanh.Codegym;

public class Cylinder {
    public static double getVolume(int radius, int height){
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }

    private static double getBaseArea(int radius) {
        double baseArea = Math.PI * radius * radius;
        return baseArea;
    }

    private static double getPerimeter(int radius) {
        return 2 * Math.PI  * radius;
    }

}
